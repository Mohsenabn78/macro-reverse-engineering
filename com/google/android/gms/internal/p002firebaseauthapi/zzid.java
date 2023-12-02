package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzid  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzid {
    public static final String zza;
    @Deprecated
    static final zzul zzb;
    @Deprecated
    static final zzul zzc;

    static {
        new zzhs();
        zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
        zzb = zzul.zzb();
        zzc = zzul.zzb();
        try {
            zza();
        } catch (GeneralSecurityException e4) {
            throw new ExceptionInInitializerError(e4);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzih.zze();
        if (zzhl.zzb()) {
            return;
        }
        zzcr.zzg(new zzhs(), true);
        int i4 = zzic.zza;
        zzic.zzd(zzkz.zzc());
    }
}
