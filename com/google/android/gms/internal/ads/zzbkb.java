package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbkb implements Runnable {
    final /* synthetic */ zzbke zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkb(zzbke zzbkeVar) {
        this.zza = zzbkeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbke.zzc(this.zza);
    }
}
