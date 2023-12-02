package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyl  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzyl implements zzabx {
    final /* synthetic */ zzaaq zza;
    final /* synthetic */ zzys zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyl(zzys zzysVar, zzaaq zzaaqVar) {
        this.zzb = zzysVar;
        this.zza = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaex zzaexVar = (zzaex) obj;
        if (!zzaexVar.zzm()) {
            zzys.zzd(this.zzb, zzaexVar, this.zza, this);
        } else {
            this.zza.zzf(new zzwy(zzaexVar.zzg(), zzaexVar.zzl(), zzaexVar.zzc()));
        }
    }
}
