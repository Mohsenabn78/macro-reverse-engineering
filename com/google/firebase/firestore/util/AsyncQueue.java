package com.google.firebase.firestore.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.util.AsyncQueue;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

/* loaded from: classes5.dex */
public class AsyncQueue {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<TimerId> f31250c = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<DelayedTask> f31249b = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private final SynchronizedShutdownAwareExecutor f31248a = new SynchronizedShutdownAwareExecutor();

    /* loaded from: classes5.dex */
    public class DelayedTask {

        /* renamed from: a  reason: collision with root package name */
        private final TimerId f31251a;

        /* renamed from: b  reason: collision with root package name */
        private final long f31252b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f31253c;

        /* renamed from: d  reason: collision with root package name */
        private ScheduledFuture f31254d;

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            AsyncQueue.this.verifyIsCurrentThread();
            if (this.f31254d != null) {
                f();
                this.f31253c.run();
            }
        }

        private void f() {
            boolean z3;
            if (this.f31254d != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.f31254d = null;
            AsyncQueue.this.r(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(long j4) {
            this.f31254d = AsyncQueue.this.f31248a.schedule(new Runnable() { // from class: com.google.firebase.firestore.util.h
                @Override // java.lang.Runnable
                public final void run() {
                    AsyncQueue.DelayedTask.this.e();
                }
            }, j4, TimeUnit.MILLISECONDS);
        }

        public void cancel() {
            AsyncQueue.this.verifyIsCurrentThread();
            ScheduledFuture scheduledFuture = this.f31254d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                f();
            }
        }

        void g() {
            e();
        }

        private DelayedTask(TimerId timerId, long j4, Runnable runnable) {
            this.f31251a = timerId;
            this.f31252b = j4;
            this.f31253c = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SynchronizedShutdownAwareExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final ScheduledThreadPoolExecutor f31256a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f31257b;

        /* renamed from: c  reason: collision with root package name */
        private final Thread f31258c;

        /* loaded from: classes5.dex */
        private class DelayedStartFactory implements Runnable, ThreadFactory {

            /* renamed from: a  reason: collision with root package name */
            private final CountDownLatch f31262a;

            /* renamed from: b  reason: collision with root package name */
            private Runnable f31263b;

            private DelayedStartFactory() {
                this.f31262a = new CountDownLatch(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                boolean z3;
                if (this.f31263b == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assert.hardAssert(z3, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.f31263b = runnable;
                this.f31262a.countDown();
                return SynchronizedShutdownAwareExecutor.this.f31258c;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f31262a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.f31263b.run();
            }
        }

        @SuppressLint({"ThreadPoolCreation"})
        SynchronizedShutdownAwareExecutor() {
            DelayedStartFactory delayedStartFactory = new DelayedStartFactory();
            Thread newThread = java.util.concurrent.Executors.defaultThreadFactory().newThread(delayedStartFactory);
            this.f31258c = newThread;
            newThread.setName("FirestoreWorker");
            newThread.setDaemon(true);
            newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.google.firebase.firestore.util.i
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    AsyncQueue.SynchronizedShutdownAwareExecutor.this.q(thread, th);
                }
            });
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, delayedStartFactory) { // from class: com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor.1
                @Override // java.util.concurrent.ThreadPoolExecutor
                protected void afterExecute(Runnable runnable, Throwable th) {
                    super.afterExecute(runnable, th);
                    if (th == null && (runnable instanceof Future)) {
                        Future future = (Future) runnable;
                        try {
                            if (future.isDone()) {
                                future.get();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        } catch (CancellationException unused2) {
                        } catch (ExecutionException e4) {
                            th = e4.getCause();
                        }
                    }
                    if (th != null) {
                        AsyncQueue.this.panic(th);
                    }
                }
            };
            this.f31256a = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
            this.f31257b = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized Task<Void> k(final Runnable runnable) {
            if (n()) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(null);
                return taskCompletionSource.getTask();
            }
            Task<Void> l4 = l(new Callable() { // from class: com.google.firebase.firestore.util.j
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void o4;
                    o4 = AsyncQueue.SynchronizedShutdownAwareExecutor.o(runnable);
                    return o4;
                }
            });
            this.f31257b = true;
            return l4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> Task<T> l(final Callable<T> callable) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                execute(new Runnable() { // from class: com.google.firebase.firestore.util.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncQueue.SynchronizedShutdownAwareExecutor.p(TaskCompletionSource.this, callable);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.warn(AsyncQueue.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return taskCompletionSource.getTask();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean n() {
            return this.f31257b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Void o(Runnable runnable) throws Exception {
            runnable.run();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void p(TaskCompletionSource taskCompletionSource, Callable callable) {
            try {
                taskCompletionSource.setResult(callable.call());
            } catch (Exception e4) {
                taskCompletionSource.setException(e4);
                throw new RuntimeException(e4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(Thread thread, Throwable th) {
            AsyncQueue.this.panic(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(int i4) {
            this.f31256a.setCorePoolSize(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            this.f31256a.shutdownNow();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized ScheduledFuture<?> schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
            if (!this.f31257b) {
                return this.f31256a.schedule(runnable, j4, timeUnit);
            }
            return null;
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (!this.f31257b) {
                this.f31256a.execute(runnable);
            }
        }

        public void m(Runnable runnable) {
            try {
                this.f31256a.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Logger.warn(AsyncQueue.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum TimerId {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        HEALTH_CHECK_TIMEOUT,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER,
        INDEX_BACKFILL
    }

    public static <TResult> Task<TResult> callTask(final Executor executor, final Callable<Task<TResult>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.firestore.util.c
            @Override // java.lang.Runnable
            public final void run() {
                AsyncQueue.l(callable, executor, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private DelayedTask j(TimerId timerId, long j4, Runnable runnable) {
        DelayedTask delayedTask = new DelayedTask(timerId, System.currentTimeMillis() + j4, runnable);
        delayedTask.h(j4);
        return delayedTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void k(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Callable callable, Executor executor, final TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new Continuation() { // from class: com.google.firebase.firestore.util.g
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Void k4;
                    k4 = AsyncQueue.k(TaskCompletionSource.this, task);
                    return k4;
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        } catch (Throwable th) {
            taskCompletionSource.setException(new IllegalStateException("Unhandled throwable in callTask.", th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void m(Runnable runnable) throws Exception {
        runnable.run();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (24.7.1) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
            outOfMemoryError.initCause(th);
            throw outOfMemoryError;
        }
        throw new RuntimeException("Internal error in Cloud Firestore (24.7.1).", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int o(DelayedTask delayedTask, DelayedTask delayedTask2) {
        return Long.compare(delayedTask.f31252b, delayedTask2.f31252b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(TimerId timerId) {
        boolean z3;
        if (timerId != TimerId.ALL && !containsDelayedTask(timerId)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "Attempted to run tasks until missing TimerId: %s", timerId);
        Collections.sort(this.f31249b, new Comparator() { // from class: com.google.firebase.firestore.util.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o4;
                o4 = AsyncQueue.o((AsyncQueue.DelayedTask) obj, (AsyncQueue.DelayedTask) obj2);
                return o4;
            }
        });
        Iterator it = new ArrayList(this.f31249b).iterator();
        while (it.hasNext()) {
            DelayedTask delayedTask = (DelayedTask) it.next();
            delayedTask.g();
            if (timerId != TimerId.ALL && delayedTask.f31251a == timerId) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(Runnable runnable, Throwable[] thArr, Semaphore semaphore) {
        try {
            runnable.run();
        } catch (Throwable th) {
            thArr[0] = th;
        }
        semaphore.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(DelayedTask delayedTask) {
        Assert.hardAssert(this.f31249b.remove(delayedTask), "Delayed task not found.", new Object[0]);
    }

    @VisibleForTesting
    public boolean containsDelayedTask(TimerId timerId) {
        Iterator<DelayedTask> it = this.f31249b.iterator();
        while (it.hasNext()) {
            if (it.next().f31251a == timerId) {
                return true;
            }
        }
        return false;
    }

    @CheckReturnValue
    public <T> Task<T> enqueue(Callable<T> callable) {
        return this.f31248a.l(callable);
    }

    public DelayedTask enqueueAfterDelay(TimerId timerId, long j4, Runnable runnable) {
        if (this.f31250c.contains(timerId)) {
            j4 = 0;
        }
        DelayedTask j5 = j(timerId, j4, runnable);
        this.f31249b.add(j5);
        return j5;
    }

    public void enqueueAndForget(Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueueAndForgetEvenAfterShutdown(Runnable runnable) {
        this.f31248a.m(runnable);
    }

    public Task<Void> enqueueAndInitiateShutdown(Runnable runnable) {
        return this.f31248a.k(runnable);
    }

    public Executor getExecutor() {
        return this.f31248a;
    }

    public boolean isShuttingDown() {
        return this.f31248a.n();
    }

    public void panic(final Throwable th) {
        this.f31248a.s();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.firebase.firestore.util.e
            @Override // java.lang.Runnable
            public final void run() {
                AsyncQueue.n(th);
            }
        });
    }

    @VisibleForTesting
    public void runDelayedTasksUntil(final TimerId timerId) throws InterruptedException {
        runSync(new Runnable() { // from class: com.google.firebase.firestore.util.b
            @Override // java.lang.Runnable
            public final void run() {
                AsyncQueue.this.p(timerId);
            }
        });
    }

    @VisibleForTesting
    public void runSync(final Runnable runnable) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(0);
        final Throwable[] thArr = new Throwable[1];
        enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.util.d
            @Override // java.lang.Runnable
            public final void run() {
                AsyncQueue.q(runnable, thArr, semaphore);
            }
        });
        semaphore.acquire(1);
        if (thArr[0] == null) {
            return;
        }
        throw new RuntimeException("Synchronous task failed", thArr[0]);
    }

    public void shutdown() {
        this.f31248a.r(0);
    }

    @VisibleForTesting
    public void skipDelaysForTimerId(TimerId timerId) {
        this.f31250c.add(timerId);
    }

    public void verifyIsCurrentThread() {
        Thread currentThread = Thread.currentThread();
        if (this.f31248a.f31258c == currentThread) {
            return;
        }
        throw Assert.fail("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.f31248a.f31258c.getName(), Long.valueOf(this.f31248a.f31258c.getId()), currentThread.getName(), Long.valueOf(currentThread.getId()));
    }

    @CheckReturnValue
    public Task<Void> enqueue(final Runnable runnable) {
        return enqueue(new Callable() { // from class: com.google.firebase.firestore.util.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void m4;
                m4 = AsyncQueue.m(runnable);
                return m4;
            }
        });
    }
}
