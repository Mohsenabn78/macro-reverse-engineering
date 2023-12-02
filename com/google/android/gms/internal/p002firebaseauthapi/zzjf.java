package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjf  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static zziz zza(zzsr zzsrVar) throws GeneralSecurityException {
        if (zzsrVar.zzd() == 3) {
            return new zziw(16);
        }
        if (zzsrVar.zzd() == 4) {
            return new zziw(32);
        }
        if (zzsrVar.zzd() == 5) {
            return new zzix();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjd zzb(zzsr zzsrVar) throws GeneralSecurityException {
        if (zzsrVar.zzf() == 3) {
            return new zzjo(new zziy("HmacSha256"));
        }
        if (zzsrVar.zzf() == 4) {
            return zzjm.zzc(1);
        }
        if (zzsrVar.zzf() == 5) {
            return zzjm.zzc(2);
        }
        if (zzsrVar.zzf() == 6) {
            return zzjm.zzc(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zziy zzc(zzsr zzsrVar) {
        if (zzsrVar.zze() == 3) {
            return new zziy("HmacSha256");
        }
        if (zzsrVar.zze() == 4) {
            return new zziy("HmacSha384");
        }
        if (zzsrVar.zze() == 5) {
            return new zziy("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
