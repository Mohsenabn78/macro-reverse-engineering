package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfsh extends zzfrx implements Set {
    @CheckForNull
    private transient zzfsc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i4) {
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
        zzfph.zzf(z3, "collection too large");
        return 1073741824;
    }

    public static zzfsg zzj(int i4) {
        return new zzfsg(i4);
    }

    public static zzfsh zzl(Collection collection) {
        Object[] array = collection.toArray();
        return zzs(array.length, array);
    }

    public static zzfsh zzm() {
        return zzfts.zza;
    }

    public static zzfsh zzn(Object obj) {
        return new zzftz(obj);
    }

    public static zzfsh zzo(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzs(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfsh zzp(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 6);
        return zzs(12, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfsh zzs(int i4, Object... objArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                int zzh = zzh(i4);
                Object[] objArr2 = new Object[zzh];
                int i5 = zzh - 1;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    Object obj = objArr[i8];
                    zzftk.zza(obj, i8);
                    int hashCode = obj.hashCode();
                    int zza = zzfru.zza(hashCode);
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
                    return new zzftz(obj3);
                }
                if (zzh(i7) < zzh / 2) {
                    return zzs(i7, objArr);
                }
                if (zzt(i7, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i7);
                }
                return new zzfts(objArr, i6, objArr2, i5, i7);
            }
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzftz(obj4);
        }
        return zzfts.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(int i4, int i5) {
        if (i4 < (i5 >> 1) + (i5 >> 2)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfsh) && zzr() && ((zzfsh) obj).zzr() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzfty.zzc(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzfty.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfrx
    public zzfsc zzd() {
        zzfsc zzfscVar = this.zza;
        if (zzfscVar == null) {
            zzfsc zzi = zzi();
            this.zza = zzi;
            return zzi;
        }
        return zzfscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfrx, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zze */
    public abstract zzfuc iterator();

    zzfsc zzi() {
        Object[] array = toArray();
        int i4 = zzfsc.zzd;
        return zzfsc.zzi(array, array.length);
    }

    boolean zzr() {
        return false;
    }
}
