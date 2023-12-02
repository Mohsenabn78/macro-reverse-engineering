package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<LLRBValueNode<K, V>> f30046a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30047b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k4, Comparator<K> comparator, boolean z3) {
        int i4;
        this.f30047b = z3;
        while (!lLRBNode.isEmpty()) {
            if (k4 != null) {
                if (z3) {
                    i4 = comparator.compare(k4, lLRBNode.getKey());
                } else {
                    i4 = comparator.compare(lLRBNode.getKey(), k4);
                }
            } else {
                i4 = 1;
            }
            if (i4 < 0) {
                if (z3) {
                    lLRBNode = lLRBNode.getLeft();
                } else {
                    lLRBNode = lLRBNode.getRight();
                }
            } else if (i4 == 0) {
                this.f30046a.push((LLRBValueNode) lLRBNode);
                return;
            } else {
                this.f30046a.push((LLRBValueNode) lLRBNode);
                if (z3) {
                    lLRBNode = lLRBNode.getRight();
                } else {
                    lLRBNode = lLRBNode.getLeft();
                }
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f30046a.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode<K, V> pop = this.f30046a.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.f30047b) {
                for (LLRBNode<K, V> left = pop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.f30046a.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode<K, V> right = pop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.f30046a.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}
