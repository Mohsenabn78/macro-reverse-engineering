package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class u implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f25348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(v vVar, t tVar) {
        this.f25348a = vVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        v.f(this.f25348a).d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f25348a.c().post(new r(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        v.f(this.f25348a).d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f25348a.c().post(new s(this));
    }
}
