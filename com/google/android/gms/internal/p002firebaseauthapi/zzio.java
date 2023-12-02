package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzio  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzio {
    @Deprecated
    static final zzul zza;
    @Deprecated
    static final zzul zzb;
    @Deprecated
    static final zzul zzc;

    static {
        new zzin();
        new zzil();
        zza = zzul.zzb();
        zzb = zzul.zzb();
        zzc = zzul.zzb();
        try {
            zza();
        } catch (GeneralSecurityException e4) {
            throw new ExceptionInInitializerError(e4);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zziq.zze();
        zzis.zzd();
        zzcu.zza();
        zzid.zza();
        if (zzhl.zzb()) {
            return;
        }
        zzcr.zzf(new zzil(), new zzin(), true);
        zzcr.zzf(new zzji(), new zzjk(), true);
    }
}
