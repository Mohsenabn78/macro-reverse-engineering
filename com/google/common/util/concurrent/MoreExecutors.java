package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class MoreExecutors {

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BlockingQueue f28544a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ListenableFuture f28545b;

        @Override // java.lang.Runnable
        public void run() {
            this.f28544a.add(this.f28545b);
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 extends WrappingExecutorService {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Supplier f28548b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public Runnable c(Runnable runnable) {
            return Callables.i(runnable, this.f28548b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public <T> Callable<T> d(Callable<T> callable) {
            return Callables.j(callable, this.f28548b);
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    @J2ktIncompatible
    /* loaded from: classes5.dex */
    static class Application {
        Application() {
        }

        final void a(final ExecutorService executorService, final long j4, final TimeUnit timeUnit) {
            Preconditions.checkNotNull(executorService);
            Preconditions.checkNotNull(timeUnit);
            b(MoreExecutors.c("DelayedShutdownHook-for-" + executorService, new Runnable(this) { // from class: com.google.common.util.concurrent.MoreExecutors.Application.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        executorService.shutdown();
                        executorService.awaitTermination(j4, timeUnit);
                    } catch (InterruptedException unused) {
                    }
                }
            }));
        }

        @VisibleForTesting
        void b(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        final ExecutorService c(ThreadPoolExecutor threadPoolExecutor) {
            return d(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        final ExecutorService d(ThreadPoolExecutor threadPoolExecutor, long j4, TimeUnit timeUnit) {
            MoreExecutors.g(threadPoolExecutor);
            ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            a(threadPoolExecutor, j4, timeUnit);
            return unconfigurableExecutorService;
        }

        final ScheduledExecutorService e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return f(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        final ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j4, TimeUnit timeUnit) {
            MoreExecutors.g(scheduledThreadPoolExecutor);
            ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            a(scheduledThreadPoolExecutor, j4, timeUnit);
            return unconfigurableScheduledExecutorService;
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    /* loaded from: classes5.dex */
    private static class ListeningDecorator extends AbstractListeningExecutorService {

        /* renamed from: a  reason: collision with root package name */
        private final ExecutorService f28558a;

        ListeningDecorator(ExecutorService executorService) {
            this.f28558a = (ExecutorService) Preconditions.checkNotNull(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
            return this.f28558a.awaitTermination(j4, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f28558a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f28558a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f28558a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f28558a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f28558a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f28558a + "]";
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    /* loaded from: classes5.dex */
    private static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {

        /* renamed from: b  reason: collision with root package name */
        final ScheduledExecutorService f28559b;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {

            /* renamed from: b  reason: collision with root package name */
            private final ScheduledFuture<?> f28560b;

            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.f28560b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z3) {
                boolean cancel = super.cancel(z3);
                if (cancel) {
                    this.f28560b.cancel(z3);
                }
                return cancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f28560b.getDelay(timeUnit);
            }

            @Override // java.lang.Comparable
            /* renamed from: h */
            public int compareTo(Delayed delayed) {
                return this.f28560b.compareTo(delayed);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @GwtIncompatible
        @J2ktIncompatible
        /* loaded from: classes5.dex */
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {

            /* renamed from: h  reason: collision with root package name */
            private final Runnable f28561h;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.f28561h = (Runnable) Preconditions.checkNotNull(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f28561h.run();
                } catch (Error | RuntimeException e4) {
                    setException(e4);
                    throw e4;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.AbstractFuture
            public String y() {
                return "task=[" + this.f28561h + "]";
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f28559b = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f28559b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j4, j5, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f28559b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j4, j5, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
            TrustedListenableFutureTask D = TrustedListenableFutureTask.D(runnable, null);
            return new ListenableScheduledTask(D, this.f28559b.schedule(D, j4, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j4, TimeUnit timeUnit) {
            TrustedListenableFutureTask E = TrustedListenableFutureTask.E(callable);
            return new ListenableScheduledTask(E, this.f28559b.schedule(E, j4, timeUnit));
        }
    }

    private MoreExecutors() {
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static void addDelayedShutdownHook(ExecutorService executorService, long j4, TimeUnit timeUnit) {
        new Application().a(executorService, j4, timeUnit);
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static boolean b() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            Class.forName("com.google.appengine.api.utils.SystemProperty");
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) == null) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @J2ktIncompatible
    @GwtIncompatible
    public static Thread c(String str, Runnable runnable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(runnable);
        Thread newThread = platformThreadFactory().newThread(runnable);
        Objects.requireNonNull(newThread);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor d(final Executor executor, final AbstractFuture<?> abstractFuture) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(abstractFuture);
        if (executor == directExecutor()) {
            return executor;
        }
        return new Executor() { // from class: com.google.common.util.concurrent.MoreExecutors.5
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RejectedExecutionException e4) {
                    abstractFuture.setException(e4);
                }
            }
        };
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @J2ktIncompatible
    @GwtIncompatible
    public static Executor e(final Executor executor, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        return new Executor() { // from class: com.google.common.util.concurrent.MoreExecutors.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Callables.i(runnable, supplier));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @J2ktIncompatible
    @GwtIncompatible
    public static ScheduledExecutorService f(ScheduledExecutorService scheduledExecutorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        return new WrappingScheduledExecutorService(scheduledExecutorService) { // from class: com.google.common.util.concurrent.MoreExecutors.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.WrappingExecutorService
            public Runnable c(Runnable runnable) {
                return Callables.i(runnable, supplier);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.WrappingExecutorService
            public <T> Callable<T> d(Callable<T> callable) {
                return Callables.j(callable, supplier);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @J2ktIncompatible
    @GwtIncompatible
    public static void g(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j4, TimeUnit timeUnit) {
        return new Application().d(threadPoolExecutor, j4, timeUnit);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j4, TimeUnit timeUnit) {
        return new Application().f(scheduledThreadPoolExecutor, j4, timeUnit);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        ListeningExecutorService listeningDecorator;
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            listeningDecorator = new ScheduledListeningDecorator((ScheduledExecutorService) executorService);
        } else {
            listeningDecorator = new ListeningDecorator(executorService);
        }
        return listeningDecorator;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService(null);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ThreadFactory platformThreadFactory() {
        if (!b()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e6);
        } catch (InvocationTargetException e7) {
            throw Throwables.propagate(e7.getCause());
        }
    }

    @CanIgnoreReturnValue
    @J2ktIncompatible
    @GwtIncompatible
    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j4, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j4) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        return new Application().c(threadPoolExecutor);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().e(scheduledThreadPoolExecutor);
    }

    @J2ktIncompatible
    @GwtIncompatible
    /* loaded from: classes5.dex */
    private static final class DirectExecutorService extends AbstractListeningExecutorService {

        /* renamed from: a  reason: collision with root package name */
        private final Object f28555a;
        @GuardedBy("lock")

        /* renamed from: b  reason: collision with root package name */
        private int f28556b;
        @GuardedBy("lock")

        /* renamed from: c  reason: collision with root package name */
        private boolean f28557c;

        private DirectExecutorService() {
            this.f28555a = new Object();
            this.f28556b = 0;
            this.f28557c = false;
        }

        private void a() {
            synchronized (this.f28555a) {
                int i4 = this.f28556b - 1;
                this.f28556b = i4;
                if (i4 == 0) {
                    this.f28555a.notifyAll();
                }
            }
        }

        private void b() {
            synchronized (this.f28555a) {
                if (!this.f28557c) {
                    this.f28556b++;
                } else {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j4);
            synchronized (this.f28555a) {
                while (true) {
                    if (this.f28557c && this.f28556b == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.f28555a, nanos);
                    nanos -= System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b();
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z3;
            synchronized (this.f28555a) {
                z3 = this.f28557c;
            }
            return z3;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z3;
            synchronized (this.f28555a) {
                if (this.f28557c && this.f28556b == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            return z3;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.f28555a) {
                this.f28557c = true;
                if (this.f28556b == 0) {
                    this.f28555a.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        /* synthetic */ DirectExecutorService(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService instanceof ListeningScheduledExecutorService) {
            return (ListeningScheduledExecutorService) scheduledExecutorService;
        }
        return new ScheduledListeningDecorator(scheduledExecutorService);
    }
}
