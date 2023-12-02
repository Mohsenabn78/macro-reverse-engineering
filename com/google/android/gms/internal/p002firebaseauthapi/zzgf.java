package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgf  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzgf {
    public static final /* synthetic */ int zza = 0;
    private static final zzwi zzb;
    private static final zzlh zzc;
    private static final zzld zzd;
    private static final zzkj zze;
    private static final zzkf zzf;

    static {
        zzwi zzb2 = zzmj.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzb2;
        zzc = zzlh.zzb(new zzlf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlf
            public final zzlz zza(zzcf zzcfVar) {
                zzui zzuiVar;
                int i4 = zzgf.zza;
                zztg zza2 = zzth.zza();
                zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
                zza2.zzc(zzqz.zzb().zzo());
                zzfz zza3 = ((zzga) zzcfVar).zza();
                if (zzfz.zza.equals(zza3)) {
                    zzuiVar = zzui.TINK;
                } else if (zzfz.zzb.equals(zza3)) {
                    zzuiVar = zzui.CRUNCHY;
                } else if (zzfz.zzc.equals(zza3)) {
                    zzuiVar = zzui.RAW;
                } else {
                    throw new GeneralSecurityException("Unable to serialize variant: ".concat(zza3.toString()));
                }
                zza2.zza(zzuiVar);
                return zzlv.zzb((zzth) zza2.zzi());
            }
        }, zzga.class, zzlv.class);
        zzd = zzld.zzb(new zzlb() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlb
            public final zzcf zza(zzlz zzlzVar) {
                return zzgf.zzb((zzlv) zzlzVar);
            }
        }, zzb2, zzlv.class);
        zze = zzkj.zza(new zzkh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgd
        }, zzfv.class, zzlu.class);
        zzf = zzkf.zzb(new zzkd() { // from class: com.google.android.gms.internal.firebase-auth-api.zzge
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkd
            public final zzbn zza(zzlz zzlzVar, zzcs zzcsVar) {
                return zzgf.zza((zzlu) zzlzVar, zzcsVar);
            }
        }, zzb2, zzlu.class);
    }

    public static /* synthetic */ zzfv zza(zzlu zzluVar, zzcs zzcsVar) {
        if (zzluVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzqw zzd2 = zzqw.zzd(zzluVar.zze(), zzagq.zza());
                if (zzd2.zza() == 0) {
                    return zzfv.zza(zzd(zzluVar.zzc()), zzwj.zzb(zzd2.zze().zzq(), zzcsVar), zzluVar.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahl unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
    }

    public static /* synthetic */ zzga zzb(zzlv zzlvVar) {
        if (zzlvVar.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzqz.zzc(zzlvVar.zzc().zzf(), zzagq.zza());
                return zzga.zzb(zzd(zzlvVar.zzc().zze()));
            } catch (zzahl e4) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e4);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters: ".concat(String.valueOf(zzlvVar.zzc().zzg())));
    }

    public static void zzc(zzkz zzkzVar) throws GeneralSecurityException {
        zzkzVar.zzh(zzc);
        zzkzVar.zzg(zzd);
        zzkzVar.zzf(zze);
        zzkzVar.zze(zzf);
    }

    private static zzfz zzd(zzui zzuiVar) throws GeneralSecurityException {
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
                    return zzfz.zzc;
                }
            }
            return zzfz.zzb;
        }
        return zzfz.zza;
    }
}
