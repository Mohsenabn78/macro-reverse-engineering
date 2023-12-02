package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzqu;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzko {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzkp f22004a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzko(zzkp zzkpVar) {
        this.f22004a = zzkpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a() {
        this.f22004a.zzg();
        if (this.f22004a.f21734a.zzm().k(this.f22004a.f21734a.zzax().currentTimeMillis())) {
            this.f22004a.f21734a.zzm().f21600l.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f22004a.f21734a.zzaA().zzj().zza("Detected application was in foreground");
                c(this.f22004a.f21734a.zzax().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(long j4, boolean z3) {
        this.f22004a.zzg();
        this.f22004a.j();
        if (this.f22004a.f21734a.zzm().k(j4)) {
            this.f22004a.f21734a.zzm().f21600l.zza(true);
            zzqu.zzc();
            if (this.f22004a.f21734a.zzf().zzs(null, zzeg.zzan)) {
                this.f22004a.f21734a.zzh().i();
            }
        }
        this.f22004a.f21734a.zzm().f21603o.zzb(j4);
        if (this.f22004a.f21734a.zzm().f21600l.zzb()) {
            c(j4, z3);
        }
    }

    @VisibleForTesting
    @WorkerThread
    final void c(long j4, boolean z3) {
        this.f22004a.zzg();
        if (!this.f22004a.f21734a.zzJ()) {
            return;
        }
        this.f22004a.f21734a.zzm().f21603o.zzb(j4);
        this.f22004a.f21734a.zzaA().zzj().zzb("Session started, time", Long.valueOf(this.f22004a.f21734a.zzax().elapsedRealtime()));
        Long valueOf = Long.valueOf(j4 / 1000);
        this.f22004a.f21734a.zzq().m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j4);
        this.f22004a.f21734a.zzm().f21604p.zzb(valueOf.longValue());
        this.f22004a.f21734a.zzm().f21600l.zza(false);
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", valueOf.longValue());
        if (this.f22004a.f21734a.zzf().zzs(null, zzeg.zzab) && z3) {
            bundle.putLong("_aib", 1L);
        }
        this.f22004a.f21734a.zzq().f(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j4, bundle);
        zzos.zzc();
        if (this.f22004a.f21734a.zzf().zzs(null, zzeg.zzae)) {
            String zza = this.f22004a.f21734a.zzm().f21609u.zza();
            if (!TextUtils.isEmpty(zza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                this.f22004a.f21734a.zzq().f(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j4, bundle2);
            }
        }
    }
}
