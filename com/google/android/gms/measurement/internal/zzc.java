package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f21488a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzd f21489b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(zzd zzdVar, long j4) {
        this.f21489b = zzdVar;
        this.f21488a = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21489b.f(this.f21488a);
    }
}
