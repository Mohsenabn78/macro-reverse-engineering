package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjl extends zzan {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjz f21929e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjl(zzjz zzjzVar, zzgy zzgyVar) {
        super(zzgyVar);
        this.f21929e = zzjzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzan
    public final void c() {
        this.f21929e.f21734a.zzaA().zzk().zza("Tasks have been queued for a long time");
    }
}
