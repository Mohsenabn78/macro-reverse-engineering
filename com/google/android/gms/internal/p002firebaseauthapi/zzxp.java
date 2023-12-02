package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxp implements zzabx {
    final /* synthetic */ zzafc zza;
    final /* synthetic */ zzaaq zzb;
    final /* synthetic */ zzys zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxp(zzys zzysVar, zzafc zzafcVar, zzaaq zzaaqVar) {
        this.zzc = zzysVar;
        this.zza = zzafcVar;
        this.zzb = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaby zzabyVar;
        this.zza.zzd(((zzadu) obj).zze());
        zzabyVar = this.zzc.zza;
        zzabyVar.zzv(this.zza, new zzxo(this, this));
    }
}
