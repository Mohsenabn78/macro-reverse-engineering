package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zap implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PendingResult f20528a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20529b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PendingResultUtil.ResultConverter f20530c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zas f20531d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zasVar) {
        this.f20528a = pendingResult;
        this.f20529b = taskCompletionSource;
        this.f20530c = resultConverter;
        this.f20531d = zasVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.f20529b.setResult(this.f20530c.convert(this.f20528a.await(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f20529b.setException(ApiExceptionUtil.fromStatus(status));
    }
}
