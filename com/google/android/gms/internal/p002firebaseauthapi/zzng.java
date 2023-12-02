package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzng implements zzcn {
    private static final zzng zza = new zzng();

    private zzng() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd() throws GeneralSecurityException {
        zzcr.zzh(zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zza() {
        return zznd.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zzb() {
        return zznd.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final /* bridge */ /* synthetic */ Object zzc(zzcm zzcmVar) throws GeneralSecurityException {
        if (zzcmVar.zza() != null) {
            for (List<zzci> list : zzcmVar.zzd()) {
                for (zzci zzciVar : list) {
                    zznd zzndVar = (zznd) zzciVar.zzd();
                }
            }
            return new zznf(zzcmVar, null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
