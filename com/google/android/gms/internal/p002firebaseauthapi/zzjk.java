package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjk  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjk extends zzkm {
    public zzjk() {
        super(zzsx.class, new zzjj(zzbl.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzsx.zzf(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzsx zzsxVar = (zzsx) zzaiiVar;
        zzwf.zzc(zzsxVar.zza(), 0);
        if (zzsxVar.zzl()) {
            zzjl.zza(zzsxVar.zzb());
            return;
        }
        throw new GeneralSecurityException("Missing HPKE key params.");
    }
}
