package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzih implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f21839a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzik f21840b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzih(zzik zzikVar, boolean z3) {
        this.f21840b = zzikVar;
        this.f21839a = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zzJ = this.f21840b.f21734a.zzJ();
        boolean zzI = this.f21840b.f21734a.zzI();
        this.f21840b.f21734a.e(this.f21839a);
        if (zzI == this.f21839a) {
            this.f21840b.f21734a.zzaA().zzj().zzb("Default data collection state already set to", Boolean.valueOf(this.f21839a));
        }
        if (this.f21840b.f21734a.zzJ() == zzJ || this.f21840b.f21734a.zzJ() != this.f21840b.f21734a.zzI()) {
            this.f21840b.f21734a.zzaA().zzl().zzc("Default data collection is different than actual status", Boolean.valueOf(this.f21839a), Boolean.valueOf(zzJ));
        }
        this.f21840b.o();
    }
}
