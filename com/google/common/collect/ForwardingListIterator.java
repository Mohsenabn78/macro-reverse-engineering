package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ListIterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    protected ForwardingListIterator() {
    }

    @Override // java.util.ListIterator
    public void add(@ParametricNullness E e4) {
        f().add(e4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingIterator
    /* renamed from: g */
    public abstract ListIterator<E> f();

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return f().hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return f().nextIndex();
    }

    @Override // java.util.ListIterator
    @ParametricNullness
    @CanIgnoreReturnValue
    public E previous() {
        return f().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return f().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(@ParametricNullness E e4) {
        f().set(e4);
    }
}
