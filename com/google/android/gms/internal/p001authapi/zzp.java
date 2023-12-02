package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzp  reason: invalid package */
/* loaded from: classes4.dex */
final class zzp extends zzh {
    private BaseImplementation.ResultHolder<Status> zzaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zzaq = resultHolder;
    }

    @Override // com.google.android.gms.internal.p001authapi.zzh, com.google.android.gms.internal.p001authapi.zzv
    public final void zzd(Status status) {
        this.zzaq.setResult(status);
    }
}
