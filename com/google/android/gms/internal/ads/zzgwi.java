package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwi extends zzgwa {
    private static final zzgwr zza = zzgwf.zza(Collections.emptyMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgwi(Map map, zzgwg zzgwgVar) {
        super(map);
    }

    public static zzgwh zzc(int i4) {
        return new zzgwh(i4, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zzd */
    public final Map zzb() {
        LinkedHashMap zzb = zzgwb.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzb.put(entry.getKey(), ((zzgwr) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzb);
    }
}
