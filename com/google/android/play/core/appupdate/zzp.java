package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzp extends zzo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnCompleteUpdateCallback"), taskCompletionSource);
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzb(Bundle bundle) throws RemoteException {
        int i4;
        int i5;
        super.zzb(bundle);
        i4 = bundle.getInt("error.code", -2);
        if (i4 != 0) {
            TaskCompletionSource taskCompletionSource = this.f25247b;
            i5 = bundle.getInt("error.code", -2);
            taskCompletionSource.trySetException(new InstallException(i5));
            return;
        }
        this.f25247b.trySetResult(null);
    }
}
