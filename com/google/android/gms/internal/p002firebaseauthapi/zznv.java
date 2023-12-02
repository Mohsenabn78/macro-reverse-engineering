package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zznv extends zzny {
    private final int zza;
    private final int zzb;
    private final zznt zzc;
    private final zzns zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zznv(int i4, int i5, zznt zzntVar, zzns zznsVar, zznu zznuVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = zzntVar;
        this.zzd = zznsVar;
    }

    public static zznr zzd() {
        return new zznr(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznv)) {
            return false;
        }
        zznv zznvVar = (zznv) obj;
        if (zznvVar.zza != this.zza || zznvVar.zzc() != zzc() || zznvVar.zzc != this.zzc || zznvVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zznv.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
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
        zznt zzntVar = this.zzc;
        if (zzntVar == zznt.zzd) {
            return this.zzb;
        }
        if (zzntVar == zznt.zza || zzntVar == zznt.zzb || zzntVar == zznt.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzns zze() {
        return this.zzd;
    }

    public final zznt zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        if (this.zzc != zznt.zzd) {
            return true;
        }
        return false;
    }
}
