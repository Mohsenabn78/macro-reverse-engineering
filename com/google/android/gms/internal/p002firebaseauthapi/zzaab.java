package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaab  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaab extends zzabs {
    private final boolean zzC;
    private final boolean zzD;
    @Nullable
    private final String zzE;
    @Nullable
    private final String zzF;
    private final boolean zzG;
    private final String zza;
    private final String zzb;
    @Nullable
    private final String zzc;
    private final long zzd;

    public zzaab(zzag zzagVar, String str, @Nullable String str2, long j4, boolean z3, boolean z4, @Nullable String str3, @Nullable String str4, boolean z5) {
        super(8);
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzagVar.zzd());
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j4;
        this.zzC = z3;
        this.zzD = z4;
        this.zzE = str3;
        this.zzF = str4;
        this.zzG = z5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final String zza() {
        return "startMfaEnrollment";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabu
    public final void zzc(TaskCompletionSource taskCompletionSource, zzaar zzaarVar) {
        this.zzk = new zzabr(this, taskCompletionSource);
        zzaarVar.zzB(this.zza, this.zzb, this.zzc, this.zzd, this.zzC, this.zzD, this.zzE, this.zzF, this.zzG, this.zzf);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabs
    public final void zzb() {
    }
}
