package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgvz {
    final LinkedHashMap zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgvz(int i4) {
        this.zza = zzgwb.zzb(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgvz zza(Object obj, zzgwr zzgwrVar) {
        LinkedHashMap linkedHashMap = this.zza;
        zzgwm.zza(obj, "key");
        zzgwm.zza(zzgwrVar, "provider");
        linkedHashMap.put(obj, zzgwrVar);
        return this;
    }
}
