package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<Comparable> f26959i = Ordering.natural();

    /* renamed from: j  reason: collision with root package name */
    private static final ImmutableSortedMap<Comparable, Object> f26960j = new ImmutableSortedMap<>(ImmutableSortedSet.q(Ordering.natural()), ImmutableList.of());
    private static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    private final transient RegularImmutableSortedSet<K> f26961f;

    /* renamed from: g  reason: collision with root package name */
    private final transient ImmutableList<V> f26962g;
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    private transient ImmutableSortedMap<K, V> f26963h;

    /* loaded from: classes5.dex */
    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {

        /* renamed from: f  reason: collision with root package name */
        private transient Object[] f26964f;

        /* renamed from: g  reason: collision with root package name */
        private transient Object[] f26965g;

        /* renamed from: h  reason: collision with root package name */
        private final Comparator<? super K> f26966h;

        public Builder(Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        private void b(int i4) {
            Object[] objArr = this.f26964f;
            if (i4 > objArr.length) {
                int a4 = ImmutableCollection.Builder.a(objArr.length, i4);
                this.f26964f = Arrays.copyOf(this.f26964f, a4);
                this.f26965g = Arrays.copyOf(this.f26965g, a4);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        private Builder(Comparator<? super K> comparator, int i4) {
            this.f26966h = (Comparator) Preconditions.checkNotNull(comparator);
            this.f26964f = new Object[i4];
            this.f26965g = new Object[i4];
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @DoNotCall
        @Deprecated
        public final ImmutableSortedMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> buildOrThrow() {
            int i4;
            int i5 = this.f26900c;
            if (i5 != 0) {
                if (i5 != 1) {
                    Object[] copyOf = Arrays.copyOf(this.f26964f, i5);
                    Arrays.sort(copyOf, this.f26966h);
                    Object[] objArr = new Object[this.f26900c];
                    for (int i6 = 0; i6 < this.f26900c; i6++) {
                        if (i6 > 0) {
                            if (this.f26966h.compare(copyOf[i6 - 1], copyOf[i6]) == 0) {
                                throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i4] + " and " + copyOf[i6]);
                            }
                        }
                        Object obj = this.f26964f[i6];
                        Objects.requireNonNull(obj);
                        int binarySearch = Arrays.binarySearch(copyOf, obj, this.f26966h);
                        Object obj2 = this.f26965g[i6];
                        Objects.requireNonNull(obj2);
                        objArr[binarySearch] = obj2;
                    }
                    return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.g(copyOf), this.f26966h), ImmutableList.g(objArr));
                }
                Comparator<? super K> comparator = this.f26966h;
                Object obj3 = this.f26964f[0];
                Objects.requireNonNull(obj3);
                Object obj4 = this.f26965g[0];
                Objects.requireNonNull(obj4);
                return ImmutableSortedMap.x(comparator, obj3, obj4);
            }
            return ImmutableSortedMap.r(this.f26966h);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k4, V v3) {
            b(this.f26900c + 1);
            CollectPreconditions.a(k4, v3);
            Object[] objArr = this.f26964f;
            int i4 = this.f26900c;
            objArr[i4] = k4;
            this.f26965g[i4] = v3;
            this.f26900c = i4 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }
    }

    @J2ktIncompatible
    /* loaded from: classes5.dex */
    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        SerializedForm(ImmutableSortedMap<K, V> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* renamed from: c */
        public Builder<K, V> b(int i4) {
            return new Builder<>(this.comparator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return q(map, (Ordering) f26959i);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = f26959i;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.j()) {
                return immutableSortedMap;
            }
        }
        return s(comparator, true, sortedMap.entrySet());
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) f26960j;
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    private static <K, V> ImmutableSortedMap<K, V> q(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z3 = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 == null) {
                if (comparator == f26959i) {
                    z3 = true;
                }
            } else {
                z3 = comparator.equals(comparator2);
            }
        }
        if (z3 && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.j()) {
                return immutableSortedMap;
            }
        }
        return s(comparator, z3, map.entrySet());
    }

    static <K, V> ImmutableSortedMap<K, V> r(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.q(comparator), ImmutableList.of());
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    private static <K, V> ImmutableSortedMap<K, V> s(Comparator<? super K> comparator, boolean z3, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.g(iterable, ImmutableMap.f26892e);
        return t(comparator, z3, entryArr, entryArr.length);
    }

    private static <K, V> ImmutableSortedMap<K, V> t(final Comparator<? super K> comparator, boolean z3, Map.Entry<K, V>[] entryArr, int i4) {
        boolean z4;
        if (i4 != 0) {
            if (i4 != 1) {
                Object[] objArr = new Object[i4];
                Object[] objArr2 = new Object[i4];
                if (z3) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        Map.Entry<K, V> entry = entryArr[i5];
                        Objects.requireNonNull(entry);
                        Map.Entry<K, V> entry2 = entry;
                        K key = entry2.getKey();
                        V value = entry2.getValue();
                        CollectPreconditions.a(key, value);
                        objArr[i5] = key;
                        objArr2[i5] = value;
                    }
                } else {
                    Arrays.sort(entryArr, 0, i4, new Comparator() { // from class: com.google.common.collect.d
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int w3;
                            w3 = ImmutableSortedMap.w(comparator, (Map.Entry) obj, (Map.Entry) obj2);
                            return w3;
                        }
                    });
                    Map.Entry<K, V> entry3 = entryArr[0];
                    Objects.requireNonNull(entry3);
                    Map.Entry<K, V> entry4 = entry3;
                    Object key2 = entry4.getKey();
                    objArr[0] = key2;
                    V value2 = entry4.getValue();
                    objArr2[0] = value2;
                    CollectPreconditions.a(objArr[0], value2);
                    int i6 = 1;
                    while (i6 < i4) {
                        Map.Entry<K, V> entry5 = entryArr[i6 - 1];
                        Objects.requireNonNull(entry5);
                        Map.Entry<K, V> entry6 = entry5;
                        Map.Entry<K, V> entry7 = entryArr[i6];
                        Objects.requireNonNull(entry7);
                        Map.Entry<K, V> entry8 = entry7;
                        Object key3 = entry8.getKey();
                        V value3 = entry8.getValue();
                        CollectPreconditions.a(key3, value3);
                        objArr[i6] = key3;
                        objArr2[i6] = value3;
                        if (comparator.compare(key2, key3) != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        ImmutableMap.a(z4, "key", entry6, entry8);
                        i6++;
                        key2 = key3;
                    }
                }
                return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.g(objArr), comparator), ImmutableList.g(objArr2));
            }
            Map.Entry<K, V> entry9 = entryArr[0];
            Objects.requireNonNull(entry9);
            Map.Entry<K, V> entry10 = entry9;
            return x(comparator, entry10.getKey(), entry10.getValue());
        }
        return r(comparator);
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> u(Map.Entry<K, V>... entryArr) {
        return t(Ordering.natural(), false, entryArr, entryArr.length);
    }

    private ImmutableSortedMap<K, V> v(int i4, int i5) {
        if (i4 == 0 && i5 == size()) {
            return this;
        }
        if (i4 == i5) {
            return r(comparator());
        }
        return new ImmutableSortedMap<>(this.f26961f.w(i4, i5), this.f26962g.subList(i4, i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int w(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        Objects.requireNonNull(entry);
        Objects.requireNonNull(entry2);
        return comparator.compare(entry.getKey(), entry2.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> x(Comparator<? super K> comparator, K k4, V v3) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k4), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.of(v3));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k4) {
        return tailMap((ImmutableSortedMap<K, V>) k4, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(K k4) {
        return (K) Maps.v(ceilingEntry(k4));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> e() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<K, V>> l() {
                return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.ImmutableCollection
                    public boolean f() {
                        return true;
                    }

                    @Override // java.util.List
                    /* renamed from: l */
                    public Map.Entry<K, V> get(int i4) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.f26961f.asList().get(i4), ImmutableSortedMap.this.f26962g.get(i4));
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }
                };
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap<K, V> o() {
                return ImmutableSortedMap.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> f() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k4) {
        return headMap((ImmutableSortedMap<K, V>) k4, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(K k4) {
        return (K) Maps.v(floorEntry(k4));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int indexOf = this.f26961f.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.f26962g.get(indexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z3) {
        return headMap((ImmutableSortedMap<K, V>) obj, z3);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k4) {
        return tailMap((ImmutableSortedMap<K, V>) k4, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(K k4) {
        return (K) Maps.v(higherEntry(k4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean j() {
        if (!this.f26961f.f() && !this.f26962g.f()) {
            return false;
        }
        return true;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k4) {
        return headMap((ImmutableSortedMap<K, V>) k4, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(K k4) {
        return (K) Maps.v(lowerEntry(k4));
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f26962g.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z3, Object obj2, boolean z4) {
        return subMap((boolean) obj, z3, (boolean) obj2, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z3) {
        return tailMap((ImmutableSortedMap<K, V>) obj, z3);
    }

    @Override // com.google.common.collect.ImmutableMap
    @J2ktIncompatible
    Object writeReplace() {
        return new SerializedForm(this);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, @CheckForNull ImmutableSortedMap<K, V> immutableSortedMap) {
        this.f26961f = regularImmutableSortedSet;
        this.f26962g = immutableList;
        this.f26963h = immutableSortedMap;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        return x(Ordering.natural(), comparable, obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.f26961f.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.f26963h;
        if (immutableSortedMap == null) {
            if (isEmpty()) {
                return r(Ordering.from(comparator()).reverse());
            }
            return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.f26961f.descendingSet(), this.f26962g.reverse(), this);
        }
        return immutableSortedMap;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.f26961f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ImmutableSortedMap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        return this.f26962g;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return q(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k4) {
        return headMap((ImmutableSortedMap<K, V>) k4, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f26961f;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k4, K k5) {
        return subMap((boolean) k4, true, (boolean) k5, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k4) {
        return tailMap((ImmutableSortedMap<K, V>) k4, true);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) f26959i);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k4, boolean z3) {
        return v(0, this.f26961f.x(Preconditions.checkNotNull(k4), z3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k4, boolean z3, K k5, boolean z4) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(k5);
        Preconditions.checkArgument(comparator().compare(k4, k5) <= 0, "expected fromKey <= toKey but %s > %s", k4, k5);
        return headMap((ImmutableSortedMap<K, V>) k5, z4).tailMap((ImmutableSortedMap<K, V>) k4, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k4, boolean z3) {
        return v(this.f26961f.y(Preconditions.checkNotNull(k4), z3), size());
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return s((Comparator) Preconditions.checkNotNull(comparator), false, iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4), ImmutableMap.h(comparable5, obj5));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4), ImmutableMap.h(comparable5, obj5), ImmutableMap.h(comparable6, obj6));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4), ImmutableMap.h(comparable5, obj5), ImmutableMap.h(comparable6, obj6), ImmutableMap.h(comparable7, obj7));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4), ImmutableMap.h(comparable5, obj5), ImmutableMap.h(comparable6, obj6), ImmutableMap.h(comparable7, obj7), ImmutableMap.h(comparable8, obj8));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8, Comparable comparable9, Object obj9) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4), ImmutableMap.h(comparable5, obj5), ImmutableMap.h(comparable6, obj6), ImmutableMap.h(comparable7, obj7), ImmutableMap.h(comparable8, obj8), ImmutableMap.h(comparable9, obj9));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5, Comparable comparable6, Object obj6, Comparable comparable7, Object obj7, Comparable comparable8, Object obj8, Comparable comparable9, Object obj9, Comparable comparable10, Object obj10) {
        return u(ImmutableMap.h(comparable, obj), ImmutableMap.h(comparable2, obj2), ImmutableMap.h(comparable3, obj3), ImmutableMap.h(comparable4, obj4), ImmutableMap.h(comparable5, obj5), ImmutableMap.h(comparable6, obj6), ImmutableMap.h(comparable7, obj7), ImmutableMap.h(comparable8, obj8), ImmutableMap.h(comparable9, obj9), ImmutableMap.h(comparable10, obj10));
    }
}
