package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzft implements BaseImplementation.ResultHolder {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f22770a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzft(zzfw zzfwVar, TaskCompletionSource taskCompletionSource) {
        this.f22770a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f22770a.setException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        MessageApi.SendMessageResult sendMessageResult = (MessageApi.SendMessageResult) obj;
        if (sendMessageResult.getStatus().isSuccess()) {
            this.f22770a.setResult(Integer.valueOf(sendMessageResult.getRequestId()));
        } else {
            this.f22770a.setException(ApiExceptionUtil.fromStatus(sendMessageResult.getStatus()));
        }
    }
}
