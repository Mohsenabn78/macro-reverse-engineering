package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
final class zzm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f22079a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f22080b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f22081c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f22082d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2) {
        this.f22082d = appMeasurementDynamiteService;
        this.f22079a = zzcfVar;
        this.f22080b = str;
        this.f22081c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22082d.f21422a.zzt().C(this.f22079a, this.f22080b, this.f22081c);
    }
}
