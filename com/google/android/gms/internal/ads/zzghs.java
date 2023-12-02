package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghs {
    private final zzfxs zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzghs(zzfxs zzfxsVar, int i4, String str, String str2, zzghr zzghrVar) {
        this.zza = zzfxsVar;
        this.zzb = i4;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghs)) {
            return false;
        }
        zzghs zzghsVar = (zzghs) obj;
        if (this.zza != zzghsVar.zza || this.zzb != zzghsVar.zzb || !this.zzc.equals(zzghsVar.zzc) || !this.zzd.equals(zzghsVar.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final int zza() {
        return this.zzb;
    }
}
