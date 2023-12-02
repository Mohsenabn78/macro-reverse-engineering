package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzfz {
    static final zzfz zza = new zzfz(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzfz() {
        this.zzd = new HashMap();
    }

    public final zzgm zza(zzhy zzhyVar, int i4) {
        return (zzgm) this.zzd.get(new zzfy(zzhyVar, i4));
    }

    zzfz(boolean z3) {
        this.zzd = Collections.emptyMap();
    }
}
