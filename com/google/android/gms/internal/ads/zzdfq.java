package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdfq implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;

    public zzdfq(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4, zzgwr zzgwrVar5, zzgwr zzgwrVar6) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
        this.zzd = zzgwrVar4;
        this.zze = zzgwrVar5;
        this.zzf = zzgwrVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcuo zza = ((zzcuy) this.zzb).zza();
        zzdat zza2 = ((zzdbm) this.zzc).zza();
        zzdff zza3 = ((zzdfh) this.zzd).zza();
        zzcxv zzb = ((zzcpa) this.zze).zzb();
        zzefr zzefrVar = (zzefr) this.zzf.zzb();
        zzcpx zzd = ((zzcgu) this.zza.zzb()).zzd();
        zzd.zzi(zza.zzj());
        zzd.zzf(zza2);
        zzd.zzd(zza3);
        zzd.zze(new zzehv(null));
        zzd.zzg(new zzcqv(zzb, null));
        zzd.zzc(new zzcoy(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdm)).booleanValue()) {
            zzd.zzj(zzefy.zzb(zzefrVar));
        }
        zzcrg zzc = zzd.zzk().zzc();
        zzgwm.zzb(zzc);
        return zzc;
    }
}
