package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
final class zzn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f22083a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f22084b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.f22084b = appMeasurementDynamiteService;
        this.f22083a = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22084b.f21422a.zzv().zzQ(this.f22083a, this.f22084b.f21422a.zzI());
    }
}
