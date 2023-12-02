package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgbm extends zzfyu {
    private final int zza;
    private final zzgbk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgbm(int i4, zzgbk zzgbkVar, zzgbl zzgblVar) {
        this.zza = i4;
        this.zzb = zzgbkVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgbm)) {
            return false;
        }
        zzgbm zzgbmVar = (zzgbm) obj;
        if (zzgbmVar.zza != this.zza || zzgbmVar.zzb != this.zzb) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgbm.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i4 = this.zza;
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + i4 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzgbk zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        if (this.zzb != zzgbk.zzc) {
            return true;
        }
        return false;
    }
}
