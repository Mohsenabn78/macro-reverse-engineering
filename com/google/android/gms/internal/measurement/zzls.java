package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zzls extends zzlw {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzls(zzlr zzlrVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zza(Object obj, long j4) {
        Object unmodifiableList;
        List list = (List) zznu.zzf(obj, j4);
        if (list instanceof zzlq) {
            unmodifiableList = ((zzlq) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzmp) && (list instanceof zzli)) {
                zzli zzliVar = (zzli) list;
                if (zzliVar.zzc()) {
                    zzliVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zznu.zzs(obj, j4, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzb(Object obj, Object obj2, long j4) {
        zzlp zzlpVar;
        List list = (List) zznu.zzf(obj2, j4);
        int size = list.size();
        List list2 = (List) zznu.zzf(obj, j4);
        if (list2.isEmpty()) {
            if (list2 instanceof zzlq) {
                list2 = new zzlp(size);
            } else if ((list2 instanceof zzmp) && (list2 instanceof zzli)) {
                list2 = ((zzli) list2).zzd(size);
            } else {
                list2 = new ArrayList(size);
            }
            zznu.zzs(obj, j4, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zznu.zzs(obj, j4, arrayList);
                zzlpVar = arrayList;
            } else if (list2 instanceof zznp) {
                zzlp zzlpVar2 = new zzlp(list2.size() + size);
                zzlpVar2.addAll(zzlpVar2.size(), (zznp) list2);
                zznu.zzs(obj, j4, zzlpVar2);
                zzlpVar = zzlpVar2;
            } else if ((list2 instanceof zzmp) && (list2 instanceof zzli)) {
                zzli zzliVar = (zzli) list2;
                if (!zzliVar.zzc()) {
                    list2 = zzliVar.zzd(list2.size() + size);
                    zznu.zzs(obj, j4, list2);
                }
            }
            list2 = zzlpVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zznu.zzs(obj, j4, list);
    }

    private zzls() {
        super(null);
    }
}
