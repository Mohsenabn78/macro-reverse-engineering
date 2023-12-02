package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    @Override // java.util.SortedSet
    @CheckForNull
    public Comparator<? super E> comparator() {
        return n().comparator();
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E first() {
        return n().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(@ParametricNullness E e4) {
        return n().headSet(e4);
    }

    @Override // java.util.SortedSet
    @ParametricNullness
    public E last() {
        return n().last();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet
    /* renamed from: p */
    public abstract SortedSet<E> n();

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(@ParametricNullness E e4, @ParametricNullness E e5) {
        return n().subSet(e4, e5);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(@ParametricNullness E e4) {
        return n().tailSet(e4);
    }
}
