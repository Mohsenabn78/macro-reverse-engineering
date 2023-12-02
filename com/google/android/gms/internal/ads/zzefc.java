package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefc implements zzeci {
    private final Context zza;
    private final zzdfk zzb;
    private zzbol zzc;
    private final zzbzx zzd;

    public zzefc(Context context, zzdfk zzdfkVar, zzbzx zzbzxVar) {
        this.zza = context;
        this.zzb = zzdfkVar;
        this.zzd = zzbzxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan, zzefu {
        if (zzezzVar.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdha zzs = zzdha.zzs(this.zzc);
            if (zzezzVar.zza.zza.zzg.contains(Integer.toString(zzs.zzc()))) {
                zzdhc zze = this.zzb.zze(new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza), new zzdhm(zzs), new zzdjb(null, null, this.zzc));
                ((zzedy) zzecfVar.zzc).zzc(zze.zzi());
                return zze.zza();
            }
            throw new zzefu(1, "No corresponding native ad listener");
        }
        throw new zzefu(2, "Unified must be used for RTB.");
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        try {
            ((zzbpt) zzecfVar.zzb).zzq(zzeznVar.zzaa);
            if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbB)).intValue()) {
                ((zzbpt) zzecfVar.zzb).zzm(zzeznVar.zzV, zzeznVar.zzw.toString(), zzezzVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefb(this, zzecfVar, null), (zzboc) zzecfVar.zzc);
            } else {
                ((zzbpt) zzecfVar.zzb).zzn(zzeznVar.zzV, zzeznVar.zzw.toString(), zzezzVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefb(this, zzecfVar, null), (zzboc) zzecfVar.zzc, zzezzVar.zza.zza.zzi);
            }
        } catch (RemoteException e4) {
            throw new zzfan(e4);
        }
    }
}
