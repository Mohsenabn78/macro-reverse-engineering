package com.google.android.gms.ads.internal.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zza implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzb f19257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzb zzbVar) {
        this.f19257a = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f19257a.zzb = Thread.currentThread();
        this.f19257a.zza();
    }
}
