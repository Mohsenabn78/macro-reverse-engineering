package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: f */
    public abstract Iterator<T> e();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return e().hasNext();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public T next() {
        return e().next();
    }

    public void remove() {
        e().remove();
    }
}
