package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzuw implements zzbd {
    private static final ThreadLocal zza = new zzuu();
    private static final ThreadLocal zzb = new zzuv();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public zzuw(byte[] bArr, int i4) throws GeneralSecurityException {
        if (zzhk.zza(1)) {
            if (i4 != 12 && i4 != 16) {
                throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
            }
            this.zzf = i4;
            zzwf.zzb(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            this.zze = secretKeySpec;
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, secretKeySpec);
            byte[] zzc = zzc(cipher.doFinal(new byte[16]));
            this.zzc = zzc;
            this.zzd = zzc(zzc);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    private static byte[] zzc(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i4 = 0;
        while (i4 < 15) {
            byte b4 = bArr[i4];
            int i5 = i4 + 1;
            bArr2[i4] = (byte) (((b4 + b4) ^ ((bArr[i5] & 255) >>> 7)) & 255);
            i4 = i5;
        }
        byte b5 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b5 + b5));
        return bArr2;
    }

    private final byte[] zzd(Cipher cipher, int i4, byte[] bArr, int i5, int i6) throws IllegalBlockSizeException, BadPaddingException {
        int length;
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i4;
        if (i6 == 0) {
            return cipher.doFinal(zze(bArr3, this.zzc));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i7 = 0;
        int i8 = 0;
        while (i6 - i8 > 16) {
            for (int i9 = 0; i9 < 16; i9++) {
                doFinal[i9] = (byte) (doFinal[i9] ^ bArr[(i5 + i8) + i9]);
            }
            doFinal = cipher.doFinal(doFinal);
            i8 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i8 + i5, i5 + i6);
        if (copyOfRange.length == 16) {
            bArr2 = zze(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = copyOfRange.length;
                if (i7 >= length) {
                    break;
                }
                copyOf[i7] = (byte) (copyOf[i7] ^ copyOfRange[i7]);
                i7++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zze(doFinal, bArr2));
    }

    private static byte[] zze(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr3[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i4 = (length - this.zzf) - 16;
        if (i4 >= 0) {
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zze);
            byte[] zzd = zzd(cipher, 0, bArr, 0, this.zzf);
            byte[] zzd2 = zzd(cipher, 1, bArr2, 0, 0);
            byte[] zzd3 = zzd(cipher, 2, bArr, this.zzf, i4);
            int i5 = length - 16;
            byte b4 = 0;
            for (int i6 = 0; i6 < 16; i6++) {
                b4 = (byte) (b4 | (((bArr[i5 + i6] ^ zzd2[i6]) ^ zzd[i6]) ^ zzd3[i6]));
            }
            if (b4 == 0) {
                Cipher cipher2 = (Cipher) zzb.get();
                cipher2.init(1, this.zze, new IvParameterSpec(zzd));
                return cipher2.doFinal(bArr, this.zzf, i4);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
