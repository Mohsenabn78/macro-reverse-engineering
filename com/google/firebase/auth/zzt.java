package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzael;
import com.google.android.gms.internal.p002firebaseauthapi.zzaer;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzbw;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzt implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(FirebaseAuth firebaseAuth) {
        this.f29161a = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        zzael zzaelVar = (zzael) task.getResult();
        if (zzaelVar instanceof zzaer) {
            zzaer zzaerVar = (zzaer) zzaelVar;
            return Tasks.forResult(new zzbw(Preconditions.checkNotEmpty(zzaerVar.zzi()), Preconditions.checkNotEmpty(zzaerVar.zzh()), zzaerVar.zze(), zzaerVar.zzd(), zzaerVar.zzf(), Preconditions.checkNotEmpty(zzaerVar.zzc()), this.f29161a));
        }
        String name = zzaelVar.getClass().getName();
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + name + ".");
    }
}
