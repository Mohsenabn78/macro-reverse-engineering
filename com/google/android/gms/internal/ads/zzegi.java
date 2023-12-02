package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzegi extends zzehj {
    private final zzddd zza;

    public zzegi(zzcve zzcveVar, zzdcs zzdcsVar, zzcvy zzcvyVar, zzcwn zzcwnVar, zzcws zzcwsVar, zzcvt zzcvtVar, zzdaa zzdaaVar, zzddk zzddkVar, zzcxm zzcxmVar, zzddd zzdddVar, zzczw zzczwVar) {
        super(zzcveVar, zzdcsVar, zzcvyVar, zzcwnVar, zzcwsVar, zzdaaVar, zzcxmVar, zzddkVar, zzczwVar, zzcvtVar);
        this.zza = zzdddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehj, com.google.android.gms.internal.ads.zzboc
    public final void zzs(zzbvg zzbvgVar) {
        this.zza.zza(zzbvgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzehj, com.google.android.gms.internal.ads.zzboc
    public final void zzt(zzbvk zzbvkVar) throws RemoteException {
        this.zza.zza(new zzbvg(zzbvkVar.zzf(), zzbvkVar.zze()));
    }

    @Override // com.google.android.gms.internal.ads.zzehj, com.google.android.gms.internal.ads.zzboc
    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzehj, com.google.android.gms.internal.ads.zzboc
    public final void zzv() {
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzehj, com.google.android.gms.internal.ads.zzboc
    public final void zzy() {
        this.zza.zzc();
    }
}
