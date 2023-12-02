package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f21683a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f21684b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgv f21685c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgf(zzgv zzgvVar, zzac zzacVar, zzq zzqVar) {
        this.f21685c = zzgvVar;
        this.f21683a = zzacVar;
        this.f21684b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlh zzlhVar3;
        zzlhVar = this.f21685c.f21731a;
        zzlhVar.a();
        if (this.f21683a.zzc.zza() == null) {
            zzlhVar3 = this.f21685c.f21731a;
            zzlhVar3.o(this.f21683a, this.f21684b);
            return;
        }
        zzlhVar2 = this.f21685c.f21731a;
        zzlhVar2.t(this.f21683a, this.f21684b);
    }
}
