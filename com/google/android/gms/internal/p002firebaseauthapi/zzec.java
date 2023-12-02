package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzec  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzec extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec() {
        super(zzpv.class, new zzea(zzbd.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzg(int i4, int i5, int i6) {
        zzpx zzb = zzpy.zzb();
        zzb.zza(i4);
        zzqa zzb2 = zzqb.zzb();
        zzb2.zza(16);
        zzb.zzb((zzqb) zzb2.zzi());
        return new zzkk((zzpy) zzb.zzi(), i6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzeb(this, zzpy.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzpv.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpv zzpvVar = (zzpv) zzaiiVar;
        zzwf.zzc(zzpvVar.zza(), 0);
        zzwf.zzb(zzpvVar.zzf().zzd());
        if (zzpvVar.zze().zza() != 12 && zzpvVar.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
