package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class TransformedIterator<F, T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterator<? extends F> f27501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformedIterator(Iterator<? extends F> it) {
        this.f27501a = (Iterator) Preconditions.checkNotNull(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T a(@ParametricNullness F f4);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f27501a.hasNext();
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        return a(this.f27501a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f27501a.remove();
    }
}
