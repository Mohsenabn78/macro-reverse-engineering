package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbr implements zzbs {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ zzkm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(zzlt zzltVar, zzkm zzkmVar) {
        this.zza = zzltVar;
        this.zzb = zzkmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final zzbo zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzcp(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e4) {
            throw new GeneralSecurityException("Primitive type not supported", e4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final zzbo zzb() {
        zzlt zzltVar = this.zza;
        return new zzcp(zzltVar, this.zzb, zzltVar.zzj());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final Class zzc() {
        return this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final Class zzd() {
        return this.zzb.getClass();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final Set zze() {
        return this.zza.zzm();
    }
}
