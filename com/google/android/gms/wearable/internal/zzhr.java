package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhr extends zzhn {
    public zzhr(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzj(zzdn zzdnVar) {
        Status zza = zzhf.zza(zzdnVar.zza);
        List<zzao> list = zzdnVar.zzb;
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (zzao zzaoVar : list) {
                hashMap.put(zzaoVar.getName(), new zzac(zzaoVar));
            }
        }
        a(new zzad(zza, hashMap));
    }
}
