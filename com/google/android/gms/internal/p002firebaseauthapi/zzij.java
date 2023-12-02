package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzij extends zzlm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzij(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    public final /* bridge */ /* synthetic */ Object zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzrn zzrnVar = (zzrn) zzaiiVar;
        zzrk zzb = zzrnVar.zze().zzb();
        zzrt zze = zzb.zze();
        return new zzvc(zzvg.zzg(zziu.zzc(zze.zzf()), zzrnVar.zzf().zzq()), zze.zzd().zzq(), zziu.zzb(zze.zzg()), zziu.zzd(zzb.zzh()), new zziv(zzb.zza().zzd()));
    }
}
