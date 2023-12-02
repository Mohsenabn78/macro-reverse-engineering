package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* loaded from: classes5.dex */
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LLRBRedValueNode(K k4, V v3) {
        super(k4, v3, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
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
        return new LLRBRedValueNode(k4, v3, lLRBNode, lLRBNode2);
    }

    @Override // com.google.firebase.database.collection.LLRBValueNode
    protected LLRBNode.Color d() {
        return LLRBNode.Color.RED;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isRed() {
        return true;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return getLeft().size() + 1 + getRight().size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LLRBRedValueNode(K k4, V v3, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k4, v3, lLRBNode, lLRBNode2);
    }
}
