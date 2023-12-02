package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaid  reason: invalid package */
/* loaded from: classes4.dex */
final class zzaid {
    public static final boolean zza(Object obj) {
        if (!((zzaic) obj).zze()) {
            return true;
        }
        return false;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzaic zzaicVar = (zzaic) obj;
        zzaic zzaicVar2 = (zzaic) obj2;
        if (!zzaicVar2.isEmpty()) {
            if (!zzaicVar.zze()) {
                zzaicVar = zzaicVar.zzb();
            }
            zzaicVar.zzd(zzaicVar2);
        }
        return zzaicVar;
    }
}
