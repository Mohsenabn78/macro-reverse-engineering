package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgaj {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zza2;
        zzc = zzgeo.zzb(new zzgem() { // from class: com.google.android.gms.internal.ads.zzgaf
            @Override // com.google.android.gms.internal.ads.zzgem
            public final zzgfd zza(zzfyf zzfyfVar) {
                zzglq zzglqVar;
                zzgae zzgaeVar = (zzgae) zzfyfVar;
                int i4 = zzgaj.zza;
                zzgko zza3 = zzgkp.zza();
                zza3.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
                zzgiy zzc2 = zzgiz.zzc();
                zzgjb zzc3 = zzgjc.zzc();
                zzc3.zza(zzgaeVar.zza());
                zzc2.zzb((zzgjc) zzc3.zzal());
                zzc2.zza(zzgaeVar.zzb());
                zza3.zzc(((zzgiz) zzc2.zzal()).zzau());
                zzgac zzc4 = zzgaeVar.zzc();
                if (zzgac.zza.equals(zzc4)) {
                    zzglqVar = zzglq.TINK;
                } else if (zzgac.zzb.equals(zzc4)) {
                    zzglqVar = zzglq.CRUNCHY;
                } else if (zzgac.zzc.equals(zzc4)) {
                    zzglqVar = zzglq.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzc4)));
                }
                zza3.zza(zzglqVar);
                return zzgfb.zza((zzgkp) zza3.zzal());
            }
        }, zzgae.class, zzgfb.class);
        zzd = zzgek.zzb(new zzgei() { // from class: com.google.android.gms.internal.ads.zzgag
            @Override // com.google.android.gms.internal.ads.zzgei
            public final zzfyf zza(zzgfd zzgfdVar) {
                return zzgaj.zzb((zzgfb) zzgfdVar);
            }
        }, zza2, zzgfb.class);
        zze = zzgdr.zza(new zzgdp() { // from class: com.google.android.gms.internal.ads.zzgah
        }, zzfzw.class, zzgfa.class);
        zzf = zzgdn.zzb(new zzgdl() { // from class: com.google.android.gms.internal.ads.zzgai
            @Override // com.google.android.gms.internal.ads.zzgdl
            public final zzfxn zza(zzgfd zzgfdVar, zzfyq zzfyqVar) {
                return zzgaj.zza((zzgfa) zzgfdVar, zzfyqVar);
            }
        }, zza2, zzgfa.class);
    }

    public static /* synthetic */ zzfzw zza(zzgfa zzgfaVar, zzfyq zzfyqVar) {
        if (zzgfaVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgiw zze2 = zzgiw.zze(zzgfaVar.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    zzgab zzgabVar = new zzgab(null);
                    zzgabVar.zzb(zze2.zzg().zzd());
                    zzgabVar.zza(zze2.zzf().zza());
                    zzgabVar.zzc(16);
                    zzgabVar.zzd(zzd(zzgfaVar.zzc()));
                    zzgae zze3 = zzgabVar.zze();
                    zzfzu zzfzuVar = new zzfzu(null);
                    zzfzuVar.zzc(zze3);
                    zzfzuVar.zzb(zzgnl.zzb(zze2.zzg().zzA(), zzfyqVar));
                    zzfzuVar.zza(zzgfaVar.zzf());
                    return zzfzuVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
    }

    public static /* synthetic */ zzgae zzb(zzgfb zzgfbVar) {
        if (zzgfbVar.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgiz zze2 = zzgiz.zze(zzgfbVar.zzb().zzg(), zzgoy.zza());
                zzgab zzgabVar = new zzgab(null);
                zzgabVar.zzb(zze2.zza());
                zzgabVar.zza(zze2.zzf().zza());
                zzgabVar.zzc(16);
                zzgabVar.zzd(zzd(zzgfbVar.zzb().zzf()));
                return zzgabVar.zze();
            } catch (zzgpy e4) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: ".concat(String.valueOf(zzgfbVar.zzb().zzh())));
    }

    public static void zzc(zzgeg zzgegVar) throws GeneralSecurityException {
        zzgegVar.zzh(zzc);
        zzgegVar.zzg(zzd);
        zzgegVar.zzf(zze);
        zzgegVar.zze(zzf);
    }

    private static zzgac zzd(zzglq zzglqVar) throws GeneralSecurityException {
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
                    return zzgac.zzc;
                }
            }
            return zzgac.zzb;
        }
        return zzgac.zza;
    }
}
