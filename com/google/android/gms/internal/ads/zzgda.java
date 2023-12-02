package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgda extends zzgdb {
    public zzgda(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    final zzgcz zza(byte[] bArr, int i4) throws InvalidKeyException {
        return new zzgcy(bArr, i4);
    }
}
