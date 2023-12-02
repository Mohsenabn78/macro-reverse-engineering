package com.google.android.gms.internal.places;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class zzbw extends zzbu {
    private static final Class<?> zzkd = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzbw() {
        super();
    }

    private static <E> List<E> zzd(Object obj, long j4) {
        return (List) zzdy.zzp(obj, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzbu
    public final void zzb(Object obj, long j4) {
        Object unmodifiableList;
        List list = (List) zzdy.zzp(obj, j4);
        if (list instanceof zzbr) {
            unmodifiableList = ((zzbr) list).zzbz();
        } else if (zzkd.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzcw) && (list instanceof zzbh)) {
                zzbh zzbhVar = (zzbh) list;
                if (zzbhVar.zzaa()) {
                    zzbhVar.zzab();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzdy.zzb(obj, j4, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzbu
    public final <E> void zzb(Object obj, Object obj2, long j4) {
        ArrayList arrayList;
        List zzd = zzd(obj2, j4);
        int size = zzd.size();
        List zzd2 = zzd(obj, j4);
        if (zzd2.isEmpty()) {
            if (zzd2 instanceof zzbr) {
                zzd2 = new zzbs(size);
            } else if ((zzd2 instanceof zzcw) && (zzd2 instanceof zzbh)) {
                zzd2 = ((zzbh) zzd2).zzh(size);
            } else {
                zzd2 = new ArrayList(size);
            }
            zzdy.zzb(obj, j4, zzd2);
        } else {
            if (zzkd.isAssignableFrom(zzd2.getClass())) {
                ArrayList arrayList2 = new ArrayList(zzd2.size() + size);
                arrayList2.addAll(zzd2);
                zzdy.zzb(obj, j4, arrayList2);
                arrayList = arrayList2;
            } else if (zzd2 instanceof zzdt) {
                List zzbsVar = new zzbs(zzd2.size() + size);
                zzbsVar.addAll((zzdt) zzd2);
                zzdy.zzb(obj, j4, zzbsVar);
                arrayList = zzbsVar;
            } else if ((zzd2 instanceof zzcw) && (zzd2 instanceof zzbh)) {
                zzbh zzbhVar = (zzbh) zzd2;
                if (!zzbhVar.zzaa()) {
                    zzd2 = zzbhVar.zzh(zzd2.size() + size);
                    zzdy.zzb(obj, j4, zzd2);
                }
            }
            zzd2 = arrayList;
        }
        int size2 = zzd2.size();
        int size3 = zzd.size();
        if (size2 > 0 && size3 > 0) {
            zzd2.addAll(zzd);
        }
        if (size2 > 0) {
            zzd = zzd2;
        }
        zzdy.zzb(obj, j4, zzd);
    }
}
