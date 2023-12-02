package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {

    /* renamed from: o  reason: collision with root package name */
    private static final Logger f28374o = Logger.getLogger(AggregateFuture.class.getName());
    @CheckForNull

    /* renamed from: l  reason: collision with root package name */
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> f28375l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f28376m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f28377n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z3, boolean z4) {
        super(immutableCollection.size());
        this.f28375l = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
        this.f28376m = z3;
        this.f28377n = z4;
    }

    private static boolean L(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(int i4, Future<? extends InputT> future) {
        try {
            M(i4, Futures.getDone(future));
        } catch (Error e4) {
            e = e4;
            Q(e);
        } catch (RuntimeException e5) {
            e = e5;
            Q(e);
        } catch (ExecutionException e6) {
            Q(e6.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public void T(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        boolean z3;
        int H = H();
        if (H >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Less than 0 remaining futures");
        if (H == 0) {
            V(immutableCollection);
        }
    }

    private void Q(Throwable th) {
        Preconditions.checkNotNull(th);
        if (this.f28376m && !setException(th) && L(I(), th)) {
            U(th);
        } else if (th instanceof Error) {
            U(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(ListenableFuture listenableFuture, int i4) {
        try {
            if (listenableFuture.isCancelled()) {
                this.f28375l = null;
                cancel(false);
            } else {
                N(i4, listenableFuture);
            }
        } finally {
            T(null);
        }
    }

    private static void U(Throwable th) {
        String str;
        if (th instanceof Error) {
            str = "Input Future failed with Error";
        } else {
            str = "Got more than one input Future failure. Logging failures after the first";
        }
        f28374o.log(Level.SEVERE, str, th);
    }

    private void V(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator<? extends Future<? extends InputT>> it = immutableCollection.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                Future<? extends InputT> next = it.next();
                if (!next.isCancelled()) {
                    N(i4, next);
                }
                i4++;
            }
        }
        G();
        P();
        W(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    @Override // com.google.common.util.concurrent.AggregateFutureState
    final void F(Set<Throwable> set) {
        Preconditions.checkNotNull(set);
        if (!isCancelled()) {
            Throwable a4 = a();
            Objects.requireNonNull(a4);
            L(set, a4);
        }
    }

    abstract void M(int i4, @ParametricNullness InputT inputt);

    abstract void P();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void R() {
        final ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection;
        Objects.requireNonNull(this.f28375l);
        if (this.f28375l.isEmpty()) {
            P();
        } else if (this.f28376m) {
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.f28375l.iterator();
            final int i4 = 0;
            while (it.hasNext()) {
                final ListenableFuture<? extends InputT> next = it.next();
                next.addListener(new Runnable() { // from class: com.google.common.util.concurrent.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        AggregateFuture.this.S(next, i4);
                    }
                }, MoreExecutors.directExecutor());
                i4++;
            }
        } else {
            if (this.f28377n) {
                immutableCollection = this.f28375l;
            } else {
                immutableCollection = null;
            }
            Runnable runnable = new Runnable() { // from class: com.google.common.util.concurrent.k
                @Override // java.lang.Runnable
                public final void run() {
                    AggregateFuture.this.T(immutableCollection);
                }
            };
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.f28375l.iterator();
            while (it2.hasNext()) {
                it2.next().addListener(runnable, MoreExecutors.directExecutor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ForOverride
    @OverridingMethodsMustInvokeSuper
    public void W(ReleaseResourcesReason releaseResourcesReason) {
        Preconditions.checkNotNull(releaseResourcesReason);
        this.f28375l = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void m() {
        boolean z3;
        super.m();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.f28375l;
        W(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        boolean isCancelled = isCancelled();
        if (immutableCollection != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (isCancelled & z3) {
            boolean B = B();
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                it.next().cancel(B);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public final String y() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.f28375l;
        if (immutableCollection != null) {
            return "futures=" + immutableCollection;
        }
        return super.y();
    }
}
