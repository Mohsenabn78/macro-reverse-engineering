package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zzku extends zzjl implements RandomAccess, zzmp {
    private static final zzku zza = new zzku(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    zzku() {
        this(new float[10], 0, true);
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

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        float floatValue = ((Float) obj).floatValue();
        zzbW();
        if (i4 >= 0 && i4 <= (i5 = this.zzc)) {
            float[] fArr = this.zzb;
            if (i5 < fArr.length) {
                System.arraycopy(fArr, i4, fArr, i4 + 1, i5 - i4);
            } else {
                float[] fArr2 = new float[((i5 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i4);
                System.arraycopy(this.zzb, i4, fArr2, i4 + 1, this.zzc - i4);
                this.zzb = fArr2;
            }
            this.zzb[i4] = floatValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzf(i4));
    }

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbW();
        byte[] bArr = zzlj.zzd;
        collection.getClass();
        if (!(collection instanceof zzku)) {
            return super.addAll(collection);
        }
        zzku zzkuVar = (zzku) collection;
        int i4 = zzkuVar.zzc;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.zzc;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            float[] fArr = this.zzb;
            if (i6 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i6);
            }
            System.arraycopy(zzkuVar.zzb, 0, this.zzb, this.zzc, zzkuVar.zzc);
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

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzku)) {
            return super.equals(obj);
        }
        zzku zzkuVar = (zzku) obj;
        if (this.zzc != zzkuVar.zzc) {
            return false;
        }
        float[] fArr = zzkuVar.zzb;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            if (Float.floatToIntBits(this.zzb[i4]) != Float.floatToIntBits(fArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzg(i4);
        return Float.valueOf(this.zzb[i4]);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + Float.floatToIntBits(this.zzb[i5]);
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i4 = this.zzc;
        for (int i5 = 0; i5 < i4; i5++) {
            if (this.zzb[i5] == floatValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i4) {
        int i5;
        zzbW();
        zzg(i4);
        float[] fArr = this.zzb;
        float f4 = fArr[i4];
        if (i4 < this.zzc - 1) {
            System.arraycopy(fArr, i4 + 1, fArr, i4, (i5 - i4) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i4, int i5) {
        zzbW();
        if (i5 >= i4) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i5, fArr, i4, this.zzc - i5);
            this.zzc -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbW();
        zzg(i4);
        float[] fArr = this.zzb;
        float f4 = fArr[i4];
        fArr[i4] = floatValue;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final /* bridge */ /* synthetic */ zzli zzd(int i4) {
        if (i4 >= this.zzc) {
            return new zzku(Arrays.copyOf(this.zzb, i4), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f4) {
        zzbW();
        int i4 = this.zzc;
        float[] fArr = this.zzb;
        if (i4 == fArr.length) {
            float[] fArr2 = new float[((i4 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i4);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        fArr3[i5] = f4;
    }

    private zzku(float[] fArr, int i4, boolean z3) {
        super(z3);
        this.zzb = fArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzjl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}