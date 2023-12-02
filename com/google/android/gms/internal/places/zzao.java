package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzao extends zzq<Double> implements zzcw, RandomAccess {
    private static final zzao zzex;
    private int size;
    private double[] zzey;

    static {
        zzao zzaoVar = new zzao(new double[0], 0);
        zzex = zzaoVar;
        zzaoVar.zzab();
    }

    zzao() {
        this(new double[10], 0);
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

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        zzd(i4, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzao)) {
            return super.addAll(collection);
        }
        zzao zzaoVar = (zzao) collection;
        int i4 = zzaoVar.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            double[] dArr = this.zzey;
            if (i6 > dArr.length) {
                this.zzey = Arrays.copyOf(dArr, i6);
            }
            System.arraycopy(zzaoVar.zzey, 0, this.zzey, this.size, zzaoVar.size);
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
        if (!(obj instanceof zzao)) {
            return super.equals(obj);
        }
        zzao zzaoVar = (zzao) obj;
        if (this.size != zzaoVar.size) {
            return false;
        }
        double[] dArr = zzaoVar.zzey;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (Double.doubleToLongBits(this.zzey[i4]) != Double.doubleToLongBits(dArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzf(i4);
        return Double.valueOf(this.zzey[i4]);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + zzbd.zzl(Double.doubleToLongBits(this.zzey[i5]));
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i4 = 0; i4 < this.size; i4++) {
            if (obj.equals(Double.valueOf(this.zzey[i4]))) {
                double[] dArr = this.zzey;
                System.arraycopy(dArr, i4 + 1, dArr, i4, (this.size - i4) - 1);
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
            double[] dArr = this.zzey;
            System.arraycopy(dArr, i5, dArr, i4, this.size - i5);
            this.size -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzac();
        zzf(i4);
        double[] dArr = this.zzey;
        double d4 = dArr[i4];
        dArr[i4] = doubleValue;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzd(double d4) {
        zzd(this.size, d4);
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh zzh(int i4) {
        if (i4 >= this.size) {
            return new zzao(Arrays.copyOf(this.zzey, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzao(double[] dArr, int i4) {
        this.zzey = dArr;
        this.size = i4;
    }

    private final void zzd(int i4, double d4) {
        int i5;
        zzac();
        if (i4 >= 0 && i4 <= (i5 = this.size)) {
            double[] dArr = this.zzey;
            if (i5 < dArr.length) {
                System.arraycopy(dArr, i4, dArr, i4 + 1, i5 - i4);
            } else {
                double[] dArr2 = new double[((i5 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i4);
                System.arraycopy(this.zzey, i4, dArr2, i4 + 1, this.size - i4);
                this.zzey = dArr2;
            }
            this.zzey[i4] = d4;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        int i5;
        zzac();
        zzf(i4);
        double[] dArr = this.zzey;
        double d4 = dArr[i4];
        if (i4 < this.size - 1) {
            System.arraycopy(dArr, i4 + 1, dArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d4);
    }
}
