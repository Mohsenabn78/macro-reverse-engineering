package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzgu {
    private final String zza;
    private final long zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgu(String str, long j4) {
        this.zza = str;
        this.zzb = j4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgu) {
            zzgu zzguVar = (zzgu) obj;
            if (Objects.equal(this.zza, zzguVar.zza) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzguVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }

    public final String zza() {
        return this.zza;
    }
}
