package com.google.android.gms.internal.ads;

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

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfoh {
    private static final Map zza = new HashMap();
    private final Context zzb;
    private final zzfnw zzc;
    private boolean zzh;
    private final Intent zzi;
    @Nullable
    private ServiceConnection zzm;
    @Nullable
    private IInterface zzn;
    private final zzfne zzo;
    private final List zze = new ArrayList();
    @GuardedBy("attachedRemoteTasksLock")
    private final Set zzf = new HashSet();
    private final Object zzg = new Object();
    private final IBinder.DeathRecipient zzk = new IBinder.DeathRecipient() { // from class: com.google.android.gms.internal.ads.zzfnz
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzfoh.zzj(zzfoh.this);
        }
    };
    @GuardedBy("attachedRemoteTasksLock")
    private final AtomicInteger zzl = new AtomicInteger(0);
    private final String zzd = "OverlayDisplayService";
    private final WeakReference zzj = new WeakReference(null);

    public zzfoh(Context context, zzfnw zzfnwVar, String str, Intent intent, zzfne zzfneVar, @Nullable zzfoc zzfocVar) {
        this.zzb = context;
        this.zzc = zzfnwVar;
        this.zzi = intent;
        this.zzo = zzfneVar;
    }

    public static /* synthetic */ void zzj(zzfoh zzfohVar) {
        zzfohVar.zzc.zzc("reportBinderDeath", new Object[0]);
        zzfoc zzfocVar = (zzfoc) zzfohVar.zzj.get();
        if (zzfocVar != null) {
            zzfohVar.zzc.zzc("calling onBinderDied", new Object[0]);
            zzfocVar.zza();
        } else {
            zzfohVar.zzc.zzc("%s : Binder has died.", zzfohVar.zzd);
            for (zzfnx zzfnxVar : zzfohVar.zze) {
                zzfnxVar.zzc(zzfohVar.zzv());
            }
            zzfohVar.zze.clear();
        }
        synchronized (zzfohVar.zzg) {
            zzfohVar.zzw();
        }
    }

    public static /* bridge */ /* synthetic */ void zzn(zzfoh zzfohVar, final TaskCompletionSource taskCompletionSource) {
        zzfohVar.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfny
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzfoh.this.zzt(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void zzp(zzfoh zzfohVar, zzfnx zzfnxVar) {
        if (zzfohVar.zzn == null && !zzfohVar.zzh) {
            zzfohVar.zzc.zzc("Initiate binding to the service.", new Object[0]);
            zzfohVar.zze.add(zzfnxVar);
            zzfog zzfogVar = new zzfog(zzfohVar, null);
            zzfohVar.zzm = zzfogVar;
            zzfohVar.zzh = true;
            if (!zzfohVar.zzb.bindService(zzfohVar.zzi, zzfogVar, 1)) {
                zzfohVar.zzc.zzc("Failed to bind to the service.", new Object[0]);
                zzfohVar.zzh = false;
                for (zzfnx zzfnxVar2 : zzfohVar.zze) {
                    zzfnxVar2.zzc(new zzfoi());
                }
                zzfohVar.zze.clear();
            }
        } else if (zzfohVar.zzh) {
            zzfohVar.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            zzfohVar.zze.add(zzfnxVar);
        } else {
            zzfnxVar.run();
        }
    }

    public static /* bridge */ /* synthetic */ void zzq(zzfoh zzfohVar) {
        zzfohVar.zzc.zzc("linkToDeath", new Object[0]);
        try {
            zzfohVar.zzn.asBinder().linkToDeath(zzfohVar.zzk, 0);
        } catch (RemoteException e4) {
            zzfohVar.zzc.zzb(e4, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void zzr(zzfoh zzfohVar) {
        zzfohVar.zzc.zzc("unlinkToDeath", new Object[0]);
        zzfohVar.zzn.asBinder().unlinkToDeath(zzfohVar.zzk, 0);
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    @GuardedBy("attachedRemoteTasksLock")
    public final void zzw() {
        for (TaskCompletionSource taskCompletionSource : this.zzf) {
            taskCompletionSource.trySetException(zzv());
        }
        this.zzf.clear();
    }

    public final Handler zzc() {
        Handler handler;
        Map map = zza;
        synchronized (map) {
            if (!map.containsKey(this.zzd)) {
                HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                handlerThread.start();
                map.put(this.zzd, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.zzd);
        }
        return handler;
    }

    @Nullable
    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzs(zzfnx zzfnxVar, @Nullable TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzfoa(this, zzfnxVar.zzb(), taskCompletionSource, zzfnxVar));
    }

    public final /* synthetic */ void zzt(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    public final void zzu() {
        zzc().post(new zzfob(this));
    }
}
