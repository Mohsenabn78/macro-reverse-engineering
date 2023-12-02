package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdvx implements zzdvz {
    private final Map zza;
    private final zzfwn zzb;
    private final zzcxz zzc;

    public zzdvx(Map map, zzfwn zzfwnVar, zzcxz zzcxzVar) {
        this.zza = map;
        this.zzb = zzfwnVar;
        this.zzc = zzcxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    public final zzfwm zzb(final zzbue zzbueVar) {
        this.zzc.zzbA(zzbueVar);
        zzfwm zzg = zzfwc.zzg(new zzdtx(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhM)).split(",")) {
            final zzgwr zzgwrVar = (zzgwr) this.zza.get(str.trim());
            if (zzgwrVar != null) {
                zzg = zzfwc.zzf(zzg, zzdtx.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdvv
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        zzgwr zzgwrVar2 = zzgwr.this;
                        zzdtx zzdtxVar = (zzdtx) obj;
                        return ((zzdvz) zzgwrVar2.zzb()).zzb(zzbueVar);
                    }
                }, this.zzb);
            }
        }
        zzfwc.zzq(zzg, new zzdvw(this), zzcae.zzf);
        return zzg;
    }
}
