package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    @J2ktIncompatible
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    private transient Node<K, V> f27050f;
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    private transient Node<K, V> f27051g;

    /* renamed from: h  reason: collision with root package name */
    private transient Map<K, KeyList<K, V>> f27052h;

    /* renamed from: i  reason: collision with root package name */
    private transient int f27053i;

    /* renamed from: j  reason: collision with root package name */
    private transient int f27054j;

    /* loaded from: classes5.dex */
    private class DistinctKeyIterator implements Iterator<K> {

        /* renamed from: a  reason: collision with root package name */
        final Set<K> f27061a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f27062b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f27063c;

        /* renamed from: d  reason: collision with root package name */
        int f27064d;

        private DistinctKeyIterator() {
            this.f27061a = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.f27062b = LinkedListMultimap.this.f27050f;
            this.f27064d = LinkedListMultimap.this.f27054j;
        }

        private void a() {
            if (LinkedListMultimap.this.f27054j == this.f27064d) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            if (this.f27062b != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public K next() {
            Node<K, V> node;
            a();
            Node<K, V> node2 = this.f27062b;
            if (node2 != null) {
                this.f27063c = node2;
                this.f27061a.add(node2.f27069a);
                do {
                    node = this.f27062b.f27071c;
                    this.f27062b = node;
                    if (node == null) {
                        break;
                    }
                } while (!this.f27061a.add(node.f27069a));
                return this.f27063c.f27069a;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            a();
            if (this.f27063c != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.x(this.f27063c.f27069a);
            this.f27063c = null;
            this.f27064d = LinkedListMultimap.this.f27054j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class KeyList<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Node<K, V> f27066a;

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f27067b;

        /* renamed from: c  reason: collision with root package name */
        int f27068c;

        KeyList(Node<K, V> node) {
            this.f27066a = node;
            this.f27067b = node;
            node.f27074f = null;
            node.f27073e = null;
            this.f27068c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Node<K, V> extends AbstractMapEntry<K, V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f27069a;
        @ParametricNullness

        /* renamed from: b  reason: collision with root package name */
        V f27070b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f27071c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        Node<K, V> f27072d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        Node<K, V> f27073e;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        Node<K, V> f27074f;

        Node(@ParametricNullness K k4, @ParametricNullness V v3) {
            this.f27069a = k4;
            this.f27070b = v3;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.f27069a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            return this.f27070b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v3) {
            V v4 = this.f27070b;
            this.f27070b = v3;
            return v4;
        }
    }

    /* loaded from: classes5.dex */
    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        int f27075a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f27076b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f27077c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        Node<K, V> f27078d;

        /* renamed from: e  reason: collision with root package name */
        int f27079e;

        NodeIterator(int i4) {
            this.f27079e = LinkedListMultimap.this.f27054j;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i4, size);
            if (i4 >= size / 2) {
                this.f27078d = LinkedListMultimap.this.f27051g;
                this.f27075a = size;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 >= size) {
                        break;
                    }
                    previous();
                    i4 = i5;
                }
            } else {
                this.f27076b = LinkedListMultimap.this.f27050f;
                while (true) {
                    int i6 = i4 - 1;
                    if (i4 <= 0) {
                        break;
                    }
                    next();
                    i4 = i6;
                }
            }
            this.f27077c = null;
        }

        private void b() {
            if (LinkedListMultimap.this.f27054j == this.f27079e) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        /* renamed from: c */
        public Node<K, V> next() {
            b();
            Node<K, V> node = this.f27076b;
            if (node != null) {
                this.f27077c = node;
                this.f27078d = node;
                this.f27076b = node.f27071c;
                this.f27075a++;
                return node;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        /* renamed from: d */
        public Node<K, V> previous() {
            b();
            Node<K, V> node = this.f27078d;
            if (node != null) {
                this.f27077c = node;
                this.f27076b = node;
                this.f27078d = node.f27072d;
                this.f27075a--;
                return node;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        void f(@ParametricNullness V v3) {
            boolean z3;
            if (this.f27077c != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            this.f27077c.f27070b = v3;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            if (this.f27076b != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            if (this.f27078d != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f27075a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f27075a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            boolean z3;
            b();
            if (this.f27077c != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
            Node<K, V> node = this.f27077c;
            if (node != this.f27076b) {
                this.f27078d = node.f27072d;
                this.f27075a--;
            } else {
                this.f27076b = node.f27071c;
            }
            LinkedListMultimap.this.y(node);
            this.f27077c = null;
            this.f27079e = LinkedListMultimap.this.f27054j;
        }
    }

    LinkedListMultimap() {
        this(12);
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @J2ktIncompatible
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f27052h = CompactLinkedHashMap.c0();
        int readInt = objectInputStream.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Node<K, V> t(@ParametricNullness K k4, @ParametricNullness V v3, @CheckForNull Node<K, V> node) {
        Node<K, V> node2 = new Node<>(k4, v3);
        if (this.f27050f == null) {
            this.f27051g = node2;
            this.f27050f = node2;
            this.f27052h.put(k4, new KeyList<>(node2));
            this.f27054j++;
        } else if (node == null) {
            Node<K, V> node3 = this.f27051g;
            Objects.requireNonNull(node3);
            node3.f27071c = node2;
            node2.f27072d = this.f27051g;
            this.f27051g = node2;
            KeyList<K, V> keyList = this.f27052h.get(k4);
            if (keyList == null) {
                this.f27052h.put(k4, new KeyList<>(node2));
                this.f27054j++;
            } else {
                keyList.f27068c++;
                Node<K, V> node4 = keyList.f27067b;
                node4.f27073e = node2;
                node2.f27074f = node4;
                keyList.f27067b = node2;
            }
        } else {
            KeyList<K, V> keyList2 = this.f27052h.get(k4);
            Objects.requireNonNull(keyList2);
            keyList2.f27068c++;
            node2.f27072d = node.f27072d;
            node2.f27074f = node.f27074f;
            node2.f27071c = node;
            node2.f27073e = node;
            Node<K, V> node5 = node.f27074f;
            if (node5 == null) {
                keyList2.f27066a = node2;
            } else {
                node5.f27073e = node2;
            }
            Node<K, V> node6 = node.f27072d;
            if (node6 == null) {
                this.f27050f = node2;
            } else {
                node6.f27071c = node2;
            }
            node.f27072d = node2;
            node.f27074f = node2;
        }
        this.f27053i++;
        return node2;
    }

    private List<V> w(@ParametricNullness K k4) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(k4)));
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(@ParametricNullness K k4) {
        Iterators.c(new ValueForKeyIterator(k4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Node<K, V> node) {
        Node<K, V> node2 = node.f27072d;
        if (node2 != null) {
            node2.f27071c = node.f27071c;
        } else {
            this.f27050f = node.f27071c;
        }
        Node<K, V> node3 = node.f27071c;
        if (node3 != null) {
            node3.f27072d = node2;
        } else {
            this.f27051g = node2;
        }
        if (node.f27074f == null && node.f27073e == null) {
            KeyList<K, V> remove = this.f27052h.remove(node.f27069a);
            Objects.requireNonNull(remove);
            remove.f27068c = 0;
            this.f27054j++;
        } else {
            KeyList<K, V> keyList = this.f27052h.get(node.f27069a);
            Objects.requireNonNull(keyList);
            keyList.f27068c--;
            Node<K, V> node4 = node.f27074f;
            if (node4 == null) {
                Node<K, V> node5 = node.f27073e;
                Objects.requireNonNull(node5);
                keyList.f27066a = node5;
            } else {
                node4.f27073e = node.f27073e;
            }
            Node<K, V> node6 = node.f27073e;
            if (node6 == null) {
                Node<K, V> node7 = node.f27074f;
                Objects.requireNonNull(node7);
                keyList.f27067b = node7;
            } else {
                node6.f27074f = node.f27074f;
            }
        }
        this.f27053i--;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> b() {
        return new Multimaps.AsMap(this);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.f27050f = null;
        this.f27051g = null;
        this.f27052h.clear();
        this.f27053i = 0;
        this.f27054j++;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f27052h.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> f() {
        return new Sets.ImprovedAbstractSet<K>() { // from class: com.google.common.collect.LinkedListMultimap.1KeySetImpl
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                return !LinkedListMultimap.this.removeAll(obj).isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return LinkedListMultimap.this.f27052h.size();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> g() {
        return new Multimaps.Keys(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean isEmpty() {
        if (this.f27050f == null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k4, @ParametricNullness V v3) {
        t(k4, v3, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f27053i;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: u */
    public List<Map.Entry<K, V>> e() {
        return new AbstractSequentialList<Map.Entry<K, V>>() { // from class: com.google.common.collect.LinkedListMultimap.1EntriesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator<Map.Entry<K, V>> listIterator(int i4) {
                return new NodeIterator(i4);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return LinkedListMultimap.this.f27053i;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* renamed from: v */
    public List<V> h() {
        return new AbstractSequentialList<V>() { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator<V> listIterator(int i4) {
                final NodeIterator nodeIterator = new NodeIterator(i4);
                return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeIterator) { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.TransformedIterator
                    @ParametricNullness
                    /* renamed from: c */
                    public V a(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    @Override // com.google.common.collect.TransformedListIterator, java.util.ListIterator
                    public void set(@ParametricNullness V v3) {
                        nodeIterator.f(v3);
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return LinkedListMultimap.this.f27053i;
            }
        };
    }

    private LinkedListMultimap(int i4) {
        this.f27052h = Platform.d(i4);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i4) {
        return new LinkedListMultimap<>(i4);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List<V> get(@ParametricNullness final K k4) {
        return new AbstractSequentialList<V>() { // from class: com.google.common.collect.LinkedListMultimap.1
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public ListIterator<V> listIterator(int i4) {
                return new ValueForKeyIterator(k4, i4);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                KeyList keyList = (KeyList) LinkedListMultimap.this.f27052h.get(k4);
                if (keyList == null) {
                    return 0;
                }
                return keyList.f27068c;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public List<V> removeAll(@CheckForNull Object obj) {
        List<V> w3 = w(obj);
        x(obj);
        return w3;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(@ParametricNullness K k4, Iterable<? extends V> iterable) {
        List<V> w3 = w(k4);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k4);
        Iterator<? extends V> it = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it.hasNext()) {
            valueForKeyIterator.add(it.next());
        }
        return w3;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class ValueForKeyIterator implements ListIterator<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f27081a;

        /* renamed from: b  reason: collision with root package name */
        int f27082b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f27083c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        Node<K, V> f27084d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        Node<K, V> f27085e;

        ValueForKeyIterator(@ParametricNullness K k4) {
            this.f27081a = k4;
            KeyList keyList = (KeyList) LinkedListMultimap.this.f27052h.get(k4);
            this.f27083c = keyList == null ? null : keyList.f27066a;
        }

        @Override // java.util.ListIterator
        public void add(@ParametricNullness V v3) {
            this.f27085e = LinkedListMultimap.this.t(this.f27081a, v3, this.f27083c);
            this.f27082b++;
            this.f27084d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.f27083c != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f27085e != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @ParametricNullness
        @CanIgnoreReturnValue
        public V next() {
            Node<K, V> node = this.f27083c;
            if (node != null) {
                this.f27084d = node;
                this.f27085e = node;
                this.f27083c = node.f27073e;
                this.f27082b++;
                return node.f27070b;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f27082b;
        }

        @Override // java.util.ListIterator
        @ParametricNullness
        @CanIgnoreReturnValue
        public V previous() {
            Node<K, V> node = this.f27085e;
            if (node != null) {
                this.f27084d = node;
                this.f27083c = node;
                this.f27085e = node.f27074f;
                this.f27082b--;
                return node.f27070b;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f27082b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            boolean z3;
            if (this.f27084d != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
            Node<K, V> node = this.f27084d;
            if (node != this.f27083c) {
                this.f27085e = node.f27074f;
                this.f27082b--;
            } else {
                this.f27083c = node.f27073e;
            }
            LinkedListMultimap.this.y(node);
            this.f27084d = null;
        }

        @Override // java.util.ListIterator
        public void set(@ParametricNullness V v3) {
            boolean z3;
            if (this.f27084d != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            this.f27084d.f27070b = v3;
        }

        public ValueForKeyIterator(@ParametricNullness K k4, int i4) {
            KeyList keyList = (KeyList) LinkedListMultimap.this.f27052h.get(k4);
            int i5 = keyList == null ? 0 : keyList.f27068c;
            Preconditions.checkPositionIndex(i4, i5);
            if (i4 >= i5 / 2) {
                this.f27085e = keyList == null ? null : keyList.f27067b;
                this.f27082b = i5;
                while (true) {
                    int i6 = i4 + 1;
                    if (i4 >= i5) {
                        break;
                    }
                    previous();
                    i4 = i6;
                }
            } else {
                this.f27083c = keyList == null ? null : keyList.f27066a;
                while (true) {
                    int i7 = i4 - 1;
                    if (i4 <= 0) {
                        break;
                    }
                    next();
                    i4 = i7;
                }
            }
            this.f27081a = k4;
            this.f27084d = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
