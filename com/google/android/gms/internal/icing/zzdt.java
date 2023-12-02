package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzdt extends zzbt<Long> implements RandomAccess, zzdf, zzel {
    private static final zzdt zza;
    private long[] zzb;
    private int zzc;

    static {
        zzdt zzdtVar = new zzdt(new long[0], 0);
        zza = zzdtVar;
        zzdtVar.zzb();
    }

    zzdt() {
        this(new long[10], 0);
    }

    public static zzdt zzd() {
        return zza;
    }

    private final void zzg(int i4) {
        if (i4 >= 0 && i4 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzh(i4));
    }

    private final String zzh(int i4) {
        int i5 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i4);
        sb.append(", Size:");
        sb.append(i5);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i4, Object obj) {
        int i5;
        long longValue = ((Long) obj).longValue();
        zzc();
        if (i4 >= 0 && i4 <= (i5 = this.zzc)) {
            long[] jArr = this.zzb;
            if (i5 < jArr.length) {
                System.arraycopy(jArr, i4, jArr, i4 + 1, i5 - i4);
            } else {
                long[] jArr2 = new long[((i5 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                System.arraycopy(this.zzb, i4, jArr2, i4 + 1, this.zzc - i4);
                this.zzb = jArr2;
            }
            this.zzb[i4] = longValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzh(i4));
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzc();
        zzdh.zza(collection);
        if (!(collection instanceof zzdt)) {
            return super.addAll(collection);
        }
        zzdt zzdtVar = (zzdt) collection;
        int i4 = zzdtVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            long[] jArr = this.zzb;
            if (i6 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i6);
            }
            System.arraycopy(zzdtVar.zzb, 0, this.zzb, this.zzc, zzdtVar.zzc);
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

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdt)) {
            return super.equals(obj);
        }
        zzdt zzdtVar = (zzdt) obj;
        if (this.zzc != zzdtVar.zzc) {
            return false;
        }
        long[] jArr = zzdtVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (this.zzb[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        zzg(i4);
        return Long.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + zzdh.zze(this.zzb[i5]);
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == longValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        int i5;
        zzc();
        zzg(i4);
        long[] jArr = this.zzb;
        long j4 = jArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (i5 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i4, int i5) {
        zzc();
        if (i5 >= i4) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i5, jArr, i4, this.zzc - i5);
            this.zzc -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzc();
        zzg(i4);
        long[] jArr = this.zzb;
        long j4 = jArr[i4];
        jArr[i4] = longValue;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.icing.zzdg
    public final /* bridge */ /* synthetic */ zzdg<Long> zze(int i4) {
        if (i4 >= this.zzc) {
            return new zzdt(Arrays.copyOf(this.zzb, i4), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final long zzf(int i4) {
        zzg(i4);
        return this.zzb[i4];
    }

    private zzdt(long[] jArr, int i4) {
        this.zzb = jArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        long longValue = ((Long) obj).longValue();
        zzc();
        int i4 = this.zzc;
        long[] jArr = this.zzb;
        if (i4 == jArr.length) {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        jArr3[i5] = longValue;
        return true;
    }
}
