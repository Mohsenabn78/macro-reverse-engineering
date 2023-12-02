package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    public void add(int i4, @ParametricNullness E e4) {
        f().add(i4, e4);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i4, Collection<? extends E> collection) {
        return f().addAll(i4, collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        if (obj != this && !f().equals(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.List
    @ParametricNullness
    public E get(int i4) {
        return f().get(i4);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f().hashCode();
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        return f().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        return f().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return f().listIterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    /* renamed from: n */
    public abstract List<E> f();

    @Override // java.util.List
    @ParametricNullness
    @CanIgnoreReturnValue
    public E remove(int i4) {
        return f().remove(i4);
    }

    @Override // java.util.List
    @ParametricNullness
    @CanIgnoreReturnValue
    public E set(int i4, @ParametricNullness E e4) {
        return f().set(i4, e4);
    }

    @Override // java.util.List
    public List<E> subList(int i4, int i5) {
        return f().subList(i4, i5);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i4) {
        return f().listIterator(i4);
    }
}
