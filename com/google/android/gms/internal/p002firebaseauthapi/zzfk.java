package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfk  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzfk extends zzkm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfk() {
        super(zzqk.class, new zzfi(zzbd.class));
    }

    public static void zzg(boolean z3) throws GeneralSecurityException {
        if (zzi()) {
            zzcr.zzg(new zzfk(), true);
            int i4 = zzfu.zza;
            zzfu.zzc(zzkz.zzc());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzh(int i4, int i5) {
        zzqm zzc = zzqn.zzc();
        zzc.zza(i4);
        return new zzkk((zzqn) zzc.zzi(), i5);
    }

    private static boolean zzi() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzfj(this, zzqn.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzqk.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzqk zzqkVar = (zzqk) zzaiiVar;
        zzwf.zzc(zzqkVar.zza(), 0);
        zzwf.zzb(zzqkVar.zze().zzd());
    }
}
