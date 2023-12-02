package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzr extends GmsClientSupervisor {
    @GuardedBy("connectionStatus")

    /* renamed from: f  reason: collision with root package name */
    private final HashMap f20582f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Context f20583g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Handler f20584h;

    /* renamed from: i  reason: collision with root package name */
    private final zzq f20585i;

    /* renamed from: j  reason: collision with root package name */
    private final ConnectionTracker f20586j;

    /* renamed from: k  reason: collision with root package name */
    private final long f20587k;

    /* renamed from: l  reason: collision with root package name */
    private final long f20588l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(Context context, Looper looper) {
        zzq zzqVar = new zzq(this, null);
        this.f20585i = zzqVar;
        this.f20583g = context.getApplicationContext();
        this.f20584h = new com.google.android.gms.internal.common.zzi(looper, zzqVar);
        this.f20586j = ConnectionTracker.getInstance();
        this.f20587k = 5000L;
        this.f20588l = 300000L;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void a(zzn zznVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f20582f) {
            zzo zzoVar = (zzo) this.f20582f.get(zznVar);
            if (zzoVar != null) {
                if (zzoVar.h(serviceConnection)) {
                    zzoVar.f(serviceConnection, str);
                    if (zzoVar.i()) {
                        this.f20584h.sendMessageDelayed(this.f20584h.obtainMessage(0, zznVar), this.f20587k);
                    }
                } else {
                    String obj = zznVar.toString();
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj);
                }
            } else {
                String obj2 = zznVar.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + obj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean b(zzn zznVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor) {
        boolean j4;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f20582f) {
            zzo zzoVar = (zzo) this.f20582f.get(zznVar);
            if (zzoVar == null) {
                zzoVar = new zzo(this, zznVar);
                zzoVar.d(serviceConnection, serviceConnection, str);
                zzoVar.e(str, executor);
                this.f20582f.put(zznVar, zzoVar);
            } else {
                this.f20584h.removeMessages(0, zznVar);
                if (!zzoVar.h(serviceConnection)) {
                    zzoVar.d(serviceConnection, serviceConnection, str);
                    int a4 = zzoVar.a();
                    if (a4 != 1) {
                        if (a4 == 2) {
                            zzoVar.e(str, executor);
                        }
                    } else {
                        serviceConnection.onServiceConnected(zzoVar.b(), zzoVar.c());
                    }
                } else {
                    String obj = zznVar.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                }
            }
            j4 = zzoVar.j();
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(Looper looper) {
        synchronized (this.f20582f) {
            this.f20584h = new com.google.android.gms.internal.common.zzi(looper, this.f20585i);
        }
    }
}
