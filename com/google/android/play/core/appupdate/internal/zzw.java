package com.google.android.play.core.appupdate.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzw implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzx f25194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzw(zzx zzxVar, zzv zzvVar) {
        this.f25194a = zzxVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzx.d(this.f25194a).zzd("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f25194a.zzc().post(new zzt(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzx.d(this.f25194a).zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f25194a.zzc().post(new zzu(this));
    }
}
