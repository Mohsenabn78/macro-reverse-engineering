package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfzk extends zzfyu {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzfzi zze;
    private final zzfzh zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfzk(int i4, int i5, int i6, int i7, zzfzi zzfziVar, zzfzh zzfzhVar, zzfzj zzfzjVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = zzfziVar;
        this.zzf = zzfzhVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfzk)) {
            return false;
        }
        zzfzk zzfzkVar = (zzfzk) obj;
        if (zzfzkVar.zza != this.zza || zzfzkVar.zzb != this.zzb || zzfzkVar.zzc != this.zzc || zzfzkVar.zzd != this.zzd || zzfzkVar.zze != this.zze || zzfzkVar.zzf != this.zzf) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfzk.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
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

    public final zzfzh zze() {
        return this.zzf;
    }

    public final zzfzi zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        if (this.zze != zzfzi.zzc) {
            return true;
        }
        return false;
    }
}
