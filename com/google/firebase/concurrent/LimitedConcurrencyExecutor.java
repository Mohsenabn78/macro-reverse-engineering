package com.google.firebase.concurrent;

import com.google.firebase.components.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class LimitedConcurrencyExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f29268a;

    /* renamed from: b  reason: collision with root package name */
    private final Semaphore f29269b;

    /* renamed from: c  reason: collision with root package name */
    private final LinkedBlockingQueue<Runnable> f29270c = new LinkedBlockingQueue<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LimitedConcurrencyExecutor(Executor executor, int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "concurrency must be positive.");
        this.f29268a = executor;
        this.f29269b = new Semaphore(i4, true);
    }

    private Runnable b(final Runnable runnable) {
        return new Runnable() { // from class: com.google.firebase.concurrent.x
            @Override // java.lang.Runnable
            public final void run() {
                LimitedConcurrencyExecutor.this.c(runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            this.f29269b.release();
            d();
        }
    }

    private void d() {
        while (this.f29269b.tryAcquire()) {
            Runnable poll = this.f29270c.poll();
            if (poll != null) {
                this.f29268a.execute(b(poll));
            } else {
                this.f29269b.release();
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f29270c.offer(runnable);
        d();
    }
}
