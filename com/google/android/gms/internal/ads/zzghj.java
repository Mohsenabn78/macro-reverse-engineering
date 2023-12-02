package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghj implements zzggf {
    private final zzgfq zza;

    public zzghj(zzgfq zzgfqVar) throws GeneralSecurityException {
        if (zzgdh.zza(1)) {
            this.zza = zzgfqVar;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
