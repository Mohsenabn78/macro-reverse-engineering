package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ImmutableSortedSet<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableSortedMap<T, Void> f30048a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WrappedEntryIterator<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<T, Void>> f30049a;

        public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> it) {
            this.f30049a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30049a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f30049a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f30049a.remove();
        }
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator) {
        this.f30048a = ImmutableSortedMap.Builder.buildFrom(list, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    public boolean contains(T t3) {
        return this.f30048a.containsKey(t3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableSortedSet)) {
            return false;
        }
        return this.f30048a.equals(((ImmutableSortedSet) obj).f30048a);
    }

    public T getMaxEntry() {
        return this.f30048a.getMaxKey();
    }

    public T getMinEntry() {
        return this.f30048a.getMinKey();
    }

    public T getPredecessorEntry(T t3) {
        return this.f30048a.getPredecessorKey(t3);
    }

    public int hashCode() {
        return this.f30048a.hashCode();
    }

    public int indexOf(T t3) {
        return this.f30048a.indexOf(t3);
    }

    public ImmutableSortedSet<T> insert(T t3) {
        return new ImmutableSortedSet<>(this.f30048a.insert(t3, null));
    }

    public boolean isEmpty() {
        return this.f30048a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new WrappedEntryIterator(this.f30048a.iterator());
    }

    public Iterator<T> iteratorFrom(T t3) {
        return new WrappedEntryIterator(this.f30048a.iteratorFrom(t3));
    }

    public ImmutableSortedSet<T> remove(T t3) {
        ImmutableSortedMap<T, Void> remove = this.f30048a.remove(t3);
        if (remove == this.f30048a) {
            return this;
        }
        return new ImmutableSortedSet<>(remove);
    }

    public Iterator<T> reverseIterator() {
        return new WrappedEntryIterator(this.f30048a.reverseIterator());
    }

    public Iterator<T> reverseIteratorFrom(T t3) {
        return new WrappedEntryIterator(this.f30048a.reverseIteratorFrom(t3));
    }

    public int size() {
        return this.f30048a.size();
    }

    public ImmutableSortedSet<T> unionWith(ImmutableSortedSet<T> immutableSortedSet) {
        ImmutableSortedSet<T> immutableSortedSet2;
        if (size() < immutableSortedSet.size()) {
            immutableSortedSet2 = immutableSortedSet;
            immutableSortedSet = this;
        } else {
            immutableSortedSet2 = this;
        }
        Iterator<T> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            immutableSortedSet2 = immutableSortedSet2.insert(it.next());
        }
        return immutableSortedSet2;
    }

    private ImmutableSortedSet(ImmutableSortedMap<T, Void> immutableSortedMap) {
        this.f30048a = immutableSortedMap;
    }
}
