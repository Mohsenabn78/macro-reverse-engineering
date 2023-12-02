package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zav extends IStatusCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zav(zay zayVar, TaskCompletionSource taskCompletionSource) {
        this.f20632a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.trySetResultOrApiException(status, Boolean.TRUE, this.f20632a);
    }
}
