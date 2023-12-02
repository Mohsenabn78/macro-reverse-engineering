package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: d  reason: collision with root package name */
    private static final IntArrayList f33415d;

    /* renamed from: b  reason: collision with root package name */
    private int[] f33416b;

    /* renamed from: c  reason: collision with root package name */
    private int f33417c;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        f33415d = intArrayList;
        intArrayList.makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntArrayList() {
        this(new int[10], 0);
    }

    private void d(int i4, int i5) {
        int i6;
        a();
        if (i4 >= 0 && i4 <= (i6 = this.f33417c)) {
            int[] iArr = this.f33416b;
            if (i6 < iArr.length) {
                System.arraycopy(iArr, i4, iArr, i4 + 1, i6 - i4);
            } else {
                int[] iArr2 = new int[((i6 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i4);
                System.arraycopy(this.f33416b, i4, iArr2, i4 + 1, this.f33417c - i4);
                this.f33416b = iArr2;
            }
            this.f33416b[i4] = i5;
            this.f33417c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(h(i4));
    }

    public static IntArrayList e() {
        return f33415d;
    }

    private void f(int i4) {
        if (i4 >= 0 && i4 < this.f33417c) {
            return;
        }
        throw new IndexOutOfBoundsException(h(i4));
    }

    private String h(int i4) {
        return "Index:" + i4 + ", Size:" + this.f33417c;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i4 = intArrayList.f33417c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f33417c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            int[] iArr = this.f33416b;
            if (i6 > iArr.length) {
                this.f33416b = Arrays.copyOf(iArr, i6);
            }
            System.arraycopy(intArrayList.f33416b, 0, this.f33416b, this.f33417c, intArrayList.f33417c);
            this.f33417c = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int i4) {
        a();
        int i5 = this.f33417c;
        int[] iArr = this.f33416b;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            this.f33416b = iArr2;
        }
        int[] iArr3 = this.f33416b;
        int i6 = this.f33417c;
        this.f33417c = i6 + 1;
        iArr3[i6] = i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: b */
    public void add(int i4, Integer num) {
        d(i4, num.intValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c */
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f33417c != intArrayList.f33417c) {
            return false;
        }
        int[] iArr = intArrayList.f33416b;
        for (int i4 = 0; i4 < this.f33417c; i4++) {
            if (this.f33416b[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public Integer get(int i4) {
        return Integer.valueOf(getInt(i4));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i4) {
        f(i4);
        return this.f33416b[i4];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f33417c; i5++) {
            i4 = (i4 * 31) + this.f33416b[i5];
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: i */
    public Integer remove(int i4) {
        int i5;
        a();
        f(i4);
        int[] iArr = this.f33416b;
        int i6 = iArr[i4];
        if (i4 < this.f33417c - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (i5 - i4) - 1);
        }
        this.f33417c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f33416b[i4] == intValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: j */
    public Integer set(int i4, Integer num) {
        return Integer.valueOf(setInt(i4, num.intValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i4, int i5) {
        a();
        if (i5 >= i4) {
            int[] iArr = this.f33416b;
            System.arraycopy(iArr, i5, iArr, i4, this.f33417c - i5);
            this.f33417c -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int i4, int i5) {
        a();
        f(i4);
        int[] iArr = this.f33416b;
        int i6 = iArr[i4];
        iArr[i4] = i5;
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33417c;
    }

    private IntArrayList(int[] iArr, int i4) {
        this.f33416b = iArr;
        this.f33417c = i4;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int i4) {
        if (i4 >= this.f33417c) {
            return new IntArrayList(Arrays.copyOf(this.f33416b, i4), this.f33417c);
        }
        throw new IllegalArgumentException();
    }
}
