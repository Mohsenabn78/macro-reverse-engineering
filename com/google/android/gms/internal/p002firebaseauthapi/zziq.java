package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zziq implements zzcn {
    private static final Logger zza = Logger.getLogger(zziq.class.getName());
    private static final zziq zzb = new zziq();

    zziq() {
    }

    public static void zze() throws GeneralSecurityException {
        zzcr.zzh(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zza() {
        return zzbk.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zzb() {
        return zzbk.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final /* synthetic */ Object zzc(zzcm zzcmVar) throws GeneralSecurityException {
        return new zzip(zzcmVar);
    }
}
