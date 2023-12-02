package com.google.android.gms.measurement.internal;

import android.os.Handler;
import androidx.annotation.WorkerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkl {

    /* renamed from: a  reason: collision with root package name */
    private zzkk f21997a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzkp f21998b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkl(zzkp zzkpVar) {
        this.f21998b = zzkpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(long j4) {
        Handler handler;
        this.f21997a = new zzkk(this, this.f21998b.f21734a.zzax().currentTimeMillis(), j4);
        handler = this.f21998b.f22005c;
        handler.postDelayed(this.f21997a, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b() {
        Handler handler;
        this.f21998b.zzg();
        zzkk zzkkVar = this.f21997a;
        if (zzkkVar != null) {
            handler = this.f21998b.f22005c;
            handler.removeCallbacks(zzkkVar);
        }
        this.f21998b.f21734a.zzm().f21606r.zza(false);
        this.f21998b.h(false);
    }
}
