package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.RequestDeduplicator;
import com.google.firebase.iid.Store;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@Deprecated
/* loaded from: classes5.dex */
public class FirebaseInstanceId {

    /* renamed from: j  reason: collision with root package name */
    private static Store f31441j;
    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")

    /* renamed from: l  reason: collision with root package name */
    static ScheduledExecutorService f31443l;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Executor f31444a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f31445b;

    /* renamed from: c  reason: collision with root package name */
    private final Metadata f31446c;

    /* renamed from: d  reason: collision with root package name */
    private final GmsRpc f31447d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestDeduplicator f31448e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f31449f;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    private boolean f31450g;

    /* renamed from: h  reason: collision with root package name */
    private final List<FirebaseInstanceIdInternal.NewTokenListener> f31451h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f31440i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f31442k = Pattern.compile("\\AA[\\w-]{38}\\z");

    FirebaseInstanceId(FirebaseApp firebaseApp, Metadata metadata, Executor executor, Executor executor2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f31450g = false;
        this.f31451h = new ArrayList();
        if (Metadata.getDefaultSenderId(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f31441j == null) {
                    f31441j = new Store(firebaseApp.getApplicationContext());
                }
            }
            this.f31445b = firebaseApp;
            this.f31446c = metadata;
            this.f31447d = new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi);
            this.f31444a = executor2;
            this.f31448e = new RequestDeduplicator(executor);
            this.f31449f = firebaseInstallationsApi;
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    private <T> T b(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    w();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e4);
            }
        }
    }

    private static <T> T c(@NonNull Task<T> task) throws InterruptedException {
        Preconditions.checkNotNull(task, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(FirebaseInstanceId$$Lambda$1.f31455a, new OnCompleteListener(countDownLatch) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$2

            /* renamed from: a  reason: collision with root package name */
            private final CountDownLatch f31456a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31456a = countDownLatch;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task2) {
                this.f31456a.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        return (T) j(task);
    }

    @VisibleForTesting
    @KeepForSdk
    public static synchronized void clearInstancesForTest() {
        synchronized (FirebaseInstanceId.class) {
            ScheduledExecutorService scheduledExecutorService = f31443l;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            f31443l = null;
            f31441j = null;
        }
    }

    private static void e(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(p(firebaseApp.getOptions().getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(o(firebaseApp.getOptions().getApiKey()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private Task<InstanceIdResult> i(final String str, String str2) {
        final String v3 = v(str2);
        return Tasks.forResult(null).continueWithTask(this.f31444a, new Continuation(this, str, v3) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$0

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f31452a;

            /* renamed from: b  reason: collision with root package name */
            private final String f31453b;

            /* renamed from: c  reason: collision with root package name */
            private final String f31454c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31452a = this;
                this.f31453b = str;
                this.f31454c = v3;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task) {
                return this.f31452a.u(this.f31453b, this.f31454c, task);
            }
        });
    }

    private static <T> T j(@NonNull Task<T> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (!task.isCanceled()) {
            if (task.isComplete()) {
                throw new IllegalStateException(task.getException());
            }
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
        throw new CancellationException("Task is already canceled");
    }

    private String k() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.f31445b.getName())) {
            return "";
        }
        return this.f31445b.getPersistenceKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        if (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return false;
    }

    static boolean o(@Nonnull String str) {
        return f31442k.matcher(str).matches();
    }

    static boolean p(@Nonnull String str) {
        return str.contains(":");
    }

    private static String v(String str) {
        if (!str.isEmpty() && !str.equalsIgnoreCase("fcm") && !str.equalsIgnoreCase(Constants.MessageTypes.MESSAGE)) {
            return str;
        }
        return "*";
    }

    private void z() {
        if (B(l())) {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void A(long j4) {
        f(new SyncTask(this, Math.min(Math.max(30L, j4 + j4), f31440i)), j4);
        this.f31450g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B(@Nullable Store.Token token) {
        if (token != null && !token.c(this.f31446c.getAppVersionCode())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FirebaseInstanceIdInternal.NewTokenListener newTokenListener) {
        this.f31451h.add(newTokenListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() throws IOException {
        return getToken(Metadata.getDefaultSenderId(this.f31445b), "*");
    }

    @WorkerThread
    @Deprecated
    public void deleteInstanceId() throws IOException {
        e(this.f31445b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            b(this.f31449f.delete());
            w();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @WorkerThread
    @Deprecated
    public void deleteToken(@NonNull String str, @NonNull String str2) throws IOException {
        e(this.f31445b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String v3 = v(str2);
            b(this.f31447d.deleteToken(h(), str, v3));
            f31441j.e(k(), str, v3);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Runnable runnable, long j4) {
        synchronized (FirebaseInstanceId.class) {
            if (f31443l == null) {
                f31443l = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            f31443l.schedule(runnable, j4, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseApp g() {
        return this.f31445b;
    }

    public long getCreationTime() {
        return f31441j.f(this.f31445b.getPersistenceKey());
    }

    @NonNull
    @WorkerThread
    @Deprecated
    public String getId() {
        e(this.f31445b);
        z();
        return h();
    }

    @NonNull
    @Deprecated
    public Task<InstanceIdResult> getInstanceId() {
        e(this.f31445b);
        return i(Metadata.getDefaultSenderId(this.f31445b), "*");
    }

    @Nullable
    @Deprecated
    public String getToken() {
        e(this.f31445b);
        Store.Token l4 = l();
        if (B(l4)) {
            y();
        }
        return Store.Token.b(l4);
    }

    String h() {
        try {
            f31441j.k(this.f31445b.getPersistenceKey());
            return (String) c(this.f31449f.getId());
        } catch (InterruptedException e4) {
            throw new IllegalStateException(e4);
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public boolean isFcmAutoInitEnabled() {
        throw new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
    }

    @VisibleForTesting
    public boolean isGmsCorePresent() {
        return this.f31446c.isGmscorePresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Store.Token l() {
        return m(Metadata.getDefaultSenderId(this.f31445b), "*");
    }

    @Nullable
    @VisibleForTesting
    Store.Token m(String str, String str2) {
        return f31441j.h(k(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task r(String str, String str2, String str3, String str4) throws Exception {
        f31441j.j(k(), str, str2, str4, this.f31446c.getAppVersionCode());
        return Tasks.forResult(new InstanceIdResultImpl(str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void s(Store.Token token, InstanceIdResult instanceIdResult) {
        String token2 = instanceIdResult.getToken();
        if (token == null || !token2.equals(token.f31498a)) {
            for (FirebaseInstanceIdInternal.NewTokenListener newTokenListener : this.f31451h) {
                newTokenListener.onNewToken(token2);
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void setFcmAutoInitEnabled(boolean z3) {
        throw new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task t(final String str, final String str2, final String str3, final Store.Token token) {
        return this.f31447d.getToken(str, str2, str3).onSuccessTask(this.f31444a, new SuccessContinuation(this, str2, str3, str) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$4

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f31462a;

            /* renamed from: b  reason: collision with root package name */
            private final String f31463b;

            /* renamed from: c  reason: collision with root package name */
            private final String f31464c;

            /* renamed from: d  reason: collision with root package name */
            private final String f31465d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31462a = this;
                this.f31463b = str2;
                this.f31464c = str3;
                this.f31465d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task then(Object obj) {
                return this.f31462a.r(this.f31463b, this.f31464c, this.f31465d, (String) obj);
            }
        }).addOnSuccessListener(FirebaseInstanceId$$Lambda$5.f31466a, new OnSuccessListener(this, token) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$6

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f31467a;

            /* renamed from: b  reason: collision with root package name */
            private final Store.Token f31468b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31467a = this;
                this.f31468b = token;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.f31467a.s(this.f31468b, (InstanceIdResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task u(final String str, final String str2, Task task) throws Exception {
        final String h4 = h();
        final Store.Token m4 = m(str, str2);
        if (!B(m4)) {
            return Tasks.forResult(new InstanceIdResultImpl(h4, m4.f31498a));
        }
        return this.f31448e.a(str, str2, new RequestDeduplicator.GetTokenRequest(this, h4, str, str2, m4) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$3

            /* renamed from: a  reason: collision with root package name */
            private final FirebaseInstanceId f31457a;

            /* renamed from: b  reason: collision with root package name */
            private final String f31458b;

            /* renamed from: c  reason: collision with root package name */
            private final String f31459c;

            /* renamed from: d  reason: collision with root package name */
            private final String f31460d;

            /* renamed from: e  reason: collision with root package name */
            private final Store.Token f31461e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f31457a = this;
                this.f31458b = h4;
                this.f31459c = str;
                this.f31460d = str2;
                this.f31461e = m4;
            }

            @Override // com.google.firebase.iid.RequestDeduplicator.GetTokenRequest
            public Task start() {
                return this.f31457a.t(this.f31458b, this.f31459c, this.f31460d, this.f31461e);
            }
        });
    }

    synchronized void w() {
        f31441j.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void x(boolean z3) {
        this.f31450g = z3;
    }

    synchronized void y() {
        if (!this.f31450g) {
            A(0L);
        }
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        e(firebaseApp);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
        Preconditions.checkNotNull(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    @Nullable
    @WorkerThread
    @Deprecated
    public String getToken(@NonNull String str, @NonNull String str2) throws IOException {
        e(this.f31445b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) b(i(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new Metadata(firebaseApp.getApplicationContext()), FirebaseIidExecutors.b(), FirebaseIidExecutors.b(), provider, provider2, firebaseInstallationsApi);
    }
}
