package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @J2ktIncompatible
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    private transient Map<K, V> f26604a;
    @RetainedWith

    /* renamed from: b  reason: collision with root package name */
    transient AbstractBiMap<V, K> f26605b;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private transient Set<K> f26606c;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private transient Set<V> f26607d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f26608e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class BiMapEntry extends ForwardingMapEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final Map.Entry<K, V> f26612a;

        BiMapEntry(Map.Entry<K, V> entry) {
            this.f26612a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        /* renamed from: f */
        public Map.Entry<K, V> e() {
            return this.f26612a;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v3) {
            AbstractBiMap.this.n(v3);
            Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(v3, getValue())) {
                return v3;
            }
            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v3), "value already present: %s", v3);
            V value = this.f26612a.setValue(v3);
            Preconditions.checkState(Objects.equal(v3, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.v(getKey(), true, value, v3);
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class EntrySet extends ForwardingSet<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final Set<Map.Entry<K, V>> f26614a;

        private EntrySet() {
            this.f26614a = AbstractBiMap.this.f26604a.entrySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return Maps.l(f(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return h(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.o();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<Map.Entry<K, V>> f() {
            return this.f26614a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (this.f26614a.contains(obj) && (obj instanceof Map.Entry)) {
                Map.Entry entry = (Map.Entry) obj;
                ((AbstractBiMap) AbstractBiMap.this.f26605b).f26604a.remove(entry.getValue());
                this.f26614a.remove(entry);
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return o(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return i(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return j();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) l(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @J2ktIncompatible
        @GwtIncompatible
        private static final long serialVersionUID = 0;

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        @J2ktIncompatible
        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            u((AbstractBiMap) objectInputStream.readObject());
        }

        @J2ktIncompatible
        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object e() {
            return super.e();
        }

        @Override // com.google.common.collect.AbstractBiMap
        @ParametricNullness
        K m(@ParametricNullness K k4) {
            return this.f26605b.n(k4);
        }

        @Override // com.google.common.collect.AbstractBiMap
        @ParametricNullness
        V n(@ParametricNullness V v3) {
            return this.f26605b.m(v3);
        }

        @J2ktIncompatible
        @GwtIncompatible
        Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.u(AbstractBiMap.this.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<K> f() {
            return AbstractBiMap.this.f26604a.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (contains(obj)) {
                AbstractBiMap.this.r(obj);
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return o(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return i(collection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class ValueSet extends ForwardingSet<V> {

        /* renamed from: a  reason: collision with root package name */
        final Set<V> f26617a;

        private ValueSet() {
            this.f26617a = AbstractBiMap.this.f26605b.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.O(AbstractBiMap.this.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<V> f() {
            return this.f26617a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return j();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return m();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) l(tArr);
        }
    }

    @CheckForNull
    private V q(@ParametricNullness K k4, @ParametricNullness V v3, boolean z3) {
        m(k4);
        n(v3);
        boolean containsKey = containsKey(k4);
        if (containsKey && Objects.equal(v3, get(k4))) {
            return v3;
        }
        if (z3) {
            inverse().remove(v3);
        } else {
            Preconditions.checkArgument(!containsValue(v3), "value already present: %s", v3);
        }
        V put = this.f26604a.put(k4, v3);
        v(k4, containsKey, put, v3);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ParametricNullness
    @CanIgnoreReturnValue
    public V r(@CheckForNull Object obj) {
        V v3 = (V) NullnessCasts.a(this.f26604a.remove(obj));
        s(v3);
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(@ParametricNullness V v3) {
        this.f26605b.f26604a.remove(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void v(@ParametricNullness K k4, boolean z3, @CheckForNull V v3, @ParametricNullness V v4) {
        if (z3) {
            s(NullnessCasts.a(v3));
        }
        this.f26605b.f26604a.put(v4, k4);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.f26604a.clear();
        this.f26605b.f26604a.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return this.f26605b.containsKey(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f26608e;
        if (set == null) {
            EntrySet entrySet = new EntrySet();
            this.f26608e = entrySet;
            return entrySet;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* renamed from: f */
    public Map<K, V> e() {
        return this.f26604a;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V forcePut(@ParametricNullness K k4, @ParametricNullness V v3) {
        return q(k4, v3, true);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        return this.f26605b;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f26606c;
        if (set == null) {
            KeySet keySet = new KeySet();
            this.f26606c = keySet;
            return keySet;
        }
        return set;
    }

    Iterator<Map.Entry<K, V>> o() {
        final Iterator<Map.Entry<K, V>> it = this.f26604a.entrySet().iterator();
        return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.AbstractBiMap.1
            @CheckForNull

            /* renamed from: a  reason: collision with root package name */
            Map.Entry<K, V> f26609a;

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                Map.Entry<K, V> entry = (Map.Entry) it.next();
                this.f26609a = entry;
                return new BiMapEntry(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                Map.Entry<K, V> entry = this.f26609a;
                if (entry != null) {
                    V value = entry.getValue();
                    it.remove();
                    AbstractBiMap.this.s(value);
                    this.f26609a = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
        };
    }

    AbstractBiMap<V, K> p(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k4, @ParametricNullness V v3) {
        return q(k4, v3, false);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (containsKey(obj)) {
            return r(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Map<K, V> map, Map<V, K> map2) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (this.f26604a == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (this.f26605b == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map == map2) {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        this.f26604a = map;
        this.f26605b = p(map2);
    }

    void u(AbstractBiMap<V, K> abstractBiMap) {
        this.f26605b = abstractBiMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        t(map, map2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> set = this.f26607d;
        if (set == null) {
            ValueSet valueSet = new ValueSet();
            this.f26607d = valueSet;
            return valueSet;
        }
        return set;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.f26604a = map;
        this.f26605b = abstractBiMap;
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    K m(@ParametricNullness K k4) {
        return k4;
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    V n(@ParametricNullness V v3) {
        return v3;
    }
}
