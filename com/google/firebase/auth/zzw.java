package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(FirebaseAuth firebaseAuth) {
        this.f29166a = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<FirebaseAuth.AuthStateListener> list;
        list = this.f29166a.f28874d;
        for (FirebaseAuth.AuthStateListener authStateListener : list) {
            authStateListener.onAuthStateChanged(this.f29166a);
        }
    }
}
