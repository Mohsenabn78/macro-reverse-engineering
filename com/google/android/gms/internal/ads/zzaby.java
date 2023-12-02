package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaby {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzaby(int i4, byte[] bArr, int i5, int i6) {
        this.zza = i4;
        this.zzb = bArr;
        this.zzc = i5;
        this.zzd = i6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaby.class == obj.getClass()) {
            zzaby zzabyVar = (zzaby) obj;
            if (this.zza == zzabyVar.zza && this.zzc == zzabyVar.zzc && this.zzd == zzabyVar.zzd && Arrays.equals(this.zzb, zzabyVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
