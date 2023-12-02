package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzwx extends zzwu {
    private final boolean zze;
    private final zzwm zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:139:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzwx(int r5, com.google.android.gms.internal.ads.zzcy r6, int r7, com.google.android.gms.internal.ads.zzwm r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwx.<init>(int, com.google.android.gms.internal.ads.zzcy, int, com.google.android.gms.internal.ads.zzwm, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzwx zzwxVar, zzwx zzwxVar2) {
        zzftl zzftlVar;
        zzftl zza;
        zzftl zzftlVar2;
        if (!zzwxVar.zze || !zzwxVar.zzh) {
            zzftlVar = zzwy.zzc;
            zza = zzftlVar.zza();
        } else {
            zza = zzwy.zzc;
        }
        zzfrr zzj = zzfrr.zzj();
        Integer valueOf = Integer.valueOf(zzwxVar.zzi);
        Integer valueOf2 = Integer.valueOf(zzwxVar2.zzi);
        boolean z3 = zzwxVar.zzf.zzA;
        zzftlVar2 = zzwy.zzd;
        return zzj.zzc(valueOf, valueOf2, zzftlVar2).zzc(Integer.valueOf(zzwxVar.zzj), Integer.valueOf(zzwxVar2.zzj), zza).zzc(Integer.valueOf(zzwxVar.zzi), Integer.valueOf(zzwxVar2.zzi), zza).zza();
    }

    public static /* synthetic */ int zzd(zzwx zzwxVar, zzwx zzwxVar2) {
        zzfrr zzc = zzfrr.zzj().zzd(zzwxVar.zzh, zzwxVar2.zzh).zzb(zzwxVar.zzl, zzwxVar2.zzl).zzd(true, true).zzd(zzwxVar.zze, zzwxVar2.zze).zzd(zzwxVar.zzg, zzwxVar2.zzg).zzc(Integer.valueOf(zzwxVar.zzk), Integer.valueOf(zzwxVar2.zzk), zzftl.zzc().zza());
        boolean z3 = zzwxVar.zzo;
        zzfrr zzd = zzc.zzd(z3, zzwxVar2.zzo);
        boolean z4 = zzwxVar.zzp;
        zzfrr zzd2 = zzd.zzd(z4, zzwxVar2.zzp);
        if (z3 && z4) {
            zzd2 = zzd2.zzb(zzwxVar.zzq, zzwxVar2.zzq);
        }
        return zzd2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final int zzb() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final /* bridge */ /* synthetic */ boolean zzc(zzwu zzwuVar) {
        zzwx zzwxVar = (zzwx) zzwuVar;
        if (zzfj.zzC(this.zzd.zzm, zzwxVar.zzd.zzm)) {
            boolean z3 = this.zzf.zzK;
            if (this.zzo == zzwxVar.zzo && this.zzp == zzwxVar.zzp) {
                return true;
            }
            return false;
        }
        return false;
    }
}
