package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzfa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f21562a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzfb f21563b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfa(zzfb zzfbVar, boolean z3) {
        this.f21563b = zzfbVar;
        this.f21562a = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlhVar = this.f21563b.f21564a;
        zzlhVar.j(this.f21562a);
    }
}
