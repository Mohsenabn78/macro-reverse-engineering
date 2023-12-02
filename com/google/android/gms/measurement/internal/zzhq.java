package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21788a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21789b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f21790c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f21791d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzik f21792e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhq(zzik zzikVar, String str, String str2, Object obj, long j4) {
        this.f21792e = zzikVar;
        this.f21788a = str;
        this.f21789b = str2;
        this.f21790c = obj;
        this.f21791d = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21792e.m(this.f21788a, this.f21789b, this.f21790c, this.f21791d);
    }
}
