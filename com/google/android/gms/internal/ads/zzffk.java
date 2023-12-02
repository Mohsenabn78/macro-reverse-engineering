package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzffk implements zzdcd, zzcvw, zzdch {
    private final zzffy zza;
    private final zzffn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzffk(Context context, zzffy zzffyVar) {
        this.zza = zzffyVar;
        this.zzb = zzffm.zza(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zzb() {
        if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            zzffy zzffyVar = this.zza;
            zzffn zzffnVar = this.zzb;
            zzffnVar.zzf(true);
            zzffyVar.zza(zzffnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzg() {
        if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            this.zzb.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            zzffy zzffyVar = this.zza;
            zzffn zzffnVar = this.zzb;
            zzffnVar.zzc(zzeVar.zza().toString());
            zzffnVar.zzf(false);
            zzffyVar.zza(zzffnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdch
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzf() {
    }
}
