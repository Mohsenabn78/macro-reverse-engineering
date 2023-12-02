package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzu extends zzq<Boolean> implements zzcw, RandomAccess {
    private static final zzu zzed;
    private int size;
    private boolean[] zzee;

    static {
        zzu zzuVar = new zzu(new boolean[0], 0);
        zzed = zzuVar;
        zzuVar.zzab();
    }

    zzu() {
        this(new boolean[10], 0);
    }

    private final void zzb(int i4, boolean z3) {
        int i5;
        zzac();
        if (i4 >= 0 && i4 <= (i5 = this.size)) {
            boolean[] zArr = this.zzee;
            if (i5 < zArr.length) {
                System.arraycopy(zArr, i4, zArr, i4 + 1, i5 - i4);
            } else {
                boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i4);
                System.arraycopy(this.zzee, i4, zArr2, i4 + 1, this.size - i4);
                this.zzee = zArr2;
            }
            this.zzee[i4] = z3;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
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
        zzb(i4, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzu)) {
            return super.addAll(collection);
        }
        zzu zzuVar = (zzu) collection;
        int i4 = zzuVar.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            boolean[] zArr = this.zzee;
            if (i6 > zArr.length) {
                this.zzee = Arrays.copyOf(zArr, i6);
            }
            System.arraycopy(zzuVar.zzee, 0, this.zzee, this.size, zzuVar.size);
            this.size = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z3) {
        zzb(this.size, z3);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzu)) {
            return super.equals(obj);
        }
        zzu zzuVar = (zzu) obj;
        if (this.size != zzuVar.size) {
            return false;
        }
        boolean[] zArr = zzuVar.zzee;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.zzee[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzf(i4);
        return Boolean.valueOf(this.zzee[i4]);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + zzbd.zze(this.zzee[i5]);
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i4 = 0; i4 < this.size; i4++) {
            if (obj.equals(Boolean.valueOf(this.zzee[i4]))) {
                boolean[] zArr = this.zzee;
                System.arraycopy(zArr, i4 + 1, zArr, i4, (this.size - i4) - 1);
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
            boolean[] zArr = this.zzee;
            System.arraycopy(zArr, i5, zArr, i4, this.size - i5);
            this.size -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzac();
        zzf(i4);
        boolean[] zArr = this.zzee;
        boolean z3 = zArr[i4];
        zArr[i4] = booleanValue;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh zzh(int i4) {
        if (i4 >= this.size) {
            return new zzu(Arrays.copyOf(this.zzee, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzu(boolean[] zArr, int i4) {
        this.zzee = zArr;
        this.size = i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        int i5;
        zzac();
        zzf(i4);
        boolean[] zArr = this.zzee;
        boolean z3 = zArr[i4];
        if (i4 < this.size - 1) {
            System.arraycopy(zArr, i4 + 1, zArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z3);
    }
}
