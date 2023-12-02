package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzji  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzji extends zzlt {
    public zzji() {
        super(zzsu.class, zzsx.class, new zzjg(zzbk.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzh(int i4, int i5, int i6, int i7) {
        zzsq zza = zzsr.zza();
        zza.zzc(i4);
        zza.zzb(i5);
        zza.zza(i6);
        zzsn zza2 = zzso.zza();
        zza2.zza((zzsr) zza.zzi());
        return new zzkk((zzso) zza2.zzi(), i7);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzjh(this, zzso.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzsu.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzsu zzsuVar = (zzsu) zzaiiVar;
        if (!zzsuVar.zzf().zzp()) {
            if (zzsuVar.zzk()) {
                zzwf.zzc(zzsuVar.zza(), 0);
                zzjl.zza(zzsuVar.zze().zzb());
                return;
            }
            throw new GeneralSecurityException("Missing public key.");
        }
        throw new GeneralSecurityException("Private key is empty.");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlt
    public final /* synthetic */ zzaii zzg(zzaii zzaiiVar) throws GeneralSecurityException {
        return ((zzsu) zzaiiVar).zze();
    }
}
