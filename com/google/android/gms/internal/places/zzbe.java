package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbe extends zzq<Integer> implements zzbi, zzcw, RandomAccess {
    private static final zzbe zzjc;
    private int size;
    private int[] zzjd;

    static {
        zzbe zzbeVar = new zzbe(new int[0], 0);
        zzjc = zzbeVar;
        zzbeVar.zzab();
    }

    zzbe() {
        this(new int[10], 0);
    }

    public static zzbe zzbo() {
        return zzjc;
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

    private final void zzp(int i4, int i5) {
        int i6;
        zzac();
        if (i4 >= 0 && i4 <= (i6 = this.size)) {
            int[] iArr = this.zzjd;
            if (i6 < iArr.length) {
                System.arraycopy(iArr, i4, iArr, i4 + 1, i6 - i4);
            } else {
                int[] iArr2 = new int[((i6 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i4);
                System.arraycopy(this.zzjd, i4, iArr2, i4 + 1, this.size - i4);
                this.zzjd = iArr2;
            }
            this.zzjd[i4] = i5;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        zzp(i4, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzbe)) {
            return super.addAll(collection);
        }
        zzbe zzbeVar = (zzbe) collection;
        int i4 = zzbeVar.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            int[] iArr = this.zzjd;
            if (i6 > iArr.length) {
                this.zzjd = Arrays.copyOf(iArr, i6);
            }
            System.arraycopy(zzbeVar.zzjd, 0, this.zzjd, this.size, zzbeVar.size);
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
        if (!(obj instanceof zzbe)) {
            return super.equals(obj);
        }
        zzbe zzbeVar = (zzbe) obj;
        if (this.size != zzbeVar.size) {
            return false;
        }
        int[] iArr = zzbeVar.zzjd;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.zzjd[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        return Integer.valueOf(getInt(i4));
    }

    public final int getInt(int i4) {
        zzf(i4);
        return this.zzjd[i4];
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + this.zzjd[i5];
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i4 = 0; i4 < this.size; i4++) {
            if (obj.equals(Integer.valueOf(this.zzjd[i4]))) {
                int[] iArr = this.zzjd;
                System.arraycopy(iArr, i4 + 1, iArr, i4, (this.size - i4) - 1);
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
            int[] iArr = this.zzjd;
            System.arraycopy(iArr, i5, iArr, i4, this.size - i5);
            this.size -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzac();
        zzf(i4);
        int[] iArr = this.zzjd;
        int i5 = iArr[i4];
        iArr[i4] = intValue;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzac(int i4) {
        zzp(this.size, i4);
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh<Integer> zzh(int i4) {
        if (i4 >= this.size) {
            return new zzbe(Arrays.copyOf(this.zzjd, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzbe(int[] iArr, int i4) {
        this.zzjd = iArr;
        this.size = i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        int i5;
        zzac();
        zzf(i4);
        int[] iArr = this.zzjd;
        int i6 = iArr[i4];
        if (i4 < this.size - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }
}
