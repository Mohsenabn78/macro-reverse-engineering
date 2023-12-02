package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzks  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzks {
    public static final zzon zza = new zzkr(null);

    public static zzot zza(zzcm zzcmVar) {
        zzbu zzbuVar;
        zzop zzopVar = new zzop();
        zzopVar.zzb(zzcmVar.zzb());
        for (List<zzci> list : zzcmVar.zzd()) {
            for (zzci zzciVar : list) {
                int zzh = zzciVar.zzh() - 2;
                if (zzh != 1) {
                    if (zzh != 2) {
                        if (zzh == 3) {
                            zzbuVar = zzbu.zzc;
                        } else {
                            throw new IllegalStateException("Unknown key status");
                        }
                    } else {
                        zzbuVar = zzbu.zzb;
                    }
                } else {
                    zzbuVar = zzbu.zza;
                }
                int zza2 = zzciVar.zza();
                String zzf = zzciVar.zzf();
                if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                    zzf = zzf.substring(34);
                }
                zzopVar.zza(zzbuVar, zza2, zzf, zzciVar.zzc().name());
            }
        }
        if (zzcmVar.zza() != null) {
            zzopVar.zzc(zzcmVar.zza().zza());
        }
        try {
            return zzopVar.zzd();
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
