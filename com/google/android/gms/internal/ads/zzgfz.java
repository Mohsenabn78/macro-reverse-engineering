package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfz extends zzghe {
    private final int zza;
    private final int zzb;
    private final zzgfx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgfz(int i4, int i5, zzgfx zzgfxVar, zzgfy zzgfyVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = zzgfxVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfz)) {
            return false;
        }
        zzgfz zzgfzVar = (zzgfz) obj;
        if (zzgfzVar.zza != this.zza || zzgfzVar.zzc() != zzc() || zzgfzVar.zzc != this.zzc) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgfz.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i4 = this.zzb;
        int i5 = this.zza;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i4 + "-byte tags, and " + i5 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzgfx zzgfxVar = this.zzc;
        if (zzgfxVar == zzgfx.zzd) {
            return this.zzb;
        }
        if (zzgfxVar == zzgfx.zza || zzgfxVar == zzgfx.zzb || zzgfxVar == zzgfx.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgfx zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        if (this.zzc != zzgfx.zzd) {
            return true;
        }
        return false;
    }
}
