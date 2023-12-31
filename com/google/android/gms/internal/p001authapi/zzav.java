package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzav  reason: invalid package */
/* loaded from: classes4.dex */
final class zzav extends zzad {
    private final /* synthetic */ TaskCompletionSource zzbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzao zzaoVar, TaskCompletionSource taskCompletionSource) {
        this.zzbq = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001authapi.zzaa
    public final void zzc(Status status, BeginSignInResult beginSignInResult) throws RemoteException {
        TaskUtil.setResultOrApiException(status, beginSignInResult, this.zzbq);
    }
}
