package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzod  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzod implements zznd {
    private final zzmn zza;

    public zzod(zzmn zzmnVar) throws GeneralSecurityException {
        if (zzhk.zza(1)) {
            this.zza = zzmnVar;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
