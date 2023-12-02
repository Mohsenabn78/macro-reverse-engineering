package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhf  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzhf extends zzhc {
    public zzhf(byte[] bArr, int i4) throws InvalidKeyException {
        super(bArr, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhc
    final int zza() {
        return 24;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhc
    final int[] zzb(int[] iArr, int i4) {
        int length = iArr.length;
        if (length == 6) {
            int[] iArr2 = new int[16];
            zzgy.zzb(r0, this.zza);
            int[] iArr3 = {0, 0, 0, 0, iArr3[12], iArr3[13], iArr3[14], iArr3[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
            zzgy.zzc(iArr3);
            zzgy.zzb(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i4;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
    }
}
