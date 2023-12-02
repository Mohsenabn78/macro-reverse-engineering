package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjj extends zzan {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjz f21924e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjj(zzjz zzjzVar, zzgy zzgyVar) {
        super(zzgyVar);
        this.f21924e = zzjzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzan
    public final void c() {
        zzjz zzjzVar = this.f21924e;
        zzjzVar.zzg();
        if (!zzjzVar.zzL()) {
            return;
        }
        zzjzVar.f21734a.zzaA().zzj().zza("Inactivity, disconnecting from the service");
        zzjzVar.zzs();
    }
}
