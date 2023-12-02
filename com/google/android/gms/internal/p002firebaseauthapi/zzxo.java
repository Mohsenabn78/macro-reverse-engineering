package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxo  reason: invalid package */
/* loaded from: classes4.dex */
final class zzxo implements zzabx {
    final /* synthetic */ zzabx zza;
    final /* synthetic */ zzxp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxo(zzxp zzxpVar, zzabx zzabxVar) {
        this.zzb = zzxpVar;
        this.zza = zzabxVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzafd zzafdVar = (zzafd) obj;
        if (!TextUtils.isEmpty(zzafdVar.zzf())) {
            this.zzb.zzb.zzg(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzd(zzafdVar.zzd(), zzafdVar.zzf()));
            return;
        }
        this.zzb.zzc.zzQ(new zzadu(zzafdVar.zze(), zzafdVar.zzc(), Long.valueOf(zzafdVar.zzb()), "Bearer"), null, "phone", Boolean.valueOf(zzafdVar.zzg()), null, this.zzb.zzb, this.zza);
    }
}
