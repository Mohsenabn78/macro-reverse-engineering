package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes5.dex */
public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    int f26059a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f26060b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class Entry implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private int f26061a;

        Entry(int i4) {
            this.f26061a = i4;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.equal(getKey(), entry.getKey()) && Objects.equal(getValue(), entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ArrayMap.this.getKey(this.f26061a);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) ArrayMap.this.getValue(this.f26061a);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            return (V) ArrayMap.this.set(this.f26061a, v3);
        }
    }

    /* loaded from: classes5.dex */
    final class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f26063a;

        /* renamed from: b  reason: collision with root package name */
        private int f26064b;

        EntryIterator() {
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            int i4 = this.f26064b;
            ArrayMap arrayMap = ArrayMap.this;
            if (i4 != arrayMap.f26059a) {
                this.f26064b = i4 + 1;
                return new Entry(i4);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f26064b < ArrayMap.this.f26059a) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i4 = this.f26064b - 1;
            if (!this.f26063a && i4 >= 0) {
                ArrayMap.this.remove(i4);
                this.f26063a = true;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes5.dex */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ArrayMap.this.f26059a;
        }
    }

    private int a(Object obj) {
        int i4 = this.f26059a << 1;
        Object[] objArr = this.f26060b;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Object obj2 = objArr[i5];
            if (obj == null) {
                if (obj2 == null) {
                    return i5;
                }
            } else if (obj.equals(obj2)) {
                return i5;
            }
        }
        return -2;
    }

    private V c(int i4) {
        int i5 = this.f26059a << 1;
        if (i4 < 0 || i4 >= i5) {
            return null;
        }
        V f4 = f(i4 + 1);
        Object[] objArr = this.f26060b;
        int i6 = (i5 - i4) - 2;
        if (i6 != 0) {
            System.arraycopy(objArr, i4 + 2, objArr, i4, i6);
        }
        this.f26059a--;
        d(i5 - 2, null, null);
        return f4;
    }

    public static <K, V> ArrayMap<K, V> create() {
        return new ArrayMap<>();
    }

    private void d(int i4, K k4, V v3) {
        Object[] objArr = this.f26060b;
        objArr[i4] = k4;
        objArr[i4 + 1] = v3;
    }

    private void e(int i4) {
        if (i4 == 0) {
            this.f26060b = null;
            return;
        }
        int i5 = this.f26059a;
        Object[] objArr = this.f26060b;
        if (i5 == 0 || i4 != objArr.length) {
            Object[] objArr2 = new Object[i4];
            this.f26060b = objArr2;
            if (i5 != 0) {
                System.arraycopy(objArr, 0, objArr2, 0, i5 << 1);
            }
        }
    }

    private V f(int i4) {
        if (i4 < 0) {
            return null;
        }
        return (V) this.f26060b[i4];
    }

    public static <K, V> ArrayMap<K, V> of(Object... objArr) {
        ArrayMap<K, V> create = create(1);
        int length = objArr.length;
        if (1 != length % 2) {
            create.f26059a = objArr.length / 2;
            Object[] objArr2 = new Object[length];
            ((ArrayMap) create).f26060b = objArr2;
            System.arraycopy(objArr, 0, objArr2, 0, length);
            return create;
        }
        String valueOf = String.valueOf(objArr[length - 1]);
        StringBuilder sb = new StringBuilder(valueOf.length() + 28);
        sb.append("missing value for last key: ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void add(K k4, V v3) {
        set(this.f26059a, k4, v3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f26059a = 0;
        this.f26060b = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (-2 != a(obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i4 = this.f26059a << 1;
        Object[] objArr = this.f26060b;
        for (int i5 = 1; i5 < i4; i5 += 2) {
            Object obj2 = objArr[i5];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public final void ensureCapacity(int i4) {
        int length;
        if (i4 >= 0) {
            Object[] objArr = this.f26060b;
            int i5 = i4 << 1;
            if (objArr == null) {
                length = 0;
            } else {
                length = objArr.length;
            }
            if (i5 > length) {
                int i6 = ((length / 2) * 3) + 1;
                if (i6 % 2 != 0) {
                    i6++;
                }
                if (i6 >= i5) {
                    i5 = i6;
                }
                e(i5);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return f(a(obj) + 1);
    }

    public final int getIndexOfKey(K k4) {
        return a(k4) >> 1;
    }

    public final K getKey(int i4) {
        if (i4 >= 0 && i4 < this.f26059a) {
            return (K) this.f26060b[i4 << 1];
        }
        return null;
    }

    public final V getValue(int i4) {
        if (i4 >= 0 && i4 < this.f26059a) {
            return f((i4 << 1) + 1);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k4, V v3) {
        int indexOfKey = getIndexOfKey(k4);
        if (indexOfKey == -1) {
            indexOfKey = this.f26059a;
        }
        return set(indexOfKey, k4, v3);
    }

    public final V remove(int i4) {
        return c(i4 << 1);
    }

    public final V set(int i4, K k4, V v3) {
        if (i4 >= 0) {
            int i5 = i4 + 1;
            ensureCapacity(i5);
            int i6 = i4 << 1;
            V f4 = f(i6 + 1);
            d(i6, k4, v3);
            if (i5 > this.f26059a) {
                this.f26059a = i5;
            }
            return f4;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f26059a;
    }

    public final void trim() {
        e(this.f26059a << 1);
    }

    public static <K, V> ArrayMap<K, V> create(int i4) {
        ArrayMap<K, V> create = create();
        create.ensureCapacity(i4);
        return create;
    }

    @Override // java.util.AbstractMap
    public ArrayMap<K, V> clone() {
        try {
            ArrayMap<K, V> arrayMap = (ArrayMap) super.clone();
            Object[] objArr = this.f26060b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                arrayMap.f26060b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return arrayMap;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return c(a(obj));
    }

    public final V set(int i4, V v3) {
        int i5 = this.f26059a;
        if (i4 >= 0 && i4 < i5) {
            int i6 = (i4 << 1) + 1;
            V f4 = f(i6);
            this.f26060b[i6] = v3;
            return f4;
        }
        throw new IndexOutOfBoundsException();
    }
}
