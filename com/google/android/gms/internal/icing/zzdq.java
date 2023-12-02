package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzdq extends zzds {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdq(zzdp zzdpVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzds
    public final void zza(Object obj, long j4) {
        Object unmodifiableList;
        List list = (List) zzfn.zzn(obj, j4);
        if (list instanceof zzdo) {
            unmodifiableList = ((zzdo) list).zzi();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzel) && (list instanceof zzdg)) {
                zzdg zzdgVar = (zzdg) list;
                if (zzdgVar.zza()) {
                    zzdgVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzfn.zzo(obj, j4, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzds
    public final <E> void zzb(Object obj, Object obj2, long j4) {
        ArrayList arrayList;
        List list = (List) zzfn.zzn(obj2, j4);
        int size = list.size();
        List list2 = (List) zzfn.zzn(obj, j4);
        if (list2.isEmpty()) {
            if (list2 instanceof zzdo) {
                list2 = new zzdn(size);
            } else if ((list2 instanceof zzel) && (list2 instanceof zzdg)) {
                list2 = ((zzdg) list2).zze(size);
            } else {
                list2 = new ArrayList(size);
            }
            zzfn.zzo(obj, j4, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList2 = new ArrayList(list2.size() + size);
                arrayList2.addAll(list2);
                zzfn.zzo(obj, j4, arrayList2);
                arrayList = arrayList2;
            } else if (list2 instanceof zzfi) {
                zzdn zzdnVar = new zzdn(list2.size() + size);
                zzdnVar.addAll(zzdnVar.size(), (zzfi) list2);
                zzfn.zzo(obj, j4, zzdnVar);
                arrayList = zzdnVar;
            } else if ((list2 instanceof zzel) && (list2 instanceof zzdg)) {
                zzdg zzdgVar = (zzdg) list2;
                if (!zzdgVar.zza()) {
                    list2 = zzdgVar.zze(list2.size() + size);
                    zzfn.zzo(obj, j4, list2);
                }
            }
            list2 = arrayList;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzfn.zzo(obj, j4, list);
    }

    private zzdq() {
        super(null);
    }
}
