package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzih  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzih implements zzcn {
    private static final Logger zza = Logger.getLogger(zzih.class.getName());
    private static final zzih zzb = new zzih();

    zzih() {
    }

    public static void zze() throws GeneralSecurityException {
        zzcr.zzh(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zza() {
        return zzbj.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zzb() {
        return zzbj.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final /* synthetic */ Object zzc(zzcm zzcmVar) throws GeneralSecurityException {
        return new zzig(zzcmVar);
    }
}
