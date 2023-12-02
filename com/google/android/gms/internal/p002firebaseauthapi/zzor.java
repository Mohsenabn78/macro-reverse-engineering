package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzor  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzor {
    private final zzbu zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzor(zzbu zzbuVar, int i4, String str, String str2, zzoq zzoqVar) {
        this.zza = zzbuVar;
        this.zzb = i4;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzor)) {
            return false;
        }
        zzor zzorVar = (zzor) obj;
        if (this.zza != zzorVar.zza || this.zzb != zzorVar.zzb || !this.zzc.equals(zzorVar.zzc) || !this.zzd.equals(zzorVar.zzd)) {
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
