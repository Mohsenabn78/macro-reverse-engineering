package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzbn {
    static final zzbn zza = new zzbn(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzbn zzd;
    private final Map zze;

    zzbn() {
        this.zze = new HashMap();
    }

    public static zzbn zza() {
        zzbn zzbnVar = zzd;
        if (zzbnVar != null) {
            return zzbnVar;
        }
        synchronized (zzbn.class) {
            zzbn zzbnVar2 = zzd;
            if (zzbnVar2 != null) {
                return zzbnVar2;
            }
            zzbn zzb2 = zzbv.zzb(zzbn.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzbz zzb(zzdf zzdfVar, int i4) {
        return (zzbz) this.zze.get(new zzbm(zzdfVar, i4));
    }

    zzbn(boolean z3) {
        this.zze = Collections.emptyMap();
    }
}
