package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
final class zzl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzo f22025a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f22026b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzo zzoVar) {
        this.f22026b = appMeasurementDynamiteService;
        this.f22025a = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22026b.f21422a.zzq().zzT(this.f22025a);
    }
}
