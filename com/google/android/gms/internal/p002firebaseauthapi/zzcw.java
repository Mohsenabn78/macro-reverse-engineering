package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcw  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzcw {
    public static final zzth zza = zzb(16);
    public static final zzth zzb = zzb(32);
    public static final zzth zzc = zza(16, 16);
    public static final zzth zzd = zza(32, 16);
    public static final zzth zze = zzc(16, 16, 32, 16, 5);
    public static final zzth zzf = zzc(32, 16, 32, 32, 5);
    public static final zzth zzg;
    public static final zzth zzh;

    static {
        zztg zza2 = zzth.zza();
        new zzfy();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzui zzuiVar = zzui.TINK;
        zza2.zza(zzuiVar);
        zzg = (zzth) zza2.zzi();
        zztg zza3 = zzth.zza();
        new zzgq();
        zza3.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza3.zza(zzuiVar);
        zzh = (zzth) zza3.zzi();
    }

    public static zzth zza(int i4, int i5) {
        zzpx zzb2 = zzpy.zzb();
        zzb2.zza(i4);
        zzqa zzb3 = zzqb.zzb();
        zzb3.zza(16);
        zzb2.zzb((zzqb) zzb3.zzi());
        zztg zza2 = zzth.zza();
        zza2.zzc(((zzpy) zzb2.zzi()).zzo());
        new zzec();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza2.zza(zzui.TINK);
        return (zzth) zza2.zzi();
    }

    public static zzth zzb(int i4) {
        zzqg zzc2 = zzqh.zzc();
        zzc2.zza(i4);
        zztg zza2 = zzth.zza();
        zza2.zzc(((zzqh) zzc2.zzi()).zzo());
        new zzet();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza2.zza(zzui.TINK);
        return (zzth) zza2.zzi();
    }

    public static zzth zzc(int i4, int i5, int i6, int i7, int i8) {
        zzpo zzb2 = zzpp.zzb();
        zzpr zzb3 = zzps.zzb();
        zzb3.zza(16);
        zzb2.zzb((zzps) zzb3.zzi());
        zzb2.zza(i4);
        zzsf zzc2 = zzsg.zzc();
        zzsi zzb4 = zzsj.zzb();
        zzb4.zzb(5);
        zzb4.zza(i7);
        zzc2.zzb((zzsj) zzb4.zzi());
        zzc2.zza(32);
        zzpi zza2 = zzpj.zza();
        zza2.zza((zzpp) zzb2.zzi());
        zza2.zzb((zzsg) zzc2.zzi());
        zztg zza3 = zzth.zza();
        zza3.zzc(((zzpj) zza2.zzi()).zzo());
        new zzdh();
        zza3.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza3.zza(zzui.TINK);
        return (zzth) zza3.zzi();
    }
}
