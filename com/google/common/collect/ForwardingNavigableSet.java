package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    /* loaded from: classes5.dex */
    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E ceiling(@ParametricNullness E e4) {
        return p().ceiling(e4);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return p().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return p().descendingSet();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E floor(@ParametricNullness E e4) {
        return p().floor(e4);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(@ParametricNullness E e4, boolean z3) {
        return p().headSet(e4, z3);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E higher(@ParametricNullness E e4) {
        return p().higher(e4);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E lower(@ParametricNullness E e4) {
        return p().lower(e4);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollFirst() {
        return p().pollFirst();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollLast() {
        return p().pollLast();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedSet
    /* renamed from: q */
    public abstract NavigableSet<E> p();

    /* JADX INFO: Access modifiers changed from: protected */
    public SortedSet<E> r(@ParametricNullness E e4) {
        return headSet(e4, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SortedSet<E> s(@ParametricNullness E e4, @ParametricNullness E e5) {
        return subSet(e4, true, e5, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(@ParametricNullness E e4, boolean z3, @ParametricNullness E e5, boolean z4) {
        return p().subSet(e4, z3, e5, z4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SortedSet<E> t(@ParametricNullness E e4) {
        return tailSet(e4, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(@ParametricNullness E e4, boolean z3) {
        return p().tailSet(e4, z3);
    }
}
