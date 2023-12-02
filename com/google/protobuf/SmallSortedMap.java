package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f33542a;

    /* renamed from: b  reason: collision with root package name */
    private List<SmallSortedMap<K, V>.Entry> f33543b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f33544c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33545d;

    /* renamed from: e  reason: collision with root package name */
    private volatile SmallSortedMap<K, V>.EntrySet f33546e;

    /* renamed from: f  reason: collision with root package name */
    private Map<K, V> f33547f;

    /* renamed from: g  reason: collision with root package name */
    private volatile SmallSortedMap<K, V>.DescendingEntrySet f33548g;

    /* loaded from: classes6.dex */
    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f33549a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f33550b;

        private DescendingEntryIterator() {
            this.f33549a = SmallSortedMap.this.f33543b.size();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f33550b == null) {
                this.f33550b = SmallSortedMap.this.f33547f.entrySet().iterator();
            }
            return this.f33550b;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (!a().hasNext()) {
                List list = SmallSortedMap.this.f33543b;
                int i4 = this.f33549a - 1;
                this.f33549a = i4;
                return (Map.Entry) list.get(i4);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i4 = this.f33549a;
            if ((i4 > 0 && i4 <= SmallSortedMap.this.f33543b.size()) || a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        private DescendingEntrySet() {
            super();
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class EmptySet {

        /* renamed from: a  reason: collision with root package name */
        private static final Iterator<Object> f33553a = new Iterator<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f33554b = new Iterable<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.2
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return EmptySet.f33553a;
            }
        };

        private EmptySet() {
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f33554b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* renamed from: a  reason: collision with root package name */
        private final K f33555a;

        /* renamed from: b  reason: collision with root package name */
        private V f33556b;

        Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: c */
        public K getKey() {
            return this.f33555a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (b(this.f33555a, entry.getKey()) && b(this.f33556b, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f33556b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k4 = this.f33555a;
            int i4 = 0;
            if (k4 == null) {
                hashCode = 0;
            } else {
                hashCode = k4.hashCode();
            }
            V v3 = this.f33556b;
            if (v3 != null) {
                i4 = v3.hashCode();
            }
            return hashCode ^ i4;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            SmallSortedMap.this.h();
            V v4 = this.f33556b;
            this.f33556b = v3;
            return v4;
        }

        public String toString() {
            return this.f33555a + "=" + this.f33556b;
        }

        Entry(K k4, V v3) {
            this.f33555a = k4;
            this.f33556b = v3;
        }
    }

    /* loaded from: classes6.dex */
    private class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f33558a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f33559b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f33560c;

        private EntryIterator() {
            this.f33558a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f33560c == null) {
                this.f33560c = SmallSortedMap.this.f33544c.entrySet().iterator();
            }
            return this.f33560c;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.f33559b = true;
            int i4 = this.f33558a + 1;
            this.f33558a = i4;
            if (i4 < SmallSortedMap.this.f33543b.size()) {
                return (Map.Entry) SmallSortedMap.this.f33543b.get(this.f33558a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f33558a + 1 < SmallSortedMap.this.f33543b.size()) {
                return true;
            }
            if (!SmallSortedMap.this.f33544c.isEmpty() && a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f33559b) {
                this.f33559b = false;
                SmallSortedMap.this.h();
                if (this.f33558a < SmallSortedMap.this.f33543b.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i4 = this.f33558a;
                    this.f33558a = i4 - 1;
                    smallSortedMap.t(i4);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (!contains(entry)) {
                SmallSortedMap.this.put(entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                SmallSortedMap.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap.this.size();
        }
    }

    private int g(K k4) {
        int size = this.f33543b.size() - 1;
        if (size >= 0) {
            int compareTo = k4.compareTo(this.f33543b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i4 = 0;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            int compareTo2 = k4.compareTo(this.f33543b.get(i5).getKey());
            if (compareTo2 < 0) {
                size = i5 - 1;
            } else if (compareTo2 > 0) {
                i4 = i5 + 1;
            } else {
                return i5;
            }
        }
        return -(i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f33545d) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private void j() {
        h();
        if (this.f33543b.isEmpty() && !(this.f33543b instanceof ArrayList)) {
            this.f33543b = new ArrayList(this.f33542a);
        }
    }

    private SortedMap<K, V> o() {
        h();
        if (this.f33544c.isEmpty() && !(this.f33544c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f33544c = treeMap;
            this.f33547f = treeMap.descendingMap();
        }
        return (SortedMap) this.f33544c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> r(int i4) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new SmallSortedMap<FieldDescriptorType, Object>(i4) { // from class: com.google.protobuf.SmallSortedMap.1
            @Override // com.google.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return super.put((FieldSet.FieldDescriptorLite) obj, obj2);
            }

            @Override // com.google.protobuf.SmallSortedMap
            public void q() {
                if (!p()) {
                    for (int i5 = 0; i5 < l(); i5++) {
                        Map.Entry<FieldDescriptorType, Object> k4 = k(i5);
                        if (((FieldSet.FieldDescriptorLite) k4.getKey()).isRepeated()) {
                            k4.setValue(Collections.unmodifiableList((List) k4.getValue()));
                        }
                    }
                    for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.q();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V t(int i4) {
        h();
        V value = this.f33543b.remove(i4).getValue();
        if (!this.f33544c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = o().entrySet().iterator();
            this.f33543b.add(new Entry(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f33543b.isEmpty()) {
            this.f33543b.clear();
        }
        if (!this.f33544c.isEmpty()) {
            this.f33544c.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (g(comparable) < 0 && !this.f33544c.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f33546e == null) {
            this.f33546e = new EntrySet();
        }
        return this.f33546e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int l4 = l();
        if (l4 != smallSortedMap.l()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i4 = 0; i4 < l4; i4++) {
            if (!k(i4).equals(smallSortedMap.k(i4))) {
                return false;
            }
        }
        if (l4 == size) {
            return true;
        }
        return this.f33544c.equals(smallSortedMap.f33544c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int g4 = g(comparable);
        if (g4 >= 0) {
            return this.f33543b.get(g4).getValue();
        }
        return this.f33544c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int l4 = l();
        int i4 = 0;
        for (int i5 = 0; i5 < l4; i5++) {
            i4 += this.f33543b.get(i5).hashCode();
        }
        if (m() > 0) {
            return i4 + this.f33544c.hashCode();
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> i() {
        if (this.f33548g == null) {
            this.f33548g = new DescendingEntrySet();
        }
        return this.f33548g;
    }

    public Map.Entry<K, V> k(int i4) {
        return this.f33543b.get(i4);
    }

    public int l() {
        return this.f33543b.size();
    }

    public int m() {
        return this.f33544c.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        if (this.f33544c.isEmpty()) {
            return EmptySet.b();
        }
        return this.f33544c.entrySet();
    }

    public boolean p() {
        return this.f33545d;
    }

    public void q() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.f33545d) {
            if (this.f33544c.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f33544c);
            }
            this.f33544c = unmodifiableMap;
            if (this.f33547f.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.f33547f);
            }
            this.f33547f = unmodifiableMap2;
            this.f33545d = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int g4 = g(comparable);
        if (g4 >= 0) {
            return (V) t(g4);
        }
        if (this.f33544c.isEmpty()) {
            return null;
        }
        return this.f33544c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: s */
    public V put(K k4, V v3) {
        h();
        int g4 = g(k4);
        if (g4 >= 0) {
            return this.f33543b.get(g4).setValue(v3);
        }
        j();
        int i4 = -(g4 + 1);
        if (i4 >= this.f33542a) {
            return o().put(k4, v3);
        }
        int size = this.f33543b.size();
        int i5 = this.f33542a;
        if (size == i5) {
            SmallSortedMap<K, V>.Entry remove = this.f33543b.remove(i5 - 1);
            o().put((K) remove.getKey(), remove.getValue());
        }
        this.f33543b.add(i4, new Entry(k4, v3));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f33543b.size() + this.f33544c.size();
    }

    private SmallSortedMap(int i4) {
        this.f33542a = i4;
        this.f33543b = Collections.emptyList();
        this.f33544c = Collections.emptyMap();
        this.f33547f = Collections.emptyMap();
    }
}
