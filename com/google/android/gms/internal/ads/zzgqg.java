package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgqg extends zzgqk {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgqg(zzgqf zzgqfVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j4, int i4) {
        zzgqd zzgqdVar;
        List arrayList;
        List list = (List) zzgsq.zzh(obj, j4);
        if (list.isEmpty()) {
            if (list instanceof zzgqe) {
                arrayList = new zzgqd(i4);
            } else if ((list instanceof zzgrd) && (list instanceof zzgpv)) {
                arrayList = ((zzgpv) list).zzd(i4);
            } else {
                arrayList = new ArrayList(i4);
            }
            zzgsq.zzv(obj, j4, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i4);
            arrayList2.addAll(list);
            zzgsq.zzv(obj, j4, arrayList2);
            zzgqdVar = arrayList2;
        } else if (list instanceof zzgsl) {
            zzgqd zzgqdVar2 = new zzgqd(list.size() + i4);
            zzgqdVar2.addAll(zzgqdVar2.size(), (zzgsl) list);
            zzgsq.zzv(obj, j4, zzgqdVar2);
            zzgqdVar = zzgqdVar2;
        } else if ((list instanceof zzgrd) && (list instanceof zzgpv)) {
            zzgpv zzgpvVar = (zzgpv) list;
            if (!zzgpvVar.zzc()) {
                zzgpv zzd = zzgpvVar.zzd(list.size() + i4);
                zzgsq.zzv(obj, j4, zzd);
                return zzd;
            }
            return list;
        } else {
            return list;
        }
        return zzgqdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgqk
    public final List zza(Object obj, long j4) {
        return zzf(obj, j4, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgqk
    public final void zzb(Object obj, long j4) {
        Object unmodifiableList;
        List list = (List) zzgsq.zzh(obj, j4);
        if (list instanceof zzgqe) {
            unmodifiableList = ((zzgqe) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzgrd) && (list instanceof zzgpv)) {
                zzgpv zzgpvVar = (zzgpv) list;
                if (zzgpvVar.zzc()) {
                    zzgpvVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzgsq.zzv(obj, j4, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgqk
    public final void zzc(Object obj, Object obj2, long j4) {
        List list = (List) zzgsq.zzh(obj2, j4);
        List zzf = zzf(obj, j4, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzgsq.zzv(obj, j4, list);
    }

    private zzgqg() {
        super(null);
    }
}
