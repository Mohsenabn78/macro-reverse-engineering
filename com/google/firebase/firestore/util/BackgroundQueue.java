package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* loaded from: classes5.dex */
public class BackgroundQueue implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Semaphore f31266a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private int f31267b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        runnable.run();
        this.f31266a.release();
    }

    public void drain() {
        try {
            this.f31266a.acquire(this.f31267b);
            this.f31267b = 0;
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            Assert.fail("Interrupted while waiting for background task", e4);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        this.f31267b++;
        Executors.BACKGROUND_EXECUTOR.execute(new Runnable() { // from class: com.google.firebase.firestore.util.l
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundQueue.this.b(runnable);
            }
        });
    }
}
