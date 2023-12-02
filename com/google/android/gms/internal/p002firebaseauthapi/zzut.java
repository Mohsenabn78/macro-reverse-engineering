package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzut implements zzvz {
    private static final ThreadLocal zza = new zzus();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzut(byte[] bArr, int i4) throws GeneralSecurityException {
        if (zzhk.zza(2)) {
            zzwf.zzb(bArr.length);
            this.zzb = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            int blockSize = ((Cipher) zza.get()).getBlockSize();
            this.zzd = blockSize;
            if (i4 >= 12 && i4 <= blockSize) {
                this.zzc = i4;
                return;
            }
            throw new GeneralSecurityException("invalid IV size");
        }
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzvz
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i4 = this.zzc;
        if (length >= i4) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            int i5 = this.zzc;
            int i6 = length - i5;
            byte[] bArr3 = new byte[i6];
            Cipher cipher = (Cipher) zza.get();
            byte[] bArr4 = new byte[this.zzd];
            System.arraycopy(bArr2, 0, bArr4, 0, this.zzc);
            cipher.init(2, this.zzb, new IvParameterSpec(bArr4));
            if (cipher.doFinal(bArr, i5, i6, bArr3, 0) == i6) {
                return bArr3;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
