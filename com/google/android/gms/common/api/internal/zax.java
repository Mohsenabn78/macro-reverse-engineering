package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zax implements zabz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaa f20336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zax(zaaa zaaaVar, zaw zawVar) {
        this.f20336a = zaaaVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(@NonNull ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f20336a.f20125m;
        lock.lock();
        try {
            this.f20336a.f20122j = connectionResult;
            zaaa.p(this.f20336a);
        } finally {
            lock2 = this.f20336a.f20125m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(@Nullable Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f20336a.f20125m;
        lock.lock();
        try {
            zaaa.o(this.f20336a, bundle);
            this.f20336a.f20122j = ConnectionResult.RESULT_SUCCESS;
            zaaa.p(this.f20336a);
        } finally {
            lock2 = this.f20336a.f20125m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i4, boolean z3) {
        Lock lock;
        Lock lock2;
        boolean z4;
        Lock lock3;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        zabi zabiVar;
        lock = this.f20336a.f20125m;
        lock.lock();
        try {
            zaaa zaaaVar = this.f20336a;
            z4 = zaaaVar.f20124l;
            if (!z4) {
                connectionResult = zaaaVar.f20123k;
                if (connectionResult != null) {
                    connectionResult2 = zaaaVar.f20123k;
                    if (connectionResult2.isSuccess()) {
                        this.f20336a.f20124l = true;
                        zabiVar = this.f20336a.f20117e;
                        zabiVar.onConnectionSuspended(i4);
                        lock3 = this.f20336a.f20125m;
                        lock3.unlock();
                    }
                }
            }
            this.f20336a.f20124l = false;
            zaaa.n(this.f20336a, i4, z3);
            lock3 = this.f20336a.f20125m;
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = this.f20336a.f20125m;
            lock2.unlock();
            throw th;
        }
    }
}
