package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcp  reason: invalid package */
/* loaded from: classes4.dex */
final class zzcp extends zzbp implements zzco {
    private final zzlt zza;
    private final zzkm zzb;

    public zzcp(zzlt zzltVar, zzkm zzkmVar, Class cls) {
        super(zzltVar, cls);
        this.zza = zzltVar;
        this.zzb = zzkmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzco
    public final zztc zzd(zzafy zzafyVar) throws GeneralSecurityException {
        try {
            zzaii zzc = this.zza.zzc(zzafyVar);
            this.zza.zze(zzc);
            zzaii zzg = this.zza.zzg(zzc);
            this.zzb.zze(zzg);
            zzsz zza = zztc.zza();
            zza.zzb(this.zzb.zzd());
            zza.zzc(zzg.zzo());
            zza.zza(this.zzb.zzb());
            return (zztc) zza.zzi();
        } catch (zzahl e4) {
            throw new GeneralSecurityException("expected serialized proto of type ", e4);
        }
    }
}
