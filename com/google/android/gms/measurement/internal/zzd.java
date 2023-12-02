package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzd extends zze {

    /* renamed from: b  reason: collision with root package name */
    private final Map f21490b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f21491c;

    /* renamed from: d  reason: collision with root package name */
    private long f21492d;

    public zzd(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21491c = new ArrayMap();
        this.f21490b = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(zzd zzdVar, String str, long j4) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzdVar.f21491c.isEmpty()) {
            zzdVar.f21492d = j4;
        }
        Integer num = (Integer) zzdVar.f21491c.get(str);
        if (num != null) {
            zzdVar.f21491c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzdVar.f21491c.size() >= 100) {
            zzdVar.f21734a.zzaA().zzk().zza("Too many ads visible");
        } else {
            zzdVar.f21491c.put(str, 1);
            zzdVar.f21490b.put(str, Long.valueOf(j4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(zzd zzdVar, String str, long j4) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) zzdVar.f21491c.get(str);
        if (num != null) {
            zzir zzj = zzdVar.f21734a.zzs().zzj(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzdVar.f21491c.remove(str);
                Long l4 = (Long) zzdVar.f21490b.get(str);
                if (l4 == null) {
                    zzdVar.f21734a.zzaA().zzd().zza("First ad unit exposure time was never set");
                } else {
                    zzdVar.f21490b.remove(str);
                    zzdVar.e(str, j4 - l4.longValue(), zzj);
                }
                if (zzdVar.f21491c.isEmpty()) {
                    long j5 = zzdVar.f21492d;
                    if (j5 == 0) {
                        zzdVar.f21734a.zzaA().zzd().zza("First ad exposure time was never set");
                        return;
                    }
                    zzdVar.d(j4 - j5, zzj);
                    zzdVar.f21492d = 0L;
                    return;
                }
                return;
            }
            zzdVar.f21491c.put(str, Integer.valueOf(intValue));
            return;
        }
        zzdVar.f21734a.zzaA().zzd().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @WorkerThread
    private final void d(long j4, zzir zzirVar) {
        if (zzirVar == null) {
            this.f21734a.zzaA().zzj().zza("Not logging ad exposure. No active activity");
        } else if (j4 < 1000) {
            this.f21734a.zzaA().zzj().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j4));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j4);
            zzlp.zzK(zzirVar, bundle, true);
            this.f21734a.zzq().e("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void e(String str, long j4, zzir zzirVar) {
        if (zzirVar == null) {
            this.f21734a.zzaA().zzj().zza("Not logging ad unit exposure. No active activity");
        } else if (j4 < 1000) {
            this.f21734a.zzaA().zzj().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j4));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j4);
            zzlp.zzK(zzirVar, bundle, true);
            this.f21734a.zzq().e("am", "_xu", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void f(long j4) {
        for (String str : this.f21490b.keySet()) {
            this.f21490b.put(str, Long.valueOf(j4));
        }
        if (!this.f21490b.isEmpty()) {
            this.f21492d = j4;
        }
    }

    public final void zzd(String str, long j4) {
        if (str != null && str.length() != 0) {
            this.f21734a.zzaB().zzp(new zza(this, str, j4));
        } else {
            this.f21734a.zzaA().zzd().zza("Ad unit id must be a non-empty string");
        }
    }

    public final void zze(String str, long j4) {
        if (str != null && str.length() != 0) {
            this.f21734a.zzaB().zzp(new zzb(this, str, j4));
        } else {
            this.f21734a.zzaA().zzd().zza("Ad unit id must be a non-empty string");
        }
    }

    @WorkerThread
    public final void zzf(long j4) {
        zzir zzj = this.f21734a.zzs().zzj(false);
        for (String str : this.f21490b.keySet()) {
            e(str, j4 - ((Long) this.f21490b.get(str)).longValue(), zzj);
        }
        if (!this.f21490b.isEmpty()) {
            d(j4 - this.f21492d, zzj);
        }
        f(j4);
    }
}
