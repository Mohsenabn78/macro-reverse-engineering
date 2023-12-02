package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzai implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(FirebaseUser firebaseUser) {
        this.f29124a = firebaseUser;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.f29124a.zza()).zzk(null, (String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()));
    }
}
