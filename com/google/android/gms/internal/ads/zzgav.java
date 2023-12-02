package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgav extends zzfyu {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgat zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgav(int i4, int i5, int i6, zzgat zzgatVar, zzgau zzgauVar) {
        this.zza = i4;
        this.zzd = zzgatVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgav)) {
            return false;
        }
        zzgav zzgavVar = (zzgav) obj;
        if (zzgavVar.zza != this.zza || zzgavVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgav.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i4 = this.zza;
        return "AesGcm Parameters (variant: " + valueOf + ", 12-byte IV, 16-byte tag, and " + i4 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzgat zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        if (this.zzd != zzgat.zzc) {
            return true;
        }
        return false;
    }
}
