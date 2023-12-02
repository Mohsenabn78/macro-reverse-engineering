package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdmc {
    private final zzcve zza;
    private final zzcwn zzb;
    private final zzcxa zzc;
    private final zzcxm zzd;
    private final zzdaa zze;
    private final zzdcs zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmc(zzcve zzcveVar, zzcwn zzcwnVar, zzcxa zzcxaVar, zzcxm zzcxmVar, zzdaa zzdaaVar, zzdcs zzdcsVar) {
        this.zza = zzcveVar;
        this.zzb = zzcwnVar;
        this.zzc = zzcxaVar;
        this.zzd = zzcxmVar;
        this.zze = zzdaaVar;
        this.zzf = zzdcsVar;
    }

    public final void zza(zzdmd zzdmdVar) {
        zzdma zzdmaVar;
        zzdmaVar = zzdmdVar.zza;
        zzcve zzcveVar = this.zza;
        zzcxa zzcxaVar = this.zzc;
        zzcxm zzcxmVar = this.zzd;
        zzdaa zzdaaVar = this.zze;
        final zzcwn zzcwnVar = this.zzb;
        zzcwnVar.getClass();
        zzdmaVar.zzi(zzcveVar, zzcxaVar, zzcxmVar, zzdaaVar, new com.google.android.gms.ads.internal.overlay.zzz() { // from class: com.google.android.gms.internal.ads.zzdmb
            @Override // com.google.android.gms.ads.internal.overlay.zzz
            public final void zzg() {
                zzcwn.this.zzb();
            }
        }, this.zzf);
    }
}
