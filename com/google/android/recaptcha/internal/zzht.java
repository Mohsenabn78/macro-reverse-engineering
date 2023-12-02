package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzht {
    public static final int zza(int i4, Object obj, Object obj2) {
        zzhs zzhsVar = (zzhs) obj;
        zzhr zzhrVar = (zzhr) obj2;
        if (!zzhsVar.isEmpty()) {
            Iterator it = zzhsVar.entrySet().iterator();
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
        if (!((zzhs) obj).zze()) {
            return true;
        }
        return false;
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzhs zzhsVar = (zzhs) obj;
        zzhs zzhsVar2 = (zzhs) obj2;
        if (!zzhsVar2.isEmpty()) {
            if (!zzhsVar.zze()) {
                zzhsVar = zzhsVar.zzb();
            }
            zzhsVar.zzd(zzhsVar2);
        }
        return zzhsVar;
    }
}
