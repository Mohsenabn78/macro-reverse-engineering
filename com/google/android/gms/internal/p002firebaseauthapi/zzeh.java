package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeh  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzeh extends zzcx {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzef zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeh(int i4, int i5, int i6, zzef zzefVar, zzeg zzegVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzd = zzefVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzehVar = (zzeh) obj;
        if (zzehVar.zza != this.zza || zzehVar.zzb != this.zzb || zzehVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzeh.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i4 = this.zzb;
        int i5 = this.zza;
        return "AesEax Parameters (variant: " + valueOf + ", " + i4 + "-byte IV, 16-byte tag, and " + i5 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzef zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        if (this.zzd != zzef.zzc) {
            return true;
        }
        return false;
    }
}
