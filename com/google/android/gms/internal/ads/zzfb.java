package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfb {
    public static final zzfb zza = new zzfb(-1, -1);
    public static final zzfb zzb = new zzfb(0, 0);
    private final int zzc;
    private final int zzd;

    public zzfb(int i4, int i5) {
        boolean z3 = false;
        if ((i4 == -1 || i4 >= 0) && (i5 == -1 || i5 >= 0)) {
            z3 = true;
        }
        zzdy.zzd(z3);
        this.zzc = i4;
        this.zzd = i5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfb) {
            zzfb zzfbVar = (zzfb) obj;
            if (this.zzc == zzfbVar.zzc && this.zzd == zzfbVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zzd;
        int i5 = this.zzc;
        return i4 ^ ((i5 >>> 16) | (i5 << 16));
    }

    public final String toString() {
        int i4 = this.zzc;
        int i5 = this.zzd;
        return i4 + "x" + i5;
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzc;
    }
}
