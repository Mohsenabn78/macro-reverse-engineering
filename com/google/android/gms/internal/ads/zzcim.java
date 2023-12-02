package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcim extends zzesh {
    private final zzerv zza;
    private final zzciq zzb;
    private final zzcim zzc = this;
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
    public /* synthetic */ zzcim(zzciq zzciqVar, zzerv zzervVar, zzcil zzcilVar) {
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzgwr zzgwrVar3;
        this.zzb = zzciqVar;
        this.zza = zzervVar;
        zzgwrVar = zzciqVar.zzG;
        this.zzd = zzgwd.zzc(new zzffz(zzgwrVar));
        zzesd zzesdVar = new zzesd(zzervVar);
        this.zze = zzesdVar;
        zzgwr zzc = zzgwd.zzc(zzdoz.zza());
        this.zzf = zzc;
        zzgwr zzc2 = zzgwd.zzc(zzdox.zza());
        this.zzg = zzc2;
        zzgwr zzc3 = zzgwd.zzc(zzdpb.zza());
        this.zzh = zzc3;
        zzgwr zzc4 = zzgwd.zzc(zzdpd.zza());
        this.zzi = zzc4;
        zzgwh zzc5 = zzgwi.zzc(4);
        zzc5.zzb(zzfef.GMS_SIGNALS, zzc);
        zzc5.zzb(zzfef.BUILD_URL, zzc2);
        zzc5.zzb(zzfef.HTTP, zzc3);
        zzc5.zzb(zzfef.PRE_PROCESS, zzc4);
        zzgwi zzc6 = zzc5.zzc();
        this.zzj = zzc6;
        zzgwrVar2 = zzciqVar.zzg;
        zzgwr zzc7 = zzgwd.zzc(new zzdpe(zzesdVar, zzgwrVar2, zzfdg.zza(), zzc6));
        this.zzk = zzc7;
        zzgwo zza = zzgwp.zza(0, 1);
        zza.zza(zzc7);
        zzgwp zzc8 = zza.zzc();
        this.zzl = zzc8;
        zzfeo zzfeoVar = new zzfeo(zzc8);
        this.zzm = zzfeoVar;
        zzfdg zza2 = zzfdg.zza();
        zzgwrVar3 = zzciqVar.zzm;
        this.zzn = zzgwd.zzc(new zzfen(zza2, zzgwrVar3, zzfeoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzesh
    public final zzerb zza() {
        zzcgx zzcgxVar;
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzcgx zzcgxVar2;
        zzgwr zzgwrVar3;
        zzcgx zzcgxVar3;
        zzgwr zzgwrVar4;
        zzgwr zzgwrVar5;
        zzgwr zzgwrVar6;
        zzcgx zzcgxVar4;
        zzcgx zzcgxVar5;
        zzcgx zzcgxVar6;
        zzgwr zzgwrVar7;
        zzgwr zzgwrVar8;
        zzgwr zzgwrVar9;
        zzgwr zzgwrVar10;
        zzgwr zzgwrVar11;
        zzgwr zzgwrVar12;
        zzcgxVar = this.zzb.zza;
        Context zza = zzcgxVar.zza();
        zzgwm.zzb(zza);
        zzfwn zzfwnVar = zzcae.zza;
        zzgwm.zzb(zzfwnVar);
        zzbyo zzbyoVar = new zzbyo();
        zzgwm.zzb(zzfwnVar);
        zzetf zzetfVar = new zzetf(zzbyoVar, zzfwnVar, zzerw.zza(this.zza));
        zzeoy zza2 = zzepa.zza();
        zzgwrVar = this.zzb.zzm;
        zzeqy zza3 = zzeub.zza(zzetfVar, zza2, (ScheduledExecutorService) zzgwrVar.zzb(), 0);
        zzbrx zzbrxVar = new zzbrx();
        zzgwrVar2 = this.zzb.zzm;
        zzcgxVar2 = this.zzb.zza;
        Context zza4 = zzcgxVar2.zza();
        zzgwm.zzb(zza4);
        zzetp zzetpVar = new zzetp(zzbrxVar, (ScheduledExecutorService) zzgwrVar2.zzb(), zza4);
        zzgwrVar3 = this.zzb.zzm;
        zzeqy zzb = zzeub.zzb(zzetpVar, (ScheduledExecutorService) zzgwrVar3.zzb());
        zzbyr zzbyrVar = new zzbyr();
        zzcgxVar3 = this.zzb.zza;
        Context zza5 = zzcgxVar3.zza();
        zzgwm.zzb(zza5);
        zzgwrVar4 = this.zzb.zzm;
        zzgwm.zzb(zzfwnVar);
        zzern zza6 = zzerp.zza(zzbyrVar, zza5, (ScheduledExecutorService) zzgwrVar4.zzb(), zzfwnVar, zzerx.zza(this.zza), zzerz.zza(this.zza), zzesa.zza(this.zza));
        zzgwrVar5 = this.zzb.zzm;
        zzeqy zza7 = zzeuc.zza(zza6, (ScheduledExecutorService) zzgwrVar5.zzb());
        zzgwm.zzb(zzfwnVar);
        zzeuk zzeukVar = new zzeuk(zzfwnVar);
        zzgwrVar6 = this.zzb.zzm;
        zzeqy zzc = zzeub.zzc(zzeukVar, (ScheduledExecutorService) zzgwrVar6.zzb());
        zzetz zzetzVar = zzetz.zza;
        zzcgxVar4 = this.zzb.zza;
        Context zza8 = zzcgxVar4.zza();
        zzgwm.zzb(zza8);
        String zza9 = zzerw.zza(this.zza);
        zzgwm.zzb(zzfwnVar);
        zzesj zzesjVar = new zzesj(null, zza8, zza9, zzfwnVar);
        zzawo zzawoVar = new zzawo();
        zzgwm.zzb(zzfwnVar);
        zzcgxVar5 = this.zzb.zza;
        Context zza10 = zzcgxVar5.zza();
        zzgwm.zzb(zza10);
        zzbax zzbaxVar = new zzbax();
        zzgwm.zzb(zzfwnVar);
        zzbyr zzbyrVar2 = new zzbyr();
        zzgwm.zzb(zzfwnVar);
        zzbyr zzbyrVar3 = new zzbyr();
        int zza11 = zzerx.zza(this.zza);
        zzcgxVar6 = this.zzb.zza;
        Context zza12 = zzcgxVar6.zza();
        zzgwm.zzb(zza12);
        zzgwrVar7 = this.zzb.zzag;
        zzbza zzbzaVar = (zzbza) zzgwrVar7.zzb();
        zzgwrVar8 = this.zzb.zzm;
        zzgwm.zzb(zzfwnVar);
        zzgwrVar9 = this.zzb.zzaI;
        String zza13 = zzerw.zza(this.zza);
        zzawc zzawcVar = new zzawc();
        zzgwrVar10 = this.zzb.zzag;
        zzgwrVar11 = this.zzb.zzm;
        zzgwm.zzb(zzfwnVar);
        zzfsh zzp = zzfsh.zzp(zza3, zzb, zza7, zzc, zzetzVar, zzesjVar, new zzesy(zzawoVar, zzfwnVar, zza10), new zzetj(zzbaxVar, zzfwnVar, zzery.zza(this.zza)), new zzert(zzbyrVar2, zzfwnVar, zzesb.zza(this.zza), zzesc.zza(this.zza), zzerx.zza(this.zza)), new zzesu(zzbyrVar3, zza11, zza12, zzbzaVar, (ScheduledExecutorService) zzgwrVar8.zzb(), zzfwnVar, zzerw.zza(this.zza)), (zzeqy) zzgwrVar9.zzb(), zzesq.zza(zza13, zzawcVar, (zzbza) zzgwrVar10.zzb(), (ScheduledExecutorService) zzgwrVar11.zzb(), zzfwnVar));
        zzffy zzffyVar = (zzffy) this.zzd.zzb();
        zzgwrVar12 = this.zzb.zzZ;
        return new zzerb(zza, zzfwnVar, zzp, zzffyVar, (zzdqa) zzgwrVar12.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzesh
    public final zzfel zzb() {
        return (zzfel) this.zzn.zzb();
    }
}
