package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzki implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f21992a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzkp f21993b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzki(zzkp zzkpVar, long j4) {
        this.f21993b = zzkpVar;
        this.f21992a = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkp.f(this.f21993b, this.f21992a);
    }
}
