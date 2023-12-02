package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfxp implements zzfxo {
    private final zzgdu zza;
    private final Class zzb;

    public zzfxp(zzgdu zzgduVar, Class cls) {
        if (!zzgduVar.zzl().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzgduVar.toString(), cls.getName()));
        }
        this.zza = zzgduVar;
        this.zzb = cls;
    }

    @Override // com.google.android.gms.internal.ads.zzfxo
    public final zzgkk zza(zzgoe zzgoeVar) throws GeneralSecurityException {
        try {
            zzgdt zza = this.zza.zza();
            zzgqw zzb = zza.zzb(zzgoeVar);
            zza.zzd(zzb);
            zzgqw zza2 = zza.zza(zzb);
            zzgkh zza3 = zzgkk.zza();
            zza3.zzb(this.zza.zzd());
            zza3.zzc(zza2.zzau());
            zza3.zza(this.zza.zzb());
            return (zzgkk) zza3.zzal();
        } catch (zzgpy e4) {
            throw new GeneralSecurityException("Unexpected proto", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfxo
    public final Object zzb(zzgoe zzgoeVar) throws GeneralSecurityException {
        try {
            zzgqw zzc = this.zza.zzc(zzgoeVar);
            if (!Void.class.equals(this.zzb)) {
                this.zza.zze(zzc);
                return this.zza.zzk(zzc, this.zzb);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (zzgpy e4) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.zza.zzj().getName()), e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfxo
    public final String zzc() {
        return this.zza.zzd();
    }
}
