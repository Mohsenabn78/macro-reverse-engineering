package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjb  reason: invalid package */
/* loaded from: classes4.dex */
final class zzjb implements zzbk {
    private static final byte[] zza = new byte[0];
    private final zzje zzb;
    private final zzjd zzc;
    private final zziz zzd;
    private final int zze;
    private final zziy zzf;

    private zzjb(zzje zzjeVar, zzjd zzjdVar, zziy zziyVar, zziz zzizVar, int i4) {
        this.zzb = zzjeVar;
        this.zzc = zzjdVar;
        this.zzf = zziyVar;
        this.zzd = zzizVar;
        this.zze = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjb zzb(zzsu zzsuVar) throws GeneralSecurityException {
        int i4;
        zzje zzc;
        if (zzsuVar.zzk()) {
            if (zzsuVar.zze().zzl()) {
                if (!zzsuVar.zzf().zzp()) {
                    zzsr zzb = zzsuVar.zze().zzb();
                    zzjd zzb2 = zzjf.zzb(zzb);
                    zziy zzc2 = zzjf.zzc(zzb);
                    zziz zza2 = zzjf.zza(zzb);
                    int zzf = zzb.zzf();
                    int i5 = zzf - 2;
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 == 4) {
                                    i4 = 133;
                                } else {
                                    throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(zzsl.zza(zzf)));
                                }
                            } else {
                                i4 = 97;
                            }
                        } else {
                            i4 = 65;
                        }
                    } else {
                        i4 = 32;
                    }
                    int zzf2 = zzsuVar.zze().zzb().zzf() - 2;
                    if (zzf2 != 1) {
                        if (zzf2 != 2 && zzf2 != 3 && zzf2 != 4) {
                            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
                        }
                        zzc = zzjn.zzc(zzsuVar.zzf().zzq(), zzsuVar.zze().zzg().zzq(), zzjl.zzg(zzsuVar.zze().zzb().zzf()));
                    } else {
                        zzc = zzjp.zzc(zzsuVar.zzf().zzq());
                    }
                    return new zzjb(zzc, zzb2, zzc2, zza2, i4);
                }
                throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
            }
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i4 = this.zze;
        if (length >= i4) {
            byte[] copyOf = Arrays.copyOf(bArr, i4);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zze, length);
            zzje zzjeVar = this.zzb;
            zzjd zzjdVar = this.zzc;
            zziy zziyVar = this.zzf;
            zziz zzizVar = this.zzd;
            return zzja.zzb(copyOf, zzjdVar.zza(copyOf, zzjeVar), zzjdVar, zziyVar, zzizVar, new byte[0]).zza(copyOfRange, zza);
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
