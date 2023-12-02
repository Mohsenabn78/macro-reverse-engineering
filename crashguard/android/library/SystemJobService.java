package crashguard.android.library;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
@SuppressLint({"SpecifyJobSchedulerIdRange"})
/* loaded from: classes6.dex */
public class SystemJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        boolean z3;
        try {
            Context applicationContext = getApplicationContext();
            PersistableBundle extras = jobParameters.getExtras();
            Bundle bundle = new Bundle();
            String str = c0.f38662n;
            bundle.putString(str, extras.getString(str, null));
            String str2 = c0.f38661m;
            if (Build.VERSION.SDK_INT > 21) {
                z3 = extras.getBoolean(c0.f38661m, false);
            } else if (extras.getInt(c0.f38661m, 0) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            bundle.putBoolean(str2, z3);
            g6.b(applicationContext).e(new f1(applicationContext, bundle, new z0(this, jobParameters)));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
