package crashguard.android.library;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(api = 21)
/* loaded from: classes6.dex */
public final class k1 extends k {

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f38888c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(Context context) {
        super(context);
        this.f38888c = (JobScheduler) context.getSystemService("jobscheduler");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002b -> B:12:0x002c). Please submit an issue!!! */
    @Override // crashguard.android.library.k
    protected final boolean c(int i4) {
        JobInfo jobInfo;
        if (Build.VERSION.SDK_INT > 23) {
            jobInfo = this.f38888c.getPendingJob(i4);
        } else {
            for (JobInfo jobInfo2 : this.f38888c.getAllPendingJobs()) {
                if (jobInfo2.getId() == i4) {
                    jobInfo = jobInfo2;
                    break;
                }
            }
            jobInfo = null;
        }
        if (jobInfo != null) {
            try {
                this.f38888c.cancel(i4);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    @Override // crashguard.android.library.k
    protected final boolean d(int i4, Bundle bundle) {
        try {
            JobInfo.Builder overrideDeadline = new JobInfo.Builder(i4, new ComponentName(this.f38886a.get(), SystemJobService.class)).setMinimumLatency(1L).setOverrideDeadline(1L);
            overrideDeadline.setExtras(k.a(bundle));
            if (this.f38888c.schedule(overrideDeadline.build()) != 1) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // crashguard.android.library.k
    protected final boolean e(int i4, Bundle bundle, long j4) {
        try {
            JobInfo.Builder overrideDeadline = new JobInfo.Builder(i4, new ComponentName(this.f38886a.get(), SystemJobService.class)).setMinimumLatency(j4).setOverrideDeadline(j4);
            overrideDeadline.setExtras(k.a(bundle));
            if (this.f38888c.schedule(overrideDeadline.build()) != 1) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // crashguard.android.library.k
    protected final boolean f(int i4, Bundle bundle, long j4, long j5) {
        boolean z3;
        try {
            JobInfo.Builder periodic = new JobInfo.Builder(i4, new ComponentName(this.f38886a.get(), SystemJobService.class)).setPeriodic(j5);
            String str = c0.f38661m;
            if (j4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            bundle.putBoolean(str, z3);
            periodic.setExtras(k.a(bundle));
            if (this.f38888c.schedule(periodic.build()) != 1) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // crashguard.android.library.k
    final boolean h(String str, c0 c0Var) {
        boolean h4 = super.h(str, c0Var);
        if (h4 && Build.VERSION.SDK_INT == 23) {
            try {
                c0Var.i(this.f38887b.a());
                c0Var.f(null);
                c0Var.c(c0Var.a() + 1);
                t4.f(this.f38886a.get()).o().k(c0Var);
                g(c0Var);
            } catch (Throwable unused) {
            }
        }
        return h4;
    }

    @Override // crashguard.android.library.k
    final boolean i(c0 c0Var) {
        boolean i4 = super.i(c0Var);
        if (i4 && Build.VERSION.SDK_INT == 23) {
            try {
                c0Var.i(this.f38887b.a());
                c0Var.f(null);
                c0Var.c(c0Var.a() + 1);
                t4.f(this.f38886a.get()).o().k(c0Var);
                g(c0Var);
            } catch (Throwable unused) {
            }
        }
        return i4;
    }
}
