package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

/* loaded from: classes5.dex */
public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f30053a;

    /* renamed from: b  reason: collision with root package name */
    private final V f30054b;

    /* renamed from: c  reason: collision with root package name */
    private LLRBNode<K, V> f30055c;

    /* renamed from: d  reason: collision with root package name */
    private final LLRBNode<K, V> f30056d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LLRBValueNode(K k4, V v3, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        this.f30053a = k4;
        this.f30054b = v3;
        this.f30055c = lLRBNode == null ? LLRBEmptyNode.getInstance() : lLRBNode;
        this.f30056d = lLRBNode2 == null ? LLRBEmptyNode.getInstance() : lLRBNode2;
    }

    private LLRBValueNode<K, V> a() {
        LLRBNode<K, V> lLRBNode = this.f30055c;
        LLRBNode<K, V> copy = lLRBNode.copy(null, null, g(lLRBNode), null, null);
        LLRBNode<K, V> lLRBNode2 = this.f30056d;
        return copy((LLRBValueNode<K, V>) null, (K) null, g(this), (LLRBNode<LLRBValueNode<K, V>, K>) copy, (LLRBNode<LLRBValueNode<K, V>, K>) lLRBNode2.copy(null, null, g(lLRBNode2), null, null));
    }

    private LLRBValueNode<K, V> c() {
        LLRBValueNode<K, V> lLRBValueNode;
        if (this.f30056d.isRed() && !this.f30055c.isRed()) {
            lLRBValueNode = i();
        } else {
            lLRBValueNode = this;
        }
        if (lLRBValueNode.f30055c.isRed() && ((LLRBValueNode) lLRBValueNode.f30055c).f30055c.isRed()) {
            lLRBValueNode = lLRBValueNode.j();
        }
        if (lLRBValueNode.f30055c.isRed() && lLRBValueNode.f30056d.isRed()) {
            return lLRBValueNode.a();
        }
        return lLRBValueNode;
    }

    private LLRBValueNode<K, V> e() {
        LLRBValueNode<K, V> a4 = a();
        if (a4.getRight().getLeft().isRed()) {
            return a4.b(null, null, null, ((LLRBValueNode) a4.getRight()).j()).i().a();
        }
        return a4;
    }

    private LLRBValueNode<K, V> f() {
        LLRBValueNode<K, V> a4 = a();
        if (a4.getLeft().getLeft().isRed()) {
            return a4.j().a();
        }
        return a4;
    }

    private static LLRBNode.Color g(LLRBNode lLRBNode) {
        if (lLRBNode.isRed()) {
            return LLRBNode.Color.BLACK;
        }
        return LLRBNode.Color.RED;
    }

    private LLRBNode<K, V> h() {
        LLRBValueNode<K, V> lLRBValueNode;
        if (this.f30055c.isEmpty()) {
            return LLRBEmptyNode.getInstance();
        }
        if (!getLeft().isRed() && !getLeft().getLeft().isRed()) {
            lLRBValueNode = e();
        } else {
            lLRBValueNode = this;
        }
        return lLRBValueNode.b(null, null, ((LLRBValueNode) lLRBValueNode.f30055c).h(), null).c();
    }

    private LLRBValueNode<K, V> i() {
        return (LLRBValueNode) this.f30056d.copy(null, null, d(), copy((LLRBValueNode<K, V>) null, (K) null, LLRBNode.Color.RED, (LLRBNode<LLRBValueNode<K, V>, K>) null, (LLRBNode<LLRBValueNode<K, V>, K>) ((LLRBValueNode) this.f30056d).f30055c), null);
    }

    private LLRBValueNode<K, V> j() {
        return (LLRBValueNode) this.f30055c.copy(null, null, d(), null, copy((LLRBValueNode<K, V>) null, (K) null, LLRBNode.Color.RED, (LLRBNode<LLRBValueNode<K, V>, K>) ((LLRBValueNode) this.f30055c).f30056d, (LLRBNode<LLRBValueNode<K, V>, K>) null));
    }

    protected abstract LLRBValueNode<K, V> b(K k4, V v3, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.database.collection.LLRBNode
    public /* bridge */ /* synthetic */ LLRBNode copy(Object obj, Object obj2, LLRBNode.Color color, LLRBNode lLRBNode, LLRBNode lLRBNode2) {
        return copy((LLRBValueNode<K, V>) obj, obj2, color, (LLRBNode<LLRBValueNode<K, V>, Object>) lLRBNode, (LLRBNode<LLRBValueNode<K, V>, Object>) lLRBNode2);
    }

    protected abstract LLRBNode.Color d();

    @Override // com.google.firebase.database.collection.LLRBNode
    public K getKey() {
        return this.f30053a;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getLeft() {
        return this.f30055c;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getMax() {
        if (this.f30056d.isEmpty()) {
            return this;
        }
        return this.f30056d.getMax();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getMin() {
        if (this.f30055c.isEmpty()) {
            return this;
        }
        return this.f30055c.getMin();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getRight() {
        return this.f30056d;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public V getValue() {
        return this.f30054b;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.f30055c.inOrderTraversal(nodeVisitor);
        nodeVisitor.visitEntry(this.f30053a, this.f30054b);
        this.f30056d.inOrderTraversal(nodeVisitor);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> insert(K k4, V v3, Comparator<K> comparator) {
        LLRBValueNode<K, V> b4;
        int compare = comparator.compare(k4, this.f30053a);
        if (compare < 0) {
            b4 = b(null, null, this.f30055c.insert(k4, v3, comparator), null);
        } else if (compare == 0) {
            b4 = b(k4, v3, null, null);
        } else {
            b4 = b(null, null, null, this.f30056d.insert(k4, v3, comparator));
        }
        return b4.c();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(LLRBNode<K, V> lLRBNode) {
        this.f30055c = lLRBNode;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> remove(K k4, Comparator<K> comparator) {
        LLRBValueNode<K, V> lLRBValueNode;
        LLRBValueNode<K, V> b4;
        LLRBValueNode<K, V> lLRBValueNode2;
        if (comparator.compare(k4, this.f30053a) < 0) {
            if (!this.f30055c.isEmpty() && !this.f30055c.isRed() && !((LLRBValueNode) this.f30055c).f30055c.isRed()) {
                lLRBValueNode2 = e();
            } else {
                lLRBValueNode2 = this;
            }
            b4 = lLRBValueNode2.b(null, null, lLRBValueNode2.f30055c.remove(k4, comparator), null);
        } else {
            if (this.f30055c.isRed()) {
                lLRBValueNode = j();
            } else {
                lLRBValueNode = this;
            }
            if (!lLRBValueNode.f30056d.isEmpty() && !lLRBValueNode.f30056d.isRed() && !((LLRBValueNode) lLRBValueNode.f30056d).f30055c.isRed()) {
                lLRBValueNode = lLRBValueNode.f();
            }
            if (comparator.compare(k4, lLRBValueNode.f30053a) == 0) {
                if (lLRBValueNode.f30056d.isEmpty()) {
                    return LLRBEmptyNode.getInstance();
                }
                LLRBNode<K, V> min = lLRBValueNode.f30056d.getMin();
                lLRBValueNode = lLRBValueNode.b(min.getKey(), min.getValue(), null, ((LLRBValueNode) lLRBValueNode.f30056d).h());
            }
            b4 = lLRBValueNode.b(null, null, null, lLRBValueNode.f30056d.remove(k4, comparator));
        }
        return b4.c();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (this.f30055c.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor) && shortCircuitingNodeVisitor.shouldContinue(this.f30053a, this.f30054b)) {
            return this.f30056d.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor);
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (this.f30056d.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor) && shortCircuitingNodeVisitor.shouldContinue(this.f30053a, this.f30054b)) {
            return this.f30055c.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor);
        }
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBValueNode<K, V> copy(K k4, V v3, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k4 == null) {
            k4 = this.f30053a;
        }
        if (v3 == null) {
            v3 = this.f30054b;
        }
        if (lLRBNode == null) {
            lLRBNode = this.f30055c;
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = this.f30056d;
        }
        if (color == LLRBNode.Color.RED) {
            return new LLRBRedValueNode(k4, v3, lLRBNode, lLRBNode2);
        }
        return new LLRBBlackValueNode(k4, v3, lLRBNode, lLRBNode2);
    }
}
