package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f21710a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f21711b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgv f21712c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzgv zzgvVar, zzau zzauVar, zzq zzqVar) {
        this.f21712c = zzgvVar;
        this.f21710a = zzauVar;
        this.f21711b = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21712c.d(this.f21712c.b(this.f21710a, this.f21711b), this.f21711b);
    }
}
