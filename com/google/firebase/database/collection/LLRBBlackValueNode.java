package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* loaded from: classes5.dex */
public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private int f30050e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LLRBBlackValueNode(K k4, V v3, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k4, v3, lLRBNode, lLRBNode2);
        this.f30050e = -1;
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected LLRBValueNode<K, V> b(K k4, V v3, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k4 == null) {
            k4 = getKey();
        }
        if (v3 == null) {
            v3 = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBBlackValueNode(k4, v3, lLRBNode, lLRBNode2);
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected LLRBNode.Color d() {
        return LLRBNode.Color.BLACK;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isRed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.database.collection.LLRBValueNode
    public void k(LLRBNode<K, V> lLRBNode) {
        if (this.f30050e == -1) {
            super.k(lLRBNode);
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        if (this.f30050e == -1) {
            this.f30050e = getLeft().size() + 1 + getRight().size();
        }
        return this.f30050e;
    }
}
