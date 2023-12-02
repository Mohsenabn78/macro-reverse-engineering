package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdn  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzdn extends zzcx {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzdl zze;
    private final zzdk zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdn(int i4, int i5, int i6, int i7, zzdl zzdlVar, zzdk zzdkVar, zzdm zzdmVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = zzdlVar;
        this.zzf = zzdkVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdn)) {
            return false;
        }
        zzdn zzdnVar = (zzdn) obj;
        if (zzdnVar.zza != this.zza || zzdnVar.zzb != this.zzb || zzdnVar.zzc != this.zzc || zzdnVar.zzd != this.zzd || zzdnVar.zze != this.zze || zzdnVar.zzf != this.zzf) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzdn.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i4 = this.zzc;
        int i5 = this.zzd;
        int i6 = this.zza;
        int i7 = this.zzb;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i4 + "-byte IV, and " + i5 + "-byte tags, and " + i6 + "-byte AES key, and " + i7 + "-byte HMAC key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final zzdk zze() {
        return this.zzf;
    }

    public final zzdl zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        if (this.zze != zzdl.zzc) {
            return true;
        }
        return false;
    }
}
