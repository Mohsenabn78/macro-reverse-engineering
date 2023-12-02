package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwa  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwa implements zzou {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public zzwa(byte[] bArr) throws GeneralSecurityException {
        zzwf.zzb(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        this.zza = secretKeySpec;
        Cipher zzb = zzb();
        zzb.init(1, secretKeySpec);
        byte[] zzb2 = zzoc.zzb(zzb.doFinal(new byte[16]));
        this.zzb = zzb2;
        this.zzc = zzoc.zzb(zzb2);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzhk.zza(1)) {
            return (Cipher) zzvp.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
    public final byte[] zza(byte[] bArr, int i4) throws GeneralSecurityException {
        byte[] zzc;
        if (i4 <= 16) {
            Cipher zzb = zzb();
            zzb.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(length / 16.0d));
            if (max * 16 == length) {
                zzc = zzuz.zzd(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                zzc = zzuz.zzc(zzoc.zza(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr2 = new byte[16];
            for (int i5 = 0; i5 < max - 1; i5++) {
                bArr2 = zzb.doFinal(zzuz.zzd(bArr2, 0, bArr, i5 * 16, 16));
            }
            return Arrays.copyOf(zzb.doFinal(zzuz.zzc(zzc, bArr2)), i4);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
