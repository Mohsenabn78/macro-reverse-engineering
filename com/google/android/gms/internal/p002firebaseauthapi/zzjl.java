package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjl {
    public static final byte[] zza = zzc(1, 0);
    public static final byte[] zzb = zzc(2, 32);
    public static final byte[] zzc = zzc(2, 16);
    public static final byte[] zzd = zzc(2, 17);
    public static final byte[] zze = zzc(2, 18);
    public static final byte[] zzf = zzc(2, 1);
    public static final byte[] zzg = zzc(2, 2);
    public static final byte[] zzh = zzc(2, 3);
    public static final byte[] zzi = zzc(2, 1);
    public static final byte[] zzj = zzc(2, 2);
    public static final byte[] zzk = zzc(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    static {
        Charset charset = zzmj.zza;
        zzm = "KEM".getBytes(charset);
        zzn = "HPKE".getBytes(charset);
        zzo = "HPKE-v1".getBytes(charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzsr zzsrVar) throws GeneralSecurityException {
        if (zzsrVar.zzf() != 2 && zzsrVar.zzf() != 1) {
            String str = "UNRECOGNIZED";
            if (zzsrVar.zze() != 2 && zzsrVar.zze() != 1) {
                if (zzsrVar.zzd() != 2 && zzsrVar.zzd() != 1) {
                    return;
                }
                int zzd2 = zzsrVar.zzd();
                if (zzd2 != 2) {
                    if (zzd2 != 3) {
                        if (zzd2 != 4) {
                            if (zzd2 == 5) {
                                str = "CHACHA20_POLY1305";
                            }
                        } else {
                            str = "AES_256_GCM";
                        }
                    } else {
                        str = "AES_128_GCM";
                    }
                } else {
                    str = "AEAD_UNKNOWN";
                }
                throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
            }
            int zze2 = zzsrVar.zze();
            if (zze2 != 2) {
                if (zze2 != 3) {
                    if (zze2 != 4) {
                        if (zze2 == 5) {
                            str = "HKDF_SHA512";
                        }
                    } else {
                        str = "HKDF_SHA384";
                    }
                } else {
                    str = "HKDF_SHA256";
                }
            } else {
                str = "KDF_UNKNOWN";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        }
        throw new GeneralSecurityException("Invalid KEM param: ".concat(zzsl.zza(zzsrVar.zzf())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzuz.zzb(zzn, bArr, bArr2, bArr3);
    }

    public static byte[] zzc(int i4, int i5) {
        byte[] bArr = new byte[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            bArr[i6] = (byte) ((i5 >> (((i4 - i6) - 1) * 8)) & 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zzd(byte[] bArr) throws GeneralSecurityException {
        return zzuz.zzb(zzm, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zze(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzuz.zzb(zzo, bArr2, str.getBytes(zzmj.zza), bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zzf(String str, byte[] bArr, byte[] bArr2, int i4) throws GeneralSecurityException {
        return zzuz.zzb(zzc(2, i4), zzo, bArr2, str.getBytes(zzmj.zza), bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i4) throws GeneralSecurityException {
        int i5 = i4 - 2;
        if (i5 != 2) {
            if (i5 == 3) {
                return 2;
            }
            if (i5 == 4) {
                return 3;
            }
            throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
        }
        return 1;
    }
}
