package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfsi {
    public static boolean zza(Iterable iterable, zzfpi zzfpiVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzfpiVar.getClass();
            return zzc((List) iterable, zzfpiVar);
        }
        Iterator it = iterable.iterator();
        zzfpiVar.getClass();
        boolean z3 = false;
        while (it.hasNext()) {
            if (zzfpiVar.zza(it.next())) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    private static void zzb(List list, zzfpi zzfpiVar, int i4, int i5) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i5) {
                break;
            } else if (zzfpiVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i5--;
            if (i5 >= i4) {
                list.remove(i5);
            } else {
                return;
            }
        }
    }

    private static boolean zzc(List list, zzfpi zzfpiVar) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            Object obj = list.get(i4);
            if (!zzfpiVar.zza(obj)) {
                if (i4 > i5) {
                    try {
                        list.set(i5, obj);
                    } catch (IllegalArgumentException unused) {
                        zzb(list, zzfpiVar, i5, i4);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzb(list, zzfpiVar, i5, i4);
                        return true;
                    }
                }
                i5++;
            }
            i4++;
        }
        list.subList(i5, list.size()).clear();
        if (i4 == i5) {
            return false;
        }
        return true;
    }
}
