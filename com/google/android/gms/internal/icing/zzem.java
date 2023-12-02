package com.google.android.gms.internal.icing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzem {
    private static final zzem zza = new zzem();
    private final ConcurrentMap<Class<?>, zzep<?>> zzc = new ConcurrentHashMap();
    private final zzeq zzb = new zzdw();

    private zzem() {
    }

    public static zzem zza() {
        return zza;
    }

    public final <T> zzep<T> zzb(Class<T> cls) {
        zzdh.zzb(cls, "messageType");
        zzep<T> zzepVar = (zzep<T>) this.zzc.get(cls);
        if (zzepVar == null) {
            zzepVar = this.zzb.zza(cls);
            zzdh.zzb(cls, "messageType");
            zzdh.zzb(zzepVar, "schema");
            zzep putIfAbsent = this.zzc.putIfAbsent(cls, zzepVar);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return zzepVar;
    }
}
