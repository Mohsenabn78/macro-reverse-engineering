package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbni {
    private final zzbml zza;
    private zzfwm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbni(zzbml zzbmlVar) {
        this.zza = zzbmlVar;
    }

    private final void zzd() {
        if (this.zzb == null) {
            final zzcaj zzcajVar = new zzcaj();
            this.zzb = zzcajVar;
            this.zza.zzb(null).zzi(new zzcan() { // from class: com.google.android.gms.internal.ads.zzbng
                @Override // com.google.android.gms.internal.ads.zzcan
                public final void zza(Object obj) {
                    zzcaj.this.zzd((zzbmm) obj);
                }
            }, new zzcal() { // from class: com.google.android.gms.internal.ads.zzbnh
                @Override // com.google.android.gms.internal.ads.zzcal
                public final void zza() {
                    zzcaj.this.zze(new zzbmo("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzbnl zza(String str, zzbms zzbmsVar, zzbmr zzbmrVar) {
        zzd();
        return new zzbnl(this.zzb, "google.afma.activeView.handleUpdate", zzbmsVar, zzbmrVar);
    }

    public final void zzb(final String str, final zzbij zzbijVar) {
        zzd();
        this.zzb = zzfwc.zzm(this.zzb, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzbne
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                zzbmm zzbmmVar = (zzbmm) obj;
                zzbmmVar.zzq(str, zzbijVar);
                return zzfwc.zzh(zzbmmVar);
            }
        }, zzcae.zzf);
    }

    public final void zzc(final String str, final zzbij zzbijVar) {
        this.zzb = zzfwc.zzl(this.zzb, new zzfov() { // from class: com.google.android.gms.internal.ads.zzbnf
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                zzbmm zzbmmVar = (zzbmm) obj;
                zzbmmVar.zzr(str, zzbijVar);
                return zzbmmVar;
            }
        }, zzcae.zzf);
    }
}
