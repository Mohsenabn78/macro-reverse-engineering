package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafn  reason: invalid package */
/* loaded from: classes4.dex */
final class zzafn extends zzafj implements RandomAccess, zzaip {
    private static final zzafn zza = new zzafn(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    zzafn() {
        this(new boolean[10], 0, true);
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i4 >= 0 && i4 <= (i5 = this.zzc)) {
            boolean[] zArr = this.zzb;
            if (i5 < zArr.length) {
                System.arraycopy(zArr, i4, zArr, i4 + 1, i5 - i4);
            } else {
                boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i4);
                System.arraycopy(this.zzb, i4, zArr2, i4 + 1, this.zzc - i4);
                this.zzb = zArr2;
            }
            this.zzb[i4] = booleanValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i4));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzahj.zzd;
        collection.getClass();
        if (!(collection instanceof zzafn)) {
            return super.addAll(collection);
        }
        zzafn zzafnVar = (zzafn) collection;
        int i4 = zzafnVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            boolean[] zArr = this.zzb;
            if (i6 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i6);
            }
            System.arraycopy(zzafnVar.zzb, 0, this.zzb, this.zzc, zzafnVar.zzc);
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzafn)) {
            return super.equals(obj);
        }
        zzafn zzafnVar = (zzafn) obj;
        if (this.zzc != zzafnVar.zzc) {
            return false;
        }
        boolean[] zArr = zzafnVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (this.zzb[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzg(i4);
        return Boolean.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + zzahj.zza(this.zzb[i5]);
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == booleanValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        int i5;
        zza();
        zzg(i4);
        boolean[] zArr = this.zzb;
        boolean z3 = zArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(zArr, i4 + 1, zArr, i4, (i5 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i4, int i5) {
        zza();
        if (i5 >= i4) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i5, zArr, i4, this.zzc - i5);
            this.zzc -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzg(i4);
        boolean[] zArr = this.zzb;
        boolean z3 = zArr[i4];
        zArr[i4] = booleanValue;
        return Boolean.valueOf(z3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final /* bridge */ /* synthetic */ zzahi zzd(int i4) {
        if (i4 >= this.zzc) {
            return new zzafn(Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z3) {
        zza();
        int i4 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i4 == zArr.length) {
            boolean[] zArr2 = new boolean[((i4 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        zArr3[i5] = z3;
    }

    private zzafn(boolean[] zArr, int i4, boolean z3) {
        super(z3);
        this.zzb = zArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
