package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.3.0 */
/* loaded from: classes4.dex */
final class zzk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf f21978a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21979b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21980c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f21981d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f21982e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2, boolean z3) {
        this.f21982e = appMeasurementDynamiteService;
        this.f21978a = zzcfVar;
        this.f21979b = str;
        this.f21980c = str2;
        this.f21981d = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21982e.f21422a.zzt().F(this.f21978a, this.f21979b, this.f21980c, this.f21981d);
    }
}
