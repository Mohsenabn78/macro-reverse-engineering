package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkg;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
@TargetApi(24)
/* loaded from: classes4.dex */
public final class AppMeasurementJobService extends JobService implements zzkf {

    /* renamed from: a  reason: collision with root package name */
    private zzkg f21418a;

    private final zzkg a() {
        if (this.f21418a == null) {
            this.f21418a = new zzkg(this);
        }
        return this.f21418a;
    }

    @Override // android.app.Service
    @MainThread
    public void onCreate() {
        super.onCreate();
        a().zze();
    }

    @Override // android.app.Service
    @MainThread
    public void onDestroy() {
        a().zzf();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public void onRebind(@NonNull Intent intent) {
        a().zzg(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters jobParameters) {
        a().zzi(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    @MainThread
    public boolean onUnbind(@NonNull Intent intent) {
        a().zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzkf
    @TargetApi(24)
    public final void zzb(@NonNull JobParameters jobParameters, boolean z3) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzkf
    public final boolean zzc(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzkf
    public final void zza(@NonNull Intent intent) {
    }
}
