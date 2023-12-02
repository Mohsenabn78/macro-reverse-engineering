package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzph;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkn {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    protected long f22000a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    protected long f22001b;

    /* renamed from: c  reason: collision with root package name */
    private final zzan f22002c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzkp f22003d;

    public zzkn(zzkp zzkpVar) {
        this.f22003d = zzkpVar;
        this.f22002c = new zzkm(this, zzkpVar.f21734a);
        long elapsedRealtime = zzkpVar.f21734a.zzax().elapsedRealtime();
        this.f22000a = elapsedRealtime;
        this.f22001b = elapsedRealtime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f22002c.b();
        this.f22000a = 0L;
        this.f22001b = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(long j4) {
        this.f22002c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void c(long j4) {
        this.f22003d.zzg();
        this.f22002c.b();
        this.f22000a = j4;
        this.f22001b = j4;
    }

    @WorkerThread
    public final boolean d(boolean z3, boolean z4, long j4) {
        this.f22003d.zzg();
        this.f22003d.zza();
        zzph.zzc();
        if (this.f22003d.f21734a.zzf().zzs(null, zzeg.zzaf)) {
            if (this.f22003d.f21734a.zzJ()) {
                this.f22003d.f21734a.zzm().f21603o.zzb(this.f22003d.f21734a.zzax().currentTimeMillis());
            }
        } else {
            this.f22003d.f21734a.zzm().f21603o.zzb(this.f22003d.f21734a.zzax().currentTimeMillis());
        }
        long j5 = j4 - this.f22000a;
        if (!z3 && j5 < 1000) {
            this.f22003d.f21734a.zzaA().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j5));
            return false;
        }
        if (!z4) {
            j5 = j4 - this.f22001b;
            this.f22001b = j4;
        }
        this.f22003d.f21734a.zzaA().zzj().zzb("Recording user engagement, ms", Long.valueOf(j5));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j5);
        zzlp.zzK(this.f22003d.f21734a.zzs().zzj(!this.f22003d.f21734a.zzf().zzu()), bundle, true);
        if (!z4) {
            this.f22003d.f21734a.zzq().e(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
        }
        this.f22000a = j4;
        this.f22002c.b();
        this.f22002c.d(3600000L);
        return true;
    }
}
