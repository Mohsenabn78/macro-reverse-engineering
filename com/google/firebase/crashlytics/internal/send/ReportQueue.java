package com.google.firebase.crashlytics.internal.send;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.os.SystemClock;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.ForcedSender;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ReportQueue {

    /* renamed from: a  reason: collision with root package name */
    private final double f29985a;

    /* renamed from: b  reason: collision with root package name */
    private final double f29986b;

    /* renamed from: c  reason: collision with root package name */
    private final long f29987c;

    /* renamed from: d  reason: collision with root package name */
    private final long f29988d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29989e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue<Runnable> f29990f;

    /* renamed from: g  reason: collision with root package name */
    private final ThreadPoolExecutor f29991g;

    /* renamed from: h  reason: collision with root package name */
    private final Transport<CrashlyticsReport> f29992h;

    /* renamed from: i  reason: collision with root package name */
    private final OnDemandCounter f29993i;

    /* renamed from: j  reason: collision with root package name */
    private int f29994j;

    /* renamed from: k  reason: collision with root package name */
    private long f29995k;

    /* loaded from: classes5.dex */
    private final class ReportRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CrashlyticsReportWithSessionId f29996a;

        /* renamed from: b  reason: collision with root package name */
        private final TaskCompletionSource<CrashlyticsReportWithSessionId> f29997b;

        @Override // java.lang.Runnable
        public void run() {
            ReportQueue.this.p(this.f29996a, this.f29997b);
            ReportQueue.this.f29993i.resetDroppedOnDemandExceptions();
            double g4 = ReportQueue.this.g();
            Logger logger = Logger.getLogger();
            logger.d("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(g4 / 1000.0d)) + " s for report: " + this.f29996a.getSessionId());
            ReportQueue.q(g4);
        }

        private ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
            this.f29996a = crashlyticsReportWithSessionId;
            this.f29997b = taskCompletionSource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReportQueue(Transport<CrashlyticsReport> transport, Settings settings, OnDemandCounter onDemandCounter) {
        this(settings.onDemandUploadRatePerMinute, settings.onDemandBackoffBase, settings.onDemandBackoffStepDurationSeconds * 1000, transport, onDemandCounter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.f29985a) * Math.pow(this.f29986b, h()));
    }

    private int h() {
        int max;
        if (this.f29995k == 0) {
            this.f29995k = o();
        }
        int o4 = (int) ((o() - this.f29995k) / this.f29987c);
        if (l()) {
            max = Math.min(100, this.f29994j + o4);
        } else {
            max = Math.max(0, this.f29994j - o4);
        }
        if (this.f29994j != max) {
            this.f29994j = max;
            this.f29995k = o();
        }
        return max;
    }

    private boolean k() {
        if (this.f29990f.size() < this.f29989e) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (this.f29990f.size() == this.f29989e) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            ForcedSender.sendBlocking(this.f29992h, Priority.HIGHEST);
        } catch (SQLException unused) {
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z3, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z3) {
            j();
        }
        taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
    }

    private long o() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        final boolean z3;
        Logger logger = Logger.getLogger();
        logger.d("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.getSessionId());
        if (SystemClock.elapsedRealtime() - this.f29988d < 2000) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f29992h.schedule(Event.ofUrgent(crashlyticsReportWithSessionId.getReport()), new TransportScheduleCallback() { // from class: com.google.firebase.crashlytics.internal.send.b
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void onSchedule(Exception exc) {
                ReportQueue.this.n(taskCompletionSource, z3, crashlyticsReportWithSessionId, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(double d4) {
        try {
            Thread.sleep((long) d4);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskCompletionSource<CrashlyticsReportWithSessionId> i(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z3) {
        synchronized (this.f29990f) {
            TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource = new TaskCompletionSource<>();
            if (z3) {
                this.f29993i.incrementRecordedOnDemandExceptions();
                if (k()) {
                    Logger logger = Logger.getLogger();
                    logger.d("Enqueueing report: " + crashlyticsReportWithSessionId.getSessionId());
                    Logger logger2 = Logger.getLogger();
                    logger2.d("Queue size: " + this.f29990f.size());
                    this.f29991g.execute(new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                    Logger logger3 = Logger.getLogger();
                    logger3.d("Closing task for report: " + crashlyticsReportWithSessionId.getSessionId());
                    taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                    return taskCompletionSource;
                }
                h();
                Logger logger4 = Logger.getLogger();
                logger4.d("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.getSessionId());
                this.f29993i.incrementDroppedOnDemandExceptions();
                taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                return taskCompletionSource;
            }
            p(crashlyticsReportWithSessionId, taskCompletionSource);
            return taskCompletionSource;
        }
    }

    @SuppressLint({"DiscouragedApi", "ThreadPoolCreation"})
    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.c
            @Override // java.lang.Runnable
            public final void run() {
                ReportQueue.this.m(countDownLatch);
            }
        }).start();
        Utils.awaitUninterruptibly(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    @SuppressLint({"ThreadPoolCreation"})
    ReportQueue(double d4, double d5, long j4, Transport<CrashlyticsReport> transport, OnDemandCounter onDemandCounter) {
        this.f29985a = d4;
        this.f29986b = d5;
        this.f29987c = j4;
        this.f29992h = transport;
        this.f29993i = onDemandCounter;
        this.f29988d = SystemClock.elapsedRealtime();
        int i4 = (int) d4;
        this.f29989e = i4;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i4);
        this.f29990f = arrayBlockingQueue;
        this.f29991g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f29994j = 0;
        this.f29995k = 0L;
    }
}
