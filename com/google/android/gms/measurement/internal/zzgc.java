package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzgc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzhi f21655a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgd f21656b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgc(zzgd zzgdVar, zzhi zzhiVar) {
        this.f21656b = zzgdVar;
        this.f21655a = zzhiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgd.a(this.f21656b, this.f21655a);
        this.f21656b.f(this.f21655a.f21772g);
    }
}
