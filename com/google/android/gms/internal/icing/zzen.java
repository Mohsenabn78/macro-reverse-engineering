package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzen<E> extends zzbt<E> implements RandomAccess {
    private static final zzen<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzen<Object> zzenVar = new zzen<>(new Object[0], 0);
        zza = zzenVar;
        zzenVar.zzb();
    }

    zzen() {
        this(new Object[10], 0);
    }

    public static <E> zzen<E> zzd() {
        return (zzen<E>) zza;
    }

    private final void zzf(int i4) {
        if (i4 >= 0 && i4 < this.zzc) {
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    private final String zzg(int i4) {
        int i5 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i4);
        sb.append(", Size:");
        sb.append(i5);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.List
    public final void add(int i4, E e4) {
        int i5;
        zzc();
        if (i4 >= 0 && i4 <= (i5 = this.zzc)) {
            E[] eArr = this.zzb;
            if (i5 < eArr.length) {
                System.arraycopy(eArr, i4, eArr, i4 + 1, i5 - i4);
            } else {
                E[] eArr2 = (E[]) new Object[((i5 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i4);
                System.arraycopy(this.zzb, i4, eArr2, i4 + 1, this.zzc - i4);
                this.zzb = eArr2;
            }
            this.zzb[i4] = e4;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i4));
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i4) {
        zzf(i4);
        return this.zzb[i4];
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.List
    public final E remove(int i4) {
        int i5;
        zzc();
        zzf(i4);
        E[] eArr = this.zzb;
        E e4 = eArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(eArr, i4 + 1, eArr, i4, (i5 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.List
    public final E set(int i4, E e4) {
        zzc();
        zzf(i4);
        E[] eArr = this.zzb;
        E e5 = eArr[i4];
        eArr[i4] = e4;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.icing.zzdg
    public final /* bridge */ /* synthetic */ zzdg zze(int i4) {
        if (i4 >= this.zzc) {
            return new zzen(Arrays.copyOf(this.zzb, i4), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzen(E[] eArr, int i4) {
        this.zzb = eArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.icing.zzbt, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e4) {
        zzc();
        int i4 = this.zzc;
        E[] eArr = this.zzb;
        if (i4 == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i4 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        eArr2[i5] = e4;
        ((AbstractList) this).modCount++;
        return true;
    }
}
