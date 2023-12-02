package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziu  reason: invalid package */
/* loaded from: classes4.dex */
final class zziu {
    public static void zza(zzrk zzrkVar) throws GeneralSecurityException {
        zzvg.zzi(zzc(zzrkVar.zze().zzf()));
        zzb(zzrkVar.zze().zzg());
        if (zzrkVar.zzh() != 2) {
            zzcr.zzb(zzrkVar.zza().zzd());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zzb(int i4) throws NoSuchAlgorithmException {
        int i5 = i4 - 2;
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 == 5) {
                            return "HmacSha224";
                        }
                        throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(Integer.toString(zzsa.zza(i4))));
                    }
                    return "HmacSha512";
                }
                return "HmacSha256";
            }
            return "HmacSha384";
        }
        return "HmacSha1";
    }

    public static int zzc(int i4) throws GeneralSecurityException {
        int i5 = i4 - 2;
        if (i5 != 2) {
            if (i5 == 3) {
                return 2;
            }
            if (i5 == 4) {
                return 3;
            }
            throw new GeneralSecurityException("unknown curve type: ".concat(Integer.toString(zzrv.zza(i4))));
        }
        return 1;
    }

    public static int zzd(int i4) throws GeneralSecurityException {
        int i5 = i4 - 2;
        int i6 = 1;
        if (i5 != 1) {
            i6 = 2;
            if (i5 != 2) {
                if (i5 == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown point format: ".concat(Integer.toString(zzrb.zza(i4))));
            }
        }
        return i6;
    }
}
