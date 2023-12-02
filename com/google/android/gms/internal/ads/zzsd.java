package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzsd {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzsd(String str, boolean z3, boolean z4) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = z4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzsd.class) {
            zzsd zzsdVar = (zzsd) obj;
            if (TextUtils.equals(this.zza, zzsdVar.zza) && this.zzb == zzsdVar.zzb && this.zzc == zzsdVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = this.zza.hashCode() + 31;
        int i5 = 1237;
        if (true != this.zzb) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        if (true == this.zzc) {
            i5 = 1231;
        }
        return (((hashCode * 31) + i4) * 31) + i5;
    }
}
