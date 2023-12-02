package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21724a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgv f21725b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgt(zzgv zzgvVar, zzq zzqVar) {
        this.f21725b = zzgvVar;
        this.f21724a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21725b.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21725b.f21731a;
        zzlhVar2.l(this.f21724a);
    }
}
