package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkr extends zzan {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzks f22012e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkr(zzks zzksVar, zzgy zzgyVar) {
        super(zzgyVar);
        this.f22012e = zzksVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzan
    public final void c() {
        this.f22012e.zza();
        this.f22012e.f21734a.zzaA().zzj().zza("Starting upload from DelayedRunnable");
        this.f22012e.f22016b.w();
    }
}
