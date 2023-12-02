package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth.AuthStateListener f29162a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29163b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.f29163b = firebaseAuth;
        this.f29162a = authStateListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f29162a.onAuthStateChanged(this.f29163b);
    }
}
