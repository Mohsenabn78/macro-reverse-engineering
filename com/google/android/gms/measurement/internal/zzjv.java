package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzjv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzej f21964a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjy f21965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjv(zzjy zzjyVar, zzej zzejVar) {
        this.f21965b = zzjyVar;
        this.f21964a = zzejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f21965b) {
            this.f21965b.f21968a = false;
            if (!this.f21965b.f21970c.zzL()) {
                this.f21965b.f21970c.f21734a.zzaA().zzc().zza("Connected to remote service");
                this.f21965b.f21970c.k(this.f21964a);
            }
        }
    }
}
