package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjn implements zzje {
    private final zzwi zza;
    private final zzwi zzb;

    private zzjn(byte[] bArr, byte[] bArr2) {
        this.zza = zzwi.zzb(bArr);
        this.zzb = zzwi.zzb(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjn zzc(byte[] bArr, byte[] bArr2, int i4) throws GeneralSecurityException {
        zzvg.zzd(zzvg.zzh(zzvg.zzi(i4), 1, bArr2), zzvg.zzg(i4, bArr));
        return new zzjn(bArr, bArr2);
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
