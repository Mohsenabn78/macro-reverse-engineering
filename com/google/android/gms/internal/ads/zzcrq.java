package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcrq implements zzfvy {
    final /* synthetic */ zzfvy zza;
    final /* synthetic */ zzcrr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrq(zzcrr zzcrrVar, zzfvy zzfvyVar) {
        this.zzb = zzcrrVar;
        this.zza = zzfvyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcro
            @Override // java.lang.Runnable
            public final void run() {
                zzcrr.this.zzd();
            }
        });
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcro
            @Override // java.lang.Runnable
            public final void run() {
                zzcrr.this.zzd();
            }
        });
        this.zza.zzb((zzcrd) obj);
    }
}
