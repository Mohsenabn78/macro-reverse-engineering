package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyo  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzyo implements zzabx {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaaq zzb;
    final /* synthetic */ zzys zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyo(zzys zzysVar, String str, zzaaq zzaaqVar) {
        this.zzc = zzysVar;
        this.zza = str;
        this.zzb = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadu zzaduVar = (zzadu) obj;
        zzaeg zzaegVar = new zzaeg();
        zzaegVar.zze(zzaduVar.zze());
        zzaegVar.zzd(this.zza);
        zzys.zze(this.zzc, this.zzb, zzaduVar, zzaegVar, this);
    }
}
