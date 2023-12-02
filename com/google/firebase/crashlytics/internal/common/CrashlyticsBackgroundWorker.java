package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class CrashlyticsBackgroundWorker {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f29414a;

    /* renamed from: b  reason: collision with root package name */
    private Task<Void> f29415b = Tasks.forResult(null);

    /* renamed from: c  reason: collision with root package name */
    private final Object f29416c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Boolean> f29417d = new ThreadLocal<>();

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.f29414a = executor;
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.1
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsBackgroundWorker.this.f29417d.set(Boolean.TRUE);
            }
        });
    }

    private <T> Task<Void> b(Task<T> task) {
        return task.continueWith(this.f29414a, (Continuation<T, Void>) new Continuation<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.4
            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public Void then(@NonNull Task<T> task2) throws Exception {
                return null;
            }
        });
    }

    private boolean c() {
        return Boolean.TRUE.equals(this.f29417d.get());
    }

    private <T> Continuation<Void, T> d(final Callable<T> callable) {
        return new Continuation<Void, T>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.3
            @Override // com.google.android.gms.tasks.Continuation
            public T then(@NonNull Task<Void> task) throws Exception {
                return (T) callable.call();
            }
        };
    }

    public void checkRunningOnThread() {
        if (c()) {
            return;
        }
        throw new IllegalStateException("Not running on background worker thread as intended.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> e(final Runnable runnable) {
        return submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    public Executor getExecutor() {
        return this.f29414a;
    }

    public <T> Task<T> submit(Callable<T> callable) {
        Task<T> continueWith;
        synchronized (this.f29416c) {
            continueWith = this.f29415b.continueWith(this.f29414a, d(callable));
            this.f29415b = b(continueWith);
        }
        return continueWith;
    }

    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        Task<T> continueWithTask;
        synchronized (this.f29416c) {
            continueWithTask = this.f29415b.continueWithTask(this.f29414a, d(callable));
            this.f29415b = b(continueWithTask);
        }
        return continueWithTask;
    }
}
