package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzb extends com.google.android.gms.internal.common.zzi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20554a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.f20554a = baseGmsClient;
    }

    private static final void a(Message message) {
        zzc zzcVar = (zzc) message.obj;
        zzcVar.b();
        zzcVar.zzg();
    }

    private static final boolean b(Message message) {
        int i4 = message.what;
        if (i4 == 2 || i4 == 1 || i4 == 7) {
            return true;
        }
        return false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        ConnectionResult connectionResult3;
        ConnectionResult connectionResult4;
        boolean z3;
        if (this.f20554a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i4 = message.what;
        if ((i4 != 1 && i4 != 7 && ((i4 != 4 || this.f20554a.enableLocalFallback()) && message.what != 5)) || this.f20554a.isConnecting()) {
            int i5 = message.what;
            PendingIntent pendingIntent = null;
            if (i5 == 4) {
                this.f20554a.zzB = new ConnectionResult(message.arg2);
                if (BaseGmsClient.zzo(this.f20554a)) {
                    BaseGmsClient baseGmsClient = this.f20554a;
                    z3 = baseGmsClient.zzC;
                    if (!z3) {
                        baseGmsClient.zzp(3, null);
                        return;
                    }
                }
                BaseGmsClient baseGmsClient2 = this.f20554a;
                connectionResult3 = baseGmsClient2.zzB;
                if (connectionResult3 != null) {
                    connectionResult4 = baseGmsClient2.zzB;
                } else {
                    connectionResult4 = new ConnectionResult(8);
                }
                this.f20554a.zzc.onReportServiceBinding(connectionResult4);
                this.f20554a.onConnectionFailed(connectionResult4);
                return;
            } else if (i5 == 5) {
                BaseGmsClient baseGmsClient3 = this.f20554a;
                connectionResult = baseGmsClient3.zzB;
                if (connectionResult != null) {
                    connectionResult2 = baseGmsClient3.zzB;
                } else {
                    connectionResult2 = new ConnectionResult(8);
                }
                this.f20554a.zzc.onReportServiceBinding(connectionResult2);
                this.f20554a.onConnectionFailed(connectionResult2);
                return;
            } else if (i5 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                ConnectionResult connectionResult5 = new ConnectionResult(message.arg2, pendingIntent);
                this.f20554a.zzc.onReportServiceBinding(connectionResult5);
                this.f20554a.onConnectionFailed(connectionResult5);
                return;
            } else if (i5 == 6) {
                this.f20554a.zzp(5, null);
                BaseGmsClient baseGmsClient4 = this.f20554a;
                baseConnectionCallbacks = baseGmsClient4.zzw;
                if (baseConnectionCallbacks != null) {
                    baseConnectionCallbacks2 = baseGmsClient4.zzw;
                    baseConnectionCallbacks2.onConnectionSuspended(message.arg2);
                }
                this.f20554a.onConnectionSuspended(message.arg2);
                BaseGmsClient.zzn(this.f20554a, 5, 1, null);
                return;
            } else if (i5 == 2 && !this.f20554a.isConnected()) {
                a(message);
                return;
            } else if (b(message)) {
                ((zzc) message.obj).zze();
                return;
            } else {
                int i6 = message.what;
                Log.wtf("GmsClient", "Don't know how to handle message: " + i6, new Exception());
                return;
            }
        }
        a(message);
    }
}
