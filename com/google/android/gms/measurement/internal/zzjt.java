package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzjt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzej f21960a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjy f21961b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjt(zzjy zzjyVar, zzej zzejVar) {
        this.f21961b = zzjyVar;
        this.f21960a = zzejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21961b) {
            this.f21961b.f21968a = false;
            if (!this.f21961b.f21970c.zzL()) {
                this.f21961b.f21970c.f21734a.zzaA().zzj().zza("Connected to service");
                this.f21961b.f21970c.k(this.f21960a);
            }
        }
    }
}
