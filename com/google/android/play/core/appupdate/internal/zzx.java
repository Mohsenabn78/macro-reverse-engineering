package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzx {

    /* renamed from: o */
    private static final Map f25195o = new HashMap();

    /* renamed from: a */
    private final Context f25196a;

    /* renamed from: b */
    private final zzm f25197b;

    /* renamed from: g */
    private boolean f25202g;

    /* renamed from: h */
    private final Intent f25203h;
    @Nullable

    /* renamed from: l */
    private ServiceConnection f25207l;
    @Nullable

    /* renamed from: m */
    private IInterface f25208m;

    /* renamed from: n */
    private final com.google.android.play.core.appupdate.zzl f25209n;

    /* renamed from: d */
    private final List f25199d = new ArrayList();
    @GuardedBy("attachedRemoteTasksLock")

    /* renamed from: e */
    private final Set f25200e = new HashSet();

    /* renamed from: f */
    private final Object f25201f = new Object();

    /* renamed from: j */
    private final IBinder.DeathRecipient f25205j = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.appupdate.internal.zzp
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzx.zzh(zzx.this);
        }
    };
    @GuardedBy("attachedRemoteTasksLock")

    /* renamed from: k */
    private final AtomicInteger f25206k = new AtomicInteger(0);

    /* renamed from: c */
    private final String f25198c = "AppUpdateService";

    /* renamed from: i */
    private final WeakReference f25204i = new WeakReference(null);

    public zzx(Context context, zzm zzmVar, String str, Intent intent, com.google.android.play.core.appupdate.zzl zzlVar, @Nullable zzs zzsVar, byte[] bArr) {
        this.f25196a = context;
        this.f25197b = zzmVar;
        this.f25203h = intent;
        this.f25209n = zzlVar;
    }

    public static /* bridge */ /* synthetic */ void j(zzx zzxVar, zzn zznVar) {
        if (zzxVar.f25208m == null && !zzxVar.f25202g) {
            zzxVar.f25197b.zzd("Initiate binding to the service.", new Object[0]);
            zzxVar.f25199d.add(zznVar);
            zzw zzwVar = new zzw(zzxVar, null);
            zzxVar.f25207l = zzwVar;
            zzxVar.f25202g = true;
            if (!zzxVar.f25196a.bindService(zzxVar.f25203h, zzwVar, 1)) {
                zzxVar.f25197b.zzd("Failed to bind to the service.", new Object[0]);
                zzxVar.f25202g = false;
                for (zzn zznVar2 : zzxVar.f25199d) {
                    zznVar2.zzc(new zzy());
                }
                zzxVar.f25199d.clear();
            }
        } else if (zzxVar.f25202g) {
            zzxVar.f25197b.zzd("Waiting to bind to the service.", new Object[0]);
            zzxVar.f25199d.add(zznVar);
        } else {
            zznVar.run();
        }
    }

    public static /* bridge */ /* synthetic */ void k(zzx zzxVar) {
        zzxVar.f25197b.zzd("linkToDeath", new Object[0]);
        try {
            zzxVar.f25208m.asBinder().linkToDeath(zzxVar.f25205j, 0);
        } catch (RemoteException e4) {
            zzxVar.f25197b.zzc(e4, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void l(zzx zzxVar) {
        zzxVar.f25197b.zzd("unlinkToDeath", new Object[0]);
        zzxVar.f25208m.asBinder().unlinkToDeath(zzxVar.f25205j, 0);
    }

    private final RemoteException n() {
        return new RemoteException(String.valueOf(this.f25198c).concat(" : Binder has died."));
    }

    public final void o() {
        synchronized (this.f25201f) {
            for (TaskCompletionSource taskCompletionSource : this.f25200e) {
                taskCompletionSource.trySetException(n());
            }
            this.f25200e.clear();
        }
    }

    public static /* synthetic */ void zzh(zzx zzxVar) {
        zzxVar.f25197b.zzd("reportBinderDeath", new Object[0]);
        zzs zzsVar = (zzs) zzxVar.f25204i.get();
        if (zzsVar != null) {
            zzxVar.f25197b.zzd("calling onBinderDied", new Object[0]);
            zzsVar.zza();
        } else {
            zzxVar.f25197b.zzd("%s : Binder has died.", zzxVar.f25198c);
            for (zzn zznVar : zzxVar.f25199d) {
                zznVar.zzc(zzxVar.n());
            }
            zzxVar.f25199d.clear();
        }
        zzxVar.o();
    }

    public final /* synthetic */ void m(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f25201f) {
            this.f25200e.remove(taskCompletionSource);
        }
    }

    public final Handler zzc() {
        Handler handler;
        Map map = f25195o;
        synchronized (map) {
            if (!map.containsKey(this.f25198c)) {
                HandlerThread handlerThread = new HandlerThread(this.f25198c, 10);
                handlerThread.start();
                map.put(this.f25198c, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f25198c);
        }
        return handler;
    }

    @Nullable
    public final IInterface zze() {
        return this.f25208m;
    }

    public final void zzp(zzn zznVar, @Nullable final TaskCompletionSource taskCompletionSource) {
        synchronized (this.f25201f) {
            this.f25200e.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.appupdate.internal.zzo
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzx.this.m(taskCompletionSource, task);
                }
            });
        }
        synchronized (this.f25201f) {
            if (this.f25206k.getAndIncrement() > 0) {
                this.f25197b.zza("Already connected to the service.", new Object[0]);
            }
        }
        zzc().post(new zzq(this, zznVar.b(), zznVar));
    }

    public final void zzr(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f25201f) {
            this.f25200e.remove(taskCompletionSource);
        }
        synchronized (this.f25201f) {
            if (this.f25206k.get() > 0 && this.f25206k.decrementAndGet() > 0) {
                this.f25197b.zzd("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            zzc().post(new zzr(this));
        }
    }
}
