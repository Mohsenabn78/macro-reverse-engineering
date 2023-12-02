package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    private transient int[] f26763f;
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    private transient int[] f26764g;

    /* renamed from: h  reason: collision with root package name */
    private transient int f26765h;

    /* renamed from: i  reason: collision with root package name */
    private transient int f26766i;

    CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> E(int i4) {
        return new CompactLinkedHashSet<>(i4);
    }

    private int F(int i4) {
        return G()[i4] - 1;
    }

    private int[] G() {
        int[] iArr = this.f26763f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private int[] H() {
        int[] iArr = this.f26764g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private void I(int i4, int i5) {
        G()[i4] = i5 + 1;
    }

    private void J(int i4, int i5) {
        if (i4 == -2) {
            this.f26765h = i5;
        } else {
            K(i4, i5);
        }
        if (i5 == -2) {
            this.f26766i = i4;
        } else {
            I(i5, i4);
        }
    }

    private void K(int i4, int i5) {
        H()[i4] = i5 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    int c(int i4, int i5) {
        if (i4 >= size()) {
            return i5;
        }
        return i4;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (u()) {
            return;
        }
        this.f26765h = -2;
        this.f26766i = -2;
        int[] iArr = this.f26763f;
        if (iArr != null && this.f26764g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f26764g, 0, size(), 0);
        }
        super.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public int e() {
        int e4 = super.e();
        this.f26763f = new int[e4];
        this.f26764g = new int[e4];
        return e4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    @CanIgnoreReturnValue
    public Set<E> f() {
        Set<E> f4 = super.f();
        this.f26763f = null;
        this.f26764g = null;
        return f4;
    }

    @Override // com.google.common.collect.CompactHashSet
    int n() {
        return this.f26765h;
    }

    @Override // com.google.common.collect.CompactHashSet
    int o(int i4) {
        return H()[i4] - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void r(int i4) {
        super.r(i4);
        this.f26765h = -2;
        this.f26766i = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void s(int i4, @ParametricNullness E e4, int i5, int i6) {
        super.s(i4, e4, i5, i6);
        J(this.f26766i, i4);
        J(i4, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void t(int i4, int i5) {
        int size = size() - 1;
        super.t(i4, i5);
        J(F(i4), o(i4));
        if (i4 < size) {
            J(F(size), i4);
            J(i4, o(size));
        }
        G()[size] = 0;
        H()[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.e(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void y(int i4) {
        super.y(i4);
        this.f26763f = Arrays.copyOf(G(), i4);
        this.f26764g = Arrays.copyOf(H(), i4);
    }

    CompactLinkedHashSet(int i4) {
        super(i4);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.f(this, tArr);
    }
}
