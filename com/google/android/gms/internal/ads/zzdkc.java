package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdkc implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;
    private final zzgwr zzl;
    private final zzgwr zzm;
    private final zzgwr zzn;
    private final zzgwr zzo;
    private final zzgwr zzp;
    private final zzgwr zzq;

    public zzdkc(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4, zzgwr zzgwrVar5, zzgwr zzgwrVar6, zzgwr zzgwrVar7, zzgwr zzgwrVar8, zzgwr zzgwrVar9, zzgwr zzgwrVar10, zzgwr zzgwrVar11, zzgwr zzgwrVar12, zzgwr zzgwrVar13, zzgwr zzgwrVar14, zzgwr zzgwrVar15, zzgwr zzgwrVar16, zzgwr zzgwrVar17) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
        this.zzd = zzgwrVar4;
        this.zze = zzgwrVar5;
        this.zzf = zzgwrVar6;
        this.zzg = zzgwrVar7;
        this.zzh = zzgwrVar8;
        this.zzi = zzgwrVar9;
        this.zzj = zzgwrVar10;
        this.zzk = zzgwrVar11;
        this.zzl = zzgwrVar12;
        this.zzm = zzgwrVar13;
        this.zzn = zzgwrVar14;
        this.zzo = zzgwrVar15;
        this.zzp = zzgwrVar16;
        this.zzq = zzgwrVar17;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zza */
    public final zzdkb zzb() {
        Context context = (Context) this.zza.zzb();
        zzdjk zzdjkVar = (zzdjk) this.zzb.zzb();
        zzaqs zzaqsVar = (zzaqs) this.zzc.zzb();
        zzbzx zza = ((zzchm) this.zzd).zza();
        com.google.android.gms.ads.internal.zza zza2 = com.google.android.gms.ads.internal.zza.zza();
        zzawz zzawzVar = (zzawz) this.zzf.zzb();
        zzfwn zzfwnVar = zzcae.zza;
        zzgwm.zzb(zzfwnVar);
        return new zzdkb(context, zzdjkVar, zzaqsVar, zza, zza2, zzawzVar, zzfwnVar, ((zzcux) this.zzh).zza(), (zzdkt) this.zzi.zzb(), (zzdni) this.zzj.zzb(), (ScheduledExecutorService) this.zzk.zzb(), (zzdqa) this.zzl.zzb(), (zzfev) this.zzm.zzb(), (zzfgr) this.zzn.zzb(), (zzeba) this.zzo.zzb(), (zzdmd) this.zzp.zzb(), (zzebl) this.zzq.zzb());
    }
}
