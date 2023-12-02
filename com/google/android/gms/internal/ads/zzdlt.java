package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdlt {
    private final zzcve zza;
    private final zzcwn zzb;
    private final zzcxa zzc;
    private final zzcxm zzd;
    private final zzdaa zze;
    private final zzezn zzf;
    private final zzezq zzg;

    public zzdlt(zzcve zzcveVar, zzcwn zzcwnVar, zzcxa zzcxaVar, zzcxm zzcxmVar, zzdaa zzdaaVar, zzezn zzeznVar, zzezq zzezqVar) {
        this.zza = zzcveVar;
        this.zzb = zzcwnVar;
        this.zzc = zzcxaVar;
        this.zzd = zzcxmVar;
        this.zze = zzdaaVar;
        this.zzf = zzeznVar;
        this.zzg = zzezqVar;
    }

    public final void zza(zzdlx zzdlxVar) {
        zzdlk zzdlkVar;
        zzdlkVar = zzdlxVar.zza;
        zzcve zzcveVar = this.zza;
        zzcxa zzcxaVar = this.zzc;
        zzcxm zzcxmVar = this.zzd;
        zzdaa zzdaaVar = this.zze;
        final zzcwn zzcwnVar = this.zzb;
        zzcwnVar.getClass();
        zzdlkVar.zzh(zzcveVar, zzcxaVar, zzcxmVar, zzdaaVar, new com.google.android.gms.ads.internal.overlay.zzz() { // from class: com.google.android.gms.internal.ads.zzdls
            @Override // com.google.android.gms.ads.internal.overlay.zzz
            public final void zzg() {
                zzcwn.this.zzb();
            }
        });
        zzdlxVar.zze(this.zzf, this.zzg);
    }
}
