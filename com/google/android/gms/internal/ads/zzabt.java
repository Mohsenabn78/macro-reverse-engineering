package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabt {
    public final zzabw zza;
    public final zzabw zzb;

    public zzabt(zzabw zzabwVar, zzabw zzabwVar2) {
        this.zza = zzabwVar;
        this.zzb = zzabwVar2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabt.class == obj.getClass()) {
            zzabt zzabtVar = (zzabt) obj;
            if (this.zza.equals(zzabtVar.zza) && this.zzb.equals(zzabtVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        String concat;
        String obj = this.zza.toString();
        if (this.zza.equals(this.zzb)) {
            concat = "";
        } else {
            concat = ", ".concat(this.zzb.toString());
        }
        return "[" + obj + concat + "]";
    }
}
