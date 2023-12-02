package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: i  reason: collision with root package name */
    private static final long[] f27367i = {0};

    /* renamed from: j  reason: collision with root package name */
    static final ImmutableSortedMultiset<Comparable> f27368j = new RegularImmutableSortedMultiset(Ordering.natural());
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final transient RegularImmutableSortedSet<E> f27369e;

    /* renamed from: f  reason: collision with root package name */
    private final transient long[] f27370f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f27371g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int f27372h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.f27369e = ImmutableSortedSet.q(comparator);
        this.f27370f = f27367i;
        this.f27371g = 0;
        this.f27372h = 0;
    }

    private int n(int i4) {
        long[] jArr = this.f27370f;
        int i5 = this.f27371g;
        return (int) (jArr[(i5 + i4) + 1] - jArr[i5 + i4]);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        int indexOf = this.f27369e.indexOf(obj);
        if (indexOf >= 0) {
            return n(indexOf);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean f() {
        if (this.f27371g > 0 || this.f27372h < this.f27370f.length - 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return j(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> j(int i4) {
        return Multisets.immutableEntry(this.f27369e.asList().get(i4), n(i4));
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return j(this.f27372h - 1);
    }

    ImmutableSortedMultiset<E> o(int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i5, this.f27372h);
        if (i4 == i5) {
            return ImmutableSortedMultiset.m(comparator());
        }
        if (i4 == 0 && i5 == this.f27372h) {
            return this;
        }
        return new RegularImmutableSortedMultiset(this.f27369e.w(i4, i5), this.f27370f, this.f27371g + i4, i5 - i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] jArr = this.f27370f;
        int i4 = this.f27371g;
        return Ints.saturatedCast(jArr[this.f27372h + i4] - jArr[i4]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e4, BoundType boundType) {
        return o(0, this.f27369e.x(e4, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e4, BoundType boundType) {
        return o(this.f27369e.y(e4, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.f27372h);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet<E> elementSet() {
        return this.f27369e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i4, int i5) {
        this.f27369e = regularImmutableSortedSet;
        this.f27370f = jArr;
        this.f27371g = i4;
        this.f27372h = i5;
    }
}
