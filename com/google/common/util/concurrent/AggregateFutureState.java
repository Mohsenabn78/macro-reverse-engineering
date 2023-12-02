package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
/* loaded from: classes5.dex */
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicHelper f28381j;

    /* renamed from: k  reason: collision with root package name */
    private static final Logger f28382k = Logger.getLogger(AggregateFutureState.class.getName());
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    private volatile Set<Throwable> f28383h = null;

    /* renamed from: i  reason: collision with root package name */
    private volatile int f28384i;

    /* loaded from: classes5.dex */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        abstract int b(AggregateFutureState<?> aggregateFutureState);
    }

    /* loaded from: classes5.dex */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> f28385a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> f28386b;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f28385a = atomicReferenceFieldUpdater;
            this.f28386b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            androidx.concurrent.futures.a.a(this.f28385a, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int b(AggregateFutureState<?> aggregateFutureState) {
            return this.f28386b.decrementAndGet(aggregateFutureState);
        }
    }

    /* loaded from: classes5.dex */
    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (((AggregateFutureState) aggregateFutureState).f28383h == set) {
                    ((AggregateFutureState) aggregateFutureState).f28383h = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int b(AggregateFutureState<?> aggregateFutureState) {
            int E;
            synchronized (aggregateFutureState) {
                E = AggregateFutureState.E(aggregateFutureState);
            }
            return E;
        }
    }

    static {
        AtomicHelper synchronizedAtomicHelper;
        Throwable th = null;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "h"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "i"));
        } catch (Error | RuntimeException e4) {
            synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            th = e4;
        }
        f28381j = synchronizedAtomicHelper;
        if (th != null) {
            f28382k.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateFutureState(int i4) {
        this.f28384i = i4;
    }

    static /* synthetic */ int E(AggregateFutureState aggregateFutureState) {
        int i4 = aggregateFutureState.f28384i - 1;
        aggregateFutureState.f28384i = i4;
        return i4;
    }

    abstract void F(Set<Throwable> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G() {
        this.f28383h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int H() {
        return f28381j.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> I() {
        Set<Throwable> set = this.f28383h;
        if (set == null) {
            Set<Throwable> newConcurrentHashSet = Sets.newConcurrentHashSet();
            F(newConcurrentHashSet);
            f28381j.a(this, null, newConcurrentHashSet);
            Set<Throwable> set2 = this.f28383h;
            Objects.requireNonNull(set2);
            return set2;
        }
        return set;
    }
}
