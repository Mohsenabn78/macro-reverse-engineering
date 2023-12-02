package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zziu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzir f21869a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzir f21870b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f21871c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f21872d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zziz f21873e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziu(zziz zzizVar, zzir zzirVar, zzir zzirVar2, long j4, boolean z3) {
        this.f21873e = zzizVar;
        this.f21869a = zzirVar;
        this.f21870b = zzirVar2;
        this.f21871c = j4;
        this.f21872d = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21873e.d(this.f21869a, this.f21870b, this.f21871c, this.f21872d, null);
    }
}
