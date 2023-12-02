package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public final class zzm implements ServiceConnection {

    /* renamed from: c  reason: collision with root package name */
    zzn f19912c;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzs f19915f;
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    int f19910a = 0;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f19911b = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzf
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            zzm zzmVar = zzm.this;
            int i4 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(i4);
            }
            synchronized (zzmVar) {
                zzp<?> zzpVar = zzmVar.f19914e.get(i4);
                if (zzpVar == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i4);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                zzmVar.f19914e.remove(i4);
                zzmVar.f();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzpVar.c(new zzq(4, "Not supported by GmsCore", null));
                    return true;
                }
                zzpVar.a(data);
                return true;
            }
        }
    }));
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    final Queue<zzp<?>> f19913d = new ArrayDeque();
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    final SparseArray<zzp<?>> f19914e = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzm(zzs zzsVar, zzl zzlVar) {
        this.f19915f = zzsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i4, @Nullable String str) {
        b(i4, str, null);
    }

    final synchronized void b(int i4, @Nullable String str, @Nullable Throwable th) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            }
        }
        int i5 = this.f19910a;
        if (i5 != 0) {
            if (i5 != 1 && i5 != 2) {
                if (i5 != 3) {
                    return;
                }
                this.f19910a = 4;
                return;
            }
            Log.isLoggable("MessengerIpcClient", 2);
            this.f19910a = 4;
            ConnectionTracker.getInstance().unbindService(zzs.a(this.f19915f), this);
            zzq zzqVar = new zzq(i4, str, th);
            for (zzp<?> zzpVar : this.f19913d) {
                zzpVar.c(zzqVar);
            }
            this.f19913d.clear();
            for (int i6 = 0; i6 < this.f19914e.size(); i6++) {
                this.f19914e.valueAt(i6).c(zzqVar);
            }
            this.f19914e.clear();
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        zzs.b(this.f19915f).execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzh
            @Override // java.lang.Runnable
            public final void run() {
                final zzp<?> poll;
                final zzm zzmVar = zzm.this;
                while (true) {
                    synchronized (zzmVar) {
                        if (zzmVar.f19910a != 2) {
                            return;
                        }
                        if (zzmVar.f19913d.isEmpty()) {
                            zzmVar.f();
                            return;
                        }
                        poll = zzmVar.f19913d.poll();
                        zzmVar.f19914e.put(poll.f19918a, poll);
                        zzs.b(zzmVar.f19915f).schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzk
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzm.this.e(poll.f19918a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                    }
                    Context a4 = zzs.a(zzmVar.f19915f);
                    Messenger messenger = zzmVar.f19911b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f19920c;
                    obtain.arg1 = poll.f19918a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.b());
                    bundle.putString("pkg", a4.getPackageName());
                    bundle.putBundle("data", poll.f19921d);
                    obtain.setData(bundle);
                    try {
                        zzmVar.f19912c.a(obtain);
                    } catch (RemoteException e4) {
                        zzmVar.a(2, e4.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.f19910a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void e(int i4) {
        zzp<?> zzpVar = this.f19914e.get(i4);
        if (zzpVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i4);
            Log.w("MessengerIpcClient", sb.toString());
            this.f19914e.remove(i4);
            zzpVar.c(new zzq(3, "Timed out waiting for response", null));
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void f() {
        if (this.f19910a == 2 && this.f19913d.isEmpty() && this.f19914e.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.f19910a = 3;
            ConnectionTracker.getInstance().unbindService(zzs.a(this.f19915f), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean g(zzp<?> zzpVar) {
        boolean z3;
        int i4 = this.f19910a;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return false;
                }
                this.f19913d.add(zzpVar);
                c();
                return true;
            }
            this.f19913d.add(zzpVar);
            return true;
        }
        this.f19913d.add(zzpVar);
        if (this.f19910a == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        Log.isLoggable("MessengerIpcClient", 2);
        this.f19910a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (!ConnectionTracker.getInstance().bindService(zzs.a(this.f19915f), intent, this, 1)) {
                a(0, "Unable to bind to service");
            } else {
                zzs.b(this.f19915f).schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzm.this.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            }
        } catch (SecurityException e4) {
            b(0, "Unable to bind to service", e4);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Log.isLoggable("MessengerIpcClient", 2);
        zzs.b(this.f19915f).execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                zzm zzmVar = zzm.this;
                IBinder iBinder2 = iBinder;
                synchronized (zzmVar) {
                    try {
                        if (iBinder2 == null) {
                            zzmVar.a(0, "Null service connection");
                            return;
                        }
                        try {
                            zzmVar.f19912c = new zzn(iBinder2);
                            zzmVar.f19910a = 2;
                            zzmVar.c();
                        } catch (RemoteException e4) {
                            zzmVar.a(0, e4.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.isLoggable("MessengerIpcClient", 2);
        zzs.b(this.f19915f).execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
            @Override // java.lang.Runnable
            public final void run() {
                zzm.this.a(2, "Service disconnected");
            }
        });
    }
}
