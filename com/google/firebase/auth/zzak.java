package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzak implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29127a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionCodeSettings f29128b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29129c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(FirebaseUser firebaseUser, String str, ActionCodeSettings actionCodeSettings) {
        this.f29129c = firebaseUser;
        this.f29127a = str;
        this.f29128b = actionCodeSettings;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.f29129c.zza()).zzu((String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()), this.f29127a, this.f29128b);
    }
}
