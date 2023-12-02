package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzkh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f21990a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzkp f21991b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkh(zzkp zzkpVar, long j4) {
        this.f21991b = zzkpVar;
        this.f21990a = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkp.g(this.f21991b, this.f21990a);
    }
}
