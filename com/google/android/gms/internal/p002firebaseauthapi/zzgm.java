package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzgm extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgm() {
        super(zzud.class, new zzgk(zzbd.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzgl(this, zzug.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.REMOTE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzud.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzud zzudVar = (zzud) zzaiiVar;
        zzwf.zzc(zzudVar.zza(), 0);
        if (zzgj.zzc(zzudVar.zze().zza().zzg())) {
            return;
        }
        String zzg = zzudVar.zze().zza().zzg();
        throw new GeneralSecurityException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
    }
}
