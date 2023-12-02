package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfrl extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    @CheckForNull
    transient int[] zza;
    @CheckForNull
    transient Object[] zzb;
    @CheckForNull
    transient Object[] zzc;
    @CheckForNull
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    @CheckForNull
    private transient Set zzh;
    @CheckForNull
    private transient Set zzi;
    @CheckForNull
    private transient Collection zzj;

    zzfrl() {
        zzm(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object zzh(zzfrl zzfrlVar) {
        Object obj = zzfrlVar.zze;
        obj.getClass();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzq(@CheckForNull Object obj) {
        if (zzo()) {
            return -1;
        }
        int zzb = zzfru.zzb(obj);
        int zzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzc = zzfrm.zzc(obj2, zzb & zzp);
        if (zzc == 0) {
            return -1;
        }
        int i4 = ~zzp;
        int i5 = zzb & i4;
        do {
            int i6 = zzc - 1;
            int[] iArr = this.zza;
            iArr.getClass();
            int i7 = iArr[i6];
            if ((i7 & i4) == i5) {
                Object[] objArr = this.zzb;
                objArr.getClass();
                if (zzfpc.zza(obj, objArr[i6])) {
                    return i6;
                }
            }
            zzc = i7 & zzp;
        } while (zzc != 0);
        return -1;
    }

    private final int zzr(int i4, int i5, int i6, int i7) {
        int i8 = i5 - 1;
        Object zzd2 = zzfrm.zzd(i5);
        if (i7 != 0) {
            zzfrm.zze(zzd2, i6 & i8, i7 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        for (int i9 = 0; i9 <= i4; i9++) {
            int zzc = zzfrm.zzc(obj, i9);
            while (zzc != 0) {
                int i10 = zzc - 1;
                int i11 = iArr[i10];
                int i12 = ((~i4) & i11) | i9;
                int i13 = i12 & i8;
                int zzc2 = zzfrm.zzc(zzd2, i13);
                zzfrm.zze(zzd2, i13, zzc);
                iArr[i10] = ((~i8) & i12) | (zzc2 & i8);
                zzc = i11 & i4;
            }
        }
        this.zze = zzd2;
        zzt(i8);
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzs(@CheckForNull Object obj) {
        if (zzo()) {
            return zzd;
        }
        int zzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        int zzb = zzfrm.zzb(obj, null, zzp, obj2, iArr, objArr, null);
        if (zzb == -1) {
            return zzd;
        }
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Object obj3 = objArr2[zzb];
        zzn(zzb, zzp);
        this.zzg--;
        zzl();
        return obj3;
    }

    private final void zzt(int i4) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i4)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzo()) {
            return;
        }
        zzl();
        Map zzj = zzj();
        if (zzj == null) {
            Object[] objArr = this.zzb;
            objArr.getClass();
            Arrays.fill(objArr, 0, this.zzg, (Object) null);
            Object[] objArr2 = this.zzc;
            objArr2.getClass();
            Arrays.fill(objArr2, 0, this.zzg, (Object) null);
            Object obj = this.zze;
            obj.getClass();
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, (short) 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            int[] iArr = this.zza;
            iArr.getClass();
            Arrays.fill(iArr, 0, this.zzg, 0);
            this.zzg = 0;
            return;
        }
        this.zzf = zzfuk.zzb(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        zzj.clear();
        this.zze = null;
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        Map zzj = zzj();
        if (zzj != null) {
            return zzj.containsKey(obj);
        }
        if (zzq(obj) == -1) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        Map zzj = zzj();
        if (zzj == null) {
            for (int i4 = 0; i4 < this.zzg; i4++) {
                Object[] objArr = this.zzc;
                objArr.getClass();
                if (zzfpc.zza(obj, objArr[i4])) {
                    return true;
                }
            }
            return false;
        }
        return zzj.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set == null) {
            zzfrf zzfrfVar = new zzfrf(this);
            this.zzi = zzfrfVar;
            return zzfrfVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Map zzj = zzj();
        if (zzj != null) {
            return zzj.get(obj);
        }
        int zzq = zzq(obj);
        if (zzq == -1) {
            return null;
        }
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr[zzq];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set == null) {
            zzfri zzfriVar = new zzfri(this);
            this.zzh = zzfriVar;
            return zzfriVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        int min;
        if (zzo()) {
            zzfph.zzi(zzo(), "Arrays already allocated");
            int i4 = this.zzf;
            int max = Math.max(i4 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > highestOneBit && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzfrm.zzd(max2);
            zzt(max2 - 1);
            this.zza = new int[i4];
            this.zzb = new Object[i4];
            this.zzc = new Object[i4];
        }
        Map zzj = zzj();
        if (zzj == null) {
            int[] iArr = this.zza;
            iArr.getClass();
            Object[] objArr = this.zzb;
            objArr.getClass();
            Object[] objArr2 = this.zzc;
            objArr2.getClass();
            int i5 = this.zzg;
            int i6 = i5 + 1;
            int zzb = zzfru.zzb(obj);
            int zzp = zzp();
            int i7 = zzb & zzp;
            Object obj3 = this.zze;
            obj3.getClass();
            int zzc = zzfrm.zzc(obj3, i7);
            if (zzc == 0) {
                if (i6 > zzp) {
                    zzp = zzr(zzp, zzfrm.zza(zzp), zzb, i5);
                } else {
                    Object obj4 = this.zze;
                    obj4.getClass();
                    zzfrm.zze(obj4, i7, i6);
                }
            } else {
                int i8 = ~zzp;
                int i9 = zzb & i8;
                int i10 = 0;
                while (true) {
                    int i11 = zzc - 1;
                    int i12 = iArr[i11];
                    int i13 = i12 & i8;
                    if (i13 == i9 && zzfpc.zza(obj, objArr[i11])) {
                        Object obj5 = objArr2[i11];
                        objArr2[i11] = obj2;
                        return obj5;
                    }
                    int i14 = i12 & zzp;
                    i10++;
                    if (i14 == 0) {
                        if (i10 >= 9) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                            int zze = zze();
                            while (zze >= 0) {
                                Object[] objArr3 = this.zzb;
                                objArr3.getClass();
                                Object obj6 = objArr3[zze];
                                Object[] objArr4 = this.zzc;
                                objArr4.getClass();
                                linkedHashMap.put(obj6, objArr4[zze]);
                                zze = zzf(zze);
                            }
                            this.zze = linkedHashMap;
                            this.zza = null;
                            this.zzb = null;
                            this.zzc = null;
                            zzl();
                            return linkedHashMap.put(obj, obj2);
                        } else if (i6 > zzp) {
                            zzp = zzr(zzp, zzfrm.zza(zzp), zzb, i5);
                        } else {
                            iArr[i11] = (i6 & zzp) | i13;
                        }
                    } else {
                        zzc = i14;
                    }
                }
            }
            int[] iArr2 = this.zza;
            iArr2.getClass();
            int length = iArr2.length;
            if (i6 > length && (min = Math.min((int) LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
                int[] iArr3 = this.zza;
                iArr3.getClass();
                this.zza = Arrays.copyOf(iArr3, min);
                Object[] objArr5 = this.zzb;
                objArr5.getClass();
                this.zzb = Arrays.copyOf(objArr5, min);
                Object[] objArr6 = this.zzc;
                objArr6.getClass();
                this.zzc = Arrays.copyOf(objArr6, min);
            }
            int[] iArr4 = this.zza;
            iArr4.getClass();
            iArr4[i5] = (~zzp) & zzb;
            Object[] objArr7 = this.zzb;
            objArr7.getClass();
            objArr7[i5] = obj;
            Object[] objArr8 = this.zzc;
            objArr8.getClass();
            objArr8[i5] = obj2;
            this.zzg = i6;
            zzl();
            return null;
        }
        return zzj.put(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        Map zzj = zzj();
        if (zzj != null) {
            return zzj.remove(obj);
        }
        Object zzs = zzs(obj);
        if (zzs == zzd) {
            return null;
        }
        return zzs;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map zzj = zzj();
        if (zzj != null) {
            return zzj.size();
        }
        return this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection == null) {
            zzfrk zzfrkVar = new zzfrk(this);
            this.zzj = zzfrkVar;
            return zzfrkVar;
        }
        return collection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzf(int i4) {
        int i5 = i4 + 1;
        if (i5 < this.zzg) {
            return i5;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public final Map zzj() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzl() {
        this.zzf += 32;
    }

    final void zzm(int i4) {
        this.zzf = zzfuk.zzb(8, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzn(int i4, int i5) {
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int size = size() - 1;
        if (i4 < size) {
            Object obj2 = objArr[size];
            objArr[i4] = obj2;
            objArr2[i4] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            iArr[i4] = iArr[size];
            iArr[size] = 0;
            int zzb = zzfru.zzb(obj2) & i5;
            int zzc = zzfrm.zzc(obj, zzb);
            int i6 = size + 1;
            if (zzc == i6) {
                zzfrm.zze(obj, zzb, i4 + 1);
                return;
            }
            while (true) {
                int i7 = zzc - 1;
                int i8 = iArr[i7];
                int i9 = i8 & i5;
                if (i9 != i6) {
                    zzc = i9;
                } else {
                    iArr[i7] = ((i4 + 1) & i5) | (i8 & (~i5));
                    return;
                }
            }
        } else {
            objArr[i4] = null;
            objArr2[i4] = null;
            iArr[i4] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzo() {
        if (this.zze == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfrl(int i4) {
        zzm(8);
    }
}
