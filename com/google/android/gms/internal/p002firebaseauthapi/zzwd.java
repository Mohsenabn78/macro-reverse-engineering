package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwd implements zzce {
    private static final byte[] zza = {0};
    private final zzou zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzwd(zzmn zzmnVar) throws GeneralSecurityException {
        this.zzb = new zzwa(zzmnVar.zzd().zzc(zzbm.zza()));
        this.zzc = zzmnVar.zza().zza();
        this.zzd = zzmnVar.zzc().zzc();
        if (zzmnVar.zza().zzd().equals(zzmv.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzce zzb(zzmn zzmnVar) throws GeneralSecurityException {
        return new zzwd(zzmnVar);
    }

    public static zzce zzc(zznk zznkVar) throws GeneralSecurityException {
        return new zzwd(zznkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzb;
        byte[] bArr3 = this.zze;
        if (bArr3.length > 0) {
            zzb = zzuz.zzb(this.zzd, this.zzb.zza(zzuz.zzb(bArr2, bArr3), this.zzc));
        } else {
            zzb = zzuz.zzb(this.zzd, this.zzb.zza(bArr2, this.zzc));
        }
        if (MessageDigest.isEqual(zzb, bArr)) {
            return;
        }
        throw new GeneralSecurityException("invalid MAC");
    }

    private zzwd(zznk zznkVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(zznkVar.zzd().zze());
        this.zzb = new zzwc("HMAC".concat(valueOf), new SecretKeySpec(zznkVar.zze().zzc(zzbm.zza()), "HMAC"));
        this.zzc = zznkVar.zzd().zza();
        this.zzd = zznkVar.zzc().zzc();
        if (zznkVar.zzd().zzf().equals(zznt.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzwd(zzou zzouVar, int i4) throws GeneralSecurityException {
        this.zzb = zzouVar;
        this.zzc = i4;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i4 >= 10) {
            zzouVar.zza(new byte[0], i4);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
}
