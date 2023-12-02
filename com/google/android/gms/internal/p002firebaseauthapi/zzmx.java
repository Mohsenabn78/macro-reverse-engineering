package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzmx extends zzny {
    private final int zza;
    private final int zzb;
    private final zzmv zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmx(int i4, int i5, zzmv zzmvVar, zzmw zzmwVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = zzmvVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzmx)) {
            return false;
        }
        zzmx zzmxVar = (zzmx) obj;
        if (zzmxVar.zza != this.zza || zzmxVar.zzc() != zzc() || zzmxVar.zzc != this.zzc) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzmx.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
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
        zzmv zzmvVar = this.zzc;
        if (zzmvVar == zzmv.zzd) {
            return this.zzb;
        }
        if (zzmvVar == zzmv.zza || zzmvVar == zzmv.zzb || zzmvVar == zzmv.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzmv zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        if (this.zzc != zzmv.zzd) {
            return true;
        }
        return false;
    }
}
