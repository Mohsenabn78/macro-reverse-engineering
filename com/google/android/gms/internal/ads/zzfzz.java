package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfzz extends zzgdu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfzz() {
        super(zzgiw.class, new zzfzx(zzfxh.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzgds zzg(int i4, int i5, int i6) {
        zzgiy zzc = zzgiz.zzc();
        zzc.zza(i4);
        zzgjb zzc2 = zzgjc.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgjc) zzc2.zzal());
        return new zzgds((zzgiz) zzc.zzal(), i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgdt zza() {
        return new zzfzy(this, zzgiz.class);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* synthetic */ zzgqw zzc(zzgoe zzgoeVar) throws zzgpy {
        return zzgiw.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgiw zzgiwVar = (zzgiw) zzgqwVar;
        zzgni.zzb(zzgiwVar.zza(), 0);
        zzgni.zza(zzgiwVar.zzg().zzd());
        if (zzgiwVar.zzf().zza() != 12 && zzgiwVar.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
