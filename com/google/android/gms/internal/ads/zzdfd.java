package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdfd implements zzcrg {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzgwr zzd;
    private final zzdhl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfd(Map map, Map map2, Map map3, zzgwr zzgwrVar, zzdhl zzdhlVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzgwrVar;
        this.zze = zzdhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrg
    @Nullable
    public final zzecc zza(int i4, String str) {
        zzecc zza;
        zzecc zzeccVar = (zzecc) this.zza.get(str);
        if (zzeccVar != null) {
            return zzeccVar;
        }
        if (i4 != 1) {
            if (i4 != 4) {
                return null;
            }
            zzeeq zzeeqVar = (zzeeq) this.zzc.get(str);
            if (zzeeqVar != null) {
                return new zzecd(zzeeqVar, new zzfov() { // from class: com.google.android.gms.internal.ads.zzcri
                    @Override // com.google.android.gms.internal.ads.zzfov
                    public final Object apply(Object obj) {
                        return new zzcrk((List) obj);
                    }
                });
            }
            zzecc zzeccVar2 = (zzecc) this.zzb.get(str);
            if (zzeccVar2 == null) {
                return null;
            }
            return zzcrk.zza(zzeccVar2);
        } else if (this.zze.zze() == null || (zza = ((zzcrg) this.zzd.zzb()).zza(i4, str)) == null) {
            return null;
        } else {
            return zzcrk.zza(zza);
        }
    }
}
