package com.google.android.gms.internal.ads;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcy {
    public final int zzb = 1;
    public final String zzc;
    public final int zzd;
    private final zzam[] zzg;
    private int zzh;
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzcx
    };

    public zzcy(String str, zzam... zzamVarArr) {
        this.zzc = str;
        this.zzg = zzamVarArr;
        int zzb = zzcc.zzb(zzamVarArr[0].zzm);
        this.zzd = zzb == -1 ? zzcc.zzb(zzamVarArr[0].zzl) : zzb;
        zzd(zzamVarArr[0].zzd);
        int i4 = zzamVarArr[0].zzf;
    }

    private static String zzd(@Nullable String str) {
        if (str != null && !str.equals("und")) {
            return str;
        }
        return "";
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcy.class == obj.getClass()) {
            zzcy zzcyVar = (zzcy) obj;
            if (this.zzc.equals(zzcyVar.zzc) && Arrays.equals(this.zzg, zzcyVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zzh;
        if (i4 == 0) {
            int hashCode = ((this.zzc.hashCode() + 527) * 31) + Arrays.hashCode(this.zzg);
            this.zzh = hashCode;
            return hashCode;
        }
        return i4;
    }

    public final int zza(zzam zzamVar) {
        for (int i4 = 0; i4 <= 0; i4++) {
            if (zzamVar == this.zzg[i4]) {
                return i4;
            }
        }
        return -1;
    }

    public final zzam zzb(int i4) {
        return this.zzg[i4];
    }

    @CheckResult
    public final zzcy zzc(String str) {
        return new zzcy(str, this.zzg);
    }
}
