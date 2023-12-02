package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* renamed from: h  reason: collision with root package name */
    static final WeakValueReference<Object, Object, DummyInternalEntry> f27105h = new WeakValueReference<Object, Object, DummyInternalEntry>() { // from class: com.google.common.collect.MapMakerInternalMap.1
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        @CheckForNull
        /* renamed from: c */
        public DummyInternalEntry getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        @CheckForNull
        public Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* renamed from: b */
        public WeakValueReference<Object, Object, DummyInternalEntry> a(ReferenceQueue<Object> referenceQueue, DummyInternalEntry dummyInternalEntry) {
            return this;
        }
    };
    private static final long serialVersionUID = 5;

    /* renamed from: a  reason: collision with root package name */
    final transient int f27106a;

    /* renamed from: b  reason: collision with root package name */
    final transient int f27107b;

    /* renamed from: c  reason: collision with root package name */
    final transient Segment<K, V, E, S>[] f27108c;
    final int concurrencyLevel;

    /* renamed from: d  reason: collision with root package name */
    final transient InternalEntryHelper<K, V, E, S> f27109d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    transient Set<K> f27110e;
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    transient Collection<V> f27111f;
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    transient Set<Map.Entry<K, V>> f27112g;
    final Equivalence<Object> keyEquivalence;

    /* loaded from: classes5.dex */
    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: a  reason: collision with root package name */
        transient ConcurrentMap<K, V> f27113a;
        final int concurrencyLevel;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i4, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i4;
            this.f27113a = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap
        /* renamed from: h */
        public ConcurrentMap<K, V> f() {
            return this.f27113a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @J2ktIncompatible
        void i(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.f27113a.put(readObject, objectInputStream.readObject());
            }
        }

        @J2ktIncompatible
        MapMaker j(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().initialCapacity(objectInputStream.readInt()).g(this.keyStrength).h(this.valueStrength).f(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
        }

        void l(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.f27113a.size());
            for (Map.Entry<K, V> entry : this.f27113a.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final K f27114a;

        /* renamed from: b  reason: collision with root package name */
        final int f27115b;

        AbstractStrongKeyEntry(K k4, int i4) {
            this.f27114a = k4;
            this.f27115b = i4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int b() {
            return this.f27115b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final K getKey() {
            return this.f27114a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @CheckForNull
        public E getNext() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {

        /* renamed from: a  reason: collision with root package name */
        final int f27116a;

        AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k4, int i4) {
            super(k4, referenceQueue);
            this.f27116a = i4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int b() {
            return this.f27116a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @CheckForNull
        public E getNext() {
            return null;
        }
    }

    /* loaded from: classes5.dex */
    static final class CleanupMapTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> f27117a;

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.f27117a.get();
            if (mapMakerInternalMap != null) {
                for (Segment<?, ?, ?, ?> segment : mapMakerInternalMap.f27108c) {
                    segment.D();
                }
                return;
            }
            throw new CancellationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        private DummyInternalEntry() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int b() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: c */
        public DummyInternalEntry getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* loaded from: classes5.dex */
    final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: classes5.dex */
    final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = MapMakerInternalMap.this.get(key)) == null || !MapMakerInternalMap.this.r().equivalent(entry.getValue(), obj2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !MapMakerInternalMap.this.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public abstract class HashIterator<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f27119a;

        /* renamed from: b  reason: collision with root package name */
        int f27120b = -1;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Segment<K, V, E, S> f27121c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        AtomicReferenceArray<E> f27122d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        E f27123e;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry f27124f;
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry f27125g;

        HashIterator() {
            this.f27119a = MapMakerInternalMap.this.f27108c.length - 1;
            a();
        }

        final void a() {
            this.f27124f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i4 = this.f27119a;
                if (i4 >= 0) {
                    Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.f27108c;
                    this.f27119a = i4 - 1;
                    Segment<K, V, E, S> segment = segmentArr[i4];
                    this.f27121c = segment;
                    if (segment.count != 0) {
                        AtomicReferenceArray<E> atomicReferenceArray = this.f27121c.table;
                        this.f27122d = atomicReferenceArray;
                        this.f27120b = atomicReferenceArray.length() - 1;
                        if (e()) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }

        boolean b(E e4) {
            try {
                Object key = e4.getKey();
                Object h4 = MapMakerInternalMap.this.h(e4);
                if (h4 != null) {
                    this.f27124f = new WriteThroughEntry(key, h4);
                    this.f27121c.t();
                    return true;
                }
                this.f27121c.t();
                return false;
            } catch (Throwable th) {
                this.f27121c.t();
                throw th;
            }
        }

        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry c() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.f27124f;
            if (writeThroughEntry != null) {
                this.f27125g = writeThroughEntry;
                a();
                return this.f27125g;
            }
            throw new NoSuchElementException();
        }

        boolean d() {
            E e4 = this.f27123e;
            if (e4 == null) {
                return false;
            }
            while (true) {
                this.f27123e = (E) e4.getNext();
                E e5 = this.f27123e;
                if (e5 != null) {
                    if (b(e5)) {
                        return true;
                    }
                    e4 = this.f27123e;
                } else {
                    return false;
                }
            }
        }

        boolean e() {
            while (true) {
                int i4 = this.f27120b;
                if (i4 >= 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f27122d;
                    this.f27120b = i4 - 1;
                    E e4 = atomicReferenceArray.get(i4);
                    this.f27123e = e4;
                    if (e4 != null && (b(e4) || d())) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f27124f != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            if (this.f27125g != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            CollectPreconditions.e(z3);
            MapMakerInternalMap.this.remove(this.f27125g.getKey());
            this.f27125g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int b();

        K getKey();

        E getNext();

        V getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i4);

        void b(S s3, E e4, V v3);

        Strength c();

        E d(S s3, E e4, @CheckForNull E e5);

        Strength e();

        E f(S s3, K k4, int i4, @CheckForNull E e4);
    }

    /* loaded from: classes5.dex */
    final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        KeyIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes5.dex */
    final class KeySet extends SafeToArraySet<K> {
        KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (MapMakerInternalMap.this.remove(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes5.dex */
    private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.p(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.p(this).toArray(tArr);
        }
    }

    /* loaded from: classes5.dex */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i4, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i4, concurrentMap);
        }

        @J2ktIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f27113a = j(objectInputStream).makeMap();
            i(objectInputStream);
        }

        private Object readResolve() {
            return this.f27113a;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            l(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> b() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> b() {
                return Equivalence.identity();
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class LinkedStrongKeyDummyValueEntry<K> extends StrongKeyDummyValueEntry<K> {

            /* renamed from: c  reason: collision with root package name */
            private final StrongKeyDummyValueEntry<K> f27132c;

            LinkedStrongKeyDummyValueEntry(K k4, int i4, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
                super(k4, i4);
                this.f27132c = strongKeyDummyValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* renamed from: d */
            public StrongKeyDummyValueEntry<K> getNext() {
                return this.f27132c;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: c */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        private StrongKeyDummyValueEntry(K k4, int i4) {
            super(k4, i4);
        }

        /* loaded from: classes5.dex */
        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?> f27131a = new Helper<>();

            Helper() {
            }

            static <K> Helper<K> h() {
                return (Helper<K>) f27131a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g */
            public StrongKeyDummyValueEntry<K> d(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, @CheckForNull StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry2) {
                return f(strongKeyDummyValueSegment, strongKeyDummyValueEntry.f27114a, strongKeyDummyValueEntry.f27115b, strongKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i */
            public StrongKeyDummyValueEntry<K> f(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k4, int i4, @CheckForNull StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
                if (strongKeyDummyValueEntry == null) {
                    return new StrongKeyDummyValueEntry<>(k4, i4);
                }
                return new LinkedStrongKeyDummyValueEntry(k4, i4, strongKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j */
            public StrongKeyDummyValueSegment<K> a(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i4) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k */
            public void b(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        private volatile V f27133c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f27134a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return (Helper<K, V>) f27134a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: g */
            public StrongKeyStrongValueEntry<K, V> d(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, @CheckForNull StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2) {
                StrongKeyStrongValueEntry<K, V> f4 = f(strongKeyStrongValueSegment, strongKeyStrongValueEntry.f27114a, strongKeyStrongValueEntry.f27115b, strongKeyStrongValueEntry2);
                ((StrongKeyStrongValueEntry) f4).f27133c = ((StrongKeyStrongValueEntry) strongKeyStrongValueEntry).f27133c;
                return f4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i */
            public StrongKeyStrongValueEntry<K, V> f(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k4, int i4, @CheckForNull StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                if (strongKeyStrongValueEntry == null) {
                    return new StrongKeyStrongValueEntry<>(k4, i4);
                }
                return new LinkedStrongKeyStrongValueEntry(k4, i4, strongKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j */
            public StrongKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i4) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k */
            public void b(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, V v3) {
                ((StrongKeyStrongValueEntry) strongKeyStrongValueEntry).f27133c = v3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class LinkedStrongKeyStrongValueEntry<K, V> extends StrongKeyStrongValueEntry<K, V> {

            /* renamed from: d  reason: collision with root package name */
            private final StrongKeyStrongValueEntry<K, V> f27135d;

            LinkedStrongKeyStrongValueEntry(K k4, int i4, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                super(k4, i4);
                this.f27135d = strongKeyStrongValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* renamed from: e */
            public StrongKeyStrongValueEntry<K, V> getNext() {
                return this.f27135d;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @CheckForNull
        public final V getValue() {
            return this.f27133c;
        }

        private StrongKeyStrongValueEntry(K k4, int i4) {
            super(k4, i4);
            this.f27133c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> f27136c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f27137a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return (Helper<K, V>) f27137a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength e() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            @CheckForNull
            /* renamed from: g */
            public StrongKeyWeakValueEntry<K, V> d(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, @CheckForNull StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2) {
                if (Segment.p(strongKeyWeakValueEntry)) {
                    return null;
                }
                StrongKeyWeakValueEntry<K, V> f4 = f(strongKeyWeakValueSegment, strongKeyWeakValueEntry.f27114a, strongKeyWeakValueEntry.f27115b, strongKeyWeakValueEntry2);
                ((StrongKeyWeakValueEntry) f4).f27136c = ((StrongKeyWeakValueEntry) strongKeyWeakValueEntry).f27136c.a(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, f4);
                return f4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i */
            public StrongKeyWeakValueEntry<K, V> f(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k4, int i4, @CheckForNull StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                if (strongKeyWeakValueEntry == null) {
                    return new StrongKeyWeakValueEntry<>(k4, i4);
                }
                return new LinkedStrongKeyWeakValueEntry(k4, i4, strongKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j */
            public StrongKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i4) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k */
            public void b(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, V v3) {
                WeakValueReference weakValueReference = ((StrongKeyWeakValueEntry) strongKeyWeakValueEntry).f27136c;
                ((StrongKeyWeakValueEntry) strongKeyWeakValueEntry).f27136c = new WeakValueReferenceImpl(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, v3, strongKeyWeakValueEntry);
                weakValueReference.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class LinkedStrongKeyWeakValueEntry<K, V> extends StrongKeyWeakValueEntry<K, V> {

            /* renamed from: d  reason: collision with root package name */
            private final StrongKeyWeakValueEntry<K, V> f27138d;

            LinkedStrongKeyWeakValueEntry(K k4, int i4, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                super(k4, i4);
                this.f27138d = strongKeyWeakValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* renamed from: e */
            public StrongKeyWeakValueEntry<K, V> getNext() {
                return this.f27138d;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> a() {
            return this.f27136c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @CheckForNull
        public final V getValue() {
            return this.f27136c.get();
        }

        private StrongKeyWeakValueEntry(K k4, int i4) {
            super(k4, i4);
            this.f27136c = MapMakerInternalMap.q();
        }
    }

    /* loaded from: classes5.dex */
    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    /* loaded from: classes5.dex */
    final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        ValueIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: classes5.dex */
    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.p(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.p(this).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class LinkedWeakKeyDummyValueEntry<K> extends WeakKeyDummyValueEntry<K> {

            /* renamed from: b  reason: collision with root package name */
            private final WeakKeyDummyValueEntry<K> f27141b;

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* renamed from: d */
            public WeakKeyDummyValueEntry<K> getNext() {
                return this.f27141b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }

            private LinkedWeakKeyDummyValueEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
                super(referenceQueue, k4, i4);
                this.f27141b = weakKeyDummyValueEntry;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* renamed from: c */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        private WeakKeyDummyValueEntry(ReferenceQueue<K> referenceQueue, K k4, int i4) {
            super(referenceQueue, k4, i4);
        }

        /* loaded from: classes5.dex */
        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?> f27140a = new Helper<>();

            Helper() {
            }

            static <K> Helper<K> h() {
                return (Helper<K>) f27140a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            @CheckForNull
            /* renamed from: g */
            public WeakKeyDummyValueEntry<K> d(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, @CheckForNull WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry2) {
                K key = weakKeyDummyValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                return f(weakKeyDummyValueSegment, key, weakKeyDummyValueEntry.f27116a, weakKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i */
            public WeakKeyDummyValueEntry<K> f(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k4, int i4, @CheckForNull WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
                if (weakKeyDummyValueEntry == null) {
                    return new WeakKeyDummyValueEntry<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k4, i4);
                }
                return new LinkedWeakKeyDummyValueEntry(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k4, i4, weakKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j */
            public WeakKeyDummyValueSegment<K> a(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i4) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k */
            public void b(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        private volatile V f27142b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f27143a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return (Helper<K, V>) f27143a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            @CheckForNull
            /* renamed from: g */
            public WeakKeyStrongValueEntry<K, V> d(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, @CheckForNull WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2) {
                K key = weakKeyStrongValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                WeakKeyStrongValueEntry<K, V> f4 = f(weakKeyStrongValueSegment, key, weakKeyStrongValueEntry.f27116a, weakKeyStrongValueEntry2);
                ((WeakKeyStrongValueEntry) f4).f27142b = ((WeakKeyStrongValueEntry) weakKeyStrongValueEntry).f27142b;
                return f4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i */
            public WeakKeyStrongValueEntry<K, V> f(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k4, int i4, @CheckForNull WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                if (weakKeyStrongValueEntry == null) {
                    return new WeakKeyStrongValueEntry<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k4, i4);
                }
                return new LinkedWeakKeyStrongValueEntry(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k4, i4, weakKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j */
            public WeakKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i4) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k */
            public void b(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, V v3) {
                ((WeakKeyStrongValueEntry) weakKeyStrongValueEntry).f27142b = v3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class LinkedWeakKeyStrongValueEntry<K, V> extends WeakKeyStrongValueEntry<K, V> {

            /* renamed from: c  reason: collision with root package name */
            private final WeakKeyStrongValueEntry<K, V> f27144c;

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* renamed from: e */
            public WeakKeyStrongValueEntry<K, V> getNext() {
                return this.f27144c;
            }

            private LinkedWeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                super(referenceQueue, k4, i4);
                this.f27144c = weakKeyStrongValueEntry;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @CheckForNull
        public final V getValue() {
            return this.f27142b;
        }

        private WeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k4, int i4) {
            super(referenceQueue, k4, i4);
            this.f27142b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> f27145b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f27146a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return (Helper<K, V>) f27146a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength e() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            @CheckForNull
            /* renamed from: g */
            public WeakKeyWeakValueEntry<K, V> d(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, @CheckForNull WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2) {
                K key = weakKeyWeakValueEntry.getKey();
                if (key == null || Segment.p(weakKeyWeakValueEntry)) {
                    return null;
                }
                WeakKeyWeakValueEntry<K, V> f4 = f(weakKeyWeakValueSegment, key, weakKeyWeakValueEntry.f27116a, weakKeyWeakValueEntry2);
                ((WeakKeyWeakValueEntry) f4).f27145b = ((WeakKeyWeakValueEntry) weakKeyWeakValueEntry).f27145b.a(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, f4);
                return f4;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: i */
            public WeakKeyWeakValueEntry<K, V> f(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k4, int i4, @CheckForNull WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                if (weakKeyWeakValueEntry == null) {
                    return new WeakKeyWeakValueEntry<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k4, i4);
                }
                return new LinkedWeakKeyWeakValueEntry(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k4, i4, weakKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: j */
            public WeakKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i4) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i4);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* renamed from: k */
            public void b(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, V v3) {
                WeakValueReference weakValueReference = ((WeakKeyWeakValueEntry) weakKeyWeakValueEntry).f27145b;
                ((WeakKeyWeakValueEntry) weakKeyWeakValueEntry).f27145b = new WeakValueReferenceImpl(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, v3, weakKeyWeakValueEntry);
                weakValueReference.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class LinkedWeakKeyWeakValueEntry<K, V> extends WeakKeyWeakValueEntry<K, V> {

            /* renamed from: c  reason: collision with root package name */
            private final WeakKeyWeakValueEntry<K, V> f27147c;

            LinkedWeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k4, int i4, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                super(referenceQueue, k4, i4);
                this.f27147c = weakKeyWeakValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* renamed from: e */
            public WeakKeyWeakValueEntry<K, V> getNext() {
                return this.f27147c;
            }
        }

        WeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k4, int i4) {
            super(referenceQueue, k4, i4);
            this.f27145b = MapMakerInternalMap.q();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> a() {
            return this.f27145b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final V getValue() {
            return this.f27145b.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference<K, V, E> a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        WeakValueReference<K, V, E> a(ReferenceQueue<V> referenceQueue, E e4);

        void clear();

        @CheckForNull
        V get();

        E getEntry();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        @Weak

        /* renamed from: a  reason: collision with root package name */
        final E f27148a;

        WeakValueReferenceImpl(ReferenceQueue<V> referenceQueue, V v3, E e4) {
            super(v3, referenceQueue);
            this.f27148a = e4;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> a(ReferenceQueue<V> referenceQueue, E e4) {
            return new WeakValueReferenceImpl(referenceQueue, get(), e4);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.f27148a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class WriteThroughEntry extends AbstractMapEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f27149a;

        /* renamed from: b  reason: collision with root package name */
        V f27150b;

        WriteThroughEntry(K k4, V v3) {
            this.f27149a = k4;
            this.f27150b = v3;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f27149a.equals(entry.getKey()) || !this.f27150b.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.f27149a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.f27150b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            return this.f27149a.hashCode() ^ this.f27150b.hashCode();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v3) {
            V v4 = (V) MapMakerInternalMap.this.put(this.f27149a, v3);
            this.f27150b = v3;
            return v4;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.concurrencyLevel = Math.min(mapMaker.a(), 65536);
        this.keyEquivalence = mapMaker.c();
        this.f27109d = internalEntryHelper;
        int min = Math.min(mapMaker.b(), 1073741824);
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.concurrencyLevel) {
            i7++;
            i6 <<= 1;
        }
        this.f27107b = 32 - i7;
        this.f27106a = i6 - 1;
        this.f27108c = j(i6);
        int i8 = min / i6;
        while (i5 < (i6 * i8 < min ? i8 + 1 : i8)) {
            i5 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.f27108c;
            if (i4 < segmentArr.length) {
                segmentArr[i4] = e(i5);
                i4++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> c(MapMaker mapMaker) {
        Strength d4 = mapMaker.d();
        Strength strength = Strength.STRONG;
        if (d4 == strength && mapMaker.e() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.d() == strength && mapMaker.e() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyWeakValueEntry.Helper.h());
        }
        Strength d5 = mapMaker.d();
        Strength strength2 = Strength.WEAK;
        if (d5 == strength2 && mapMaker.e() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.d() == strength2 && mapMaker.e() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyWeakValueEntry.Helper.h());
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> f(MapMaker mapMaker) {
        Strength d4 = mapMaker.d();
        Strength strength = Strength.STRONG;
        if (d4 == strength && mapMaker.e() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyDummyValueEntry.Helper.h());
        }
        Strength d5 = mapMaker.d();
        Strength strength2 = Strength.WEAK;
        if (d5 == strength2 && mapMaker.e() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyDummyValueEntry.Helper.h());
        }
        if (mapMaker.e() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static int n(int i4) {
        int i5 = i4 + ((i4 << 15) ^ (-12931));
        int i6 = i5 ^ (i5 >>> 10);
        int i7 = i6 + (i6 << 3);
        int i8 = i7 ^ (i7 >>> 6);
        int i9 = i8 + (i8 << 2) + (i8 << 14);
        return i9 ^ (i9 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> p(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> q() {
        return (WeakValueReference<K, V, E>) f27105h;
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.f27108c) {
            segment.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int i4 = i(obj);
        return o(i4).c(obj, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.f27108c;
        long j4 = -1;
        int i4 = 0;
        while (i4 < 3) {
            long j5 = 0;
            for (StrongKeyDummyValueSegment strongKeyDummyValueSegment : segmentArr) {
                int i5 = strongKeyDummyValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyDummyValueSegment.table;
                for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                    for (E e4 = atomicReferenceArray.get(i6); e4 != null; e4 = e4.getNext()) {
                        Object n4 = strongKeyDummyValueSegment.n(e4);
                        if (n4 != null && r().equivalent(obj, n4)) {
                            return true;
                        }
                    }
                }
                j5 += strongKeyDummyValueSegment.modCount;
            }
            if (j5 != j4) {
                i4++;
                j4 = j5;
            } else {
                return false;
            }
        }
        return false;
    }

    Segment<K, V, E, S> e(int i4) {
        return (S) this.f27109d.a(this, i4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f27112g;
        if (set == null) {
            EntrySet entrySet = new EntrySet();
            this.f27112g = entrySet;
            return entrySet;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public E g(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int i4 = i(obj);
        return o(i4).j(obj, i4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int i4 = i(obj);
        return o(i4).i(obj, i4);
    }

    @CheckForNull
    V h(E e4) {
        if (e4.getKey() == null) {
            return null;
        }
        return (V) e4.getValue();
    }

    int i(Object obj) {
        return n(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.f27108c;
        long j4 = 0;
        for (int i4 = 0; i4 < segmentArr.length; i4++) {
            if (segmentArr[i4].count != 0) {
                return false;
            }
            j4 += segmentArr[i4].modCount;
        }
        if (j4 == 0) {
            return true;
        }
        for (int i5 = 0; i5 < segmentArr.length; i5++) {
            if (segmentArr[i5].count != 0) {
                return false;
            }
            j4 -= segmentArr[i5].modCount;
        }
        if (j4 != 0) {
            return false;
        }
        return true;
    }

    final Segment<K, V, E, S>[] j(int i4) {
        return new Segment[i4];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f27110e;
        if (set == null) {
            KeySet keySet = new KeySet();
            this.f27110e = keySet;
            return keySet;
        }
        return set;
    }

    void l(E e4) {
        int b4 = e4.b();
        o(b4).w(e4, b4);
    }

    void m(WeakValueReference<K, V, E> weakValueReference) {
        E entry = weakValueReference.getEntry();
        int b4 = entry.b();
        o(b4).x((K) entry.getKey(), b4, weakValueReference);
    }

    Segment<K, V, E, S> o(int i4) {
        return this.f27108c[(i4 >>> this.f27107b) & this.f27106a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        int i4 = i(k4);
        return o(i4).v(k4, i4, v3, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V putIfAbsent(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        int i4 = i(k4);
        return o(i4).v(k4, i4, v3, true);
    }

    @VisibleForTesting
    Equivalence<Object> r() {
        return this.f27109d.e().b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int i4 = i(obj);
        return o(i4).y(obj, i4);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k4, @CheckForNull V v3, V v4) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v4);
        if (v3 == null) {
            return false;
        }
        int i4 = i(k4);
        return o(i4).C(k4, i4, v3, v4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j4 = 0;
        for (Segment<K, V, E, S> segment : this.f27108c) {
            j4 += segment.count;
        }
        return Ints.saturatedCast(j4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f27111f;
        if (collection == null) {
            Values values = new Values();
            this.f27111f = values;
            return values;
        }
        return collection;
    }

    Object writeReplace() {
        return new SerializationProxy(this.f27109d.c(), this.f27109d.e(), this.keyEquivalence, this.f27109d.e().b(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int i4 = i(obj);
        return o(i4).z(obj, i4, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V replace(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        int i4 = i(k4);
        return o(i4).B(k4, i4, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        @CheckForNull
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i4) {
            this.map = mapMakerInternalMap;
            o(s(i4));
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean p(E e4) {
            if (e4.getValue() == null) {
                return true;
            }
            return false;
        }

        @CheckForNull
        @GuardedBy("this")
        E A(E e4, E e5) {
            int i4 = this.count;
            E e6 = (E) e5.getNext();
            while (e4 != e5) {
                E e7 = e(e4, e6);
                if (e7 != null) {
                    e6 = e7;
                } else {
                    i4--;
                }
                e4 = (E) e4.getNext();
            }
            this.count = i4;
            return e6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        V B(K k4, int i4, V v3) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                E e4 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e4; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.b() == i4 && key != null && this.map.keyEquivalence.equivalent(k4, key)) {
                        V v4 = (V) internalEntry.getValue();
                        if (v4 == null) {
                            if (p(internalEntry)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, A(e4, internalEntry));
                                this.count--;
                            }
                            return null;
                        }
                        this.modCount++;
                        G(internalEntry, v3);
                        return v4;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean C(K k4, int i4, V v3, V v4) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                E e4 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e4; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.b() == i4 && key != null && this.map.keyEquivalence.equivalent(k4, key)) {
                        Object value = internalEntry.getValue();
                        if (value == null) {
                            if (p(internalEntry)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, A(e4, internalEntry));
                                this.count--;
                            }
                            return false;
                        } else if (!this.map.r().equivalent(v3, value)) {
                            return false;
                        } else {
                            this.modCount++;
                            G(internalEntry, v4);
                            return true;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void D() {
            E();
        }

        void E() {
            if (tryLock()) {
                try {
                    r();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S F();

        void G(E e4, V v3) {
            this.map.f27109d.b(F(), e4, v3);
        }

        void H() {
            if (tryLock()) {
                try {
                    r();
                } finally {
                    unlock();
                }
            }
        }

        void a() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                        atomicReferenceArray.set(i4, null);
                    }
                    q();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void b(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        boolean c(Object obj, int i4) {
            try {
                boolean z3 = false;
                if (this.count == 0) {
                    return false;
                }
                E m4 = m(obj, i4);
                if (m4 != null) {
                    if (m4.getValue() != null) {
                        z3 = true;
                    }
                }
                return z3;
            } finally {
                t();
            }
        }

        @CheckForNull
        E e(E e4, E e5) {
            return this.map.f27109d.d(F(), e4, e5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void f(ReferenceQueue<K> referenceQueue) {
            int i4 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.l((InternalEntry) poll);
                    i4++;
                } else {
                    return;
                }
            } while (i4 != 16);
        }

        @GuardedBy("this")
        void g(ReferenceQueue<V> referenceQueue) {
            int i4 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.m((WeakValueReference) poll);
                    i4++;
                } else {
                    return;
                }
            } while (i4 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        void h() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i4 = this.count;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) s(length << 1);
            this.threshold = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i5 = 0; i5 < length; i5++) {
                E e4 = atomicReferenceArray.get(i5);
                if (e4 != null) {
                    InternalEntry next = e4.getNext();
                    int b4 = e4.b() & length2;
                    if (next == null) {
                        atomicReferenceArray2.set(b4, e4);
                    } else {
                        InternalEntry internalEntry = e4;
                        while (next != null) {
                            int b5 = next.b() & length2;
                            if (b5 != b4) {
                                internalEntry = next;
                                b4 = b5;
                            }
                            next = next.getNext();
                        }
                        atomicReferenceArray2.set(b4, internalEntry);
                        while (e4 != internalEntry) {
                            int b6 = e4.b() & length2;
                            InternalEntry e5 = e(e4, (InternalEntry) atomicReferenceArray2.get(b6));
                            if (e5 != null) {
                                atomicReferenceArray2.set(b6, e5);
                            } else {
                                i4--;
                            }
                            e4 = e4.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArray2;
            this.count = i4;
        }

        @CheckForNull
        V i(Object obj, int i4) {
            try {
                E m4 = m(obj, i4);
                if (m4 == null) {
                    t();
                    return null;
                }
                V v3 = (V) m4.getValue();
                if (v3 == null) {
                    H();
                }
                return v3;
            } finally {
                t();
            }
        }

        @CheckForNull
        E j(Object obj, int i4) {
            if (this.count != 0) {
                for (E l4 = l(i4); l4 != null; l4 = (E) l4.getNext()) {
                    if (l4.b() == i4) {
                        Object key = l4.getKey();
                        if (key == null) {
                            H();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return l4;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        @CheckForNull
        E l(int i4) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i4 & (atomicReferenceArray.length() - 1));
        }

        @CheckForNull
        E m(Object obj, int i4) {
            return j(obj, i4);
        }

        @CheckForNull
        V n(E e4) {
            if (e4.getKey() == null) {
                H();
                return null;
            }
            V v3 = (V) e4.getValue();
            if (v3 == null) {
                H();
                return null;
            }
            return v3;
        }

        void o(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            this.table = atomicReferenceArray;
        }

        AtomicReferenceArray<E> s(int i4) {
            return new AtomicReferenceArray<>(i4);
        }

        void t() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                D();
            }
        }

        @GuardedBy("this")
        void u() {
            E();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        V v(K k4, int i4, V v3, boolean z3) {
            lock();
            try {
                u();
                int i5 = this.count + 1;
                if (i5 > this.threshold) {
                    h();
                    i5 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                E e4 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e4; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.b() == i4 && key != null && this.map.keyEquivalence.equivalent(k4, key)) {
                        V v4 = (V) internalEntry.getValue();
                        if (v4 == null) {
                            this.modCount++;
                            G(internalEntry, v3);
                            this.count = this.count;
                            return null;
                        } else if (z3) {
                            return v4;
                        } else {
                            this.modCount++;
                            G(internalEntry, v3);
                            return v4;
                        }
                    }
                }
                this.modCount++;
                E f4 = this.map.f27109d.f(F(), k4, i4, e4);
                G(f4, v3);
                atomicReferenceArray.set(length, f4);
                this.count = i5;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean w(E e4, int i4) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i4 & (atomicReferenceArray.length() - 1);
                E e5 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e5; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    if (internalEntry == e4) {
                        this.modCount++;
                        atomicReferenceArray.set(length, A(e5, internalEntry));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        boolean x(K k4, int i4, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                E e4 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e4; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.b() == i4 && key != null && this.map.keyEquivalence.equivalent(k4, key)) {
                        if (((WeakValueEntry) internalEntry).a() != weakValueReference) {
                            return false;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, A(e4, internalEntry));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        @CheckForNull
        V y(Object obj, int i4) {
            lock();
            try {
                u();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i4;
                E e4 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e4; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.b() == i4 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v3 = (V) internalEntry.getValue();
                        if (v3 == null && !p(internalEntry)) {
                            return null;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, A(e4, internalEntry));
                        this.count--;
                        return v3;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            if (r8.map.r().equivalent(r11, r4.getValue()) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (p(r4) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            r8.modCount++;
            r0.set(r1, A(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean z(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.u()     // Catch: java.lang.Throwable -> L69
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L69
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L69
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r3     // Catch: java.lang.Throwable -> L69
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L65
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L69
                int r7 = r4.b()     // Catch: java.lang.Throwable -> L69
                if (r7 != r10) goto L60
                if (r6 == 0) goto L60
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L69
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L69
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L69
                if (r6 == 0) goto L60
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L69
                com.google.common.base.Equivalence r10 = r10.r()     // Catch: java.lang.Throwable -> L69
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L41
                r5 = 1
                goto L47
            L41:
                boolean r9 = p(r4)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L5c
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L69
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap$InternalEntry r9 = r8.A(r3, r4)     // Catch: java.lang.Throwable -> L69
                int r10 = r8.count     // Catch: java.lang.Throwable -> L69
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L69
                r8.count = r10     // Catch: java.lang.Throwable -> L69
                r8.unlock()
                return r5
            L5c:
                r8.unlock()
                return r5
            L60:
                com.google.common.collect.MapMakerInternalMap$InternalEntry r4 = r4.getNext()     // Catch: java.lang.Throwable -> L69
                goto L16
            L65:
                r8.unlock()
                return r5
            L69:
                r9 = move-exception
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.z(java.lang.Object, int, java.lang.Object):boolean");
        }

        void q() {
        }

        @GuardedBy("this")
        void r() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i4) {
            super(mapMakerInternalMap, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: I */
        public StrongKeyDummyValueSegment<K> F() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i4) {
            super(mapMakerInternalMap, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: I */
        public StrongKeyStrongValueSegment<K, V> F() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i4) {
            super(mapMakerInternalMap, i4);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void q() {
            b((ReferenceQueue<V>) this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void r() {
            g(this.queueForValues);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: J */
        public StrongKeyWeakValueSegment<K, V> F() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i4) {
            super(mapMakerInternalMap, i4);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void q() {
            b((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void r() {
            f(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: J */
        public WeakKeyDummyValueSegment<K> F() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i4) {
            super(mapMakerInternalMap, i4);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void q() {
            b((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void r() {
            f(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: J */
        public WeakKeyStrongValueSegment<K, V> F() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i4) {
            super(mapMakerInternalMap, i4);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void q() {
            b((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void r() {
            f(this.queueForKeys);
            g(this.queueForValues);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* renamed from: K */
        public WeakKeyWeakValueSegment<K, V> F() {
            return this;
        }
    }
}
