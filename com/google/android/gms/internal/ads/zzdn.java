package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.android.dx.io.Opcodes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdn {
    @IntRange(from = 0)
    public final int zzc;
    @IntRange(from = 0)
    public final int zzd;
    @IntRange(from = 0, to = 359)
    public final int zze;
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, fromInclusive = false)
    public final float zzf;
    public static final zzdn zza = new zzdn(0, 0, 0, 1.0f);
    private static final String zzg = Integer.toString(0, 36);
    private static final String zzh = Integer.toString(1, 36);
    private static final String zzi = Integer.toString(2, 36);
    private static final String zzj = Integer.toString(3, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzdm
    };

    public zzdn(@IntRange(from = 0) int i4, @IntRange(from = 0) int i5, @IntRange(from = 0, to = 359) int i6, @FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = f4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdn) {
            zzdn zzdnVar = (zzdn) obj;
            if (this.zzc == zzdnVar.zzc && this.zzd == zzdnVar.zzd && this.zze == zzdnVar.zze && this.zzf == zzdnVar.zzf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zzc + Opcodes.RSUB_INT_LIT8) * 31) + this.zzd) * 31) + this.zze) * 31) + Float.floatToRawIntBits(this.zzf);
    }
}
