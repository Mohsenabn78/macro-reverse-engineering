package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwz  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzwz implements zzabx {
    final /* synthetic */ zzaaq zza;
    final /* synthetic */ zzys zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwz(zzys zzysVar, zzaaq zzaaqVar) {
        this.zzb = zzysVar;
        this.zza = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaej zzaejVar = (zzaej) obj;
        this.zzb.zzQ(new zzadu(zzaejVar.zzd(), zzaejVar.zzc(), Long.valueOf(zzaejVar.zzb()), "Bearer"), null, null, Boolean.TRUE, null, this.zza, this);
    }
}
