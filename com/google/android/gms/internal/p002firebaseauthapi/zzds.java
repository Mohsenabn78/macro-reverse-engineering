package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzds {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdo
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                int i4;
                zzui zzuiVar;
                zzdn zzdnVar = (zzdn) zzcfVar;
                int i5 = zzds.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
                zzpi zza3 = zzpj.zza();
                zzpo zzb3 = zzpp.zzb();
                zzpr zzb4 = zzps.zzb();
                zzb4.zza(zzdnVar.zzc());
                zzb3.zzb((zzps) zzb4.zzi());
                zzb3.zza(zzdnVar.zza());
                zza3.zza((zzpp) zzb3.zzi());
                zzsf zzc2 = zzsg.zzc();
                zzsi zzb5 = zzsj.zzb();
                zzb5.zza(zzdnVar.zzd());
                zzdk zze2 = zzdnVar.zze();
                if (zzdk.zza.equals(zze2)) {
                    i4 = 3;
                } else if (zzdk.zzb.equals(zze2)) {
                    i4 = 7;
                } else if (zzdk.zzc.equals(zze2)) {
                    i4 = 5;
                } else if (zzdk.zzd.equals(zze2)) {
                    i4 = 4;
                } else if (zzdk.zze.equals(zze2)) {
                    i4 = 6;
                } else {
                    throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zze2)));
                }
                zzb5.zzb(i4);
                zzc2.zzb((zzsj) zzb5.zzi());
                zzc2.zza(zzdnVar.zzb());
                zza3.zzb((zzsg) zzc2.zzi());
                zza2.zzc(((zzpj) zza3.zzi()).zzo());
                zzdl zzf2 = zzdnVar.zzf();
                if (zzdl.zza.equals(zzf2)) {
                    zzuiVar = zzui.TINK;
                } else if (zzdl.zzb.equals(zzf2)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zzdl.zzc.equals(zzf2)) {
                    zzuiVar = zzui.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzf2)));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zzdn.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdp
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzds.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdq
        }, zzde.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdr
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzds.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zzde zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzpg zzd2 = zzpg.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    if (zzd2.zze().zza() == 0) {
                        if (zzd2.zzf().zza() == 0) {
                            zzdj zzdjVar = new zzdj(null);
                            zzdjVar.zza(zzd2.zze().zzg().zzd());
                            zzdjVar.zzc(zzd2.zzf().zzg().zzd());
                            zzdjVar.zzd(zzd2.zze().zzf().zza());
                            zzdjVar.zze(zzd2.zzf().zzf().zza());
                            zzdjVar.zzb(zze(zzd2.zzf().zzf().zzf()));
                            zzdjVar.zzf(zzd(zzluVar.zzc()));
                            zzdn zzg = zzdjVar.zzg();
                            zzdc zzdcVar = new zzdc(null);
                            zzdcVar.zzd(zzg);
                            zzdcVar.zza(zzwj.zzb(zzd2.zze().zzg().zzq(), zzcsVar));
                            zzdcVar.zzb(zzwj.zzb(zzd2.zzf().zzg().zzq(), zzcsVar));
                            zzdcVar.zzc(zzluVar.zzf());
                            return zzdcVar.zze();
                        }
                        throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                    }
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
    }

    public static /* synthetic */ zzdn zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzpj zzc2 = zzpj.zzc(zzlvVar.zzc().zzf(), zzagq.zza());
                if (zzc2.zze().zzb() == 0) {
                    zzdj zzdjVar = new zzdj(null);
                    zzdjVar.zza(zzc2.zzd().zza());
                    zzdjVar.zzc(zzc2.zze().zza());
                    zzdjVar.zzd(zzc2.zzd().zzf().zza());
                    zzdjVar.zze(zzc2.zze().zzg().zza());
                    zzdjVar.zzb(zze(zzc2.zze().zzg().zzf()));
                    zzdjVar.zzf(zzd(zzlvVar.zzc().zze()));
                    return zzdjVar.zzg();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzdl zzd(zzui zzuiVar) throws GeneralSecurityException {
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
                    return zzdl.zzc;
                }
            }
            return zzdl.zzb;
        }
        return zzdl.zza;
    }

    private static zzdk zze(int i4) throws GeneralSecurityException {
        zzui zzuiVar = zzui.UNKNOWN_PREFIX;
        int i5 = i4 - 2;
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 == 5) {
                            return zzdk.zzb;
                        }
                        throw new GeneralSecurityException("Unable to parse HashType: " + zzsa.zza(i4));
                    }
                    return zzdk.zze;
                }
                return zzdk.zzc;
            }
            return zzdk.zzd;
        }
        return zzdk.zza;
    }
}
