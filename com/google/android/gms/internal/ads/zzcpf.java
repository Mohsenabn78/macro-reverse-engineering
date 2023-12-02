package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcpf implements zzgwe {
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

    public zzcpf(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3, zzgwr zzgwrVar4, zzgwr zzgwrVar5, zzgwr zzgwrVar6, zzgwr zzgwrVar7, zzgwr zzgwrVar8, zzgwr zzgwrVar9, zzgwr zzgwrVar10) {
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
    }

    public static zzcpe zzc(zzcrc zzcrcVar, Context context, zzezo zzezoVar, View view, zzcez zzcezVar, zzcrb zzcrbVar, zzdhl zzdhlVar, zzdcw zzdcwVar, zzgvy zzgvyVar, Executor executor) {
        return new zzcpe(zzcrcVar, context, zzezoVar, view, zzcezVar, zzcrbVar, zzdhlVar, zzdcwVar, zzgvyVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zza */
    public final zzcpe zzb() {
        return new zzcpe(((zzctc) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcpl) this.zzc).zza(), ((zzcpk) this.zzd).zza(), ((zzcpw) this.zze).zza(), ((zzcpm) this.zzf).zza(), ((zzdfi) this.zzg).zza(), (zzdcw) this.zzh.zzb(), zzgwd.zza(this.zzi), (Executor) this.zzj.zzb());
    }
}
