package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class AlarmManagerScheduler implements WorkScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18791a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f18792b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f18793c;

    /* renamed from: d  reason: collision with root package name */
    private final SchedulerConfig f18794d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f18795e;

    public AlarmManagerScheduler(Context context, EventStore eventStore, Clock clock, SchedulerConfig schedulerConfig) {
        this(context, eventStore, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), clock, schedulerConfig);
    }

    @VisibleForTesting
    boolean a(Intent intent) {
        int i4;
        if (Build.VERSION.SDK_INT >= 23) {
            i4 = 603979776;
        } else {
            i4 = 536870912;
        }
        if (PendingIntent.getBroadcast(this.f18791a, 0, intent, i4) == null) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i4) {
        schedule(transportContext, i4, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void schedule(TransportContext transportContext, int i4, boolean z3) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", transportContext.getBackendName());
        builder.appendQueryParameter(LogFactory.PRIORITY_KEY, String.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        if (transportContext.getExtras() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        Intent intent = new Intent(this.f18791a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i4);
        if (!z3 && a(intent)) {
            Logging.d("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long nextCallTime = this.f18792b.getNextCallTime(transportContext);
        long scheduleDelay = this.f18794d.getScheduleDelay(transportContext.getPriority(), nextCallTime, i4);
        Logging.d("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(scheduleDelay), Long.valueOf(nextCallTime), Integer.valueOf(i4));
        this.f18793c.set(3, this.f18795e.getTime() + scheduleDelay, PendingIntent.getBroadcast(this.f18791a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
    }

    @VisibleForTesting
    AlarmManagerScheduler(Context context, EventStore eventStore, AlarmManager alarmManager, Clock clock, SchedulerConfig schedulerConfig) {
        this.f18791a = context;
        this.f18792b = eventStore;
        this.f18793c = alarmManager;
        this.f18795e = clock;
        this.f18794d = schedulerConfig;
    }
}
