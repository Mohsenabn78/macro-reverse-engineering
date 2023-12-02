package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.sun.mail.imap.IMAPStore;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CrashlyticsController {

    /* renamed from: s  reason: collision with root package name */
    static final FilenameFilter f29424s = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.a
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean M;
            M = CrashlyticsController.M(file, str);
            return M;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Context f29425a;

    /* renamed from: b  reason: collision with root package name */
    private final DataCollectionArbiter f29426b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsFileMarker f29427c;

    /* renamed from: d  reason: collision with root package name */
    private final UserMetadata f29428d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashlyticsBackgroundWorker f29429e;

    /* renamed from: f  reason: collision with root package name */
    private final IdManager f29430f;

    /* renamed from: g  reason: collision with root package name */
    private final FileStore f29431g;

    /* renamed from: h  reason: collision with root package name */
    private final AppData f29432h;

    /* renamed from: i  reason: collision with root package name */
    private final LogFileManager f29433i;

    /* renamed from: j  reason: collision with root package name */
    private final CrashlyticsNativeComponent f29434j;

    /* renamed from: k  reason: collision with root package name */
    private final AnalyticsEventLogger f29435k;

    /* renamed from: l  reason: collision with root package name */
    private final SessionReportingCoordinator f29436l;

    /* renamed from: m  reason: collision with root package name */
    private CrashlyticsUncaughtExceptionHandler f29437m;

    /* renamed from: n  reason: collision with root package name */
    private SettingsProvider f29438n = null;

    /* renamed from: o  reason: collision with root package name */
    final TaskCompletionSource<Boolean> f29439o = new TaskCompletionSource<>();

    /* renamed from: p  reason: collision with root package name */
    final TaskCompletionSource<Boolean> f29440p = new TaskCompletionSource<>();

    /* renamed from: q  reason: collision with root package name */
    final TaskCompletionSource<Void> f29441q = new TaskCompletionSource<>();

    /* renamed from: r  reason: collision with root package name */
    final AtomicBoolean f29442r = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass4 implements SuccessContinuation<Boolean, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Task f29454a;

        AnonymousClass4(Task task) {
            this.f29454a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: a */
        public Task<Void> then(@Nullable final Boolean bool) throws Exception {
            return CrashlyticsController.this.f29429e.submitTask(new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Task<Void> call() throws Exception {
                    if (!bool.booleanValue()) {
                        Logger.getLogger().v("Deleting cached crash reports...");
                        CrashlyticsController.s(CrashlyticsController.this.N());
                        CrashlyticsController.this.f29436l.removeAllReports();
                        CrashlyticsController.this.f29441q.trySetResult(null);
                        return Tasks.forResult(null);
                    }
                    Logger.getLogger().d("Sending cached crash reports...");
                    CrashlyticsController.this.f29426b.grantDataCollectionPermission(bool.booleanValue());
                    final Executor executor = CrashlyticsController.this.f29429e.getExecutor();
                    return AnonymousClass4.this.f29454a.onSuccessTask(executor, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1.1
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        @NonNull
                        /* renamed from: a */
                        public Task<Void> then(@Nullable Settings settings) throws Exception {
                            if (settings != null) {
                                CrashlyticsController.this.P();
                                CrashlyticsController.this.f29436l.sendReports(executor);
                                CrashlyticsController.this.f29441q.trySetResult(null);
                                return Tasks.forResult(null);
                            }
                            Logger.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
                            return Tasks.forResult(null);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger) {
        this.f29425a = context;
        this.f29429e = crashlyticsBackgroundWorker;
        this.f29430f = idManager;
        this.f29426b = dataCollectionArbiter;
        this.f29431g = fileStore;
        this.f29427c = crashlyticsFileMarker;
        this.f29432h = appData;
        this.f29428d = userMetadata;
        this.f29433i = logFileManager;
        this.f29434j = crashlyticsNativeComponent;
        this.f29435k = analyticsEventLogger;
        this.f29436l = sessionReportingCoordinator;
    }

    private void A(String str) {
        Logger logger = Logger.getLogger();
        logger.v("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.f29434j.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        CrashlyticsReport.ApplicationExitInfo applicationExitInto = sessionFileProvider.getApplicationExitInto();
        if (R(str, minidumpFile, applicationExitInto)) {
            Logger.getLogger().w("No native core present");
            return;
        }
        long lastModified = minidumpFile.lastModified();
        LogFileManager logFileManager = new LogFileManager(this.f29431g, str);
        File nativeSessionDir = this.f29431g.getNativeSessionDir(str);
        if (!nativeSessionDir.isDirectory()) {
            Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
            return;
        }
        y(lastModified);
        List<NativeSessionFile> F = F(sessionFileProvider, str, this.f29431g, logFileManager.getBytesForLog());
        NativeSessionFileGzipper.b(nativeSessionDir, F);
        Logger.getLogger().d("CrashlyticsController#finalizePreviousNativeSession");
        this.f29436l.finalizeSessionWithNativeEvent(str, F, applicationExitInto);
        logFileManager.clearLog();
    }

    private static boolean C() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String D() {
        SortedSet<String> listSortedOpenSessionIds = this.f29436l.listSortedOpenSessionIds();
        if (!listSortedOpenSessionIds.isEmpty()) {
            return listSortedOpenSessionIds.first();
        }
        return null;
    }

    private static long E() {
        return H(System.currentTimeMillis());
    }

    @NonNull
    static List<NativeSessionFile> F(NativeSessionFileProvider nativeSessionFileProvider, String str, FileStore fileStore, byte[] bArr) {
        File sessionFile = fileStore.getSessionFile(str, UserMetadata.USERDATA_FILENAME);
        File sessionFile2 = fileStore.getSessionFile(str, UserMetadata.KEYDATA_FILENAME);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.getAppFile()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", IMAPStore.ID_OS, nativeSessionFileProvider.getOsFile()));
        arrayList.add(S(nativeSessionFileProvider));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", sessionFile));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", UserMetadata.KEYDATA_FILENAME, sessionFile2));
        return arrayList;
    }

    private InputStream G(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            Logger.getLogger().w("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            Logger.getLogger().i("No version control information found");
            return null;
        }
        return resourceAsStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long H(long j4) {
        return j4 / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean M(File file, String str) {
        return str.startsWith(".ae");
    }

    private Task<Void> O(final long j4) {
        if (C()) {
            Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.8
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt("fatal", 1);
                bundle.putLong("timestamp", j4);
                CrashlyticsController.this.f29435k.logEvent("_ae", bundle);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> P() {
        ArrayList arrayList = new ArrayList();
        for (File file : N()) {
            try {
                arrayList.add(O(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger logger = Logger.getLogger();
                logger.w("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    private static boolean R(String str, File file, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        if (file == null || !file.exists()) {
            Logger logger = Logger.getLogger();
            logger.w("No minidump data found for session " + str);
        }
        if (applicationExitInfo == null) {
            Logger logger2 = Logger.getLogger();
            logger2.i("No Tombstones data found for session " + str);
        }
        if ((file == null || !file.exists()) && applicationExitInfo == null) {
            return true;
        }
        return false;
    }

    private static NativeSessionFile S(NativeSessionFileProvider nativeSessionFileProvider) {
        File minidumpFile = nativeSessionFileProvider.getMinidumpFile();
        if (minidumpFile != null && minidumpFile.exists()) {
            return new FileBackedNativeSessionFile("minidump_file", "minidump", minidumpFile);
        }
        return new BytesBackedNativeSessionFile("minidump_file", "minidump", new byte[]{0});
    }

    private static byte[] U(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private Task<Boolean> c0() {
        if (this.f29426b.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.f29439o.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().v("Notifying that unsent reports are available.");
        this.f29439o.trySetResult(Boolean.TRUE);
        Task<TContinuationResult> onSuccessTask = this.f29426b.waitForAutomaticDataCollectionEnabled().onSuccessTask(new SuccessContinuation<Void, Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.3
            @Override // com.google.android.gms.tasks.SuccessContinuation
            @NonNull
            /* renamed from: a */
            public Task<Boolean> then(@Nullable Void r12) throws Exception {
                return Tasks.forResult(Boolean.TRUE);
            }
        });
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(onSuccessTask, this.f29440p.getTask());
    }

    private void d0(String str) {
        List<ApplicationExitInfo> historicalProcessExitReasons;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            historicalProcessExitReasons = ((ActivityManager) this.f29425a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            if (historicalProcessExitReasons.size() != 0) {
                this.f29436l.persistRelevantAppExitInfoEvent(str, historicalProcessExitReasons, new LogFileManager(this.f29431g, str), UserMetadata.loadFromExistingSession(str, this.f29431g, this.f29429e));
                return;
            }
            Logger logger = Logger.getLogger();
            logger.v("No ApplicationExitInfo available. Session: " + str);
            return;
        }
        Logger logger2 = Logger.getLogger();
        logger2.v("ANR feature enabled, but device is API " + i4);
    }

    private static StaticSessionData.AppData p(IdManager idManager, AppData appData) {
        return StaticSessionData.AppData.create(idManager.getAppIdentifier(), appData.versionCode, appData.versionName, idManager.getInstallIds().getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(appData.installerPackageName).getId(), appData.developmentPlatformProvider);
    }

    private static StaticSessionData.DeviceData q() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.create(CommonUtils.getCpuArchitectureInt(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.getTotalRamInBytes(), statFs.getBlockCount() * statFs.getBlockSize(), CommonUtils.isEmulator(), CommonUtils.getDeviceState(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static StaticSessionData.OsData r() {
        return StaticSessionData.OsData.create(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.isRooted());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(List<File> list) {
        for (File file : list) {
            file.delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w(boolean z3, SettingsProvider settingsProvider) {
        String str;
        ArrayList arrayList = new ArrayList(this.f29436l.listSortedOpenSessionIds());
        if (arrayList.size() <= z3) {
            Logger.getLogger().v("No open sessions to be closed.");
            return;
        }
        String str2 = (String) arrayList.get(z3 ? 1 : 0);
        if (settingsProvider.getSettingsSync().featureFlagData.collectAnrs) {
            d0(str2);
        } else {
            Logger.getLogger().v("ANR feature disabled.");
        }
        if (this.f29434j.hasCrashDataForSession(str2)) {
            A(str2);
        }
        if (z3 != 0) {
            str = (String) arrayList.get(0);
        } else {
            str = null;
        }
        this.f29436l.finalizeSessions(E(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str) {
        long E = E();
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + str);
        this.f29434j.prepareNativeSession(str, String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.getVersion()), E, StaticSessionData.create(p(this.f29430f, this.f29432h), r(), q()));
        this.f29433i.setCurrentSession(str);
        this.f29436l.onBeginSession(str, E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j4) {
        try {
            FileStore fileStore = this.f29431g;
            if (!fileStore.getCommonFile(".ae" + j4).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e4) {
            Logger.getLogger().w("Could not create app exception marker file.", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B(SettingsProvider settingsProvider) {
        this.f29429e.checkRunningOnThread();
        if (L()) {
            Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.getLogger().v("Finalizing previously open sessions.");
        try {
            w(true, settingsProvider);
            Logger.getLogger().v("Closed all previously open sessions.");
            return true;
        } catch (Exception e4) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e4);
            return false;
        }
    }

    String I() throws IOException {
        InputStream G = G("META-INF/version-control-info.textproto");
        if (G == null) {
            return null;
        }
        Logger.getLogger().d("Read version control info");
        return Base64.encodeToString(U(G), 0);
    }

    void J(@NonNull SettingsProvider settingsProvider, @NonNull Thread thread, @NonNull Throwable th) {
        K(settingsProvider, thread, th, false);
    }

    synchronized void K(@NonNull final SettingsProvider settingsProvider, @NonNull final Thread thread, @NonNull final Throwable th, final boolean z3) {
        Logger logger = Logger.getLogger();
        logger.d("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            Utils.awaitEvenIfOnMainThread(this.f29429e.submitTask(new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Task<Void> call() throws Exception {
                    long H = CrashlyticsController.H(currentTimeMillis);
                    final String D = CrashlyticsController.this.D();
                    if (D == null) {
                        Logger.getLogger().e("Tried to write a fatal exception while no session was open.");
                        return Tasks.forResult(null);
                    }
                    CrashlyticsController.this.f29427c.a();
                    CrashlyticsController.this.f29436l.persistFatalEvent(th, thread, D, H);
                    CrashlyticsController.this.y(currentTimeMillis);
                    CrashlyticsController.this.v(settingsProvider);
                    CrashlyticsController.this.x(new CLSUUID(CrashlyticsController.this.f29430f).toString());
                    if (!CrashlyticsController.this.f29426b.isAutomaticDataCollectionEnabled()) {
                        return Tasks.forResult(null);
                    }
                    final Executor executor = CrashlyticsController.this.f29429e.getExecutor();
                    return settingsProvider.getSettingsAsync().onSuccessTask(executor, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2.1
                        @Override // com.google.android.gms.tasks.SuccessContinuation
                        @NonNull
                        /* renamed from: a */
                        public Task<Void> then(@Nullable Settings settings) throws Exception {
                            String str = null;
                            if (settings == null) {
                                Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
                                return Tasks.forResult(null);
                            }
                            Task[] taskArr = new Task[2];
                            taskArr[0] = CrashlyticsController.this.P();
                            SessionReportingCoordinator sessionReportingCoordinator = CrashlyticsController.this.f29436l;
                            Executor executor2 = executor;
                            if (z3) {
                                str = D;
                            }
                            taskArr[1] = sessionReportingCoordinator.sendReports(executor2, str);
                            return Tasks.whenAll(taskArr);
                        }
                    });
                }
            }));
        } catch (TimeoutException unused) {
            Logger.getLogger().e("Cannot send reports. Timed out while fetching settings.");
        } catch (Exception e4) {
            Logger.getLogger().e("Error handling uncaught exception", e4);
        }
    }

    boolean L() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f29437m;
        if (crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.a()) {
            return true;
        }
        return false;
    }

    List<File> N() {
        return this.f29431g.getCommonFiles(f29424s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(Thread thread, Throwable th) {
        SettingsProvider settingsProvider = this.f29438n;
        if (settingsProvider == null) {
            Logger.getLogger().w("settingsProvider not set");
        } else {
            K(settingsProvider, thread, th, true);
        }
    }

    void T(final String str) {
        this.f29429e.submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                CrashlyticsController.this.x(str);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        try {
            String I = I();
            if (I != null) {
                Z("com.crashlytics.version-control-info", I);
                Logger.getLogger().i("Saved version control info");
            }
        } catch (IOException e4) {
            Logger.getLogger().w("Unable to save version control info", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> W() {
        this.f29440p.trySetResult(Boolean.TRUE);
        return this.f29441q.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(String str, String str2) {
        try {
            this.f29428d.setCustomKey(str, str2);
        } catch (IllegalArgumentException e4) {
            Context context = this.f29425a;
            if (context != null && CommonUtils.isAppDebuggable(context)) {
                throw e4;
            }
            Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(Map<String, String> map) {
        this.f29428d.setCustomKeys(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(String str, String str2) {
        try {
            this.f29428d.setInternalKey(str, str2);
        } catch (IllegalArgumentException e4) {
            Context context = this.f29425a;
            if (context != null && CommonUtils.isAppDebuggable(context)) {
                throw e4;
            }
            Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(String str) {
        this.f29428d.setUserId(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"TaskMainThread"})
    public Task<Void> b0(Task<Settings> task) {
        if (!this.f29436l.hasReportsToSend()) {
            Logger.getLogger().v("No crash reports are available to be sent.");
            this.f29439o.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        Logger.getLogger().v("Crash reports are available to be sent.");
        return c0().onSuccessTask(new AnonymousClass4(task));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(@NonNull final Thread thread, @NonNull final Throwable th) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f29429e.e(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.6
            @Override // java.lang.Runnable
            public void run() {
                if (!CrashlyticsController.this.L()) {
                    long H = CrashlyticsController.H(currentTimeMillis);
                    String D = CrashlyticsController.this.D();
                    if (D == null) {
                        Logger.getLogger().w("Tried to write a non-fatal exception while no session was open.");
                    } else {
                        CrashlyticsController.this.f29436l.persistNonFatalEvent(th, thread, D, H);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(final long j4, final String str) {
        this.f29429e.submit(new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                if (!CrashlyticsController.this.L()) {
                    CrashlyticsController.this.f29433i.writeToLog(j4, str);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Task<Boolean> o() {
        if (!this.f29442r.compareAndSet(false, true)) {
            Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
            return Tasks.forResult(Boolean.FALSE);
        }
        return this.f29439o.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> t() {
        this.f29440p.trySetResult(Boolean.FALSE);
        return this.f29441q.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        if (!this.f29427c.c()) {
            String D = D();
            if (D != null && this.f29434j.hasCrashDataForSession(D)) {
                return true;
            }
            return false;
        }
        Logger.getLogger().v("Found previous crash marker.");
        this.f29427c.d();
        return true;
    }

    void v(SettingsProvider settingsProvider) {
        w(false, settingsProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsProvider settingsProvider) {
        this.f29438n = settingsProvider;
        T(str);
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.1
            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener
            public void a(@NonNull SettingsProvider settingsProvider2, @NonNull Thread thread, @NonNull Throwable th) {
                CrashlyticsController.this.J(settingsProvider2, thread, th);
            }
        }, settingsProvider, uncaughtExceptionHandler, this.f29434j);
        this.f29437m = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }
}
