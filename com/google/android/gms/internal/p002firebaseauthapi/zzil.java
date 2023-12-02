package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzil  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzil extends zzlt {
    private static final byte[] zza = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzil() {
        super(zzrn.class, zzrq.class, new zzij(zzbk.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzi(int i4, int i5, int i6, final zzbv zzbvVar, byte[] bArr, int i7) {
        zzrg zza2 = zzrh.zza();
        zzrs zza3 = zzrt.zza();
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzafy.zzn(bArr, 0, 0));
        zzrd zza4 = zzre.zza();
        zza4.zza((zzth) zzmi.zza(new zzmh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzii
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmh
            public final Object zza() {
                zzcf zza5 = zzbv.this.zza();
                if (zza5 instanceof zzkp) {
                    return ((zzkp) zza5).zza().zzc();
                }
                return ((zzlv) zzkz.zzc().zzd(zza5, zzlv.class)).zzc();
            }
        }));
        zzrj zzb = zzrk.zzb();
        zzb.zzb((zzrt) zza3.zzi());
        zzb.zza((zzre) zza4.zzi());
        zzb.zzc(i6);
        zza2.zza((zzrk) zzb.zzi());
        return new zzkk((zzrh) zza2.zzi(), i7);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzik(this, zzrh.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzrn.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzrn zzrnVar = (zzrn) zzaiiVar;
        if (!zzrnVar.zzf().zzp()) {
            zzwf.zzc(zzrnVar.zza(), 0);
            zziu.zza(zzrnVar.zze().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlt
    public final /* synthetic */ zzaii zzg(zzaii zzaiiVar) throws GeneralSecurityException {
        return ((zzrn) zzaiiVar).zze();
    }
}
