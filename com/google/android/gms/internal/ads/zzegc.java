package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzegc implements zzeci {
    private final Context zza;
    private final Executor zzb;
    private final zzdmr zzc;

    public zzegc(Context context, Executor executor, zzdmr zzdmrVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, zzezn zzeznVar, final zzecf zzecfVar) throws zzfan, zzefu {
        zzdmn zze = this.zzc.zze(new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza), new zzdmo(new zzdew() { // from class: com.google.android.gms.internal.ads.zzegb
            @Override // com.google.android.gms.internal.ads.zzdew
            public final void zza(boolean z3, Context context, zzcvt zzcvtVar) {
                zzecf zzecfVar2 = zzecf.this;
                try {
                    ((zzfbd) zzecfVar2.zzb).zzv(z3);
                    ((zzfbd) zzecfVar2.zzb).zzz(context);
                } catch (zzfan e4) {
                    throw new zzdev(e4.getCause());
                }
            }
        }));
        zze.zzd().zzm(new zzcnd((zzfbd) zzecfVar.zzb), this.zzb);
        ((zzedy) zzecfVar.zzc).zzc(zze.zzm());
        return zze.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        try {
            zzfai zzfaiVar = zzezzVar.zza.zza;
            if (zzfaiVar.zzo.zza == 3) {
                ((zzfbd) zzecfVar.zzb).zzr(this.zza, zzfaiVar.zzd, zzeznVar.zzw.toString(), (zzboc) zzecfVar.zzc);
            } else {
                ((zzfbd) zzecfVar.zzb).zzq(this.zza, zzfaiVar.zzd, zzeznVar.zzw.toString(), (zzboc) zzecfVar.zzc);
            }
        } catch (Exception e4) {
            zzbzr.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzecfVar.zza)), e4);
        }
    }
}
