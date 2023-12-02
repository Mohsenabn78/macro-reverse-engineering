package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes5.dex */
final /* synthetic */ class FirebaseInstanceId$$Lambda$5 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    static final Executor f31466a = new FirebaseInstanceId$$Lambda$5();

    private FirebaseInstanceId$$Lambda$5() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
