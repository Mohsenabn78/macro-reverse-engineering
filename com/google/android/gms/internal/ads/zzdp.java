package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdp {
    public static final zzdp zza = new zzdp(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzdp(int i4, int i5, int i6) {
        int i7;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        if (zzfj.zzD(i6)) {
            i7 = zzfj.zzk(i6, i5);
        } else {
            i7 = -1;
        }
        this.zze = i7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return false;
        }
        zzdp zzdpVar = (zzdp) obj;
        if (this.zzb == zzdpVar.zzb && this.zzc == zzdpVar.zzc && this.zzd == zzdpVar.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        int i4 = this.zzb;
        int i5 = this.zzc;
        int i6 = this.zzd;
        return "AudioFormat[sampleRate=" + i4 + ", channelCount=" + i5 + ", encoding=" + i6 + "]";
    }
}
