package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxr implements zzabx {
    final /* synthetic */ zzaev zza;
    final /* synthetic */ zzaaq zzb;
    final /* synthetic */ zzys zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxr(zzys zzysVar, zzaev zzaevVar, zzaaq zzaaqVar) {
        this.zzc = zzysVar;
        this.zza = zzaevVar;
        this.zzb = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaby zzabyVar;
        this.zza.zzd(true);
        this.zza.zzc(((zzadu) obj).zze());
        zzabyVar = this.zzc.zza;
        zzabyVar.zzs(this.zza, new zzxq(this, this));
    }
}
