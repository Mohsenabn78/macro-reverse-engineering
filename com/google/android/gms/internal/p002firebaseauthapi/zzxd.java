package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxd implements zzabx {
    final /* synthetic */ zzabw zza;
    final /* synthetic */ zzaaq zzb;
    final /* synthetic */ zzadu zzc;
    final /* synthetic */ zzaeg zzd;
    final /* synthetic */ zzys zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxd(zzys zzysVar, zzabw zzabwVar, zzaaq zzaaqVar, zzadu zzaduVar, zzaeg zzaegVar) {
        this.zze = zzysVar;
        this.zza = zzabwVar;
        this.zzb = zzaaqVar;
        this.zzc = zzaduVar;
        this.zzd = zzaegVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb = ((zzadk) obj).zzb();
        if (zzb != null && !zzb.isEmpty()) {
            zzys.zzf(this.zze, this.zzb, this.zzc, (zzadl) zzb.get(0), this.zzd, this.zza);
        } else {
            this.zza.zza("No users");
        }
    }
}
