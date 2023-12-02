package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzdz {
    public static final int zza(int i4, Object obj, Object obj2) {
        zzdy zzdyVar = (zzdy) obj;
        zzdx zzdxVar = (zzdx) obj2;
        if (!zzdyVar.isEmpty()) {
            Iterator it = zzdyVar.entrySet().iterator();
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
}
