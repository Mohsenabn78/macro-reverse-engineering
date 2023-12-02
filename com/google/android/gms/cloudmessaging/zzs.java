package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public final class zzs {
    @Nullable
    @GuardedBy("MessengerIpcClient.class")

    /* renamed from: e */
    private static zzs f19922e;

    /* renamed from: a */
    private final Context f19923a;

    /* renamed from: b */
    private final ScheduledExecutorService f19924b;
    @GuardedBy("this")

    /* renamed from: c */
    private zzm f19925c = new zzm(this, null);
    @GuardedBy("this")

    /* renamed from: d */
    private int f19926d = 1;

    @VisibleForTesting
    zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f19924b = scheduledExecutorService;
        this.f19923a = context.getApplicationContext();
    }

    public static /* bridge */ /* synthetic */ Context a(zzs zzsVar) {
        return zzsVar.f19923a;
    }

    public static /* bridge */ /* synthetic */ ScheduledExecutorService b(zzs zzsVar) {
        return zzsVar.f19924b;
    }

    private final synchronized int c() {
        int i4;
        i4 = this.f19926d;
        this.f19926d = i4 + 1;
        return i4;
    }

    private final synchronized <T> Task<T> d(zzp<T> zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzpVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
        }
        if (!this.f19925c.g(zzpVar)) {
            zzm zzmVar = new zzm(this, null);
            this.f19925c = zzmVar;
            zzmVar.g(zzpVar);
        }
        return zzpVar.f19919b.getTask();
    }

    public static synchronized zzs zzb(Context context) {
        zzs zzsVar;
        synchronized (zzs.class) {
            if (f19922e == null) {
                com.google.android.gms.internal.cloudmessaging.zze.zza();
                f19922e = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            zzsVar = f19922e;
        }
        return zzsVar;
    }

    public final Task<Void> zzc(int i4, Bundle bundle) {
        return d(new zzo(c(), 2, bundle));
    }

    public final Task<Bundle> zzd(int i4, Bundle bundle) {
        return d(new zzr(c(), 1, bundle));
    }
}
