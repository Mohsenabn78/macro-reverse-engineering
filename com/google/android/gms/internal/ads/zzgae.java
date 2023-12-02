package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgae extends zzfyu {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgac zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgae(int i4, int i5, int i6, zzgac zzgacVar, zzgad zzgadVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzd = zzgacVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgae)) {
            return false;
        }
        zzgae zzgaeVar = (zzgae) obj;
        if (zzgaeVar.zza != this.zza || zzgaeVar.zzb != this.zzb || zzgaeVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgae.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i4 = this.zzb;
        int i5 = this.zza;
        return "AesEax Parameters (variant: " + valueOf + ", " + i4 + "-byte IV, 16-byte tag, and " + i5 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgac zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        if (this.zzd != zzgac.zzc) {
            return true;
        }
        return false;
    }
}
