package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzya  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzya implements zzabx {
    final /* synthetic */ zzacz zza;
    final /* synthetic */ zzaaq zzb;
    final /* synthetic */ zzys zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzya(zzys zzysVar, zzacz zzaczVar, zzaaq zzaaqVar) {
        this.zzc = zzysVar;
        this.zza = zzaczVar;
        this.zzb = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaby zzabyVar;
        this.zza.zzb(((zzadu) obj).zze());
        zzabyVar = this.zzc.zza;
        zzabyVar.zzd(this.zza, new zzxz(this));
    }
}
