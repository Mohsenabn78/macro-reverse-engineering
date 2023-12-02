package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f21713a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21714b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgv f21715c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgp(zzgv zzgvVar, zzau zzauVar, String str) {
        this.f21715c = zzgvVar;
        this.f21713a = zzauVar;
        this.f21714b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlhVar = this.f21715c.f21731a;
        zzlhVar.a();
        zzlhVar2 = this.f21715c.f21731a;
        zzlhVar2.f(this.f21713a, this.f21714b);
    }
}
