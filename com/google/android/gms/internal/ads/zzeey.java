package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeey implements zzeci {
    private final Context zza;
    private final zzdfk zzb;
    private final Executor zzc;

    public zzeey(Context context, zzdfk zzdfkVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdfkVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzezz zzezzVar, int i4) {
        return zzezzVar.zza.zza.zzg.contains(Integer.toString(i4));
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan, zzefu {
        zzdha zzaf;
        zzboh zzD = ((zzfbd) zzecfVar.zzb).zzD();
        zzboi zzE = ((zzfbd) zzecfVar.zzb).zzE();
        zzbol zzd = ((zzfbd) zzecfVar.zzb).zzd();
        if (zzd != null && zzc(zzezzVar, 6)) {
            zzaf = zzdha.zzs(zzd);
        } else if (zzD != null && zzc(zzezzVar, 6)) {
            zzaf = zzdha.zzag(zzD);
        } else if (zzD != null && zzc(zzezzVar, 2)) {
            zzaf = zzdha.zzae(zzD);
        } else if (zzE != null && zzc(zzezzVar, 6)) {
            zzaf = zzdha.zzah(zzE);
        } else if (zzE != null && zzc(zzezzVar, 1)) {
            zzaf = zzdha.zzaf(zzE);
        } else {
            throw new zzefu(1, "No native ad mappers");
        }
        if (zzezzVar.zza.zza.zzg.contains(Integer.toString(zzaf.zzc()))) {
            zzdhc zze = this.zzb.zze(new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza), new zzdhm(zzaf), new zzdjb(zzE, zzD, zzd));
            ((zzedy) zzecfVar.zzc).zzc(zze.zzj());
            zze.zzd().zzm(new zzcnd((zzfbd) zzecfVar.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzefu(1, "No corresponding native ad listener");
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        zzfai zzfaiVar = zzezzVar.zza.zza;
        ((zzfbd) zzecfVar.zzb).zzp(this.zza, zzezzVar.zza.zza.zzd, zzeznVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbu.zzl(zzeznVar.zzt), (zzboc) zzecfVar.zzc, zzfaiVar.zzi, zzfaiVar.zzg);
    }
}
