package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaac extends zzabs {
    private final zzaeq zza;

    public zzaac(zzag zzagVar, @Nullable String str) {
        super(12);
        Preconditions.checkNotNull(zzagVar);
        this.zza = zzaeq.zzb(Preconditions.checkNotEmpty(zzagVar.zzd()), str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabs
    public final void zzb() {
        zzm(this.zzz);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final void zzc(TaskCompletionSource taskCompletionSource, zzaar zzaarVar) {
        this.zzk = new zzabr(this, taskCompletionSource);
        zzaarVar.zzD(this.zza, this.zzf);
    }
}
