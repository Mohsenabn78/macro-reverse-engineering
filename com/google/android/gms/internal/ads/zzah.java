package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzah {
    private final SparseBooleanArray zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        if (zzfj.zza < 24) {
            if (this.zza.size() != zzahVar.zza.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.zza.size(); i4++) {
                if (zza(i4) != zzahVar.zza(i4)) {
                    return false;
                }
            }
            return true;
        }
        return this.zza.equals(zzahVar.zza);
    }

    public final int hashCode() {
        if (zzfj.zza < 24) {
            int size = this.zza.size();
            for (int i4 = 0; i4 < this.zza.size(); i4++) {
                size = (size * 31) + zza(i4);
            }
            return size;
        }
        return this.zza.hashCode();
    }

    public final int zza(int i4) {
        zzdy.zza(i4, 0, this.zza.size());
        return this.zza.keyAt(i4);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i4) {
        return this.zza.get(i4);
    }
}
