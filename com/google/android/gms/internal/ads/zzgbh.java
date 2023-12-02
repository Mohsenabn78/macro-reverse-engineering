package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgbh extends zzgdu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgbh() {
        super(zzgjl.class, new zzgbf(zzfxh.class));
    }

    public static void zzg(boolean z3) throws GeneralSecurityException {
        if (zzm()) {
            zzfyp.zze(new zzgbh(), true);
            int i4 = zzgbr.zza;
            zzgbr.zzc(zzgeg.zzc());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzgds zzh(int i4, int i5) {
        zzgjn zzc = zzgjo.zzc();
        zzc.zza(i4);
        return new zzgds((zzgjo) zzc.zzal(), i5);
    }

    private static boolean zzm() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgdt zza() {
        return new zzgbg(this, zzgjo.class);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* synthetic */ zzgqw zzc(zzgoe zzgoeVar) throws zzgpy {
        return zzgjl.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgjl zzgjlVar = (zzgjl) zzgqwVar;
        zzgni.zzb(zzgjlVar.zza(), 0);
        zzgni.zza(zzgjlVar.zzf().zzd());
    }
}
