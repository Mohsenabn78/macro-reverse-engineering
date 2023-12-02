package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgcy extends zzgcz {
    public zzgcy(byte[] bArr, int i4) throws InvalidKeyException {
        super(bArr, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    public final int zza() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    public final int[] zzb(int[] iArr, int i4) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            zzgcv.zzb(iArr2, this.zza);
            iArr2[12] = i4;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
    }
}
