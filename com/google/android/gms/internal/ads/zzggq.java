package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzggq extends zzgdu {
    private static final zzges zza = zzges.zzb(new zzgeq() { // from class: com.google.android.gms.internal.ads.zzggn
        @Override // com.google.android.gms.internal.ads.zzgeq
        public final Object zza(zzfxn zzfxnVar) {
            return new zzghk((zzggm) zzfxnVar);
        }
    }, zzggm.class, zzggf.class);

    public zzggq() {
        super(zzgjz.class, new zzggo(zzfye.class));
    }

    public static void zzh(boolean z3) throws GeneralSecurityException {
        zzfyp.zze(new zzggq(), true);
        int i4 = zzghb.zza;
        zzghb.zzc(zzgeg.zzc());
        zzgee.zza().zze(zza);
    }

    public static final void zzm(zzgjz zzgjzVar) throws GeneralSecurityException {
        zzgni.zzb(zzgjzVar.zza(), 0);
        if (zzgjzVar.zzh().zzd() >= 16) {
            zzo(zzgjzVar.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzgds zzn(int i4, int i5, int i6, int i7) {
        zzgkb zzd = zzgkc.zzd();
        zzgke zzc = zzgkf.zzc();
        zzc.zzb(i6);
        zzc.zza(i5);
        zzd.zzb((zzgkf) zzc.zzal());
        zzd.zza(i4);
        return new zzgds((zzgkc) zzd.zzal(), i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzo(zzgkf zzgkfVar) throws GeneralSecurityException {
        if (zzgkfVar.zza() >= 10) {
            int zzg = zzgkfVar.zzg() - 2;
            if (zzg != 1) {
                if (zzg != 2) {
                    if (zzg != 3) {
                        if (zzg != 4) {
                            if (zzg == 5) {
                                if (zzgkfVar.zza() > 28) {
                                    throw new GeneralSecurityException("tag size too big");
                                }
                                return;
                            }
                            throw new GeneralSecurityException("unknown hash type");
                        } else if (zzgkfVar.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        } else {
                            return;
                        }
                    } else if (zzgkfVar.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    } else {
                        return;
                    }
                } else if (zzgkfVar.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                } else {
                    return;
                }
            } else if (zzgkfVar.zza() <= 20) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too big");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgdt zza() {
        return new zzggp(this, zzgkc.class);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* synthetic */ zzgqw zzc(zzgoe zzgoeVar) throws zzgpy {
        return zzgjz.zzf(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzm((zzgjz) zzgqwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final int zzf() {
        return 2;
    }
}
