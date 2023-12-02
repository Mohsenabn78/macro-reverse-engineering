package com.koushikdutta.async;

import java.util.Iterator;
import java.util.Queue;

/* loaded from: classes6.dex */
public interface Deque<E> extends Queue<E> {
    @Override // java.util.Collection, com.koushikdutta.async.Deque, java.util.Queue
    boolean add(E e4);

    void addFirst(E e4);

    void addLast(E e4);

    @Override // java.util.Collection, com.koushikdutta.async.Deque
    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    @Override // java.util.Queue
    E element();

    E getFirst();

    E getLast();

    @Override // java.util.Collection, java.lang.Iterable, com.koushikdutta.async.Deque
    Iterator<E> iterator();

    @Override // java.util.Queue
    boolean offer(E e4);

    boolean offerFirst(E e4);

    boolean offerLast(E e4);

    @Override // java.util.Queue
    E peek();

    E peekFirst();

    E peekLast();

    @Override // java.util.Queue
    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e4);

    @Override // java.util.Queue
    E remove();

    @Override // java.util.Collection, com.koushikdutta.async.Deque
    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, com.koushikdutta.async.Deque
    int size();
}
