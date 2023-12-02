package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabw {
    public static final zzabw zza = new zzabw(0, 0);
    public final long zzb;
    public final long zzc;

    public zzabw(long j4, long j5) {
        this.zzb = j4;
        this.zzc = j5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabw.class == obj.getClass()) {
            zzabw zzabwVar = (zzabw) obj;
            if (this.zzb == zzabwVar.zzb && this.zzc == zzabwVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        long j4 = this.zzb;
        long j5 = this.zzc;
        return "[timeUs=" + j4 + ", position=" + j5 + "]";
    }
}
