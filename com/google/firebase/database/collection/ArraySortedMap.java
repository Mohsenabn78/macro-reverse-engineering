package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K[] f30038a;

    /* renamed from: b  reason: collision with root package name */
    private final V[] f30039b;

    /* renamed from: c  reason: collision with root package name */
    private final Comparator<K> f30040c;

    public ArraySortedMap(Comparator<K> comparator) {
        this.f30038a = (K[]) new Object[0];
        this.f30039b = (V[]) new Object[0];
        this.f30040c = comparator;
    }

    public static <A, B, C> ArraySortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i4 = 0;
        for (A a4 : list) {
            objArr[i4] = a4;
            objArr2[i4] = map.get(keyTranslator.translate(a4));
            i4++;
        }
        return new ArraySortedMap<>(comparator, objArr, objArr2);
    }

    private static <T> T[] c(T[] tArr, int i4, T t3) {
        int length = tArr.length + 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i4);
        tArr2[i4] = t3;
        System.arraycopy(tArr, i4, tArr2, i4 + 1, (length - i4) - 1);
        return tArr2;
    }

    private int d(K k4) {
        int i4 = 0;
        for (K k5 : this.f30038a) {
            if (this.f30040c.compare(k4, k5) == 0) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private int e(K k4) {
        int i4 = 0;
        while (true) {
            K[] kArr = this.f30038a;
            if (i4 >= kArr.length || this.f30040c.compare(kArr[i4], k4) >= 0) {
                break;
            }
            i4++;
        }
        return i4;
    }

    private Iterator<Map.Entry<K, V>> f(int i4, boolean z3) {
        return new Iterator<Map.Entry<K, V>>(i4, z3) { // from class: com.google.firebase.database.collection.ArraySortedMap.1

            /* renamed from: a  reason: collision with root package name */
            int f30041a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f30042b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f30043c;

            {
                this.f30042b = i4;
                this.f30043c = z3;
                this.f30041a = i4;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                int i5;
                Object obj = ArraySortedMap.this.f30038a[this.f30041a];
                Object[] objArr = ArraySortedMap.this.f30039b;
                int i6 = this.f30041a;
                Object obj2 = objArr[i6];
                if (this.f30043c) {
                    i5 = i6 - 1;
                } else {
                    i5 = i6 + 1;
                }
                this.f30041a = i5;
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f30043c) {
                    if (this.f30041a >= 0) {
                        return true;
                    }
                } else if (this.f30041a < ArraySortedMap.this.f30038a.length) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }
        };
    }

    public static <K, V> ArraySortedMap<K, V> fromMap(Map<K, V> map, Comparator<K> comparator) {
        return buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    private static <T> T[] g(T[] tArr, int i4) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i4);
        System.arraycopy(tArr, i4 + 1, tArr2, i4, length - i4);
        return tArr2;
    }

    private static <T> T[] h(T[] tArr, int i4, T t3) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i4] = t3;
        return tArr2;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k4) {
        if (d(k4) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k4) {
        int d4 = d(k4);
        if (d4 != -1) {
            return this.f30039b[d4];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.f30040c;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        K[] kArr = this.f30038a;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        K[] kArr = this.f30038a;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k4) {
        int d4 = d(k4);
        if (d4 != -1) {
            if (d4 > 0) {
                return this.f30038a[d4 - 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k4) {
        int d4 = d(k4);
        if (d4 != -1) {
            K[] kArr = this.f30038a;
            if (d4 < kArr.length - 1) {
                return kArr[d4 + 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find successor of nonexistent key");
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int i4 = 0;
        while (true) {
            K[] kArr = this.f30038a;
            if (i4 < kArr.length) {
                nodeVisitor.visitEntry(kArr[i4], this.f30039b[i4]);
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k4) {
        return d(k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k4, V v3) {
        int d4 = d(k4);
        if (d4 != -1) {
            K[] kArr = this.f30038a;
            if (kArr[d4] == k4 && this.f30039b[d4] == v3) {
                return this;
            }
            return new ArraySortedMap(this.f30040c, h(kArr, d4, k4), h(this.f30039b, d4, v3));
        } else if (this.f30038a.length > 25) {
            HashMap hashMap = new HashMap(this.f30038a.length + 1);
            int i4 = 0;
            while (true) {
                K[] kArr2 = this.f30038a;
                if (i4 < kArr2.length) {
                    hashMap.put(kArr2[i4], this.f30039b[i4]);
                    i4++;
                } else {
                    hashMap.put(k4, v3);
                    return RBTreeSortedMap.fromMap(hashMap, this.f30040c);
                }
            }
        } else {
            int e4 = e(k4);
            return new ArraySortedMap(this.f30040c, c(this.f30038a, e4, k4), c(this.f30039b, e4, v3));
        }
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        if (this.f30038a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return f(0, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> iteratorFrom(K k4) {
        return f(e(k4), false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k4) {
        int d4 = d(k4);
        if (d4 == -1) {
            return this;
        }
        return new ArraySortedMap(this.f30040c, g(this.f30038a, d4), g(this.f30039b, d4));
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return f(this.f30038a.length - 1, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k4) {
        int e4 = e(k4);
        K[] kArr = this.f30038a;
        if (e4 < kArr.length && this.f30040c.compare(kArr[e4], k4) == 0) {
            return f(e4, true);
        }
        return f(e4 - 1, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.f30038a.length;
    }

    private ArraySortedMap(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f30038a = kArr;
        this.f30039b = vArr;
        this.f30040c = comparator;
    }
}
