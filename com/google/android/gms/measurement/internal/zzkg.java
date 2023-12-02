package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkg {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21989a;

    public zzkg(Context context) {
        Preconditions.checkNotNull(context);
        this.f21989a = context;
    }

    private final zzet c() {
        return zzgd.zzp(this.f21989a, null, null).zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i4, zzet zzetVar, Intent intent) {
        if (((zzkf) this.f21989a).zzc(i4)) {
            zzetVar.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i4));
            c().zzj().zza("Completed wakeful intent.");
            ((zzkf) this.f21989a).zza(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzet zzetVar, JobParameters jobParameters) {
        zzetVar.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzkf) this.f21989a).zzb(jobParameters, false);
    }

    @MainThread
    public final int zza(final Intent intent, int i4, final int i5) {
        zzgd zzp = zzgd.zzp(this.f21989a, null, null);
        final zzet zzaA = zzp.zzaA();
        if (intent == null) {
            zzaA.zzk().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzp.zzay();
        zzaA.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i5), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzh(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkd
                @Override // java.lang.Runnable
                public final void run() {
                    zzkg.this.a(i5, zzaA, intent);
                }
            });
        }
        return 2;
    }

    @MainThread
    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            c().zzd().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgv(zzlh.zzt(this.f21989a), null);
        }
        c().zzk().zzb("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final void zze() {
        zzgd zzp = zzgd.zzp(this.f21989a, null, null);
        zzet zzaA = zzp.zzaA();
        zzp.zzay();
        zzaA.zzj().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzf() {
        zzgd zzp = zzgd.zzp(this.f21989a, null, null);
        zzet zzaA = zzp.zzaA();
        zzp.zzay();
        zzaA.zzj().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void zzg(Intent intent) {
        if (intent == null) {
            c().zzd().zza("onRebind called with null intent");
            return;
        }
        c().zzj().zzb("onRebind called. action", intent.getAction());
    }

    public final void zzh(Runnable runnable) {
        zzlh zzt = zzlh.zzt(this.f21989a);
        zzt.zzaB().zzp(new zzke(this, zzt, runnable));
    }

    @TargetApi(24)
    @MainThread
    public final boolean zzi(final JobParameters jobParameters) {
        zzgd zzp = zzgd.zzp(this.f21989a, null, null);
        final zzet zzaA = zzp.zzaA();
        String string = jobParameters.getExtras().getString("action");
        zzp.zzay();
        zzaA.zzj().zzb("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzh(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkc
                @Override // java.lang.Runnable
                public final void run() {
                    zzkg.this.b(zzaA, jobParameters);
                }
            });
            return true;
        }
        return true;
    }

    @MainThread
    public final boolean zzj(Intent intent) {
        if (intent == null) {
            c().zzd().zza("onUnbind called with null intent");
            return true;
        }
        c().zzj().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
