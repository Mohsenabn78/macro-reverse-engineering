package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzak extends zzad<Status> {
    public zzak(BaseImplementation.ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.internal.icing.zzad, com.google.android.gms.internal.icing.zzac
    public final void zzb(Status status) {
        this.zza.setResult(status);
    }
}
