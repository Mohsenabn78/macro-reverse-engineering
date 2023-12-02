package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziy  reason: invalid package */
/* loaded from: classes4.dex */
final class zziy {
    private final String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziy(String str) {
        this.zza = str;
    }

    private final byte[] zzf(byte[] bArr, byte[] bArr2, int i4) throws GeneralSecurityException {
        Mac mac = (Mac) zzvp.zzb.zza(this.zza);
        if (i4 <= mac.getMacLength() * 255) {
            byte[] bArr3 = new byte[i4];
            mac.init(new SecretKeySpec(bArr, this.zza));
            byte[] bArr4 = new byte[0];
            int i5 = 1;
            int i6 = 0;
            while (true) {
                mac.update(bArr4);
                mac.update(bArr2);
                mac.update((byte) i5);
                bArr4 = mac.doFinal();
                int length = bArr4.length;
                int i7 = i6 + length;
                if (i7 < i4) {
                    System.arraycopy(bArr4, 0, bArr3, i6, length);
                    i5++;
                    i6 = i7;
                } else {
                    System.arraycopy(bArr4, 0, bArr3, i6, i4 - i6);
                    return bArr3;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }

    private final byte[] zzg(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac mac = (Mac) zzvp.zzb.zza(this.zza);
        if (bArr2 != null && bArr2.length != 0) {
            mac.init(new SecretKeySpec(bArr2, this.zza));
        } else {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], this.zza));
        }
        return mac.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza() throws GeneralSecurityException {
        return Mac.getInstance(this.zza).getMacLength();
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i4) throws GeneralSecurityException {
        return zzf(zzg(zzjl.zze("eae_prk", bArr2, bArr4), null), zzjl.zzf("shared_secret", bArr3, bArr4, i4), i4);
    }

    public final byte[] zzc() throws GeneralSecurityException {
        char c4;
        String str = this.zza;
        int hashCode = str.hashCode();
        if (hashCode != 984523022) {
            if (hashCode != 984524074) {
                if (hashCode == 984525777 && str.equals("HmacSha512")) {
                    c4 = 2;
                }
                c4 = 65535;
            } else {
                if (str.equals("HmacSha384")) {
                    c4 = 1;
                }
                c4 = 65535;
            }
        } else {
            if (str.equals("HmacSha256")) {
                c4 = 0;
            }
            c4 = 65535;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 == 2) {
                    return zzjl.zzh;
                }
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
            }
            return zzjl.zzg;
        }
        return zzjl.zzf;
    }

    public final byte[] zzd(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i4) throws GeneralSecurityException {
        return zzf(bArr, zzjl.zzf(str, bArr2, bArr3, i4), i4);
    }

    public final byte[] zze(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return zzg(zzjl.zze(str, bArr2, bArr3), bArr);
    }
}
