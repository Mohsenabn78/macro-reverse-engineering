package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    static final NaturalOrdering f27305c = new NaturalOrdering();
    private static final long serialVersionUID = 0;
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private transient Ordering<Comparable<?>> f27306a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private transient Ordering<Comparable<?>> f27307b;

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return f27305c;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* renamed from: b */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> nullsFirst() {
        Ordering<S> ordering = (Ordering<S>) this.f27306a;
        if (ordering == null) {
            Ordering<S> nullsFirst = super.nullsFirst();
            this.f27306a = nullsFirst;
            return nullsFirst;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> nullsLast() {
        Ordering<S> ordering = (Ordering<S>) this.f27307b;
        if (ordering == null) {
            Ordering<S> nullsLast = super.nullsLast();
            this.f27307b = nullsLast;
            return nullsLast;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return ReverseNaturalOrdering.f27375a;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
