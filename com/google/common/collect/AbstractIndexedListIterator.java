package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f26619a;

    /* renamed from: b  reason: collision with root package name */
    private int f26620b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractIndexedListIterator(int i4) {
        this(i4, 0);
    }

    @ParametricNullness
    protected abstract E a(int i4);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f26620b < this.f26619a) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f26620b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    @ParametricNullness
    public final E next() {
        if (hasNext()) {
            int i4 = this.f26620b;
            this.f26620b = i4 + 1;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f26620b;
    }

    @Override // java.util.ListIterator
    @ParametricNullness
    public final E previous() {
        if (hasPrevious()) {
            int i4 = this.f26620b - 1;
            this.f26620b = i4;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f26620b - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractIndexedListIterator(int i4, int i5) {
        Preconditions.checkPositionIndex(i5, i4);
        this.f26619a = i4;
        this.f26620b = i5;
    }
}
