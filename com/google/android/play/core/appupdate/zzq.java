package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzq extends zzo {

    /* renamed from: d  reason: collision with root package name */
    private final String f25249d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzr f25250e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnRequestInstallCallback"), taskCompletionSource);
        this.f25250e = zzrVar;
        this.f25249d = str;
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzc(Bundle bundle) throws RemoteException {
        int i4;
        int i5;
        super.zzc(bundle);
        i4 = bundle.getInt("error.code", -2);
        if (i4 != 0) {
            TaskCompletionSource taskCompletionSource = this.f25247b;
            i5 = bundle.getInt("error.code", -2);
            taskCompletionSource.trySetException(new InstallException(i5));
            return;
        }
        this.f25247b.trySetResult(zzr.f(this.f25250e, bundle, this.f25249d));
    }
}
