package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzaj extends zzd {
    private final zzaj zza = this;
    private final zzcl<Application> zzb;
    private final zzcl<zzam> zzc;
    private final zzcl<zzac> zzd;
    private final zzcl<zzas> zze;
    private final zzcl<zzba> zzf;
    private final zzcl<zzb> zzg;
    private final zzcl<zzn> zzh;
    private final zzcl<zzh> zzi;
    private final zzcl<zzak> zzj;
    private final zzcl<zzz> zzk;
    private final zzcl<zzv> zzl;
    private final zzcl<zzk> zzm;

    public /* synthetic */ zzaj(Application application, zzaf zzafVar) {
        zzae zzaeVar;
        zzar zzarVar;
        zzar zzarVar2;
        zzap zzapVar;
        zzar zzarVar3;
        zzch zza = zzci.zza(application);
        this.zzb = zza;
        zzcl<zzam> zza2 = zzcg.zza(new zzan(zza));
        this.zzc = zza2;
        zzaeVar = zzad.zza;
        zzcl<zzac> zza3 = zzcg.zza(zzaeVar);
        this.zzd = zza3;
        zzaf zzafVar2 = new zzaf(this);
        this.zze = zzafVar2;
        zzcl<zzba> zza4 = zzcg.zza(new zzbb(zzafVar2));
        this.zzf = zza4;
        zzc zzcVar = new zzc(zza);
        this.zzg = zzcVar;
        zzp zzpVar = new zzp(zza, zzcVar, zza2);
        this.zzh = zzpVar;
        zzarVar = zzaq.zza;
        zzcl<zzh> zza5 = zzcg.zza(new zzi(zzarVar));
        this.zzi = zza5;
        zzarVar2 = zzaq.zza;
        zzal zzalVar = new zzal(zza, zza2, zzarVar2);
        this.zzj = zzalVar;
        zzab zzabVar = new zzab(zza5, zzalVar, zza2);
        this.zzk = zzabVar;
        zzapVar = zzao.zza;
        zzarVar3 = zzaq.zza;
        zzw zzwVar = new zzw(zza, zza3, zzapVar, zzarVar3, zza2, zza4, zzpVar, zzabVar, zza5);
        this.zzl = zzwVar;
        this.zzm = zzcg.zza(new zzl(zza2, zzwVar, zza4));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final zzk zzb() {
        return this.zzm.zzb();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final zzba zzc() {
        return this.zzf.zzb();
    }
}
