package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmc  reason: invalid package */
/* loaded from: classes4.dex */
final class zzmc {
    private final Class zza;
    private final zzwi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmc(Class cls, zzwi zzwiVar, zzmb zzmbVar) {
        this.zza = cls;
        this.zzb = zzwiVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzmc)) {
            return false;
        }
        zzmc zzmcVar = (zzmc) obj;
        if (!zzmcVar.zza.equals(this.zza) || !zzmcVar.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
