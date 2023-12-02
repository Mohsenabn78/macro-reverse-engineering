package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* renamed from: m  reason: collision with root package name */
    private static final Object f31515m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadFactory f31516n = new ThreadFactory() { // from class: com.google.firebase.installations.FirebaseInstallations.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f31529a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f31529a.getAndIncrement())));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f31517a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstallationServiceClient f31518b;

    /* renamed from: c  reason: collision with root package name */
    private final PersistedInstallation f31519c;

    /* renamed from: d  reason: collision with root package name */
    private final Utils f31520d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy<IidStore> f31521e;

    /* renamed from: f  reason: collision with root package name */
    private final RandomFidGenerator f31522f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f31523g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f31524h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f31525i;
    @GuardedBy("this")

    /* renamed from: j  reason: collision with root package name */
    private String f31526j;
    @GuardedBy("FirebaseInstallations.this")

    /* renamed from: k  reason: collision with root package name */
    private Set<FidListener> f31527k;
    @GuardedBy("lock")

    /* renamed from: l  reason: collision with root package name */
    private final List<StateListener> f31528l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.installations.FirebaseInstallations$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31532a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31533b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f31533b = iArr;
            try {
                iArr[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31533b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31533b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f31532a = iArr2;
            try {
                iArr2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31532a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public FirebaseInstallations(final FirebaseApp firebaseApp, @NonNull Provider<HeartBeatController> provider, @NonNull ExecutorService executorService, @NonNull Executor executor) {
        this(executorService, executor, firebaseApp, new FirebaseInstallationServiceClient(firebaseApp.getApplicationContext(), provider), new PersistedInstallation(firebaseApp), Utils.getInstance(), new Lazy(new Provider() { // from class: com.google.firebase.installations.d
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                IidStore y3;
                y3 = FirebaseInstallations.y(FirebaseApp.this);
                return y3;
            }
        }), new RandomFidGenerator());
    }

    private String A(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.f31517a.getName().equals("CHIME_ANDROID_SDK") && !this.f31517a.isDefaultApp()) || !persistedInstallationEntry.shouldAttemptMigration()) {
            return this.f31522f.createRandomFid();
        }
        String readIid = q().readIid();
        if (TextUtils.isEmpty(readIid)) {
            return this.f31522f.createRandomFid();
        }
        return readIid;
    }

    private PersistedInstallationEntry B(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        String str;
        if (persistedInstallationEntry.getFirebaseInstallationId() != null && persistedInstallationEntry.getFirebaseInstallationId().length() == 11) {
            str = q().readToken();
        } else {
            str = null;
        }
        InstallationResponse createFirebaseInstallation = this.f31518b.createFirebaseInstallation(n(), persistedInstallationEntry.getFirebaseInstallationId(), t(), o(), str);
        int i4 = AnonymousClass3.f31532a[createFirebaseInstallation.getResponseCode().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return persistedInstallationEntry.withFisError("BAD CONFIG");
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        return persistedInstallationEntry.withRegisteredFid(createFirebaseInstallation.getFid(), createFirebaseInstallation.getRefreshToken(), this.f31520d.currentTimeInSecs(), createFirebaseInstallation.getAuthToken().getToken(), createFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
    }

    private void C(Exception exc) {
        synchronized (this.f31523g) {
            Iterator<StateListener> it = this.f31528l.iterator();
            while (it.hasNext()) {
                if (it.next().onException(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void D(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f31523g) {
            Iterator<StateListener> it = this.f31528l.iterator();
            while (it.hasNext()) {
                if (it.next().a(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void E(String str) {
        this.f31526j = str;
    }

    private synchronized void F(PersistedInstallationEntry persistedInstallationEntry, PersistedInstallationEntry persistedInstallationEntry2) {
        if (this.f31527k.size() != 0 && !TextUtils.equals(persistedInstallationEntry.getFirebaseInstallationId(), persistedInstallationEntry2.getFirebaseInstallationId())) {
            for (FidListener fidListener : this.f31527k) {
                fidListener.onFidChanged(persistedInstallationEntry2.getFirebaseInstallationId());
            }
        }
    }

    private Task<InstallationTokenResult> g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        i(new GetAuthTokenListener(this.f31520d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private Task<String> h() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        i(new GetIdListener(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private void i(StateListener stateListener) {
        synchronized (this.f31523g) {
            this.f31528l.add(stateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Void j() throws FirebaseInstallationsException {
        E(null);
        PersistedInstallationEntry r4 = r();
        if (r4.isRegistered()) {
            this.f31518b.deleteFirebaseInstallation(n(), r4.getFirebaseInstallationId(), t(), r4.getRefreshToken());
        }
        u(r4.withNoGeneratedFid());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void v(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.r()
            boolean r1 = r0.isErrored()     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            if (r1 != 0) goto L22
            boolean r1 = r0.isUnregistered()     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            if (r1 == 0) goto L11
            goto L22
        L11:
            if (r3 != 0) goto L1d
            com.google.firebase.installations.Utils r3 = r2.f31520d     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            boolean r3 = r3.isAuthTokenExpired(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            return
        L1d:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.m(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
            goto L26
        L22:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.B(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L5f
        L26:
            r2.u(r3)
            r2.F(r0, r3)
            boolean r0 = r3.isRegistered()
            if (r0 == 0) goto L39
            java.lang.String r0 = r3.getFirebaseInstallationId()
            r2.E(r0)
        L39:
            boolean r0 = r3.isErrored()
            if (r0 == 0) goto L4a
            com.google.firebase.installations.FirebaseInstallationsException r3 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r3.<init>(r0)
            r2.C(r3)
            goto L5e
        L4a:
            boolean r0 = r3.isNotGenerated()
            if (r0 == 0) goto L5b
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            r2.C(r3)
            goto L5e
        L5b:
            r2.D(r3)
        L5e:
            return
        L5f:
            r3 = move-exception
            r2.C(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.v(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final void x(final boolean z3) {
        PersistedInstallationEntry s3 = s();
        if (z3) {
            s3 = s3.withClearedAuthToken();
        }
        D(s3);
        this.f31525i.execute(new Runnable() { // from class: com.google.firebase.installations.e
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.v(z3);
            }
        });
    }

    private PersistedInstallationEntry m(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult generateAuthToken = this.f31518b.generateAuthToken(n(), persistedInstallationEntry.getFirebaseInstallationId(), t(), persistedInstallationEntry.getRefreshToken());
        int i4 = AnonymousClass3.f31533b[generateAuthToken.getResponseCode().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    E(null);
                    return persistedInstallationEntry.withNoGeneratedFid();
                }
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
            }
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        return persistedInstallationEntry.withAuthToken(generateAuthToken.getToken(), generateAuthToken.getTokenExpirationTimestamp(), this.f31520d.currentTimeInSecs());
    }

    private synchronized String p() {
        return this.f31526j;
    }

    private IidStore q() {
        return this.f31521e.get();
    }

    private PersistedInstallationEntry r() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (f31515m) {
            CrossProcessLock a4 = CrossProcessLock.a(this.f31517a.getApplicationContext(), "generatefid.lock");
            readPersistedInstallationEntryValue = this.f31519c.readPersistedInstallationEntryValue();
            if (a4 != null) {
                a4.b();
            }
        }
        return readPersistedInstallationEntryValue;
    }

    private PersistedInstallationEntry s() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (f31515m) {
            CrossProcessLock a4 = CrossProcessLock.a(this.f31517a.getApplicationContext(), "generatefid.lock");
            readPersistedInstallationEntryValue = this.f31519c.readPersistedInstallationEntryValue();
            if (readPersistedInstallationEntryValue.isNotGenerated()) {
                readPersistedInstallationEntryValue = this.f31519c.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue.withUnregisteredFid(A(readPersistedInstallationEntryValue)));
            }
            if (a4 != null) {
                a4.b();
            }
        }
        return readPersistedInstallationEntryValue;
    }

    private void u(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (f31515m) {
            CrossProcessLock a4 = CrossProcessLock.a(this.f31517a.getApplicationContext(), "generatefid.lock");
            this.f31519c.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
            if (a4 != null) {
                a4.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        x(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IidStore y(FirebaseApp firebaseApp) {
        return new IidStore(firebaseApp);
    }

    private void z() {
        Preconditions.checkNotEmpty(o(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(n(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.b(o()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(Utils.a(n()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<Void> delete() {
        return Tasks.call(this.f31524h, new Callable() { // from class: com.google.firebase.installations.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void j4;
                j4 = FirebaseInstallations.this.j();
                return j4;
            }
        });
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<String> getId() {
        z();
        String p4 = p();
        if (p4 != null) {
            return Tasks.forResult(p4);
        }
        Task<String> h4 = h();
        this.f31524h.execute(new Runnable() { // from class: com.google.firebase.installations.c
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.w();
            }
        });
        return h4;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<InstallationTokenResult> getToken(final boolean z3) {
        z();
        Task<InstallationTokenResult> g4 = g();
        this.f31524h.execute(new Runnable() { // from class: com.google.firebase.installations.b
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.x(z3);
            }
        });
        return g4;
    }

    @Nullable
    String n() {
        return this.f31517a.getOptions().getApiKey();
    }

    @VisibleForTesting
    String o() {
        return this.f31517a.getOptions().getApplicationId();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public synchronized FidListenerHandle registerFidListener(@NonNull final FidListener fidListener) {
        this.f31527k.add(fidListener);
        return new FidListenerHandle() { // from class: com.google.firebase.installations.FirebaseInstallations.2
            @Override // com.google.firebase.installations.internal.FidListenerHandle
            public void unregister() {
                synchronized (FirebaseInstallations.this) {
                    FirebaseInstallations.this.f31527k.remove(fidListener);
                }
            }
        };
    }

    @Nullable
    String t() {
        return this.f31517a.getOptions().getProjectId();
    }

    @NonNull
    public static FirebaseInstallations getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.get(FirebaseInstallationsApi.class);
    }

    @SuppressLint({"ThreadPoolCreation"})
    FirebaseInstallations(ExecutorService executorService, Executor executor, FirebaseApp firebaseApp, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation, Utils utils, Lazy<IidStore> lazy, RandomFidGenerator randomFidGenerator) {
        this.f31523g = new Object();
        this.f31527k = new HashSet();
        this.f31528l = new ArrayList();
        this.f31517a = firebaseApp;
        this.f31518b = firebaseInstallationServiceClient;
        this.f31519c = persistedInstallation;
        this.f31520d = utils;
        this.f31521e = lazy;
        this.f31522f = randomFidGenerator;
        this.f31524h = executorService;
        this.f31525i = executor;
    }
}
