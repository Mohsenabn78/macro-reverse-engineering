package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxc implements zzabx {
    final /* synthetic */ zzaaq zza;
    final /* synthetic */ zzys zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxc(zzys zzysVar, zzaaq zzaaqVar) {
        this.zzb = zzysVar;
        this.zza = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzacy zzacyVar = (zzacy) obj;
        if (zzacyVar.zzg()) {
            this.zza.zzf(new zzwy(zzacyVar.zzd(), zzacyVar.zzf(), null));
            return;
        }
        this.zzb.zzQ(new zzadu(zzacyVar.zze(), zzacyVar.zzc(), Long.valueOf(zzacyVar.zzb()), "Bearer"), null, null, Boolean.valueOf(zzacyVar.zzh()), null, this.zza, this);
    }
}
