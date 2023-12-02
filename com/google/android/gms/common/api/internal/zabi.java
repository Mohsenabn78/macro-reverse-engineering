package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabi implements zaca, zau {

    /* renamed from: a  reason: collision with root package name */
    private final Lock f20218a;

    /* renamed from: b  reason: collision with root package name */
    private final Condition f20219b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f20220c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleApiAvailabilityLight f20221d;

    /* renamed from: e  reason: collision with root package name */
    private final zabh f20222e;

    /* renamed from: f  reason: collision with root package name */
    final Map f20223f;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    final ClientSettings f20225h;

    /* renamed from: i  reason: collision with root package name */
    final Map f20226i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    final Api.AbstractClientBuilder f20227j;
    @NotOnlyInitialized

    /* renamed from: k  reason: collision with root package name */
    private volatile zabf f20228k;

    /* renamed from: m  reason: collision with root package name */
    int f20230m;

    /* renamed from: n  reason: collision with root package name */
    final zabe f20231n;

    /* renamed from: o  reason: collision with root package name */
    final zabz f20232o;

    /* renamed from: g  reason: collision with root package name */
    final Map f20224g = new HashMap();
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ConnectionResult f20229l = null;

    public zabi(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, @Nullable ClientSettings clientSettings, Map map2, @Nullable Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList, zabz zabzVar) {
        this.f20220c = context;
        this.f20218a = lock;
        this.f20221d = googleApiAvailabilityLight;
        this.f20223f = map;
        this.f20225h = clientSettings;
        this.f20226i = map2;
        this.f20227j = abstractClientBuilder;
        this.f20231n = zabeVar;
        this.f20232o = zabzVar;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((zat) arrayList.get(i4)).zaa(this);
        }
        this.f20222e = new zabh(this, looper);
        this.f20219b = lock.newCondition();
        this.f20228k = new zaax(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.f20218a.lock();
        try {
            this.f20231n.h();
            this.f20228k = new zaaj(this);
            this.f20228k.zad();
            this.f20219b.signalAll();
        } finally {
            this.f20218a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.f20218a.lock();
        try {
            this.f20228k = new zaaw(this, this.f20225h, this.f20226i, this.f20221d, this.f20227j, this.f20218a, this.f20220c);
            this.f20228k.zad();
            this.f20219b.signalAll();
        } finally {
            this.f20218a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(@Nullable ConnectionResult connectionResult) {
        this.f20218a.lock();
        try {
            this.f20229l = connectionResult;
            this.f20228k = new zaax(this);
            this.f20228k.zad();
            this.f20219b.signalAll();
        } finally {
            this.f20218a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(zabg zabgVar) {
        this.f20222e.sendMessage(this.f20222e.obtainMessage(1, zabgVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(RuntimeException runtimeException) {
        this.f20222e.sendMessage(this.f20222e.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        this.f20218a.lock();
        try {
            this.f20228k.zag(bundle);
        } finally {
            this.f20218a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        this.f20218a.lock();
        try {
            this.f20228k.zai(i4);
        } finally {
            this.f20218a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(@NonNull ConnectionResult connectionResult, @NonNull Api api, boolean z3) {
        this.f20218a.lock();
        try {
            this.f20228k.zah(connectionResult, api, z3);
        } finally {
            this.f20218a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult zab() {
        zaq();
        while (this.f20228k instanceof zaaw) {
            try {
                this.f20219b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.f20228k instanceof zaaj) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f20229l;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult zac(long j4, TimeUnit timeUnit) {
        zaq();
        long nanos = timeUnit.toNanos(j4);
        while (this.f20228k instanceof zaaw) {
            if (nanos <= 0) {
                zar();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f20219b.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (this.f20228k instanceof zaaj) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f20229l;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult zad(@NonNull Api api) {
        Api.AnyClientKey zab = api.zab();
        if (this.f20223f.containsKey(zab)) {
            if (((Api.Client) this.f20223f.get(zab)).isConnected()) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            if (this.f20224g.containsKey(zab)) {
                return (ConnectionResult) this.f20224g.get(zab);
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl zae(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.f20228k.zaa(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl zaf(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        return this.f20228k.zab(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void zaq() {
        this.f20228k.zae();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void zar() {
        if (this.f20228k.zaj()) {
            this.f20224g.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("mState=").println(this.f20228k);
        for (Api api : this.f20226i.keySet()) {
            String valueOf = String.valueOf(str);
            printWriter.append((CharSequence) str).append((CharSequence) api.zad()).println(":");
            ((Api.Client) Preconditions.checkNotNull((Api.Client) this.f20223f.get(api.zab()))).dump(valueOf.concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void zat() {
        if (this.f20228k instanceof zaaj) {
            ((zaaj) this.f20228k).b();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zaw() {
        return this.f20228k instanceof zaaj;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        return this.f20228k instanceof zaaw;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
    }
}
