package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzjb extends zziw implements Set {
    @CheckForNull
    private transient zzja zza;

    static int zzf(int i4) {
        int max = Math.max(i4, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    @SafeVarargs
    public static zzjb zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[15];
        objArr2[0] = "_in";
        objArr2[1] = "_xa";
        objArr2[2] = "_xu";
        objArr2[3] = "_aq";
        objArr2[4] = "_aa";
        objArr2[5] = "_ai";
        System.arraycopy(objArr, 0, objArr2, 6, 9);
        return zzk(15, objArr2);
    }

    private static zzjb zzk(int i4, Object... objArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                int zzf = zzf(i4);
                Object[] objArr2 = new Object[zzf];
                int i5 = zzf - 1;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    Object obj = objArr[i8];
                    zzjd.zza(obj, i8);
                    int hashCode = obj.hashCode();
                    int zza = zzit.zza(hashCode);
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
                    return new zzjg(obj3);
                }
                if (zzf(i7) < zzf / 2) {
                    return zzk(i7, objArr);
                }
                if (i7 < 10) {
                    objArr = Arrays.copyOf(objArr, i7);
                }
                return new zzjf(objArr, i6, objArr2, i5, i7);
            }
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzjg(obj4);
        }
        return zzjf.zza;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzjb) && zzj() && ((zzjb) obj).zzj() && hashCode() != obj.hashCode()) {
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

    @Override // com.google.android.gms.internal.measurement.zziw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzjh iterator();

    public final zzja zzg() {
        zzja zzjaVar = this.zza;
        if (zzjaVar == null) {
            zzja zzh = zzh();
            this.zza = zzh;
            return zzh;
        }
        return zzjaVar;
    }

    zzja zzh() {
        Object[] array = toArray();
        int i4 = zzja.zzd;
        return zzja.zzg(array, array.length);
    }

    boolean zzj() {
        return false;
    }
}
