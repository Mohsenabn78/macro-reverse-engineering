package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfez {
    @NonNull
    public final String zza;
    @NonNull
    public final String zzb;

    public zzfez(@NonNull String str, @NonNull String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfez)) {
            return false;
        }
        zzfez zzfezVar = (zzfez) obj;
        if (this.zza.equals(zzfezVar.zza) && this.zzb.equals(zzfezVar.zzb)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return String.valueOf(this.zza).concat(String.valueOf(this.zzb)).hashCode();
    }
}
