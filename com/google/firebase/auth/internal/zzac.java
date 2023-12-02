package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzac extends MultiFactor {

    /* renamed from: a  reason: collision with root package name */
    private final zzx f28967a;

    public zzac(zzx zzxVar) {
        Preconditions.checkNotNull(zzxVar);
        this.f28967a = zzxVar;
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, @Nullable String str) {
        Preconditions.checkNotNull(multiFactorAssertion);
        zzx zzxVar = this.f28967a;
        return FirebaseAuth.getInstance(zzxVar.zza()).zzb(zzxVar, multiFactorAssertion, str);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.f28967a.zzn();
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<MultiFactorSession> getSession() {
        return this.f28967a.getIdToken(false).continueWithTask(new zzab(this));
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        Preconditions.checkNotNull(multiFactorInfo);
        String uid = multiFactorInfo.getUid();
        Preconditions.checkNotEmpty(uid);
        zzx zzxVar = this.f28967a;
        return FirebaseAuth.getInstance(zzxVar.zza()).zzo(zzxVar, uid);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> unenroll(String str) {
        Preconditions.checkNotEmpty(str);
        zzx zzxVar = this.f28967a;
        return FirebaseAuth.getInstance(zzxVar.zza()).zzo(zzxVar, str);
    }
}
