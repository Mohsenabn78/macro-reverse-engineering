package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private transient SortedMultiset<E> f26685c;
    @GwtTransient
    final Comparator<? super E> comparator;

    AbstractSortedMultiset() {
        this(Ordering.natural());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    Iterator<E> descendingIterator() {
        return Multisets.h(descendingMultiset());
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.f26685c;
        if (sortedMultiset == null) {
            SortedMultiset<E> f4 = f();
            this.f26685c = f4;
            return f4;
        }
        return sortedMultiset;
    }

    SortedMultiset<E> f() {
        return new DescendingMultiset<E>() { // from class: com.google.common.collect.AbstractSortedMultiset.1DescendingMultisetImpl
            @Override // com.google.common.collect.DescendingMultiset, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<E> iterator() {
                return AbstractSortedMultiset.this.descendingIterator();
            }

            @Override // com.google.common.collect.DescendingMultiset
            Iterator<Multiset.Entry<E>> p() {
                return AbstractSortedMultiset.this.h();
            }

            @Override // com.google.common.collect.DescendingMultiset
            SortedMultiset<E> q() {
                return AbstractSortedMultiset.this;
            }
        };
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> e4 = e();
        if (e4.hasNext()) {
            return e4.next();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    /* renamed from: g */
    public NavigableSet<E> a() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    abstract Iterator<Multiset.Entry<E>> h();

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> h4 = h();
        if (h4.hasNext()) {
            return h4.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> e4 = e();
        if (e4.hasNext()) {
            Multiset.Entry<E> next = e4.next();
            Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(next.getElement(), next.getCount());
            e4.remove();
            return immutableEntry;
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> h4 = h();
        if (h4.hasNext()) {
            Multiset.Entry<E> next = h4.next();
            Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(next.getElement(), next.getCount());
            h4.remove();
            return immutableEntry;
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(@ParametricNullness E e4, BoundType boundType, @ParametricNullness E e5, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return tailMultiset(e4, boundType).headMultiset(e5, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSortedMultiset(Comparator<? super E> comparator) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
