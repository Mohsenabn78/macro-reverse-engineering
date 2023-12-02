package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* renamed from: w  reason: collision with root package name */
    static final Logger f26470w = Logger.getLogger(LocalCache.class.getName());

    /* renamed from: x  reason: collision with root package name */
    static final ValueReference<Object, Object> f26471x = new ValueReference<Object, Object>() { // from class: com.google.common.cache.LocalCache.1
        @Override // com.google.common.cache.LocalCache.ValueReference
        @CheckForNull
        public Object b() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        @CheckForNull
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        @CheckForNull
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> d(ReferenceQueue<Object> referenceQueue, @CheckForNull Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }
    };

    /* renamed from: y  reason: collision with root package name */
    static final Queue<?> f26472y = new AbstractQueue<Object>() { // from class: com.google.common.cache.LocalCache.2
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        @CheckForNull
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        @CheckForNull
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f26473a;

    /* renamed from: b  reason: collision with root package name */
    final int f26474b;

    /* renamed from: c  reason: collision with root package name */
    final Segment<K, V>[] f26475c;

    /* renamed from: d  reason: collision with root package name */
    final int f26476d;

    /* renamed from: e  reason: collision with root package name */
    final Equivalence<Object> f26477e;

    /* renamed from: f  reason: collision with root package name */
    final Equivalence<Object> f26478f;

    /* renamed from: g  reason: collision with root package name */
    final Strength f26479g;

    /* renamed from: h  reason: collision with root package name */
    final Strength f26480h;

    /* renamed from: i  reason: collision with root package name */
    final long f26481i;

    /* renamed from: j  reason: collision with root package name */
    final Weigher<K, V> f26482j;

    /* renamed from: k  reason: collision with root package name */
    final long f26483k;

    /* renamed from: l  reason: collision with root package name */
    final long f26484l;

    /* renamed from: m  reason: collision with root package name */
    final long f26485m;

    /* renamed from: n  reason: collision with root package name */
    final Queue<RemovalNotification<K, V>> f26486n;

    /* renamed from: o  reason: collision with root package name */
    final RemovalListener<K, V> f26487o;

    /* renamed from: p  reason: collision with root package name */
    final Ticker f26488p;

    /* renamed from: q  reason: collision with root package name */
    final EntryFactory f26489q;

    /* renamed from: r  reason: collision with root package name */
    final AbstractCache.StatsCounter f26490r;
    @CheckForNull

    /* renamed from: s  reason: collision with root package name */
    final CacheLoader<? super K, V> f26491s;
    @RetainedWith
    @CheckForNull

    /* renamed from: t  reason: collision with root package name */
    Set<K> f26492t;
    @RetainedWith
    @CheckForNull

    /* renamed from: u  reason: collision with root package name */
    Collection<V> f26493u;
    @RetainedWith
    @CheckForNull

    /* renamed from: v  reason: collision with root package name */
    Set<Map.Entry<K, V>> f26494v;

    /* loaded from: classes5.dex */
    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        AbstractCacheSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.K(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.K(this).toArray(eArr);
        }
    }

    /* loaded from: classes5.dex */
    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> a() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int b() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void c(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> e() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void f(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long g() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void h(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void i(long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> j() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> l() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> m() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long n() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void q(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final ReferenceEntry<K, V> f26496a = new AbstractReferenceEntry<K, V>(this) { // from class: com.google.common.cache.LocalCache.AccessQueue.1
            @Weak

            /* renamed from: a  reason: collision with root package name */
            ReferenceEntry<K, V> f26497a = this;
            @Weak

            /* renamed from: b  reason: collision with root package name */
            ReferenceEntry<K, V> f26498b = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void c(ReferenceEntry<K, V> referenceEntry) {
                this.f26498b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> j() {
                return this.f26498b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> m() {
                return this.f26497a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long n() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void o(ReferenceEntry<K, V> referenceEntry) {
                this.f26497a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void h(long j4) {
            }
        };

        AccessQueue() {
        }

        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.d(referenceEntry.j(), referenceEntry.m());
            LocalCache.d(this.f26496a.j(), referenceEntry);
            LocalCache.d(referenceEntry, this.f26496a);
            return true;
        }

        @Override // java.util.Queue
        @CheckForNull
        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> m4 = this.f26496a.m();
            if (m4 == this.f26496a) {
                return null;
            }
            return m4;
        }

        @Override // java.util.Queue
        @CheckForNull
        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> m4 = this.f26496a.m();
            if (m4 == this.f26496a) {
                return null;
            }
            remove(m4);
            return m4;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> m4 = this.f26496a.m();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.f26496a;
                if (m4 != referenceEntry) {
                    ReferenceEntry<K, V> m5 = m4.m();
                    LocalCache.y(m4);
                    m4 = m5;
                } else {
                    referenceEntry.o(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.f26496a;
                    referenceEntry2.c(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (((ReferenceEntry) obj).m() != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f26496a.m() == this.f26496a) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                @CheckForNull
                /* renamed from: b */
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> m4 = referenceEntry.m();
                    if (m4 == AccessQueue.this.f26496a) {
                        return null;
                    }
                    return m4;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        @CanIgnoreReturnValue
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> j4 = referenceEntry.j();
            ReferenceEntry<K, V> m4 = referenceEntry.m();
            LocalCache.d(j4, m4);
            LocalCache.y(referenceEntry);
            if (m4 != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i4 = 0;
            for (ReferenceEntry<K, V> m4 = this.f26496a.m(); m4 != this.f26496a; m4 = m4.m()) {
                i4++;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k4, i4, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
                ReferenceEntry<K, V> c4 = super.c(segment, referenceEntry, referenceEntry2, k4);
                b(referenceEntry, c4);
                return c4;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k4, i4, referenceEntry);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
                ReferenceEntry<K, V> c4 = super.c(segment, referenceEntry, referenceEntry2, k4);
                e(referenceEntry, c4);
                return c4;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k4, i4, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
                ReferenceEntry<K, V> c4 = super.c(segment, referenceEntry, referenceEntry2, k4);
                b(referenceEntry, c4);
                e(referenceEntry, c4);
                return c4;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k4, i4, referenceEntry);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k4, i4, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
                ReferenceEntry<K, V> c4 = super.c(segment, referenceEntry, referenceEntry2, k4);
                b(referenceEntry, c4);
                return c4;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, k4, i4, referenceEntry);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
                ReferenceEntry<K, V> c4 = super.c(segment, referenceEntry, referenceEntry2, k4);
                e(referenceEntry, c4);
                return c4;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, k4, i4, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
                ReferenceEntry<K, V> c4 = super.c(segment, referenceEntry, referenceEntry2, k4);
                b(referenceEntry, c4);
                e(referenceEntry, c4);
                return c4;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, k4, i4, referenceEntry);
            }
        };
        

        /* renamed from: i  reason: collision with root package name */
        static final EntryFactory[] f26508i;

        static {
            EntryFactory entryFactory;
            EntryFactory entryFactory2;
            EntryFactory entryFactory3;
            EntryFactory entryFactory4;
            EntryFactory entryFactory5;
            EntryFactory entryFactory6;
            EntryFactory entryFactory7;
            EntryFactory entryFactory8;
            f26508i = new EntryFactory[]{entryFactory, entryFactory2, entryFactory3, entryFactory4, entryFactory5, entryFactory6, entryFactory7, entryFactory8};
        }

        static EntryFactory f(Strength strength, boolean z3, boolean z4) {
            int i4;
            int i5 = 0;
            if (strength == Strength.WEAK) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            int i6 = i4 | (z3 ? 1 : 0);
            if (z4) {
                i5 = 2;
            }
            return f26508i[i6 | i5];
        }

        <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.h(referenceEntry.n());
            LocalCache.d(referenceEntry.j(), referenceEntry2);
            LocalCache.d(referenceEntry2, referenceEntry.m());
            LocalCache.y(referenceEntry);
        }

        <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k4) {
            return g(segment, k4, referenceEntry.b(), referenceEntry2);
        }

        <K, V> void e(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.i(referenceEntry.g());
            LocalCache.e(referenceEntry.e(), referenceEntry2);
            LocalCache.e(referenceEntry2, referenceEntry.l());
            LocalCache.z(referenceEntry);
        }

        abstract <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry);
    }

    /* loaded from: classes5.dex */
    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: classes5.dex */
    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = LocalCache.this.get(key)) == null || !LocalCache.this.f26478f.equivalent(entry.getValue(), obj2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !LocalCache.this.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public abstract class HashIterator<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f26511a;

        /* renamed from: b  reason: collision with root package name */
        int f26512b = -1;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Segment<K, V> f26513c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        AtomicReferenceArray<ReferenceEntry<K, V>> f26514d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        ReferenceEntry<K, V> f26515e;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        LocalCache<K, V>.WriteThroughEntry f26516f;
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        LocalCache<K, V>.WriteThroughEntry f26517g;

        HashIterator() {
            this.f26511a = LocalCache.this.f26475c.length - 1;
            a();
        }

        final void a() {
            this.f26516f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i4 = this.f26511a;
                if (i4 >= 0) {
                    Segment<K, V>[] segmentArr = LocalCache.this.f26475c;
                    this.f26511a = i4 - 1;
                    Segment<K, V> segment = segmentArr[i4];
                    this.f26513c = segment;
                    if (segment.count != 0) {
                        AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f26513c.table;
                        this.f26514d = atomicReferenceArray;
                        this.f26512b = atomicReferenceArray.length() - 1;
                        if (e()) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        boolean b(ReferenceEntry<K, V> referenceEntry) {
            try {
                long read = LocalCache.this.f26488p.read();
                K key = referenceEntry.getKey();
                Object p4 = LocalCache.this.p(referenceEntry, read);
                if (p4 != null) {
                    this.f26516f = new WriteThroughEntry(key, p4);
                    this.f26513c.I();
                    return true;
                }
                this.f26513c.I();
                return false;
            } catch (Throwable th) {
                this.f26513c.I();
                throw th;
            }
        }

        LocalCache<K, V>.WriteThroughEntry c() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.f26516f;
            if (writeThroughEntry != null) {
                this.f26517g = writeThroughEntry;
                a();
                return this.f26517g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            ReferenceEntry<K, V> referenceEntry = this.f26515e;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.f26515e = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.f26515e;
                if (referenceEntry2 != null) {
                    if (b(referenceEntry2)) {
                        return true;
                    }
                    referenceEntry = this.f26515e;
                } else {
                    return false;
                }
            }
        }

        boolean e() {
            while (true) {
                int i4 = this.f26512b;
                if (i4 >= 0) {
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f26514d;
                    this.f26512b = i4 - 1;
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i4);
                    this.f26515e = referenceEntry;
                    if (referenceEntry != null && (b(referenceEntry) || d())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f26516f != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            if (this.f26517g != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            LocalCache.this.remove(this.f26517g.getKey());
            this.f26517g = null;
        }
    }

    /* loaded from: classes5.dex */
    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes5.dex */
    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (LocalCache.this.remove(obj) != null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        transient LoadingCache<K, V> f26520b;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f26520b = (LoadingCache<K, V>) g().build((CacheLoader<? super K, V>) this.loader);
        }

        private Object readResolve() {
            return this.f26520b;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public V apply(K k4) {
            return this.f26520b.apply(k4);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k4) throws ExecutionException {
            return this.f26520b.get(k4);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.f26520b.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k4) {
            return this.f26520b.getUnchecked(k4);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k4) {
            this.f26520b.refresh(k4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class LoadingValueReference<K, V> implements ValueReference<K, V> {

        /* renamed from: a  reason: collision with root package name */
        volatile ValueReference<K, V> f26521a;

        /* renamed from: b  reason: collision with root package name */
        final SettableFuture<V> f26522b;

        /* renamed from: c  reason: collision with root package name */
        final Stopwatch f26523c;

        public LoadingValueReference() {
            this(LocalCache.L());
        }

        private ListenableFuture<V> g(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object i(Object obj) {
            k(obj);
            return obj;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(@CheckForNull V v3) {
            if (v3 != null) {
                k(v3);
            } else {
                this.f26521a = LocalCache.L();
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V b() throws ExecutionException {
            return (V) Uninterruptibles.getUninterruptibly(this.f26522b);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean c() {
            return true;
        }

        public long f() {
            return this.f26523c.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.f26521a.get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.f26521a.getWeight();
        }

        public ValueReference<K, V> h() {
            return this.f26521a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.f26521a.isActive();
        }

        public ListenableFuture<V> j(K k4, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> g4;
            try {
                this.f26523c.start();
                V v3 = this.f26521a.get();
                if (v3 == null) {
                    V load = cacheLoader.load(k4);
                    if (k(load)) {
                        return this.f26522b;
                    }
                    return Futures.immediateFuture(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k4, v3);
                if (reload == null) {
                    return Futures.immediateFuture(null);
                }
                return Futures.transform(reload, new Function() { // from class: com.google.common.cache.c
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        Object i4;
                        i4 = LocalCache.LoadingValueReference.this.i(obj);
                        return i4;
                    }
                }, MoreExecutors.directExecutor());
            } catch (Throwable th) {
                if (l(th)) {
                    g4 = this.f26522b;
                } else {
                    g4 = g(th);
                }
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return g4;
            }
        }

        @CanIgnoreReturnValue
        public boolean k(@CheckForNull V v3) {
            return this.f26522b.set(v3);
        }

        @CanIgnoreReturnValue
        public boolean l(Throwable th) {
            return this.f26522b.setException(th);
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.f26522b = SettableFuture.create();
            this.f26523c = Stopwatch.createUnstarted();
            this.f26521a = valueReference;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, @CheckForNull V v3, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k4) {
            return getUnchecked(k4);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k4) throws ExecutionException {
            return this.localCache.q(k4);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.m(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        @CanIgnoreReturnValue
        public V getUnchecked(K k4) {
            try {
                return get(k4);
            } catch (ExecutionException e4) {
                throw new UncheckedExecutionException(e4.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k4) {
            this.localCache.G(k4);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.c();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k4, final Callable<? extends V> callable) throws ExecutionException {
            Preconditions.checkNotNull(callable);
            return this.localCache.l(k4, new CacheLoader<Object, V>(this) { // from class: com.google.common.cache.LocalCache.LocalManualCache.1
                @Override // com.google.common.cache.CacheLoader
                public V load(Object obj) throws Exception {
                    return (V) callable.call();
                }
            });
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.n(iterable);
        }

        @Override // com.google.common.cache.Cache
        @CheckForNull
        public V getIfPresent(Object obj) {
            return this.localCache.o(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.s(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k4, V v3) {
            this.localCache.put(k4, v3);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.v();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.localCache.f26490r);
            for (Segment<K, V> segment : this.localCache.f26475c) {
                simpleStatsCounter.incrementBy(segment.statsCounter);
            }
            return simpleStatsCounter.snapshot();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    /* loaded from: classes5.dex */
    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        transient Cache<K, V> f26525a;
        final int concurrencyLevel;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        @CheckForNull
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.f26479g, localCache.f26480h, localCache.f26477e, localCache.f26478f, localCache.f26484l, localCache.f26483k, localCache.f26481i, localCache.f26482j, localCache.f26476d, localCache.f26487o, localCache.f26488p, localCache.f26491s);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f26525a = (Cache<K, V>) g().build();
        }

        private Object readResolve() {
            return this.f26525a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* renamed from: f */
        public Cache<K, V> e() {
            return this.f26525a;
        }

        CacheBuilder<K, V> g() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.newBuilder().u(this.keyStrength).v(this.valueStrength).r(this.keyEquivalence).w(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener((RemovalListener<? super K, ? super V>) this.removalListener);
            cacheBuilder.f26420a = false;
            long j4 = this.expireAfterWriteNanos;
            if (j4 > 0) {
                cacheBuilder.expireAfterWrite(j4, TimeUnit.NANOSECONDS);
            }
            long j5 = this.expireAfterAccessNanos;
            if (j5 > 0) {
                cacheBuilder.expireAfterAccess(j5, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.weigher;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.weigher(weigher);
                long j6 = this.maxWeight;
                if (j6 != -1) {
                    cacheBuilder.maximumWeight(j6);
                }
            } else {
                long j7 = this.maxWeight;
                if (j7 != -1) {
                    cacheBuilder.maximumSize(j7);
                }
            }
            Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilder.ticker(ticker);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j4, long j5, long j6, Weigher<K, V> weigher, int i4, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j4;
            this.expireAfterAccessNanos = j5;
            this.maxWeight = j6;
            this.weigher = weigher;
            this.concurrencyLevel = i4;
            this.removalListener = removalListener;
            this.ticker = (ticker == Ticker.systemTicker() || ticker == CacheBuilder.f26418t) ? null : null;
            this.loader = cacheLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Segment<K, V> extends ReentrantLock {
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        @CheckForNull
        final ReferenceQueue<K> keyReferenceQueue;
        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        @CheckForNull
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        @GuardedBy("this")
        long totalWeight;
        @CheckForNull
        final ReferenceQueue<V> valueReferenceQueue;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i4, long j4, AbstractCache.StatsCounter statsCounter) {
            ReferenceQueue<K> referenceQueue;
            Queue<ReferenceEntry<K, V>> h4;
            Queue<ReferenceEntry<K, V>> h5;
            Queue<ReferenceEntry<K, V>> h6;
            this.map = localCache;
            this.maxSegmentWeight = j4;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            A(H(i4));
            if (localCache.O()) {
                referenceQueue = new ReferenceQueue<>();
            } else {
                referenceQueue = null;
            }
            this.keyReferenceQueue = referenceQueue;
            this.valueReferenceQueue = localCache.P() ? new ReferenceQueue<>() : null;
            if (localCache.N()) {
                h4 = new ConcurrentLinkedQueue<>();
            } else {
                h4 = LocalCache.h();
            }
            this.recencyQueue = h4;
            if (localCache.R()) {
                h5 = new WriteQueue<>();
            } else {
                h5 = LocalCache.h();
            }
            this.writeQueue = h5;
            if (localCache.N()) {
                h6 = new AccessQueue<>();
            } else {
                h6 = LocalCache.h();
            }
            this.accessQueue = h6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void C(Object obj, int i4, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
            try {
                u(obj, i4, loadingValueReference, listenableFuture);
            } catch (Throwable th) {
                LocalCache.f26470w.log(Level.WARNING, "Exception thrown during refresh", th);
                loadingValueReference.l(th);
            }
        }

        void A(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.g()) {
                int i4 = this.threshold;
                if (i4 == this.maxSegmentWeight) {
                    this.threshold = i4 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        @CheckForNull
        LoadingValueReference<K, V> B(K k4, int i4, boolean z3) {
            lock();
            try {
                long read = this.map.f26488p.read();
                K(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.b() == i4 && key != null && this.map.f26477e.equivalent(k4, key)) {
                        ValueReference<K, V> a4 = referenceEntry2.a();
                        if (!a4.c() && (!z3 || read - referenceEntry2.g() >= this.map.f26485m)) {
                            this.modCount++;
                            LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(a4);
                            referenceEntry2.f(loadingValueReference);
                            return loadingValueReference;
                        }
                        unlock();
                        J();
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry<K, V> G = G(k4, i4, referenceEntry);
                G.f(loadingValueReference2);
                atomicReferenceArray.set(length, G);
                return loadingValueReference2;
            } finally {
                unlock();
                J();
            }
        }

        ListenableFuture<V> D(final K k4, final int i4, final LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            final ListenableFuture<V> j4 = loadingValueReference.j(k4, cacheLoader);
            j4.addListener(new Runnable() { // from class: com.google.common.cache.d
                @Override // java.lang.Runnable
                public final void run() {
                    LocalCache.Segment.this.C(k4, i4, loadingValueReference, j4);
                }
            }, MoreExecutors.directExecutor());
            return j4;
        }

        V E(K k4, int i4, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return u(k4, i4, loadingValueReference, loadingValueReference.j(k4, cacheLoader));
        }

        V F(K k4, int i4, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            LoadingValueReference<K, V> loadingValueReference;
            ValueReference<K, V> valueReference;
            boolean z3;
            V E;
            lock();
            try {
                long read = this.map.f26488p.read();
                K(read);
                int i5 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i4 & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 != null) {
                        K key = referenceEntry2.getKey();
                        if (referenceEntry2.b() == i4 && key != null && this.map.f26477e.equivalent(k4, key)) {
                            ValueReference<K, V> a4 = referenceEntry2.a();
                            if (a4.c()) {
                                z3 = false;
                                valueReference = a4;
                            } else {
                                V v3 = a4.get();
                                if (v3 == null) {
                                    o(key, i4, v3, a4.getWeight(), RemovalCause.COLLECTED);
                                } else if (this.map.t(referenceEntry2, read)) {
                                    o(key, i4, v3, a4.getWeight(), RemovalCause.EXPIRED);
                                } else {
                                    O(referenceEntry2, read);
                                    this.statsCounter.recordHits(1);
                                    return v3;
                                }
                                this.writeQueue.remove(referenceEntry2);
                                this.accessQueue.remove(referenceEntry2);
                                this.count = i5;
                                valueReference = a4;
                            }
                        } else {
                            referenceEntry2 = referenceEntry2.getNext();
                        }
                    } else {
                        valueReference = null;
                        break;
                    }
                }
                z3 = true;
                if (z3) {
                    loadingValueReference = new LoadingValueReference<>();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = G(k4, i4, referenceEntry);
                        referenceEntry2.f(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.f(loadingValueReference);
                    }
                }
                if (z3) {
                    try {
                        synchronized (referenceEntry2) {
                            E = E(k4, i4, loadingValueReference, cacheLoader);
                        }
                        return E;
                    } finally {
                        this.statsCounter.recordMisses(1);
                    }
                }
                return i0(referenceEntry2, k4, valueReference);
            } finally {
                unlock();
                J();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        ReferenceEntry<K, V> G(K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            return this.map.f26489q.g(this, Preconditions.checkNotNull(k4), i4, referenceEntry);
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> H(int i4) {
            return new AtomicReferenceArray<>(i4);
        }

        void I() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                b();
            }
        }

        void J() {
            c0();
        }

        @GuardedBy("this")
        void K(long j4) {
            b0(j4);
        }

        @CanIgnoreReturnValue
        @CheckForNull
        V L(K k4, int i4, V v3, boolean z3) {
            int i5;
            lock();
            try {
                long read = this.map.f26488p.read();
                K(read);
                if (this.count + 1 > this.threshold) {
                    q();
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i4 & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 != null) {
                        K key = referenceEntry2.getKey();
                        if (referenceEntry2.b() == i4 && key != null && this.map.f26477e.equivalent(k4, key)) {
                            ValueReference<K, V> a4 = referenceEntry2.a();
                            V v4 = a4.get();
                            if (v4 == null) {
                                this.modCount++;
                                if (a4.isActive()) {
                                    o(k4, i4, v4, a4.getWeight(), RemovalCause.COLLECTED);
                                    e0(referenceEntry2, k4, v3, read);
                                    i5 = this.count;
                                } else {
                                    e0(referenceEntry2, k4, v3, read);
                                    i5 = this.count + 1;
                                }
                                this.count = i5;
                                p(referenceEntry2);
                            } else {
                                if (z3) {
                                    O(referenceEntry2, read);
                                } else {
                                    this.modCount++;
                                    o(k4, i4, v4, a4.getWeight(), RemovalCause.REPLACED);
                                    e0(referenceEntry2, k4, v3, read);
                                    p(referenceEntry2);
                                }
                                return v4;
                            }
                        } else {
                            referenceEntry2 = referenceEntry2.getNext();
                        }
                    } else {
                        this.modCount++;
                        ReferenceEntry<K, V> G = G(k4, i4, referenceEntry);
                        e0(G, k4, v3, read);
                        atomicReferenceArray.set(length, G);
                        this.count++;
                        p(G);
                        break;
                    }
                }
                return null;
            } finally {
                unlock();
                J();
            }
        }

        @CanIgnoreReturnValue
        boolean M(ReferenceEntry<K, V> referenceEntry, int i4) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        atomicReferenceArray.set(length, Y(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i4, referenceEntry3.a().get(), referenceEntry3.a(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                J();
                return false;
            } finally {
                unlock();
                J();
            }
        }

        @CanIgnoreReturnValue
        boolean N(K k4, int i4, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.b() == i4 && key != null && this.map.f26477e.equivalent(k4, key)) {
                        if (referenceEntry2.a() == valueReference) {
                            this.modCount++;
                            atomicReferenceArray.set(length, Y(referenceEntry, referenceEntry2, key, i4, valueReference.get(), valueReference, RemovalCause.COLLECTED));
                            this.count--;
                            return true;
                        }
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            J();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    J();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    J();
                }
            }
        }

        @GuardedBy("this")
        void O(ReferenceEntry<K, V> referenceEntry, long j4) {
            if (this.map.D()) {
                referenceEntry.h(j4);
            }
            this.accessQueue.add(referenceEntry);
        }

        void P(ReferenceEntry<K, V> referenceEntry, long j4) {
            if (this.map.D()) {
                referenceEntry.h(j4);
            }
            this.recencyQueue.add(referenceEntry);
        }

        @GuardedBy("this")
        void Q(ReferenceEntry<K, V> referenceEntry, int i4, long j4) {
            l();
            this.totalWeight += i4;
            if (this.map.D()) {
                referenceEntry.h(j4);
            }
            if (this.map.F()) {
                referenceEntry.i(j4);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        @CanIgnoreReturnValue
        @CheckForNull
        V R(K k4, int i4, CacheLoader<? super K, V> cacheLoader, boolean z3) {
            LoadingValueReference<K, V> B = B(k4, i4, z3);
            if (B == null) {
                return null;
            }
            ListenableFuture<V> D = D(k4, i4, B, cacheLoader);
            if (D.isDone()) {
                try {
                    return (V) Uninterruptibles.getUninterruptibly(D);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            r9 = r5.a();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
            if (r12 == null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
            if (r9.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
            r11.modCount++;
            r0.set(r1, Y(r4, r5, r6, r13, r12, r9, r10));
            r11.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
            return r12;
         */
        @javax.annotation.CheckForNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V S(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch: java.lang.Throwable -> L78
                com.google.common.base.Ticker r0 = r0.f26488p     // Catch: java.lang.Throwable -> L78
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L78
                r11.K(r0)     // Catch: java.lang.Throwable -> L78
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r11.table     // Catch: java.lang.Throwable -> L78
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L78
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
                r4 = r2
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L78
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6c
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L78
                int r3 = r5.b()     // Catch: java.lang.Throwable -> L78
                if (r3 != r13) goto L73
                if (r6 == 0) goto L73
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch: java.lang.Throwable -> L78
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.f26477e     // Catch: java.lang.Throwable -> L78
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L73
                com.google.common.cache.LocalCache$ValueReference r9 = r5.a()     // Catch: java.lang.Throwable -> L78
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L78
                if (r12 == 0) goto L46
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L78
            L44:
                r10 = r2
                goto L4f
            L46:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L6c
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L78
                goto L44
            L4f:
                int r2 = r11.modCount     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + 1
                r11.modCount = r2     // Catch: java.lang.Throwable -> L78
                r3 = r11
                r7 = r13
                r8 = r12
                com.google.common.cache.ReferenceEntry r13 = r3.Y(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L78
                int r2 = r11.count     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L78
                r11.count = r2     // Catch: java.lang.Throwable -> L78
                r11.unlock()
                r11.J()
                return r12
            L6c:
                r11.unlock()
                r11.J()
                return r2
            L73:
                com.google.common.cache.ReferenceEntry r5 = r5.getNext()     // Catch: java.lang.Throwable -> L78
                goto L1f
            L78:
                r12 = move-exception
                r11.unlock()
                r11.J()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.S(java.lang.Object, int):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            r10 = r6.a();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
            if (r12.map.f26478f.equivalent(r15, r9) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
            if (r9 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
            if (r10.isActive() == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
            r12.modCount++;
            r0.set(r1, Y(r5, r6, r7, r14, r9, r10, r13));
            r12.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean T(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Ticker r0 = r0.f26488p     // Catch: java.lang.Throwable -> L84
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L84
                r12.K(r0)     // Catch: java.lang.Throwable -> L84
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.table     // Catch: java.lang.Throwable -> L84
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L84
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L84
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch: java.lang.Throwable -> L84
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L78
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L84
                int r4 = r6.b()     // Catch: java.lang.Throwable -> L84
                if (r4 != r14) goto L7f
                if (r7 == 0) goto L7f
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.f26477e     // Catch: java.lang.Throwable -> L84
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L84
                if (r4 == 0) goto L7f
                com.google.common.cache.LocalCache$ValueReference r10 = r6.a()     // Catch: java.lang.Throwable -> L84
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.f26478f     // Catch: java.lang.Throwable -> L84
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L4d
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                goto L57
            L4d:
                if (r9 != 0) goto L78
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L78
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L84
            L57:
                int r15 = r12.modCount     // Catch: java.lang.Throwable -> L84
                int r15 = r15 + r2
                r12.modCount = r15     // Catch: java.lang.Throwable -> L84
                r4 = r12
                r8 = r14
                r11 = r13
                com.google.common.cache.ReferenceEntry r14 = r4.Y(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L84
                int r15 = r12.count     // Catch: java.lang.Throwable -> L84
                int r15 = r15 - r2
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L84
                r12.count = r15     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.RemovalCause r14 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                if (r13 != r14) goto L70
                goto L71
            L70:
                r2 = 0
            L71:
                r12.unlock()
                r12.J()
                return r2
            L78:
                r12.unlock()
                r12.J()
                return r3
            L7f:
                com.google.common.cache.ReferenceEntry r6 = r6.getNext()     // Catch: java.lang.Throwable -> L84
                goto L1f
            L84:
                r13 = move-exception
                r12.unlock()
                r12.J()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.T(java.lang.Object, int, java.lang.Object):boolean");
        }

        @GuardedBy("this")
        void U(ReferenceEntry<K, V> referenceEntry) {
            o(referenceEntry.getKey(), referenceEntry.b(), referenceEntry.a().get(), referenceEntry.a().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        @VisibleForTesting
        @CanIgnoreReturnValue
        @GuardedBy("this")
        boolean V(ReferenceEntry<K, V> referenceEntry, int i4, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i4;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    atomicReferenceArray.set(length, Y(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i4, referenceEntry3.a().get(), referenceEntry3.a(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        @CheckForNull
        @GuardedBy("this")
        ReferenceEntry<K, V> W(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i4 = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> i5 = i(referenceEntry, next);
                if (i5 != null) {
                    next = i5;
                } else {
                    U(referenceEntry);
                    i4--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i4;
            return next;
        }

        @CanIgnoreReturnValue
        boolean X(K k4, int i4, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.b() == i4 && key != null && this.map.f26477e.equivalent(k4, key)) {
                        if (referenceEntry2.a() == loadingValueReference) {
                            if (loadingValueReference.isActive()) {
                                referenceEntry2.f(loadingValueReference.h());
                            } else {
                                atomicReferenceArray.set(length, W(referenceEntry, referenceEntry2));
                            }
                            return true;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                return false;
            } finally {
                unlock();
                J();
            }
        }

        @CheckForNull
        @GuardedBy("this")
        ReferenceEntry<K, V> Y(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @CheckForNull K k4, int i4, V v3, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            o(k4, i4, v3, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (valueReference.c()) {
                valueReference.a(null);
                return referenceEntry;
            }
            return W(referenceEntry, referenceEntry2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
            return null;
         */
        @javax.annotation.CheckForNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V Z(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La7
                com.google.common.base.Ticker r1 = r1.f26488p     // Catch: java.lang.Throwable -> La7
                long r7 = r1.read()     // Catch: java.lang.Throwable -> La7
                r9.K(r7)     // Catch: java.lang.Throwable -> La7
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> La7
                int r1 = r10.length()     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> La7
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> La7
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6c
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> La7
                int r1 = r12.b()     // Catch: java.lang.Throwable -> La7
                if (r1 != r0) goto L9f
                if (r4 == 0) goto L9f
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La7
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f26477e     // Catch: java.lang.Throwable -> La7
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto La1
                com.google.common.cache.LocalCache$ValueReference r15 = r12.a()     // Catch: java.lang.Throwable -> La7
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> La7
                if (r16 != 0) goto L73
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto L6c
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.ReferenceEntry r0 = r1.Y(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La7
                int r1 = r9.count     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> La7
                r9.count = r1     // Catch: java.lang.Throwable -> La7
            L6c:
                r17.unlock()
                r17.J()
                return r13
            L73:
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La7
                int r5 = r15.getWeight()     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.o(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.e0(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La7
                r9.p(r12)     // Catch: java.lang.Throwable -> La7
                r17.unlock()
                r17.J()
                return r16
            L9f:
                r14 = r18
            La1:
                com.google.common.cache.ReferenceEntry r12 = r12.getNext()     // Catch: java.lang.Throwable -> La7
                goto L24
            La7:
                r0 = move-exception
                r17.unlock()
                r17.J()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.Z(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean a0(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Ticker r1 = r1.f26488p     // Catch: java.lang.Throwable -> Lb5
                long r7 = r1.read()     // Catch: java.lang.Throwable -> Lb5
                r9.K(r7)     // Catch: java.lang.Throwable -> Lb5
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> Lb5
                int r1 = r10.length()     // Catch: java.lang.Throwable -> Lb5
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch: java.lang.Throwable -> Lb5
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> Lb5
                r13 = r2
            L24:
                r14 = 0
                if (r13 == 0) goto L69
                java.lang.Object r4 = r13.getKey()     // Catch: java.lang.Throwable -> Lb5
                int r1 = r13.b()     // Catch: java.lang.Throwable -> Lb5
                if (r1 != r0) goto Lab
                if (r4 == 0) goto Lab
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f26477e     // Catch: java.lang.Throwable -> Lb5
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto Lad
                com.google.common.cache.LocalCache$ValueReference r16 = r13.a()     // Catch: java.lang.Throwable -> Lb5
                java.lang.Object r6 = r16.get()     // Catch: java.lang.Throwable -> Lb5
                if (r6 != 0) goto L70
                boolean r1 = r16.isActive()     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto L69
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.ReferenceEntry r0 = r1.Y(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb5
                int r1 = r9.count     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch: java.lang.Throwable -> Lb5
                r9.count = r1     // Catch: java.lang.Throwable -> Lb5
            L69:
                r17.unlock()
                r17.J()
                return r14
            L70:
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f26478f     // Catch: java.lang.Throwable -> Lb5
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto La7
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb5
                int r5 = r16.getWeight()     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.o(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.e0(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb5
                r9.p(r13)     // Catch: java.lang.Throwable -> Lb5
                r17.unlock()
                r17.J()
                return r11
            La7:
                r9.O(r13, r7)     // Catch: java.lang.Throwable -> Lb5
                goto L69
            Lab:
                r15 = r18
            Lad:
                r3 = r20
                com.google.common.cache.ReferenceEntry r13 = r13.getNext()     // Catch: java.lang.Throwable -> Lb5
                goto L24
            Lb5:
                r0 = move-exception
                r17.unlock()
                r17.J()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.a0(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        void b() {
            b0(this.map.f26488p.read());
            c0();
        }

        void b0(long j4) {
            if (tryLock()) {
                try {
                    m();
                    r(j4);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void c() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    K(this.map.f26488p.read());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i4); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.a().isActive()) {
                                K key = referenceEntry.getKey();
                                V v3 = referenceEntry.a().get();
                                if (key != null && v3 != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    o(key, referenceEntry.b(), v3, referenceEntry.a().getWeight(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                o(key, referenceEntry.b(), v3, referenceEntry.a().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                        atomicReferenceArray.set(i5, null);
                    }
                    f();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    J();
                }
            }
        }

        void c0() {
            if (!isHeldByCurrentThread()) {
                this.map.A();
            }
        }

        V d0(ReferenceEntry<K, V> referenceEntry, K k4, int i4, V v3, long j4, CacheLoader<? super K, V> cacheLoader) {
            V R;
            if (this.map.H() && j4 - referenceEntry.g() > this.map.f26485m && !referenceEntry.a().c() && (R = R(k4, i4, cacheLoader, true)) != null) {
                return R;
            }
            return v3;
        }

        void e() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        @GuardedBy("this")
        void e0(ReferenceEntry<K, V> referenceEntry, K k4, V v3, long j4) {
            boolean z3;
            ValueReference<K, V> a4 = referenceEntry.a();
            int weigh = this.map.f26482j.weigh(k4, v3);
            if (weigh >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Weights must be non-negative");
            referenceEntry.f(this.map.f26480h.c(this, referenceEntry, v3, weigh));
            Q(referenceEntry, weigh, j4);
            a4.a(v3);
        }

        void f() {
            if (this.map.O()) {
                e();
            }
            if (this.map.P()) {
                g();
            }
        }

        @CanIgnoreReturnValue
        boolean f0(K k4, int i4, LoadingValueReference<K, V> loadingValueReference, V v3) {
            RemovalCause removalCause;
            lock();
            try {
                long read = this.map.f26488p.read();
                K(read);
                int i5 = this.count + 1;
                if (i5 > this.threshold) {
                    q();
                    i5 = this.count + 1;
                }
                int i6 = i5;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i4 & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 != null) {
                        K key = referenceEntry2.getKey();
                        if (referenceEntry2.b() == i4 && key != null && this.map.f26477e.equivalent(k4, key)) {
                            ValueReference<K, V> a4 = referenceEntry2.a();
                            V v4 = a4.get();
                            if (loadingValueReference != a4 && (v4 != null || a4 == LocalCache.f26471x)) {
                                o(k4, i4, v3, 0, RemovalCause.REPLACED);
                                unlock();
                                J();
                                return false;
                            }
                            this.modCount++;
                            if (loadingValueReference.isActive()) {
                                if (v4 == null) {
                                    removalCause = RemovalCause.COLLECTED;
                                } else {
                                    removalCause = RemovalCause.REPLACED;
                                }
                                o(k4, i4, v4, loadingValueReference.getWeight(), removalCause);
                                i6--;
                            }
                            e0(referenceEntry2, k4, v3, read);
                            this.count = i6;
                            p(referenceEntry2);
                        } else {
                            referenceEntry2 = referenceEntry2.getNext();
                        }
                    } else {
                        this.modCount++;
                        ReferenceEntry<K, V> G = G(k4, i4, referenceEntry);
                        e0(G, k4, v3, read);
                        atomicReferenceArray.set(length, G);
                        this.count = i6;
                        p(G);
                        break;
                    }
                }
                return true;
            } finally {
                unlock();
                J();
            }
        }

        void g() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        void g0() {
            if (tryLock()) {
                try {
                    m();
                } finally {
                    unlock();
                }
            }
        }

        boolean h(Object obj, int i4) {
            try {
                boolean z3 = false;
                if (this.count == 0) {
                    return false;
                }
                ReferenceEntry<K, V> x3 = x(obj, i4, this.map.f26488p.read());
                if (x3 == null) {
                    return false;
                }
                if (x3.a().get() != null) {
                    z3 = true;
                }
                return z3;
            } finally {
                I();
            }
        }

        void h0(long j4) {
            if (tryLock()) {
                try {
                    r(j4);
                } finally {
                    unlock();
                }
            }
        }

        @CheckForNull
        @GuardedBy("this")
        ReferenceEntry<K, V> i(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            K key = referenceEntry.getKey();
            if (key == null) {
                return null;
            }
            ValueReference<K, V> a4 = referenceEntry.a();
            V v3 = a4.get();
            if (v3 == null && a4.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> c4 = this.map.f26489q.c(this, referenceEntry, referenceEntry2, key);
            c4.f(a4.d(this.valueReferenceQueue, v3, c4));
            return c4;
        }

        V i0(ReferenceEntry<K, V> referenceEntry, K k4, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.c()) {
                Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k4);
                try {
                    V b4 = valueReference.b();
                    if (b4 != null) {
                        P(referenceEntry, this.map.f26488p.read());
                        return b4;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k4 + ".");
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            }
            throw new AssertionError();
        }

        @GuardedBy("this")
        void j() {
            int i4 = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.B((ReferenceEntry) poll);
                    i4++;
                } else {
                    return;
                }
            } while (i4 != 16);
        }

        @GuardedBy("this")
        void l() {
            while (true) {
                ReferenceEntry<K, V> poll = this.recencyQueue.poll();
                if (poll != null) {
                    if (this.accessQueue.contains(poll)) {
                        this.accessQueue.add(poll);
                    }
                } else {
                    return;
                }
            }
        }

        @GuardedBy("this")
        void m() {
            if (this.map.O()) {
                j();
            }
            if (this.map.P()) {
                n();
            }
        }

        @GuardedBy("this")
        void n() {
            int i4 = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.C((ValueReference) poll);
                    i4++;
                } else {
                    return;
                }
            } while (i4 != 16);
        }

        @GuardedBy("this")
        void o(@CheckForNull K k4, int i4, @CheckForNull V v3, int i5, RemovalCause removalCause) {
            this.totalWeight -= i5;
            if (removalCause.b()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.f26486n != LocalCache.f26472y) {
                this.map.f26486n.offer(RemovalNotification.create(k4, v3, removalCause));
            }
        }

        @GuardedBy("this")
        void p(ReferenceEntry<K, V> referenceEntry) {
            if (!this.map.i()) {
                return;
            }
            l();
            if (referenceEntry.a().getWeight() > this.maxSegmentWeight && !V(referenceEntry, referenceEntry.b(), RemovalCause.SIZE)) {
                throw new AssertionError();
            }
            while (this.totalWeight > this.maxSegmentWeight) {
                ReferenceEntry<K, V> z3 = z();
                if (!V(z3, z3.b(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
            }
        }

        @GuardedBy("this")
        void q() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i4 = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> H = H(length << 1);
            this.threshold = (H.length() * 3) / 4;
            int length2 = H.length() - 1;
            for (int i5 = 0; i5 < length; i5++) {
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i5);
                if (referenceEntry != null) {
                    ReferenceEntry<K, V> next = referenceEntry.getNext();
                    int b4 = referenceEntry.b() & length2;
                    if (next == null) {
                        H.set(b4, referenceEntry);
                    } else {
                        ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                        while (next != null) {
                            int b5 = next.b() & length2;
                            if (b5 != b4) {
                                referenceEntry2 = next;
                                b4 = b5;
                            }
                            next = next.getNext();
                        }
                        H.set(b4, referenceEntry2);
                        while (referenceEntry != referenceEntry2) {
                            int b6 = referenceEntry.b() & length2;
                            ReferenceEntry<K, V> i6 = i(referenceEntry, H.get(b6));
                            if (i6 != null) {
                                H.set(b6, i6);
                            } else {
                                U(referenceEntry);
                                i4--;
                            }
                            referenceEntry = referenceEntry.getNext();
                        }
                    }
                }
            }
            this.table = H;
            this.count = i4;
        }

        @GuardedBy("this")
        void r(long j4) {
            ReferenceEntry<K, V> peek;
            ReferenceEntry<K, V> peek2;
            l();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.t(peek, j4)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.t(peek2, j4)) {
                            return;
                        }
                    } while (V(peek2, peek2.b(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (V(peek, peek.b(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        @CheckForNull
        V s(Object obj, int i4) {
            try {
                if (this.count != 0) {
                    long read = this.map.f26488p.read();
                    ReferenceEntry<K, V> x3 = x(obj, i4, read);
                    if (x3 == null) {
                        return null;
                    }
                    V v3 = x3.a().get();
                    if (v3 != null) {
                        P(x3, read);
                        return d0(x3, x3.getKey(), i4, v3, read, this.map.f26491s);
                    }
                    g0();
                }
                return null;
            } finally {
                I();
            }
        }

        @CanIgnoreReturnValue
        V t(K k4, int i4, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            ReferenceEntry<K, V> v3;
            Preconditions.checkNotNull(k4);
            Preconditions.checkNotNull(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (v3 = v(k4, i4)) != null) {
                        long read = this.map.f26488p.read();
                        V y3 = y(v3, read);
                        if (y3 != null) {
                            P(v3, read);
                            this.statsCounter.recordHits(1);
                            return d0(v3, k4, i4, y3, read, cacheLoader);
                        }
                        ValueReference<K, V> a4 = v3.a();
                        if (a4.c()) {
                            return i0(v3, k4, a4);
                        }
                    }
                    return F(k4, i4, cacheLoader);
                } catch (ExecutionException e4) {
                    Throwable cause = e4.getCause();
                    if (!(cause instanceof Error)) {
                        if (cause instanceof RuntimeException) {
                            throw new UncheckedExecutionException(cause);
                        }
                        throw e4;
                    }
                    throw new ExecutionError((Error) cause);
                }
            } finally {
                I();
            }
        }

        @CanIgnoreReturnValue
        V u(K k4, int i4, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v3;
            try {
                v3 = (V) Uninterruptibles.getUninterruptibly(listenableFuture);
                try {
                    if (v3 != null) {
                        this.statsCounter.recordLoadSuccess(loadingValueReference.f());
                        f0(k4, i4, loadingValueReference, v3);
                        return v3;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k4 + ".");
                } catch (Throwable th) {
                    th = th;
                    if (v3 == null) {
                        this.statsCounter.recordLoadException(loadingValueReference.f());
                        X(k4, i4, loadingValueReference);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v3 = null;
            }
        }

        @CheckForNull
        ReferenceEntry<K, V> v(Object obj, int i4) {
            for (ReferenceEntry<K, V> w3 = w(i4); w3 != null; w3 = w3.getNext()) {
                if (w3.b() == i4) {
                    K key = w3.getKey();
                    if (key == null) {
                        g0();
                    } else if (this.map.f26477e.equivalent(obj, key)) {
                        return w3;
                    }
                }
            }
            return null;
        }

        ReferenceEntry<K, V> w(int i4) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i4 & (atomicReferenceArray.length() - 1));
        }

        @CheckForNull
        ReferenceEntry<K, V> x(Object obj, int i4, long j4) {
            ReferenceEntry<K, V> v3 = v(obj, i4);
            if (v3 == null) {
                return null;
            }
            if (this.map.t(v3, j4)) {
                h0(j4);
                return null;
            }
            return v3;
        }

        V y(ReferenceEntry<K, V> referenceEntry, long j4) {
            if (referenceEntry.getKey() == null) {
                g0();
                return null;
            }
            V v3 = referenceEntry.a().get();
            if (v3 == null) {
                g0();
                return null;
            } else if (this.map.t(referenceEntry, j4)) {
                h0(j4);
                return null;
            } else {
                return v3;
            }
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> z() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.a().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> b() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v3, int i4) {
                if (i4 == 1) {
                    return new StrongValueReference(v3);
                }
                return new WeightedStrongValueReference(v3, i4);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> b() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v3, int i4) {
                if (i4 == 1) {
                    return new SoftValueReference(segment.valueReferenceQueue, v3, referenceEntry);
                }
                return new WeightedSoftValueReference(segment.valueReferenceQueue, v3, referenceEntry, i4);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> b() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v3, int i4) {
                if (i4 == 1) {
                    return new WeakValueReference(segment.valueReferenceQueue, v3, referenceEntry);
                }
                return new WeightedWeakValueReference(segment.valueReferenceQueue, v3, referenceEntry, i4);
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> b();

        abstract <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v3, int i4);
    }

    /* loaded from: classes5.dex */
    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        volatile long f26533e;
        @Weak

        /* renamed from: f  reason: collision with root package name */
        ReferenceEntry<K, V> f26534f;
        @Weak

        /* renamed from: g  reason: collision with root package name */
        ReferenceEntry<K, V> f26535g;

        StrongAccessEntry(K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k4, i4, referenceEntry);
            this.f26533e = Long.MAX_VALUE;
            this.f26534f = LocalCache.x();
            this.f26535g = LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void c(ReferenceEntry<K, V> referenceEntry) {
            this.f26535g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void h(long j4) {
            this.f26533e = j4;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> j() {
            return this.f26535g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> m() {
            return this.f26534f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long n() {
            return this.f26533e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.f26534f = referenceEntry;
        }
    }

    /* loaded from: classes5.dex */
    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        volatile long f26536e;
        @Weak

        /* renamed from: f  reason: collision with root package name */
        ReferenceEntry<K, V> f26537f;
        @Weak

        /* renamed from: g  reason: collision with root package name */
        ReferenceEntry<K, V> f26538g;

        /* renamed from: h  reason: collision with root package name */
        volatile long f26539h;
        @Weak

        /* renamed from: i  reason: collision with root package name */
        ReferenceEntry<K, V> f26540i;
        @Weak

        /* renamed from: j  reason: collision with root package name */
        ReferenceEntry<K, V> f26541j;

        StrongAccessWriteEntry(K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k4, i4, referenceEntry);
            this.f26536e = Long.MAX_VALUE;
            this.f26537f = LocalCache.x();
            this.f26538g = LocalCache.x();
            this.f26539h = Long.MAX_VALUE;
            this.f26540i = LocalCache.x();
            this.f26541j = LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void c(ReferenceEntry<K, V> referenceEntry) {
            this.f26538g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> e() {
            return this.f26541j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long g() {
            return this.f26539h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void h(long j4) {
            this.f26536e = j4;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void i(long j4) {
            this.f26539h = j4;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> j() {
            return this.f26538g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> l() {
            return this.f26540i;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> m() {
            return this.f26537f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long n() {
            return this.f26536e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.f26537f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.f26540i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void q(ReferenceEntry<K, V> referenceEntry) {
            this.f26541j = referenceEntry;
        }
    }

    /* loaded from: classes5.dex */
    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f26542a;

        /* renamed from: b  reason: collision with root package name */
        final int f26543b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        final ReferenceEntry<K, V> f26544c;

        /* renamed from: d  reason: collision with root package name */
        volatile ValueReference<K, V> f26545d = LocalCache.L();

        StrongEntry(K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            this.f26542a = k4;
            this.f26543b = i4;
            this.f26544c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> a() {
            return this.f26545d;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int b() {
            return this.f26543b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void f(ValueReference<K, V> valueReference) {
            this.f26545d = valueReference;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.f26542a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.f26544c;
        }
    }

    /* loaded from: classes5.dex */
    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        volatile long f26547e;
        @Weak

        /* renamed from: f  reason: collision with root package name */
        ReferenceEntry<K, V> f26548f;
        @Weak

        /* renamed from: g  reason: collision with root package name */
        ReferenceEntry<K, V> f26549g;

        StrongWriteEntry(K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k4, i4, referenceEntry);
            this.f26547e = Long.MAX_VALUE;
            this.f26548f = LocalCache.x();
            this.f26549g = LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> e() {
            return this.f26549g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long g() {
            return this.f26547e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void i(long j4) {
            this.f26547e = j4;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> l() {
            return this.f26548f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.f26548f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void q(ReferenceEntry<K, V> referenceEntry) {
            this.f26549g = referenceEntry;
        }
    }

    /* loaded from: classes5.dex */
    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface ValueReference<K, V> {
        void a(@CheckForNull V v3);

        V b() throws ExecutionException;

        boolean c();

        ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, @CheckForNull V v3, ReferenceEntry<K, V> referenceEntry);

        @CheckForNull
        V get();

        @CheckForNull
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();
    }

    /* loaded from: classes5.dex */
    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.K(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.K(this).toArray(eArr);
        }
    }

    /* loaded from: classes5.dex */
    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: d  reason: collision with root package name */
        volatile long f26551d;
        @Weak

        /* renamed from: e  reason: collision with root package name */
        ReferenceEntry<K, V> f26552e;
        @Weak

        /* renamed from: f  reason: collision with root package name */
        ReferenceEntry<K, V> f26553f;

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k4, i4, referenceEntry);
            this.f26551d = Long.MAX_VALUE;
            this.f26552e = LocalCache.x();
            this.f26553f = LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void c(ReferenceEntry<K, V> referenceEntry) {
            this.f26553f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void h(long j4) {
            this.f26551d = j4;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> j() {
            return this.f26553f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> m() {
            return this.f26552e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long n() {
            return this.f26551d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.f26552e = referenceEntry;
        }
    }

    /* loaded from: classes5.dex */
    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: d  reason: collision with root package name */
        volatile long f26554d;
        @Weak

        /* renamed from: e  reason: collision with root package name */
        ReferenceEntry<K, V> f26555e;
        @Weak

        /* renamed from: f  reason: collision with root package name */
        ReferenceEntry<K, V> f26556f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f26557g;
        @Weak

        /* renamed from: h  reason: collision with root package name */
        ReferenceEntry<K, V> f26558h;
        @Weak

        /* renamed from: i  reason: collision with root package name */
        ReferenceEntry<K, V> f26559i;

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k4, i4, referenceEntry);
            this.f26554d = Long.MAX_VALUE;
            this.f26555e = LocalCache.x();
            this.f26556f = LocalCache.x();
            this.f26557g = Long.MAX_VALUE;
            this.f26558h = LocalCache.x();
            this.f26559i = LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void c(ReferenceEntry<K, V> referenceEntry) {
            this.f26556f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> e() {
            return this.f26559i;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long g() {
            return this.f26557g;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void h(long j4) {
            this.f26554d = j4;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void i(long j4) {
            this.f26557g = j4;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> j() {
            return this.f26556f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> l() {
            return this.f26558h;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> m() {
            return this.f26555e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long n() {
            return this.f26554d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.f26555e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.f26558h = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void q(ReferenceEntry<K, V> referenceEntry) {
            this.f26559i = referenceEntry;
        }
    }

    /* loaded from: classes5.dex */
    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final int f26560a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        final ReferenceEntry<K, V> f26561b;

        /* renamed from: c  reason: collision with root package name */
        volatile ValueReference<K, V> f26562c;

        WeakEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k4, referenceQueue);
            this.f26562c = LocalCache.L();
            this.f26560a = i4;
            this.f26561b = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> a() {
            return this.f26562c;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int b() {
            return this.f26560a;
        }

        public void c(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> e() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void f(ValueReference<K, V> valueReference) {
            this.f26562c = valueReference;
        }

        public long g() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.f26561b;
        }

        public void h(long j4) {
            throw new UnsupportedOperationException();
        }

        public void i(long j4) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> j() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> l() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> m() {
            throw new UnsupportedOperationException();
        }

        public long n() {
            throw new UnsupportedOperationException();
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void q(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes5.dex */
    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: d  reason: collision with root package name */
        volatile long f26564d;
        @Weak

        /* renamed from: e  reason: collision with root package name */
        ReferenceEntry<K, V> f26565e;
        @Weak

        /* renamed from: f  reason: collision with root package name */
        ReferenceEntry<K, V> f26566f;

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k4, i4, referenceEntry);
            this.f26564d = Long.MAX_VALUE;
            this.f26565e = LocalCache.x();
            this.f26566f = LocalCache.x();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> e() {
            return this.f26566f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long g() {
            return this.f26564d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void i(long j4) {
            this.f26564d = j4;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> l() {
            return this.f26565e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.f26565e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void q(ReferenceEntry<K, V> referenceEntry) {
            this.f26566f = referenceEntry;
        }
    }

    /* loaded from: classes5.dex */
    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f26567b;

        WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry, int i4) {
            super(referenceQueue, v3, referenceEntry);
            this.f26567b = i4;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v3, referenceEntry, this.f26567b);
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.f26567b;
        }
    }

    /* loaded from: classes5.dex */
    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f26568b;

        WeightedStrongValueReference(V v3, int i4) {
            super(v3);
            this.f26568b = i4;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.f26568b;
        }
    }

    /* loaded from: classes5.dex */
    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f26569b;

        WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry, int i4) {
            super(referenceQueue, v3, referenceEntry);
            this.f26569b = i4;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v3, referenceEntry, this.f26569b);
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.f26569b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final ReferenceEntry<K, V> f26570a = new AbstractReferenceEntry<K, V>(this) { // from class: com.google.common.cache.LocalCache.WriteQueue.1
            @Weak

            /* renamed from: a  reason: collision with root package name */
            ReferenceEntry<K, V> f26571a = this;
            @Weak

            /* renamed from: b  reason: collision with root package name */
            ReferenceEntry<K, V> f26572b = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> e() {
                return this.f26572b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long g() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> l() {
                return this.f26571a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void p(ReferenceEntry<K, V> referenceEntry) {
                this.f26571a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void q(ReferenceEntry<K, V> referenceEntry) {
                this.f26572b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void i(long j4) {
            }
        };

        WriteQueue() {
        }

        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.e(referenceEntry.e(), referenceEntry.l());
            LocalCache.e(this.f26570a.e(), referenceEntry);
            LocalCache.e(referenceEntry, this.f26570a);
            return true;
        }

        @Override // java.util.Queue
        @CheckForNull
        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> l4 = this.f26570a.l();
            if (l4 == this.f26570a) {
                return null;
            }
            return l4;
        }

        @Override // java.util.Queue
        @CheckForNull
        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> l4 = this.f26570a.l();
            if (l4 == this.f26570a) {
                return null;
            }
            remove(l4);
            return l4;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> l4 = this.f26570a.l();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.f26570a;
                if (l4 != referenceEntry) {
                    ReferenceEntry<K, V> l5 = l4.l();
                    LocalCache.z(l4);
                    l4 = l5;
                } else {
                    referenceEntry.p(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.f26570a;
                    referenceEntry2.q(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (((ReferenceEntry) obj).l() != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.f26570a.l() == this.f26570a) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                @CheckForNull
                /* renamed from: b */
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> l4 = referenceEntry.l();
                    if (l4 == WriteQueue.this.f26570a) {
                        return null;
                    }
                    return l4;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        @CanIgnoreReturnValue
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> e4 = referenceEntry.e();
            ReferenceEntry<K, V> l4 = referenceEntry.l();
            LocalCache.e(e4, l4);
            LocalCache.z(referenceEntry);
            if (l4 != NullEntry.INSTANCE) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i4 = 0;
            for (ReferenceEntry<K, V> l4 = this.f26570a.l(); l4 != this.f26570a; l4 = l4.l()) {
                i4++;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class WriteThroughEntry implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f26574a;

        /* renamed from: b  reason: collision with root package name */
        V f26575b;

        WriteThroughEntry(K k4, V v3) {
            this.f26574a = k4;
            this.f26575b = v3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f26574a.equals(entry.getKey()) || !this.f26575b.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f26574a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f26575b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f26574a.hashCode() ^ this.f26575b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            V v4 = (V) LocalCache.this.put(this.f26574a, v3);
            this.f26575b = v3;
            return v4;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @CheckForNull CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> concurrentLinkedQueue;
        this.f26476d = Math.min(cacheBuilder.d(), 65536);
        Strength i4 = cacheBuilder.i();
        this.f26479g = i4;
        this.f26480h = cacheBuilder.p();
        this.f26477e = cacheBuilder.h();
        this.f26478f = cacheBuilder.o();
        long j4 = cacheBuilder.j();
        this.f26481i = j4;
        this.f26482j = (Weigher<K, V>) cacheBuilder.q();
        this.f26483k = cacheBuilder.e();
        this.f26484l = cacheBuilder.f();
        this.f26485m = cacheBuilder.k();
        RemovalListener<K, V> removalListener = (RemovalListener<K, V>) cacheBuilder.l();
        this.f26487o = removalListener;
        if (removalListener == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = h();
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        this.f26486n = concurrentLinkedQueue;
        this.f26488p = cacheBuilder.n(E());
        this.f26489q = EntryFactory.f(i4, M(), Q());
        this.f26490r = cacheBuilder.m().get();
        this.f26491s = cacheLoader;
        int min = Math.min(cacheBuilder.g(), 1073741824);
        if (i() && !g()) {
            min = (int) Math.min(min, j4);
        }
        int i5 = 0;
        int i6 = 1;
        int i7 = 1;
        int i8 = 0;
        while (i7 < this.f26476d && (!i() || i7 * 20 <= this.f26481i)) {
            i8++;
            i7 <<= 1;
        }
        this.f26474b = 32 - i8;
        this.f26473a = i7 - 1;
        this.f26475c = w(i7);
        int i9 = min / i7;
        while (i6 < (i9 * i7 < min ? i9 + 1 : i9)) {
            i6 <<= 1;
        }
        if (i()) {
            long j5 = this.f26481i;
            long j6 = i7;
            long j7 = (j5 / j6) + 1;
            long j8 = j5 % j6;
            while (true) {
                Segment<K, V>[] segmentArr = this.f26475c;
                if (i5 < segmentArr.length) {
                    if (i5 == j8) {
                        j7--;
                    }
                    segmentArr[i5] = f(i6, j7, cacheBuilder.m().get());
                    i5++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.f26475c;
                if (i5 < segmentArr2.length) {
                    segmentArr2[i5] = f(i6, -1L, cacheBuilder.m().get());
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    static int I(int i4) {
        int i5 = i4 + ((i4 << 15) ^ (-12931));
        int i6 = i5 ^ (i5 >>> 10);
        int i7 = i6 + (i6 << 3);
        int i8 = i7 ^ (i7 >>> 6);
        int i9 = i8 + (i8 << 2) + (i8 << 14);
        return i9 ^ (i9 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> K(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> ValueReference<K, V> L() {
        return (ValueReference<K, V>) f26471x;
    }

    static <K, V> void d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.o(referenceEntry2);
        referenceEntry2.c(referenceEntry);
    }

    static <K, V> void e(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.p(referenceEntry2);
        referenceEntry2.q(referenceEntry);
    }

    static <E> Queue<E> h() {
        return (Queue<E>) f26472y;
    }

    static <K, V> ReferenceEntry<K, V> x() {
        return NullEntry.INSTANCE;
    }

    static <K, V> void y(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> x3 = x();
        referenceEntry.o(x3);
        referenceEntry.c(x3);
    }

    static <K, V> void z(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> x3 = x();
        referenceEntry.p(x3);
        referenceEntry.q(x3);
    }

    void A() {
        while (true) {
            RemovalNotification<K, V> poll = this.f26486n.poll();
            if (poll != null) {
                try {
                    this.f26487o.onRemoval(poll);
                } catch (Throwable th) {
                    f26470w.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    void B(ReferenceEntry<K, V> referenceEntry) {
        int b4 = referenceEntry.b();
        J(b4).M(referenceEntry, b4);
    }

    void C(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int b4 = entry.b();
        J(b4).N(entry.getKey(), b4, valueReference);
    }

    boolean D() {
        return j();
    }

    boolean E() {
        if (!F() && !D()) {
            return false;
        }
        return true;
    }

    boolean F() {
        if (!k() && !H()) {
            return false;
        }
        return true;
    }

    void G(K k4) {
        int r4 = r(Preconditions.checkNotNull(k4));
        J(r4).R(k4, r4, this.f26491s, false);
    }

    boolean H() {
        if (this.f26485m > 0) {
            return true;
        }
        return false;
    }

    Segment<K, V> J(int i4) {
        return this.f26475c[(i4 >>> this.f26474b) & this.f26473a];
    }

    boolean M() {
        if (!N() && !D()) {
            return false;
        }
        return true;
    }

    boolean N() {
        if (!j() && !i()) {
            return false;
        }
        return true;
    }

    boolean O() {
        if (this.f26479g != Strength.STRONG) {
            return true;
        }
        return false;
    }

    boolean P() {
        if (this.f26480h != Strength.STRONG) {
            return true;
        }
        return false;
    }

    boolean Q() {
        if (!R() && !F()) {
            return false;
        }
        return true;
    }

    boolean R() {
        return k();
    }

    public void c() {
        for (Segment<K, V> segment : this.f26475c) {
            segment.b();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f26475c) {
            segment.c();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int r4 = r(obj);
        return J(r4).h(obj, r4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        long read = this.f26488p.read();
        Segment<K, V>[] segmentArr = this.f26475c;
        long j4 = -1;
        int i4 = 0;
        while (i4 < 3) {
            int length = segmentArr.length;
            long j5 = 0;
            int i5 = 0;
            while (i5 < length) {
                Segment<K, V> segment = segmentArr[i5];
                int i6 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i7 = 0; i7 < atomicReferenceArray.length(); i7++) {
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i7);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V y3 = segment.y(referenceEntry, read);
                        long j6 = read;
                        if (y3 != null && this.f26478f.equivalent(obj, y3)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        read = j6;
                    }
                }
                j5 += segment.modCount;
                i5++;
                read = read;
            }
            long j7 = read;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j5 != j4) {
                i4++;
                j4 = j5;
                segmentArr = segmentArr3;
                read = j7;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f26494v;
        if (set == null) {
            EntrySet entrySet = new EntrySet();
            this.f26494v = entrySet;
            return entrySet;
        }
        return set;
    }

    Segment<K, V> f(int i4, long j4, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i4, j4, statsCounter);
    }

    boolean g() {
        if (this.f26482j != CacheBuilder.OneWeigher.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int r4 = r(obj);
        return J(r4).s(obj, r4);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V getOrDefault(@CheckForNull Object obj, @CheckForNull V v3) {
        V v4 = get(obj);
        if (v4 != null) {
            return v4;
        }
        return v3;
    }

    boolean i() {
        if (this.f26481i >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f26475c;
        long j4 = 0;
        for (Segment<K, V> segment : segmentArr) {
            if (segment.count != 0) {
                return false;
            }
            j4 += segment.modCount;
        }
        if (j4 == 0) {
            return true;
        }
        for (Segment<K, V> segment2 : segmentArr) {
            if (segment2.count != 0) {
                return false;
            }
            j4 -= segment2.modCount;
        }
        if (j4 != 0) {
            return false;
        }
        return true;
    }

    boolean j() {
        if (this.f26483k > 0) {
            return true;
        }
        return false;
    }

    boolean k() {
        if (this.f26484l > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f26492t;
        if (set == null) {
            KeySet keySet = new KeySet();
            this.f26492t = keySet;
            return keySet;
        }
        return set;
    }

    @CanIgnoreReturnValue
    V l(K k4, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int r4 = r(Preconditions.checkNotNull(k4));
        return J(r4).t(k4, r4, cacheLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> m(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet newLinkedHashSet = Sets.newLinkedHashSet();
        int i4 = 0;
        int i5 = 0;
        for (K k4 : iterable) {
            Object obj = get(k4);
            if (!newLinkedHashMap.containsKey(k4)) {
                newLinkedHashMap.put(k4, obj);
                if (obj == null) {
                    i5++;
                    newLinkedHashSet.add(k4);
                } else {
                    i4++;
                }
            }
        }
        try {
            if (!newLinkedHashSet.isEmpty()) {
                try {
                    Map u3 = u(Collections.unmodifiableSet(newLinkedHashSet), this.f26491s);
                    for (Object obj2 : newLinkedHashSet) {
                        Object obj3 = u3.get(obj2);
                        if (obj3 != null) {
                            newLinkedHashMap.put(obj2, obj3);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : newLinkedHashSet) {
                        i5--;
                        newLinkedHashMap.put(obj4, l(obj4, this.f26491s));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) newLinkedHashMap);
        } finally {
            this.f26490r.recordHits(i4);
            this.f26490r.recordMisses(i5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> n(Iterable<?> iterable) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i4 = 0;
        int i5 = 0;
        for (Object obj : iterable) {
            V v3 = get(obj);
            if (v3 == null) {
                i5++;
            } else {
                builder.put(obj, v3);
                i4++;
            }
        }
        this.f26490r.recordHits(i4);
        this.f26490r.recordMisses(i5);
        return builder.buildKeepingLast();
    }

    @CheckForNull
    public V o(Object obj) {
        int r4 = r(Preconditions.checkNotNull(obj));
        V s3 = J(r4).s(obj, r4);
        if (s3 == null) {
            this.f26490r.recordMisses(1);
        } else {
            this.f26490r.recordHits(1);
        }
        return s3;
    }

    @CheckForNull
    V p(ReferenceEntry<K, V> referenceEntry, long j4) {
        V v3;
        if (referenceEntry.getKey() == null || (v3 = referenceEntry.a().get()) == null || t(referenceEntry, j4)) {
            return null;
        }
        return v3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        int r4 = r(k4);
        return J(r4).L(k4, r4, v3, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V putIfAbsent(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        int r4 = r(k4);
        return J(r4).L(k4, r4, v3, true);
    }

    V q(K k4) throws ExecutionException {
        return l(k4, this.f26491s);
    }

    int r(@CheckForNull Object obj) {
        return I(this.f26477e.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int r4 = r(obj);
        return J(r4).S(obj, r4);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k4, @CheckForNull V v3, V v4) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v4);
        if (v3 == null) {
            return false;
        }
        int r4 = r(k4);
        return J(r4).a0(k4, r4, v3, v4);
    }

    void s(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(v());
    }

    boolean t(ReferenceEntry<K, V> referenceEntry, long j4) {
        Preconditions.checkNotNull(referenceEntry);
        if (j() && j4 - referenceEntry.n() >= this.f26483k) {
            return true;
        }
        if (k() && j4 - referenceEntry.g() >= this.f26484l) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map<K, V> u(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            com.google.common.base.Preconditions.checkNotNull(r8)
            com.google.common.base.Preconditions.checkNotNull(r7)
            com.google.common.base.Stopwatch r0 = com.google.common.base.Stopwatch.createStarted()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> L8e java.lang.Error -> L91 java.lang.Exception -> L98 java.lang.RuntimeException -> L9f java.lang.InterruptedException -> La6 com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lb4
            if (r7 == 0) goto L6c
            r0.stop()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.f26490r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadSuccess(r0)
            return r7
        L4a:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.f26490r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L6c:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.f26490r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L8e:
            r7 = move-exception
            r1 = 0
            goto Lb7
        L91:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L98:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L9f:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        La6:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8e
            r8.interrupt()     // Catch: java.lang.Throwable -> L8e
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        Lb4:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r7 = move-exception
        Lb7:
            if (r1 != 0) goto Lc4
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.f26490r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadException(r0)
        Lc4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.u(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    long v() {
        long j4 = 0;
        for (Segment<K, V> segment : this.f26475c) {
            j4 += Math.max(0, segment.count);
        }
        return j4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f26493u;
        if (collection == null) {
            Values values = new Values();
            this.f26493u = values;
            return values;
        }
        return collection;
    }

    final Segment<K, V>[] w(int i4) {
        return new Segment[i4];
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int r4 = r(obj);
        return J(r4).T(obj, r4, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V replace(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        int r4 = r(k4);
        return J(r4).Z(k4, r4, v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        @CheckForNull
        public ValueReference<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int b() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long g() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        @CheckForNull
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        @CheckForNull
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long n() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> e() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> j() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> l() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> m() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void c(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void f(ValueReference<Object, Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void h(long j4) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void i(long j4) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void q(ReferenceEntry<Object, Object> referenceEntry) {
        }
    }

    /* loaded from: classes5.dex */
    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final ReferenceEntry<K, V> f26528a;

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            super(v3, referenceQueue);
            this.f26528a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V b() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v3, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.f26528a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(V v3) {
        }
    }

    /* loaded from: classes5.dex */
    static class StrongValueReference<K, V> implements ValueReference<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final V f26546a;

        StrongValueReference(V v3) {
            this.f26546a = v3;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V b() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.f26546a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(V v3) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }
    }

    /* loaded from: classes5.dex */
    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final ReferenceEntry<K, V> f26563a;

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            super(v3, referenceQueue);
            this.f26563a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V b() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> d(ReferenceQueue<V> referenceQueue, V v3, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v3, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.f26563a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void a(V v3) {
        }
    }
}
