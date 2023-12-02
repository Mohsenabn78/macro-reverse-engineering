package com.google.android.gms.internal.ads;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgnb implements zzghv {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzgnb(byte[] bArr) throws GeneralSecurityException {
        zzgni.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        this.zza = secretKeySpec;
        Cipher zzb = zzb();
        zzb.init(1, secretKeySpec);
        byte[] zza = zzghi.zza(zzb.doFinal(new byte[16]));
        this.zzb = zza;
        this.zzc = zzghi.zza(zza);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgdh.zza(1)) {
            return (Cipher) zzgmq.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.ads.zzghv
    public final byte[] zza(byte[] bArr, int i4) throws GeneralSecurityException {
        byte[] zzc;
        if (i4 <= 16) {
            Cipher zzb = zzb();
            zzb.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(length / 16.0d));
            if (max * 16 == length) {
                zzc = zzgmg.zzd(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) * 16, length);
                int length2 = copyOfRange.length;
                if (length2 < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[length2] = Byte.MIN_VALUE;
                    zzc = zzgmg.zzc(copyOf, this.zzc);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr2 = new byte[16];
            for (int i5 = 0; i5 < max - 1; i5++) {
                bArr2 = zzb.doFinal(zzgmg.zzd(bArr2, 0, bArr, i5 * 16, 16));
            }
            return Arrays.copyOf(zzb.doFinal(zzgmg.zzc(zzc, bArr2)), i4);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
