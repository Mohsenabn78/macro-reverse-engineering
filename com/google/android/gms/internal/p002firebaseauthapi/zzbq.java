package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbq  reason: invalid package */
/* loaded from: classes4.dex */
final class zzbq implements zzbs {
    final /* synthetic */ zzkm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(zzkm zzkmVar) {
        this.zza = zzkmVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final zzbo zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzbp(this.zza, cls);
        } catch (IllegalArgumentException e4) {
            throw new GeneralSecurityException("Primitive type not supported", e4);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final zzbo zzb() {
        zzkm zzkmVar = this.zza;
        return new zzbp(zzkmVar, zzkmVar.zzj());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final Class zzc() {
        return this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    @Nullable
    public final Class zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final Set zze() {
        return this.zza.zzm();
    }
}
