package com.koushikdutta.async;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    private static final long serialVersionUID = 2340985798034038923L;

    /* renamed from: a  reason: collision with root package name */
    private transient Object[] f34598a;

    /* renamed from: b  reason: collision with root package name */
    private transient int f34599b;

    /* renamed from: c  reason: collision with root package name */
    private transient int f34600c;

    /* loaded from: classes6.dex */
    private class b implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f34601a;

        /* renamed from: b  reason: collision with root package name */
        private int f34602b;

        /* renamed from: c  reason: collision with root package name */
        private int f34603c;

        private b() {
            this.f34601a = ArrayDeque.this.f34599b;
            this.f34602b = ArrayDeque.this.f34600c;
            this.f34603c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34601a != this.f34602b) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f34601a != this.f34602b) {
                E e4 = (E) ArrayDeque.this.f34598a[this.f34601a];
                if (ArrayDeque.this.f34600c == this.f34602b && e4 != null) {
                    int i4 = this.f34601a;
                    this.f34603c = i4;
                    this.f34601a = (i4 + 1) & (ArrayDeque.this.f34598a.length - 1);
                    return e4;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i4 = this.f34603c;
            if (i4 >= 0) {
                if (ArrayDeque.this.i(i4)) {
                    this.f34601a = (this.f34601a - 1) & (ArrayDeque.this.f34598a.length - 1);
                    this.f34602b = ArrayDeque.this.f34600c;
                }
                this.f34603c = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes6.dex */
    private class c implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f34605a;

        /* renamed from: b  reason: collision with root package name */
        private int f34606b;

        /* renamed from: c  reason: collision with root package name */
        private int f34607c;

        private c() {
            this.f34605a = ArrayDeque.this.f34600c;
            this.f34606b = ArrayDeque.this.f34599b;
            this.f34607c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34605a != this.f34606b) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            int i4 = this.f34605a;
            if (i4 != this.f34606b) {
                this.f34605a = (i4 - 1) & (ArrayDeque.this.f34598a.length - 1);
                E e4 = (E) ArrayDeque.this.f34598a[this.f34605a];
                if (ArrayDeque.this.f34599b == this.f34606b && e4 != null) {
                    this.f34607c = this.f34605a;
                    return e4;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i4 = this.f34607c;
            if (i4 >= 0) {
                if (!ArrayDeque.this.i(i4)) {
                    this.f34605a = (this.f34605a + 1) & (ArrayDeque.this.f34598a.length - 1);
                    this.f34606b = ArrayDeque.this.f34599b;
                }
                this.f34607c = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public ArrayDeque() {
        this.f34598a = new Object[16];
    }

    private void f(int i4) {
        int i5 = 8;
        if (i4 >= 8) {
            int i6 = i4 | (i4 >>> 1);
            int i7 = i6 | (i6 >>> 2);
            int i8 = i7 | (i7 >>> 4);
            int i9 = i8 | (i8 >>> 8);
            i5 = (i9 | (i9 >>> 16)) + 1;
            if (i5 < 0) {
                i5 >>>= 1;
            }
        }
        this.f34598a = new Object[i5];
    }

    private <T> T[] h(T[] tArr) {
        int i4 = this.f34599b;
        int i5 = this.f34600c;
        if (i4 < i5) {
            System.arraycopy(this.f34598a, i4, tArr, 0, size());
        } else if (i4 > i5) {
            Object[] objArr = this.f34598a;
            int length = objArr.length - i4;
            System.arraycopy(objArr, i4, tArr, 0, length);
            System.arraycopy(this.f34598a, 0, tArr, length, this.f34600c);
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(int i4) {
        g();
        Object[] objArr = this.f34598a;
        int length = objArr.length - 1;
        int i5 = this.f34599b;
        int i6 = this.f34600c;
        int i7 = (i4 - i5) & length;
        int i8 = (i6 - i4) & length;
        if (i7 < ((i6 - i5) & length)) {
            if (i7 < i8) {
                if (i5 <= i4) {
                    System.arraycopy(objArr, i5, objArr, i5 + 1, i7);
                } else {
                    System.arraycopy(objArr, 0, objArr, 1, i4);
                    objArr[0] = objArr[length];
                    System.arraycopy(objArr, i5, objArr, i5 + 1, length - i5);
                }
                objArr[i5] = null;
                this.f34599b = (i5 + 1) & length;
                return false;
            }
            if (i4 < i6) {
                System.arraycopy(objArr, i4 + 1, objArr, i4, i8);
                this.f34600c = i6 - 1;
            } else {
                System.arraycopy(objArr, i4 + 1, objArr, i4, length - i4);
                objArr[length] = objArr[0];
                System.arraycopy(objArr, 1, objArr, 0, i6);
                this.f34600c = (i6 - 1) & length;
            }
            return true;
        }
        throw new ConcurrentModificationException();
    }

    private void j() {
        int i4 = this.f34599b;
        Object[] objArr = this.f34598a;
        int length = objArr.length;
        int i5 = length - i4;
        int i6 = length << 1;
        if (i6 >= 0) {
            Object[] objArr2 = new Object[i6];
            System.arraycopy(objArr, i4, objArr2, 0, i5);
            System.arraycopy(this.f34598a, 0, objArr2, i5, i4);
            this.f34598a = objArr2;
            this.f34599b = 0;
            this.f34600c = length;
            return;
        }
        throw new IllegalStateException("Sorry, deque too big");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        f(readInt);
        this.f34599b = 0;
        this.f34600c = readInt;
        for (int i4 = 0; i4 < readInt; i4++) {
            this.f34598a[i4] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.f34598a.length - 1;
        for (int i4 = this.f34599b; i4 != this.f34600c; i4 = (i4 + 1) & length) {
            objectOutputStream.writeObject(this.f34598a[i4]);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.koushikdutta.async.Deque, java.util.Queue
    public boolean add(E e4) {
        addLast(e4);
        return true;
    }

    @Override // com.koushikdutta.async.Deque
    public void addFirst(E e4) {
        if (e4 != null) {
            Object[] objArr = this.f34598a;
            int length = (this.f34599b - 1) & (objArr.length - 1);
            this.f34599b = length;
            objArr[length] = e4;
            if (length == this.f34600c) {
                j();
                return;
            }
            return;
        }
        throw new NullPointerException("e == null");
    }

    @Override // com.koushikdutta.async.Deque
    public void addLast(E e4) {
        if (e4 != null) {
            Object[] objArr = this.f34598a;
            int i4 = this.f34600c;
            objArr[i4] = e4;
            int length = (objArr.length - 1) & (i4 + 1);
            this.f34600c = length;
            if (length == this.f34599b) {
                j();
                return;
            }
            return;
        }
        throw new NullPointerException("e == null");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int i4 = this.f34599b;
        int i5 = this.f34600c;
        if (i4 != i5) {
            this.f34600c = 0;
            this.f34599b = 0;
            int length = this.f34598a.length - 1;
            do {
                this.f34598a[i4] = null;
                i4 = (i4 + 1) & length;
            } while (i4 != i5);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.koushikdutta.async.Deque
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f34598a.length - 1;
        int i4 = this.f34599b;
        while (true) {
            Object obj2 = this.f34598a[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                return true;
            }
            i4 = (i4 + 1) & length;
        }
    }

    @Override // com.koushikdutta.async.Deque
    public Iterator<E> descendingIterator() {
        return new c();
    }

    @Override // com.koushikdutta.async.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // com.koushikdutta.async.Deque
    public E getFirst() {
        E e4 = (E) this.f34598a[this.f34599b];
        if (e4 != null) {
            return e4;
        }
        throw new NoSuchElementException();
    }

    @Override // com.koushikdutta.async.Deque
    public E getLast() {
        Object[] objArr = this.f34598a;
        E e4 = (E) objArr[(this.f34600c - 1) & (objArr.length - 1)];
        if (e4 != null) {
            return e4;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.f34599b == this.f34600c) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.koushikdutta.async.Deque
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // com.koushikdutta.async.Deque, java.util.Queue
    public boolean offer(E e4) {
        return offerLast(e4);
    }

    @Override // com.koushikdutta.async.Deque
    public boolean offerFirst(E e4) {
        addFirst(e4);
        return true;
    }

    @Override // com.koushikdutta.async.Deque
    public boolean offerLast(E e4) {
        addLast(e4);
        return true;
    }

    @Override // com.koushikdutta.async.Deque, java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // com.koushikdutta.async.Deque
    public E peekFirst() {
        return (E) this.f34598a[this.f34599b];
    }

    @Override // com.koushikdutta.async.Deque
    public E peekLast() {
        Object[] objArr = this.f34598a;
        return (E) objArr[(this.f34600c - 1) & (objArr.length - 1)];
    }

    @Override // com.koushikdutta.async.Deque, java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // com.koushikdutta.async.Deque
    public E pollFirst() {
        int i4 = this.f34599b;
        Object[] objArr = this.f34598a;
        E e4 = (E) objArr[i4];
        if (e4 == null) {
            return null;
        }
        objArr[i4] = null;
        this.f34599b = (i4 + 1) & (objArr.length - 1);
        return e4;
    }

    @Override // com.koushikdutta.async.Deque
    public E pollLast() {
        Object[] objArr = this.f34598a;
        int length = (this.f34600c - 1) & (objArr.length - 1);
        E e4 = (E) objArr[length];
        if (e4 == null) {
            return null;
        }
        objArr[length] = null;
        this.f34600c = length;
        return e4;
    }

    @Override // com.koushikdutta.async.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // com.koushikdutta.async.Deque
    public void push(E e4) {
        addFirst(e4);
    }

    @Override // com.koushikdutta.async.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // com.koushikdutta.async.Deque
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.koushikdutta.async.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f34598a.length - 1;
        int i4 = this.f34599b;
        while (true) {
            Object obj2 = this.f34598a[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                i(i4);
                return true;
            }
            i4 = (i4 + 1) & length;
        }
    }

    @Override // com.koushikdutta.async.Deque
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // com.koushikdutta.async.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f34598a.length - 1;
        int i4 = this.f34600c - 1;
        while (true) {
            int i5 = i4 & length;
            Object obj2 = this.f34598a[i5];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                i(i5);
                return true;
            }
            i4 = i5 - 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.koushikdutta.async.Deque
    public int size() {
        return (this.f34600c - this.f34599b) & (this.f34598a.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return h(new Object[size()]);
    }

    /* renamed from: clone */
    public ArrayDeque<E> m4174clone() {
        try {
            ArrayDeque<E> arrayDeque = (ArrayDeque) super.clone();
            Object[] objArr = this.f34598a;
            System.arraycopy(objArr, 0, arrayDeque.f34598a, 0, objArr.length);
            return arrayDeque;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.koushikdutta.async.Deque
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        h(tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public ArrayDeque(int i4) {
        f(i4);
    }

    public ArrayDeque(Collection<? extends E> collection) {
        f(collection.size());
        addAll(collection);
    }

    private void g() {
    }
}
