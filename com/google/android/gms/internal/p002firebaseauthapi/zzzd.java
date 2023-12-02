package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzzd extends zzabs {
    private final zzwm zza;

    public zzzd() {
        super(11);
        this.zza = new zzwm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final String zza() {
        return "getRecaptchaParam";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabs
    public final void zzb() {
        zzm(this.zzy);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final void zzc(TaskCompletionSource taskCompletionSource, zzaar zzaarVar) {
        this.zzk = new zzabr(this, taskCompletionSource);
        zzaarVar.zzk(this.zza, this.zzf);
    }
}
