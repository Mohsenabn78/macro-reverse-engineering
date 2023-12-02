package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.Weak;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    @J2ktIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: f  reason: collision with root package name */
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> f26912f;

    /* renamed from: g  reason: collision with root package name */
    final transient int f26913g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        @Weak
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return this.multimap.p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.i();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    /* loaded from: classes5.dex */
    static class FieldSettersHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Serialization.FieldSetter<ImmutableMultimap> f26924a = Serialization.a(ImmutableMultimap.class, "map");

        /* renamed from: b  reason: collision with root package name */
        static final Serialization.FieldSetter<ImmutableMultimap> f26925b = Serialization.a(ImmutableMultimap.class, "size");

        FieldSettersHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        @J2ktIncompatible
        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.f26912f.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset
        Multiset.Entry<K> j(int i4) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.f26912f.entrySet().asList().get(i4);
            return Multisets.immutableEntry(entry.getKey(), entry.getValue().size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        @J2ktIncompatible
        @GwtIncompatible
        Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    /* loaded from: classes5.dex */
    private static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        Object readResolve() {
            return this.multimap.keys();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        @J2ktIncompatible
        private static final long serialVersionUID = 0;
        @Weak

        /* renamed from: b  reason: collision with root package name */
        private final transient ImmutableMultimap<K, V> f26926b;

        Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f26926b = immutableMultimap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public int a(Object[] objArr, int i4) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> it = this.f26926b.f26912f.values().iterator();
            while (it.hasNext()) {
                i4 = it.next().a(objArr, i4);
            }
            return i4;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f26926b.containsValue(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f26926b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<V> iterator() {
            return this.f26926b.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i4) {
        this.f26912f = immutableMap;
        this.f26913g = i4;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.p()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((Multimap) multimap);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f26912f.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj != null && super.containsValue(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> f() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public abstract ImmutableCollection<V> get(K k4);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: l */
    public ImmutableCollection<Map.Entry<K, V>> e() {
        return new EntryCollection(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: m */
    public ImmutableMultiset<K> g() {
        return new Keys();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: n */
    public ImmutableCollection<V> h() {
        return new Values(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: o */
    public UnmodifiableIterator<Map.Entry<K, V>> i() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableMultimap.1

            /* renamed from: a  reason: collision with root package name */
            final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f26914a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            K f26915b = null;

            /* renamed from: c  reason: collision with root package name */
            Iterator<V> f26916c = Iterators.f();

            {
                this.f26914a = ImmutableMultimap.this.f26912f.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (!this.f26916c.hasNext()) {
                    Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f26914a.next();
                    this.f26915b = next.getKey();
                    this.f26916c = next.getValue().iterator();
                }
                K k4 = this.f26915b;
                Objects.requireNonNull(k4);
                return Maps.immutableEntry(k4, this.f26916c.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.f26916c.hasNext() && !this.f26914a.hasNext()) {
                    return false;
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f26912f.j();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean put(K k4, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean putAll(K k4, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: q */
    public UnmodifiableIterator<V> j() {
        return new UnmodifiableIterator<V>() { // from class: com.google.common.collect.ImmutableMultimap.2

            /* renamed from: a  reason: collision with root package name */
            Iterator<? extends ImmutableCollection<V>> f26918a;

            /* renamed from: b  reason: collision with root package name */
            Iterator<V> f26919b = Iterators.f();

            {
                this.f26918a = ImmutableMultimap.this.f26912f.values().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.f26919b.hasNext() && !this.f26918a.hasNext()) {
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public V next() {
                if (!this.f26919b.hasNext()) {
                    this.f26919b = this.f26918a.next().iterator();
                }
                return this.f26919b.next();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f26913g;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @DoNotMock
    /* loaded from: classes5.dex */
    public static class Builder<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final Map<K, Collection<V>> f26921a = Platform.i();
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Comparator<? super K> f26922b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Comparator<? super V> f26923c;

        Collection<V> a() {
            return new ArrayList();
        }

        public ImmutableMultimap<K, V> build() {
            Collection entrySet = this.f26921a.entrySet();
            Comparator<? super K> comparator = this.f26922b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).a().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.r(entrySet, this.f26923c);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            this.f26922b = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            this.f26923c = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k4, V v3) {
            CollectPreconditions.a(k4, v3);
            Collection<V> collection = this.f26921a.get(k4);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f26921a;
                Collection<V> a4 = a();
                map.put(k4, a4);
                collection = a4;
            }
            collection.add(v3);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                put(entry);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k4, Iterable<? extends V> iterable) {
            if (k4 != null) {
                Collection<V> collection = this.f26921a.get(k4);
                if (collection != null) {
                    for (V v3 : iterable) {
                        CollectPreconditions.a(k4, v3);
                        collection.add(v3);
                    }
                    return this;
                }
                Iterator<? extends V> it = iterable.iterator();
                if (it.hasNext()) {
                    Collection<V> a4 = a();
                    while (it.hasNext()) {
                        V next = it.next();
                        CollectPreconditions.a(k4, next);
                        a4.add(next);
                    }
                    this.f26921a.put(k4, a4);
                    return this;
                }
                return this;
            }
            throw new NullPointerException("null key in entry: null=" + Iterables.toString(iterable));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k4, V... vArr) {
            return putAll((Builder<K, V>) k4, Arrays.asList(vArr));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k4, V v3) {
        return ImmutableListMultimap.of((Object) k4, (Object) v3);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return (ImmutableMap<K, ? extends ImmutableCollection<V>>) this.f26912f;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.f26912f.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public ImmutableCollection<V> removeAll(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k4, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k4, V v3, K k5, V v4) {
        return ImmutableListMultimap.of((Object) k4, (Object) v3, (Object) k5, (Object) v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5) {
        return ImmutableListMultimap.of((Object) k4, (Object) v3, (Object) k5, (Object) v4, (Object) k6, (Object) v5);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        return ImmutableListMultimap.of((Object) k4, (Object) v3, (Object) k5, (Object) v4, (Object) k6, (Object) v5, (Object) k7, (Object) v6);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7) {
        return ImmutableListMultimap.of((Object) k4, (Object) v3, (Object) k5, (Object) v4, (Object) k6, (Object) v5, (Object) k7, (Object) v6, (Object) k8, (Object) v7);
    }
}
