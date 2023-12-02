package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zznp extends zzkm {
    private static final zzll zza = zzll.zzb(new zzlj() { // from class: com.google.android.gms.internal.firebase-auth-api.zznl
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj
        public final Object zza(zzbn zzbnVar) {
            return new zzoe((zznk) zzbnVar);
        }
    }, zznk.class, zznd.class);
    private static final zzll zzb = zzll.zzb(new zzlj() { // from class: com.google.android.gms.internal.firebase-auth-api.zznm
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj
        public final Object zza(zzbn zzbnVar) {
            return zzwd.zzc((zznk) zzbnVar);
        }
    }, zznk.class, zzce.class);

    public zznp() {
        super(zzsd.class, new zznn(zzce.class));
    }

    public static void zzh(boolean z3) throws GeneralSecurityException {
        zzcr.zzg(new zznp(), true);
        int i4 = zzoj.zza;
        zzoj.zzc(zzkz.zzc());
        zzkw.zza().zze(zza);
        zzkw.zza().zze(zzb);
    }

    public static final void zzi(zzsd zzsdVar) throws GeneralSecurityException {
        zzwf.zzc(zzsdVar.zza(), 0);
        if (zzsdVar.zzg().zzd() >= 16) {
            zzo(zzsdVar.zzf());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzkk zzn(int i4, int i5, int i6, int i7) {
        zzsf zzc = zzsg.zzc();
        zzsi zzb2 = zzsj.zzb();
        zzb2.zzb(i6);
        zzb2.zza(i5);
        zzc.zzb((zzsj) zzb2.zzi());
        zzc.zza(i4);
        return new zzkk((zzsg) zzc.zzi(), i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzo(zzsj zzsjVar) throws GeneralSecurityException {
        if (zzsjVar.zza() >= 10) {
            int zzf = zzsjVar.zzf() - 2;
            if (zzf != 1) {
                if (zzf != 2) {
                    if (zzf != 3) {
                        if (zzf != 4) {
                            if (zzf == 5) {
                                if (zzsjVar.zza() > 28) {
                                    throw new GeneralSecurityException("tag size too big");
                                }
                                return;
                            }
                            throw new GeneralSecurityException("unknown hash type");
                        } else if (zzsjVar.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        } else {
                            return;
                        }
                    } else if (zzsjVar.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    } else {
                        return;
                    }
                } else if (zzsjVar.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                } else {
                    return;
                }
            } else if (zzsjVar.zza() <= 20) {
                return;
            } else {
                throw new GeneralSecurityException("tag size too big");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zzkl zza() {
        return new zzno(this, zzsg.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final zztb zzb() {
        return zztb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* synthetic */ zzaii zzc(zzafy zzafyVar) throws zzahl {
        return zzsd.zze(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final /* bridge */ /* synthetic */ void zze(zzaii zzaiiVar) throws GeneralSecurityException {
        zzi((zzsd) zzaiiVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkm
    public final int zzf() {
        return 2;
    }
}
