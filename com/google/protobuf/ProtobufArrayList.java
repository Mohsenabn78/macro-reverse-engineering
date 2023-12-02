package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final ProtobufArrayList<Object> f33517d;

    /* renamed from: b  reason: collision with root package name */
    private E[] f33518b;

    /* renamed from: c  reason: collision with root package name */
    private int f33519c;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        f33517d = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] b(int i4) {
        return (E[]) new Object[i4];
    }

    public static <E> ProtobufArrayList<E> c() {
        return (ProtobufArrayList<E>) f33517d;
    }

    private void d(int i4) {
        if (i4 >= 0 && i4 < this.f33519c) {
            return;
        }
        throw new IndexOutOfBoundsException(e(i4));
    }

    private String e(int i4) {
        return "Index:" + i4 + ", Size:" + this.f33519c;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e4) {
        a();
        int i4 = this.f33519c;
        E[] eArr = this.f33518b;
        if (i4 == eArr.length) {
            this.f33518b = (E[]) Arrays.copyOf(eArr, ((i4 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f33518b;
        int i5 = this.f33519c;
        this.f33519c = i5 + 1;
        eArr2[i5] = e4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: f */
    public ProtobufArrayList<E> mutableCopyWithCapacity(int i4) {
        if (i4 >= this.f33519c) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.f33518b, i4), this.f33519c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i4) {
        d(i4);
        return this.f33518b[i4];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i4) {
        int i5;
        a();
        d(i4);
        E[] eArr = this.f33518b;
        E e4 = eArr[i4];
        if (i4 < this.f33519c - 1) {
            System.arraycopy(eArr, i4 + 1, eArr, i4, (i5 - i4) - 1);
        }
        this.f33519c--;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i4, E e4) {
        a();
        d(i4);
        E[] eArr = this.f33518b;
        E e5 = eArr[i4];
        eArr[i4] = e4;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33519c;
    }

    private ProtobufArrayList(E[] eArr, int i4) {
        this.f33518b = eArr;
        this.f33519c = i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i4, E e4) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f33519c)) {
            E[] eArr = this.f33518b;
            if (i5 < eArr.length) {
                System.arraycopy(eArr, i4, eArr, i4 + 1, i5 - i4);
            } else {
                E[] eArr2 = (E[]) b(((i5 * 3) / 2) + 1);
                System.arraycopy(this.f33518b, 0, eArr2, 0, i4);
                System.arraycopy(this.f33518b, i4, eArr2, i4 + 1, this.f33519c - i4);
                this.f33518b = eArr2;
            }
            this.f33518b[i4] = e4;
            this.f33519c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(e(i4));
    }
}
