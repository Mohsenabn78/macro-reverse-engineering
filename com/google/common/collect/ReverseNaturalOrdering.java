package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final ReverseNaturalOrdering f27375a = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return f27375a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* renamed from: b */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: c */
    public <E extends Comparable<?>> E max(E e4, E e5) {
        return (E) NaturalOrdering.f27305c.min(e4, e5);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: e */
    public <E extends Comparable<?>> E max(E e4, E e5, E e6, E... eArr) {
        return (E) NaturalOrdering.f27305c.min(e4, e5, e6, eArr);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: f */
    public <E extends Comparable<?>> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.f27305c.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: g */
    public <E extends Comparable<?>> E max(Iterator<E> it) {
        return (E) NaturalOrdering.f27305c.min(it);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: h */
    public <E extends Comparable<?>> E min(E e4, E e5) {
        return (E) NaturalOrdering.f27305c.max(e4, e5);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: i */
    public <E extends Comparable<?>> E min(E e4, E e5, E e6, E... eArr) {
        return (E) NaturalOrdering.f27305c.max(e4, e5, e6, eArr);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: j */
    public <E extends Comparable<?>> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.f27305c.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* renamed from: l */
    public <E extends Comparable<?>> E min(Iterator<E> it) {
        return (E) NaturalOrdering.f27305c.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
