package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Executors {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f17572a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f17573b = new b();

    /* loaded from: classes3.dex */
    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f17574a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f17574a.post(runnable);
        }
    }

    /* loaded from: classes3.dex */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private Executors() {
    }

    public static Executor directExecutor() {
        return f17573b;
    }

    public static Executor mainThreadExecutor() {
        return f17572a;
    }

    @VisibleForTesting
    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5L, timeUnit)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e4) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e4);
        }
    }
}
