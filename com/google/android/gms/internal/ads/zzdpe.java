package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdpe implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;

    public zzdpe(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
        this.zzd = zzgwrVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set emptySet;
        final String str = (String) this.zza.zzb();
        Context zza = ((zzcha) this.zzb).zza();
        zzfwn zzfwnVar = zzcae.zza;
        zzgwm.zzb(zzfwnVar);
        Map zzb = ((zzgwi) this.zzd).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeG)).booleanValue()) {
            zzawz zzawzVar = new zzawz(new zzaxf(zza));
            zzawzVar.zzb(new zzawy() { // from class: com.google.android.gms.internal.ads.zzdpf
                @Override // com.google.android.gms.internal.ads.zzawy
                public final void zza(zzayo zzayoVar) {
                    zzayoVar.zzh(str);
                }
            });
            emptySet = Collections.singleton(new zzdcm(new zzdph(zzawzVar, zzb), zzfwnVar));
        } else {
            emptySet = Collections.emptySet();
        }
        zzgwm.zzb(emptySet);
        return emptySet;
    }
}
