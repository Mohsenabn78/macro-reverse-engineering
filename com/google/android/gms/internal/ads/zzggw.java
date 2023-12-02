package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzggw extends zzghe {
    private final int zza;
    private final int zzb;
    private final zzggu zzc;
    private final zzggt zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzggw(int i4, int i5, zzggu zzgguVar, zzggt zzggtVar, zzggv zzggvVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = zzgguVar;
        this.zzd = zzggtVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggw)) {
            return false;
        }
        zzggw zzggwVar = (zzggw) obj;
        if (zzggwVar.zza != this.zza || zzggwVar.zzc() != zzc() || zzggwVar.zzc != this.zzc || zzggwVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzggw.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i4 = this.zzb;
        int i5 = this.zza;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i4 + "-byte tags, and " + i5 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzggu zzgguVar = this.zzc;
        if (zzgguVar == zzggu.zzd) {
            return this.zzb;
        }
        if (zzgguVar == zzggu.zza || zzgguVar == zzggu.zzb || zzgguVar == zzggu.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzggt zzd() {
        return this.zzd;
    }

    public final zzggu zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        if (this.zzc != zzggu.zzd) {
            return true;
        }
        return false;
    }
}
