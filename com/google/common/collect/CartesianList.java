package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final transient ImmutableList<List<E>> f26712a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int[] f26713b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CartesianList(ImmutableList<List<E>> immutableList) {
        this.f26712a = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = IntMath.checkedMultiply(iArr[size + 1], immutableList.get(size).size());
            }
            this.f26713b = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> List<List<E>> c(List<? extends List<? extends E>> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        for (List<? extends E> list2 : list) {
            ImmutableList copyOf = ImmutableList.copyOf((Collection) list2);
            if (copyOf.isEmpty()) {
                return ImmutableList.of();
            }
            builder.add((ImmutableList.Builder) copyOf);
        }
        return new CartesianList(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(int i4, int i5) {
        return (i4 / this.f26713b[i5 + 1]) % this.f26712a.get(i5).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List<E> list = (List) obj;
        if (list.size() != this.f26712a.size()) {
            return false;
        }
        int i4 = 0;
        for (E e4 : list) {
            if (!this.f26712a.get(i4).contains(e4)) {
                return false;
            }
            i4++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public ImmutableList<E> get(final int i4) {
        Preconditions.checkElementIndex(i4, size());
        return new ImmutableList<E>() { // from class: com.google.common.collect.CartesianList.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableCollection
            public boolean f() {
                return true;
            }

            @Override // java.util.List
            public E get(int i5) {
                Preconditions.checkElementIndex(i5, size());
                return (E) ((List) CartesianList.this.f26712a.get(i5)).get(CartesianList.this.e(i4, i5));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return CartesianList.this.f26712a.size();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f26712a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i4 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int indexOf = this.f26712a.get(nextIndex).indexOf(listIterator.next());
            if (indexOf == -1) {
                return -1;
            }
            i4 += indexOf * this.f26713b[nextIndex + 1];
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f26712a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i4 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int lastIndexOf = this.f26712a.get(nextIndex).lastIndexOf(listIterator.next());
            if (lastIndexOf == -1) {
                return -1;
            }
            i4 += lastIndexOf * this.f26713b[nextIndex + 1];
        }
        return i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f26713b[0];
    }
}
