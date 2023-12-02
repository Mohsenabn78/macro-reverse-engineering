package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzgi implements BaseImplementation.ResultHolder {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f22783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(zzgl zzglVar, TaskCompletionSource taskCompletionSource) {
        this.f22783a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f22783a.setException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        zzgk zzgkVar = (zzgk) obj;
        if (zzgkVar.getStatus().isSuccess()) {
            this.f22783a.setResult(zzgkVar.zza());
        } else {
            this.f22783a.setException(ApiExceptionUtil.fromStatus(zzgkVar.getStatus()));
        }
    }
}
