package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt  reason: invalid package */
/* loaded from: classes4.dex */
final class zzxt implements zzabx {
    final /* synthetic */ zzabx zza;
    final /* synthetic */ zzadu zzb;
    final /* synthetic */ zzxu zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxt(zzxu zzxuVar, zzabx zzabxVar, zzadu zzaduVar) {
        this.zzc = zzxuVar;
        this.zza = zzabxVar;
        this.zzb = zzaduVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzc.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb = ((zzadk) obj).zzb();
        if (zzb != null && !zzb.isEmpty()) {
            zzadl zzadlVar = (zzadl) zzb.get(0);
            zzaeg zzaegVar = new zzaeg();
            zzaegVar.zze(this.zzb.zze());
            zzaegVar.zzb(this.zzc.zza);
            zzxu zzxuVar = this.zzc;
            zzys.zzf(zzxuVar.zzc, zzxuVar.zzb, this.zzb, zzadlVar, zzaegVar, this.zza);
            return;
        }
        this.zza.zza("No users.");
    }
}
