package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@DoNotMock("Use ImmutableMap.of or another implementation")
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: e  reason: collision with root package name */
    static final Map.Entry<?, ?>[] f26892e = new Map.Entry[0];
    @RetainedWith
    @CheckForNull
    @LazyInit

    /* renamed from: a  reason: collision with root package name */
    private transient ImmutableSet<Map.Entry<K, V>> f26893a;
    @RetainedWith
    @CheckForNull
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient ImmutableSet<K> f26894b;
    @RetainedWith
    @CheckForNull
    @LazyInit

    /* renamed from: c  reason: collision with root package name */
    private transient ImmutableCollection<V> f26895c;
    @CheckForNull
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private transient ImmutableSetMultimap<K, V> f26896d;

    @DoNotMock
    /* loaded from: classes5.dex */
    public static class Builder<K, V> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        Comparator<? super V> f26898a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f26899b;

        /* renamed from: c  reason: collision with root package name */
        int f26900c;

        /* renamed from: d  reason: collision with root package name */
        boolean f26901d;

        /* renamed from: e  reason: collision with root package name */
        DuplicateKey f26902e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class DuplicateKey {

            /* renamed from: a  reason: collision with root package name */
            private final Object f26903a;

            /* renamed from: b  reason: collision with root package name */
            private final Object f26904b;

            /* renamed from: c  reason: collision with root package name */
            private final Object f26905c;

            /* JADX INFO: Access modifiers changed from: package-private */
            public DuplicateKey(Object obj, Object obj2, Object obj3) {
                this.f26903a = obj;
                this.f26904b = obj2;
                this.f26905c = obj3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f26903a + "=" + this.f26904b + " and " + this.f26903a + "=" + this.f26905c);
            }
        }

        public Builder() {
            this(4);
        }

        private ImmutableMap<K, V> a(boolean z3) {
            Object[] objArr;
            DuplicateKey duplicateKey;
            DuplicateKey duplicateKey2;
            if (z3 && (duplicateKey2 = this.f26902e) != null) {
                throw duplicateKey2.a();
            }
            int i4 = this.f26900c;
            if (this.f26898a == null) {
                objArr = this.f26899b;
            } else {
                if (this.f26901d) {
                    this.f26899b = Arrays.copyOf(this.f26899b, i4 * 2);
                }
                objArr = this.f26899b;
                if (!z3) {
                    objArr = c(objArr, this.f26900c);
                    if (objArr.length < this.f26899b.length) {
                        i4 = objArr.length >>> 1;
                    }
                }
                d(objArr, i4, this.f26898a);
            }
            this.f26901d = true;
            RegularImmutableMap n4 = RegularImmutableMap.n(i4, objArr, this);
            if (z3 && (duplicateKey = this.f26902e) != null) {
                throw duplicateKey.a();
            }
            return n4;
        }

        private void b(int i4) {
            int i5 = i4 * 2;
            Object[] objArr = this.f26899b;
            if (i5 > objArr.length) {
                this.f26899b = Arrays.copyOf(objArr, ImmutableCollection.Builder.a(objArr.length, i5));
                this.f26901d = false;
            }
        }

        private Object[] c(Object[] objArr, int i4) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                Object obj = objArr[i5 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i5);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i4 - bitSet.cardinality()) * 2];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4 * 2) {
                if (bitSet.get(i6 >>> 1)) {
                    i6 += 2;
                } else {
                    int i8 = i7 + 1;
                    int i9 = i6 + 1;
                    Object obj2 = objArr[i6];
                    Objects.requireNonNull(obj2);
                    objArr2[i7] = obj2;
                    i7 = i8 + 1;
                    i6 = i9 + 1;
                    Object obj3 = objArr[i9];
                    Objects.requireNonNull(obj3);
                    objArr2[i8] = obj3;
                }
            }
            return objArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <V> void d(Object[] objArr, int i4, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 2;
                Object obj = objArr[i6];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i6 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i5] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i4, Ordering.from(comparator).onResultOf(Maps.N()));
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = i7 * 2;
                objArr[i8] = entryArr[i7].getKey();
                objArr[i8 + 1] = entryArr[i7].getValue();
            }
        }

        public ImmutableMap<K, V> build() {
            return buildOrThrow();
        }

        public ImmutableMap<K, V> buildKeepingLast() {
            return a(false);
        }

        public ImmutableMap<K, V> buildOrThrow() {
            return a(true);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            boolean z3;
            if (this.f26898a == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "valueComparator was already set");
            this.f26898a = (Comparator) Preconditions.checkNotNull(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k4, V v3) {
            b(this.f26900c + 1);
            CollectPreconditions.a(k4, v3);
            Object[] objArr = this.f26899b;
            int i4 = this.f26900c;
            objArr[i4 * 2] = k4;
            objArr[(i4 * 2) + 1] = v3;
            this.f26900c = i4 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i4) {
            this.f26899b = new Object[i4 * 2];
            this.f26900c = 0;
            this.f26901d = false;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                b(this.f26900c + ((Collection) iterable).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                put(entry);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> e() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                ImmutableMap<K, V> o() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.m();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> f() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection<V> g() {
            return new ImmutableMapValues(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        abstract UnmodifiableIterator<Map.Entry<K, V>> m();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: classes5.dex */
    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> f() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean i() {
            return ImmutableMap.this.i();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean j() {
            return ImmutableMap.this.j();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> m() {
            final UnmodifiableIterator<Map.Entry<K, V>> it = ImmutableMap.this.entrySet().iterator();
            return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(this) { // from class: com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1
                @Override // java.util.Iterator
                /* renamed from: a */
                public Map.Entry<K, ImmutableSet<V>> next() {
                    final Map.Entry entry = (Map.Entry) it.next();
                    return new AbstractMapEntry<K, ImmutableSet<V>>(this) { // from class: com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1.1
                        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        /* renamed from: f */
                        public ImmutableSet<V> getValue() {
                            return ImmutableSet.of(entry.getValue());
                        }

                        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public K getKey() {
                            return (K) entry.getKey();
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        /* renamed from: n */
        public ImmutableSet<V> get(@CheckForNull Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }
    }

    @J2ktIncompatible
    /* loaded from: classes5.dex */
    static class SerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<K, V>> it = immutableMap.entrySet().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i4] = next.getKey();
                objArr2[i4] = next.getValue();
                i4++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        final Object a() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            Builder<K, V> b4 = b(objArr.length);
            for (int i4 = 0; i4 < objArr.length; i4++) {
                b4.put((K) objArr[i4], (V) objArr2[i4]);
            }
            return b4.buildOrThrow();
        }

        Builder<K, V> b(int i4) {
            return new Builder<>(i4);
        }

        final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return a();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            Builder<K, V> b4 = b(immutableSet.size());
            UnmodifiableIterator it = immutableSet.iterator();
            UnmodifiableIterator it2 = ((ImmutableCollection) this.values).iterator();
            while (it.hasNext()) {
                b4.put((K) it.next(), (V) it2.next());
            }
            return b4.buildOrThrow();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, String str, Object obj, Object obj2) {
        if (z3) {
            return;
        }
        throw c(str, obj, obj2);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int i4) {
        CollectPreconditions.b(i4, "expectedSize");
        return new Builder<>(i4);
    }

    static IllegalArgumentException c(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.j()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> h(K k4, V v3) {
        CollectPreconditions.a(k4, v3);
        return new AbstractMap.SimpleImmutableEntry(k4, v3);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.f27343i;
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.f26896d;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(), size(), null);
            this.f26896d = immutableSetMultimap2;
            return immutableSetMultimap2;
        }
        return immutableSetMultimap;
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    abstract ImmutableSet<Map.Entry<K, V>> e();

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return Maps.n(this, obj);
    }

    abstract ImmutableSet<K> f();

    abstract ImmutableCollection<V> g();

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v3) {
        V v4 = get(obj);
        if (v4 != null) {
            return v4;
        }
        return v3;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.b(entrySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnmodifiableIterator<K> l() {
        final UnmodifiableIterator<Map.Entry<K, V>> it = entrySet().iterator();
        return new UnmodifiableIterator<K>(this) { // from class: com.google.common.collect.ImmutableMap.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return (K) ((Map.Entry) it.next()).getKey();
            }
        };
    }

    @Override // java.util.Map
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V put(K k4, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.F(this);
    }

    @J2ktIncompatible
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3) {
        CollectPreconditions.a(k4, v3);
        return RegularImmutableMap.m(1, new Object[]{k4, v3});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f26893a;
        if (immutableSet == null) {
            ImmutableSet<Map.Entry<K, V>> e4 = e();
            this.f26893a = e4;
            return e4;
        }
        return immutableSet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f26894b;
        if (immutableSet == null) {
            ImmutableSet<K> f4 = f();
            this.f26894b = f4;
            return f4;
        }
        return immutableSet;
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f26895c;
        if (immutableCollection == null) {
            ImmutableCollection<V> g4 = g();
            this.f26895c = g4;
            return g4;
        }
        return immutableCollection;
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        return RegularImmutableMap.m(2, new Object[]{k4, v3, k5, v4});
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.putAll(iterable);
        return builder.build();
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        return RegularImmutableMap.m(3, new Object[]{k4, v3, k5, v4, k6, v5});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        return RegularImmutableMap.m(4, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        return RegularImmutableMap.m(5, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        return RegularImmutableMap.m(6, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        return RegularImmutableMap.m(7, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        return RegularImmutableMap.m(8, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10, K k12, V v11) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        CollectPreconditions.a(k12, v11);
        return RegularImmutableMap.m(9, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10, k12, v11});
    }

    public static <K, V> ImmutableMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10, K k12, V v11, K k13, V v12) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        CollectPreconditions.a(k12, v11);
        CollectPreconditions.a(k13, v12);
        return RegularImmutableMap.m(10, new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10, k12, v11, k13, v12});
    }
}
