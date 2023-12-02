package com.google.android.gms.internal.nearby;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzsv extends zzsq implements Set {
    @CheckForNull
    private transient zzst zza;

    static int zzh(int i4) {
        boolean z3;
        int max = Math.max(i4, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        }
        if (max < 1073741824) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzsj.zze(z3, "collection too large");
        return 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzsv zzl(int i4, Object... objArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                int zzh = zzh(i4);
                Object[] objArr2 = new Object[zzh];
                int i5 = zzh - 1;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    Object obj = objArr[i8];
                    zzsx.zza(obj, i8);
                    int hashCode = obj.hashCode();
                    int zza = zzsn.zza(hashCode);
                    while (true) {
                        int i9 = zza & i5;
                        Object obj2 = objArr2[i9];
                        if (obj2 == null) {
                            objArr[i7] = obj;
                            objArr2[i9] = obj;
                            i6 += hashCode;
                            i7++;
                            break;
                        } else if (!obj2.equals(obj)) {
                            zza++;
                        }
                    }
                }
                Arrays.fill(objArr, i7, i4, (Object) null);
                if (i7 == 1) {
                    Object obj3 = objArr[0];
                    obj3.getClass();
                    return new zzta(obj3);
                }
                if (zzh(i7) < zzh / 2) {
                    return zzl(i7, objArr);
                }
                int length = objArr.length;
                if (i7 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i7);
                }
                return new zzsz(objArr, i6, objArr2, i5, i7);
            }
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzta(obj4);
        }
        return zzsz.zza;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzsv) && zzk() && ((zzsv) obj).zzk() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int i4;
        int i5 = 0;
        for (Object obj : this) {
            if (obj != null) {
                i4 = obj.hashCode();
            } else {
                i4 = 0;
            }
            i5 += i4;
        }
        return i5;
    }

    @Override // com.google.android.gms.internal.nearby.zzsq
    public zzst zzd() {
        zzst zzstVar = this.zza;
        if (zzstVar == null) {
            zzst zzi = zzi();
            this.zza = zzi;
            return zzi;
        }
        return zzstVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzsq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zze */
    public abstract zztb iterator();

    zzst zzi() {
        Object[] array = toArray();
        int i4 = zzst.zzd;
        return zzst.zzi(array, array.length);
    }

    boolean zzk() {
        return false;
    }
}
