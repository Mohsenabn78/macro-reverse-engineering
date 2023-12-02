package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzvs {
    public final long zza;
    public final long zzb;

    public zzvs(long j4, long j5) {
        this.zza = j4;
        this.zzb = j5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvs)) {
            return false;
        }
        zzvs zzvsVar = (zzvs) obj;
        if (this.zza == zzvsVar.zza && this.zzb == zzvsVar.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
