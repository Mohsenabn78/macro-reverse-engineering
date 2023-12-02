package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfzr extends zzgdt {
    final /* synthetic */ zzfzs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfzr(zzfzs zzfzsVar, Class cls) {
        super(cls);
        this.zza = zzfzsVar;
    }

    public static final zzgin zzf(zzgiq zzgiqVar) throws GeneralSecurityException {
        zzgim zzc = zzgin.zzc();
        zzc.zzb(zzgiqVar.zzg());
        byte[] zza = zzgng.zza(zzgiqVar.zza());
        zzc.zza(zzgoe.zzv(zza, 0, zza.length));
        zzc.zzc(0);
        return (zzgin) zzc.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqwVar) throws GeneralSecurityException {
        return zzf((zzgiq) zzgqwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    public final /* synthetic */ zzgqw zzb(zzgoe zzgoeVar) throws zzgpy {
        return zzgiq.zzf(zzgoeVar, zzgoy.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzgdt
    /* renamed from: zze */
    public final void zzd(zzgiq zzgiqVar) throws GeneralSecurityException {
        zzgni.zza(zzgiqVar.zza());
        zzfzs zzfzsVar = this.zza;
        zzfzs.zzm(zzgiqVar.zzg());
    }
}
