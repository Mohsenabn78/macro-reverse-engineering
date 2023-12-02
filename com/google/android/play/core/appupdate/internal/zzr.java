package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzr extends zzn {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzx f25190b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzx zzxVar) {
        this.f25190b = zzxVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        IInterface iInterface;
        zzm zzmVar;
        Context context;
        ServiceConnection serviceConnection;
        zzx zzxVar = this.f25190b;
        iInterface = zzxVar.f25208m;
        if (iInterface != null) {
            zzmVar = zzxVar.f25197b;
            zzmVar.zzd("Unbind from service.", new Object[0]);
            zzx zzxVar2 = this.f25190b;
            context = zzxVar2.f25196a;
            serviceConnection = zzxVar2.f25207l;
            context.unbindService(serviceConnection);
            this.f25190b.f25202g = false;
            this.f25190b.f25208m = null;
            this.f25190b.f25207l = null;
        }
        this.f25190b.o();
    }
}
