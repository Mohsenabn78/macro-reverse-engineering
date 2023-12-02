package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: d  reason: collision with root package name */
    private static final BooleanArrayList f33194d;

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f33195b;

    /* renamed from: c  reason: collision with root package name */
    private int f33196c;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        f33194d = booleanArrayList;
        booleanArrayList.makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private void d(int i4, boolean z3) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f33196c)) {
            boolean[] zArr = this.f33195b;
            if (i5 < zArr.length) {
                System.arraycopy(zArr, i4, zArr, i4 + 1, i5 - i4);
            } else {
                boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i4);
                System.arraycopy(this.f33195b, i4, zArr2, i4 + 1, this.f33196c - i4);
                this.f33195b = zArr2;
            }
            this.f33195b[i4] = z3;
            this.f33196c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(g(i4));
    }

    private void e(int i4) {
        if (i4 >= 0 && i4 < this.f33196c) {
            return;
        }
        throw new IndexOutOfBoundsException(g(i4));
    }

    private String g(int i4) {
        return "Index:" + i4 + ", Size:" + this.f33196c;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i4 = booleanArrayList.f33196c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f33196c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            boolean[] zArr = this.f33195b;
            if (i6 > zArr.length) {
                this.f33195b = Arrays.copyOf(zArr, i6);
            }
            System.arraycopy(booleanArrayList.f33195b, 0, this.f33195b, this.f33196c, booleanArrayList.f33196c);
            this.f33196c = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z3) {
        a();
        int i4 = this.f33196c;
        boolean[] zArr = this.f33195b;
        if (i4 == zArr.length) {
            boolean[] zArr2 = new boolean[((i4 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            this.f33195b = zArr2;
        }
        boolean[] zArr3 = this.f33195b;
        int i5 = this.f33196c;
        this.f33196c = i5 + 1;
        zArr3[i5] = z3;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: b */
    public void add(int i4, Boolean bool) {
        d(i4, bool.booleanValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c */
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
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
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.f33196c != booleanArrayList.f33196c) {
            return false;
        }
        boolean[] zArr = booleanArrayList.f33195b;
        for (int i4 = 0; i4 < this.f33196c; i4++) {
            if (this.f33195b[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f */
    public Boolean get(int i4) {
        return Boolean.valueOf(getBoolean(i4));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int i4) {
        e(i4);
        return this.f33195b[i4];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: h */
    public Boolean remove(int i4) {
        int i5;
        a();
        e(i4);
        boolean[] zArr = this.f33195b;
        boolean z3 = zArr[i4];
        if (i4 < this.f33196c - 1) {
            System.arraycopy(zArr, i4 + 1, zArr, i4, (i5 - i4) - 1);
        }
        this.f33196c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z3);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f33196c; i5++) {
            i4 = (i4 * 31) + Internal.hashBoolean(this.f33195b[i5]);
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: i */
    public Boolean set(int i4, Boolean bool) {
        return Boolean.valueOf(setBoolean(i4, bool.booleanValue()));
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f33195b[i4] == booleanValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i4, int i5) {
        a();
        if (i5 >= i4) {
            boolean[] zArr = this.f33195b;
            System.arraycopy(zArr, i5, zArr, i4, this.f33196c - i5);
            this.f33196c -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int i4, boolean z3) {
        a();
        e(i4);
        boolean[] zArr = this.f33195b;
        boolean z4 = zArr[i4];
        zArr[i4] = z3;
        return z4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33196c;
    }

    private BooleanArrayList(boolean[] zArr, int i4) {
        this.f33195b = zArr;
        this.f33196c = i4;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int i4) {
        if (i4 >= this.f33196c) {
            return new BooleanArrayList(Arrays.copyOf(this.f33195b, i4), this.f33196c);
        }
        throw new IllegalArgumentException();
    }
}
