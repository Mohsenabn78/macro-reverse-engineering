package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzmq {
    private static final zzmq zza = new zzmq();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzmu zzb = new zzma();

    private zzmq() {
    }

    public static zzmq zza() {
        return zza;
    }

    public final zzmt zzb(Class cls) {
        zzlj.zzc(cls, "messageType");
        zzmt zzmtVar = (zzmt) this.zzc.get(cls);
        if (zzmtVar == null) {
            zzmtVar = this.zzb.zza(cls);
            zzlj.zzc(cls, "messageType");
            zzlj.zzc(zzmtVar, "schema");
            zzmt zzmtVar2 = (zzmt) this.zzc.putIfAbsent(cls, zzmtVar);
            if (zzmtVar2 != null) {
                return zzmtVar2;
            }
        }
        return zzmtVar;
    }
}
