package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzddx implements zzgwe {
    private final zzddr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzddx(zzddr zzddrVar, zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4) {
        this.zza = zzddrVar;
        this.zzb = zzgwrVar;
        this.zzc = zzgwrVar2;
        this.zzd = zzgwrVar3;
        this.zze = zzgwrVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zzb.zzb();
        final zzbzx zza = ((zzchm) this.zzc).zza();
        final zzezn zza2 = ((zzcrt) this.zzd).zza();
        final zzfai zza3 = ((zzcux) this.zze).zza();
        return new zzdcm(new zzcwu() { // from class: com.google.android.gms.internal.ads.zzddq
            @Override // com.google.android.gms.internal.ads.zzcwu
            public final void zzn() {
                com.google.android.gms.ads.internal.zzt.zzs().zzn(context, zza.zza, zza2.zzD.toString(), zza3.zzf);
            }
        }, zzcae.zzf);
    }
}
