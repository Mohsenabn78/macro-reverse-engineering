package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzab implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f28966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzac zzacVar) {
        this.f28966a = zzacVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        zzx zzxVar;
        if (!task.isSuccessful()) {
            return Tasks.forException(task.getException());
        }
        String token = ((GetTokenResult) task.getResult()).getToken();
        zzxVar = this.f28966a.f28967a;
        return Tasks.forResult(zzag.zzb(token, zzxVar));
    }
}
