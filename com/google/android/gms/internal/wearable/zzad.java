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
public final class zzad extends AbstractList implements RandomAccess, Serializable {
    final long[] zza;
    final int zzb;
    final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(long[] jArr, int i4, int i5) {
        this.zza = jArr;
        this.zzb = i4;
        this.zzc = i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        if ((obj instanceof Long) && zzae.zza(this.zza, ((Long) obj).longValue(), this.zzb, this.zzc) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzad) {
            zzad zzadVar = (zzad) obj;
            int i4 = this.zzc - this.zzb;
            if (zzadVar.zzc - zzadVar.zzb != i4) {
                return false;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                if (this.zza[this.zzb + i5] != zzadVar.zza[zzadVar.zzb + i5]) {
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
        return Long.valueOf(this.zza[this.zzb + i4]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i4 = 1;
        for (int i5 = this.zzb; i5 < this.zzc; i5++) {
            long j4 = this.zza[i5];
            i4 = (i4 * 31) + ((int) (j4 ^ (j4 >>> 32)));
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int zza;
        if ((obj instanceof Long) && (zza = zzae.zza(this.zza, ((Long) obj).longValue(), this.zzb, this.zzc)) >= 0) {
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
        if (obj instanceof Long) {
            long[] jArr = this.zza;
            long longValue = ((Long) obj).longValue();
            int i4 = this.zzb;
            int i5 = this.zzc - 1;
            while (true) {
                if (i5 >= i4) {
                    if (jArr[i5] == longValue) {
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
        Long l4 = (Long) obj;
        zzy.zza(i4, this.zzc - this.zzb, FirebaseAnalytics.Param.INDEX);
        long[] jArr = this.zza;
        int i5 = this.zzb + i4;
        long j4 = jArr[i5];
        l4.getClass();
        jArr[i5] = l4.longValue();
        return Long.valueOf(j4);
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
        long[] jArr = this.zza;
        int i6 = this.zzb;
        return new zzad(jArr, i4 + i6, i6 + i5);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 10);
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
