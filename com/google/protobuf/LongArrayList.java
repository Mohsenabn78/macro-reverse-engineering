package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: d  reason: collision with root package name */
    private static final LongArrayList f33459d;

    /* renamed from: b  reason: collision with root package name */
    private long[] f33460b;

    /* renamed from: c  reason: collision with root package name */
    private int f33461c;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        f33459d = longArrayList;
        longArrayList.makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongArrayList() {
        this(new long[10], 0);
    }

    private void d(int i4, long j4) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f33461c)) {
            long[] jArr = this.f33460b;
            if (i5 < jArr.length) {
                System.arraycopy(jArr, i4, jArr, i4 + 1, i5 - i4);
            } else {
                long[] jArr2 = new long[((i5 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                System.arraycopy(this.f33460b, i4, jArr2, i4 + 1, this.f33461c - i4);
                this.f33460b = jArr2;
            }
            this.f33460b[i4] = j4;
            this.f33461c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(h(i4));
    }

    public static LongArrayList e() {
        return f33459d;
    }

    private void f(int i4) {
        if (i4 >= 0 && i4 < this.f33461c) {
            return;
        }
        throw new IndexOutOfBoundsException(h(i4));
    }

    private String h(int i4) {
        return "Index:" + i4 + ", Size:" + this.f33461c;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i4 = longArrayList.f33461c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f33461c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            long[] jArr = this.f33460b;
            if (i6 > jArr.length) {
                this.f33460b = Arrays.copyOf(jArr, i6);
            }
            System.arraycopy(longArrayList.f33460b, 0, this.f33460b, this.f33461c, longArrayList.f33461c);
            this.f33461c = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long j4) {
        a();
        int i4 = this.f33461c;
        long[] jArr = this.f33460b;
        if (i4 == jArr.length) {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            this.f33460b = jArr2;
        }
        long[] jArr3 = this.f33460b;
        int i5 = this.f33461c;
        this.f33461c = i5 + 1;
        jArr3[i5] = j4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: b */
    public void add(int i4, Long l4) {
        d(i4, l4.longValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: c */
    public boolean add(Long l4) {
        addLong(l4.longValue());
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f33461c != longArrayList.f33461c) {
            return false;
        }
        long[] jArr = longArrayList.f33460b;
        for (int i4 = 0; i4 < this.f33461c; i4++) {
            if (this.f33460b[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public Long get(int i4) {
        return Long.valueOf(getLong(i4));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i4) {
        f(i4);
        return this.f33460b[i4];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f33461c; i5++) {
            i4 = (i4 * 31) + Internal.hashLong(this.f33460b[i5]);
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: i */
    public Long remove(int i4) {
        int i5;
        a();
        f(i4);
        long[] jArr = this.f33460b;
        long j4 = jArr[i4];
        if (i4 < this.f33461c - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (i5 - i4) - 1);
        }
        this.f33461c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f33460b[i4] == longValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* renamed from: j */
    public Long set(int i4, Long l4) {
        return Long.valueOf(setLong(i4, l4.longValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i4, int i5) {
        a();
        if (i5 >= i4) {
            long[] jArr = this.f33460b;
            System.arraycopy(jArr, i5, jArr, i4, this.f33461c - i5);
            this.f33461c -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int i4, long j4) {
        a();
        f(i4);
        long[] jArr = this.f33460b;
        long j5 = jArr[i4];
        jArr[i4] = j4;
        return j5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33461c;
    }

    private LongArrayList(long[] jArr, int i4) {
        this.f33460b = jArr;
        this.f33461c = i4;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int i4) {
        if (i4 >= this.f33461c) {
            return new LongArrayList(Arrays.copyOf(this.f33460b, i4), this.f33461c);
        }
        throw new IllegalArgumentException();
    }
}
