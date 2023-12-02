package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    ListenableFuture<? extends I> f28372h;
    @CheckForNull

    /* renamed from: i  reason: collision with root package name */
    F f28373i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* renamed from: G */
        public ListenableFuture<? extends O> E(AsyncFunction<? super I, ? extends O> asyncFunction, @ParametricNullness I i4) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i4);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* renamed from: H */
        public void F(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void F(@ParametricNullness O o4) {
            set(o4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @ParametricNullness
        /* renamed from: G */
        public O E(Function<? super I, ? extends O> function, @ParametricNullness I i4) {
            return function.apply(i4);
        }
    }

    AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f4) {
        this.f28372h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.f28373i = (F) Preconditions.checkNotNull(f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> ListenableFuture<O> C(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function);
        listenableFuture.addListener(transformFuture, MoreExecutors.d(executor, transformFuture));
        return transformFuture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> ListenableFuture<O> D(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.d(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @ParametricNullness
    @ForOverride
    abstract T E(F f4, @ParametricNullness I i4) throws Exception;

    @ForOverride
    abstract void F(@ParametricNullness T t3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void m() {
        x(this.f28372h);
        this.f28372h = null;
        this.f28373i = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        ListenableFuture<? extends I> listenableFuture = this.f28372h;
        F f4 = this.f28373i;
        boolean isCancelled = isCancelled();
        boolean z4 = true;
        if (listenableFuture == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z5 = isCancelled | z3;
        if (f4 != null) {
            z4 = false;
        }
        if (z5 | z4) {
            return;
        }
        this.f28372h = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object E = E(f4, Futures.getDone(listenableFuture));
                this.f28373i = null;
                F(E);
            } catch (Throwable th) {
                try {
                    Platform.b(th);
                    setException(th);
                } finally {
                    this.f28373i = null;
                }
            }
        } catch (Error e4) {
            setException(e4);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e5) {
            setException(e5);
        } catch (ExecutionException e6) {
            setException(e6.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String y() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.f28372h;
        F f4 = this.f28373i;
        String y3 = super.y();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f4 != null) {
            return str + "function=[" + f4 + "]";
        } else if (y3 != null) {
            return str + y3;
        } else {
            return null;
        }
    }
}
