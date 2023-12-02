package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzccc implements Runnable {
    private final zzcbo zza;
    private boolean zzb = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzccc(zzcbo zzcboVar) {
        this.zza = zzcboVar;
    }

    private final void zzc() {
        zzfmd zzfmdVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzfmdVar.removeCallbacks(this);
        zzfmdVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzb) {
            this.zza.zzt();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
