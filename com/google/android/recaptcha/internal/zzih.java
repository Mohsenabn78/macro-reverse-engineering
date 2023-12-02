package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzih {
    public static final /* synthetic */ int zza = 0;
    private static final zzih zzb = new zzih();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzim zzc = new zzhq();

    private zzih() {
    }

    public static zzih zza() {
        return zzb;
    }

    public final zzil zzb(Class cls) {
        zzgw.zzc(cls, "messageType");
        zzil zzilVar = (zzil) this.zzd.get(cls);
        if (zzilVar == null) {
            zzilVar = this.zzc.zza(cls);
            zzgw.zzc(cls, "messageType");
            zzgw.zzc(zzilVar, "schema");
            zzil zzilVar2 = (zzil) this.zzd.putIfAbsent(cls, zzilVar);
            if (zzilVar2 != null) {
                return zzilVar2;
            }
        }
        return zzilVar;
    }
}
