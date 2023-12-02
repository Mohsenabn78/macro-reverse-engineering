package com.google.android.play.integrity.internal;

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

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class v {

    /* renamed from: o */
    private static final Map f25349o = new HashMap();

    /* renamed from: a */
    private final Context f25350a;

    /* renamed from: b */
    private final k f25351b;

    /* renamed from: g */
    private boolean f25356g;

    /* renamed from: h */
    private final Intent f25357h;
    @Nullable

    /* renamed from: l */
    private ServiceConnection f25361l;
    @Nullable

    /* renamed from: m */
    private IInterface f25362m;

    /* renamed from: n */
    private final com.google.android.play.core.integrity.q f25363n;

    /* renamed from: d */
    private final List f25353d = new ArrayList();
    @GuardedBy("attachedRemoteTasksLock")

    /* renamed from: e */
    private final Set f25354e = new HashSet();

    /* renamed from: f */
    private final Object f25355f = new Object();

    /* renamed from: j */
    private final IBinder.DeathRecipient f25359j = new IBinder.DeathRecipient() { // from class: com.google.android.play.integrity.internal.n
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            v.h(v.this);
        }
    };
    @GuardedBy("attachedRemoteTasksLock")

    /* renamed from: k */
    private final AtomicInteger f25360k = new AtomicInteger(0);

    /* renamed from: c */
    private final String f25352c = "IntegrityService";

    /* renamed from: i */
    private final WeakReference f25358i = new WeakReference(null);

    public v(Context context, k kVar, String str, Intent intent, com.google.android.play.core.integrity.q qVar, @Nullable q qVar2, byte[] bArr) {
        this.f25350a = context;
        this.f25351b = kVar;
        this.f25357h = intent;
        this.f25363n = qVar;
    }

    public static /* synthetic */ void h(v vVar) {
        vVar.f25351b.d("reportBinderDeath", new Object[0]);
        q qVar = (q) vVar.f25358i.get();
        if (qVar != null) {
            vVar.f25351b.d("calling onBinderDied", new Object[0]);
            qVar.a();
        } else {
            vVar.f25351b.d("%s : Binder has died.", vVar.f25352c);
            for (l lVar : vVar.f25353d) {
                lVar.a(vVar.s());
            }
            vVar.f25353d.clear();
        }
        vVar.t();
    }

    public static /* bridge */ /* synthetic */ void m(v vVar, l lVar) {
        if (vVar.f25362m == null && !vVar.f25356g) {
            vVar.f25351b.d("Initiate binding to the service.", new Object[0]);
            vVar.f25353d.add(lVar);
            u uVar = new u(vVar, null);
            vVar.f25361l = uVar;
            vVar.f25356g = true;
            if (!vVar.f25350a.bindService(vVar.f25357h, uVar, 1)) {
                vVar.f25351b.d("Failed to bind to the service.", new Object[0]);
                vVar.f25356g = false;
                for (l lVar2 : vVar.f25353d) {
                    lVar2.a(new w());
                }
                vVar.f25353d.clear();
            }
        } else if (vVar.f25356g) {
            vVar.f25351b.d("Waiting to bind to the service.", new Object[0]);
            vVar.f25353d.add(lVar);
        } else {
            lVar.run();
        }
    }

    public static /* bridge */ /* synthetic */ void n(v vVar) {
        vVar.f25351b.d("linkToDeath", new Object[0]);
        try {
            vVar.f25362m.asBinder().linkToDeath(vVar.f25359j, 0);
        } catch (RemoteException e4) {
            vVar.f25351b.c(e4, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void o(v vVar) {
        vVar.f25351b.d("unlinkToDeath", new Object[0]);
        vVar.f25362m.asBinder().unlinkToDeath(vVar.f25359j, 0);
    }

    private final RemoteException s() {
        return new RemoteException(String.valueOf(this.f25352c).concat(" : Binder has died."));
    }

    public final void t() {
        synchronized (this.f25355f) {
            for (TaskCompletionSource taskCompletionSource : this.f25354e) {
                taskCompletionSource.trySetException(s());
            }
            this.f25354e.clear();
        }
    }

    public final Handler c() {
        Handler handler;
        Map map = f25349o;
        synchronized (map) {
            if (!map.containsKey(this.f25352c)) {
                HandlerThread handlerThread = new HandlerThread(this.f25352c, 10);
                handlerThread.start();
                map.put(this.f25352c, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f25352c);
        }
        return handler;
    }

    @Nullable
    public final IInterface e() {
        return this.f25362m;
    }

    public final void p(l lVar, @Nullable final TaskCompletionSource taskCompletionSource) {
        synchronized (this.f25355f) {
            this.f25354e.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.integrity.internal.m
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    v.this.q(taskCompletionSource, task);
                }
            });
        }
        synchronized (this.f25355f) {
            if (this.f25360k.getAndIncrement() > 0) {
                this.f25351b.a("Already connected to the service.", new Object[0]);
            }
        }
        c().post(new o(this, lVar.c(), lVar));
    }

    public final /* synthetic */ void q(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f25355f) {
            this.f25354e.remove(taskCompletionSource);
        }
    }

    public final void r(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f25355f) {
            this.f25354e.remove(taskCompletionSource);
        }
        synchronized (this.f25355f) {
            if (this.f25360k.get() > 0 && this.f25360k.decrementAndGet() > 0) {
                this.f25351b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            c().post(new p(this));
        }
    }
}
