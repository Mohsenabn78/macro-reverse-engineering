package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbxd extends zzbxx {
    private final Clock zzb;
    private final zzbxd zzc = this;
    private final zzgwr zzd;
    private final zzgwr zze;
    private final zzgwr zzf;
    private final zzgwr zzg;
    private final zzgwr zzh;
    private final zzgwr zzi;
    private final zzgwr zzj;
    private final zzgwr zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbxd(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbxw zzbxwVar, zzbxc zzbxcVar) {
        this.zzb = clock;
        zzgwe zza = zzgwf.zza(context);
        this.zzd = zza;
        zzgwe zza2 = zzgwf.zza(zzgVar);
        this.zze = zza2;
        zzgwe zza3 = zzgwf.zza(zzbxwVar);
        this.zzf = zza3;
        this.zzg = zzgwd.zzc(new zzbwv(zza, zza2, zza3));
        zzgwe zza4 = zzgwf.zza(clock);
        this.zzh = zza4;
        zzgwr zzc = zzgwd.zzc(new zzbwx(zza4, zza2, zza3));
        this.zzi = zzc;
        zzbwz zzbwzVar = new zzbwz(zza4, zzc);
        this.zzj = zzbwzVar;
        this.zzk = zzgwd.zzc(new zzbyc(zza, zzbwzVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbxx
    final zzbwu zza() {
        return (zzbwu) this.zzg.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbxx
    public final zzbwy zzb() {
        return new zzbwy(this.zzb, (zzbww) this.zzi.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbxx
    final zzbyb zzc() {
        return (zzbyb) this.zzk.zzb();
    }
}
