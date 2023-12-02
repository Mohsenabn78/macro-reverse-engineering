package com.google.android.gms.internal.nearby;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzto extends AbstractList implements RandomAccess, Serializable {
    final int[] zza;
    final int zzb;
    final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzto(int[] iArr, int i4, int i5) {
        this.zza = iArr;
        this.zzb = i4;
        this.zzc = i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        if ((obj instanceof Integer) && zztp.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzto) {
            zzto zztoVar = (zzto) obj;
            int i4 = this.zzc - this.zzb;
            if (zztoVar.zzc - zztoVar.zzb != i4) {
                return false;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                if (this.zza[this.zzb + i5] != zztoVar.zza[zztoVar.zzb + i5]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        zzsj.zza(i4, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        return Integer.valueOf(this.zza[this.zzb + i4]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = this.zzb; i5 < this.zzc; i5++) {
            i4 = (i4 * 31) + this.zza[i5];
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int zza;
        if ((obj instanceof Integer) && (zza = zztp.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc)) >= 0) {
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
        if (obj instanceof Integer) {
            int[] iArr = this.zza;
            int intValue = ((Integer) obj).intValue();
            int i4 = this.zzb;
            int i5 = this.zzc - 1;
            while (true) {
                if (i5 >= i4) {
                    if (iArr[i5] == intValue) {
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
        Integer num = (Integer) obj;
        zzsj.zza(i4, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        int[] iArr = this.zza;
        int i5 = this.zzb + i4;
        int i6 = iArr[i5];
        num.getClass();
        iArr[i5] = num.intValue();
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i4, int i5) {
        zzsj.zzh(i4, i5, this.zzc - this.zzb);
        if (i4 == i5) {
            return Collections.emptyList();
        }
        int[] iArr = this.zza;
        int i6 = this.zzb;
        return new zzto(iArr, i4 + i6, i6 + i5);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 5);
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
