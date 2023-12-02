package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zas extends zaa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zas(zay zayVar, TaskCompletionSource taskCompletionSource) {
        this.f20626a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zab(Status status) {
        TaskUtil.trySetResultOrApiException(status, null, this.f20626a);
    }
}
