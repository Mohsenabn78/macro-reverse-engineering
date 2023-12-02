package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzey  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzey extends zzcx {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzew zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzey(int i4, int i5, int i6, zzew zzewVar, zzex zzexVar) {
        this.zza = i4;
        this.zzd = zzewVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzey)) {
            return false;
        }
        zzey zzeyVar = (zzey) obj;
        if (zzeyVar.zza != this.zza || zzeyVar.zzd != this.zzd) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzey.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i4 = this.zza;
        return "AesGcm Parameters (variant: " + valueOf + ", 12-byte IV, 16-byte tag, and " + i4 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzew zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        if (this.zzd != zzew.zzc) {
            return true;
        }
        return false;
    }
}
