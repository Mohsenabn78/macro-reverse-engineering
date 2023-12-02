package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhw extends zzhn {
    public zzhw(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzt(zzeh zzehVar) {
        ArrayList arrayList = new ArrayList();
        List list = zzehVar.zzb;
        if (list != null) {
            arrayList.addAll(list);
        }
        a(new zzgb(zzhf.zza(zzehVar.zza), arrayList));
    }
}
