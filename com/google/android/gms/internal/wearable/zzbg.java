package com.google.android.gms.internal.wearable;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbg extends zzah implements RandomAccess, zzdj {
    private static final zzbg zza;
    private double[] zzb;
    private int zzc;

    static {
        zzbg zzbgVar = new zzbg(new double[0], 0);
        zza = zzbgVar;
        zzbgVar.zzb();
    }

    zzbg() {
        this(new double[10], 0);
    }

    private final String zzf(int i4) {
        int i5 = this.zzc;
        return "Index:" + i4 + ", Size:" + i5;
    }

    private final void zzg(int i4) {
        if (i4 >= 0 && i4 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i4));
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        double doubleValue = ((Double) obj).doubleValue();
        zzad();
        if (i4 >= 0 && i4 <= (i5 = this.zzc)) {
            double[] dArr = this.zzb;
            if (i5 < dArr.length) {
                System.arraycopy(dArr, i4, dArr, i4 + 1, i5 - i4);
            } else {
                double[] dArr2 = new double[((i5 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i4);
                System.arraycopy(this.zzb, i4, dArr2, i4 + 1, this.zzc - i4);
                this.zzb = dArr2;
            }
            this.zzb[i4] = doubleValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i4));
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzad();
        zzcd.zze(collection);
        if (!(collection instanceof zzbg)) {
            return super.addAll(collection);
        }
        zzbg zzbgVar = (zzbg) collection;
        int i4 = zzbgVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            double[] dArr = this.zzb;
            if (i6 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i6);
            }
            System.arraycopy(zzbgVar.zzb, 0, this.zzb, this.zzc, zzbgVar.zzc);
            this.zzc = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbg)) {
            return super.equals(obj);
        }
        zzbg zzbgVar = (zzbg) obj;
        if (this.zzc != zzbgVar.zzc) {
            return false;
        }
        double[] dArr = zzbgVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (Double.doubleToLongBits(this.zzb[i4]) != Double.doubleToLongBits(dArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzg(i4);
        return Double.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + zzcd.zzc(Double.doubleToLongBits(this.zzb[i5]));
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == doubleValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        int i5;
        zzad();
        zzg(i4);
        double[] dArr = this.zzb;
        double d4 = dArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(dArr, i4 + 1, dArr, i4, (i5 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i4, int i5) {
        zzad();
        if (i5 >= i4) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i5, dArr, i4, this.zzc - i5);
            this.zzc -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzad();
        zzg(i4);
        double[] dArr = this.zzb;
        double d4 = dArr[i4];
        dArr[i4] = doubleValue;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzcc
    public final /* bridge */ /* synthetic */ zzcc zzd(int i4) {
        if (i4 >= this.zzc) {
            return new zzbg(Arrays.copyOf(this.zzb, i4), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d4) {
        zzad();
        int i4 = this.zzc;
        double[] dArr = this.zzb;
        if (i4 == dArr.length) {
            double[] dArr2 = new double[((i4 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i4);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        dArr3[i5] = d4;
    }

    private zzbg(double[] dArr, int i4) {
        this.zzb = dArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
