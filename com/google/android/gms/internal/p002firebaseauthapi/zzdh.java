package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdh  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzdh extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh() {
        super(zzpg.class, new zzdf(zzbd.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzg(int i4, int i5, int i6, int i7, int i8, int i9) {
        zzpo zzb = zzpp.zzb();
        zzpr zzb2 = zzps.zzb();
        zzb2.zza(16);
        zzb.zzb((zzps) zzb2.zzi());
        zzb.zza(i4);
        zzsf zzc = zzsg.zzc();
        zzsi zzb3 = zzsj.zzb();
        zzb3.zzb(5);
        zzb3.zza(i7);
        zzc.zzb((zzsj) zzb3.zzi());
        zzc.zza(32);
        zzpi zza = zzpj.zza();
        zza.zza((zzpp) zzb.zzi());
        zza.zzb((zzsg) zzc.zzi());
        return new zzkk((zzpj) zza.zzi(), i9);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzdg(this, zzpj.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzpg.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpg zzpgVar = (zzpg) zzaiiVar;
        zzwf.zzc(zzpgVar.zza(), 0);
        new zzdv();
        zzdv.zzh(zzpgVar.zze());
        new zznp();
        zznp.zzi(zzpgVar.zzf());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final int zzf() {
        return 2;
    }
}
