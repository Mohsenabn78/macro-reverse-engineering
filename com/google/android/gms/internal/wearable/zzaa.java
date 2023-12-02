package com.google.android.gms.internal.wearable;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzaa extends AbstractList implements RandomAccess, Serializable {
    final float[] zza;
    final int zzb;
    final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(float[] fArr, int i4, int i5) {
        this.zza = fArr;
        this.zzb = i4;
        this.zzc = i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        if ((obj instanceof Float) && zzab.zza(this.zza, ((Float) obj).floatValue(), this.zzb, this.zzc) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaa) {
            zzaa zzaaVar = (zzaa) obj;
            int i4 = this.zzc - this.zzb;
            if (zzaaVar.zzc - zzaaVar.zzb != i4) {
                return false;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                if (this.zza[this.zzb + i5] != zzaaVar.zza[zzaaVar.zzb + i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        zzy.zza(i4, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        return Float.valueOf(this.zza[this.zzb + i4]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = this.zzb; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + Float.valueOf(this.zza[i5]).hashCode();
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int zza;
        if ((obj instanceof Float) && (zza = zzab.zza(this.zza, ((Float) obj).floatValue(), this.zzb, this.zzc)) >= 0) {
            return zza - this.zzb;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj instanceof Float) {
            float[] fArr = this.zza;
            float floatValue = ((Float) obj).floatValue();
            int i4 = this.zzb;
            int i5 = this.zzc - 1;
            while (true) {
                if (i5 >= i4) {
                    if (fArr[i5] == floatValue) {
                        break;
                    }
                    i5--;
                } else {
                    i5 = -1;
                    break;
                }
            }
            if (i5 >= 0) {
                return i5 - this.zzb;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i4, Object obj) {
        Float f4 = (Float) obj;
        zzy.zza(i4, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        float[] fArr = this.zza;
        int i5 = this.zzb + i4;
        float f5 = fArr[i5];
        f4.getClass();
        fArr[i5] = f4.floatValue();
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i4, int i5) {
        zzy.zzb(i4, i5, this.zzc - this.zzb);
        if (i4 == i5) {
            return Collections.emptyList();
        }
        float[] fArr = this.zza;
        int i6 = this.zzb;
        return new zzaa(fArr, i4 + i6, i6 + i5);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 12);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        sb.append(this.zza[this.zzb]);
        int i4 = this.zzb;
        while (true) {
            i4++;
            if (i4 < this.zzc) {
                sb.append(", ");
                sb.append(this.zza[i4]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
