package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcii extends zzesf {
    private final zzetl zza;
    private final zzciq zzb;
    private final zzcii zzc = this;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcii(zzciq zzciqVar, zzetl zzetlVar, zzcih zzcihVar) {
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzgwr zzgwrVar3;
        this.zzb = zzciqVar;
        this.zza = zzetlVar;
        zzetn zzetnVar = new zzetn(zzetlVar);
        this.zzd = zzetnVar;
        zzgwr zzc = zzgwd.zzc(zzdoz.zza());
        this.zze = zzc;
        zzgwr zzc2 = zzgwd.zzc(zzdox.zza());
        this.zzf = zzc2;
        zzgwr zzc3 = zzgwd.zzc(zzdpb.zza());
        this.zzg = zzc3;
        zzgwr zzc4 = zzgwd.zzc(zzdpd.zza());
        this.zzh = zzc4;
        zzgwh zzc5 = zzgwi.zzc(4);
        zzc5.zzb(zzfef.GMS_SIGNALS, zzc);
        zzc5.zzb(zzfef.BUILD_URL, zzc2);
        zzc5.zzb(zzfef.HTTP, zzc3);
        zzc5.zzb(zzfef.PRE_PROCESS, zzc4);
        zzgwi zzc6 = zzc5.zzc();
        this.zzi = zzc6;
        zzgwrVar = zzciqVar.zzg;
        zzgwr zzc7 = zzgwd.zzc(new zzdpe(zzetnVar, zzgwrVar, zzfdg.zza(), zzc6));
        this.zzj = zzc7;
        zzgwo zza = zzgwp.zza(0, 1);
        zza.zza(zzc7);
        zzgwp zzc8 = zza.zzc();
        this.zzk = zzc8;
        zzfeo zzfeoVar = new zzfeo(zzc8);
        this.zzl = zzfeoVar;
        zzfdg zza2 = zzfdg.zza();
        zzgwrVar2 = zzciqVar.zzm;
        this.zzm = zzgwd.zzc(new zzfen(zza2, zzgwrVar2, zzfeoVar));
        zzgwrVar3 = zzciqVar.zzG;
        this.zzn = zzgwd.zzc(new zzffz(zzgwrVar3));
    }

    @Override // com.google.android.gms.internal.ads.zzesf
    public final zzerb zza() {
        zzcgx zzcgxVar;
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzcgxVar = this.zzb.zza;
        Context zza = zzcgxVar.zza();
        zzgwm.zzb(zza);
        zzbyo zzbyoVar = new zzbyo();
        zzfwn zzfwnVar = zzcae.zza;
        zzgwm.zzb(zzfwnVar);
        zzetf zzetfVar = new zzetf(zzbyoVar, zzfwnVar, zzetm.zza(this.zza));
        zzgwm.zzb(zzfwnVar);
        zzgwrVar = this.zzb.zzm;
        zzffy zzffyVar = (zzffy) this.zzn.zzb();
        zzgwrVar2 = this.zzb.zzZ;
        zzdqa zzdqaVar = (zzdqa) zzgwrVar2.zzb();
        HashSet hashSet = new HashSet();
        hashSet.add(new zzepg(zzetfVar, 0L, (ScheduledExecutorService) zzgwrVar.zzb()));
        return new zzerb(zza, zzfwnVar, hashSet, zzffyVar, zzdqaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesf
    public final zzfel zzb() {
        return (zzfel) this.zzm.zzb();
    }
}
