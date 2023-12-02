package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzob  reason: invalid package */
/* loaded from: classes4.dex */
final class zzob implements zzcn {
    private static final Logger zza = Logger.getLogger(zzob.class.getName());
    private static final byte[] zzb = {0};
    private static final zzob zzc = new zzob();

    zzob() {
    }

    public static void zze() throws GeneralSecurityException {
        zzcr.zzh(zzc);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zza() {
        return zzce.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final Class zzb() {
        return zzce.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcn
    public final /* bridge */ /* synthetic */ Object zzc(zzcm zzcmVar) throws GeneralSecurityException {
        for (List<zzci> list : zzcmVar.zzd()) {
            for (zzci zzciVar : list) {
                if (zzciVar.zzb() instanceof zznx) {
                    zznx zznxVar = (zznx) zzciVar.zzb();
                    zzwi zzb2 = zzwi.zzb(zzciVar.zzg());
                    if (!zzb2.equals(zznxVar.zzc())) {
                        String valueOf = String.valueOf(zznxVar.zzb());
                        String obj = zznxVar.zzc().toString();
                        String obj2 = zzb2.toString();
                        throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                    }
                }
            }
        }
        return new zzoa(zzcmVar, null);
    }
}
