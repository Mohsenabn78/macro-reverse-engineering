package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzay implements BaseImplementation.ResultHolder {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f22432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzbh zzbhVar, TaskCompletionSource taskCompletionSource) {
        this.f22432a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.f22432a.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        this.f22432a.setResult(null);
    }
}
