package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxv  reason: invalid package */
/* loaded from: classes4.dex */
final class zzxv implements zzabx {
    final /* synthetic */ zzxw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxv(zzxw zzxwVar) {
        this.zza = zzxwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zzc.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaff zzaffVar = (zzaff) obj;
        if (!TextUtils.isEmpty(zzaffVar.zzb()) && !TextUtils.isEmpty(zzaffVar.zzc())) {
            zzadu zzaduVar = new zzadu(zzaffVar.zzc(), zzaffVar.zzb(), Long.valueOf(zzadw.zza(zzaffVar.zzb())), "Bearer");
            zzxw zzxwVar = this.zza;
            zzxwVar.zzd.zzQ(zzaduVar, null, null, Boolean.FALSE, null, zzxwVar.zzc, this);
            return;
        }
        this.zza.zzc.zzh(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
    }
}
