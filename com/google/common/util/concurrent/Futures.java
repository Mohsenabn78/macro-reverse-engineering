package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.Partially;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Futures extends GwtFuturesCatchingSpecialization {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class CallbackListener<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Future<V> f28500a;

        /* renamed from: b  reason: collision with root package name */
        final FutureCallback<? super V> f28501b;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.f28500a = future;
            this.f28501b = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable tryInternalFastPathGetFailure;
            Future<V> future = this.f28500a;
            if ((future instanceof InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) future)) != null) {
                this.f28501b.onFailure(tryInternalFastPathGetFailure);
                return;
            }
            try {
                this.f28501b.onSuccess(Futures.getDone(this.f28500a));
            } catch (Error e4) {
                e = e4;
                this.f28501b.onFailure(e);
            } catch (RuntimeException e5) {
                e = e5;
                this.f28501b.onFailure(e);
            } catch (ExecutionException e6) {
                this.f28501b.onFailure(e6.getCause());
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.f28501b).toString();
        }
    }

    @GwtCompatible
    /* loaded from: classes5.dex */
    public static final class FutureCombiner<V> {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f28502a;

        /* renamed from: b  reason: collision with root package name */
        private final ImmutableList<ListenableFuture<? extends V>> f28503b;

        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture(this.f28503b, this.f28502a, executor, callable);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture(this.f28503b, this.f28502a, executor, asyncCallable);
        }

        public ListenableFuture<?> run(final Runnable runnable, Executor executor) {
            return call(new Callable<Void>(this) { // from class: com.google.common.util.concurrent.Futures.FutureCombiner.1
                @Override // java.util.concurrent.Callable
                @CheckForNull
                /* renamed from: a */
                public Void call() throws Exception {
                    runnable.run();
                    return null;
                }
            }, executor);
        }

        private FutureCombiner(boolean z3, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.f28502a = z3;
            this.f28503b = immutableList;
        }
    }

    /* loaded from: classes5.dex */
    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        @CheckForNull

        /* renamed from: h  reason: collision with root package name */
        private InCompletionOrderState<T> f28505h;

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z3) {
            InCompletionOrderState<T> inCompletionOrderState = this.f28505h;
            if (super.cancel(z3)) {
                Objects.requireNonNull(inCompletionOrderState);
                inCompletionOrderState.g(z3);
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void m() {
            this.f28505h = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String y() {
            InCompletionOrderState<T> inCompletionOrderState = this.f28505h;
            if (inCompletionOrderState != null) {
                return "inputCount=[" + ((InCompletionOrderState) inCompletionOrderState).f28509d.length + "], remaining=[" + ((InCompletionOrderState) inCompletionOrderState).f28508c.get() + "]";
            }
            return null;
        }

        private InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            this.f28505h = inCompletionOrderState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class InCompletionOrderState<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f28506a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f28507b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f28508c;

        /* renamed from: d  reason: collision with root package name */
        private final ListenableFuture<? extends T>[] f28509d;

        /* renamed from: e  reason: collision with root package name */
        private volatile int f28510e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void d(InCompletionOrderState inCompletionOrderState, ImmutableList immutableList, int i4) {
            inCompletionOrderState.f(immutableList, i4);
        }

        private void e() {
            ListenableFuture<? extends T>[] listenableFutureArr;
            if (this.f28508c.decrementAndGet() == 0 && this.f28506a) {
                for (ListenableFuture<? extends T> listenableFuture : this.f28509d) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.f28507b);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ImmutableList<AbstractFuture<T>> immutableList, int i4) {
            ListenableFuture<? extends T> listenableFuture = this.f28509d[i4];
            Objects.requireNonNull(listenableFuture);
            ListenableFuture<? extends T> listenableFuture2 = listenableFuture;
            this.f28509d[i4] = null;
            for (int i5 = this.f28510e; i5 < immutableList.size(); i5++) {
                if (immutableList.get(i5).setFuture(listenableFuture2)) {
                    e();
                    this.f28510e = i5 + 1;
                    return;
                }
            }
            this.f28510e = immutableList.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(boolean z3) {
            this.f28506a = true;
            if (!z3) {
                this.f28507b = false;
            }
            e();
        }

        private InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.f28506a = false;
            this.f28507b = true;
            this.f28510e = 0;
            this.f28509d = listenableFutureArr;
            this.f28508c = new AtomicInteger(listenableFutureArr.length);
        }
    }

    /* loaded from: classes5.dex */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        @CheckForNull

        /* renamed from: h  reason: collision with root package name */
        private ListenableFuture<V> f28511h;

        NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.f28511h = listenableFuture;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void m() {
            this.f28511h = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture = this.f28511h;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String y() {
            ListenableFuture<V> listenableFuture = this.f28511h;
            if (listenableFuture != null) {
                return "delegate=[" + listenableFuture + "]";
            }
            return null;
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), true);
    }

    private static <T> ListenableFuture<? extends T>[] c(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        Collection copyOf;
        if (iterable instanceof Collection) {
            copyOf = (Collection) iterable;
        } else {
            copyOf = ImmutableList.copyOf(iterable);
        }
        return (ListenableFuture[]) copyOf.toArray(new ListenableFuture[0]);
    }

    @Partially.GwtIncompatible
    @J2ktIncompatible
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.C(listenableFuture, cls, function, executor);
    }

    @Partially.GwtIncompatible
    @J2ktIncompatible
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.D(listenableFuture, cls, asyncFunction, executor);
    }

    private static void f(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @J2ktIncompatible
    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return (V) FuturesGetChecked.e(future, cls);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e4) {
            f(e4.getCause());
            throw new AssertionError();
        }
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        ImmediateFuture.ImmediateCancelledFuture<Object> immediateCancelledFuture = ImmediateFuture.ImmediateCancelledFuture.f28520h;
        if (immediateCancelledFuture != null) {
            return immediateCancelledFuture;
        }
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static <V> ListenableFuture<V> immediateFuture(@ParametricNullness V v3) {
        if (v3 == null) {
            return (ListenableFuture<V>) ImmediateFuture.f28517b;
        }
        return new ImmediateFuture(v3);
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return ImmediateFuture.f28517b;
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        ListenableFuture[] c4 = c(iterable);
        final InCompletionOrderState inCompletionOrderState = new InCompletionOrderState(c4);
        ImmutableList.Builder builderWithExpectedSize = ImmutableList.builderWithExpectedSize(c4.length);
        for (int i4 = 0; i4 < c4.length; i4++) {
            builderWithExpectedSize.add((ImmutableList.Builder) new InCompletionOrderFuture(inCompletionOrderState));
        }
        final ImmutableList<ListenableFuture<T>> build = builderWithExpectedSize.build();
        for (final int i5 = 0; i5 < c4.length; i5++) {
            c4[i5].addListener(new Runnable() { // from class: com.google.common.util.concurrent.t
                @Override // java.lang.Runnable
                public final void run() {
                    Futures.InCompletionOrderState.d(Futures.InCompletionOrderState.this, build, i5);
                }
            }, MoreExecutors.directExecutor());
        }
        return build;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <I, O> Future<O> lazyTransform(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future<O>() { // from class: com.google.common.util.concurrent.Futures.1
            private O a(I i4) throws ExecutionException {
                try {
                    return (O) function.apply(i4);
                } catch (Error | RuntimeException e4) {
                    throw new ExecutionException(e4);
                }
            }

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z3) {
                return future.cancel(z3);
            }

            @Override // java.util.concurrent.Future
            public O get() throws InterruptedException, ExecutionException {
                return a(future.get());
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return future.isDone();
            }

            @Override // java.util.concurrent.Future
            public O get(long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return a(future.get(j4, timeUnit));
            }
        };
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.addListener(nonCancellationPropagatingFuture, MoreExecutors.directExecutor());
        return nonCancellationPropagatingFuture;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask C = TrustedListenableFutureTask.C(asyncCallable);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(C, j4, timeUnit);
        C.addListener(new Runnable() { // from class: com.google.common.util.concurrent.s
            @Override // java.lang.Runnable
            public final void run() {
                schedule.cancel(false);
            }
        }, MoreExecutors.directExecutor());
        return C;
    }

    public static <O> ListenableFuture<O> submit(Callable<O> callable, Executor executor) {
        TrustedListenableFutureTask E = TrustedListenableFutureTask.E(callable);
        executor.execute(E);
        return E;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask C = TrustedListenableFutureTask.C(asyncCallable);
        executor.execute(C);
        return C;
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), false);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.C(listenableFuture, function, executor);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.D(listenableFuture, asyncFunction, executor);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(listenableFutureArr));
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(listenableFutureArr));
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j4, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return TimeoutFuture.F(listenableFuture, j4, timeUnit, scheduledExecutorService);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @J2ktIncompatible
    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j4, TimeUnit timeUnit) throws Exception {
        return (V) FuturesGetChecked.f(future, cls, j4, timeUnit);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), false);
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(iterable));
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(iterable));
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), true);
    }

    public static ListenableFuture<Void> submit(Runnable runnable, Executor executor) {
        TrustedListenableFutureTask D = TrustedListenableFutureTask.D(runnable, null);
        executor.execute(D);
        return D;
    }
}
