package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ThrottledForwardingExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f31298a;

    /* renamed from: b  reason: collision with root package name */
    private final Semaphore f31299b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThrottledForwardingExecutor(int i4, Executor executor) {
        this.f31299b = new Semaphore(i4);
        this.f31298a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        runnable.run();
        this.f31299b.release();
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (this.f31299b.tryAcquire()) {
            try {
                this.f31298a.execute(new Runnable() { // from class: com.google.firebase.firestore.util.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        ThrottledForwardingExecutor.this.b(runnable);
                    }
                });
                return;
            } catch (RejectedExecutionException unused) {
                runnable.run();
                return;
            }
        }
        runnable.run();
    }
}
