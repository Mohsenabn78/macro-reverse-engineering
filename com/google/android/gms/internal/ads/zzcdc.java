package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcdc implements Runnable {
    final /* synthetic */ zzcdd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdc(zzcdd zzcddVar) {
        this.zza = zzcddVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzy().zzc(this.zza);
    }
}
