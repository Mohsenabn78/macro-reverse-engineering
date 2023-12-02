package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzgy extends zzkm {
    private final BaseImplementation.ResultHolder zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgy(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkn
    public final void zzb(zzln zzlnVar) {
        Status zzG;
        zzG = zzgz.zzG(zzlnVar.zza());
        if (zzG.isSuccess()) {
            this.zza.setResult(new zzgx(zzG, zzlnVar.zzb()));
        } else {
            this.zza.setFailedResult(zzG);
        }
    }
}
