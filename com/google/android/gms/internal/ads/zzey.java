package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzey {
    @Nullable
    private static zzey zza;
    private final Handler zzb = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList zzc = new CopyOnWriteArrayList();
    private final Object zzd = new Object();
    @GuardedBy("networkTypeLock")
    private int zze = 0;

    private zzey(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new zzex(this, null), intentFilter);
    }

    public static synchronized zzey zzb(Context context) {
        zzey zzeyVar;
        synchronized (zzey.class) {
            if (zza == null) {
                zza = new zzey(context);
            }
            zzeyVar = zza;
        }
        return zzeyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzey zzeyVar, int i4) {
        synchronized (zzeyVar.zzd) {
            if (zzeyVar.zze == i4) {
                return;
            }
            zzeyVar.zze = i4;
            Iterator it = zzeyVar.zzc.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                zzxq zzxqVar = (zzxq) weakReference.get();
                if (zzxqVar != null) {
                    zzxqVar.zza.zzk(i4);
                } else {
                    zzeyVar.zzc.remove(weakReference);
                }
            }
        }
    }

    public final int zza() {
        int i4;
        synchronized (this.zzd) {
            i4 = this.zze;
        }
        return i4;
    }

    public final void zzd(final zzxq zzxqVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.zzc.remove(weakReference);
            }
        }
        this.zzc.add(new WeakReference(zzxqVar));
        this.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeu
            @Override // java.lang.Runnable
            public final void run() {
                zzey zzeyVar = zzey.this;
                zzxq zzxqVar2 = zzxqVar;
                zzxqVar2.zza.zzk(zzeyVar.zza());
            }
        });
    }
}
