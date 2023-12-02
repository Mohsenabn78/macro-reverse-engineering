package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Synchronized {

    /* loaded from: classes5.dex */
    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        transient Set<Map.Entry<K, Collection<V>>> f27463d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        transient Collection<Collection<V>> f27464e;

        SynchronizedAsMap(Map<K, Collection<V>> map, @CheckForNull Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(@CheckForNull Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.f27463d == null) {
                    this.f27463d = new SynchronizedAsMapEntries(f().entrySet(), this.mutex);
                }
                set = this.f27463d;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.f27464e == null) {
                    this.f27464e = new SynchronizedAsMapValues(f().values(), this.mutex);
                }
                collection = this.f27464e;
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        @CheckForNull
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> A;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(obj);
                A = collection == null ? null : Synchronized.A(collection, this.mutex);
            }
            return A;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, @CheckForNull Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                /* renamed from: b */
                public Collection<V> a(Collection<V> collection) {
                    return Synchronized.A(collection, SynchronizedAsMapValues.this.mutex);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        private transient Set<V> f27469d;
        @RetainedWith
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        private transient BiMap<V, K> f27470e;

        @Override // com.google.common.collect.BiMap
        @CheckForNull
        public V forcePut(@ParametricNullness K k4, @ParametricNullness V v3) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = f().forcePut(k4, v3);
            }
            return forcePut;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        /* renamed from: g */
        public BiMap<K, V> f() {
            return (BiMap) super.f();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap;
            synchronized (this.mutex) {
                if (this.f27470e == null) {
                    this.f27470e = new SynchronizedBiMap(f().inverse(), this.mutex, this);
                }
                biMap = this.f27470e;
            }
            return biMap;
        }

        private SynchronizedBiMap(BiMap<K, V> biMap, @CheckForNull Object obj, @CheckForNull BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.f27470e = biMap2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                if (this.f27469d == null) {
                    this.f27469d = Synchronized.u(f().values(), this.mutex);
                }
                set = this.f27469d;
            }
            return set;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection
        public boolean add(E e4) {
            boolean add;
            synchronized (this.mutex) {
                add = f().add(e4);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = f().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                f().clear();
            }
        }

        public boolean contains(@CheckForNull Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = f().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = f().containsAll(collection);
            }
            return containsAll;
        }

        Collection<E> f() {
            return (Collection) super.e();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = f().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return f().iterator();
        }

        public boolean remove(@CheckForNull Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = f().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = f().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = f().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = f().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = f().toArray();
            }
            return array;
        }

        private SynchronizedCollection(Collection<E> collection, @CheckForNull Object obj) {
            super(collection, obj);
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) f().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* loaded from: classes5.dex */
    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        SynchronizedDeque(Deque<E> deque, @CheckForNull Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e4) {
            synchronized (this.mutex) {
                g().addFirst(e4);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e4) {
            synchronized (this.mutex) {
                g().addLast(e4);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = g().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = g().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = g().getLast();
            }
            return last;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue
        /* renamed from: h */
        public Deque<E> g() {
            return (Deque) super.f();
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e4) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = g().offerFirst(e4);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e4) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = g().offerLast(e4);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = g().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = g().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = g().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        @CheckForNull
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = g().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = g().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e4) {
            synchronized (this.mutex) {
                g().push(e4);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = g().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(@CheckForNull Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = g().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = g().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(@CheckForNull Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = g().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: classes5.dex */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry<K, V> entry, @CheckForNull Object obj) {
            super(entry, obj);
        }

        @Override // java.util.Map.Entry
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        Map.Entry<K, V> f() {
            return (Map.Entry) super.e();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = f().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = f().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            V value;
            synchronized (this.mutex) {
                value = f().setValue(v3);
            }
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> list, @CheckForNull Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i4, E e4) {
            synchronized (this.mutex) {
                f().add(i4, e4);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i4, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = f().addAll(i4, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: g */
        public List<E> f() {
            return (List) super.f();
        }

        @Override // java.util.List
        public E get(int i4) {
            E e4;
            synchronized (this.mutex) {
                e4 = f().get(i4);
            }
            return e4;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = f().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = f().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return f().listIterator();
        }

        @Override // java.util.List
        public E remove(int i4) {
            E remove;
            synchronized (this.mutex) {
                remove = f().remove(i4);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i4, E e4) {
            E e5;
            synchronized (this.mutex) {
                e5 = f().set(i4, e4);
            }
            return e5;
        }

        @Override // java.util.List
        public List<E> subList(int i4, int i5) {
            List<E> j4;
            synchronized (this.mutex) {
                j4 = Synchronized.j(f().subList(i4, i5), this.mutex);
            }
            return j4;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i4) {
            return f().listIterator(i4);
        }
    }

    /* loaded from: classes5.dex */
    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, @CheckForNull Object obj) {
            super(listMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap
        /* renamed from: g */
        public ListMultimap<K, V> f() {
            return (ListMultimap) super.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> get(K k4) {
            List<V> j4;
            synchronized (this.mutex) {
                j4 = Synchronized.j(f().get((ListMultimap<K, V>) k4), this.mutex);
            }
            return j4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> removeAll(@CheckForNull Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = f().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List<V> replaceValues(K k4, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = f().replaceValues((ListMultimap<K, V>) k4, (Iterable) iterable);
            }
            return replaceValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        transient Set<K> f27471a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        transient Collection<V> f27472b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        transient Set<Map.Entry<K, V>> f27473c;

        SynchronizedMap(Map<K, V> map, @CheckForNull Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                f().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = f().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = f().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.f27473c == null) {
                    this.f27473c = Synchronized.u(f().entrySet(), this.mutex);
                }
                set = this.f27473c;
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        Map<K, V> f() {
            return (Map) super.e();
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v3;
            synchronized (this.mutex) {
                v3 = f().get(obj);
            }
            return v3;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = f().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.f27471a == null) {
                    this.f27471a = Synchronized.u(f().keySet(), this.mutex);
                }
                set = this.f27471a;
            }
            return set;
        }

        @Override // java.util.Map
        @CheckForNull
        public V put(K k4, V v3) {
            V put;
            synchronized (this.mutex) {
                put = f().put(k4, v3);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                f().putAll(map);
            }
        }

        @Override // java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = f().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = f().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.f27472b == null) {
                    this.f27472b = Synchronized.h(f().values(), this.mutex);
                }
                collection = this.f27472b;
            }
            return collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SynchronizedObject implements Serializable {
        @J2ktIncompatible
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object obj, @CheckForNull Object obj2) {
            this.delegate = Preconditions.checkNotNull(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        @J2ktIncompatible
        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        Object e() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue<E> queue, @CheckForNull Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = f().element();
            }
            return element;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: g */
        public Queue<E> f() {
            return (Queue) super.f();
        }

        @Override // java.util.Queue
        public boolean offer(E e4) {
            boolean offer;
            synchronized (this.mutex) {
                offer = f().offer(e4);
            }
            return offer;
        }

        @Override // java.util.Queue
        @CheckForNull
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = f().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        @CheckForNull
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = f().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = f().remove();
            }
            return remove;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> list, @CheckForNull Object obj) {
            super(list, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> set, @CheckForNull Object obj) {
            super(set, obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: g */
        public Set<E> f() {
            return (Set) super.f();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        transient Set<Map.Entry<K, V>> f27485f;

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, @CheckForNull Object obj) {
            super(setMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap
        /* renamed from: g */
        public SetMultimap<K, V> f() {
            return (SetMultimap) super.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.f27485f == null) {
                    this.f27485f = Synchronized.u(f().entries(), this.mutex);
                }
                set = this.f27485f;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> get(K k4) {
            Set<V> u3;
            synchronized (this.mutex) {
                u3 = Synchronized.u(f().get((SetMultimap<K, V>) k4), this.mutex);
            }
            return u3;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> removeAll(@CheckForNull Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = f().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set<V> replaceValues(K k4, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = f().replaceValues((SetMultimap<K, V>) k4, (Iterable) iterable);
            }
            return replaceValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, @CheckForNull Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = f().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = f().firstKey();
            }
            return firstKey;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        /* renamed from: g */
        public SortedMap<K, V> f() {
            return (SortedMap) super.f();
        }

        public SortedMap<K, V> headMap(K k4) {
            SortedMap<K, V> w3;
            synchronized (this.mutex) {
                w3 = Synchronized.w(f().headMap(k4), this.mutex);
            }
            return w3;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = f().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k4, K k5) {
            SortedMap<K, V> w3;
            synchronized (this.mutex) {
                w3 = Synchronized.w(f().subMap(k4, k5), this.mutex);
            }
            return w3;
        }

        public SortedMap<K, V> tailMap(K k4) {
            SortedMap<K, V> w3;
            synchronized (this.mutex) {
                w3 = Synchronized.w(f().tailMap(k4), this.mutex);
            }
            return w3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet<E> sortedSet, @CheckForNull Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = g().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = g().first();
            }
            return first;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet
        /* renamed from: h */
        public SortedSet<E> g() {
            return (SortedSet) super.f();
        }

        public SortedSet<E> headSet(E e4) {
            SortedSet<E> x3;
            synchronized (this.mutex) {
                x3 = Synchronized.x(g().headSet(e4), this.mutex);
            }
            return x3;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = g().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e4, E e5) {
            SortedSet<E> x3;
            synchronized (this.mutex) {
                x3 = Synchronized.x(g().subSet(e4, e5), this.mutex);
            }
            return x3;
        }

        public SortedSet<E> tailSet(E e4) {
            SortedSet<E> x3;
            synchronized (this.mutex) {
                x3 = Synchronized.x(g().tailSet(e4), this.mutex);
            }
            return x3;
        }
    }

    /* loaded from: classes5.dex */
    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @CheckForNull Object obj) {
            super(sortedSetMultimap, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap
        /* renamed from: h */
        public SortedSetMultimap<K, V> g() {
            return (SortedSetMultimap) super.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        @CheckForNull
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = g().valueComparator();
            }
            return valueComparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> get(K k4) {
            SortedSet<V> x3;
            synchronized (this.mutex) {
                x3 = Synchronized.x(g().get((SortedSetMultimap<K, V>) k4), this.mutex);
            }
            return x3;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> removeAll(@CheckForNull Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = g().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet<V> replaceValues(K k4, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = g().replaceValues((SortedSetMultimap<K, V>) k4, (Iterable) iterable);
            }
            return replaceValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        SynchronizedTable(Table<R, C, V> table, @CheckForNull Object obj) {
            super(table, obj);
        }

        @Override // com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            Set<Table.Cell<R, C, V>> u3;
            synchronized (this.mutex) {
                u3 = Synchronized.u(f().cellSet(), this.mutex);
            }
            return u3;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.mutex) {
                f().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> column(@ParametricNullness C c4) {
            Map<R, V> l4;
            synchronized (this.mutex) {
                l4 = Synchronized.l(f().column(c4), this.mutex);
            }
            return l4;
        }

        @Override // com.google.common.collect.Table
        public Set<C> columnKeySet() {
            Set<C> u3;
            synchronized (this.mutex) {
                u3 = Synchronized.u(f().columnKeySet(), this.mutex);
            }
            return u3;
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> l4;
            synchronized (this.mutex) {
                l4 = Synchronized.l(Maps.transformValues(f().columnMap(), new Function<Map<R, V>, Map<R, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.2
                    @Override // com.google.common.base.Function
                    /* renamed from: a */
                    public Map<R, V> apply(Map<R, V> map) {
                        return Synchronized.l(map, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return l4;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = f().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(@CheckForNull Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = f().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(@CheckForNull Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = f().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = f().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Table
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        Table<R, C, V> f() {
            return (Table) super.e();
        }

        @Override // com.google.common.collect.Table
        @CheckForNull
        public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            V v3;
            synchronized (this.mutex) {
                v3 = f().get(obj, obj2);
            }
            return v3;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = f().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Table
        @CheckForNull
        public V put(@ParametricNullness R r4, @ParametricNullness C c4, @ParametricNullness V v3) {
            V put;
            synchronized (this.mutex) {
                put = f().put(r4, c4, v3);
            }
            return put;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.mutex) {
                f().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = f().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> row(@ParametricNullness R r4) {
            Map<C, V> l4;
            synchronized (this.mutex) {
                l4 = Synchronized.l(f().row(r4), this.mutex);
            }
            return l4;
        }

        @Override // com.google.common.collect.Table
        public Set<R> rowKeySet() {
            Set<R> u3;
            synchronized (this.mutex) {
                u3 = Synchronized.u(f().rowKeySet(), this.mutex);
            }
            return u3;
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> l4;
            synchronized (this.mutex) {
                l4 = Synchronized.l(Maps.transformValues(f().rowMap(), new Function<Map<C, V>, Map<C, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.1
                    @Override // com.google.common.base.Function
                    /* renamed from: a */
                    public Map<C, V> apply(Map<C, V> map) {
                        return Synchronized.l(map, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return l4;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = f().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public Collection<V> values() {
            Collection<V> h4;
            synchronized (this.mutex) {
                h4 = Synchronized.h(f().values(), this.mutex);
            }
            return h4;
        }
    }

    private Synchronized() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> A(Collection<E> collection, @CheckForNull Object obj) {
        if (collection instanceof SortedSet) {
            return x((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return u((Set) collection, obj);
        }
        if (collection instanceof List) {
            return j((List) collection, obj);
        }
        return h(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> B(Set<E> set, @CheckForNull Object obj) {
        if (set instanceof SortedSet) {
            return x((SortedSet) set, obj);
        }
        return u(set, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> BiMap<K, V> g(BiMap<K, V> biMap, @CheckForNull Object obj) {
        if (!(biMap instanceof SynchronizedBiMap) && !(biMap instanceof ImmutableBiMap)) {
            return new SynchronizedBiMap(biMap, obj, null);
        }
        return biMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> h(Collection<E> collection, @CheckForNull Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Deque<E> i(Deque<E> deque, @CheckForNull Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> List<E> j(List<E> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list, obj);
        }
        return new SynchronizedList(list, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ListMultimap<K, V> k(ListMultimap<K, V> listMultimap, @CheckForNull Object obj) {
        if (!(listMultimap instanceof SynchronizedListMultimap) && !(listMultimap instanceof BaseImmutableMultimap)) {
            return new SynchronizedListMultimap(listMultimap, obj);
        }
        return listMultimap;
    }

    @VisibleForTesting
    static <K, V> Map<K, V> l(Map<K, V> map, @CheckForNull Object obj) {
        return new SynchronizedMap(map, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Multimap<K, V> m(Multimap<K, V> multimap, @CheckForNull Object obj) {
        if (!(multimap instanceof SynchronizedMultimap) && !(multimap instanceof BaseImmutableMultimap)) {
            return new SynchronizedMultimap(multimap, obj);
        }
        return multimap;
    }

    static <E> Multiset<E> n(Multiset<E> multiset, @CheckForNull Object obj) {
        if (!(multiset instanceof SynchronizedMultiset) && !(multiset instanceof ImmutableMultiset)) {
            return new SynchronizedMultiset(multiset, obj);
        }
        return multiset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> o(NavigableMap<K, V> navigableMap) {
        return p(navigableMap, null);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> p(NavigableMap<K, V> navigableMap, @CheckForNull Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static <E> NavigableSet<E> q(NavigableSet<E> navigableSet) {
        return r(navigableSet, null);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> r(NavigableSet<E> navigableSet, @CheckForNull Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    public static <K, V> Map.Entry<K, V> s(@CheckForNull Map.Entry<K, V> entry, @CheckForNull Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Queue<E> t(Queue<E> queue, @CheckForNull Object obj) {
        if (!(queue instanceof SynchronizedQueue)) {
            return new SynchronizedQueue(queue, obj);
        }
        return queue;
    }

    @VisibleForTesting
    static <E> Set<E> u(Set<E> set, @CheckForNull Object obj) {
        return new SynchronizedSet(set, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> SetMultimap<K, V> v(SetMultimap<K, V> setMultimap, @CheckForNull Object obj) {
        if (!(setMultimap instanceof SynchronizedSetMultimap) && !(setMultimap instanceof BaseImmutableMultimap)) {
            return new SynchronizedSetMultimap(setMultimap, obj);
        }
        return setMultimap;
    }

    static <K, V> SortedMap<K, V> w(SortedMap<K, V> sortedMap, @CheckForNull Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> SortedSet<E> x(SortedSet<E> sortedSet, @CheckForNull Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> SortedSetMultimap<K, V> y(SortedSetMultimap<K, V> sortedSetMultimap, @CheckForNull Object obj) {
        if (sortedSetMultimap instanceof SynchronizedSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R, C, V> Table<R, C, V> z(Table<R, C, V> table, @CheckForNull Object obj) {
        return new SynchronizedTable(table, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @CheckForNull Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            boolean l4;
            synchronized (this.mutex) {
                l4 = Maps.l(f(), obj);
            }
            return l4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean b4;
            synchronized (this.mutex) {
                b4 = Collections2.b(f(), collection);
            }
            return b4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            boolean a4;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                a4 = Sets.a(f(), obj);
            }
            return a4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                /* renamed from: b */
                public Map.Entry<K, Collection<V>> a(final Map.Entry<K, Collection<V>> entry) {
                    return new ForwardingMapEntry<K, Collection<V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        /* renamed from: f */
                        public Map.Entry<K, Collection<V>> e() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        /* renamed from: h */
                        public Collection<V> getValue() {
                            return Synchronized.A((Collection) entry.getValue(), SynchronizedAsMapEntries.this.mutex);
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            boolean y3;
            synchronized (this.mutex) {
                y3 = Maps.y(f(), obj);
            }
            return y3;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = Iterators.removeAll(f().iterator(), collection);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = Iterators.retainAll(f().iterator(), collection);
            }
            return retainAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] e4;
            synchronized (this.mutex) {
                e4 = ObjectArrays.e(f());
            }
            return e4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) ObjectArrays.f(f(), tArr);
            }
            return tArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        transient Set<K> f27474a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        transient Collection<V> f27475b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        transient Collection<Map.Entry<K, V>> f27476c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        transient Map<K, Collection<V>> f27477d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        transient Multiset<K> f27478e;

        SynchronizedMultimap(Multimap<K, V> multimap, @CheckForNull Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.f27477d == null) {
                    this.f27477d = new SynchronizedAsMap(f().asMap(), this.mutex);
                }
                map = this.f27477d;
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.mutex) {
                f().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = f().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(@CheckForNull Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = f().containsKey(obj);
            }
            return containsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = f().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.f27476c == null) {
                    this.f27476c = Synchronized.A(f().entries(), this.mutex);
                }
                collection = this.f27476c;
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        Multimap<K, V> f() {
            return (Multimap) super.e();
        }

        public Collection<V> get(@ParametricNullness K k4) {
            Collection<V> A;
            synchronized (this.mutex) {
                A = Synchronized.A(f().get(k4), this.mutex);
            }
            return A;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = f().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.f27474a == null) {
                    this.f27474a = Synchronized.B(f().keySet(), this.mutex);
                }
                set = this.f27474a;
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset;
            synchronized (this.mutex) {
                if (this.f27478e == null) {
                    this.f27478e = Synchronized.n(f().keys(), this.mutex);
                }
                multiset = this.f27478e;
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(@ParametricNullness K k4, @ParametricNullness V v3) {
            boolean put;
            synchronized (this.mutex) {
                put = f().put(k4, v3);
            }
            return put;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(@ParametricNullness K k4, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = f().putAll(k4, iterable);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = f().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(@CheckForNull Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = f().removeAll(obj);
            }
            return removeAll;
        }

        public Collection<V> replaceValues(@ParametricNullness K k4, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = f().replaceValues(k4, iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = f().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.f27475b == null) {
                    this.f27475b = Synchronized.h(f().values(), this.mutex);
                }
                collection = this.f27475b;
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = f().putAll(multimap);
            }
            return putAll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        transient Set<E> f27479a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        transient Set<Multiset.Entry<E>> f27480b;

        SynchronizedMultiset(Multiset<E> multiset, @CheckForNull Object obj) {
            super(multiset, obj);
        }

        @Override // com.google.common.collect.Multiset
        public int add(@ParametricNullness E e4, int i4) {
            int add;
            synchronized (this.mutex) {
                add = f().add(e4, i4);
            }
            return add;
        }

        @Override // com.google.common.collect.Multiset
        public int count(@CheckForNull Object obj) {
            int count;
            synchronized (this.mutex) {
                count = f().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                if (this.f27479a == null) {
                    this.f27479a = Synchronized.B(f().elementSet(), this.mutex);
                }
                set = this.f27479a;
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set;
            synchronized (this.mutex) {
                if (this.f27480b == null) {
                    this.f27480b = Synchronized.B(f().entrySet(), this.mutex);
                }
                set = this.f27480b;
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = f().equals(obj);
            }
            return equals;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: g */
        public Multiset<E> f() {
            return (Multiset) super.f();
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = f().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(@CheckForNull Object obj, int i4) {
            int remove;
            synchronized (this.mutex) {
                remove = f().remove(obj, i4);
            }
            return remove;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(@ParametricNullness E e4, int i4) {
            int count;
            synchronized (this.mutex) {
                count = f().setCount(e4, i4);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(@ParametricNullness E e4, int i4, int i5) {
            boolean count;
            synchronized (this.mutex) {
                count = f().setCount(e4, i4, i5);
            }
            return count;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        transient NavigableSet<K> f27481d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        transient NavigableMap<K, V> f27482e;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        transient NavigableSet<K> f27483f;

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @CheckForNull Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(K k4) {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().ceilingEntry(k4), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(K k4) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = g().ceilingKey(k4);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                NavigableSet<K> navigableSet = this.f27481d;
                if (navigableSet == null) {
                    NavigableSet<K> r4 = Synchronized.r(g().descendingKeySet(), this.mutex);
                    this.f27481d = r4;
                    return r4;
                }
                return navigableSet;
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                NavigableMap<K, V> navigableMap = this.f27482e;
                if (navigableMap == null) {
                    NavigableMap<K, V> p4 = Synchronized.p(g().descendingMap(), this.mutex);
                    this.f27482e = p4;
                    return p4;
                }
                return navigableMap;
            }
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().firstEntry(), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> floorEntry(K k4) {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().floorEntry(k4), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(K k4) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = g().floorKey(k4);
            }
            return floorKey;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap
        /* renamed from: h */
        public NavigableMap<K, V> g() {
            return (NavigableMap) super.f();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k4, boolean z3) {
            NavigableMap<K, V> p4;
            synchronized (this.mutex) {
                p4 = Synchronized.p(g().headMap(k4, z3), this.mutex);
            }
            return p4;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> higherEntry(K k4) {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().higherEntry(k4), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(K k4) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = g().higherKey(k4);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().lastEntry(), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> lowerEntry(K k4) {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().lowerEntry(k4), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(K k4) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = g().lowerKey(k4);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                NavigableSet<K> navigableSet = this.f27483f;
                if (navigableSet == null) {
                    NavigableSet<K> r4 = Synchronized.r(g().navigableKeySet(), this.mutex);
                    this.f27483f = r4;
                    return r4;
                }
                return navigableSet;
            }
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().pollFirstEntry(), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> s3;
            synchronized (this.mutex) {
                s3 = Synchronized.s(g().pollLastEntry(), this.mutex);
            }
            return s3;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k4, boolean z3, K k5, boolean z4) {
            NavigableMap<K, V> p4;
            synchronized (this.mutex) {
                p4 = Synchronized.p(g().subMap(k4, z3, k5, z4), this.mutex);
            }
            return p4;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k4, boolean z3) {
            NavigableMap<K, V> p4;
            synchronized (this.mutex) {
                p4 = Synchronized.p(g().tailMap(k4, z3), this.mutex);
            }
            return p4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k4) {
            return headMap(k4, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k4, K k5) {
            return subMap(k4, true, k5, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k4) {
            return tailMap(k4, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        transient NavigableSet<E> f27484a;

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, @CheckForNull Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(E e4) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = h().ceiling(e4);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return h().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                NavigableSet<E> navigableSet = this.f27484a;
                if (navigableSet == null) {
                    NavigableSet<E> r4 = Synchronized.r(h().descendingSet(), this.mutex);
                    this.f27484a = r4;
                    return r4;
                }
                return navigableSet;
            }
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(E e4) {
            E floor;
            synchronized (this.mutex) {
                floor = h().floor(e4);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e4, boolean z3) {
            NavigableSet<E> r4;
            synchronized (this.mutex) {
                r4 = Synchronized.r(h().headSet(e4, z3), this.mutex);
            }
            return r4;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(E e4) {
            E higher;
            synchronized (this.mutex) {
                higher = h().higher(e4);
            }
            return higher;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet
        /* renamed from: i */
        public NavigableSet<E> h() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(E e4) {
            E lower;
            synchronized (this.mutex) {
                lower = h().lower(e4);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = h().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = h().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e4, boolean z3, E e5, boolean z4) {
            NavigableSet<E> r4;
            synchronized (this.mutex) {
                r4 = Synchronized.r(h().subSet(e4, z3, e5, z4), this.mutex);
            }
            return r4;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e4, boolean z3) {
            NavigableSet<E> r4;
            synchronized (this.mutex) {
                r4 = Synchronized.r(h().tailSet(e4, z3), this.mutex);
            }
            return r4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e4) {
            return headSet(e4, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e4) {
            return tailSet(e4, true);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e4, E e5) {
            return subSet(e4, true, e5, false);
        }
    }
}
