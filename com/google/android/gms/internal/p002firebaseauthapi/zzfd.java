package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzfd {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzez
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                zzui zzuiVar;
                zzey zzeyVar = (zzey) zzcfVar;
                int i4 = zzfd.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
                zzqg zzc2 = zzqh.zzc();
                zzc2.zza(zzeyVar.zza());
                zza2.zzc(((zzqh) zzc2.zzi()).zzo());
                zzew zzb3 = zzeyVar.zzb();
                if (zzew.zza.equals(zzb3)) {
                    zzuiVar = zzui.TINK;
                } else if (zzew.zzb.equals(zzb3)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zzew.zzc.equals(zzb3)) {
                    zzuiVar = zzui.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb3)));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zzey.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfa
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzfd.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfb
        }, zzeq.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzfd.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zzeq zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzqe zzd2 = zzqe.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    zzev zzevVar = new zzev(null);
                    zzevVar.zzb(zzd2.zze().zzd());
                    zzevVar.zza(12);
                    zzevVar.zzc(16);
                    zzevVar.zzd(zzd(zzluVar.zzc()));
                    zzey zze2 = zzevVar.zze();
                    zzeo zzeoVar = new zzeo(null);
                    zzeoVar.zzc(zze2);
                    zzeoVar.zzb(zzwj.zzb(zzd2.zze().zzq(), zzcsVar));
                    zzeoVar.zza(zzluVar.zzf());
                    return zzeoVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
    }

    public static /* synthetic */ zzey zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzqh zze2 = zzqh.zze(zzlvVar.zzc().zzf(), zzagq.zza());
                if (zze2.zzb() == 0) {
                    zzev zzevVar = new zzev(null);
                    zzevVar.zzb(zze2.zza());
                    zzevVar.zza(12);
                    zzevVar.zzc(16);
                    zzevVar.zzd(zzd(zzlvVar.zzc().zze()));
                    return zzevVar.zze();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzew zzd(zzui zzuiVar) throws GeneralSecurityException {
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
                    return zzew.zzc;
                }
            }
            return zzew.zzb;
        }
        return zzew.zza;
    }
}
