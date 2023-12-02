package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzix implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzir f21877a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f21878b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zziz f21879c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzix(zziz zzizVar, zzir zzirVar, long j4) {
        this.f21879c = zzizVar;
        this.f21877a = zzirVar;
        this.f21878b = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21879c.e(this.f21877a, false, this.f21878b);
        zziz zzizVar = this.f21879c;
        zzizVar.f21883e = null;
        zzizVar.f21734a.zzt().i(null);
    }
}
