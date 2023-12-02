package com.google.firebase.concurrent;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes5.dex */
final class PausableExecutorImpl implements PausableExecutor {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f29272a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f29273b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final LinkedBlockingQueue<Runnable> f29274c = new LinkedBlockingQueue<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PausableExecutorImpl(boolean z3, Executor executor) {
        this.f29272a = z3;
        this.f29273b = executor;
    }

    private void a() {
        if (this.f29272a) {
            return;
        }
        Runnable poll = this.f29274c.poll();
        while (poll != null) {
            this.f29273b.execute(poll);
            if (!this.f29272a) {
                poll = this.f29274c.poll();
            } else {
                poll = null;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f29274c.offer(runnable);
        a();
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public boolean isPaused() {
        return this.f29272a;
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public void pause() {
        this.f29272a = true;
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public void resume() {
        this.f29272a = false;
        a();
    }
}
