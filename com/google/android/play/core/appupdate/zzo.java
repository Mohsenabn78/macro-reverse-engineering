package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
class zzo extends com.google.android.play.core.appupdate.internal.zzg {

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.play.core.appupdate.internal.zzm f25246a;

    /* renamed from: b  reason: collision with root package name */
    final TaskCompletionSource f25247b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzr f25248c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzr zzrVar, com.google.android.play.core.appupdate.internal.zzm zzmVar, TaskCompletionSource taskCompletionSource) {
        this.f25248c = zzrVar;
        this.f25246a = zzmVar;
        this.f25247b = taskCompletionSource;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzb(Bundle bundle) throws RemoteException {
        this.f25248c.f25253a.zzr(this.f25247b);
        this.f25246a.zzd("onCompleteUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzh
    public void zzc(Bundle bundle) throws RemoteException {
        this.f25248c.f25253a.zzr(this.f25247b);
        this.f25246a.zzd("onRequestInfo", new Object[0]);
    }
}
