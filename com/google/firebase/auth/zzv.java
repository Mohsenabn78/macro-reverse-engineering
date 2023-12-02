package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29164a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ InternalTokenResult f29165b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.f29164a = firebaseAuth;
        this.f29165b = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<IdTokenListener> list;
        List<FirebaseAuth.IdTokenListener> list2;
        list = this.f29164a.f28873c;
        for (IdTokenListener idTokenListener : list) {
            idTokenListener.onIdTokenChanged(this.f29165b);
        }
        list2 = this.f29164a.f28872b;
        for (FirebaseAuth.IdTokenListener idTokenListener2 : list2) {
            idTokenListener2.onIdTokenChanged(this.f29164a);
        }
    }
}
