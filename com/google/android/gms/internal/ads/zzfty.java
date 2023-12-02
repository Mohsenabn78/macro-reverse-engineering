package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfty {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Set set) {
        int i4;
        int i5 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i4 = obj.hashCode();
            } else {
                i4 = 0;
            }
            i5 += i4;
        }
        return i5;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzb(Set set, zzfpi zzfpiVar) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof zzftv) {
                zzftv zzftvVar = (zzftv) sortedSet;
                return new zzftw((SortedSet) zzftvVar.zza, zzfpl.zza(zzftvVar.zzb, zzfpiVar));
            }
            sortedSet.getClass();
            return new zzftw(sortedSet, zzfpiVar);
        } else if (set instanceof zzftv) {
            zzftv zzftvVar2 = (zzftv) set;
            return new zzftv(zzftvVar2.zza, zzfpl.zza(zzftvVar2.zzb, zzfpiVar));
        } else {
            set.getClass();
            return new zzftv(set, zzfpiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc(Set set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzfti) {
            collection = ((zzfti) collection).zza();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            Iterator it = set.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z3 = true;
                }
            }
            return z3;
        }
        return zze(set, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(Set set, Iterator it) {
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= set.remove(it.next());
        }
        return z3;
    }
}
