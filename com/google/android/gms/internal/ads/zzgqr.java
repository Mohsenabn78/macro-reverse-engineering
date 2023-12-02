package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgqr {
    public static final int zza(int i4, Object obj, Object obj2) {
        zzgqq zzgqqVar = (zzgqq) obj;
        zzgqp zzgqpVar = (zzgqp) obj2;
        if (!zzgqqVar.isEmpty()) {
            Iterator it = zzgqqVar.entrySet().iterator();
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

    public static final boolean zzb(Object obj) {
        if (!((zzgqq) obj).zze()) {
            return true;
        }
        return false;
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzgqq zzgqqVar = (zzgqq) obj;
        zzgqq zzgqqVar2 = (zzgqq) obj2;
        if (!zzgqqVar2.isEmpty()) {
            if (!zzgqqVar.zze()) {
                zzgqqVar = zzgqqVar.zzb();
            }
            zzgqqVar.zzd(zzgqqVar2);
        }
        return zzgqqVar;
    }
}
