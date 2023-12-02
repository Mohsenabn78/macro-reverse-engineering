package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbp  reason: invalid package */
/* loaded from: classes4.dex */
class zzbp implements zzbo {
    private final zzkm zza;
    private final Class zzb;

    public zzbp(zzkm zzkmVar, Class cls) {
        if (!zzkmVar.zzm().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzkmVar.toString(), cls.getName()));
        }
        this.zza = zzkmVar;
        this.zzb = cls;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    public final zztc zza(zzafy zzafyVar) throws GeneralSecurityException {
        try {
            zzkl zza = this.zza.zza();
            zzaii zzb = zza.zzb(zzafyVar);
            zza.zzd(zzb);
            zzaii zza2 = zza.zza(zzb);
            zzsz zza3 = zztc.zza();
            zza3.zzb(this.zza.zzd());
            zza3.zzc(zza2.zzo());
            zza3.zza(this.zza.zzb());
            return (zztc) zza3.zzi();
        } catch (zzahl e4) {
            throw new GeneralSecurityException("Unexpected proto", e4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    public final Object zzb(zzafy zzafyVar) throws GeneralSecurityException {
        try {
            zzaii zzc = this.zza.zzc(zzafyVar);
            if (!Void.class.equals(this.zzb)) {
                this.zza.zze(zzc);
                return this.zza.zzl(zzc, this.zzb);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (zzahl e4) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.zza.zzk().getName()), e4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    public final String zzc() {
        return this.zza.zzd();
    }
}
