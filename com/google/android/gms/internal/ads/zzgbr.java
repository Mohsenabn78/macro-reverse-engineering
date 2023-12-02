package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgbr {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zza2;
        zzc = zzgeo.zzb(new zzgem() { // from class: com.google.android.gms.internal.ads.zzgbn
            @Override // com.google.android.gms.internal.ads.zzgem
            public final zzgfd zza(zzfyf zzfyfVar) {
                zzglq zzglqVar;
                zzgbm zzgbmVar = (zzgbm) zzfyfVar;
                int i4 = zzgbr.zza;
                zzgko zza3 = zzgkp.zza();
                zza3.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
                zzgjn zzc2 = zzgjo.zzc();
                zzc2.zza(zzgbmVar.zza());
                zza3.zzc(((zzgjo) zzc2.zzal()).zzau());
                zzgbk zzb2 = zzgbmVar.zzb();
                if (zzgbk.zza.equals(zzb2)) {
                    zzglqVar = zzglq.TINK;
                } else if (zzgbk.zzb.equals(zzb2)) {
                    zzglqVar = zzglq.CRUNCHY;
                } else if (zzgbk.zzc.equals(zzb2)) {
                    zzglqVar = zzglq.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb2)));
                }
                zza3.zza(zzglqVar);
                return zzgfb.zza((zzgkp) zza3.zzal());
            }
        }, zzgbm.class, zzgfb.class);
        zzd = zzgek.zzb(new zzgei() { // from class: com.google.android.gms.internal.ads.zzgbo
            @Override // com.google.android.gms.internal.ads.zzgei
            public final zzfyf zza(zzgfd zzgfdVar) {
                return zzgbr.zzb((zzgfb) zzgfdVar);
            }
        }, zza2, zzgfb.class);
        zze = zzgdr.zza(new zzgdp() { // from class: com.google.android.gms.internal.ads.zzgbp
        }, zzgbe.class, zzgfa.class);
        zzf = zzgdn.zzb(new zzgdl() { // from class: com.google.android.gms.internal.ads.zzgbq
            @Override // com.google.android.gms.internal.ads.zzgdl
            public final zzfxn zza(zzgfd zzgfdVar, zzfyq zzfyqVar) {
                return zzgbr.zza((zzgfa) zzgfdVar, zzfyqVar);
            }
        }, zza2, zzgfa.class);
    }

    public static /* synthetic */ zzgbe zza(zzgfa zzgfaVar, zzfyq zzfyqVar) {
        if (zzgfaVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgjl zze2 = zzgjl.zze(zzgfaVar.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzgbj zzgbjVar = new zzgbj(null);
                    zzgbjVar.zza(zze2.zzf().zzd());
                    zzgbjVar.zzb(zzd(zzgfaVar.zzc()));
                    zzgbm zzc2 = zzgbjVar.zzc();
                    zzgbc zzgbcVar = new zzgbc(null);
                    zzgbcVar.zzc(zzc2);
                    zzgbcVar.zzb(zzgnl.zzb(zze2.zzf().zzA(), zzfyqVar));
                    zzgbcVar.zza(zzgfaVar.zzf());
                    return zzgbcVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
    }

    public static /* synthetic */ zzgbm zzb(zzgfb zzgfbVar) {
        if (zzgfbVar.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgjo zze2 = zzgjo.zze(zzgfbVar.zzb().zzg(), zzgoy.zza());
                zzgbj zzgbjVar = new zzgbj(null);
                zzgbjVar.zza(zze2.zza());
                zzgbjVar.zzb(zzd(zzgfbVar.zzb().zzf()));
                return zzgbjVar.zzc();
            } catch (zzgpy e4) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters: ".concat(String.valueOf(zzgfbVar.zzb().zzh())));
    }

    public static void zzc(zzgeg zzgegVar) throws GeneralSecurityException {
        zzgegVar.zzh(zzc);
        zzgegVar.zzg(zzd);
        zzgegVar.zzf(zze);
        zzgegVar.zze(zzf);
    }

    private static zzgbk zzd(zzglq zzglqVar) throws GeneralSecurityException {
        zzglq zzglqVar2 = zzglq.UNKNOWN_PREFIX;
        int ordinal = zzglqVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        int zza2 = zzglqVar.zza();
                        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                    }
                } else {
                    return zzgbk.zzc;
                }
            }
            return zzgbk.zzb;
        }
        return zzgbk.zza;
    }
}
