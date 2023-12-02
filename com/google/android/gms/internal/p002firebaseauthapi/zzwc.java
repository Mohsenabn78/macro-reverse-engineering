package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwc implements zzou {
    private final ThreadLocal zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public zzwc(String str, Key key) throws GeneralSecurityException {
        char c4;
        int i4;
        zzwb zzwbVar = new zzwb(this);
        this.zza = zzwbVar;
        if (zzhk.zza(2)) {
            this.zzb = str;
            this.zzc = key;
            if (key.getEncoded().length >= 16) {
                switch (str.hashCode()) {
                    case -1823053428:
                        if (str.equals("HMACSHA1")) {
                            c4 = 0;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 392315023:
                        if (str.equals("HMACSHA224")) {
                            c4 = 1;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 392315118:
                        if (str.equals("HMACSHA256")) {
                            c4 = 2;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 392316170:
                        if (str.equals("HMACSHA384")) {
                            c4 = 3;
                            break;
                        }
                        c4 = 65535;
                        break;
                    case 392317873:
                        if (str.equals("HMACSHA512")) {
                            c4 = 4;
                            break;
                        }
                        c4 = 65535;
                        break;
                    default:
                        c4 = 65535;
                        break;
                }
                if (c4 != 0) {
                    if (c4 != 1) {
                        if (c4 != 2) {
                            if (c4 != 3) {
                                if (c4 == 4) {
                                    i4 = 64;
                                } else {
                                    throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
                                }
                            } else {
                                i4 = 48;
                            }
                        } else {
                            i4 = 32;
                        }
                    } else {
                        i4 = 28;
                    }
                    this.zzd = i4;
                } else {
                    this.zzd = 20;
                }
                zzwbVar.get();
                return;
            }
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
    public final byte[] zza(byte[] bArr, int i4) throws GeneralSecurityException {
        if (i4 <= this.zzd) {
            ((Mac) this.zza.get()).update(bArr);
            return Arrays.copyOf(((Mac) this.zza.get()).doFinal(), i4);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
