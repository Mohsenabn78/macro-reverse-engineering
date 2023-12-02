package com.google.firebase.crashlytics.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class CrashlyticsReportPersistence {

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f29964e = Charset.forName("UTF-8");

    /* renamed from: f  reason: collision with root package name */
    private static final int f29965f = 15;

    /* renamed from: g  reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f29966g = new CrashlyticsReportJsonTransform();

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<? super File> f29967h = new Comparator() { // from class: e1.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int o4;
            o4 = CrashlyticsReportPersistence.o((File) obj, (File) obj2);
            return o4;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final FilenameFilter f29968i = new FilenameFilter() { // from class: e1.d
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean p4;
            p4 = CrashlyticsReportPersistence.p(file, str);
            return p4;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f29969a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final FileStore f29970b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingsProvider f29971c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f29972d;

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsProvider settingsProvider, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.f29970b = fileStore;
        this.f29971c = settingsProvider;
        this.f29972d = crashlyticsAppQualitySessionsSubscriber;
    }

    private SortedSet<String> e(@Nullable String str) {
        this.f29970b.cleanupPreviousFileSystems();
        SortedSet<String> openSessionIds = getOpenSessionIds();
        if (str != null) {
            openSessionIds.remove(str);
        }
        if (openSessionIds.size() <= 8) {
            return openSessionIds;
        }
        while (openSessionIds.size() > 8) {
            String last = openSessionIds.last();
            Logger logger = Logger.getLogger();
            logger.d("Removing session over cap: " + last);
            this.f29970b.deleteSessionFiles(last);
            openSessionIds.remove(last);
        }
        return openSessionIds;
    }

    private static int f(List<File> list, int i4) {
        int size = list.size();
        for (File file : list) {
            if (size <= i4) {
                return size;
            }
            FileStore.e(file);
            size--;
        }
        return size;
    }

    private void g() {
        int i4 = this.f29971c.getSettingsSync().sessionData.maxCompleteSessionsCount;
        List<File> k4 = k();
        int size = k4.size();
        if (size <= i4) {
            return;
        }
        for (File file : k4.subList(i4, size)) {
            file.delete();
        }
    }

    private static long h(long j4) {
        return j4 * 1000;
    }

    private void i(List<File> list) {
        for (File file : list) {
            file.delete();
        }
    }

    @NonNull
    private static String j(int i4, boolean z3) {
        String str;
        String format = String.format(Locale.US, "%010d", Integer.valueOf(i4));
        if (z3) {
            str = "_";
        } else {
            str = "";
        }
        return NotificationCompat.CATEGORY_EVENT + format + str;
    }

    private List<File> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f29970b.getPriorityReports());
        arrayList.addAll(this.f29970b.getNativeReports());
        Comparator<? super File> comparator = f29967h;
        Collections.sort(arrayList, comparator);
        List<File> reports = this.f29970b.getReports();
        Collections.sort(reports, comparator);
        arrayList.addAll(reports);
        return arrayList;
    }

    @NonNull
    private static String l(@NonNull String str) {
        return str.substring(0, f29965f);
    }

    private static boolean m(@NonNull String str) {
        if (str.startsWith(NotificationCompat.CATEGORY_EVENT) && str.endsWith("_")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(@NonNull File file, @NonNull String str) {
        if (str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int o(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean p(File file, String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(@NonNull File file, @NonNull File file2) {
        return l(file.getName()).compareTo(l(file2.getName()));
    }

    @NonNull
    private static String r(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f29964e);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private void s(@NonNull File file, @NonNull CrashlyticsReport.FilesPayload filesPayload, @NonNull String str, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f29966g;
            x(this.f29970b.getNativeReport(str), crashlyticsReportJsonTransform.reportToJson(crashlyticsReportJsonTransform.reportFromJson(r(file)).withNdkPayload(filesPayload).withApplicationExitInfo(applicationExitInfo)));
        } catch (IOException e4) {
            Logger logger = Logger.getLogger();
            logger.w("Could not synthesize final native report file for " + file, e4);
        }
    }

    private void t(String str, long j4) {
        boolean z3;
        List<File> sessionFiles = this.f29970b.getSessionFiles(str, f29968i);
        if (sessionFiles.isEmpty()) {
            Logger logger = Logger.getLogger();
            logger.v("Session " + str + " has no events.");
            return;
        }
        Collections.sort(sessionFiles);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z3 = false;
            for (File file : sessionFiles) {
                try {
                    arrayList.add(f29966g.eventFromJson(r(file)));
                } catch (IOException e4) {
                    Logger logger2 = Logger.getLogger();
                    logger2.w("Could not add event to report for " + file, e4);
                }
                if (z3 || m(file.getName())) {
                    z3 = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger logger3 = Logger.getLogger();
            logger3.w("Could not parse event files for session " + str);
            return;
        }
        u(this.f29970b.getSessionFile(str, "report"), arrayList, j4, z3, UserMetadata.readUserId(str, this.f29970b), w(this.f29970b.getSessionFile(str, "app-quality-session-id")));
    }

    private void u(@NonNull File file, @NonNull List<CrashlyticsReport.Session.Event> list, long j4, boolean z3, @Nullable String str, @Nullable String str2) {
        File report;
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f29966g;
            CrashlyticsReport withEvents = crashlyticsReportJsonTransform.reportFromJson(r(file)).withSessionEndFields(j4, z3, str).withAppQualitySessionId(str2).withEvents(ImmutableList.from(list));
            CrashlyticsReport.Session session = withEvents.getSession();
            if (session == null) {
                return;
            }
            Logger logger = Logger.getLogger();
            logger.d("appQualitySessionId: " + str2);
            if (z3) {
                report = this.f29970b.getPriorityReport(session.getIdentifier());
            } else {
                report = this.f29970b.getReport(session.getIdentifier());
            }
            x(report, crashlyticsReportJsonTransform.reportToJson(withEvents));
        } catch (IOException e4) {
            Logger logger2 = Logger.getLogger();
            logger2.w("Could not synthesize final report file for " + file, e4);
        }
    }

    private int v(String str, int i4) {
        List<File> sessionFiles = this.f29970b.getSessionFiles(str, new FilenameFilter() { // from class: e1.a
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                boolean n4;
                n4 = CrashlyticsReportPersistence.n(file, str2);
                return n4;
            }
        });
        Collections.sort(sessionFiles, new Comparator() { // from class: e1.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int q4;
                q4 = CrashlyticsReportPersistence.q((File) obj, (File) obj2);
                return q4;
            }
        });
        return f(sessionFiles, i4);
    }

    @Nullable
    private static String w(@NonNull File file) {
        try {
            return r(file);
        } catch (IOException unused) {
            return null;
        }
    }

    private static void x(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f29964e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void y(File file, String str, long j4) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f29964e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j4));
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void deleteAllReports() {
        i(this.f29970b.getReports());
        i(this.f29970b.getPriorityReports());
        i(this.f29970b.getNativeReports());
    }

    public void finalizeReports(@Nullable String str, long j4) {
        for (String str2 : e(str)) {
            Logger logger = Logger.getLogger();
            logger.v("Finalizing report for session " + str2);
            t(str2, j4);
            this.f29970b.deleteSessionFiles(str2);
        }
        g();
    }

    public void finalizeSessionWithNativeEvent(String str, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        File sessionFile = this.f29970b.getSessionFile(str, "report");
        Logger logger = Logger.getLogger();
        logger.d("Writing native session report for " + str + " to file: " + sessionFile);
        s(sessionFile, filesPayload, str, applicationExitInfo);
    }

    public SortedSet<String> getOpenSessionIds() {
        return new TreeSet(this.f29970b.getAllOpenSessionIds()).descendingSet();
    }

    public long getStartTimestampMillis(String str) {
        return this.f29970b.getSessionFile(str, "start-time").lastModified();
    }

    public boolean hasFinalizedReports() {
        if (this.f29970b.getReports().isEmpty() && this.f29970b.getPriorityReports().isEmpty() && this.f29970b.getNativeReports().isEmpty()) {
            return false;
        }
        return true;
    }

    @NonNull
    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> k4 = k();
        ArrayList arrayList = new ArrayList();
        for (File file : k4) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.create(f29966g.reportFromJson(r(file)), file.getName(), file));
            } catch (IOException e4) {
                Logger logger = Logger.getLogger();
                logger.w("Could not load report file " + file + "; deleting", e4);
                file.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str) {
        persistEvent(event, str, false);
    }

    public void persistReport(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            x(this.f29970b.getSessionFile(identifier, "report"), f29966g.reportToJson(crashlyticsReport));
            y(this.f29970b.getSessionFile(identifier, "start-time"), "", session.getStartedAt());
        } catch (IOException e4) {
            Logger logger = Logger.getLogger();
            logger.d("Could not persist report for session " + identifier, e4);
        }
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str, boolean z3) {
        int i4 = this.f29971c.getSettingsSync().sessionData.maxCustomExceptionEvents;
        try {
            x(this.f29970b.getSessionFile(str, j(this.f29969a.getAndIncrement(), z3)), f29966g.eventToJson(event));
            String appQualitySessionId = this.f29972d.getAppQualitySessionId();
            if (appQualitySessionId == null) {
                Logger logger = Logger.getLogger();
                logger.w("Missing AQS session id for Crashlytics session " + str);
            } else {
                x(this.f29970b.getSessionFile(str, "app-quality-session-id"), appQualitySessionId);
            }
        } catch (IOException e4) {
            Logger logger2 = Logger.getLogger();
            logger2.w("Could not persist event for session " + str, e4);
        }
        v(str, i4);
    }
}
