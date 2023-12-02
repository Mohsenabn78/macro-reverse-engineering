package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdoe implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzdoe(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4, zzgwr zzgwrVar5) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
        this.zzd = zzgwrVar4;
        this.zze = zzgwrVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        int i4;
        Context zza = ((zzcha) this.zza).zza();
        final String zzb = ((zzdup) this.zzb).zzb();
        zzbzx zza2 = ((zzchm) this.zzc).zza();
        final zzaxj zzaxjVar = (zzaxj) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzawz zzawzVar = new zzawz(new zzaxf(zza));
        zzazy zza3 = zzazz.zza();
        zza3.zza(zza2.zzb);
        zza3.zzc(zza2.zzc);
        if (true != zza2.zzd) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        zza3.zzb(i4);
        final zzazz zzazzVar = (zzazz) zza3.zzal();
        zzawzVar.zzb(new zzawy() { // from class: com.google.android.gms.internal.ads.zzdod
            @Override // com.google.android.gms.internal.ads.zzawy
            public final void zza(zzayo zzayoVar) {
                zzaxj zzaxjVar2 = zzaxj.this;
                String str2 = zzb;
                zzazz zzazzVar2 = zzazzVar;
                String str3 = str;
                zzaxk zzaxkVar = (zzaxk) zzayoVar.zza().zzaB();
                zzaxkVar.zza(zzaxjVar2);
                zzayoVar.zze(zzaxkVar);
                zzayg zzaygVar = (zzayg) zzayoVar.zzb().zzaB();
                zzaygVar.zza(str2);
                zzaygVar.zzb(zzazzVar2);
                zzayoVar.zzg(zzaygVar);
                zzayoVar.zzh(str3);
            }
        });
        return zzawzVar;
    }
}
