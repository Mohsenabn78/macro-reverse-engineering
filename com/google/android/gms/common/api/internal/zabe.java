package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabe extends GoogleApiClient implements zabz {

    /* renamed from: b  reason: collision with root package name */
    private final Lock f20192b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.internal.zak f20193c;

    /* renamed from: e  reason: collision with root package name */
    private final int f20195e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f20196f;

    /* renamed from: g  reason: collision with root package name */
    private final Looper f20197g;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f20199i;

    /* renamed from: j  reason: collision with root package name */
    private long f20200j;

    /* renamed from: k  reason: collision with root package name */
    private long f20201k;

    /* renamed from: l  reason: collision with root package name */
    private final zabc f20202l;

    /* renamed from: m  reason: collision with root package name */
    private final GoogleApiAvailability f20203m;
    @Nullable
    @VisibleForTesting

    /* renamed from: n  reason: collision with root package name */
    zabx f20204n;

    /* renamed from: o  reason: collision with root package name */
    final Map f20205o;

    /* renamed from: p  reason: collision with root package name */
    Set f20206p;

    /* renamed from: q  reason: collision with root package name */
    final ClientSettings f20207q;

    /* renamed from: r  reason: collision with root package name */
    final Map f20208r;

    /* renamed from: s  reason: collision with root package name */
    final Api.AbstractClientBuilder f20209s;

    /* renamed from: t  reason: collision with root package name */
    private final ListenerHolders f20210t;

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList f20211u;

    /* renamed from: v  reason: collision with root package name */
    private Integer f20212v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    Set f20213w;

    /* renamed from: x  reason: collision with root package name */
    final zadc f20214x;

    /* renamed from: y  reason: collision with root package name */
    private final com.google.android.gms.common.internal.zaj f20215y;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private zaca f20194d = null;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    final Queue f20198h = new LinkedList();

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i4, int i5, ArrayList arrayList) {
        this.f20200j = true != ClientLibraryUtils.isPackageSide() ? 120000L : 10000L;
        this.f20201k = 5000L;
        this.f20206p = new HashSet();
        this.f20210t = new ListenerHolders();
        this.f20212v = null;
        this.f20213w = null;
        zaay zaayVar = new zaay(this);
        this.f20215y = zaayVar;
        this.f20196f = context;
        this.f20192b = lock;
        this.f20193c = new com.google.android.gms.common.internal.zak(looper, zaayVar);
        this.f20197g = looper;
        this.f20202l = new zabc(this, looper);
        this.f20203m = googleApiAvailability;
        this.f20195e = i4;
        if (i4 >= 0) {
            this.f20212v = Integer.valueOf(i5);
        }
        this.f20208r = map;
        this.f20205o = map2;
        this.f20211u = arrayList;
        this.f20214x = new zadc();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f20193c.zaf((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f20193c.zag((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.f20207q = clientSettings;
        this.f20209s = abstractClientBuilder;
    }

    static String d(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return "UNKNOWN";
                }
                return "SIGN_IN_MODE_NONE";
            }
            return "SIGN_IN_MODE_OPTIONAL";
        }
        return "SIGN_IN_MODE_REQUIRED";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void f(zabe zabeVar) {
        zabeVar.f20192b.lock();
        try {
            if (zabeVar.f20199i) {
                zabeVar.k();
            }
        } finally {
            zabeVar.f20192b.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void g(zabe zabeVar) {
        zabeVar.f20192b.lock();
        try {
            if (zabeVar.h()) {
                zabeVar.k();
            }
        } finally {
            zabeVar.f20192b.unlock();
        }
    }

    private final void i(int i4) {
        Integer num = this.f20212v;
        if (num == null) {
            this.f20212v = Integer.valueOf(i4);
        } else if (num.intValue() != i4) {
            String d4 = d(this.f20212v.intValue());
            throw new IllegalStateException("Cannot use sign-in mode: " + d(i4) + ". Mode was already set to " + d4);
        }
        if (this.f20194d != null) {
            return;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (Api.Client client : this.f20205o.values()) {
            z3 |= client.requiresSignIn();
            z4 |= client.providesSignIn();
        }
        int intValue = this.f20212v.intValue();
        if (intValue != 1) {
            if (intValue == 2 && z3) {
                this.f20194d = zaaa.g(this.f20196f, this, this.f20192b, this.f20197g, this.f20203m, this.f20205o, this.f20207q, this.f20208r, this.f20209s, this.f20211u);
                return;
            }
        } else if (z3) {
            if (z4) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        }
        this.f20194d = new zabi(this.f20196f, this, this.f20192b, this.f20197g, this.f20203m, this.f20205o, this.f20207q, this.f20208r, this.f20209s, this.f20211u, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z3) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new zabb(this, statusPendingResult, z3, googleApiClient));
    }

    @GuardedBy("mLock")
    private final void k() {
        this.f20193c.zab();
        ((zaca) Preconditions.checkNotNull(this.f20194d)).zaq();
    }

    public static int zad(Iterable iterable, boolean z3) {
        Iterator it = iterable.iterator();
        boolean z4 = false;
        boolean z5 = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            z4 |= client.requiresSignIn();
            z5 |= client.providesSignIn();
        }
        if (z4) {
            if (z5 && z3) {
                return 2;
            }
            return 1;
        }
        return 3;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final ConnectionResult blockingConnect() {
        boolean z3 = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f20192b.lock();
        try {
            if (this.f20195e >= 0) {
                if (this.f20212v == null) {
                    z3 = false;
                }
                Preconditions.checkState(z3, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f20212v;
                if (num == null) {
                    this.f20212v = Integer.valueOf(zad(this.f20205o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            i(((Integer) Preconditions.checkNotNull(this.f20212v)).intValue());
            this.f20193c.zab();
            return ((zaca) Preconditions.checkNotNull(this.f20194d)).zab();
        } finally {
            this.f20192b.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.f20212v;
        boolean z3 = true;
        if (num != null && num.intValue() == 2) {
            z3 = false;
        }
        Preconditions.checkState(z3, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.f20205o.containsKey(Common.CLIENT_KEY)) {
            j(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zaaz zaazVar = new zaaz(this, atomicReference, statusPendingResult);
            zaba zabaVar = new zaba(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.f20196f);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(zaazVar);
            builder.addOnConnectionFailedListener(zabaVar);
            builder.setHandler(this.f20202l);
            GoogleApiClient build = builder.build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        this.f20192b.lock();
        try {
            int i4 = 2;
            boolean z3 = false;
            if (this.f20195e >= 0) {
                Preconditions.checkState(this.f20212v != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f20212v;
                if (num == null) {
                    this.f20212v = Integer.valueOf(zad(this.f20205o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.f20212v)).intValue();
            this.f20192b.lock();
            if (intValue == 3 || intValue == 1) {
                i4 = intValue;
            } else if (intValue != 2) {
                i4 = intValue;
                Preconditions.checkArgument(z3, "Illegal sign-in mode: " + i4);
                i(i4);
                k();
                this.f20192b.unlock();
            }
            z3 = true;
            Preconditions.checkArgument(z3, "Illegal sign-in mode: " + i4);
            i(i4);
            k();
            this.f20192b.unlock();
        } finally {
            this.f20192b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        Lock lock;
        this.f20192b.lock();
        try {
            this.f20214x.zab();
            zaca zacaVar = this.f20194d;
            if (zacaVar != null) {
                zacaVar.zar();
            }
            this.f20210t.zab();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.f20198h) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            this.f20198h.clear();
            if (this.f20194d == null) {
                lock = this.f20192b;
            } else {
                h();
                this.f20193c.zaa();
                lock = this.f20192b;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f20192b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f20196f);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f20199i);
        printWriter.append(" mWorkQueue.size()=").print(this.f20198h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f20214x.f20306a.size());
        zaca zacaVar = this.f20194d;
        if (zacaVar != null) {
            zacaVar.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t3) {
        String str;
        Lock lock;
        Api<?> api = t3.getApi();
        boolean containsKey = this.f20205o.containsKey(t3.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        Preconditions.checkArgument(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.f20192b.lock();
        try {
            zaca zacaVar = this.f20194d;
            if (zacaVar == null) {
                this.f20198h.add(t3);
                lock = this.f20192b;
            } else {
                t3 = (T) zacaVar.zae(t3);
                lock = this.f20192b;
            }
            lock.unlock();
            return t3;
        } catch (Throwable th) {
            this.f20192b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @ResultIgnorabilityUnspecified
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t3) {
        String str;
        Lock lock;
        Api<?> api = t3.getApi();
        boolean containsKey = this.f20205o.containsKey(t3.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        Preconditions.checkArgument(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.f20192b.lock();
        try {
            zaca zacaVar = this.f20194d;
            if (zacaVar != null) {
                if (this.f20199i) {
                    this.f20198h.add(t3);
                    while (!this.f20198h.isEmpty()) {
                        BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl) this.f20198h.remove();
                        this.f20214x.a(apiMethodImpl);
                        apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    lock = this.f20192b;
                } else {
                    t3 = (T) zacaVar.zaf(t3);
                    lock = this.f20192b;
                }
                lock.unlock();
                return t3;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th) {
            this.f20192b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        C c4 = (C) this.f20205o.get(anyClientKey);
        Preconditions.checkNotNull(c4, "Appropriate Api was not requested.");
        return c4;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        Lock lock;
        this.f20192b.lock();
        try {
            if (!isConnected() && !this.f20199i) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (this.f20205o.containsKey(api.zab())) {
                ConnectionResult zad = ((zaca) Preconditions.checkNotNull(this.f20194d)).zad(api);
                if (zad == null) {
                    if (this.f20199i) {
                        connectionResult = ConnectionResult.RESULT_SUCCESS;
                        lock = this.f20192b;
                    } else {
                        Log.w("GoogleApiClientImpl", c());
                        String zad2 = api.zad();
                        Log.wtf("GoogleApiClientImpl", zad2 + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                        connectionResult = new ConnectionResult(8, null);
                        lock = this.f20192b;
                    }
                    lock.unlock();
                    return connectionResult;
                }
                return zad;
            }
            String zad3 = api.zad();
            throw new IllegalArgumentException(zad3 + " was never registered with GoogleApiClient");
        } finally {
            this.f20192b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.f20196f;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.f20197g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ResultIgnorabilityUnspecified
    @GuardedBy("mLock")
    public final boolean h() {
        if (!this.f20199i) {
            return false;
        }
        this.f20199i = false;
        this.f20202l.removeMessages(2);
        this.f20202l.removeMessages(1);
        zabx zabxVar = this.f20204n;
        if (zabxVar != null) {
            zabxVar.zab();
            this.f20204n = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(@NonNull Api<?> api) {
        return this.f20205o.containsKey(api.zab());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.Client client;
        if (!isConnected() || (client = (Api.Client) this.f20205o.get(api.zab())) == null || !client.isConnected()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        zaca zacaVar = this.f20194d;
        if (zacaVar != null && zacaVar.zaw()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        zaca zacaVar = this.f20194d;
        if (zacaVar != null && zacaVar.zax()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f20193c.zaj(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f20193c.zak(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zacaVar = this.f20194d;
        if (zacaVar != null && zacaVar.zay(signInConnectionListener)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        zaca zacaVar = this.f20194d;
        if (zacaVar != null) {
            zacaVar.zau();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f20193c.zaf(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f20193c.zag(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(@NonNull L l4) {
        this.f20192b.lock();
        try {
            return this.f20210t.zaa(l4, this.f20197g, "NO_TYPE");
        } finally {
            this.f20192b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.f20195e >= 0) {
            zak.zaa(lifecycleActivity).zae(this.f20195e);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f20193c.zah(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f20193c.zai(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("mLock")
    public final void zaa(ConnectionResult connectionResult) {
        if (!this.f20203m.isPlayServicesPossiblyUpdating(this.f20196f, connectionResult.getErrorCode())) {
            h();
        }
        if (!this.f20199i) {
            this.f20193c.zac(connectionResult);
            this.f20193c.zaa();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("mLock")
    public final void zab(@Nullable Bundle bundle) {
        while (!this.f20198h.isEmpty()) {
            execute((BaseImplementation.ApiMethodImpl) this.f20198h.remove());
        }
        this.f20193c.zad(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("mLock")
    public final void zac(int i4, boolean z3) {
        if (i4 == 1) {
            if (!z3 && !this.f20199i) {
                this.f20199i = true;
                if (this.f20204n == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.f20204n = this.f20203m.zac(this.f20196f.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabcVar = this.f20202l;
                zabcVar.sendMessageDelayed(zabcVar.obtainMessage(1), this.f20200j);
                zabc zabcVar2 = this.f20202l;
                zabcVar2.sendMessageDelayed(zabcVar2.obtainMessage(2), this.f20201k);
            }
            i4 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f20214x.f20306a.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zadc.zaa);
        }
        this.f20193c.zae(i4);
        this.f20193c.zaa();
        if (i4 == 2) {
            k();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zao(zada zadaVar) {
        this.f20192b.lock();
        try {
            if (this.f20213w == null) {
                this.f20213w = new HashSet();
            }
            this.f20213w.add(zadaVar);
        } finally {
            this.f20192b.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r3 == false) goto L17;
     */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zap(com.google.android.gms.common.api.internal.zada r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f20192b
            r0.lock()
            java.util.Set r0 = r2.f20213w     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L16
            java.lang.String r3 = "Attempted to remove pending transform when no transforms are registered."
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Throwable -> L57
            r0.<init>()     // Catch: java.lang.Throwable -> L57
            android.util.Log.wtf(r1, r3, r0)     // Catch: java.lang.Throwable -> L57
            goto L4a
        L16:
            boolean r3 = r0.remove(r3)     // Catch: java.lang.Throwable -> L57
            if (r3 != 0) goto L27
            java.lang.String r3 = "Failed to remove pending transform - this may lead to memory leaks!"
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Throwable -> L57
            r0.<init>()     // Catch: java.lang.Throwable -> L57
            android.util.Log.wtf(r1, r3, r0)     // Catch: java.lang.Throwable -> L57
            goto L4a
        L27:
            java.util.concurrent.locks.Lock r3 = r2.f20192b     // Catch: java.lang.Throwable -> L57
            r3.lock()     // Catch: java.lang.Throwable -> L57
            java.util.Set r3 = r2.f20213w     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L36
            java.util.concurrent.locks.Lock r3 = r2.f20192b     // Catch: java.lang.Throwable -> L57
            r3.unlock()     // Catch: java.lang.Throwable -> L57
            goto L43
        L36:
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L50
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.f20192b     // Catch: java.lang.Throwable -> L57
            r0.unlock()     // Catch: java.lang.Throwable -> L57
            if (r3 != 0) goto L4a
        L43:
            com.google.android.gms.common.api.internal.zaca r3 = r2.f20194d     // Catch: java.lang.Throwable -> L57
            if (r3 == 0) goto L4a
            r3.zat()     // Catch: java.lang.Throwable -> L57
        L4a:
            java.util.concurrent.locks.Lock r3 = r2.f20192b
            r3.unlock()
            return
        L50:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f20192b     // Catch: java.lang.Throwable -> L57
            r0.unlock()     // Catch: java.lang.Throwable -> L57
            throw r3     // Catch: java.lang.Throwable -> L57
        L57:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f20192b
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.zap(com.google.android.gms.common.api.internal.zada):void");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j4, @NonNull TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.f20192b.lock();
        try {
            Integer num = this.f20212v;
            if (num == null) {
                this.f20212v = Integer.valueOf(zad(this.f20205o.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            i(((Integer) Preconditions.checkNotNull(this.f20212v)).intValue());
            this.f20193c.zab();
            return ((zaca) Preconditions.checkNotNull(this.f20194d)).zac(j4, timeUnit);
        } finally {
            this.f20192b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i4) {
        this.f20192b.lock();
        boolean z3 = true;
        if (i4 != 3 && i4 != 1) {
            if (i4 == 2) {
                i4 = 2;
            } else {
                z3 = false;
            }
        }
        try {
            Preconditions.checkArgument(z3, "Illegal sign-in mode: " + i4);
            i(i4);
            k();
        } finally {
            this.f20192b.unlock();
        }
    }
}
