package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzda  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzda implements zzcn {
    private static final Logger zza = Logger.getLogger(zzda.class.getName());
    private static final zzda zzb = new zzda();

    zzda() {
    }

    public static void zze() throws GeneralSecurityException {
        zzcr.zzh(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zza() {
        return zzbd.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zzb() {
        return zzbd.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final /* synthetic */ Object zzc(zzcm zzcmVar) throws GeneralSecurityException {
        return new zzcz(zzcmVar, null);
    }
}
