package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes5.dex */
public final class ImmutableList<E> implements List<E>, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final List<E> f29957a;

    private ImmutableList(List<E> list) {
        this.f29957a = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e4) {
        return this.f29957a.add(e4);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.f29957a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f29957a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.f29957a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f29957a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return this.f29957a.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i4) {
        return this.f29957a.get(i4);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f29957a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.f29957a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f29957a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f29957a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.f29957a.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.f29957a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.f29957a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f29957a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f29957a.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i4, @NonNull E e4) {
        return this.f29957a.set(i4, e4);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f29957a.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i4, int i5) {
        return this.f29957a.subList(i4, i5);
    }

    @Override // java.util.List, java.util.Collection
    @Nullable
    public Object[] toArray() {
        return this.f29957a.toArray();
    }

    @NonNull
    public static <E> ImmutableList<E> from(@NonNull List<E> list) {
        return new ImmutableList<>(list);
    }

    @Override // java.util.List
    public void add(int i4, @NonNull E e4) {
        this.f29957a.add(i4, e4);
    }

    @Override // java.util.List
    public boolean addAll(int i4, @NonNull Collection<? extends E> collection) {
        return this.f29957a.addAll(i4, collection);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i4) {
        return this.f29957a.listIterator(i4);
    }

    @Override // java.util.List
    public E remove(int i4) {
        return this.f29957a.remove(i4);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(@Nullable T[] tArr) {
        return (T[]) this.f29957a.toArray(tArr);
    }
}
