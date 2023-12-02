package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21708a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgv f21709b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgn(zzgv zzgvVar, zzq zzqVar) {
        this.f21709b = zzgvVar;
        this.f21708a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21709b.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21709b.f21731a;
        zzq zzqVar = this.f21708a;
        zzlhVar2.zzaB().zzg();
        zzlhVar2.b();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzhb zzc = zzhb.zzc(zzqVar.zzv, 100);
        zzhb P = zzlhVar2.P(zzqVar.zza);
        zzlhVar2.zzaA().zzj().zzc("Setting consent, package, consent", zzqVar.zza, zzc);
        zzlhVar2.u(zzqVar.zza, zzc);
        if (zzc.zzm(P)) {
            zzlhVar2.q(zzqVar);
        }
    }
}
