package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghk implements zzggf {
    private final zzggm zza;

    public zzghk(zzggm zzggmVar) throws GeneralSecurityException {
        if (zzgdh.zza(2)) {
            this.zza = zzggmVar;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
