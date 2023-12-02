package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhg  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzhg extends zzhe {
    public zzhg(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhe
    final zzhc zza(byte[] bArr, int i4) throws InvalidKeyException {
        return new zzhf(bArr, i4);
    }
}
