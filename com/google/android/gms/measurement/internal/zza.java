package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zza implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21424a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f21425b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzd f21426c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzd zzdVar, String str, long j4) {
        this.f21426c = zzdVar;
        this.f21424a = str;
        this.f21425b = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd.a(this.f21426c, this.f21424a, this.f21425b);
    }
}
