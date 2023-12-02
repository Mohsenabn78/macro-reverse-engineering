package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfu  reason: invalid package */
/* loaded from: classes4.dex */
final class zzfu {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfq
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                zzui zzuiVar;
                zzfp zzfpVar = (zzfp) zzcfVar;
                int i4 = zzfu.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
                zzqm zzc2 = zzqn.zzc();
                zzc2.zza(zzfpVar.zza());
                zza2.zzc(((zzqn) zzc2.zzi()).zzo());
                zzfn zzb3 = zzfpVar.zzb();
                if (zzfn.zza.equals(zzb3)) {
                    zzuiVar = zzui.TINK;
                } else if (zzfn.zzb.equals(zzb3)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zzfn.zzc.equals(zzb3)) {
                    zzuiVar = zzui.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb3)));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zzfp.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfr
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzfu.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfs
        }, zzfh.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzft
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzfu.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zzfh zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzqk zzd2 = zzqk.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    zzfm zzfmVar = new zzfm(null);
                    zzfmVar.zza(zzd2.zze().zzd());
                    zzfmVar.zzb(zzd(zzluVar.zzc()));
                    zzfp zzc2 = zzfmVar.zzc();
                    zzff zzffVar = new zzff(null);
                    zzffVar.zzc(zzc2);
                    zzffVar.zzb(zzwj.zzb(zzd2.zze().zzq(), zzcsVar));
                    zzffVar.zza(zzluVar.zzf());
                    return zzffVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
    }

    public static /* synthetic */ zzfp zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzqn zze2 = zzqn.zze(zzlvVar.zzc().zzf(), zzagq.zza());
                if (zze2.zzb() == 0) {
                    zzfm zzfmVar = new zzfm(null);
                    zzfmVar.zza(zze2.zza());
                    zzfmVar.zzb(zzd(zzlvVar.zzc().zze()));
                    return zzfmVar.zzc();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzfn zzd(zzui zzuiVar) throws GeneralSecurityException {
        zzui zzuiVar2 = zzui.UNKNOWN_PREFIX;
        int ordinal = zzuiVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        int zza2 = zzuiVar.zza();
                        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                    }
                } else {
                    return zzfn.zzc;
                }
            }
            return zzfn.zzb;
        }
        return zzfn.zza;
    }
}
