package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkm extends zzan {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzkn f21999e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkm(zzkn zzknVar, zzgy zzgyVar) {
        super(zzgyVar);
        this.f21999e = zzknVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzan
    @WorkerThread
    public final void c() {
        zzkn zzknVar = this.f21999e;
        zzknVar.f22003d.zzg();
        zzknVar.d(false, false, zzknVar.f22003d.f21734a.zzax().elapsedRealtime());
        zzknVar.f22003d.f21734a.zzd().zzf(zzknVar.f22003d.f21734a.zzax().elapsedRealtime());
    }
}
