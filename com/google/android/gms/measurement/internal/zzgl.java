package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f21704a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgv f21705b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgl(zzgv zzgvVar, zzq zzqVar) {
        this.f21705b = zzgvVar;
        this.f21704a = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21705b.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21705b.f21731a;
        zzlhVar2.q(this.f21704a);
    }
}
