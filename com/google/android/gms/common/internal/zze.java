package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zze implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f20560a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20561b;

    public zze(BaseGmsClient baseGmsClient, int i4) {
        this.f20561b = baseGmsClient;
        this.f20560a = i4;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        IGmsServiceBroker zzacVar;
        BaseGmsClient baseGmsClient = this.f20561b;
        if (iBinder != null) {
            obj = baseGmsClient.zzq;
            synchronized (obj) {
                BaseGmsClient baseGmsClient2 = this.f20561b;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                    zzacVar = (IGmsServiceBroker) queryLocalInterface;
                } else {
                    zzacVar = new zzac(iBinder);
                }
                baseGmsClient2.zzr = zzacVar;
            }
            this.f20561b.zzl(0, null, this.f20560a);
            return;
        }
        BaseGmsClient.zzk(baseGmsClient, 16);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f20561b.zzq;
        synchronized (obj) {
            this.f20561b.zzr = null;
        }
        Handler handler = this.f20561b.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.f20560a, 1));
    }
}
