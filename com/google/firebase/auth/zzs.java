package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth.IdTokenListener f29159a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29160b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.f29160b = firebaseAuth;
        this.f29159a = idTokenListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f29159a.onIdTokenChanged(this.f29160b);
    }
}
