package com.google.android.gms.internal.wearable;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbw extends zzah implements RandomAccess, zzdj {
    private static final zzbw zza;
    private int[] zzb;
    private int zzc;

    static {
        zzbw zzbwVar = new zzbw(new int[0], 0);
        zza = zzbwVar;
        zzbwVar.zzb();
    }

    zzbw() {
        this(new int[10], 0);
    }

    private final String zzg(int i4) {
        int i5 = this.zzc;
        return "Index:" + i4 + ", Size:" + i5;
    }

    private final void zzh(int i4) {
        if (i4 >= 0 && i4 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        int intValue = ((Integer) obj).intValue();
        zzad();
        if (i4 >= 0 && i4 <= (i5 = this.zzc)) {
            int[] iArr = this.zzb;
            if (i5 < iArr.length) {
                System.arraycopy(iArr, i4, iArr, i4 + 1, i5 - i4);
            } else {
                int[] iArr2 = new int[((i5 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i4);
                System.arraycopy(this.zzb, i4, iArr2, i4 + 1, this.zzc - i4);
                this.zzb = iArr2;
            }
            this.zzb[i4] = intValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzad();
        zzcd.zze(collection);
        if (!(collection instanceof zzbw)) {
            return super.addAll(collection);
        }
        zzbw zzbwVar = (zzbw) collection;
        int i4 = zzbwVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            int[] iArr = this.zzb;
            if (i6 > iArr.length) {
                this.zzb = Arrays.copyOf(iArr, i6);
            }
            System.arraycopy(zzbwVar.zzb, 0, this.zzb, this.zzc, zzbwVar.zzc);
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
        if (!(obj instanceof zzbw)) {
            return super.equals(obj);
        }
        zzbw zzbwVar = (zzbw) obj;
        if (this.zzc != zzbwVar.zzc) {
            return false;
        }
        int[] iArr = zzbwVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (this.zzb[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzh(i4);
        return Integer.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + this.zzb[i5];
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == intValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        int i5;
        zzad();
        zzh(i4);
        int[] iArr = this.zzb;
        int i6 = iArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (i5 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i4, int i5) {
        zzad();
        if (i5 >= i4) {
            int[] iArr = this.zzb;
            System.arraycopy(iArr, i5, iArr, i4, this.zzc - i5);
            this.zzc -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzad();
        zzh(i4);
        int[] iArr = this.zzb;
        int i5 = iArr[i4];
        iArr[i4] = intValue;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzcc
    public final /* bridge */ /* synthetic */ zzcc zzd(int i4) {
        if (i4 >= this.zzc) {
            return new zzbw(Arrays.copyOf(this.zzb, i4), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final int zze(int i4) {
        zzh(i4);
        return this.zzb[i4];
    }

    public final void zzf(int i4) {
        zzad();
        int i5 = this.zzc;
        int[] iArr = this.zzb;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i6 = this.zzc;
        this.zzc = i6 + 1;
        iArr3[i6] = i4;
    }

    private zzbw(int[] iArr, int i4) {
        this.zzb = iArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.wearable.zzah, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Integer) obj).intValue());
        return true;
    }
}
