package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgl  reason: invalid package */
/* loaded from: classes4.dex */
final class zzgl extends zzkl {
    final /* synthetic */ zzgm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgl(zzgm zzgmVar, Class cls) {
        super(cls);
        this.zza = zzgmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzuc zzb = zzud.zzb();
        zzb.zza((zzug) zzaiiVar);
        zzb.zzb(0);
        return (zzud) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzug.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzug zzugVar = (zzug) zzaiiVar;
        if (zzgj.zzc(zzugVar.zza().zzg())) {
            if (!zzugVar.zze().isEmpty() && zzugVar.zzf()) {
                return;
            }
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
        String zzg = zzugVar.zza().zzg();
        throw new GeneralSecurityException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
    }
}
