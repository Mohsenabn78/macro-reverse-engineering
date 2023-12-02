package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhi implements BaseImplementation.ResultHolder {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource f22795a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhi(TaskCompletionSource taskCompletionSource) {
        this.f22795a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f22795a.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        int statusCode = status.getStatusCode();
        if (statusCode == 0) {
            this.f22795a.setResult(Boolean.TRUE);
        } else if (statusCode == 4002) {
            this.f22795a.setResult(Boolean.FALSE);
        } else {
            setFailedResult(status);
        }
    }
}
