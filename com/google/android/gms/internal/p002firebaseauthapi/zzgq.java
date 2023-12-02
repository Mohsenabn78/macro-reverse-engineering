package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzgq extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq() {
        super(zzuo.class, new zzgo(zzbd.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzgp(this, zzur.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzuo.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzuo zzuoVar = (zzuo) zzaiiVar;
        zzwf.zzc(zzuoVar.zza(), 0);
        if (zzuoVar.zze().zzd() == 32) {
            return;
        }
        throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
    }
}
