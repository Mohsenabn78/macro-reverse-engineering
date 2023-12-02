package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoj  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzoj {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzof
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                int i4;
                zzui zzuiVar;
                zznv zznvVar = (zznv) zzcfVar;
                int i5 = zzoj.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
                zzsf zzc2 = zzsg.zzc();
                zzsi zzb3 = zzsj.zzb();
                zzb3.zza(zznvVar.zza());
                zzns zze2 = zznvVar.zze();
                if (zzns.zza.equals(zze2)) {
                    i4 = 3;
                } else if (zzns.zzb.equals(zze2)) {
                    i4 = 7;
                } else if (zzns.zzc.equals(zze2)) {
                    i4 = 5;
                } else if (zzns.zzd.equals(zze2)) {
                    i4 = 4;
                } else if (zzns.zze.equals(zze2)) {
                    i4 = 6;
                } else {
                    throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zze2)));
                }
                zzb3.zzb(i4);
                zzc2.zzb((zzsj) zzb3.zzi());
                zzc2.zza(zznvVar.zzb());
                zza2.zzc(((zzsg) zzc2.zzi()).zzo());
                zznt zzf2 = zznvVar.zzf();
                if (zznt.zza.equals(zzf2)) {
                    zzuiVar = zzui.TINK;
                } else if (zznt.zzb.equals(zzf2)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zznt.zzd.equals(zzf2)) {
                    zzuiVar = zzui.RAW;
                } else if (zznt.zzc.equals(zzf2)) {
                    zzuiVar = zzui.LEGACY;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzf2)));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zznv.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzog
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzoj.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzoh
        }, zznk.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzoi
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzoj.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zznk zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzsd zze2 = zzsd.zze(zzluVar.zze(), zzagq.zza());
                if (zze2.zza() == 0) {
                    zznr zzd2 = zznv.zzd();
                    zzd2.zzb(zze2.zzg().zzd());
                    zzd2.zzc(zze2.zzf().zza());
                    zzd2.zza(zze(zze2.zzf().zzf()));
                    zzd2.zzd(zzd(zzluVar.zzc()));
                    zznv zze3 = zzd2.zze();
                    zzni zza2 = zznk.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzwj.zzb(zze2.zzg().zzq(), zzcsVar));
                    zza2.zza(zzluVar.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
    }

    public static /* synthetic */ zznv zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzsg zzf2 = zzsg.zzf(zzlvVar.zzc().zzf(), zzagq.zza());
                if (zzf2.zzb() == 0) {
                    zznr zzd2 = zznv.zzd();
                    zzd2.zzb(zzf2.zza());
                    zzd2.zzc(zzf2.zzg().zza());
                    zzd2.zza(zze(zzf2.zzg().zzf()));
                    zzd2.zzd(zzd(zzlvVar.zzc().zze()));
                    return zzd2.zze();
                }
                int zzb2 = zzf2.zzb();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzb2);
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zznt zzd(zzui zzuiVar) throws GeneralSecurityException {
        zzui zzuiVar2 = zzui.UNKNOWN_PREFIX;
        int ordinal = zzuiVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return zznt.zzb;
                    }
                    int zza2 = zzuiVar.zza();
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
                }
                return zznt.zzd;
            }
            return zznt.zzc;
        }
        return zznt.zza;
    }

    private static zzns zze(int i4) throws GeneralSecurityException {
        zzui zzuiVar = zzui.UNKNOWN_PREFIX;
        int i5 = i4 - 2;
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 == 5) {
                            return zzns.zzb;
                        }
                        throw new GeneralSecurityException("Unable to parse HashType: " + zzsa.zza(i4));
                    }
                    return zzns.zze;
                }
                return zzns.zzc;
            }
            return zzns.zzd;
        }
        return zzns.zza;
    }
}
