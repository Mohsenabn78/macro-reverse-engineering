package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzit  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzit {
    public static final zzth zza;
    public static final zzth zzb;
    public static final zzth zzc;
    private static final byte[] zzd;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zzth zzthVar = zzcw.zza;
        zzui zzuiVar = zzui.TINK;
        zza = zza(4, 5, 3, zzthVar, zzuiVar, bArr);
        zzb = zza(4, 5, 4, zzthVar, zzui.RAW, bArr);
        zzc = zza(4, 5, 3, zzcw.zze, zzuiVar, bArr);
    }

    @Deprecated
    static zzth zza(int i4, int i5, int i6, zzth zzthVar, zzui zzuiVar, byte[] bArr) {
        zzrg zza2 = zzrh.zza();
        zzrs zza3 = zzrt.zza();
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzafy.zzn(bArr, 0, 0));
        zzrd zza4 = zzre.zza();
        zza4.zza(zzthVar);
        zzrj zzb2 = zzrk.zzb();
        zzb2.zzb((zzrt) zza3.zzi());
        zzb2.zza((zzre) zza4.zzi());
        zzb2.zzc(i6);
        zza2.zza((zzrk) zzb2.zzi());
        zztg zza5 = zzth.zza();
        new zzil();
        zza5.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza5.zza(zzuiVar);
        zza5.zzc(((zzrh) zza2.zzi()).zzo());
        return (zzth) zza5.zzi();
    }
}
