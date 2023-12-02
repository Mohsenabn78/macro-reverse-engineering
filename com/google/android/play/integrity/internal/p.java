package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class p extends l {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ v f25344f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(v vVar) {
        this.f25344f = vVar;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void b() {
        IInterface iInterface;
        k kVar;
        Context context;
        ServiceConnection serviceConnection;
        v vVar = this.f25344f;
        iInterface = vVar.f25362m;
        if (iInterface != null) {
            kVar = vVar.f25351b;
            kVar.d("Unbind from service.", new Object[0]);
            v vVar2 = this.f25344f;
            context = vVar2.f25350a;
            serviceConnection = vVar2.f25361l;
            context.unbindService(serviceConnection);
            this.f25344f.f25356g = false;
            this.f25344f.f25362m = null;
            this.f25344f.f25361l = null;
        }
        this.f25344f.t();
    }
}
