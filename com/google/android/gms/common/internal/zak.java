package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zak implements Handler.Callback {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final zaj f20517a;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f20524h;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f20518b = new ArrayList();
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final ArrayList f20519c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f20520d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f20521e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f20522f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private boolean f20523g = false;

    /* renamed from: i  reason: collision with root package name */
    private final Object f20525i = new Object();

    public zak(Looper looper, zaj zajVar) {
        this.f20517a = zajVar;
        this.f20524h = new com.google.android.gms.internal.base.zau(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.f20525i) {
                if (this.f20521e && this.f20517a.isConnected() && this.f20518b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i4, new Exception());
        return false;
    }

    public final void zaa() {
        this.f20521e = false;
        this.f20522f.incrementAndGet();
    }

    public final void zab() {
        this.f20521e = true;
    }

    @VisibleForTesting
    public final void zac(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.f20524h, "onConnectionFailure must only be called on the Handler thread");
        this.f20524h.removeMessages(1);
        synchronized (this.f20525i) {
            ArrayList arrayList = new ArrayList(this.f20520d);
            int i4 = this.f20522f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                if (this.f20521e && this.f20522f.get() == i4) {
                    if (this.f20520d.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
                return;
            }
        }
    }

    @VisibleForTesting
    public final void zad(@Nullable Bundle bundle) {
        Preconditions.checkHandlerThread(this.f20524h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f20525i) {
            Preconditions.checkState(!this.f20523g);
            this.f20524h.removeMessages(1);
            this.f20523g = true;
            Preconditions.checkState(this.f20519c.isEmpty());
            ArrayList arrayList = new ArrayList(this.f20518b);
            int i4 = this.f20522f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f20521e || !this.f20517a.isConnected() || this.f20522f.get() != i4) {
                    break;
                } else if (!this.f20519c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f20519c.clear();
            this.f20523g = false;
        }
    }

    @VisibleForTesting
    public final void zae(int i4) {
        Preconditions.checkHandlerThread(this.f20524h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f20524h.removeMessages(1);
        synchronized (this.f20525i) {
            this.f20523g = true;
            ArrayList arrayList = new ArrayList(this.f20518b);
            int i5 = this.f20522f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f20521e || this.f20522f.get() != i5) {
                    break;
                } else if (this.f20518b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i4);
                }
            }
            this.f20519c.clear();
            this.f20523g = false;
        }
    }

    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.f20525i) {
            if (this.f20518b.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + valueOf + " is already registered");
            } else {
                this.f20518b.add(connectionCallbacks);
            }
        }
        if (this.f20517a.isConnected()) {
            Handler handler = this.f20524h;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void zag(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.f20525i) {
            if (this.f20520d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + valueOf + " is already registered");
            } else {
                this.f20520d.add(onConnectionFailedListener);
            }
        }
    }

    public final void zah(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.f20525i) {
            if (!this.f20518b.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + valueOf + " not found");
            } else if (this.f20523g) {
                this.f20519c.add(connectionCallbacks);
            }
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.f20525i) {
            if (!this.f20520d.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + valueOf + " not found");
            }
        }
    }

    public final boolean zaj(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.f20525i) {
            contains = this.f20518b.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean zak(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.f20525i) {
            contains = this.f20520d.contains(onConnectionFailedListener);
        }
        return contains;
    }
}
