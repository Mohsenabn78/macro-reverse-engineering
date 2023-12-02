package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: d  reason: collision with root package name */
    private static final DoubleArrayList f33319d;

    /* renamed from: b  reason: collision with root package name */
    private double[] f33320b;

    /* renamed from: c  reason: collision with root package name */
    private int f33321c;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        f33319d = doubleArrayList;
        doubleArrayList.makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleArrayList() {
        this(new double[10], 0);
    }

    private void d(int i4, double d4) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f33321c)) {
            double[] dArr = this.f33320b;
            if (i5 < dArr.length) {
                System.arraycopy(dArr, i4, dArr, i4 + 1, i5 - i4);
            } else {
                double[] dArr2 = new double[((i5 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i4);
                System.arraycopy(this.f33320b, i4, dArr2, i4 + 1, this.f33321c - i4);
                this.f33320b = dArr2;
            }
            this.f33320b[i4] = d4;
            this.f33321c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(h(i4));
    }

    public static DoubleArrayList e() {
        return f33319d;
    }

    private void f(int i4) {
        if (i4 >= 0 && i4 < this.f33321c) {
            return;
        }
        throw new IndexOutOfBoundsException(h(i4));
    }

    private String h(int i4) {
        return "Index:" + i4 + ", Size:" + this.f33321c;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i4 = doubleArrayList.f33321c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f33321c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            double[] dArr = this.f33320b;
            if (i6 > dArr.length) {
                this.f33320b = Arrays.copyOf(dArr, i6);
            }
            System.arraycopy(doubleArrayList.f33320b, 0, this.f33320b, this.f33321c, doubleArrayList.f33321c);
            this.f33321c = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double d4) {
        a();
        int i4 = this.f33321c;
        double[] dArr = this.f33320b;
        if (i4 == dArr.length) {
            double[] dArr2 = new double[((i4 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i4);
            this.f33320b = dArr2;
        }
        double[] dArr3 = this.f33320b;
        int i5 = this.f33321c;
        this.f33321c = i5 + 1;
        dArr3[i5] = d4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: b */
    public void add(int i4, Double d4) {
        d(i4, d4.doubleValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c */
    public boolean add(Double d4) {
        addDouble(d4.doubleValue());
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.f33321c != doubleArrayList.f33321c) {
            return false;
        }
        double[] dArr = doubleArrayList.f33320b;
        for (int i4 = 0; i4 < this.f33321c; i4++) {
            if (Double.doubleToLongBits(this.f33320b[i4]) != Double.doubleToLongBits(dArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public Double get(int i4) {
        return Double.valueOf(getDouble(i4));
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i4) {
        f(i4);
        return this.f33320b[i4];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f33321c; i5++) {
            i4 = (i4 * 31) + Internal.hashLong(Double.doubleToLongBits(this.f33320b[i5]));
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: i */
    public Double remove(int i4) {
        int i5;
        a();
        f(i4);
        double[] dArr = this.f33320b;
        double d4 = dArr[i4];
        if (i4 < this.f33321c - 1) {
            System.arraycopy(dArr, i4 + 1, dArr, i4, (i5 - i4) - 1);
        }
        this.f33321c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f33320b[i4] == doubleValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: j */
    public Double set(int i4, Double d4) {
        return Double.valueOf(setDouble(i4, d4.doubleValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i4, int i5) {
        a();
        if (i5 >= i4) {
            double[] dArr = this.f33320b;
            System.arraycopy(dArr, i5, dArr, i4, this.f33321c - i5);
            this.f33321c -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int i4, double d4) {
        a();
        f(i4);
        double[] dArr = this.f33320b;
        double d5 = dArr[i4];
        dArr[i4] = d4;
        return d5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33321c;
    }

    private DoubleArrayList(double[] dArr, int i4) {
        this.f33320b = dArr;
        this.f33321c = i4;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Double> mutableCopyWithCapacity2(int i4) {
        if (i4 >= this.f33321c) {
            return new DoubleArrayList(Arrays.copyOf(this.f33320b, i4), this.f33321c);
        }
        throw new IllegalArgumentException();
    }
}
