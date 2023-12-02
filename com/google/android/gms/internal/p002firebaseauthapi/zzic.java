package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic  reason: invalid package */
/* loaded from: classes4.dex */
final class zzic {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;
    private static final Map zzg;
    private static final Map zzh;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhy
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                return zzic.zzc((zzhx) zzcfVar);
            }
        }, zzhx.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhz
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzic.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzia
        }, zzhp.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzib
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzic.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
        HashMap hashMap = new HashMap();
        zzhv zzhvVar = zzhv.zzc;
        zzui zzuiVar = zzui.RAW;
        hashMap.put(zzhvVar, zzuiVar);
        zzhv zzhvVar2 = zzhv.zza;
        zzui zzuiVar2 = zzui.TINK;
        hashMap.put(zzhvVar2, zzuiVar2);
        zzhv zzhvVar3 = zzhv.zzb;
        zzui zzuiVar3 = zzui.CRUNCHY;
        hashMap.put(zzhvVar3, zzuiVar3);
        zzg = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzui.class);
        enumMap.put((EnumMap) zzuiVar, (zzui) zzhvVar);
        enumMap.put((EnumMap) zzuiVar2, (zzui) zzhvVar2);
        enumMap.put((EnumMap) zzuiVar3, (zzui) zzhvVar3);
        enumMap.put((EnumMap) zzui.LEGACY, (zzui) zzhvVar3);
        zzh = Collections.unmodifiableMap(enumMap);
    }

    public static /* synthetic */ zzhp zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzqq zzd2 = zzqq.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    zzhu zzhuVar = new zzhu(null);
                    zzhuVar.zza(zzd2.zze().zzd());
                    zzhuVar.zzb(zze(zzluVar.zzc()));
                    zzhx zzc2 = zzhuVar.zzc();
                    zzhn zzhnVar = new zzhn(null);
                    zzhnVar.zzc(zzc2);
                    zzhnVar.zzb(zzwj.zzb(zzd2.zze().zzq(), zzcsVar));
                    zzhnVar.zza(zzluVar.zzf());
                    return zzhnVar.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
    }

    public static /* synthetic */ zzhx zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzqt zze2 = zzqt.zze(zzlvVar.zzc().zzf(), zzagq.zza());
                if (zze2.zzb() == 0) {
                    zzhu zzhuVar = new zzhu(null);
                    zzhuVar.zza(zze2.zza());
                    zzhuVar.zzb(zze(zzlvVar.zzc().zze()));
                    return zzhuVar.zzc();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static /* synthetic */ zzlv zzc(zzhx zzhxVar) {
        zztg zza2 = zzth.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzqs zzc2 = zzqt.zzc();
        zzc2.zza(zzhxVar.zza());
        zza2.zzc(((zzqt) zzc2.zzi()).zzo());
        zzhv zzb2 = zzhxVar.zzb();
        Map map = zzg;
        if (map.containsKey(zzb2)) {
            zza2.zza((zzui) map.get(zzb2));
            return zzlv.zzb((zzth) zza2.zzi());
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb2)));
    }

    public static void zzd(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzhv zze(zzui zzuiVar) throws GeneralSecurityException {
        Map map = zzh;
        if (map.containsKey(zzuiVar)) {
            return (zzhv) map.get(zzuiVar);
        }
        int zza2 = zzuiVar.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }
}
