package com.google.android.gms.internal.mlkit_translate;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public abstract class zzaa extends zzr implements Set {
    @CheckForNull
    private transient zzv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i4) {
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

    public static zzaa zzj() {
        return zzaj.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzaa zzl(int i4, Object... objArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                int zzf = zzf(i4);
                Object[] objArr2 = new Object[zzf];
                int i5 = zzf - 1;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    Object obj = objArr[i8];
                    zzac.zza(obj, i8);
                    int hashCode = obj.hashCode();
                    int zza = zzo.zza(hashCode);
                    while (true) {
                        int i9 = zza & i5;
                        Object obj2 = objArr2[i9];
                        if (obj2 == null) {
                            objArr[i7] = obj;
                            objArr2[i9] = obj;
                            i6 += hashCode;
                            i7++;
                            break;
                        } else if (obj2.equals(obj)) {
                            break;
                        } else {
                            zza++;
                        }
                    }
                }
                Arrays.fill(objArr, i7, i4, (Object) null);
                if (i7 == 1) {
                    Object obj3 = objArr[0];
                    obj3.getClass();
                    return new zzal(obj3);
                } else if (zzf(i7) < zzf / 2) {
                    return zzl(i7, objArr);
                } else {
                    int length = objArr.length;
                    if (i7 < (length >> 1) + (length >> 2)) {
                        objArr = Arrays.copyOf(objArr, i7);
                    }
                    return new zzaj(objArr, i6, objArr2, i5, i7);
                }
            }
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzal(obj4);
        }
        return zzaj.zza;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzaa) && zzk() && ((zzaa) obj).zzk() && hashCode() != obj.hashCode()) {
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
        return zzak.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: zzd */
    public abstract zzam iterator();

    public final zzv zzg() {
        zzv zzvVar = this.zza;
        if (zzvVar == null) {
            zzv zzh = zzh();
            this.zza = zzh;
            return zzh;
        }
        return zzvVar;
    }

    zzv zzh() {
        return zzv.zzh(toArray());
    }

    boolean zzk() {
        return false;
    }
}
