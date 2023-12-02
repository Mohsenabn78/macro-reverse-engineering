package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghl {
    private HashMap zza = new HashMap();

    public final zzghn zza() {
        if (this.zza != null) {
            zzghn zzghnVar = new zzghn(Collections.unmodifiableMap(this.zza), null);
            this.zza = null;
            return zzghnVar;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
