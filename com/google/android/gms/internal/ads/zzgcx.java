package com.google.android.gms.internal.ads;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgcx {
    private static final ThreadLocal zza = new zzgcw();
    private final SecretKey zzb;

    public zzgcx(byte[] bArr, boolean z3) throws GeneralSecurityException {
        if (zzgdh.zza(2)) {
            zzgni.zza(bArr.length);
            this.zzb = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r2.equals("The Android Project") != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] zza(byte[] r7, byte[] r8, byte[] r9) throws java.security.GeneralSecurityException {
        /*
            r6 = this;
            int r0 = r7.length
            r1 = 12
            if (r0 != r1) goto L82
            int r0 = r8.length
            r2 = 28
            if (r0 < r2) goto L7a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r7)
            r3 = 0
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r8, r3, r1)
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L72
            java.lang.String r2 = "java.vendor"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            java.lang.String r4 = "The Android Project"
            if (r2 == r4) goto L2c
            r5 = 0
            if (r2 == 0) goto L32
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L32
        L2c:
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
        L32:
            if (r5 == 0) goto L42
            int r2 = r5.intValue()
            r4 = 19
            if (r2 > r4) goto L42
            javax.crypto.spec.IvParameterSpec r2 = new javax.crypto.spec.IvParameterSpec
            r2.<init>(r7, r3, r1)
            goto L49
        L42:
            javax.crypto.spec.GCMParameterSpec r2 = new javax.crypto.spec.GCMParameterSpec
            r4 = 128(0x80, float:1.794E-43)
            r2.<init>(r4, r7, r3, r1)
        L49:
            java.lang.ThreadLocal r7 = com.google.android.gms.internal.ads.zzgcx.zza
            java.lang.Object r3 = r7.get()
            javax.crypto.Cipher r3 = (javax.crypto.Cipher) r3
            r4 = 2
            javax.crypto.SecretKey r5 = r6.zzb
            r3.init(r4, r5, r2)
            if (r9 == 0) goto L65
            int r2 = r9.length
            if (r2 == 0) goto L65
            java.lang.Object r2 = r7.get()
            javax.crypto.Cipher r2 = (javax.crypto.Cipher) r2
            r2.updateAAD(r9)
        L65:
            int r0 = r0 + (-12)
            java.lang.Object r7 = r7.get()
            javax.crypto.Cipher r7 = (javax.crypto.Cipher) r7
            byte[] r7 = r7.doFinal(r8, r1, r0)
            return r7
        L72:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException
            java.lang.String r8 = "iv does not match prepended iv"
            r7.<init>(r8)
            throw r7
        L7a:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException
            java.lang.String r8 = "ciphertext too short"
            r7.<init>(r8)
            throw r7
        L82:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException
            java.lang.String r8 = "iv is wrong size"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcx.zza(byte[], byte[], byte[]):byte[]");
    }
}
