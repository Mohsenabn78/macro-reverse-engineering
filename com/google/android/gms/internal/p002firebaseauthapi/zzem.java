package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzem  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzem {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzei
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                zzui zzuiVar;
                zzeh zzehVar = (zzeh) zzcfVar;
                int i4 = zzem.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
                zzpx zzb3 = zzpy.zzb();
                zzqa zzb4 = zzqb.zzb();
                zzb4.zza(zzehVar.zza());
                zzb3.zzb((zzqb) zzb4.zzi());
                zzb3.zza(zzehVar.zzb());
                zza2.zzc(((zzpy) zzb3.zzi()).zzo());
                zzef zzc2 = zzehVar.zzc();
                if (zzef.zza.equals(zzc2)) {
                    zzuiVar = zzui.TINK;
                } else if (zzef.zzb.equals(zzc2)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zzef.zzc.equals(zzc2)) {
                    zzuiVar = zzui.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzc2)));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zzeh.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzej
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzem.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzek
        }, zzdz.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzel
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzem.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zzdz zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzpv zzd2 = zzpv.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    zzee zzeeVar = new zzee(null);
                    zzeeVar.zzb(zzd2.zzf().zzd());
                    zzeeVar.zza(zzd2.zze().zza());
                    zzeeVar.zzc(16);
                    zzeeVar.zzd(zzd(zzluVar.zzc()));
                    zzeh zze2 = zzeeVar.zze();
                    zzdx zzdxVar = new zzdx(null);
                    zzdxVar.zzc(zze2);
                    zzdxVar.zzb(zzwj.zzb(zzd2.zzf().zzq(), zzcsVar));
                    zzdxVar.zza(zzluVar.zzf());
                    return zzdxVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
    }

    public static /* synthetic */ zzeh zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzpy zzd2 = zzpy.zzd(zzlvVar.zzc().zzf(), zzagq.zza());
                zzee zzeeVar = new zzee(null);
                zzeeVar.zzb(zzd2.zza());
                zzeeVar.zza(zzd2.zze().zza());
                zzeeVar.zzc(16);
                zzeeVar.zzd(zzd(zzlvVar.zzc().zze()));
                return zzeeVar.zze();
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzef zzd(zzui zzuiVar) throws GeneralSecurityException {
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
                    return zzef.zzc;
                }
            }
            return zzef.zzb;
        }
        return zzef.zza;
    }
}
