package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
/* loaded from: classes4.dex */
final class zznc {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmy
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                zzui zzuiVar;
                zzmx zzmxVar = (zzmx) zzcfVar;
                int i4 = zznc.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
                zzoz zzb3 = zzpa.zzb();
                zzpc zzb4 = zzpd.zzb();
                zzb4.zza(zzmxVar.zza());
                zzb3.zzb((zzpd) zzb4.zzi());
                zzb3.zza(zzmxVar.zzb());
                zza2.zzc(((zzpa) zzb3.zzi()).zzo());
                zzmv zzd2 = zzmxVar.zzd();
                if (zzmv.zza.equals(zzd2)) {
                    zzuiVar = zzui.TINK;
                } else if (zzmv.zzb.equals(zzd2)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zzmv.zzd.equals(zzd2)) {
                    zzuiVar = zzui.RAW;
                } else if (zzmv.zzc.equals(zzd2)) {
                    zzuiVar = zzui.LEGACY;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzd2)));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zzmx.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmz
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zznc.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzna
        }, zzmn.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zznb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zznc.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zzmn zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzox zzd2 = zzox.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    zzmu zzmuVar = new zzmu(null);
                    zzmuVar.zza(zzd2.zzf().zzd());
                    zzmuVar.zzb(zzd2.zze().zza());
                    zzmuVar.zzc(zzd(zzluVar.zzc()));
                    zzmx zzd3 = zzmuVar.zzd();
                    zzml zzmlVar = new zzml(null);
                    zzmlVar.zzc(zzd3);
                    zzmlVar.zza(zzwj.zzb(zzd2.zzf().zzq(), zzcsVar));
                    zzmlVar.zzb(zzluVar.zzf());
                    return zzmlVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
    }

    public static /* synthetic */ zzmx zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzpa zzd2 = zzpa.zzd(zzlvVar.zzc().zzf(), zzagq.zza());
                zzmu zzmuVar = new zzmu(null);
                zzmuVar.zza(zzd2.zza());
                zzmuVar.zzb(zzd2.zze().zza());
                zzmuVar.zzc(zzd(zzlvVar.zzc().zze()));
                return zzmuVar.zzd();
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzmv zzd(zzui zzuiVar) throws GeneralSecurityException {
        zzui zzuiVar2 = zzui.UNKNOWN_PREFIX;
        int ordinal = zzuiVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return zzmv.zzb;
                    }
                    int zza2 = zzuiVar.zza();
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                }
                return zzmv.zzd;
            }
            return zzmv.zzc;
        }
        return zzmv.zza;
    }
}
