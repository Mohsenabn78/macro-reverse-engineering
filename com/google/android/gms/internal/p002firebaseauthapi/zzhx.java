package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzhx extends zzif {
    private final int zza;
    private final zzhv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhx(int i4, zzhv zzhvVar, zzhw zzhwVar) {
        this.zza = i4;
        this.zzb = zzhvVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhx)) {
            return false;
        }
        zzhx zzhxVar = (zzhx) obj;
        if (zzhxVar.zza != this.zza || zzhxVar.zzb != this.zzb) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzhx.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i4 = this.zza;
        return "AesSiv Parameters (variant: " + valueOf + ", " + i4 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzhv zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        if (this.zzb != zzhv.zzc) {
            return true;
        }
        return false;
    }
}
