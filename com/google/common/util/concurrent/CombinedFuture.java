package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class CombinedFuture<V> extends AggregateFuture<Object, V> {
    @CheckForNull

    /* renamed from: p  reason: collision with root package name */
    private CombinedFuture<V>.CombinedFutureInterruptibleTask<?> f28463p;

    /* loaded from: classes5.dex */
    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String g() {
            return this.callable.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* renamed from: l */
        public ListenableFuture<V> f() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        /* renamed from: m */
        public void j(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.setFuture(listenableFuture);
        }
    }

    /* loaded from: classes5.dex */
    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            this.callable = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        @ParametricNullness
        V f() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String g() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        void j(@ParametricNullness V v3) {
            CombinedFuture.this.set(v3);
        }
    }

    /* loaded from: classes5.dex */
    private abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;

        CombinedFutureInterruptibleTask(Executor executor) {
            this.listenerExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void a(Throwable th) {
            CombinedFuture.this.f28463p = null;
            if (th instanceof ExecutionException) {
                CombinedFuture.this.setException(((ExecutionException) th).getCause());
            } else if (th instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void b(@ParametricNullness T t3) {
            CombinedFuture.this.f28463p = null;
            j(t3);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean e() {
            return CombinedFuture.this.isDone();
        }

        final void i() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e4) {
                CombinedFuture.this.setException(e4);
            }
        }

        abstract void j(@ParametricNullness T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z3, Executor executor, AsyncCallable<V> asyncCallable) {
        super(immutableCollection, z3, false);
        this.f28463p = new AsyncCallableInterruptibleTask(asyncCallable, executor);
        R();
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void P() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.f28463p;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.i();
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void W(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.W(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.f28463p = null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void w() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.f28463p;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z3, Executor executor, Callable<V> callable) {
        super(immutableCollection, z3, false);
        this.f28463p = new CallableInterruptibleTask(callable, executor);
        R();
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void M(int i4, @CheckForNull Object obj) {
    }
}
