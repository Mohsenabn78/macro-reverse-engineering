package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
final class zzj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f21891a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzau f21892b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21893c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f21894d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar, zzau zzauVar, String str) {
        this.f21894d = appMeasurementDynamiteService;
        this.f21891a = zzcfVar;
        this.f21892b = zzauVar;
        this.f21893c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21894d.f21422a.zzt().zzB(this.f21891a, this.f21892b, this.f21893c);
    }
}
