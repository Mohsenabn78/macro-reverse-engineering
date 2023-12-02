package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private LLRBNode<K, V> f30057a;

    /* renamed from: b  reason: collision with root package name */
    private Comparator<K> f30058b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Builder<A, B, C> {

        /* renamed from: a  reason: collision with root package name */
        private final List<A> f30059a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<B, C> f30060b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> f30061c;

        /* renamed from: d  reason: collision with root package name */
        private LLRBValueNode<A, C> f30062d;

        /* renamed from: e  reason: collision with root package name */
        private LLRBValueNode<A, C> f30063e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static class Base1_2 implements Iterable<BooleanChunk> {

            /* renamed from: a  reason: collision with root package name */
            private long f30064a;

            /* renamed from: b  reason: collision with root package name */
            private final int f30065b;

            public Base1_2(int i4) {
                int i5 = i4 + 1;
                int floor = (int) Math.floor(Math.log(i5) / Math.log(2.0d));
                this.f30065b = floor;
                this.f30064a = (((long) Math.pow(2.0d, floor)) - 1) & i5;
            }

            @Override // java.lang.Iterable
            public Iterator<BooleanChunk> iterator() {
                return new Iterator<BooleanChunk>() { // from class: com.google.firebase.database.collection.RBTreeSortedMap.Builder.Base1_2.1

                    /* renamed from: a  reason: collision with root package name */
                    private int f30066a;

                    {
                        this.f30066a = Base1_2.this.f30065b - 1;
                    }

                    @Override // java.util.Iterator
                    /* renamed from: a */
                    public BooleanChunk next() {
                        boolean z3;
                        BooleanChunk booleanChunk = new BooleanChunk();
                        if ((Base1_2.this.f30064a & (1 << this.f30066a)) == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        booleanChunk.f30068a = z3;
                        booleanChunk.f30069b = (int) Math.pow(2.0d, this.f30066a);
                        this.f30066a--;
                        return booleanChunk;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.f30066a >= 0) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static class BooleanChunk {

            /* renamed from: a  reason: collision with root package name */
            public boolean f30068a;

            /* renamed from: b  reason: collision with root package name */
            public int f30069b;

            BooleanChunk() {
            }
        }

        private Builder(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator) {
            this.f30059a = list;
            this.f30060b = map;
            this.f30061c = keyTranslator;
        }

        private LLRBNode<A, C> a(int i4, int i5) {
            if (i5 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i5 == 1) {
                A a4 = this.f30059a.get(i4);
                return new LLRBBlackValueNode(a4, d(a4), null, null);
            }
            int i6 = i5 / 2;
            int i7 = i4 + i6;
            LLRBNode<A, C> a5 = a(i4, i6);
            LLRBNode<A, C> a6 = a(i7 + 1, i6);
            A a7 = this.f30059a.get(i7);
            return new LLRBBlackValueNode(a7, d(a7), a5, a6);
        }

        public static <A, B, C> RBTreeSortedMap<A, C> b(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
            Builder builder = new Builder(list, map, keyTranslator);
            Collections.sort(list, comparator);
            Iterator<BooleanChunk> it = new Base1_2(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                BooleanChunk next = it.next();
                int i4 = next.f30069b;
                size -= i4;
                if (next.f30068a) {
                    builder.c(LLRBNode.Color.BLACK, i4, size);
                } else {
                    builder.c(LLRBNode.Color.BLACK, i4, size);
                    int i5 = next.f30069b;
                    size -= i5;
                    builder.c(LLRBNode.Color.RED, i5, size);
                }
            }
            LLRBNode lLRBNode = builder.f30062d;
            if (lLRBNode == null) {
                lLRBNode = LLRBEmptyNode.getInstance();
            }
            return new RBTreeSortedMap<>(lLRBNode, comparator);
        }

        private void c(LLRBNode.Color color, int i4, int i5) {
            LLRBValueNode<A, C> lLRBBlackValueNode;
            LLRBNode<A, C> a4 = a(i5 + 1, i4 - 1);
            A a5 = this.f30059a.get(i5);
            if (color == LLRBNode.Color.RED) {
                lLRBBlackValueNode = new LLRBRedValueNode<>(a5, d(a5), null, a4);
            } else {
                lLRBBlackValueNode = new LLRBBlackValueNode<>(a5, d(a5), null, a4);
            }
            if (this.f30062d == null) {
                this.f30062d = lLRBBlackValueNode;
                this.f30063e = lLRBBlackValueNode;
                return;
            }
            this.f30063e.k(lLRBBlackValueNode);
            this.f30063e = lLRBBlackValueNode;
        }

        private C d(A a4) {
            return this.f30060b.get(this.f30061c.translate(a4));
        }
    }

    private LLRBNode<K, V> a(K k4) {
        LLRBNode<K, V> lLRBNode = this.f30057a;
        while (!lLRBNode.isEmpty()) {
            int compare = this.f30058b.compare(k4, lLRBNode.getKey());
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else if (compare == 0) {
                return lLRBNode;
            } else {
                lLRBNode = lLRBNode.getRight();
            }
        }
        return null;
    }

    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        return Builder.b(list, map, keyTranslator, comparator);
    }

    public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator) {
        return Builder.b(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean containsKey(K k4) {
        if (a(k4) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public V get(K k4) {
        LLRBNode<K, V> a4 = a(k4);
        if (a4 != null) {
            return a4.getValue();
        }
        return null;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Comparator<K> getComparator() {
        return this.f30058b;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMaxKey() {
        return this.f30057a.getMax().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getMinKey() {
        return this.f30057a.getMin().getKey();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getPredecessorKey(K k4) {
        LLRBNode<K, V> lLRBNode = this.f30057a;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.f30058b.compare(k4, lLRBNode.getKey());
            if (compare == 0) {
                if (!lLRBNode.getLeft().isEmpty()) {
                    LLRBNode<K, V> left = lLRBNode.getLeft();
                    while (!left.getRight().isEmpty()) {
                        left = left.getRight();
                    }
                    return left.getKey();
                } else if (lLRBNode2 == null) {
                    return null;
                } else {
                    return lLRBNode2.getKey();
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getRight();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public K getSuccessorKey(K k4) {
        LLRBNode<K, V> lLRBNode = this.f30057a;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.f30058b.compare(lLRBNode.getKey(), k4);
            if (compare == 0) {
                if (!lLRBNode.getRight().isEmpty()) {
                    LLRBNode<K, V> right = lLRBNode.getRight();
                    while (!right.getLeft().isEmpty()) {
                        right = right.getLeft();
                    }
                    return right.getKey();
                } else if (lLRBNode2 == null) {
                    return null;
                } else {
                    return lLRBNode2.getKey();
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getRight();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getLeft();
            }
        }
        throw new IllegalArgumentException("Couldn't find successor key of non-present key: " + k4);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.f30057a.inOrderTraversal(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int indexOf(K k4) {
        LLRBNode<K, V> lLRBNode = this.f30057a;
        int i4 = 0;
        while (!lLRBNode.isEmpty()) {
            int compare = this.f30058b.compare(k4, lLRBNode.getKey());
            if (compare == 0) {
                return i4 + lLRBNode.getLeft().size();
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                i4 += lLRBNode.getLeft().size() + 1;
                lLRBNode = lLRBNode.getRight();
            }
        }
        return -1;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> insert(K k4, V v3) {
        return new RBTreeSortedMap(this.f30057a.insert(k4, v3, this.f30058b).copy(null, null, LLRBNode.Color.BLACK, null, null), this.f30058b);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public boolean isEmpty() {
        return this.f30057a.isEmpty();
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.f30057a, null, this.f30058b, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> iteratorFrom(K k4) {
        return new ImmutableSortedMapIterator(this.f30057a, k4, this.f30058b, false);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public ImmutableSortedMap<K, V> remove(K k4) {
        if (!containsKey(k4)) {
            return this;
        }
        return new RBTreeSortedMap(this.f30057a.remove(k4, this.f30058b).copy(null, null, LLRBNode.Color.BLACK, null, null), this.f30058b);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIterator() {
        return new ImmutableSortedMapIterator(this.f30057a, null, this.f30058b, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k4) {
        return new ImmutableSortedMapIterator(this.f30057a, k4, this.f30058b, true);
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap
    public int size() {
        return this.f30057a.size();
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator) {
        this.f30057a = lLRBNode;
        this.f30058b = comparator;
    }
}
