package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaaa implements zaca {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20113a;

    /* renamed from: b  reason: collision with root package name */
    private final zabe f20114b;

    /* renamed from: c  reason: collision with root package name */
    private final Looper f20115c;

    /* renamed from: d  reason: collision with root package name */
    private final zabi f20116d;

    /* renamed from: e  reason: collision with root package name */
    private final zabi f20117e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f20118f;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Api.Client f20120h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Bundle f20121i;

    /* renamed from: m  reason: collision with root package name */
    private final Lock f20125m;

    /* renamed from: g  reason: collision with root package name */
    private final Set f20119g = Collections.newSetFromMap(new WeakHashMap());
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ConnectionResult f20122j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ConnectionResult f20123k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20124l = false;
    @GuardedBy("mLock")

    /* renamed from: n  reason: collision with root package name */
    private int f20126n = 0;

    private zaaa(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, @Nullable Api.Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f20113a = context;
        this.f20114b = zabeVar;
        this.f20125m = lock;
        this.f20115c = looper;
        this.f20120h = client;
        this.f20116d = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zax(this, null));
        this.f20117e = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaz(this, null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey anyClientKey : map2.keySet()) {
            arrayMap.put(anyClientKey, this.f20116d);
        }
        for (Api.AnyClientKey anyClientKey2 : map.keySet()) {
            arrayMap.put(anyClientKey2, this.f20117e);
        }
        this.f20118f = Collections.unmodifiableMap(arrayMap);
    }

    @GuardedBy("mLock")
    private final void a(ConnectionResult connectionResult) {
        int i4 = this.f20126n;
        if (i4 != 1) {
            if (i4 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f20126n = 0;
            }
            this.f20114b.zaa(connectionResult);
        }
        b();
        this.f20126n = 0;
    }

    @GuardedBy("mLock")
    private final void b() {
        for (SignInConnectionListener signInConnectionListener : this.f20119g) {
            signInConnectionListener.onComplete();
        }
        this.f20119g.clear();
    }

    @GuardedBy("mLock")
    private final boolean c() {
        ConnectionResult connectionResult = this.f20123k;
        if (connectionResult != null && connectionResult.getErrorCode() == 4) {
            return true;
        }
        return false;
    }

    private final boolean d(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.f20118f.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        return zabiVar.equals(this.f20117e);
    }

    private static boolean e(@Nullable ConnectionResult connectionResult) {
        if (connectionResult != null && connectionResult.isSuccess()) {
            return true;
        }
        return false;
    }

    public static zaaa g(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.AnyClientKey zab = api.zab();
            if (arrayMap.containsKey(zab)) {
                arrayMap3.put(api, (Boolean) map2.get(api));
            } else if (arrayMap2.containsKey(zab)) {
                arrayMap4.put(api, (Boolean) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            zat zatVar = (zat) arrayList.get(i4);
            if (arrayMap3.containsKey(zatVar.zaa)) {
                arrayList2.add(zatVar);
            } else if (arrayMap4.containsKey(zatVar.zaa)) {
                arrayList3.add(zatVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaaa(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void n(zaaa zaaaVar, int i4, boolean z3) {
        zaaaVar.f20114b.zac(i4, z3);
        zaaaVar.f20123k = null;
        zaaaVar.f20122j = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void o(zaaa zaaaVar, Bundle bundle) {
        Bundle bundle2 = zaaaVar.f20121i;
        if (bundle2 == null) {
            zaaaVar.f20121i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void p(zaaa zaaaVar) {
        ConnectionResult connectionResult;
        if (e(zaaaVar.f20122j)) {
            if (!e(zaaaVar.f20123k) && !zaaaVar.c()) {
                ConnectionResult connectionResult2 = zaaaVar.f20123k;
                if (connectionResult2 != null) {
                    if (zaaaVar.f20126n == 1) {
                        zaaaVar.b();
                        return;
                    }
                    zaaaVar.a(connectionResult2);
                    zaaaVar.f20116d.zar();
                    return;
                }
                return;
            }
            int i4 = zaaaVar.f20126n;
            if (i4 != 1) {
                if (i4 != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    zaaaVar.f20126n = 0;
                }
                ((zabe) Preconditions.checkNotNull(zaaaVar.f20114b)).zab(zaaaVar.f20121i);
            }
            zaaaVar.b();
            zaaaVar.f20126n = 0;
        } else if (zaaaVar.f20122j != null && e(zaaaVar.f20123k)) {
            zaaaVar.f20117e.zar();
            zaaaVar.a((ConnectionResult) Preconditions.checkNotNull(zaaaVar.f20122j));
        } else {
            ConnectionResult connectionResult3 = zaaaVar.f20122j;
            if (connectionResult3 != null && (connectionResult = zaaaVar.f20123k) != null) {
                if (zaaaVar.f20117e.f20230m < zaaaVar.f20116d.f20230m) {
                    connectionResult3 = connectionResult;
                }
                zaaaVar.a(connectionResult3);
            }
        }
    }

    @Nullable
    private final PendingIntent r() {
        if (this.f20120h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f20113a, System.identityHashCode(this.f20114b), this.f20120h.getSignInIntent(), com.google.android.gms.internal.base.zap.zaa | 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult zac(long j4, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult zad(@NonNull Api api) {
        if (Objects.equal(this.f20118f.get(api.zab()), this.f20117e)) {
            if (c()) {
                return new ConnectionResult(4, r());
            }
            return this.f20117e.zad(api);
        }
        return this.f20116d.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl zae(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (d(apiMethodImpl)) {
            if (c()) {
                apiMethodImpl.setFailedResult(new Status(4, (String) null, r()));
                return apiMethodImpl;
            }
            this.f20117e.zae(apiMethodImpl);
            return apiMethodImpl;
        }
        this.f20116d.zae(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl zaf(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (d(apiMethodImpl)) {
            if (c()) {
                apiMethodImpl.setFailedResult(new Status(4, (String) null, r()));
                return apiMethodImpl;
            }
            return this.f20117e.zaf(apiMethodImpl);
        }
        return this.f20116d.zaf(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void zaq() {
        this.f20126n = 2;
        this.f20124l = false;
        this.f20123k = null;
        this.f20122j = null;
        this.f20116d.zaq();
        this.f20117e.zaq();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void zar() {
        this.f20123k = null;
        this.f20122j = null;
        this.f20126n = 0;
        this.f20116d.zar();
        this.f20117e.zar();
        b();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f20117e.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f20116d.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void zat() {
        this.f20116d.zat();
        this.f20117e.zat();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
        this.f20125m.lock();
        try {
            boolean zax = zax();
            this.f20117e.zar();
            this.f20123k = new ConnectionResult(4);
            if (zax) {
                new com.google.android.gms.internal.base.zau(this.f20115c).post(new zav(this));
            } else {
                b();
            }
        } finally {
            this.f20125m.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r3.f20126n == 1) goto L12;
     */
    @Override // com.google.android.gms.common.api.internal.zaca
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zaw() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f20125m
            r0.lock()
            com.google.android.gms.common.api.internal.zabi r0 = r3.f20116d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.zaw()     // Catch: java.lang.Throwable -> L28
            r1 = 0
            if (r0 == 0) goto L22
            com.google.android.gms.common.api.internal.zabi r0 = r3.f20117e     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.zaw()     // Catch: java.lang.Throwable -> L28
            r2 = 1
            if (r0 != 0) goto L21
            boolean r0 = r3.c()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L21
            int r0 = r3.f20126n     // Catch: java.lang.Throwable -> L28
            if (r0 != r2) goto L22
        L21:
            r1 = 1
        L22:
            java.util.concurrent.locks.Lock r0 = r3.f20125m
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r3.f20125m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaaa.zaw():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        boolean z3;
        this.f20125m.lock();
        try {
            if (this.f20126n == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            return z3;
        } finally {
            this.f20125m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        this.f20125m.lock();
        try {
            if ((zax() || zaw()) && !this.f20117e.zaw()) {
                this.f20119g.add(signInConnectionListener);
                if (this.f20126n == 0) {
                    this.f20126n = 1;
                }
                this.f20123k = null;
                this.f20117e.zaq();
                return true;
            }
            this.f20125m.unlock();
            return false;
        } finally {
            this.f20125m.unlock();
        }
    }
}
