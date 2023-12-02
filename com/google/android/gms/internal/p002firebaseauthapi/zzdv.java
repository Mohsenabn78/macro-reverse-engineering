package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzdv extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv() {
        super(zzpm.class, new zzdt(zzvz.class));
    }

    public static final void zzh(zzpm zzpmVar) throws GeneralSecurityException {
        zzwf.zzc(zzpmVar.zza(), 0);
        zzwf.zzb(zzpmVar.zzg().zzd());
        zzi(zzpmVar.zzf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzi(zzps zzpsVar) throws GeneralSecurityException {
        if (zzpsVar.zza() >= 12 && zzpsVar.zza() <= 16) {
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzdu(this, zzpp.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzpm.zze(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzh((zzpm) zzaiiVar);
    }
}
