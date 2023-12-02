package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzby extends zzq<Long> implements zzcw, RandomAccess {
    private static final zzby zzkg;
    private int size;
    private long[] zzkh;

    static {
        zzby zzbyVar = new zzby(new long[0], 0);
        zzkg = zzbyVar;
        zzbyVar.zzab();
    }

    zzby() {
        this(new long[10], 0);
    }

    private final void zzf(int i4) {
        if (i4 >= 0 && i4 < this.size) {
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    private final String zzg(int i4) {
        int i5 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i4);
        sb.append(", Size:");
        sb.append(i5);
        return sb.toString();
    }

    private final void zzl(int i4, long j4) {
        int i5;
        zzac();
        if (i4 >= 0 && i4 <= (i5 = this.size)) {
            long[] jArr = this.zzkh;
            if (i5 < jArr.length) {
                System.arraycopy(jArr, i4, jArr, i4 + 1, i5 - i4);
            } else {
                long[] jArr2 = new long[((i5 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                System.arraycopy(this.zzkh, i4, jArr2, i4 + 1, this.size - i4);
                this.zzkh = jArr2;
            }
            this.zzkh[i4] = j4;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        zzl(i4, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzby)) {
            return super.addAll(collection);
        }
        zzby zzbyVar = (zzby) collection;
        int i4 = zzbyVar.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            long[] jArr = this.zzkh;
            if (i6 > jArr.length) {
                this.zzkh = Arrays.copyOf(jArr, i6);
            }
            System.arraycopy(zzbyVar.zzkh, 0, this.zzkh, this.size, zzbyVar.size);
            this.size = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzby)) {
            return super.equals(obj);
        }
        zzby zzbyVar = (zzby) obj;
        if (this.size != zzbyVar.size) {
            return false;
        }
        long[] jArr = zzbyVar.zzkh;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.zzkh[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        return Long.valueOf(getLong(i4));
    }

    public final long getLong(int i4) {
        zzf(i4);
        return this.zzkh[i4];
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + zzbd.zzl(this.zzkh[i5]);
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i4 = 0; i4 < this.size; i4++) {
            if (obj.equals(Long.valueOf(this.zzkh[i4]))) {
                long[] jArr = this.zzkh;
                System.arraycopy(jArr, i4 + 1, jArr, i4, (this.size - i4) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i4, int i5) {
        zzac();
        if (i5 >= i4) {
            long[] jArr = this.zzkh;
            System.arraycopy(jArr, i5, jArr, i4, this.size - i5);
            this.size -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzac();
        zzf(i4);
        long[] jArr = this.zzkh;
        long j4 = jArr[i4];
        jArr[i4] = longValue;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh zzh(int i4) {
        if (i4 >= this.size) {
            return new zzby(Arrays.copyOf(this.zzkh, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzm(long j4) {
        zzl(this.size, j4);
    }

    private zzby(long[] jArr, int i4) {
        this.zzkh = jArr;
        this.size = i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        int i5;
        zzac();
        zzf(i4);
        long[] jArr = this.zzkh;
        long j4 = jArr[i4];
        if (i4 < this.size - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }
}
