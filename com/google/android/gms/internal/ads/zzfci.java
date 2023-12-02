package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfci {
    private final HashMap zza = new HashMap();

    public final zzfch zza(zzfby zzfbyVar, Context context, zzfbq zzfbqVar, zzfco zzfcoVar) {
        zzfch zzfchVar = (zzfch) this.zza.get(zzfbyVar);
        if (zzfchVar == null) {
            zzfbv zzfbvVar = new zzfbv(zzfcb.zza(zzfbyVar, context));
            zzfch zzfchVar2 = new zzfch(zzfbvVar, new zzfcq(zzfbvVar, zzfbqVar, zzfcoVar));
            this.zza.put(zzfbyVar, zzfchVar2);
            return zzfchVar2;
        }
        return zzfchVar;
    }
}
