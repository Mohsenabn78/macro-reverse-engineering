package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21485a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f21486b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzd f21487c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzd zzdVar, String str, long j4) {
        this.f21487c = zzdVar;
        this.f21485a = str;
        this.f21486b = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd.b(this.f21487c, this.f21485a, this.f21486b);
    }
}
