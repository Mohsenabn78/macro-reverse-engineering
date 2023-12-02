package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzke implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzlh f21987a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f21988b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(zzkg zzkgVar, zzlh zzlhVar, Runnable runnable) {
        this.f21987a = zzlhVar;
        this.f21988b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21987a.a();
        this.f21987a.T(this.f21988b);
        this.f21987a.w();
    }
}
