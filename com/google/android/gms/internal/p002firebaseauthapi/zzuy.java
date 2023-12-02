package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzuy implements zzbj {
    private static final Collection zza = Arrays.asList(64);
    private static final byte[] zzb = new byte[16];
    private final zzwa zzc;
    private final byte[] zzd;

    public zzuy(byte[] bArr) throws GeneralSecurityException {
        if (zzhk.zza(1)) {
            Collection collection = zza;
            int length = bArr.length;
            if (collection.contains(Integer.valueOf(length))) {
                int i4 = length >> 1;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i4);
                this.zzd = Arrays.copyOfRange(bArr, i4, length);
                this.zzc = new zzwa(copyOfRange);
                return;
            }
            throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzc;
        int length = bArr.length;
        if (length >= 16) {
            Cipher cipher = (Cipher) zzvp.zza.zza("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.zzd, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, length);
            byte[] doFinal = cipher.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && zzwe.zza()) {
                doFinal = new byte[0];
            }
            byte[][] bArr4 = {bArr2, doFinal};
            byte[] zza2 = this.zzc.zza(zzb, 16);
            for (int i4 = 0; i4 <= 0; i4++) {
                byte[] bArr5 = bArr4[i4];
                if (bArr5 == null) {
                    bArr5 = new byte[0];
                }
                zza2 = zzuz.zzc(zzoc.zzb(zza2), this.zzc.zza(bArr5, 16));
            }
            byte[] bArr6 = bArr4[1];
            int length2 = bArr6.length;
            if (length2 >= 16) {
                int length3 = zza2.length;
                if (length2 >= length3) {
                    zzc = Arrays.copyOf(bArr6, length2);
                    for (int i5 = 0; i5 < zza2.length; i5++) {
                        int i6 = (length2 - length3) + i5;
                        zzc[i6] = (byte) (zzc[i6] ^ zza2[i5]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                zzc = zzuz.zzc(zzoc.zza(bArr6), zzoc.zzb(zza2));
            }
            if (MessageDigest.isEqual(copyOfRange, this.zzc.zza(zzc, 16))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
