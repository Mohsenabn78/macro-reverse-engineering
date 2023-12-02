package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzkm {
    public final zztm zza;
    public final Object zzb;
    public final zzvf[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzkn zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzlk[] zzi;
    private final zzxg zzj;
    private final zzlb zzk;
    @Nullable
    private zzkm zzl;
    private zzvn zzm;
    private zzxh zzn;
    private long zzo;

    public zzkm(zzlk[] zzlkVarArr, long j4, zzxg zzxgVar, zzxp zzxpVar, zzlb zzlbVar, zzkn zzknVar, zzxh zzxhVar) {
        this.zzi = zzlkVarArr;
        this.zzo = j4;
        this.zzj = zzxgVar;
        this.zzk = zzlbVar;
        zzto zztoVar = zzknVar.zza;
        this.zzb = zztoVar.zza;
        this.zzf = zzknVar;
        this.zzm = zzvn.zza;
        this.zzn = zzxhVar;
        this.zzc = new zzvf[2];
        this.zzh = new boolean[2];
        long j5 = zzknVar.zzb;
        long j6 = zzknVar.zzd;
        zztm zzo = zzlbVar.zzo(zztoVar, zzxpVar, j5);
        this.zza = j6 != -9223372036854775807L ? new zzst(zzo, true, 0L, j6) : zzo;
    }

    private final void zzs() {
        if (zzu()) {
            int i4 = 0;
            while (true) {
                zzxh zzxhVar = this.zzn;
                if (i4 < zzxhVar.zza) {
                    zzxhVar.zzb(i4);
                    zzxa zzxaVar = this.zzn.zzc[i4];
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i4 = 0;
            while (true) {
                zzxh zzxhVar = this.zzn;
                if (i4 < zzxhVar.zza) {
                    zzxhVar.zzb(i4);
                    zzxa zzxaVar = this.zzn.zzc[i4];
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        if (this.zzl == null) {
            return true;
        }
        return false;
    }

    public final long zza(zzxh zzxhVar, long j4, boolean z3) {
        return zzb(zzxhVar, j4, false, new boolean[2]);
    }

    public final long zzb(zzxh zzxhVar, long j4, boolean z3, boolean[] zArr) {
        boolean z4;
        int i4 = 0;
        while (true) {
            boolean z5 = true;
            if (i4 >= zzxhVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z3 || !zzxhVar.zza(this.zzn, i4)) {
                z5 = false;
            }
            zArr2[i4] = z5;
            i4++;
        }
        int i5 = 0;
        while (true) {
            zzlk[] zzlkVarArr = this.zzi;
            if (i5 >= 2) {
                break;
            }
            zzlkVarArr[i5].zzb();
            i5++;
        }
        zzs();
        this.zzn = zzxhVar;
        zzt();
        long zzf = this.zza.zzf(zzxhVar.zzc, this.zzh, this.zzc, zArr, j4);
        int i6 = 0;
        while (true) {
            zzlk[] zzlkVarArr2 = this.zzi;
            if (i6 >= 2) {
                break;
            }
            zzlkVarArr2[i6].zzb();
            i6++;
        }
        this.zze = false;
        int i7 = 0;
        while (true) {
            zzvf[] zzvfVarArr = this.zzc;
            if (i7 < 2) {
                if (zzvfVarArr[i7] != null) {
                    zzdy.zzf(zzxhVar.zzb(i7));
                    this.zzi[i7].zzb();
                    this.zze = true;
                } else {
                    if (zzxhVar.zzc[i7] == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zzdy.zzf(z4);
                }
                i7++;
            } else {
                return zzf;
            }
        }
    }

    public final long zzc() {
        long j4;
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        if (this.zze) {
            j4 = this.zza.zzb();
        } else {
            j4 = Long.MIN_VALUE;
        }
        if (j4 == Long.MIN_VALUE) {
            return this.zzf.zze;
        }
        return j4;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0L;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    @Nullable
    public final zzkm zzg() {
        return this.zzl;
    }

    public final zzvn zzh() {
        return this.zzm;
    }

    public final zzxh zzi() {
        return this.zzn;
    }

    public final zzxh zzj(float f4, zzcw zzcwVar) throws zzih {
        zzxa[] zzxaVarArr;
        zzxh zzo = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzcwVar);
        for (zzxa zzxaVar : zzo.zzc) {
        }
        return zzo;
    }

    public final void zzk(long j4) {
        zzdy.zzf(zzu());
        this.zza.zzo(j4 - this.zzo);
    }

    public final void zzl(float f4, zzcw zzcwVar) throws zzih {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzxh zzj = zzj(f4, zzcwVar);
        zzkn zzknVar = this.zzf;
        long j4 = zzknVar.zzb;
        long j5 = zzknVar.zze;
        if (j5 != -9223372036854775807L && j4 >= j5) {
            j4 = Math.max(0L, j5 - 1);
        }
        long zza = zza(zzj, j4, false);
        long j6 = this.zzo;
        zzkn zzknVar2 = this.zzf;
        this.zzo = j6 + (zzknVar2.zzb - zza);
        this.zzf = zzknVar2.zzb(zza);
    }

    public final void zzm(long j4) {
        zzdy.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j4 - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzlb zzlbVar = this.zzk;
        zztm zztmVar = this.zza;
        try {
            if (zztmVar instanceof zzst) {
                zzlbVar.zzh(((zzst) zztmVar).zza);
            } else {
                zzlbVar.zzh(zztmVar);
            }
        } catch (RuntimeException e4) {
            zzer.zzd("MediaPeriodHolder", "Period release failed.", e4);
        }
    }

    public final void zzo(@Nullable zzkm zzkmVar) {
        if (zzkmVar == this.zzl) {
            return;
        }
        zzs();
        this.zzl = zzkmVar;
        zzt();
    }

    public final void zzp(long j4) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zztm zztmVar = this.zza;
        if (zztmVar instanceof zzst) {
            long j4 = this.zzf.zzd;
            if (j4 == -9223372036854775807L) {
                j4 = Long.MIN_VALUE;
            }
            ((zzst) zztmVar).zzn(0L, j4);
        }
    }

    public final boolean zzr() {
        if (!this.zzd) {
            return false;
        }
        if (this.zze && this.zza.zzb() != Long.MIN_VALUE) {
            return false;
        }
        return true;
    }
}
