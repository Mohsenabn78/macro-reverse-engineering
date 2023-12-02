package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzff {

    /* renamed from: a  reason: collision with root package name */
    private final Map f22760a = new HashMap();

    public final void a(zzim zzimVar, BaseImplementation.ResultHolder resultHolder, Object obj, zzit zzitVar) throws RemoteException {
        synchronized (this.f22760a) {
            if (this.f22760a.get(obj) != null) {
                if (Log.isLoggable("WearableClient", 2)) {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder();
                    sb.append("duplicate listener: ");
                    sb.append(valueOf);
                }
                resultHolder.setResult(new Status(WearableStatusCodes.DUPLICATE_LISTENER));
                return;
            }
            if (Log.isLoggable("WearableClient", 2)) {
                String valueOf2 = String.valueOf(obj);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("new listener: ");
                sb2.append(valueOf2);
            }
            this.f22760a.put(obj, zzitVar);
            try {
                ((zzfb) zzimVar.getService()).zzd(new zzfd(this.f22760a, obj, resultHolder), new zzd(zzitVar));
            } catch (RemoteException e4) {
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf3 = String.valueOf(obj);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("addListener failed, removing listener: ");
                    sb3.append(valueOf3);
                }
                this.f22760a.remove(obj);
                throw e4;
            }
        }
    }

    public final void b(IBinder iBinder) {
        zzfb zzfbVar;
        synchronized (this.f22760a) {
            if (iBinder == null) {
                zzfbVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
                if (queryLocalInterface instanceof zzfb) {
                    zzfbVar = (zzfb) queryLocalInterface;
                } else {
                    zzfbVar = new zzfb(iBinder);
                }
            }
            zzib zzibVar = new zzib();
            for (Map.Entry entry : this.f22760a.entrySet()) {
                zzit zzitVar = (zzit) entry.getValue();
                try {
                    zzfbVar.zzd(zzibVar, new zzd(zzitVar));
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf = String.valueOf(entry.getKey());
                        String valueOf2 = String.valueOf(zzitVar);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onPostInitHandler: added: ");
                        sb.append(valueOf);
                        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                        sb.append(valueOf2);
                    }
                } catch (RemoteException unused) {
                    String valueOf3 = String.valueOf(entry.getKey());
                    String valueOf4 = String.valueOf(zzitVar);
                    Log.w("WearableClient", "onPostInitHandler: Didn't add: " + valueOf3 + RemoteSettings.FORWARD_SLASH_STRING + valueOf4);
                }
            }
        }
    }

    public final void c(zzim zzimVar, BaseImplementation.ResultHolder resultHolder, Object obj) throws RemoteException {
        synchronized (this.f22760a) {
            zzit zzitVar = (zzit) this.f22760a.remove(obj);
            if (zzitVar == null) {
                if (Log.isLoggable("WearableClient", 2)) {
                    String valueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder();
                    sb.append("remove Listener unknown: ");
                    sb.append(valueOf);
                }
                resultHolder.setResult(new Status(WearableStatusCodes.UNKNOWN_LISTENER));
                return;
            }
            zzitVar.zzs();
            if (Log.isLoggable("WearableClient", 2)) {
                String valueOf2 = String.valueOf(obj);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("service.removeListener: ");
                sb2.append(valueOf2);
            }
            ((zzfb) zzimVar.getService()).zzx(new zzfe(this.f22760a, obj, resultHolder), new zzgw(zzitVar));
        }
    }
}
