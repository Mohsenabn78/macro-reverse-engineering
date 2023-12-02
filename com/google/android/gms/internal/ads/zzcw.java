package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.android.dx.io.Opcodes;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzcw {
    public static final zzcw zza = new zzcr();
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcq
    };

    public final boolean equals(@Nullable Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcw)) {
            return false;
        }
        zzcw zzcwVar = (zzcw) obj;
        if (zzcwVar.zzc() == zzc() && zzcwVar.zzb() == zzb()) {
            zzcv zzcvVar = new zzcv();
            zzct zzctVar = new zzct();
            zzcv zzcvVar2 = new zzcv();
            zzct zzctVar2 = new zzct();
            for (int i4 = 0; i4 < zzc(); i4++) {
                if (!zze(i4, zzcvVar, 0L).equals(zzcwVar.zze(i4, zzcvVar2, 0L))) {
                    return false;
                }
            }
            for (int i5 = 0; i5 < zzb(); i5++) {
                if (!zzd(i5, zzctVar, true).equals(zzcwVar.zzd(i5, zzctVar2, true))) {
                    return false;
                }
            }
            int zzg = zzg(true);
            if (zzg == zzcwVar.zzg(true) && (zzh = zzh(true)) == zzcwVar.zzh(true)) {
                while (zzg != zzh) {
                    int zzj = zzj(zzg, 0, true);
                    if (zzj != zzcwVar.zzj(zzg, 0, true)) {
                        return false;
                    }
                    zzg = zzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        zzcv zzcvVar = new zzcv();
        zzct zzctVar = new zzct();
        int zzc2 = zzc() + Opcodes.RSUB_INT_LIT8;
        for (int i4 = 0; i4 < zzc(); i4++) {
            zzc2 = (zzc2 * 31) + zze(i4, zzcvVar, 0L).hashCode();
        }
        int zzb2 = (zzc2 * 31) + zzb();
        for (int i5 = 0; i5 < zzb(); i5++) {
            zzb2 = (zzb2 * 31) + zzd(i5, zzctVar, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb2 = (zzb2 * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb2;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzct zzd(int i4, zzct zzctVar, boolean z3);

    public abstract zzcv zze(int i4, zzcv zzcvVar, long j4);

    public abstract Object zzf(int i4);

    public int zzg(boolean z3) {
        if (zzo()) {
            return -1;
        }
        return 0;
    }

    public int zzh(boolean z3) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i4, zzct zzctVar, zzcv zzcvVar, int i5, boolean z3) {
        int i6 = zzd(i4, zzctVar, false).zzd;
        if (zze(i6, zzcvVar, 0L).zzp == i4) {
            int zzj = zzj(i6, i5, z3);
            if (zzj == -1) {
                return -1;
            }
            return zze(zzj, zzcvVar, 0L).zzo;
        }
        return i4 + 1;
    }

    public int zzj(int i4, int i5, boolean z3) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    if (i4 == zzh(z3)) {
                        return zzg(z3);
                    }
                    return i4 + 1;
                }
                throw new IllegalStateException();
            }
            return i4;
        } else if (i4 == zzh(z3)) {
            return -1;
        } else {
            return i4 + 1;
        }
    }

    public int zzk(int i4, int i5, boolean z3) {
        if (i4 == zzg(false)) {
            return -1;
        }
        return i4 - 1;
    }

    public final Pair zzl(zzcv zzcvVar, zzct zzctVar, int i4, long j4) {
        Pair zzm = zzm(zzcvVar, zzctVar, i4, j4, 0L);
        zzm.getClass();
        return zzm;
    }

    @Nullable
    public final Pair zzm(zzcv zzcvVar, zzct zzctVar, int i4, long j4, long j5) {
        zzdy.zza(i4, 0, zzc());
        zze(i4, zzcvVar, j5);
        if (j4 == -9223372036854775807L) {
            long j6 = zzcvVar.zzm;
            j4 = 0;
        }
        int i5 = zzcvVar.zzo;
        zzd(i5, zzctVar, false);
        while (i5 < zzcvVar.zzp) {
            long j7 = zzctVar.zzf;
            int i6 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i6 == 0) {
                break;
            }
            int i7 = i5 + 1;
            long j8 = zzd(i7, zzctVar, false).zzf;
            if (i6 < 0) {
                break;
            }
            i5 = i7;
        }
        zzd(i5, zzctVar, true);
        long j9 = zzctVar.zzf;
        long j10 = zzctVar.zze;
        if (j10 != -9223372036854775807L) {
            j4 = Math.min(j4, j10 - 1);
        }
        long max = Math.max(0L, j4);
        Object obj = zzctVar.zzc;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public zzct zzn(Object obj, zzct zzctVar) {
        return zzd(zza(obj), zzctVar, true);
    }

    public final boolean zzo() {
        if (zzc() == 0) {
            return true;
        }
        return false;
    }
}
