package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
final class zzn {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f19916a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final zzd f19917b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(IBinder iBinder) throws RemoteException {
        String str;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f19916a = new Messenger(iBinder);
            this.f19917b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f19917b = new zzd(iBinder);
            this.f19916a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                str = "Invalid interface descriptor: ".concat(valueOf);
            } else {
                str = new String("Invalid interface descriptor: ");
            }
            Log.w("MessengerIpcClient", str);
            throw new RemoteException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f19916a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzd zzdVar = this.f19917b;
        if (zzdVar != null) {
            zzdVar.zzb(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
