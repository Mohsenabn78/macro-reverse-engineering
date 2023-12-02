package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzam implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzgy f21454a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzan f21455b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(zzan zzanVar, zzgy zzgyVar) {
        this.f21455b = zzanVar;
        this.f21454a = zzgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21454a.zzay();
        if (zzab.zza()) {
            this.f21454a.zzaB().zzp(this);
            return;
        }
        boolean e4 = this.f21455b.e();
        this.f21455b.f21459c = 0L;
        if (e4) {
            this.f21455b.c();
        }
    }
}
