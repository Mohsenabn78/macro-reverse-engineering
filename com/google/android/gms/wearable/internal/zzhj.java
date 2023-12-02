package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhj implements BaseImplementation.ResultHolder {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource f22796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhj(TaskCompletionSource taskCompletionSource) {
        this.f22796a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f22796a.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        int statusCode = status.getStatusCode();
        if (statusCode != 0 && statusCode != 4001) {
            setFailedResult(status);
        } else {
            this.f22796a.setResult(null);
        }
    }
}
