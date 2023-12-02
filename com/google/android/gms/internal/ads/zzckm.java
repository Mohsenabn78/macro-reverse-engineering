package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzckm implements zzezh {
    private final zzciq zza;
    private final zzckm zzb = this;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzckm(zzciq zzciqVar, Context context, String str, zzckl zzcklVar) {
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzgwr zzgwrVar3;
        zzgwr zzgwrVar4;
        zzgwr zzgwrVar5;
        zzgwr zzgwrVar6;
        zzgwr zzgwrVar7;
        zzgwr zzgwrVar8;
        this.zza = zzciqVar;
        zzgwe zza = zzgwf.zza(context);
        this.zzc = zza;
        zzgwrVar = zzciqVar.zzaE;
        zzgwrVar2 = zzciqVar.zzaF;
        zzexh zzexhVar = new zzexh(zza, zzgwrVar, zzgwrVar2);
        this.zzd = zzexhVar;
        zzgwrVar3 = zzciqVar.zzaE;
        zzgwr zzc = zzgwd.zzc(new zzeyr(zzgwrVar3));
        this.zze = zzc;
        zzgwr zzc2 = zzgwd.zzc(zzfaf.zza());
        this.zzf = zzc2;
        zzgwrVar4 = zzciqVar.zzo;
        zzgwrVar5 = zzciqVar.zzU;
        zzgwr zzc3 = zzgwd.zzc(new zzezb(zza, zzgwrVar4, zzgwrVar5, zzexhVar, zzc, zzfak.zza(), zzc2));
        this.zzg = zzc3;
        this.zzh = zzgwd.zzc(new zzezl(zzc3, zzc, zzc2));
        zzgwe zzc4 = zzgwf.zzc(str);
        this.zzi = zzc4;
        zzgwrVar6 = zzciqVar.zzh;
        zzgwrVar7 = zzciqVar.zzV;
        zzgwrVar8 = zzciqVar.zzZ;
        this.zzj = zzgwd.zzc(new zzezf(zzc4, zzc3, zza, zzc, zzc2, zzgwrVar6, zzgwrVar7, zzgwrVar8));
    }

    @Override // com.google.android.gms.internal.ads.zzezh
    public final zzeze zza() {
        return (zzeze) this.zzj.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzezh
    public final zzezk zzb() {
        return (zzezk) this.zzh.zzb();
    }
}
