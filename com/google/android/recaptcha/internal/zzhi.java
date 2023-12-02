package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzhi extends zzhm {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhi(zzhh zzhhVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j4, int i4) {
        zzhf zzhfVar;
        List arrayList;
        List list = (List) zzjp.zzf(obj, j4);
        if (list.isEmpty()) {
            if (list instanceof zzhg) {
                arrayList = new zzhf(i4);
            } else if ((list instanceof zzig) && (list instanceof zzgv)) {
                arrayList = ((zzgv) list).zzd(i4);
            } else {
                arrayList = new ArrayList(i4);
            }
            zzjp.zzs(obj, j4, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i4);
            arrayList2.addAll(list);
            zzjp.zzs(obj, j4, arrayList2);
            zzhfVar = arrayList2;
        } else if (list instanceof zzjk) {
            zzhf zzhfVar2 = new zzhf(list.size() + i4);
            zzhfVar2.addAll(zzhfVar2.size(), (zzjk) list);
            zzjp.zzs(obj, j4, zzhfVar2);
            zzhfVar = zzhfVar2;
        } else if ((list instanceof zzig) && (list instanceof zzgv)) {
            zzgv zzgvVar = (zzgv) list;
            if (!zzgvVar.zzc()) {
                zzgv zzd = zzgvVar.zzd(list.size() + i4);
                zzjp.zzs(obj, j4, zzd);
                return zzd;
            }
            return list;
        } else {
            return list;
        }
        return zzhfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzhm
    public final List zza(Object obj, long j4) {
        return zzf(obj, j4, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzhm
    public final void zzb(Object obj, long j4) {
        Object unmodifiableList;
        List list = (List) zzjp.zzf(obj, j4);
        if (list instanceof zzhg) {
            unmodifiableList = ((zzhg) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzig) && (list instanceof zzgv)) {
                zzgv zzgvVar = (zzgv) list;
                if (zzgvVar.zzc()) {
                    zzgvVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzjp.zzs(obj, j4, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzhm
    public final void zzc(Object obj, Object obj2, long j4) {
        List list = (List) zzjp.zzf(obj2, j4);
        List zzf = zzf(obj, j4, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzjp.zzs(obj, j4, list);
    }

    private zzhi() {
        super(null);
    }
}
