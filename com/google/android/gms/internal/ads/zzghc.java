package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghc {
    @Deprecated
    static final zzglt zza;
    @Deprecated
    static final zzglt zzb;
    @Deprecated
    static final zzglt zzc;

    static {
        new zzggq();
        zzglt zzc2 = zzglt.zzc();
        zza = zzc2;
        zzb = zzc2;
        zzc = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e4) {
            throw new ExceptionInInitializerError(e4);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzghh.zze();
        zzggi.zzd();
        zzggq.zzh(true);
        if (zzgdi.zzb()) {
            return;
        }
        zzgfu.zzm(true);
    }
}
