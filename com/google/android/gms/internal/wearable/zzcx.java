package com.google.android.gms.internal.wearable;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzcx {
    public static final int zza(int i4, Object obj, Object obj2) {
        zzcw zzcwVar = (zzcw) obj;
        zzcv zzcvVar = (zzcv) obj2;
        if (!zzcwVar.isEmpty()) {
            Iterator it = zzcwVar.entrySet().iterator();
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
        zzcw zzcwVar = (zzcw) obj;
        zzcw zzcwVar2 = (zzcw) obj2;
        if (!zzcwVar2.isEmpty()) {
            if (!zzcwVar.zze()) {
                zzcwVar = zzcwVar.zzb();
            }
            zzcwVar.zzd(zzcwVar2);
        }
        return zzcwVar;
    }
}
