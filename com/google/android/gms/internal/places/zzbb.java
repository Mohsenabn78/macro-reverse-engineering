package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
final class zzbb extends zzq<Float> implements zzcw, RandomAccess {
    private static final zzbb zzic;
    private int size;
    private float[] zzid;

    static {
        zzbb zzbbVar = new zzbb(new float[0], 0);
        zzic = zzbbVar;
        zzbbVar.zzab();
    }

    zzbb() {
        this(new float[10], 0);
    }

    private final void zzd(int i4, float f4) {
        int i5;
        zzac();
        if (i4 >= 0 && i4 <= (i5 = this.size)) {
            float[] fArr = this.zzid;
            if (i5 < fArr.length) {
                System.arraycopy(fArr, i4, fArr, i4 + 1, i5 - i4);
            } else {
                float[] fArr2 = new float[((i5 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i4);
                System.arraycopy(this.zzid, i4, fArr2, i4 + 1, this.size - i4);
                this.zzid = fArr2;
            }
            this.zzid[i4] = f4;
            this.size++;
            ((AbstractList) this).modCount++;
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
        zzd(i4, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzbb)) {
            return super.addAll(collection);
        }
        zzbb zzbbVar = (zzbb) collection;
        int i4 = zzbbVar.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            float[] fArr = this.zzid;
            if (i6 > fArr.length) {
                this.zzid = Arrays.copyOf(fArr, i6);
            }
            System.arraycopy(zzbbVar.zzid, 0, this.zzid, this.size, zzbbVar.size);
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
        if (!(obj instanceof zzbb)) {
            return super.equals(obj);
        }
        zzbb zzbbVar = (zzbb) obj;
        if (this.size != zzbbVar.size) {
            return false;
        }
        float[] fArr = zzbbVar.zzid;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (Float.floatToIntBits(this.zzid[i4]) != Float.floatToIntBits(fArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i4) {
        zzf(i4);
        return Float.valueOf(this.zzid[i4]);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + Float.floatToIntBits(this.zzid[i5]);
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i4 = 0; i4 < this.size; i4++) {
            if (obj.equals(Float.valueOf(this.zzid[i4]))) {
                float[] fArr = this.zzid;
                System.arraycopy(fArr, i4 + 1, fArr, i4, (this.size - i4) - 1);
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
            float[] fArr = this.zzid;
            System.arraycopy(fArr, i5, fArr, i4, this.size - i5);
            this.size -= i5 - i4;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i4, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzac();
        zzf(i4);
        float[] fArr = this.zzid;
        float f4 = fArr[i4];
        fArr[i4] = floatValue;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzf(float f4) {
        zzd(this.size, f4);
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh zzh(int i4) {
        if (i4 >= this.size) {
            return new zzbb(Arrays.copyOf(this.zzid, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzbb(float[] fArr, int i4) {
        this.zzid = fArr;
        this.size = i4;
    }

    private final void zzf(int i4) {
        if (i4 < 0 || i4 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i4));
        }
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i4) {
        int i5;
        zzac();
        zzf(i4);
        float[] fArr = this.zzid;
        float f4 = fArr[i4];
        if (i4 < this.size - 1) {
            System.arraycopy(fArr, i4 + 1, fArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }
}
