package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes5.dex */
public abstract class Striped<L> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {

        /* renamed from: b  reason: collision with root package name */
        private final Object[] f28616b;

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i4) {
            return (L) this.f28616b[i4];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f28616b.length;
        }

        private CompactStriped(int i4, Supplier<L> supplier) {
            super(i4);
            int i5 = 0;
            Preconditions.checkArgument(i4 <= 1073741824, "Stripes must be <= 2^30)");
            this.f28616b = new Object[this.f28620a + 1];
            while (true) {
                Object[] objArr = this.f28616b;
                if (i5 >= objArr.length) {
                    return;
                }
                objArr[i5] = supplier.get();
                i5++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {

        /* renamed from: b  reason: collision with root package name */
        final ConcurrentMap<Integer, L> f28617b;

        /* renamed from: c  reason: collision with root package name */
        final Supplier<L> f28618c;

        /* renamed from: d  reason: collision with root package name */
        final int f28619d;

        LargeLazyStriped(int i4, Supplier<L> supplier) {
            super(i4);
            int i5;
            int i6 = this.f28620a;
            if (i6 == -1) {
                i5 = Integer.MAX_VALUE;
            } else {
                i5 = i6 + 1;
            }
            this.f28619d = i5;
            this.f28618c = supplier;
            this.f28617b = new MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i4) {
            if (this.f28619d != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i4, size());
            }
            L l4 = this.f28617b.get(Integer.valueOf(i4));
            if (l4 != null) {
                return l4;
            }
            L l5 = this.f28618c.get();
            return (L) MoreObjects.firstNonNull(this.f28617b.putIfAbsent(Integer.valueOf(i4), l5), l5);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f28619d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PaddedLock() {
            super(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        PaddedSemaphore(int i4) {
            super(i4, false);
        }
    }

    /* loaded from: classes5.dex */
    private static abstract class PowerOfTwoStriped<L> extends Striped<L> {

        /* renamed from: a  reason: collision with root package name */
        final int f28620a;

        PowerOfTwoStriped(int i4) {
            super();
            boolean z3;
            int f4;
            if (i4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Stripes must be positive");
            if (i4 > 1073741824) {
                f4 = -1;
            } else {
                f4 = Striped.f(i4) - 1;
            }
            this.f28620a = f4;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            return getAt(h(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        final int h(Object obj) {
            return Striped.m(obj.hashCode()) & this.f28620a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceArray<ArrayReference<? extends L>> f28621b;

        /* renamed from: c  reason: collision with root package name */
        final Supplier<L> f28622c;

        /* renamed from: d  reason: collision with root package name */
        final int f28623d;

        /* renamed from: e  reason: collision with root package name */
        final ReferenceQueue<L> f28624e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class ArrayReference<L> extends WeakReference<L> {

            /* renamed from: a  reason: collision with root package name */
            final int f28625a;

            ArrayReference(L l4, int i4, ReferenceQueue<L> referenceQueue) {
                super(l4, referenceQueue);
                this.f28625a = i4;
            }
        }

        SmallLazyStriped(int i4, Supplier<L> supplier) {
            super(i4);
            int i5;
            this.f28624e = new ReferenceQueue<>();
            int i6 = this.f28620a;
            if (i6 == -1) {
                i5 = Integer.MAX_VALUE;
            } else {
                i5 = i6 + 1;
            }
            this.f28623d = i5;
            this.f28621b = new AtomicReferenceArray<>(i5);
            this.f28622c = supplier;
        }

        private void n() {
            while (true) {
                Reference<? extends L> poll = this.f28624e.poll();
                if (poll != null) {
                    ArrayReference arrayReference = (ArrayReference) poll;
                    f0.a(this.f28621b, arrayReference.f28625a, arrayReference, null);
                } else {
                    return;
                }
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i4) {
            L l4;
            L l5;
            if (this.f28623d != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i4, size());
            }
            ArrayReference<? extends L> arrayReference = this.f28621b.get(i4);
            if (arrayReference == null) {
                l4 = null;
            } else {
                l4 = arrayReference.get();
            }
            if (l4 != null) {
                return l4;
            }
            L l6 = this.f28622c.get();
            ArrayReference arrayReference2 = new ArrayReference(l6, i4, this.f28624e);
            while (!f0.a(this.f28621b, i4, arrayReference, arrayReference2)) {
                arrayReference = this.f28621b.get(i4);
                if (arrayReference == null) {
                    l5 = null;
                    continue;
                } else {
                    l5 = arrayReference.get();
                    continue;
                }
                if (l5 != null) {
                    return l5;
                }
            }
            n();
            return l6;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f28623d;
        }
    }

    /* loaded from: classes5.dex */
    private static final class WeakSafeCondition extends ForwardingCondition {

        /* renamed from: a  reason: collision with root package name */
        private final Condition f28626a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakSafeReadWriteLock f28627b;

        WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.f28626a = condition;
            this.f28627b = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        Condition a() {
            return this.f28626a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class WeakSafeLock extends ForwardingLock {

        /* renamed from: a  reason: collision with root package name */
        private final Lock f28628a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakSafeReadWriteLock f28629b;

        WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.f28628a = lock;
            this.f28629b = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        Lock a() {
            return this.f28628a;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.f28628a.newCondition(), this.f28629b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class WeakSafeReadWriteLock implements ReadWriteLock {

        /* renamed from: a  reason: collision with root package name */
        private final ReadWriteLock f28630a = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.f28630a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.f28630a.writeLock(), this);
        }
    }

    private Striped() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i4) {
        return 1 << IntMath.log2(i4, RoundingMode.CEILING);
    }

    static <L> Striped<L> g(int i4, Supplier<L> supplier) {
        return new CompactStriped(i4, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Lock i() {
        return new ReentrantLock(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore j(int i4) {
        return new Semaphore(i4, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore k(int i4) {
        return new PaddedSemaphore(i4);
    }

    private static <L> Striped<L> l(int i4, Supplier<L> supplier) {
        if (i4 < 1024) {
            return new SmallLazyStriped(i4, supplier);
        }
        return new LargeLazyStriped(i4, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i4) {
        return l(i4, new Supplier() { // from class: com.google.common.util.concurrent.d0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Lock i5;
                i5 = Striped.i();
                return i5;
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i4) {
        return l(i4, new Supplier() { // from class: com.google.common.util.concurrent.b0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Striped.WeakSafeReadWriteLock();
            }
        });
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i4, final int i5) {
        return l(i4, new Supplier() { // from class: com.google.common.util.concurrent.a0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Semaphore j4;
                j4 = Striped.j(i5);
                return j4;
            }
        });
    }

    public static Striped<Lock> lock(int i4) {
        return g(i4, new Supplier() { // from class: com.google.common.util.concurrent.e0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Striped.PaddedLock();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i4) {
        int i5 = i4 ^ ((i4 >>> 20) ^ (i4 >>> 12));
        return (i5 >>> 4) ^ ((i5 >>> 7) ^ i5);
    }

    public static Striped<ReadWriteLock> readWriteLock(int i4) {
        return g(i4, new Supplier() { // from class: com.google.common.util.concurrent.c0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new ReentrantReadWriteLock();
            }
        });
    }

    public static Striped<Semaphore> semaphore(int i4, final int i5) {
        return g(i4, new Supplier() { // from class: com.google.common.util.concurrent.z
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Semaphore k4;
                k4 = Striped.k(i5);
                return k4;
            }
        });
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList newArrayList = Lists.newArrayList(iterable);
        if (newArrayList.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[newArrayList.size()];
        for (int i4 = 0; i4 < newArrayList.size(); i4++) {
            iArr[i4] = h(newArrayList.get(i4));
        }
        Arrays.sort(iArr);
        int i5 = iArr[0];
        newArrayList.set(0, getAt(i5));
        for (int i6 = 1; i6 < newArrayList.size(); i6++) {
            int i7 = iArr[i6];
            if (i7 == i5) {
                newArrayList.set(i6, newArrayList.get(i6 - 1));
            } else {
                newArrayList.set(i6, getAt(i7));
                i5 = i7;
            }
        }
        return Collections.unmodifiableList(newArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i4);

    abstract int h(Object obj);

    public abstract int size();
}
