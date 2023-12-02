package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzcu {
    public static final String zza;
    public static final String zzb;
    @Deprecated
    static final zzul zzc;
    @Deprecated
    static final zzul zzd;
    @Deprecated
    static final zzul zze;

    static {
        new zzdh();
        zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new zzet();
        zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new zzfk();
        new zzec();
        new zzgi();
        new zzgm();
        new zzfy();
        new zzgq();
        zzul zzb2 = zzul.zzb();
        zzc = zzb2;
        zzd = zzb2;
        zze = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e4) {
            throw new ExceptionInInitializerError(e4);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzda.zze();
        zznw.zza();
        zzcr.zzg(new zzdh(), true);
        int i4 = zzds.zza;
        zzds.zzc(zzkz.zzc());
        zzcr.zzg(new zzet(), true);
        int i5 = zzfd.zza;
        zzfd.zzc(zzkz.zzc());
        if (zzhl.zzb()) {
            return;
        }
        zzcr.zzg(new zzec(), true);
        int i6 = zzem.zza;
        zzem.zzc(zzkz.zzc());
        zzfk.zzg(true);
        zzcr.zzg(new zzfy(), true);
        int i7 = zzgf.zza;
        zzgf.zzc(zzkz.zzc());
        zzcr.zzg(new zzgi(), true);
        zzcr.zzg(new zzgm(), true);
        zzcr.zzg(new zzgq(), true);
        int i8 = zzgx.zza;
        zzgx.zzc(zzkz.zzc());
    }
}
