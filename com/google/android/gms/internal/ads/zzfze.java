package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfze extends zzgdu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfze() {
        super(zzgih.class, new zzfzc(zzfxh.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzgds zzg(int i4, int i5, int i6, int i7, int i8, int i9) {
        zzgip zzc = zzgiq.zzc();
        zzgis zzc2 = zzgit.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgit) zzc2.zzal());
        zzc.zza(i4);
        zzgkb zzd = zzgkc.zzd();
        zzgke zzc3 = zzgkf.zzc();
        zzc3.zzb(5);
        zzc3.zza(i7);
        zzd.zzb((zzgkf) zzc3.zzal());
        zzd.zza(32);
        zzgij zza = zzgik.zza();
        zza.zza((zzgiq) zzc.zzal());
        zza.zzb((zzgkc) zzd.zzal());
        return new zzgds((zzgik) zza.zzal(), i9);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgdt zza() {
        return new zzfzd(this, zzgik.class);
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* synthetic */ zzgqw zzc(zzgoe zzgoeVar) throws zzgpy {
        return zzgih.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzgih zzgihVar = (zzgih) zzgqwVar;
        zzgni.zzb(zzgihVar.zza(), 0);
        new zzfzs();
        zzfzs.zzh(zzgihVar.zzf());
        new zzggq();
        zzggq.zzm(zzgihVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final int zzf() {
        return 2;
    }
}
