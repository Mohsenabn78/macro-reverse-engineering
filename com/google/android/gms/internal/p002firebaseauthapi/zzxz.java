package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxz  reason: invalid package */
/* loaded from: classes4.dex */
final class zzxz implements zzabx {
    final /* synthetic */ zzya zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxz(zzya zzyaVar) {
        this.zza = zzyaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzada zzadaVar = (zzada) obj;
        zzadu zzaduVar = new zzadu(zzadaVar.zzc(), zzadaVar.zzb(), Long.valueOf(zzadw.zza(zzadaVar.zzb())), "Bearer");
        zzya zzyaVar = this.zza;
        zzyaVar.zzc.zzQ(zzaduVar, null, null, Boolean.FALSE, null, zzyaVar.zzb, this);
    }
}
