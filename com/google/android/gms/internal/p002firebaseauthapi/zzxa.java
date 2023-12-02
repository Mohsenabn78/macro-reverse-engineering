package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxa  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxa implements zzabx {
    final /* synthetic */ zzaaq zza;
    final /* synthetic */ zzys zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxa(zzys zzysVar, zzaaq zzaaqVar) {
        this.zzb = zzysVar;
        this.zza = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzafb zzafbVar = (zzafb) obj;
        if (zzafbVar.zzg()) {
            this.zza.zzf(new zzwy(zzafbVar.zzd(), zzafbVar.zzf(), null));
            return;
        }
        this.zzb.zzQ(new zzadu(zzafbVar.zze(), zzafbVar.zzc(), Long.valueOf(zzafbVar.zzb()), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
    }
}
