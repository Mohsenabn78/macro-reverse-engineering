package com.google.android.gms.internal.ads;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgdg implements zzfxh {
    private static final ThreadLocal zza = new zzgdf();
    private static final boolean zzb;
    private final SecretKey zzc;

    static {
        boolean z3;
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            z3 = true;
        } catch (ClassNotFoundException unused) {
            z3 = false;
        }
        zzb = z3;
    }

    public zzgdg(byte[] bArr) throws GeneralSecurityException {
        zzgni.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
    }

    @Override // com.google.android.gms.internal.ads.zzfxh
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        AlgorithmParameterSpec ivParameterSpec;
        int length = bArr.length;
        if (length >= 28) {
            if (zzb) {
                ivParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
            } else if (zzgnh.zza()) {
                ivParameterSpec = new IvParameterSpec(bArr, 0, 12);
            } else {
                throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
            }
            ThreadLocal threadLocal = zza;
            ((Cipher) threadLocal.get()).init(2, this.zzc, ivParameterSpec);
            if (bArr2 != null && bArr2.length != 0) {
                ((Cipher) threadLocal.get()).updateAAD(bArr2);
            }
            return ((Cipher) threadLocal.get()).doFinal(bArr, 12, length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
