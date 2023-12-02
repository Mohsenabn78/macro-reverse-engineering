package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyf  reason: invalid package */
/* loaded from: classes4.dex */
final class zzyf implements zzabx {
    final /* synthetic */ zzabx zza;
    final /* synthetic */ zzadu zzb;
    final /* synthetic */ zzyg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyf(zzyg zzygVar, zzabx zzabxVar, zzadu zzaduVar) {
        this.zzc = zzygVar;
        this.zza = zzabxVar;
        this.zzb = zzaduVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb = ((zzadk) obj).zzb();
        if (zzb != null && !zzb.isEmpty()) {
            this.zzc.zza.zzk(this.zzb, (zzadl) zzb.get(0));
        } else {
            this.zza.zza("No users");
        }
    }
}
