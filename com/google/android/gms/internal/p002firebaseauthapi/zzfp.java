package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzfp extends zzcx {
    private final int zza;
    private final zzfn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfp(int i4, zzfn zzfnVar, zzfo zzfoVar) {
        this.zza = i4;
        this.zzb = zzfnVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfpVar = (zzfp) obj;
        if (zzfpVar.zza != this.zza || zzfpVar.zzb != this.zzb) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfp.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i4 = this.zza;
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + i4 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzfn zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        if (this.zzb != zzfn.zzc) {
            return true;
        }
        return false;
    }
}
