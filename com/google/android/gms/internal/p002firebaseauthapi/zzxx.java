package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxx implements zzabx {
    final /* synthetic */ zzaek zza;
    final /* synthetic */ zzaaq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxx(zzys zzysVar, zzaek zzaekVar, zzaaq zzaaqVar) {
        this.zza = zzaekVar;
        this.zzb = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzael zzaelVar = (zzael) obj;
        zzaek zzaekVar = this.zza;
        if (zzaekVar instanceof zzaeo) {
            this.zzb.zzb(zzaelVar.zzc());
        } else if (zzaekVar instanceof zzaeq) {
            this.zzb.zzp(zzaelVar);
        } else {
            String name = zzaekVar.getClass().getName();
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + name + ".");
        }
    }
}
