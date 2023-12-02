package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: e  reason: collision with root package name */
    static final ImmutableList<Object> f27340e = new RegularImmutableList(new Object[0], 0);
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f27341c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f27342d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableList(Object[] objArr, int i4) {
        this.f27341c = objArr;
        this.f27342d = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i4) {
        System.arraycopy(this.f27341c, 0, objArr, i4, this.f27342d);
        return i4 + this.f27342d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.f27341c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.f27342d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int e() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean f() {
        return false;
    }

    @Override // java.util.List
    public E get(int i4) {
        Preconditions.checkElementIndex(i4, this.f27342d);
        E e4 = (E) this.f27341c[i4];
        Objects.requireNonNull(e4);
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f27342d;
    }
}
