package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzan {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f21456d;

    /* renamed from: a  reason: collision with root package name */
    private final zzgy f21457a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f21458b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f21459c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzgy zzgyVar) {
        Preconditions.checkNotNull(zzgyVar);
        this.f21457a = zzgyVar;
        this.f21458b = new zzam(this, zzgyVar);
    }

    private final Handler f() {
        Handler handler;
        if (f21456d != null) {
            return f21456d;
        }
        synchronized (zzan.class) {
            if (f21456d == null) {
                f21456d = new com.google.android.gms.internal.measurement.zzby(this.f21457a.zzaw().getMainLooper());
            }
            handler = f21456d;
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f21459c = 0L;
        f().removeCallbacks(this.f21458b);
    }

    public abstract void c();

    public final void d(long j4) {
        b();
        if (j4 >= 0) {
            this.f21459c = this.f21457a.zzax().currentTimeMillis();
            if (!f().postDelayed(this.f21458b, j4)) {
                this.f21457a.zzaA().zzd().zzb("Failed to schedule delayed post. time", Long.valueOf(j4));
            }
        }
    }

    public final boolean e() {
        if (this.f21459c != 0) {
            return true;
        }
        return false;
    }
}
