package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
final class zzl extends IStatusCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f28824a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzm f28825b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(zzm zzmVar, TaskCompletionSource taskCompletionSource) {
        this.f28825b = zzmVar;
        this.f28824a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) throws RemoteException {
        TaskCompletionSource taskCompletionSource;
        TaskCompletionSource taskCompletionSource2;
        if (this.f28824a.trySetResult(null)) {
            if (status.isSuccess()) {
                taskCompletionSource2 = this.f28825b.f28826d.f28828b;
                taskCompletionSource2.setResult(null);
                return;
            }
            taskCompletionSource = this.f28825b.f28826d.f28828b;
            taskCompletionSource.setException(zzaf.zza(status, "Indexing error, please try again."));
        }
    }
}
