package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zziw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f21875a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zziz f21876b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(zziz zzizVar, long j4) {
        this.f21876b = zzizVar;
        this.f21875a = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21876b.f21734a.zzd().zzf(this.f21875a);
        this.f21876b.f21883e = null;
    }
}
