package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgne implements zzfye {
    private final zzghv zza;
    private final int zzb;

    public zzgne(zzghv zzghvVar, int i4) throws GeneralSecurityException {
        this.zza = zzghvVar;
        this.zzb = i4;
        if (i4 >= 10) {
            zzghvVar.zza(new byte[0], i4);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // com.google.android.gms.internal.ads.zzfye
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (MessageDigest.isEqual(this.zza.zza(bArr2, this.zzb), bArr)) {
            return;
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
