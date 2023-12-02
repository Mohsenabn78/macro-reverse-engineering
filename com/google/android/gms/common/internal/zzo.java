package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzo implements ServiceConnection, zzs {

    /* renamed from: a  reason: collision with root package name */
    private final Map f20574a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f20575b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20576c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private IBinder f20577d;

    /* renamed from: e  reason: collision with root package name */
    private final zzn f20578e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f20579f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ zzr f20580g;

    public zzo(zzr zzrVar, zzn zznVar) {
        this.f20580g = zzrVar;
        this.f20578e = zznVar;
    }

    public final int a() {
        return this.f20575b;
    }

    public final ComponentName b() {
        return this.f20579f;
    }

    @Nullable
    public final IBinder c() {
        return this.f20577d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f20574a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, @Nullable Executor executor) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j4;
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        this.f20575b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            permitUnsafeIntentLaunch = new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch();
            StrictMode.setVmPolicy(permitUnsafeIntentLaunch.build());
        }
        try {
            zzr zzrVar = this.f20580g;
            connectionTracker = zzrVar.f20586j;
            context = zzrVar.f20583g;
            zzn zznVar = this.f20578e;
            context2 = zzrVar.f20583g;
            boolean zza = connectionTracker.zza(context, str, zznVar.zzc(context2), this, this.f20578e.zza(), executor);
            this.f20576c = zza;
            if (zza) {
                handler = this.f20580g.f20584h;
                Message obtainMessage = handler.obtainMessage(1, this.f20578e);
                handler2 = this.f20580g.f20584h;
                j4 = this.f20580g.f20588l;
                handler2.sendMessageDelayed(obtainMessage, j4);
            } else {
                this.f20575b = 2;
                try {
                    zzr zzrVar2 = this.f20580g;
                    connectionTracker2 = zzrVar2.f20586j;
                    context3 = zzrVar2.f20583g;
                    connectionTracker2.unbindService(context3, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f20574a.remove(serviceConnection);
    }

    public final void g(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.f20580g.f20584h;
        handler.removeMessages(1, this.f20578e);
        zzr zzrVar = this.f20580g;
        connectionTracker = zzrVar.f20586j;
        context = zzrVar.f20583g;
        connectionTracker.unbindService(context, this);
        this.f20576c = false;
        this.f20575b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f20574a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f20574a.isEmpty();
    }

    public final boolean j() {
        return this.f20576c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f20580g.f20582f;
        synchronized (hashMap) {
            handler = this.f20580g.f20584h;
            handler.removeMessages(1, this.f20578e);
            this.f20577d = iBinder;
            this.f20579f = componentName;
            for (ServiceConnection serviceConnection : this.f20574a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f20575b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f20580g.f20582f;
        synchronized (hashMap) {
            handler = this.f20580g.f20584h;
            handler.removeMessages(1, this.f20578e);
            this.f20577d = null;
            this.f20579f = componentName;
            for (ServiceConnection serviceConnection : this.f20574a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f20575b = 2;
        }
    }
}
