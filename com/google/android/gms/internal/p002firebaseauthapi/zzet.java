package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzet  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzet extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzet() {
        super(zzqe.class, new zzer(zzbd.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzg(int i4, int i5) {
        zzqg zzc = zzqh.zzc();
        zzc.zza(i4);
        return new zzkk((zzqh) zzc.zzi(), i5);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzes(this, zzqh.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzqe.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqe zzqeVar = (zzqe) zzaiiVar;
        zzwf.zzc(zzqeVar.zza(), 0);
        zzwf.zzb(zzqeVar.zze().zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final int zzf() {
        return 2;
    }
}
