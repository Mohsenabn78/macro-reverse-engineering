package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import org.apache.commons.logging.LogFactory;

@RequiresApi(api = 21)
/* loaded from: classes.dex */
public class JobInfoScheduler implements WorkScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18804a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f18805b;

    /* renamed from: c  reason: collision with root package name */
    private final SchedulerConfig f18806c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f18804a = context;
        this.f18805b = eventStore;
        this.f18806c = schedulerConfig;
    }

    private boolean b(JobScheduler jobScheduler, int i4, int i5) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i6 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i4) {
                if (i6 < i5) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    int a(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f18804a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.getBackendName().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.toInt(transportContext.getPriority())).array());
        if (transportContext.getExtras() != null) {
            adler32.update(transportContext.getExtras());
        }
        return (int) adler32.getValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i4) {
        schedule(transportContext, i4, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i4, boolean z3) {
        ComponentName componentName = new ComponentName(this.f18804a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f18804a.getSystemService("jobscheduler");
        int a4 = a(transportContext);
        if (!z3 && b(jobScheduler, a4, i4)) {
            Logging.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long nextCallTime = this.f18805b.getNextCallTime(transportContext);
        JobInfo.Builder configureJob = this.f18806c.configureJob(new JobInfo.Builder(a4, componentName), transportContext.getPriority(), nextCallTime, i4);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i4);
        persistableBundle.putString("backendName", transportContext.getBackendName());
        persistableBundle.putInt(LogFactory.PRIORITY_KEY, PriorityMapping.toInt(transportContext.getPriority()));
        if (transportContext.getExtras() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        configureJob.setExtras(persistableBundle);
        Logging.d("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(a4), Long.valueOf(this.f18806c.getScheduleDelay(transportContext.getPriority(), nextCallTime, i4)), Long.valueOf(nextCallTime), Integer.valueOf(i4));
        jobScheduler.schedule(configureJob.build());
    }
}
