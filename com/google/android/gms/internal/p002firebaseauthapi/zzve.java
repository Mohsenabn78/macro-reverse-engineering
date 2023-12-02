package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzve {
    private final ECPrivateKey zza;

    public zzve(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i4, int i5) throws GeneralSecurityException {
        int i6 = 1;
        byte[] zzb = zzuz.zzb(bArr, zzvg.zzf(this.zza, zzvg.zzh(this.zza.getParams(), i5, bArr)));
        Mac mac = (Mac) zzvp.zzb.zza(str);
        if (i4 <= mac.getMacLength() * 255) {
            if (bArr2 != null && bArr2.length != 0) {
                mac.init(new SecretKeySpec(bArr2, str));
            } else {
                mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
            }
            byte[] doFinal = mac.doFinal(zzb);
            byte[] bArr4 = new byte[i4];
            mac.init(new SecretKeySpec(doFinal, str));
            byte[] bArr5 = new byte[0];
            int i7 = 0;
            while (true) {
                mac.update(bArr5);
                mac.update((byte[]) null);
                mac.update((byte) i6);
                bArr5 = mac.doFinal();
                int length = bArr5.length;
                int i8 = i7 + length;
                if (i8 < i4) {
                    System.arraycopy(bArr5, 0, bArr4, i7, length);
                    i6++;
                    i7 = i8;
                } else {
                    System.arraycopy(bArr5, 0, bArr4, i7, i4 - i7);
                    return bArr4;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }
}
