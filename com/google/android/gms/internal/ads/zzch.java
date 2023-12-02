package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzch {
    public final float zzc;
    public final float zzd;
    private final int zzg;
    public static final zzch zza = new zzch(1.0f, 1.0f);
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcg
    };

    public zzch(@FloatRange(from = 0.0d, fromInclusive = false) float f4, @FloatRange(from = 0.0d, fromInclusive = false) float f5) {
        boolean z3;
        if (f4 > 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        zzdy.zzd(f5 > 0.0f);
        this.zzc = f4;
        this.zzd = f5;
        this.zzg = Math.round(f4 * 1000.0f);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzch.class == obj.getClass()) {
            zzch zzchVar = (zzch) obj;
            if (this.zzc == zzchVar.zzc && this.zzd == zzchVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzc) + 527) * 31) + Float.floatToRawIntBits(this.zzd);
    }

    public final String toString() {
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.zzc), Float.valueOf(this.zzd));
    }

    public final long zza(long j4) {
        return j4 * this.zzg;
    }
}
