package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zzmd {
    public static final int zza(int i4, Object obj, Object obj2) {
        zzmc zzmcVar = (zzmc) obj;
        zzmb zzmbVar = (zzmb) obj2;
        if (!zzmcVar.isEmpty()) {
            Iterator it = zzmcVar.entrySet().iterator();
            if (!it.hasNext()) {
                return 0;
            }
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzmc zzmcVar = (zzmc) obj;
        zzmc zzmcVar2 = (zzmc) obj2;
        if (!zzmcVar2.isEmpty()) {
            if (!zzmcVar.zze()) {
                zzmcVar = zzmcVar.zzb();
            }
            zzmcVar.zzd(zzmcVar2);
        }
        return zzmcVar;
    }
}
