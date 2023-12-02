package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxn implements zzabx {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaaq zzc;
    final /* synthetic */ zzys zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxn(zzys zzysVar, String str, String str2, zzaaq zzaaqVar) {
        this.zzd = zzysVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadu zzaduVar = (zzadu) obj;
        zzaeg zzaegVar = new zzaeg();
        zzaegVar.zze(zzaduVar.zze());
        zzaegVar.zzd(this.zza);
        zzaegVar.zzg(this.zzb);
        zzys.zze(this.zzd, this.zzc, zzaduVar, zzaegVar, this);
    }
}
