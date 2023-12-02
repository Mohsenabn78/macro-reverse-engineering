package com.google.android.recaptcha.internal;

import androidx.compose.animation.core.AnimationKt;
import org.threeten.bp.Year;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzjy {
    public static final zzfw zza;
    public static final zzfw zzb;
    public static final zzfw zzc;

    static {
        zzfv zzi = zzfw.zzi();
        zzi.zze(-315576000000L);
        zzi.zzd(Year.MIN_VALUE);
        zza = (zzfw) zzi.zzj();
        zzfv zzi2 = zzfw.zzi();
        zzi2.zze(315576000000L);
        zzi2.zzd(Year.MAX_VALUE);
        zzb = (zzfw) zzi2.zzj();
        zzfv zzi3 = zzfw.zzi();
        zzi3.zze(0L);
        zzi3.zzd(0);
        zzc = (zzfw) zzi3.zzj();
    }

    public static zzfw zza(long j4) {
        return zzc(j4 / 1000, (int) ((j4 % 1000) * AnimationKt.MillisToNanos));
    }

    public static zzfw zzb(long j4) {
        return zzc(j4 / 1000000000, (int) (j4 % 1000000000));
    }

    static zzfw zzc(long j4, int i4) {
        int i5;
        if (i4 <= -1000000000 || i4 >= 1000000000) {
            j4 = zzee.zza(j4, i4 / 1000000000);
            i4 %= 1000000000;
        }
        if (j4 > 0 && i4 < 0) {
            i4 += 1000000000;
            j4--;
        }
        if (j4 < 0 && i4 > 0) {
            i4 -= 1000000000;
            j4++;
        }
        zzfv zzi = zzfw.zzi();
        zzi.zze(j4);
        zzi.zzd(i4);
        zzfw zzfwVar = (zzfw) zzi.zzj();
        long zzg = zzfwVar.zzg();
        int zzf = zzfwVar.zzf();
        if (zzg >= -315576000000L && zzg <= 315576000000L && zzf >= -999999999 && zzf < 1000000000 && ((zzg >= 0 && zzf >= 0) || (i5 <= 0 && zzf <= 0))) {
            return zzfwVar;
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(zzg), Integer.valueOf(zzf)));
    }
}
