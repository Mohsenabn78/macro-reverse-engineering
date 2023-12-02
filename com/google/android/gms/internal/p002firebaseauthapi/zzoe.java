package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoe  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzoe implements zznd {
    private final zznk zza;

    public zzoe(zznk zznkVar) throws GeneralSecurityException {
        if (zzhk.zza(2)) {
            this.zza = zznkVar;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
