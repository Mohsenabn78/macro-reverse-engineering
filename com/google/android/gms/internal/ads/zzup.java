package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzup {
    public final int zza;
    public final boolean zzb;

    public zzup(int i4, boolean z3) {
        this.zza = i4;
        this.zzb = z3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzup.class == obj.getClass()) {
            zzup zzupVar = (zzup) obj;
            if (this.zza == zzupVar.zza && this.zzb == zzupVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
