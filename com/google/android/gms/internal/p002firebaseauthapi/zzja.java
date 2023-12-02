package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@ThreadSafe
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja  reason: invalid package */
/* loaded from: classes4.dex */
final class zzja {
    private static final byte[] zza = new byte[0];
    private final zziz zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    @GuardedBy("this")
    private BigInteger zzg = BigInteger.ZERO;

    private zzja(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zziz zzizVar) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzizVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzja zzb(byte[] bArr, byte[] bArr2, zzjd zzjdVar, zziy zziyVar, zziz zzizVar, byte[] bArr3) throws GeneralSecurityException {
        byte[] zzb = zzjl.zzb(zzjdVar.zzb(), zziyVar.zzc(), zzizVar.zzb());
        byte[] bArr4 = zzjl.zzl;
        byte[] bArr5 = zza;
        byte[] zzb2 = zzuz.zzb(zzjl.zza, zziyVar.zze(bArr4, bArr5, "psk_id_hash", zzb), zziyVar.zze(bArr4, bArr3, "info_hash", zzb));
        byte[] zze = zziyVar.zze(bArr2, bArr5, "secret", zzb);
        byte[] zzd = zziyVar.zzd(zze, zzb2, "key", zzb, zzizVar.zza());
        byte[] zzd2 = zziyVar.zzd(zze, zzb2, "base_nonce", zzb, 12);
        BigInteger bigInteger = BigInteger.ONE;
        return new zzja(bArr, zzd, zzd2, bigInteger.shiftLeft(96).subtract(bigInteger), zzizVar);
    }

    private final synchronized byte[] zzc() throws GeneralSecurityException {
        byte[] zzc;
        byte[] bArr = this.zze;
        BigInteger bigInteger = this.zzg;
        if (bigInteger.signum() != -1) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length != 12) {
                if (length <= 13) {
                    if (length == 13) {
                        if (byteArray[0] == 0) {
                            byteArray = Arrays.copyOfRange(byteArray, 1, 13);
                        } else {
                            throw new GeneralSecurityException("integer too large");
                        }
                    } else {
                        byte[] bArr2 = new byte[12];
                        System.arraycopy(byteArray, 0, bArr2, 12 - length, length);
                        byteArray = bArr2;
                    }
                } else {
                    throw new GeneralSecurityException("integer too large");
                }
            }
            zzc = zzuz.zzc(bArr, byteArray);
            if (this.zzg.compareTo(this.zzc) < 0) {
                this.zzg = this.zzg.add(BigInteger.ONE);
            } else {
                throw new GeneralSecurityException("message limit reached");
            }
        } else {
            throw new IllegalArgumentException("integer must be nonnegative");
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zzc(this.zzd, zzc(), bArr, bArr2);
    }
}
