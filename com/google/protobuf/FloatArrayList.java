package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: d  reason: collision with root package name */
    private static final FloatArrayList f33391d;

    /* renamed from: b  reason: collision with root package name */
    private float[] f33392b;

    /* renamed from: c  reason: collision with root package name */
    private int f33393c;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        f33391d = floatArrayList;
        floatArrayList.makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayList() {
        this(new float[10], 0);
    }

    private void d(int i4, float f4) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f33393c)) {
            float[] fArr = this.f33392b;
            if (i5 < fArr.length) {
                System.arraycopy(fArr, i4, fArr, i4 + 1, i5 - i4);
            } else {
                float[] fArr2 = new float[((i5 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i4);
                System.arraycopy(this.f33392b, i4, fArr2, i4 + 1, this.f33393c - i4);
                this.f33392b = fArr2;
            }
            this.f33392b[i4] = f4;
            this.f33393c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(g(i4));
    }

    private void e(int i4) {
        if (i4 >= 0 && i4 < this.f33393c) {
            return;
        }
        throw new IndexOutOfBoundsException(g(i4));
    }

    private String g(int i4) {
        return "Index:" + i4 + ", Size:" + this.f33393c;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i4 = floatArrayList.f33393c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f33393c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            float[] fArr = this.f33392b;
            if (i6 > fArr.length) {
                this.f33392b = Arrays.copyOf(fArr, i6);
            }
            System.arraycopy(floatArrayList.f33392b, 0, this.f33392b, this.f33393c, floatArrayList.f33393c);
            this.f33393c = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float f4) {
        a();
        int i4 = this.f33393c;
        float[] fArr = this.f33392b;
        if (i4 == fArr.length) {
            float[] fArr2 = new float[((i4 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i4);
            this.f33392b = fArr2;
        }
        float[] fArr3 = this.f33392b;
        int i5 = this.f33393c;
        this.f33393c = i5 + 1;
        fArr3[i5] = f4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: b */
    public void add(int i4, Float f4) {
        d(i4, f4.floatValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c */
    public boolean add(Float f4) {
        addFloat(f4.floatValue());
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.f33393c != floatArrayList.f33393c) {
            return false;
        }
        float[] fArr = floatArrayList.f33392b;
        for (int i4 = 0; i4 < this.f33393c; i4++) {
            if (Float.floatToIntBits(this.f33392b[i4]) != Float.floatToIntBits(fArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f */
    public Float get(int i4) {
        return Float.valueOf(getFloat(i4));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int i4) {
        e(i4);
        return this.f33392b[i4];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: h */
    public Float remove(int i4) {
        int i5;
        a();
        e(i4);
        float[] fArr = this.f33392b;
        float f4 = fArr[i4];
        if (i4 < this.f33393c - 1) {
            System.arraycopy(fArr, i4 + 1, fArr, i4, (i5 - i4) - 1);
        }
        this.f33393c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f33393c; i5++) {
            i4 = (i4 * 31) + Float.floatToIntBits(this.f33392b[i5]);
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: i */
    public Float set(int i4, Float f4) {
        return Float.valueOf(setFloat(i4, f4.floatValue()));
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f33392b[i4] == floatValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i4, int i5) {
        a();
        if (i5 >= i4) {
            float[] fArr = this.f33392b;
            System.arraycopy(fArr, i5, fArr, i4, this.f33393c - i5);
            this.f33393c -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int i4, float f4) {
        a();
        e(i4);
        float[] fArr = this.f33392b;
        float f5 = fArr[i4];
        fArr[i4] = f4;
        return f5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33393c;
    }

    private FloatArrayList(float[] fArr, int i4) {
        this.f33392b = fArr;
        this.f33393c = i4;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int i4) {
        if (i4 >= this.f33393c) {
            return new FloatArrayList(Arrays.copyOf(this.f33392b, i4), this.f33393c);
        }
        throw new IllegalArgumentException();
    }
}
