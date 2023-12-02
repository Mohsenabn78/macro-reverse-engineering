package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjp  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjp implements zzje {
    private final zzwi zza;
    private final zzwi zzb;

    private zzjp(byte[] bArr, byte[] bArr2) {
        this.zza = zzwi.zzb(bArr);
        this.zzb = zzwi.zzb(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjp zzc(byte[] bArr) throws GeneralSecurityException {
        return new zzjp(bArr, zzwg.zzb(bArr));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzje
    public final zzwi zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzje
    public final zzwi zzb() {
        return this.zzb;
    }
}
