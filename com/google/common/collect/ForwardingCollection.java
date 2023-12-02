package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    @CanIgnoreReturnValue
    public boolean add(@ParametricNullness E e4) {
        return e().add(e4);
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return e().addAll(collection);
    }

    public void clear() {
        e().clear();
    }

    public boolean contains(@CheckForNull Object obj) {
        return e().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return e().containsAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: f */
    public abstract Collection<E> e();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(Collection<? extends E> collection) {
        return Iterators.addAll(this, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(Collection<?> collection) {
        return Collections2.b(this, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(Collection<?> collection) {
        return Iterators.retainAll(iterator(), collection);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return e().isEmpty();
    }

    public Iterator<E> iterator() {
        return e().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] j() {
        return toArray(new Object[size()]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T[] l(T[] tArr) {
        return (T[]) ObjectArrays.f(this, tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String m() {
        return Collections2.h(this);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        return e().remove(obj);
    }

    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return e().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return e().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return e().size();
    }

    public Object[] toArray() {
        return e().toArray();
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) e().toArray(tArr);
    }
}
