package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgre {
    private static final zzgre zza = new zzgre();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgrq zzb = new zzgqo();

    private zzgre() {
    }

    public static zzgre zza() {
        return zza;
    }

    public final zzgrp zzb(Class cls) {
        zzgpw.zzc(cls, "messageType");
        zzgrp zzgrpVar = (zzgrp) this.zzc.get(cls);
        if (zzgrpVar == null) {
            zzgrpVar = this.zzb.zza(cls);
            zzgpw.zzc(cls, "messageType");
            zzgrp zzgrpVar2 = (zzgrp) this.zzc.putIfAbsent(cls, zzgrpVar);
            if (zzgrpVar2 != null) {
                return zzgrpVar2;
            }
        }
        return zzgrpVar;
    }
}
