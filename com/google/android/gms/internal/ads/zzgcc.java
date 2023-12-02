package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgcc {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnk zzb;
    private static final zzgeo zzc;
    private static final zzgek zzd;
    private static final zzgdr zze;
    private static final zzgdn zzf;

    static {
        zzgnk zza2 = zzgfm.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zza2;
        zzc = zzgeo.zzb(new zzgem() { // from class: com.google.android.gms.internal.ads.zzgby
            @Override // com.google.android.gms.internal.ads.zzgem
            public final zzgfd zza(zzfyf zzfyfVar) {
                zzglq zzglqVar;
                int i4 = zzgcc.zza;
                zzgko zza3 = zzgkp.zza();
                zza3.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
                zza3.zzc(zzgju.zzc().zzau());
                zzgbw zza4 = ((zzgbx) zzfyfVar).zza();
                if (zzgbw.zza.equals(zza4)) {
                    zzglqVar = zzglq.TINK;
                } else if (zzgbw.zzb.equals(zza4)) {
                    zzglqVar = zzglq.CRUNCHY;
                } else if (zzgbw.zzc.equals(zza4)) {
                    zzglqVar = zzglq.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(zza4.toString()));
                }
                zza3.zza(zzglqVar);
                return zzgfb.zza((zzgkp) zza3.zzal());
            }
        }, zzgbx.class, zzgfb.class);
        zzd = zzgek.zzb(new zzgei() { // from class: com.google.android.gms.internal.ads.zzgbz
            @Override // com.google.android.gms.internal.ads.zzgei
            public final zzfyf zza(zzgfd zzgfdVar) {
                return zzgcc.zzb((zzgfb) zzgfdVar);
            }
        }, zza2, zzgfb.class);
        zze = zzgdr.zza(new zzgdp() { // from class: com.google.android.gms.internal.ads.zzgca
        }, zzgbs.class, zzgfa.class);
        zzf = zzgdn.zzb(new zzgdl() { // from class: com.google.android.gms.internal.ads.zzgcb
            @Override // com.google.android.gms.internal.ads.zzgdl
            public final zzfxn zza(zzgfd zzgfdVar, zzfyq zzfyqVar) {
                return zzgcc.zza((zzgfa) zzgfdVar, zzfyqVar);
            }
        }, zza2, zzgfa.class);
    }

    public static /* synthetic */ zzgbs zza(zzgfa zzgfaVar, zzfyq zzfyqVar) {
        if (zzgfaVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgjr zze2 = zzgjr.zze(zzgfaVar.zze(), zzgoy.zza());
                if (zze2.zza() == 0) {
                    return zzgbs.zza(zzd(zzgfaVar.zzc()), zzgnl.zzb(zze2.zzf().zzA(), zzfyqVar), zzgfaVar.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgpy unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
    }

    public static /* synthetic */ zzgbx zzb(zzgfb zzgfbVar) {
        if (zzgfbVar.zzb().zzh().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgju.zzd(zzgfbVar.zzb().zzg(), zzgoy.zza());
                return zzgbx.zzb(zzd(zzgfbVar.zzb().zzf()));
            } catch (zzgpy e4) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters: ".concat(String.valueOf(zzgfbVar.zzb().zzh())));
    }

    public static void zzc(zzgeg zzgegVar) throws GeneralSecurityException {
        zzgegVar.zzh(zzc);
        zzgegVar.zzg(zzd);
        zzgegVar.zzf(zze);
        zzgegVar.zze(zzf);
    }

    private static zzgbw zzd(zzglq zzglqVar) throws GeneralSecurityException {
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
                    return zzgbw.zzc;
                }
            }
            return zzgbw.zzb;
        }
        return zzgbw.zza;
    }
}
