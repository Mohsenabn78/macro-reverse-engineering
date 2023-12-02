package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzlk f21719a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f21720b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgv f21721c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzgv zzgvVar, zzlk zzlkVar, zzq zzqVar) {
        this.f21721c = zzgvVar;
        this.f21719a = zzlkVar;
        this.f21720b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlh zzlhVar3;
        zzlhVar = this.f21721c.f21731a;
        zzlhVar.a();
        if (this.f21719a.zza() == null) {
            zzlhVar3 = this.f21721c.f21731a;
            zzlhVar3.p(this.f21719a.zzb, this.f21720b);
            return;
        }
        zzlhVar2 = this.f21721c.f21731a;
        zzlhVar2.v(this.f21719a, this.f21720b);
    }
}
