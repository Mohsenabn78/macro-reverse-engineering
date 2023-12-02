package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkp extends zzf {

    /* renamed from: c  reason: collision with root package name */
    private Handler f22005c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22006d;

    /* renamed from: e  reason: collision with root package name */
    protected final zzko f22007e;

    /* renamed from: f  reason: collision with root package name */
    protected final zzkn f22008f;

    /* renamed from: g  reason: collision with root package name */
    protected final zzkl f22009g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkp(zzgd zzgdVar) {
        super(zzgdVar);
        this.f22006d = true;
        this.f22007e = new zzko(this);
        this.f22008f = new zzkn(this);
        this.f22009g = new zzkl(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void f(zzkp zzkpVar, long j4) {
        zzkpVar.zzg();
        zzkpVar.j();
        zzkpVar.f21734a.zzaA().zzj().zzb("Activity paused, time", Long.valueOf(j4));
        zzkpVar.f22009g.a(j4);
        if (zzkpVar.f21734a.zzf().zzu()) {
            zzkpVar.f22008f.b(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void g(zzkp zzkpVar, long j4) {
        zzkpVar.zzg();
        zzkpVar.j();
        zzkpVar.f21734a.zzaA().zzj().zzb("Activity resumed, time", Long.valueOf(j4));
        if (zzkpVar.f21734a.zzf().zzs(null, zzeg.zzaG)) {
            if (zzkpVar.f21734a.zzf().zzu() || zzkpVar.f22006d) {
                zzkpVar.f22008f.c(j4);
            }
        } else if (zzkpVar.f21734a.zzf().zzu() || zzkpVar.f21734a.zzm().f21606r.zzb()) {
            zzkpVar.f22008f.c(j4);
        }
        zzkpVar.f22009g.b();
        zzko zzkoVar = zzkpVar.f22007e;
        zzkoVar.f22004a.zzg();
        if (!zzkoVar.f22004a.f21734a.zzJ()) {
            return;
        }
        zzkoVar.b(zzkoVar.f22004a.f21734a.zzax().currentTimeMillis(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void j() {
        zzg();
        if (this.f22005c == null) {
            this.f22005c = new com.google.android.gms.internal.measurement.zzby(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void h(boolean z3) {
        zzg();
        this.f22006d = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean i() {
        zzg();
        return this.f22006d;
    }
}
