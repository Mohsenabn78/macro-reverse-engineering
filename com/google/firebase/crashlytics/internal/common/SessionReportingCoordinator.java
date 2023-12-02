package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.messaging.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class SessionReportingCoordinator implements CrashlyticsLifecycleEvents {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReportDataCapture f29538a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsReportPersistence f29539b;

    /* renamed from: c  reason: collision with root package name */
    private final DataTransportCrashlyticsReportSender f29540c;

    /* renamed from: d  reason: collision with root package name */
    private final LogFileManager f29541d;

    /* renamed from: e  reason: collision with root package name */
    private final UserMetadata f29542e;

    /* renamed from: f  reason: collision with root package name */
    private final IdManager f29543f;

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata, IdManager idManager) {
        this.f29538a = crashlyticsReportDataCapture;
        this.f29539b = crashlyticsReportPersistence;
        this.f29540c = dataTransportCrashlyticsReportSender;
        this.f29541d = logFileManager;
        this.f29542e = userMetadata;
        this.f29543f = idManager;
    }

    private CrashlyticsReport.Session.Event c(CrashlyticsReport.Session.Event event) {
        return d(event, this.f29541d, this.f29542e);
    }

    @RequiresApi(api = 19)
    @VisibleForTesting
    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
        }
    }

    public static SessionReportingCoordinator create(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy, settingsProvider), new CrashlyticsReportPersistence(fileStore, settingsProvider, crashlyticsAppQualitySessionsSubscriber), DataTransportCrashlyticsReportSender.create(context, settingsProvider, onDemandCounter), logFileManager, userMetadata, idManager);
    }

    private CrashlyticsReport.Session.Event d(CrashlyticsReport.Session.Event event, LogFileManager logFileManager, UserMetadata userMetadata) {
        CrashlyticsReport.Session.Event.Builder builder = event.toBuilder();
        String logString = logFileManager.getLogString();
        if (logString != null) {
            builder.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().v("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> h4 = h(userMetadata.getCustomKeys());
        List<CrashlyticsReport.CustomAttribute> h5 = h(userMetadata.getInternalKeys());
        if (!h4.isEmpty() || !h5.isEmpty()) {
            builder.setApp(event.getApp().toBuilder().setCustomAttributes(ImmutableList.from(h4)).setInternalKeys(ImmutableList.from(h5)).build());
        }
        return builder.build();
    }

    @RequiresApi(api = 30)
    private static CrashlyticsReport.ApplicationExitInfo e(ApplicationExitInfo applicationExitInfo) {
        String applicationExitInfo2;
        int importance;
        String processName;
        int reason;
        long timestamp;
        int pid;
        long pss;
        long rss;
        InputStream traceInputStream;
        String str = null;
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                str = convertInputStreamToString(traceInputStream);
            }
        } catch (IOException e4) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not get input trace in application exit info: ");
            applicationExitInfo2 = applicationExitInfo.toString();
            sb.append(applicationExitInfo2);
            sb.append(" Error: ");
            sb.append(e4);
            logger.w(sb.toString());
        }
        CrashlyticsReport.ApplicationExitInfo.Builder builder = CrashlyticsReport.ApplicationExitInfo.builder();
        importance = applicationExitInfo.getImportance();
        CrashlyticsReport.ApplicationExitInfo.Builder importance2 = builder.setImportance(importance);
        processName = applicationExitInfo.getProcessName();
        CrashlyticsReport.ApplicationExitInfo.Builder processName2 = importance2.setProcessName(processName);
        reason = applicationExitInfo.getReason();
        CrashlyticsReport.ApplicationExitInfo.Builder reasonCode = processName2.setReasonCode(reason);
        timestamp = applicationExitInfo.getTimestamp();
        CrashlyticsReport.ApplicationExitInfo.Builder timestamp2 = reasonCode.setTimestamp(timestamp);
        pid = applicationExitInfo.getPid();
        CrashlyticsReport.ApplicationExitInfo.Builder pid2 = timestamp2.setPid(pid);
        pss = applicationExitInfo.getPss();
        CrashlyticsReport.ApplicationExitInfo.Builder pss2 = pid2.setPss(pss);
        rss = applicationExitInfo.getRss();
        return pss2.setRss(rss).setTraceFile(str).build();
    }

    private CrashlyticsReportWithSessionId f(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        if (crashlyticsReportWithSessionId.getReport().getFirebaseInstallationId() == null) {
            return CrashlyticsReportWithSessionId.create(crashlyticsReportWithSessionId.getReport().withFirebaseInstallationId(this.f29543f.fetchTrueFid()), crashlyticsReportWithSessionId.getSessionId(), crashlyticsReportWithSessionId.getReportFile());
        }
        return crashlyticsReportWithSessionId;
    }

    @Nullable
    @RequiresApi(api = 30)
    private ApplicationExitInfo g(String str, List<ApplicationExitInfo> list) {
        long timestamp;
        int reason;
        long startTimestampMillis = this.f29539b.getStartTimestampMillis(str);
        for (ApplicationExitInfo applicationExitInfo : list) {
            timestamp = applicationExitInfo.getTimestamp();
            if (timestamp >= startTimestampMillis) {
                reason = applicationExitInfo.getReason();
                if (reason == 6) {
                    return applicationExitInfo;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @NonNull
    private static List<CrashlyticsReport.CustomAttribute> h(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i4;
                i4 = SessionReportingCoordinator.i((CrashlyticsReport.CustomAttribute) obj, (CrashlyticsReport.CustomAttribute) obj2);
                return i4;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(CrashlyticsReport.CustomAttribute customAttribute, CrashlyticsReport.CustomAttribute customAttribute2) {
        return customAttribute.getKey().compareTo(customAttribute2.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(@NonNull Task<CrashlyticsReportWithSessionId> task) {
        if (task.isSuccessful()) {
            CrashlyticsReportWithSessionId result = task.getResult();
            Logger logger = Logger.getLogger();
            logger.d("Crashlytics report successfully enqueued to DataTransport: " + result.getSessionId());
            File reportFile = result.getReportFile();
            if (reportFile.delete()) {
                Logger logger2 = Logger.getLogger();
                logger2.d("Deleted report file: " + reportFile.getPath());
                return true;
            }
            Logger logger3 = Logger.getLogger();
            logger3.w("Crashlytics could not delete report file: " + reportFile.getPath());
            return true;
        }
        Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", task.getException());
        return false;
    }

    private void k(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j4, boolean z3) {
        this.f29539b.persistEvent(c(this.f29538a.captureEventData(th, thread, str2, j4, 4, 8, z3)), str, str2.equals(AppMeasurement.CRASH_ORIGIN));
    }

    public void finalizeSessionWithNativeEvent(@NonNull String str, @NonNull List<NativeSessionFile> list, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        Logger.getLogger().d("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile nativeSessionFile : list) {
            CrashlyticsReport.FilesPayload.File c4 = nativeSessionFile.c();
            if (c4 != null) {
                arrayList.add(c4);
            }
        }
        this.f29539b.finalizeSessionWithNativeEvent(str, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(arrayList)).build(), applicationExitInfo);
    }

    public void finalizeSessions(long j4, @Nullable String str) {
        this.f29539b.finalizeReports(str, j4);
    }

    public boolean hasReportsToSend() {
        return this.f29539b.hasFinalizedReports();
    }

    public SortedSet<String> listSortedOpenSessionIds() {
        return this.f29539b.getOpenSessionIds();
    }

    public void onBeginSession(@NonNull String str, long j4) {
        this.f29539b.persistReport(this.f29538a.captureReportData(str, j4));
    }

    public void onCustomKey(String str, String str2) {
        this.f29542e.setCustomKey(str, str2);
    }

    public void onLog(long j4, String str) {
        this.f29541d.writeToLog(j4, str);
    }

    public void onUserId(String str) {
        this.f29542e.setUserId(str);
    }

    public void persistFatalEvent(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j4) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting fatal event for session " + str);
        k(th, thread, str, AppMeasurement.CRASH_ORIGIN, j4, true);
    }

    public void persistNonFatalEvent(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j4) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting non-fatal event for session " + str);
        k(th, thread, str, Constants.IPC_BUNDLE_KEY_SEND_ERROR, j4, false);
    }

    @RequiresApi(api = 30)
    public void persistRelevantAppExitInfoEvent(String str, List<ApplicationExitInfo> list, LogFileManager logFileManager, UserMetadata userMetadata) {
        ApplicationExitInfo g4 = g(str, list);
        if (g4 == null) {
            Logger logger = Logger.getLogger();
            logger.v("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.Session.Event captureAnrEventData = this.f29538a.captureAnrEventData(e(g4));
        Logger logger2 = Logger.getLogger();
        logger2.d("Persisting anr for session " + str);
        this.f29539b.persistEvent(d(captureAnrEventData, logFileManager, userMetadata), str, true);
    }

    public void removeAllReports() {
        this.f29539b.deleteAllReports();
    }

    public Task<Void> sendReports(@NonNull Executor executor) {
        return sendReports(executor, null);
    }

    public Task<Void> sendReports(@NonNull Executor executor, @Nullable String str) {
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.f29539b.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : loadFinalizedReports) {
            if (str == null || str.equals(crashlyticsReportWithSessionId.getSessionId())) {
                arrayList.add(this.f29540c.enqueueReport(f(crashlyticsReportWithSessionId), str != null).continueWith(executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.k
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        boolean j4;
                        j4 = SessionReportingCoordinator.this.j(task);
                        return Boolean.valueOf(j4);
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
