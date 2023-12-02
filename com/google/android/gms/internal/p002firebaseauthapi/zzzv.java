package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzzv extends zzabs {
    @Nullable
    private final String zza;

    public zzzv(@Nullable String str) {
        super(2);
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final String zza() {
        return "signInAnonymously";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabs
    public final void zzb() {
        zzx zzS = zzaao.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final void zzc(TaskCompletionSource taskCompletionSource, zzaar zzaarVar) {
        this.zzk = new zzabr(this, taskCompletionSource);
        zzaarVar.zzv(this.zza, this.zzf);
    }
}
