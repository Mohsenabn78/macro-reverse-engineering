package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbma implements zzcan {
    final /* synthetic */ zzbmk zza;
    final /* synthetic */ zzffn zzb;
    final /* synthetic */ zzbml zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbma(zzbml zzbmlVar, zzbmk zzbmkVar, zzffn zzffnVar) {
        this.zzc = zzbmlVar;
        this.zza = zzbmkVar;
        this.zzb = zzffnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Object obj2;
        zzbmk zzbmkVar;
        zzfgb zzfgbVar;
        zzfgb zzfgbVar2;
        zzbmk zzbmkVar2;
        zzbmk zzbmkVar3;
        zzblg zzblgVar = (zzblg) obj;
        obj2 = this.zzc.zza;
        synchronized (obj2) {
            this.zzc.zzi = 0;
            zzbml zzbmlVar = this.zzc;
            zzbmkVar = zzbmlVar.zzh;
            if (zzbmkVar != null) {
                zzbmk zzbmkVar4 = this.zza;
                zzbmkVar2 = zzbmlVar.zzh;
                if (zzbmkVar4 != zzbmkVar2) {
                    com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                    zzbmkVar3 = this.zzc.zzh;
                    zzbmkVar3.zzb();
                }
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
                zzbml zzbmlVar2 = this.zzc;
                zzfgbVar = zzbmlVar2.zze;
                if (zzfgbVar != null) {
                    zzfgbVar2 = zzbmlVar2.zze;
                    zzffn zzffnVar = this.zzb;
                    zzffnVar.zzf(true);
                    zzfgbVar2.zzb(zzffnVar.zzl());
                }
            }
        }
    }
}
