package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzezi implements zzekb {
    final /* synthetic */ zzezk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzezi(zzezk zzezkVar) {
        this.zza = zzezkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzekb
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdmm zzdmmVar;
        zzfaa zzfaaVar;
        synchronized (this.zza) {
            this.zza.zzd = (zzdmm) obj;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdh)).booleanValue()) {
                zzfab zzd = ((zzdmm) obj).zzd();
                zzfaaVar = this.zza.zzc;
                zzd.zza = zzfaaVar;
            }
            zzdmmVar = this.zza.zzd;
            zzdmmVar.zzj();
        }
    }
}
