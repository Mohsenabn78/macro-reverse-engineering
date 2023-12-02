package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefs {
    private final zzfax zza;
    private final zzdns zzb;
    private final zzdqa zzc;
    private final zzfev zzd;

    public zzefs(zzfax zzfaxVar, zzdns zzdnsVar, zzdqa zzdqaVar, zzfev zzfevVar) {
        this.zza = zzfaxVar;
        this.zzb = zzdnsVar;
        this.zzc = zzdqaVar;
        this.zzd = zzfevVar;
    }

    public final void zza(zzezq zzezqVar, zzezn zzeznVar, int i4, @Nullable zzecg zzecgVar, long j4) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfeu zzb = zzfeu.zzb("adapter_status");
            zzb.zzg(zzezqVar);
            zzb.zzf(zzeznVar);
            zzb.zza("adapter_l", String.valueOf(j4));
            zzb.zza("sc", Integer.toString(i4));
            if (zzecgVar != null) {
                zzb.zza("arec", Integer.toString(zzecgVar.zzb().zza));
                String zza = this.zza.zza(zzecgVar.getMessage());
                if (zza != null) {
                    zzb.zza("areec", zza);
                }
            }
            zzdnr zzb2 = this.zzb.zzb(zzeznVar.zzu);
            if (zzb2 != null) {
                zzb.zza("ancn", zzb2.zza);
                zzbqh zzbqhVar = zzb2.zzb;
                if (zzbqhVar != null) {
                    zzb.zza("adapter_v", zzbqhVar.toString());
                }
                zzbqh zzbqhVar2 = zzb2.zzc;
                if (zzbqhVar2 != null) {
                    zzb.zza("adapter_sv", zzbqhVar2.toString());
                }
            }
            this.zzd.zzb(zzb);
            return;
        }
        zzdpz zza2 = this.zzc.zza();
        zza2.zze(zzezqVar);
        zza2.zzd(zzeznVar);
        zza2.zzb("action", "adapter_status");
        zza2.zzb("adapter_l", String.valueOf(j4));
        zza2.zzb("sc", Integer.toString(i4));
        if (zzecgVar != null) {
            zza2.zzb("arec", Integer.toString(zzecgVar.zzb().zza));
            String zza3 = this.zza.zza(zzecgVar.getMessage());
            if (zza3 != null) {
                zza2.zzb("areec", zza3);
            }
        }
        zzdnr zzb3 = this.zzb.zzb(zzeznVar.zzu);
        if (zzb3 != null) {
            zza2.zzb("ancn", zzb3.zza);
            zzbqh zzbqhVar3 = zzb3.zzb;
            if (zzbqhVar3 != null) {
                zza2.zzb("adapter_v", zzbqhVar3.toString());
            }
            zzbqh zzbqhVar4 = zzb3.zzc;
            if (zzbqhVar4 != null) {
                zza2.zzb("adapter_sv", zzbqhVar4.toString());
            }
        }
        zza2.zzg();
    }
}
