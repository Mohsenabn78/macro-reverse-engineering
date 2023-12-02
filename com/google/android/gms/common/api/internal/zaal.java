package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f20143a;

    /* renamed from: b  reason: collision with root package name */
    private final Api f20144b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20145c;

    public zaal(zaaw zaawVar, Api api, boolean z3) {
        this.f20143a = new WeakReference(zaawVar);
        this.f20144b = api;
        this.f20145c = z3;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        zabi zabiVar;
        boolean z3;
        Lock lock;
        Lock lock2;
        boolean g4;
        boolean h4;
        Lock lock3;
        zaaw zaawVar = (zaaw) this.f20143a.get();
        if (zaawVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        zabiVar = zaawVar.f20158a;
        if (myLooper == zabiVar.f20231n.getLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = zaawVar.f20159b;
        lock.lock();
        try {
            g4 = zaawVar.g(0);
            if (!g4) {
                lock3 = zaawVar.f20159b;
            } else {
                if (!connectionResult.isSuccess()) {
                    zaawVar.e(connectionResult, this.f20144b, this.f20145c);
                }
                h4 = zaawVar.h();
                if (h4) {
                    zaawVar.f();
                }
                lock3 = zaawVar.f20159b;
            }
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = zaawVar.f20159b;
            lock2.unlock();
            throw th;
        }
    }
}
