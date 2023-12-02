package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcja implements zzeuo {
    private final zzciq zza;
    private final zzcja zzb = this;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcja(zzciq zzciqVar, Context context, String str, zzciz zzcizVar) {
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzgwr zzgwrVar3;
        zzgwr zzgwrVar4;
        zzgwr zzgwrVar5;
        zzgwr zzgwrVar6;
        zzgwr zzgwrVar7;
        zzgwr zzgwrVar8;
        zzgwr zzgwrVar9;
        this.zza = zzciqVar;
        zzgwe zza = zzgwf.zza(context);
        this.zzc = zza;
        zzgwe zza2 = zzgwf.zza(str);
        this.zzd = zza2;
        zzgwrVar = zzciqVar.zzaE;
        zzgwrVar2 = zzciqVar.zzaF;
        zzexg zzexgVar = new zzexg(zza, zzgwrVar, zzgwrVar2);
        this.zze = zzexgVar;
        zzgwrVar3 = zzciqVar.zzaE;
        zzgwr zzc = zzgwd.zzc(new zzevm(zzgwrVar3));
        this.zzf = zzc;
        zzgwrVar4 = zzciqVar.zzo;
        zzgwrVar5 = zzciqVar.zzU;
        zzfak zza3 = zzfak.zza();
        zzgwrVar6 = zzciqVar.zzh;
        zzgwr zzc2 = zzgwd.zzc(new zzevo(zza, zzgwrVar4, zzgwrVar5, zzexgVar, zzc, zza3, zzgwrVar6));
        this.zzg = zzc2;
        zzgwrVar7 = zzciqVar.zzU;
        zzgwrVar8 = zzciqVar.zzh;
        zzgwrVar9 = zzciqVar.zzZ;
        this.zzh = zzgwd.zzc(new zzevu(zzgwrVar7, zza, zza2, zzc2, zzc, zzgwrVar8, zzgwrVar9));
    }

    @Override // com.google.android.gms.internal.ads.zzeuo
    public final zzevt zza() {
        return (zzevt) this.zzh.zzb();
    }
}
