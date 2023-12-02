package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzws extends zzwu implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzws(int i4, zzcy zzcyVar, int i5, zzwm zzwmVar, int i6, @Nullable String str) {
        super(i4, zzcyVar, i5);
        boolean z3;
        boolean z4;
        zzfsc zzfscVar;
        int i7;
        boolean z5;
        boolean z6;
        int i8 = 0;
        this.zzf = zzwy.zzn(i6, false);
        int i9 = this.zzd.zze;
        int i10 = zzwmVar.zzy;
        if (1 != (i9 & 1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.zzg = z3;
        if ((i9 & 2) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzh = z4;
        if (zzwmVar.zzw.isEmpty()) {
            zzfscVar = zzfsc.zzm("");
        } else {
            zzfscVar = zzwmVar.zzw;
        }
        int i11 = 0;
        while (true) {
            if (i11 < zzfscVar.size()) {
                i7 = zzwy.zza(this.zzd, (String) zzfscVar.get(i11), false);
                if (i7 > 0) {
                    break;
                }
                i11++;
            } else {
                i11 = Integer.MAX_VALUE;
                i7 = 0;
                break;
            }
        }
        this.zzi = i11;
        this.zzj = i7;
        int i12 = this.zzd.zzf;
        int bitCount = Integer.bitCount(0);
        this.zzk = bitCount;
        int i13 = this.zzd.zzf;
        this.zzm = false;
        if (zzwy.zzg(str) == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        int zza = zzwy.zza(this.zzd, str, z5);
        this.zzl = zza;
        if (i7 <= 0 && ((!zzwmVar.zzw.isEmpty() || bitCount <= 0) && !this.zzg && (!this.zzh || zza <= 0))) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (zzwy.zzn(i6, zzwmVar.zzR) && z6) {
            i8 = 1;
        }
        this.zze = i8;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public final int compareTo(zzws zzwsVar) {
        zzftl zza;
        zzfrr zzd = zzfrr.zzj().zzd(this.zzf, zzwsVar.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzwsVar.zzi), zzftl.zzc().zza()).zzb(this.zzj, zzwsVar.zzj).zzb(this.zzk, zzwsVar.zzk).zzd(this.zzg, zzwsVar.zzg);
        Boolean valueOf = Boolean.valueOf(this.zzh);
        Boolean valueOf2 = Boolean.valueOf(zzwsVar.zzh);
        if (this.zzj == 0) {
            zza = zzftl.zzc();
        } else {
            zza = zzftl.zzc().zza();
        }
        zzfrr zzb = zzd.zzc(valueOf, valueOf2, zza).zzb(this.zzl, zzwsVar.zzl);
        if (this.zzk == 0) {
            zzb = zzb.zze(false, false);
        }
        return zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final /* bridge */ /* synthetic */ boolean zzc(zzwu zzwuVar) {
        zzws zzwsVar = (zzws) zzwuVar;
        return false;
    }
}
