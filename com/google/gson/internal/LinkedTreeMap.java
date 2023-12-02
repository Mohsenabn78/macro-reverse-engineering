package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Comparable> f32640a = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    /* loaded from: classes5.dex */
    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedTreeMap.this.e((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                /* renamed from: b */
                public Map.Entry<K, V> next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> e4;
            if (!(obj instanceof Map.Entry) || (e4 = LinkedTreeMap.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.h(e4, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes5.dex */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return a().f32654f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (LinkedTreeMap.this.i(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        Node<K, V> f32645a;

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f32646b = null;

        /* renamed from: c  reason: collision with root package name */
        int f32647c;

        LinkedTreeMapIterator() {
            this.f32645a = LinkedTreeMap.this.header.f32652d;
            this.f32647c = LinkedTreeMap.this.modCount;
        }

        final Node<K, V> a() {
            Node<K, V> node = this.f32645a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.f32647c) {
                    this.f32645a = node.f32652d;
                    this.f32646b = node;
                    return node;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f32645a != LinkedTreeMap.this.header) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.f32646b;
            if (node != null) {
                LinkedTreeMap.this.h(node, true);
                this.f32646b = null;
                this.f32647c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(f32640a, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void g(Node<K, V> node, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        while (node != null) {
            Node<K, V> node2 = node.f32650b;
            Node<K, V> node3 = node.f32651c;
            int i8 = 0;
            if (node2 != null) {
                i4 = node2.f32657i;
            } else {
                i4 = 0;
            }
            if (node3 != null) {
                i5 = node3.f32657i;
            } else {
                i5 = 0;
            }
            int i9 = i4 - i5;
            if (i9 == -2) {
                Node<K, V> node4 = node3.f32650b;
                Node<K, V> node5 = node3.f32651c;
                if (node5 != null) {
                    i7 = node5.f32657i;
                } else {
                    i7 = 0;
                }
                if (node4 != null) {
                    i8 = node4.f32657i;
                }
                int i10 = i8 - i7;
                if (i10 != -1 && (i10 != 0 || z3)) {
                    m(node3);
                    l(node);
                } else {
                    l(node);
                }
                if (z3) {
                    return;
                }
            } else if (i9 == 2) {
                Node<K, V> node6 = node2.f32650b;
                Node<K, V> node7 = node2.f32651c;
                if (node7 != null) {
                    i6 = node7.f32657i;
                } else {
                    i6 = 0;
                }
                if (node6 != null) {
                    i8 = node6.f32657i;
                }
                int i11 = i8 - i6;
                if (i11 != 1 && (i11 != 0 || z3)) {
                    l(node2);
                    m(node);
                } else {
                    m(node);
                }
                if (z3) {
                    return;
                }
            } else if (i9 == 0) {
                node.f32657i = i4 + 1;
                if (z3) {
                    return;
                }
            } else {
                node.f32657i = Math.max(i4, i5) + 1;
                if (!z3) {
                    return;
                }
            }
            node = node.f32649a;
        }
    }

    private void j(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.f32649a;
        node.f32649a = null;
        if (node2 != null) {
            node2.f32649a = node3;
        }
        if (node3 != null) {
            if (node3.f32650b == node) {
                node3.f32650b = node2;
                return;
            } else {
                node3.f32651c = node2;
                return;
            }
        }
        this.root = node2;
    }

    private void l(Node<K, V> node) {
        int i4;
        int i5;
        Node<K, V> node2 = node.f32650b;
        Node<K, V> node3 = node.f32651c;
        Node<K, V> node4 = node3.f32650b;
        Node<K, V> node5 = node3.f32651c;
        node.f32651c = node4;
        if (node4 != null) {
            node4.f32649a = node;
        }
        j(node, node3);
        node3.f32650b = node;
        node.f32649a = node3;
        int i6 = 0;
        if (node2 != null) {
            i4 = node2.f32657i;
        } else {
            i4 = 0;
        }
        if (node4 != null) {
            i5 = node4.f32657i;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        node.f32657i = max;
        if (node5 != null) {
            i6 = node5.f32657i;
        }
        node3.f32657i = Math.max(max, i6) + 1;
    }

    private void m(Node<K, V> node) {
        int i4;
        int i5;
        Node<K, V> node2 = node.f32650b;
        Node<K, V> node3 = node.f32651c;
        Node<K, V> node4 = node2.f32650b;
        Node<K, V> node5 = node2.f32651c;
        node.f32650b = node5;
        if (node5 != null) {
            node5.f32649a = node;
        }
        j(node, node2);
        node2.f32651c = node;
        node.f32649a = node2;
        int i6 = 0;
        if (node3 != null) {
            i4 = node3.f32657i;
        } else {
            i4 = 0;
        }
        if (node5 != null) {
            i5 = node5.f32657i;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        node.f32657i = max;
        if (node4 != null) {
            i6 = node4.f32657i;
        }
        node2.f32657i = Math.max(max, i6) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    Node<K, V> c(K k4, boolean z3) {
        int i4;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.comparator;
        Node<K, V> node3 = this.root;
        if (node3 != null) {
            if (comparator == f32640a) {
                comparable = (Comparable) k4;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i4 = comparable.compareTo(node3.f32654f);
                } else {
                    i4 = comparator.compare(k4, (K) node3.f32654f);
                }
                if (i4 == 0) {
                    return node3;
                }
                if (i4 < 0) {
                    node2 = node3.f32650b;
                } else {
                    node2 = node3.f32651c;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            i4 = 0;
        }
        if (!z3) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node3 == null) {
            if (comparator == f32640a && !(k4 instanceof Comparable)) {
                throw new ClassCastException(k4.getClass().getName() + " is not Comparable");
            }
            node = new Node<>(this.allowNullValues, node3, k4, node4, node4.f32653e);
            this.root = node;
        } else {
            node = new Node<>(this.allowNullValues, node3, k4, node4, node4.f32653e);
            if (i4 < 0) {
                node3.f32650b = node;
            } else {
                node3.f32651c = node;
            }
            g(node3, true);
        }
        this.size++;
        this.modCount++;
        return node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        node.f32653e = node;
        node.f32652d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (f(obj) != null) {
            return true;
        }
        return false;
    }

    Node<K, V> e(Map.Entry<?, ?> entry) {
        boolean z3;
        Node<K, V> f4 = f(entry.getKey());
        if (f4 != null && a(f4.f32656h, entry.getValue())) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return null;
        }
        return f4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Node<K, V> f(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return c(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> f4 = f(obj);
        if (f4 != null) {
            return f4.f32656h;
        }
        return null;
    }

    void h(Node<K, V> node, boolean z3) {
        Node<K, V> a4;
        int i4;
        if (z3) {
            Node<K, V> node2 = node.f32653e;
            node2.f32652d = node.f32652d;
            node.f32652d.f32653e = node2;
        }
        Node<K, V> node3 = node.f32650b;
        Node<K, V> node4 = node.f32651c;
        Node<K, V> node5 = node.f32649a;
        int i5 = 0;
        if (node3 != null && node4 != null) {
            if (node3.f32657i > node4.f32657i) {
                a4 = node3.b();
            } else {
                a4 = node4.a();
            }
            h(a4, false);
            Node<K, V> node6 = node.f32650b;
            if (node6 != null) {
                i4 = node6.f32657i;
                a4.f32650b = node6;
                node6.f32649a = a4;
                node.f32650b = null;
            } else {
                i4 = 0;
            }
            Node<K, V> node7 = node.f32651c;
            if (node7 != null) {
                i5 = node7.f32657i;
                a4.f32651c = node7;
                node7.f32649a = a4;
                node.f32651c = null;
            }
            a4.f32657i = Math.max(i4, i5) + 1;
            j(node, a4);
            return;
        }
        if (node3 != null) {
            j(node, node3);
            node.f32650b = null;
        } else if (node4 != null) {
            j(node, node4);
            node.f32651c = null;
        } else {
            j(node, null);
        }
        g(node5, false);
        this.size--;
        this.modCount++;
    }

    Node<K, V> i(Object obj) {
        Node<K, V> f4 = f(obj);
        if (f4 != null) {
            h(f4, true);
        }
        return f4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet == null) {
            LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k4, V v3) {
        if (k4 != null) {
            if (v3 == null && !this.allowNullValues) {
                throw new NullPointerException("value == null");
            }
            Node<K, V> c4 = c(k4, true);
            V v4 = c4.f32656h;
            c4.f32656h = v3;
            return v4;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> i4 = i(obj);
        if (i4 != null) {
            return i4.f32656h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(boolean z3) {
        this(f32640a, z3);
    }

    public LinkedTreeMap(Comparator<? super K> comparator, boolean z3) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f32640a : comparator;
        this.allowNullValues = z3;
        this.header = new Node<>(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Node<K, V> f32649a;

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f32650b;

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f32651c;

        /* renamed from: d  reason: collision with root package name */
        Node<K, V> f32652d;

        /* renamed from: e  reason: collision with root package name */
        Node<K, V> f32653e;

        /* renamed from: f  reason: collision with root package name */
        final K f32654f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f32655g;

        /* renamed from: h  reason: collision with root package name */
        V f32656h;

        /* renamed from: i  reason: collision with root package name */
        int f32657i;

        Node(boolean z3) {
            this.f32654f = null;
            this.f32655g = z3;
            this.f32653e = this;
            this.f32652d = this;
        }

        public Node<K, V> a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f32650b; node2 != null; node2 = node2.f32650b) {
                node = node2;
            }
            return node;
        }

        public Node<K, V> b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f32651c; node2 != null; node2 = node2.f32651c) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k4 = this.f32654f;
            if (k4 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k4.equals(entry.getKey())) {
                return false;
            }
            V v3 = this.f32656h;
            if (v3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f32654f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f32656h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k4 = this.f32654f;
            int i4 = 0;
            if (k4 == null) {
                hashCode = 0;
            } else {
                hashCode = k4.hashCode();
            }
            V v3 = this.f32656h;
            if (v3 != null) {
                i4 = v3.hashCode();
            }
            return hashCode ^ i4;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            if (v3 == null && !this.f32655g) {
                throw new NullPointerException("value == null");
            }
            V v4 = this.f32656h;
            this.f32656h = v3;
            return v4;
        }

        public String toString() {
            return this.f32654f + "=" + this.f32656h;
        }

        Node(boolean z3, Node<K, V> node, K k4, Node<K, V> node2, Node<K, V> node3) {
            this.f32649a = node;
            this.f32654f = k4;
            this.f32655g = z3;
            this.f32657i = 1;
            this.f32652d = node2;
            this.f32653e = node3;
            node3.f32652d = this;
            node2.f32653e = this;
        }
    }
}
