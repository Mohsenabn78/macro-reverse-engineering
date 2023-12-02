package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzaj implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionCodeSettings f29125a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29126b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.f29126b = firebaseUser;
        this.f29125a = actionCodeSettings;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.f29126b.zza()).zzk(this.f29125a, (String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()));
    }
}
