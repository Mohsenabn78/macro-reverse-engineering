package com.google.common.util.concurrent;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class AbstractScheduledService implements Service {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f28318b = Logger.getLogger(AbstractScheduledService.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final AbstractService f28319a = new ServiceDelegate();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface Cancellable {
        void cancel(boolean z3);

        boolean isCancelled();
    }

    /* loaded from: classes5.dex */
    public static abstract class CustomScheduler extends Scheduler {

        /* loaded from: classes5.dex */
        private final class ReschedulableCallable implements Callable<Void> {

            /* renamed from: a  reason: collision with root package name */
            private final Runnable f28322a;

            /* renamed from: b  reason: collision with root package name */
            private final ScheduledExecutorService f28323b;

            /* renamed from: c  reason: collision with root package name */
            private final AbstractService f28324c;

            /* renamed from: d  reason: collision with root package name */
            private final ReentrantLock f28325d = new ReentrantLock();
            @CheckForNull
            @GuardedBy("lock")

            /* renamed from: e  reason: collision with root package name */
            private SupplantableFuture f28326e;

            ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.f28322a = runnable;
                this.f28323b = scheduledExecutorService;
                this.f28324c = abstractService;
            }

            @GuardedBy("lock")
            private Cancellable b(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.f28326e;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.f28325d, d(schedule));
                    this.f28326e = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.f28331b.isCancelled()) {
                    this.f28326e.f28331b = d(schedule);
                }
                return this.f28326e;
            }

            private ScheduledFuture<Void> d(Schedule schedule) {
                return this.f28323b.schedule(this, schedule.f28328a, schedule.f28329b);
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            /* renamed from: a */
            public Void call() throws Exception {
                this.f28322a.run();
                c();
                return null;
            }

            @CanIgnoreReturnValue
            public Cancellable c() {
                Throwable th;
                Cancellable futureAsCancellable;
                try {
                    Schedule b4 = CustomScheduler.this.b();
                    this.f28325d.lock();
                    try {
                        try {
                            futureAsCancellable = b(b4);
                            this.f28325d.unlock();
                            th = null;
                        } catch (Error | RuntimeException e4) {
                            th = e4;
                            futureAsCancellable = new FutureAsCancellable(Futures.immediateCancelledFuture());
                        }
                        if (th != null) {
                            this.f28324c.l(th);
                        }
                        return futureAsCancellable;
                    } finally {
                        this.f28325d.unlock();
                    }
                } catch (Throwable th2) {
                    Platform.b(th2);
                    this.f28324c.l(th2);
                    return new FutureAsCancellable(Futures.immediateCancelledFuture());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes5.dex */
        public static final class Schedule {

            /* renamed from: a  reason: collision with root package name */
            private final long f28328a;

            /* renamed from: b  reason: collision with root package name */
            private final TimeUnit f28329b;

            public Schedule(long j4, TimeUnit timeUnit) {
                this.f28328a = j4;
                this.f28329b = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class SupplantableFuture implements Cancellable {

            /* renamed from: a  reason: collision with root package name */
            private final ReentrantLock f28330a;
            @GuardedBy("lock")

            /* renamed from: b  reason: collision with root package name */
            private Future<Void> f28331b;

            SupplantableFuture(ReentrantLock reentrantLock, Future<Void> future) {
                this.f28330a = reentrantLock;
                this.f28331b = future;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void cancel(boolean z3) {
                this.f28330a.lock();
                try {
                    this.f28331b.cancel(z3);
                } finally {
                    this.f28330a.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.f28330a.lock();
                try {
                    return this.f28331b.isCancelled();
                } finally {
                    this.f28330a.unlock();
                }
            }
        }

        public CustomScheduler() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Cancellable a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new ReschedulableCallable(abstractService, scheduledExecutorService, runnable).c();
        }

        protected abstract Schedule b() throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class FutureAsCancellable implements Cancellable {

        /* renamed from: a  reason: collision with root package name */
        private final Future<?> f28332a;

        FutureAsCancellable(Future<?> future) {
            this.f28332a = future;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void cancel(boolean z3) {
            this.f28332a.cancel(z3);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.f28332a.isCancelled();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Scheduler {
        private Scheduler() {
        }

        public static Scheduler newFixedDelaySchedule(final long j4, final long j5, final TimeUnit timeUnit) {
            boolean z3;
            Preconditions.checkNotNull(timeUnit);
            if (j5 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "delay must be > 0, found %s", j5);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Cancellable a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleWithFixedDelay(runnable, j4, j5, timeUnit));
                }
            };
        }

        public static Scheduler newFixedRateSchedule(final long j4, final long j5, final TimeUnit timeUnit) {
            boolean z3;
            Preconditions.checkNotNull(timeUnit);
            if (j5 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "period must be > 0, found %s", j5);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Cancellable a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleAtFixedRate(runnable, j4, j5, timeUnit));
                }
            };
        }

        abstract Cancellable a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class ServiceDelegate extends AbstractService {
        @CheckForNull

        /* renamed from: p  reason: collision with root package name */
        private volatile Cancellable f28339p;
        @CheckForNull

        /* renamed from: q  reason: collision with root package name */
        private volatile ScheduledExecutorService f28340q;

        /* renamed from: r  reason: collision with root package name */
        private final ReentrantLock f28341r;

        /* renamed from: s  reason: collision with root package name */
        private final Runnable f28342s;

        /* loaded from: classes5.dex */
        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Cancellable cancellable;
                ServiceDelegate.this.f28341r.lock();
                try {
                    cancellable = ServiceDelegate.this.f28339p;
                    Objects.requireNonNull(cancellable);
                } finally {
                    try {
                    } finally {
                    }
                }
                if (cancellable.isCancelled()) {
                    return;
                }
                AbstractScheduledService.this.d();
            }
        }

        private ServiceDelegate() {
            this.f28341r = new ReentrantLock();
            this.f28342s = new Task();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String v() {
            return AbstractScheduledService.this.f() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + state();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w() {
            this.f28341r.lock();
            try {
                AbstractScheduledService.this.h();
                Objects.requireNonNull(this.f28340q);
                this.f28339p = AbstractScheduledService.this.e().a(AbstractScheduledService.this.f28319a, this.f28340q, this.f28342s);
                m();
            } finally {
                try {
                } finally {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x() {
            try {
                this.f28341r.lock();
                if (state() != Service.State.STOPPING) {
                    this.f28341r.unlock();
                    return;
                }
                AbstractScheduledService.this.g();
                this.f28341r.unlock();
                n();
            } catch (Throwable th) {
                Platform.b(th);
                l(th);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void e() {
            this.f28340q = MoreExecutors.f(AbstractScheduledService.this.c(), new Supplier() { // from class: com.google.common.util.concurrent.h
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    String v3;
                    v3 = AbstractScheduledService.ServiceDelegate.this.v();
                    return v3;
                }
            });
            this.f28340q.execute(new Runnable() { // from class: com.google.common.util.concurrent.i
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractScheduledService.ServiceDelegate.this.w();
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void f() {
            Objects.requireNonNull(this.f28339p);
            Objects.requireNonNull(this.f28340q);
            this.f28339p.cancel(false);
            this.f28340q.execute(new Runnable() { // from class: com.google.common.util.concurrent.g
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractScheduledService.ServiceDelegate.this.x();
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    protected AbstractScheduledService() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f28319a.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f28319a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f28319a.awaitTerminated();
    }

    protected ScheduledExecutorService c() {
        final ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.google.common.util.concurrent.AbstractScheduledService.1ThreadFactoryImpl
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.c(AbstractScheduledService.this.f(), runnable);
            }
        });
        addListener(new Service.Listener(this) { // from class: com.google.common.util.concurrent.AbstractScheduledService.1
            @Override // com.google.common.util.concurrent.Service.Listener
            public void failed(Service.State state, Throwable th) {
                newSingleThreadScheduledExecutor.shutdown();
            }

            @Override // com.google.common.util.concurrent.Service.Listener
            public void terminated(Service.State state) {
                newSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    protected abstract void d() throws Exception;

    protected abstract Scheduler e();

    protected String f() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f28319a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f28319a.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.f28319a.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f28319a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.f28319a.stopAsync();
        return this;
    }

    public String toString() {
        return f() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28319a.awaitRunning(j4, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28319a.awaitTerminated(j4, timeUnit);
    }

    protected void g() throws Exception {
    }

    protected void h() throws Exception {
    }
}
