package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
@J2ktIncompatible
/* loaded from: classes5.dex */
public final class ClosingFuture<V> {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f28390d = Logger.getLogger(ClosingFuture.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<State> f28391a;

    /* renamed from: b  reason: collision with root package name */
    private final CloseableList f28392b;

    /* renamed from: c  reason: collision with root package name */
    private final FluentFuture<V> f28393c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.util.concurrent.ClosingFuture$11  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28398a;

        static {
            int[] iArr = new int[State.values().length];
            f28398a = iArr;
            try {
                iArr[State.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28398a[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28398a[State.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28398a[State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28398a[State.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28398a[State.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser deferredCloser) throws Exception;
    }

    /* loaded from: classes5.dex */
    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness T t3) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final DeferredCloser closer;
        @CheckForNull
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new DeferredCloser(this);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                    ClosingFuture.n(entry.getKey(), entry.getValue());
                }
                clear();
                if (this.whenClosed != null) {
                    this.whenClosed.countDown();
                }
            }
        }

        void e(@CheckForNull Closeable closeable, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                if (this.closed) {
                    ClosingFuture.n(closeable, executor);
                } else {
                    put(closeable, executor);
                }
            }
        }

        <V, U> FluentFuture<U> f(AsyncClosingFunction<V, U> asyncClosingFunction, @ParametricNullness V v3) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> apply = asyncClosingFunction.apply(closeableList.closer, v3);
                apply.i(closeableList);
                return ((ClosingFuture) apply).f28393c;
            } finally {
                e(closeableList, MoreExecutors.directExecutor());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        <V, U> ListenableFuture<U> g(ClosingFunction<? super V, U> closingFunction, @ParametricNullness V v3) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.immediateFuture(closingFunction.apply(closeableList.closer, v3));
            } finally {
                e(closeableList, MoreExecutors.directExecutor());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface ClosingCallable<V> {
        @ParametricNullness
        V call(DeferredCloser deferredCloser) throws Exception;
    }

    /* loaded from: classes5.dex */
    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U apply(DeferredCloser deferredCloser, @ParametricNullness T t3) throws Exception;
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    /* loaded from: classes5.dex */
    public static class Combiner {

        /* renamed from: a  reason: collision with root package name */
        private final CloseableList f28413a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28414b;

        /* renamed from: c  reason: collision with root package name */
        protected final ImmutableList<ClosingFuture<?>> f28415c;

        /* loaded from: classes5.dex */
        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception;
        }

        /* loaded from: classes5.dex */
        public interface CombiningCallable<V> {
            @ParametricNullness
            V call(DeferredCloser deferredCloser, Peeker peeker) throws Exception;
        }

        private Futures.FutureCombiner<Object> c() {
            if (this.f28414b) {
                return Futures.whenAllSucceed(d());
            }
            return Futures.whenAllComplete(d());
        }

        private ImmutableList<FluentFuture<?>> d() {
            return FluentIterable.from(this.f28415c).transform(new Function() { // from class: com.google.common.util.concurrent.q
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    FluentFuture b4;
                    b4 = ClosingFuture.b((ClosingFuture) obj);
                    return b4;
                }
            }).toList();
        }

        public <V> ClosingFuture<V> call(final CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(c().call((Callable<V>) new Callable<V>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner.1
                @Override // java.util.concurrent.Callable
                @ParametricNullness
                public V call() throws Exception {
                    return (V) new Peeker(Combiner.this.f28415c).c(combiningCallable, Combiner.this.f28413a);
                }

                public String toString() {
                    return combiningCallable.toString();
                }
            }, executor));
            ((ClosingFuture) closingFuture).f28392b.e(this.f28413a, MoreExecutors.directExecutor());
            return closingFuture;
        }

        public <V> ClosingFuture<V> callAsync(final AsyncCombiningCallable<V> asyncCombiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(c().callAsync((AsyncCallable<V>) new AsyncCallable<V>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner.2
                @Override // com.google.common.util.concurrent.AsyncCallable
                public ListenableFuture<V> call() throws Exception {
                    return new Peeker(Combiner.this.f28415c).d(asyncCombiningCallable, Combiner.this.f28413a);
                }

                public String toString() {
                    return asyncCombiningCallable.toString();
                }
            }, executor));
            ((ClosingFuture) closingFuture).f28392b.e(this.f28413a, MoreExecutors.directExecutor());
            return closingFuture;
        }

        private Combiner(boolean z3, Iterable<? extends ClosingFuture<?>> iterable) {
            this.f28413a = new CloseableList();
            this.f28414b = z3;
            this.f28415c = ImmutableList.copyOf(iterable);
            for (ClosingFuture<?> closingFuture : iterable) {
                closingFuture.i(this.f28413a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Combiner2<V1, V2> extends Combiner {

        /* renamed from: d  reason: collision with root package name */
        private final ClosingFuture<V1> f28420d;

        /* renamed from: e  reason: collision with root package name */
        private final ClosingFuture<V2> f28421e;

        /* loaded from: classes5.dex */
        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22) throws Exception;
        }

        /* loaded from: classes5.dex */
        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return call(new Combiner.CombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner2.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction2.apply(deferredCloser, peeker.getDone(Combiner2.this.f28420d), peeker.getDone(Combiner2.this.f28421e));
                }

                public String toString() {
                    return closingFunction2.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner2.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction2.apply(deferredCloser, peeker.getDone(Combiner2.this.f28420d), peeker.getDone(Combiner2.this.f28421e));
                }

                public String toString() {
                    return asyncClosingFunction2.toString();
                }
            }, executor);
        }

        private Combiner2(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
            super(true, ImmutableList.of((ClosingFuture<V2>) closingFuture, closingFuture2));
            this.f28420d = closingFuture;
            this.f28421e = closingFuture2;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Combiner3<V1, V2, V3> extends Combiner {

        /* renamed from: d  reason: collision with root package name */
        private final ClosingFuture<V1> f28426d;

        /* renamed from: e  reason: collision with root package name */
        private final ClosingFuture<V2> f28427e;

        /* renamed from: f  reason: collision with root package name */
        private final ClosingFuture<V3> f28428f;

        /* loaded from: classes5.dex */
        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22, @ParametricNullness V3 v3) throws Exception;
        }

        /* loaded from: classes5.dex */
        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22, @ParametricNullness V3 v3) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return call(new Combiner.CombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner3.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction3.apply(deferredCloser, peeker.getDone(Combiner3.this.f28426d), peeker.getDone(Combiner3.this.f28427e), peeker.getDone(Combiner3.this.f28428f));
                }

                public String toString() {
                    return closingFunction3.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner3.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction3.apply(deferredCloser, peeker.getDone(Combiner3.this.f28426d), peeker.getDone(Combiner3.this.f28427e), peeker.getDone(Combiner3.this.f28428f));
                }

                public String toString() {
                    return asyncClosingFunction3.toString();
                }
            }, executor);
        }

        private Combiner3(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
            super(true, ImmutableList.of((ClosingFuture<V3>) closingFuture, (ClosingFuture<V3>) closingFuture2, closingFuture3));
            this.f28426d = closingFuture;
            this.f28427e = closingFuture2;
            this.f28428f = closingFuture3;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {

        /* renamed from: d  reason: collision with root package name */
        private final ClosingFuture<V1> f28433d;

        /* renamed from: e  reason: collision with root package name */
        private final ClosingFuture<V2> f28434e;

        /* renamed from: f  reason: collision with root package name */
        private final ClosingFuture<V3> f28435f;

        /* renamed from: g  reason: collision with root package name */
        private final ClosingFuture<V4> f28436g;

        /* loaded from: classes5.dex */
        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22, @ParametricNullness V3 v3, @ParametricNullness V4 v4) throws Exception;
        }

        /* loaded from: classes5.dex */
        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22, @ParametricNullness V3 v3, @ParametricNullness V4 v4) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return call(new Combiner.CombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner4.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction4.apply(deferredCloser, peeker.getDone(Combiner4.this.f28433d), peeker.getDone(Combiner4.this.f28434e), peeker.getDone(Combiner4.this.f28435f), peeker.getDone(Combiner4.this.f28436g));
                }

                public String toString() {
                    return closingFunction4.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner4.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction4.apply(deferredCloser, peeker.getDone(Combiner4.this.f28433d), peeker.getDone(Combiner4.this.f28434e), peeker.getDone(Combiner4.this.f28435f), peeker.getDone(Combiner4.this.f28436g));
                }

                public String toString() {
                    return asyncClosingFunction4.toString();
                }
            }, executor);
        }

        private Combiner4(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
            super(true, ImmutableList.of((ClosingFuture<V4>) closingFuture, (ClosingFuture<V4>) closingFuture2, (ClosingFuture<V4>) closingFuture3, closingFuture4));
            this.f28433d = closingFuture;
            this.f28434e = closingFuture2;
            this.f28435f = closingFuture3;
            this.f28436g = closingFuture4;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {

        /* renamed from: d  reason: collision with root package name */
        private final ClosingFuture<V1> f28441d;

        /* renamed from: e  reason: collision with root package name */
        private final ClosingFuture<V2> f28442e;

        /* renamed from: f  reason: collision with root package name */
        private final ClosingFuture<V3> f28443f;

        /* renamed from: g  reason: collision with root package name */
        private final ClosingFuture<V4> f28444g;

        /* renamed from: h  reason: collision with root package name */
        private final ClosingFuture<V5> f28445h;

        /* loaded from: classes5.dex */
        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22, @ParametricNullness V3 v3, @ParametricNullness V4 v4, @ParametricNullness V5 v5) throws Exception;
        }

        /* loaded from: classes5.dex */
        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U apply(DeferredCloser deferredCloser, @ParametricNullness V1 v12, @ParametricNullness V2 v22, @ParametricNullness V3 v3, @ParametricNullness V4 v4, @ParametricNullness V5 v5) throws Exception;
        }

        public <U> ClosingFuture<U> call(final ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return call(new Combiner.CombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner5.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
                @ParametricNullness
                public U call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return (U) closingFunction5.apply(deferredCloser, peeker.getDone(Combiner5.this.f28441d), peeker.getDone(Combiner5.this.f28442e), peeker.getDone(Combiner5.this.f28443f), peeker.getDone(Combiner5.this.f28444g), peeker.getDone(Combiner5.this.f28445h));
                }

                public String toString() {
                    return closingFunction5.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> callAsync(final AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return callAsync(new Combiner.AsyncCombiningCallable<U>() { // from class: com.google.common.util.concurrent.ClosingFuture.Combiner5.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
                public ClosingFuture<U> call(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction5.apply(deferredCloser, peeker.getDone(Combiner5.this.f28441d), peeker.getDone(Combiner5.this.f28442e), peeker.getDone(Combiner5.this.f28443f), peeker.getDone(Combiner5.this.f28444g), peeker.getDone(Combiner5.this.f28445h));
                }

                public String toString() {
                    return asyncClosingFunction5.toString();
                }
            }, executor);
        }

        private Combiner5(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
            super(true, ImmutableList.of((ClosingFuture<V5>) closingFuture, (ClosingFuture<V5>) closingFuture2, (ClosingFuture<V5>) closingFuture3, (ClosingFuture<V5>) closingFuture4, closingFuture5));
            this.f28441d = closingFuture;
            this.f28442e = closingFuture2;
            this.f28443f = closingFuture3;
            this.f28444g = closingFuture4;
            this.f28445h = closingFuture5;
        }
    }

    /* loaded from: classes5.dex */
    public static final class DeferredCloser {
        @RetainedWith

        /* renamed from: a  reason: collision with root package name */
        private final CloseableList f28450a;

        DeferredCloser(CloseableList closeableList) {
            this.f28450a = closeableList;
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public <C extends Closeable> C eventuallyClose(@ParametricNullness C c4, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (c4 != null) {
                this.f28450a.e(c4, executor);
            }
            return c4;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Peeker {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableList<ClosingFuture<?>> f28451a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f28452b;

        /* JADX INFO: Access modifiers changed from: private */
        @ParametricNullness
        public <V> V c(Combiner.CombiningCallable<V> combiningCallable, CloseableList closeableList) throws Exception {
            this.f28452b = true;
            CloseableList closeableList2 = new CloseableList();
            try {
                return combiningCallable.call(closeableList2.closer, this);
            } finally {
                closeableList.e(closeableList2, MoreExecutors.directExecutor());
                this.f28452b = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <V> FluentFuture<V> d(Combiner.AsyncCombiningCallable<V> asyncCombiningCallable, CloseableList closeableList) throws Exception {
            this.f28452b = true;
            CloseableList closeableList2 = new CloseableList();
            try {
                ClosingFuture<V> call = asyncCombiningCallable.call(closeableList2.closer, this);
                call.i(closeableList);
                return ((ClosingFuture) call).f28393c;
            } finally {
                closeableList.e(closeableList2, MoreExecutors.directExecutor());
                this.f28452b = false;
            }
        }

        @ParametricNullness
        public final <D> D getDone(ClosingFuture<D> closingFuture) throws ExecutionException {
            Preconditions.checkState(this.f28452b);
            Preconditions.checkArgument(this.f28451a.contains(closingFuture));
            return (D) Futures.getDone(((ClosingFuture) closingFuture).f28393c);
        }

        private Peeker(ImmutableList<ClosingFuture<?>> immutableList) {
            this.f28451a = (ImmutableList) Preconditions.checkNotNull(immutableList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    /* loaded from: classes5.dex */
    public static final class ValueAndCloser<V> {

        /* renamed from: a  reason: collision with root package name */
        private final ClosingFuture<? extends V> f28460a;

        ValueAndCloser(ClosingFuture<? extends V> closingFuture) {
            this.f28460a = (ClosingFuture) Preconditions.checkNotNull(closingFuture);
        }

        public void closeAsync() {
            this.f28460a.m();
        }

        @ParametricNullness
        public V get() throws ExecutionException {
            return (V) Futures.getDone(((ClosingFuture) this.f28460a).f28393c);
        }
    }

    /* loaded from: classes5.dex */
    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> valueAndCloser);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ FluentFuture b(ClosingFuture closingFuture) {
        return closingFuture.f28393c;
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> listenableFuture, final Executor executor) {
        Preconditions.checkNotNull(executor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.nonCancellationPropagating(listenableFuture));
        Futures.addCallback(listenableFuture, new FutureCallback<Closeable>() { // from class: com.google.common.util.concurrent.ClosingFuture.1
            @Override // com.google.common.util.concurrent.FutureCallback
            /* renamed from: a */
            public void onSuccess(@CheckForNull Closeable closeable) {
                ClosingFuture.this.f28392b.closer.eventuallyClose(closeable, executor);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
            }
        }, MoreExecutors.directExecutor());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> listenableFuture) {
        return new ClosingFuture<>(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CloseableList closeableList) {
        l(State.OPEN, State.SUBSUMED);
        closeableList.e(this.f28392b, MoreExecutors.directExecutor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends Throwable, W extends V> ClosingFuture<V> j(Class<X> cls, final AsyncClosingFunction<? super X, W> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        return (ClosingFuture<V>) p(this.f28393c.catchingAsync(cls, new AsyncFunction<X, W>() { // from class: com.google.common.util.concurrent.ClosingFuture.8
            /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
            @Override // com.google.common.util.concurrent.AsyncFunction
            /* renamed from: a */
            public ListenableFuture apply(Throwable th) throws Exception {
                return ClosingFuture.this.f28392b.f(asyncClosingFunction, th);
            }

            public String toString() {
                return asyncClosingFunction.toString();
            }
        }, executor));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends Throwable, W extends V> ClosingFuture<V> k(Class<X> cls, final ClosingFunction<? super X, W> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        return (ClosingFuture<V>) p(this.f28393c.catchingAsync(cls, new AsyncFunction<X, W>() { // from class: com.google.common.util.concurrent.ClosingFuture.7
            /* JADX WARN: Incorrect types in method signature: (TX;)Lcom/google/common/util/concurrent/ListenableFuture<TW;>; */
            @Override // com.google.common.util.concurrent.AsyncFunction
            /* renamed from: a */
            public ListenableFuture apply(Throwable th) throws Exception {
                return ClosingFuture.this.f28392b.g(closingFunction, th);
            }

            public String toString() {
                return closingFunction.toString();
            }
        }, executor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(State state, State state2) {
        Preconditions.checkState(o(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        f28390d.log(Level.FINER, "closing {0}", this);
        this.f28392b.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(@CheckForNull final Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: com.google.common.util.concurrent.p
                @Override // java.lang.Runnable
                public final void run() {
                    ClosingFuture.q(closeable);
                }
            });
        } catch (RejectedExecutionException e4) {
            Logger logger = f28390d;
            Level level = Level.WARNING;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e4);
            }
            n(closeable, MoreExecutors.directExecutor());
        }
    }

    private boolean o(State state, State state2) {
        return androidx.compose.animation.core.d.a(this.f28391a, state, state2);
    }

    private <U> ClosingFuture<U> p(FluentFuture<U> fluentFuture) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(fluentFuture);
        i(closingFuture.f28392b);
        return closingFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException | RuntimeException e4) {
            f28390d.log(Level.WARNING, "thrown by close()", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C, V extends C> void r(ValueAndCloserConsumer<C> valueAndCloserConsumer, ClosingFuture<V> closingFuture) {
        valueAndCloserConsumer.accept(new ValueAndCloser<>(closingFuture));
    }

    public static <V> ClosingFuture<V> submit(ClosingCallable<V> closingCallable, Executor executor) {
        return new ClosingFuture<>(closingCallable, executor);
    }

    public static <V> ClosingFuture<V> submitAsync(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        return new ClosingFuture<>(asyncClosingCallable, executor);
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(false, iterable);
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(true, iterable);
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(final AsyncFunction<V, U> asyncFunction) {
        Preconditions.checkNotNull(asyncFunction);
        return new AsyncClosingFunction<V, U>() { // from class: com.google.common.util.concurrent.ClosingFuture.6
            @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
            public ClosingFuture<U> apply(DeferredCloser deferredCloser, V v3) throws Exception {
                return ClosingFuture.from(AsyncFunction.this.apply(v3));
            }
        };
    }

    @CanIgnoreReturnValue
    public boolean cancel(boolean z3) {
        f28390d.log(Level.FINER, "cancelling {0}", this);
        boolean cancel = this.f28393c.cancel(z3);
        if (cancel) {
            m();
        }
        return cancel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catching(Class<X> cls, ClosingFunction<? super X, ? extends V> closingFunction, Executor executor) {
        return k(cls, closingFunction, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> cls, AsyncClosingFunction<? super X, ? extends V> asyncClosingFunction, Executor executor) {
        return j(cls, asyncClosingFunction, executor);
    }

    protected void finalize() {
        if (this.f28391a.get().equals(State.OPEN)) {
            f28390d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            finishToFuture();
        }
    }

    public FluentFuture<V> finishToFuture() {
        if (o(State.OPEN, State.WILL_CLOSE)) {
            f28390d.log(Level.FINER, "will close {0}", this);
            this.f28393c.addListener(new Runnable() { // from class: com.google.common.util.concurrent.ClosingFuture.9
                @Override // java.lang.Runnable
                public void run() {
                    ClosingFuture closingFuture = ClosingFuture.this;
                    State state = State.WILL_CLOSE;
                    State state2 = State.CLOSING;
                    closingFuture.l(state, state2);
                    ClosingFuture.this.m();
                    ClosingFuture.this.l(state2, State.CLOSED);
                }
            }, MoreExecutors.directExecutor());
        } else {
            switch (AnonymousClass11.f28398a[this.f28391a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        return this.f28393c;
    }

    public void finishToValueAndCloser(final ValueAndCloserConsumer<? super V> valueAndCloserConsumer, Executor executor) {
        Preconditions.checkNotNull(valueAndCloserConsumer);
        if (!o(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            int i4 = AnonymousClass11.f28398a[this.f28391a.get().ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3 && i4 != 4 && i4 != 5) {
                        throw new AssertionError(this.f28391a);
                    }
                    throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
                }
                throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
            }
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        this.f28393c.addListener(new Runnable() { // from class: com.google.common.util.concurrent.ClosingFuture.10
            @Override // java.lang.Runnable
            public void run() {
                ClosingFuture.r(valueAndCloserConsumer, ClosingFuture.this);
            }
        }, executor);
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.f28393c.transform(Functions.constant(null), MoreExecutors.directExecutor()));
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(RemoteConfigConstants.ResponseFieldKey.STATE, this.f28391a.get()).addValue(this.f28393c).toString();
    }

    public <U> ClosingFuture<U> transform(final ClosingFunction<? super V, U> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        return p(this.f28393c.transformAsync(new AsyncFunction<V, U>() { // from class: com.google.common.util.concurrent.ClosingFuture.4
            @Override // com.google.common.util.concurrent.AsyncFunction
            public ListenableFuture<U> apply(V v3) throws Exception {
                return ClosingFuture.this.f28392b.g(closingFunction, v3);
            }

            public String toString() {
                return closingFunction.toString();
            }
        }, executor));
    }

    public <U> ClosingFuture<U> transformAsync(final AsyncClosingFunction<? super V, U> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        return p(this.f28393c.transformAsync(new AsyncFunction<V, U>() { // from class: com.google.common.util.concurrent.ClosingFuture.5
            @Override // com.google.common.util.concurrent.AsyncFunction
            public ListenableFuture<U> apply(V v3) throws Exception {
                return ClosingFuture.this.f28392b.f(asyncClosingFunction, v3);
            }

            public String toString() {
                return asyncClosingFunction.toString();
            }
        }, executor));
    }

    private ClosingFuture(ListenableFuture<V> listenableFuture) {
        this.f28391a = new AtomicReference<>(State.OPEN);
        this.f28392b = new CloseableList();
        this.f28393c = FluentFuture.from(listenableFuture);
    }

    public static Combiner whenAllComplete(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return whenAllComplete(Lists.asList(closingFuture, closingFutureArr));
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new Combiner2<>(closingFuture2);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new Combiner3<>(closingFuture2, closingFuture3);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new Combiner4<>(closingFuture2, closingFuture3, closingFuture4);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new Combiner5<>(closingFuture2, closingFuture3, closingFuture4, closingFuture5);
    }

    private ClosingFuture(final ClosingCallable<V> closingCallable, Executor executor) {
        this.f28391a = new AtomicReference<>(State.OPEN);
        this.f28392b = new CloseableList();
        Preconditions.checkNotNull(closingCallable);
        TrustedListenableFutureTask E = TrustedListenableFutureTask.E(new Callable<V>() { // from class: com.google.common.util.concurrent.ClosingFuture.2
            @Override // java.util.concurrent.Callable
            @ParametricNullness
            public V call() throws Exception {
                return (V) closingCallable.call(ClosingFuture.this.f28392b.closer);
            }

            public String toString() {
                return closingCallable.toString();
            }
        });
        executor.execute(E);
        this.f28393c = E;
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        return whenAllSucceed(FluentIterable.of(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6).append(closingFutureArr));
    }

    private ClosingFuture(final AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        this.f28391a = new AtomicReference<>(State.OPEN);
        this.f28392b = new CloseableList();
        Preconditions.checkNotNull(asyncClosingCallable);
        TrustedListenableFutureTask C = TrustedListenableFutureTask.C(new AsyncCallable<V>() { // from class: com.google.common.util.concurrent.ClosingFuture.3
            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture<V> call() throws Exception {
                CloseableList closeableList = new CloseableList();
                try {
                    ClosingFuture<V> call = asyncClosingCallable.call(closeableList.closer);
                    call.i(ClosingFuture.this.f28392b);
                    return ((ClosingFuture) call).f28393c;
                } finally {
                    ClosingFuture.this.f28392b.e(closeableList, MoreExecutors.directExecutor());
                }
            }

            public String toString() {
                return asyncClosingCallable.toString();
            }
        });
        executor.execute(C);
        this.f28393c = C;
    }
}
