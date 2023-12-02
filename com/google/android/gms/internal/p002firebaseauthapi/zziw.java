package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziw  reason: invalid package */
/* loaded from: classes4.dex */
final class zziw implements zziz {
    private final int zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(int i4) throws InvalidAlgorithmParameterException {
        if (i4 != 16 && i4 != 32) {
            throw new InvalidAlgorithmParameterException("Unsupported key length: " + i4);
        }
        this.zza = i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zziz
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zziz
    public final byte[] zzb() throws GeneralSecurityException {
        int i4 = this.zza;
        if (i4 != 16) {
            if (i4 == 32) {
                return zzjl.zzj;
            }
            throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
        }
        return zzjl.zzi;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zziz
    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        int length = bArr.length;
        if (length == this.zza) {
            return new zzha(bArr, false).zza(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }
}
