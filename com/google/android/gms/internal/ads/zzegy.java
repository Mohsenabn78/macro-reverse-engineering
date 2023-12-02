package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzegy implements zzeci {
    private final Context zza;
    private final Executor zzb;
    private final zzdmr zzc;

    public zzegy(Context context, Executor executor, zzdmr zzdmrVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdmrVar;
    }

    public static /* bridge */ /* synthetic */ Executor zzc(zzegy zzegyVar) {
        return zzegyVar.zzb;
    }

    public static final void zze(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) {
        try {
            ((zzfbd) zzecfVar.zzb).zzk(zzezzVar.zza.zza.zzd, zzeznVar.zzw.toString());
        } catch (Exception e4) {
            zzbzr.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzecfVar.zza)), e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezzVar, zzezn zzeznVar, final zzecf zzecfVar) throws zzfan, zzefu {
        zzdmn zze = this.zzc.zze(new zzcrs(zzezzVar, zzeznVar, zzecfVar.zza), new zzdmo(new zzdew() { // from class: com.google.android.gms.internal.ads.zzegu
            @Override // com.google.android.gms.internal.ads.zzdew
            public final void zza(boolean z3, Context context, zzcvt zzcvtVar) {
                zzecf zzecfVar2 = zzecf.this;
                try {
                    ((zzfbd) zzecfVar2.zzb).zzv(z3);
                    ((zzfbd) zzecfVar2.zzb).zzA();
                } catch (zzfan e4) {
                    zzbzr.zzk("Cannot show rewarded video.", e4);
                    throw new zzdev(e4.getCause());
                }
            }
        }));
        zze.zzd().zzm(new zzcnd((zzfbd) zzecfVar.zzb), this.zzb);
        zzcwn zze2 = zze.zze();
        zzcve zzb = zze.zzb();
        ((zzedz) zzecfVar.zzc).zzc(new zzegx(this, zze.zza(), zzb, zze2, zze.zzg()));
        return zze.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final void zzb(zzezz zzezzVar, zzezn zzeznVar, zzecf zzecfVar) throws zzfan {
        if (!((zzfbd) zzecfVar.zzb).zzC()) {
            ((zzedz) zzecfVar.zzc).zzd(new zzegw(this, zzezzVar, zzeznVar, zzecfVar));
            ((zzfbd) zzecfVar.zzb).zzh(this.zza, zzezzVar.zza.zza.zzd, null, (zzbvf) zzecfVar.zzc, zzeznVar.zzw.toString());
            return;
        }
        zze(zzezzVar, zzeznVar, zzecfVar);
    }
}
