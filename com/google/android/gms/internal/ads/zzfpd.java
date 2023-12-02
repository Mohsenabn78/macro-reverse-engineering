package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfpd implements Serializable {
    public static zzfpd zzc() {
        return zzfol.zza;
    }

    public static zzfpd zzd(@CheckForNull Object obj) {
        if (obj == null) {
            return zzfol.zza;
        }
        return new zzfpm(obj);
    }

    public abstract zzfpd zza(zzfov zzfovVar);

    public abstract Object zzb(Object obj);
}
