package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static final long f16932b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f16933c;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f16934a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f16935a;

        /* renamed from: b  reason: collision with root package name */
        final UncaughtThrowableStrategy f16936b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f16937c;

        /* renamed from: d  reason: collision with root package name */
        private int f16938d;

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0137a extends Thread {
            C0137a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (a.this.f16937c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    a.this.f16936b.handle(th);
                }
            }
        }

        a(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z3) {
            this.f16935a = str;
            this.f16936b = uncaughtThrowableStrategy;
            this.f16937c = z3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0137a c0137a;
            c0137a = new C0137a(runnable, "glide-" + this.f16935a + "-thread-" + this.f16938d);
            this.f16938d = this.f16938d + 1;
            return c0137a;
        }
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.f16934a = executorService;
    }

    public static int calculateBestThreadCount() {
        if (f16933c == 0) {
            f16933c = Math.min(4, com.bumptech.glide.load.engine.executor.a.a());
        }
        return f16933c;
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationExecutor(calculateBestThreadCount() >= 4 ? 2 : 1, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheExecutor(1, "disk-cache", UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceExecutor(calculateBestThreadCount(), "source", UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f16932b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", UncaughtThrowableStrategy.DEFAULT, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j4, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f16934a.awaitTermination(j4, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f16934a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f16934a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f16934a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f16934a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f16934a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f16934a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f16934a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f16934a.submit(runnable);
    }

    public String toString() {
        return this.f16934a.toString();
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheExecutor(1, "disk-cache", uncaughtThrowableStrategy);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j4, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f16934a.invokeAll(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j4, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f16934a.invokeAny(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t3) {
        return this.f16934a.submit(runnable, t3);
    }

    public static GlideExecutor newAnimationExecutor(int i4, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(0, i4, f16932b, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor newDiskCacheExecutor(int i4, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceExecutor(calculateBestThreadCount(), "source", uncaughtThrowableStrategy);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f16934a.submit(callable);
    }

    public static GlideExecutor newSourceExecutor(int i4, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a(str, uncaughtThrowableStrategy, false)));
    }

    /* loaded from: classes3.dex */
    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new a();
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW;

        /* loaded from: classes3.dex */
        class b implements UncaughtThrowableStrategy {
            b() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        /* loaded from: classes3.dex */
        class c implements UncaughtThrowableStrategy {
            c() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (th == null) {
                    return;
                }
                throw new RuntimeException("Request threw uncaught throwable", th);
            }
        }

        static {
            b bVar = new b();
            LOG = bVar;
            THROW = new c();
            DEFAULT = bVar;
        }

        void handle(Throwable th);

        /* loaded from: classes3.dex */
        class a implements UncaughtThrowableStrategy {
            a() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
            }
        }
    }
}
