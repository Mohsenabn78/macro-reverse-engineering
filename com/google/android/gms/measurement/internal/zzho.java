package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzho implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f21777a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21778b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzho(zzik zzikVar, long j4) {
        this.f21778b = zzikVar;
        this.f21777a = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21778b.f21734a.zzm().f21599k.zzb(this.f21777a);
        this.f21778b.f21734a.zzaA().zzc().zzb("Session timeout duration set", Long.valueOf(this.f21777a));
    }
}
