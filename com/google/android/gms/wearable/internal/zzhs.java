package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhs extends zzhn {
    public zzhs(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzk(zzdp zzdpVar) {
        zzac zzacVar;
        Status zza = zzhf.zza(zzdpVar.zza);
        zzao zzaoVar = zzdpVar.zzb;
        if (zzaoVar == null) {
            zzacVar = null;
        } else {
            zzacVar = new zzac(zzaoVar);
        }
        a(new zzae(zza, zzacVar));
    }
}
