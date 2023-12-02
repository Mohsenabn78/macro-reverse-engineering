package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.JdkFutureAdapters;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class JdkFutureAdapters {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

        /* renamed from: e  reason: collision with root package name */
        private static final ThreadFactory f28523e;

        /* renamed from: f  reason: collision with root package name */
        private static final Executor f28524f;

        /* renamed from: a  reason: collision with root package name */
        private final Executor f28525a;

        /* renamed from: b  reason: collision with root package name */
        private final ExecutionList f28526b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f28527c;

        /* renamed from: d  reason: collision with root package name */
        private final Future<V> f28528d;

        static {
            ThreadFactory build = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            f28523e = build;
            f28524f = Executors.newCachedThreadPool(build);
        }

        ListenableFutureAdapter(Future<V> future) {
            this(future, f28524f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            try {
                Uninterruptibles.getUninterruptibly(this.f28528d);
            } catch (Error | RuntimeException | ExecutionException unused) {
            }
            this.f28526b.execute();
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.f28526b.add(runnable, executor);
            if (this.f28527c.compareAndSet(false, true)) {
                if (this.f28528d.isDone()) {
                    this.f28526b.execute();
                } else {
                    this.f28525a.execute(new Runnable() { // from class: com.google.common.util.concurrent.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            JdkFutureAdapters.ListenableFutureAdapter.this.h();
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* renamed from: f */
        public Future<V> e() {
            return this.f28528d;
        }

        ListenableFutureAdapter(Future<V> future, Executor executor) {
            this.f28526b = new ExecutionList();
            this.f28527c = new AtomicBoolean(false);
            this.f28528d = (Future) Preconditions.checkNotNull(future);
            this.f28525a = (Executor) Preconditions.checkNotNull(executor);
        }
    }

    private JdkFutureAdapters() {
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future) {
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new ListenableFutureAdapter(future);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future, Executor executor) {
        Preconditions.checkNotNull(executor);
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new ListenableFutureAdapter(future, executor);
    }
}
