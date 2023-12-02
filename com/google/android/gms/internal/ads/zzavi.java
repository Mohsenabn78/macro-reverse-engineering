package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzavi {
    final long zza;
    final String zzb;
    final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavi(long j4, String str, int i4) {
        this.zza = j4;
        this.zzb = str;
        this.zzc = i4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzavi)) {
            zzavi zzaviVar = (zzavi) obj;
            if (zzaviVar.zza == this.zza && zzaviVar.zzc == this.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
