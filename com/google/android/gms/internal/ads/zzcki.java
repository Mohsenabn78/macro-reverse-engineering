package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcki implements zzext {
    private final zzciq zza;
    private final zzcki zzb = this;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcki(zzciq zzciqVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzckh zzckhVar) {
        zzgwr zzgwrVar;
        zzgwr zzgwrVar2;
        zzgwr zzgwrVar3;
        zzgwr zzgwrVar4;
        zzgwr zzgwrVar5;
        zzgwr zzgwrVar6;
        zzgwr zzgwrVar7;
        this.zza = zzciqVar;
        zzgwe zza = zzgwf.zza(context);
        this.zzc = zza;
        zzgwe zza2 = zzgwf.zza(zzqVar);
        this.zzd = zza2;
        zzgwe zza3 = zzgwf.zza(str);
        this.zze = zza3;
        zzgwrVar = zzciqVar.zzn;
        zzgwr zzc = zzgwd.zzc(new zzejn(zzgwrVar));
        this.zzf = zzc;
        zzgwrVar2 = zzciqVar.zzaE;
        zzgwr zzc2 = zzgwd.zzc(new zzeyr(zzgwrVar2));
        this.zzg = zzc2;
        zzgwrVar3 = zzciqVar.zzo;
        zzgwrVar4 = zzciqVar.zzU;
        zzgwr zzc3 = zzgwd.zzc(new zzexr(zza, zzgwrVar3, zzgwrVar4, zzc, zzc2, zzfak.zza()));
        this.zzh = zzc3;
        zzgwrVar5 = zzciqVar.zzh;
        zzgwrVar6 = zzciqVar.zzV;
        zzgwrVar7 = zzciqVar.zzZ;
        this.zzi = zzgwd.zzc(new zzejv(zza, zza2, zza3, zzc3, zzc, zzc2, zzgwrVar5, zzgwrVar6, zzgwrVar7));
    }

    @Override // com.google.android.gms.internal.ads.zzext
    public final zzeju zza() {
        return (zzeju) this.zzi.zzb();
    }
}
