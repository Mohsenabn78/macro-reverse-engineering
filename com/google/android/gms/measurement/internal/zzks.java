package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzks extends zzku {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f22013d;

    /* renamed from: e  reason: collision with root package name */
    private zzan f22014e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f22015f;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzks(zzlh zzlhVar) {
        super(zzlhVar);
        this.f22013d = (AlarmManager) this.f21734a.zzaw().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    private final int d() {
        if (this.f22015f == null) {
            this.f22015f = Integer.valueOf("measurement".concat(String.valueOf(this.f21734a.zzaw().getPackageName())).hashCode());
        }
        return this.f22015f.intValue();
    }

    private final PendingIntent e() {
        Context zzaw = this.f21734a.zzaw();
        return PendingIntent.getBroadcast(zzaw, 0, new Intent().setClassName(zzaw, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzbs.zza);
    }

    private final zzan f() {
        if (this.f22014e == null) {
            this.f22014e = new zzkr(this, this.f22016b.O());
        }
        return this.f22014e;
    }

    @TargetApi(24)
    private final void zzj() {
        JobScheduler jobScheduler = (JobScheduler) this.f21734a.zzaw().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(d());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        AlarmManager alarmManager = this.f22013d;
        if (alarmManager != null) {
            alarmManager.cancel(e());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            zzj();
            return false;
        }
        return false;
    }

    public final void zza() {
        a();
        this.f21734a.zzaA().zzj().zza("Unscheduling upload");
        AlarmManager alarmManager = this.f22013d;
        if (alarmManager != null) {
            alarmManager.cancel(e());
        }
        f().b();
        if (Build.VERSION.SDK_INT >= 24) {
            zzj();
        }
    }

    public final void zzd(long j4) {
        a();
        this.f21734a.zzay();
        Context zzaw = this.f21734a.zzaw();
        if (!zzlp.D(zzaw)) {
            this.f21734a.zzaA().zzc().zza("Receiver not registered/enabled");
        }
        if (!zzlp.E(zzaw, false)) {
            this.f21734a.zzaA().zzc().zza("Service not registered/enabled");
        }
        zza();
        this.f21734a.zzaA().zzj().zzb("Scheduling upload, millis", Long.valueOf(j4));
        long elapsedRealtime = this.f21734a.zzax().elapsedRealtime() + j4;
        this.f21734a.zzf();
        if (j4 < Math.max(0L, ((Long) zzeg.zzx.zza(null)).longValue()) && !f().e()) {
            f().d(j4);
        }
        this.f21734a.zzay();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzaw2 = this.f21734a.zzaw();
            ComponentName componentName = new ComponentName(zzaw2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int d4 = d();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            com.google.android.gms.internal.measurement.zzbt.zza(zzaw2, new JobInfo.Builder(d4, componentName).setMinimumLatency(j4).setOverrideDeadline(j4 + j4).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.f22013d;
        if (alarmManager != null) {
            this.f21734a.zzf();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzeg.zzs.zza(null)).longValue(), j4), e());
        }
    }
}
