package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzfu implements BaseImplementation.ResultHolder {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f22771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(zzfw zzfwVar, TaskCompletionSource taskCompletionSource) {
        this.f22771a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f22771a.setException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        zzfv zzfvVar = (zzfv) obj;
        if (zzfvVar.getStatus().isSuccess()) {
            this.f22771a.setResult(zzfvVar.zza());
        } else {
            this.f22771a.setException(ApiExceptionUtil.fromStatus(zzfvVar.getStatus()));
        }
    }
}
