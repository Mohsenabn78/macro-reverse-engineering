package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public abstract class zzl {

    /* renamed from: a  reason: collision with root package name */
    protected final zzm f25180a;

    /* renamed from: b  reason: collision with root package name */
    private final IntentFilter f25181b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f25182c;

    /* renamed from: d  reason: collision with root package name */
    protected final Set f25183d = new HashSet();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private zzk f25184e = null;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f25185f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzl(zzm zzmVar, IntentFilter intentFilter, Context context) {
        this.f25180a = zzmVar;
        this.f25181b = intentFilter;
        this.f25182c = zzz.zza(context);
    }

    private final void b() {
        zzk zzkVar;
        if (!this.f25183d.isEmpty() && this.f25184e == null) {
            zzk zzkVar2 = new zzk(this, null);
            this.f25184e = zzkVar2;
            if (Build.VERSION.SDK_INT >= 33) {
                this.f25182c.registerReceiver(zzkVar2, this.f25181b, 2);
            }
            this.f25182c.registerReceiver(this.f25184e, this.f25181b);
        }
        if (this.f25183d.isEmpty() && (zzkVar = this.f25184e) != null) {
            this.f25182c.unregisterReceiver(zzkVar);
            this.f25184e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void zzb(StateUpdatedListener stateUpdatedListener) {
        this.f25180a.zzd("registerListener", new Object[0]);
        zzac.zza(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.f25183d.add(stateUpdatedListener);
        b();
    }

    public final synchronized void zzc(StateUpdatedListener stateUpdatedListener) {
        this.f25180a.zzd("unregisterListener", new Object[0]);
        zzac.zza(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.f25183d.remove(stateUpdatedListener);
        b();
    }

    public final synchronized void zzd(Object obj) {
        Iterator it = new HashSet(this.f25183d).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(obj);
        }
    }
}
