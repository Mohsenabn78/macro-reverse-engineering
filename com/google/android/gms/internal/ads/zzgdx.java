package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgdx extends zzfyf {
    private final zzgfb zza;

    public zzgdx(zzgfb zzgfbVar) {
        this.zza = zzgfbVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgdx)) {
            return false;
        }
        zzgfb zzgfbVar = ((zzgdx) obj).zza;
        if (!this.zza.zzb().zzf().equals(zzgfbVar.zzb().zzf()) || !this.zza.zzb().zzh().equals(zzgfbVar.zzb().zzh()) || !this.zza.zzb().zzg().equals(zzgfbVar.zzb().zzg())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzgfb zzgfbVar = this.zza;
        return Arrays.hashCode(new Object[]{zzgfbVar.zzb(), zzgfbVar.zzd()});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzb().zzh();
        zzglq zzf = this.zza.zzb().zzf();
        zzglq zzglqVar = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzf.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        str = "UNKNOWN";
                    } else {
                        str = "CRUNCHY";
                    }
                } else {
                    str = "RAW";
                }
            } else {
                str = "LEGACY";
            }
        } else {
            str = "TINK";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final zzgfb zza() {
        return this.zza;
    }
}
