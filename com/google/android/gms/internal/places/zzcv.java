package com.google.android.gms.internal.places;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzcv {
    private static final zzcv zzll = new zzcv();
    private final ConcurrentMap<Class<?>, zzda<?>> zzln = new ConcurrentHashMap();
    private final zzcz zzlm = new zzbx();

    private zzcv() {
    }

    public static zzcv zzcq() {
        return zzll;
    }

    public final <T> zzda<T> zzf(Class<T> cls) {
        zzbd.zzb(cls, "messageType");
        zzda<T> zzdaVar = (zzda<T>) this.zzln.get(cls);
        if (zzdaVar == null) {
            zzda<T> zze = this.zzlm.zze(cls);
            zzbd.zzb(cls, "messageType");
            zzbd.zzb(zze, "schema");
            zzda<T> zzdaVar2 = (zzda<T>) this.zzln.putIfAbsent(cls, zze);
            if (zzdaVar2 != null) {
                return zzdaVar2;
            }
            return zze;
        }
        return zzdaVar;
    }

    public final <T> zzda<T> zzq(T t3) {
        return zzf(t3.getClass());
    }
}
