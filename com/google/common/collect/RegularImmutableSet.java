package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class RegularImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: h  reason: collision with root package name */
    private static final Object[] f27360h;

    /* renamed from: i  reason: collision with root package name */
    static final RegularImmutableSet<Object> f27361i;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f27362c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f27363d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final transient Object[] f27364e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f27365f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f27366g;

    static {
        Object[] objArr = new Object[0];
        f27360h = objArr;
        f27361i = new RegularImmutableSet<>(objArr, 0, objArr, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSet(Object[] objArr, int i4, Object[] objArr2, int i5, int i6) {
        this.f27362c = objArr;
        this.f27363d = i4;
        this.f27364e = objArr2;
        this.f27365f = i5;
        this.f27366g = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i4) {
        System.arraycopy(this.f27362c, 0, objArr, i4, this.f27366g);
        return i4 + this.f27366g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.f27362c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.f27366g;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.f27364e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int d4 = Hashing.d(obj);
        while (true) {
            int i4 = d4 & this.f27365f;
            Object obj2 = objArr[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            d4 = i4 + 1;
        }
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

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f27363d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> l() {
        return ImmutableList.h(this.f27362c, this.f27366g);
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean m() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f27366g;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }
}
