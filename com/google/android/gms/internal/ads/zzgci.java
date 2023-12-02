package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgci extends zzgdt {
    final /* synthetic */ zzgcj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgci(zzgcj zzgcjVar, Class cls) {
        super(cls);
        this.zza = zzgcjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzglk zzc = zzgll.zzc();
        zzc.zza((zzglo) zzgqwVar);
        zzc.zzb(0);
        return (zzgll) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzglo.zze(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqwVar) throws GeneralSecurityException {
        zzglo zzgloVar = (zzglo) zzgqwVar;
        if (!zzgloVar.zzf().isEmpty() && zzgloVar.zzg()) {
            return;
        }
        throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
    }
}
