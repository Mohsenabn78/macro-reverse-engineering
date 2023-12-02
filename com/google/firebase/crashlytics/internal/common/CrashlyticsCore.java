package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes5.dex */
public class CrashlyticsCore {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29471a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f29472b;
    @VisibleForTesting
    public final BreadcrumbSource breadcrumbSource;

    /* renamed from: c  reason: collision with root package name */
    private final DataCollectionArbiter f29473c;

    /* renamed from: f  reason: collision with root package name */
    private CrashlyticsFileMarker f29476f;

    /* renamed from: g  reason: collision with root package name */
    private CrashlyticsFileMarker f29477g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f29478h;

    /* renamed from: i  reason: collision with root package name */
    private CrashlyticsController f29479i;

    /* renamed from: j  reason: collision with root package name */
    private final IdManager f29480j;

    /* renamed from: k  reason: collision with root package name */
    private final FileStore f29481k;

    /* renamed from: l  reason: collision with root package name */
    private final AnalyticsEventLogger f29482l;

    /* renamed from: m  reason: collision with root package name */
    private final ExecutorService f29483m;

    /* renamed from: n  reason: collision with root package name */
    private final CrashlyticsBackgroundWorker f29484n;

    /* renamed from: o  reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f29485o;

    /* renamed from: p  reason: collision with root package name */
    private final CrashlyticsNativeComponent f29486p;

    /* renamed from: e  reason: collision with root package name */
    private final long f29475e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    private final OnDemandCounter f29474d = new OnDemandCounter();

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, FileStore fileStore, ExecutorService executorService, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.f29472b = firebaseApp;
        this.f29473c = dataCollectionArbiter;
        this.f29471a = firebaseApp.getApplicationContext();
        this.f29480j = idManager;
        this.f29486p = crashlyticsNativeComponent;
        this.breadcrumbSource = breadcrumbSource;
        this.f29482l = analyticsEventLogger;
        this.f29483m = executorService;
        this.f29481k = fileStore;
        this.f29484n = new CrashlyticsBackgroundWorker(executorService);
        this.f29485o = crashlyticsAppQualitySessionsSubscriber;
    }

    private void d() {
        try {
            this.f29478h = Boolean.TRUE.equals((Boolean) Utils.awaitEvenIfOnMainThread(this.f29484n.submit(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(CrashlyticsCore.this.f29479i.u());
                }
            })));
        } catch (Exception unused) {
            this.f29478h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> f(SettingsProvider settingsProvider) {
        j();
        try {
            this.breadcrumbSource.registerBreadcrumbHandler(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.b
                @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                public final void handleBreadcrumb(String str) {
                    CrashlyticsCore.this.log(str);
                }
            });
            this.f29479i.V();
            if (!settingsProvider.getSettingsSync().featureFlagData.collectReports) {
                Logger.getLogger().d("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f29479i.B(settingsProvider)) {
                Logger.getLogger().w("Previous sessions could not be finalized.");
            }
            return this.f29479i.b0(settingsProvider.getSettingsAsync());
        } catch (Exception e4) {
            Logger.getLogger().e("Crashlytics encountered a problem during asynchronous initialization.", e4);
            return Tasks.forException(e4);
        } finally {
            i();
        }
    }

    private void g(final SettingsProvider settingsProvider) {
        Future<?> submit = this.f29483m.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.2
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsCore.this.f(settingsProvider);
            }
        });
        Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e4) {
            Logger.getLogger().e("Crashlytics was interrupted during initialization.", e4);
        } catch (ExecutionException e5) {
            Logger.getLogger().e("Crashlytics encountered a problem during initialization.", e5);
        } catch (TimeoutException e6) {
            Logger.getLogger().e("Crashlytics timed out during initialization.", e6);
        }
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    static boolean h(String str, boolean z3) {
        if (!z3) {
            Logger.getLogger().v("Configured not to require a build ID.");
            return true;
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        } else {
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, ".     |  | ");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".   \\ |  | /");
            Log.e(Logger.TAG, ".    \\    /");
            Log.e(Logger.TAG, ".     \\  /");
            Log.e(Logger.TAG, ".      \\/");
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
            Log.e(Logger.TAG, ".");
            Log.e(Logger.TAG, ".      /\\");
            Log.e(Logger.TAG, ".     /  \\");
            Log.e(Logger.TAG, ".    /    \\");
            Log.e(Logger.TAG, ".   / |  | \\");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".     |  |");
            Log.e(Logger.TAG, ".");
            return false;
        }
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.f29479i.o();
    }

    public Task<Void> deleteUnsentReports() {
        return this.f29479i.t();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f29478h;
    }

    public Task<Void> doBackgroundInitializationAsync(final SettingsProvider settingsProvider) {
        return Utils.callTask(this.f29483m, new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Task<Void> call() throws Exception {
                return CrashlyticsCore.this.f(settingsProvider);
            }
        });
    }

    boolean e() {
        return this.f29476f.c();
    }

    void i() {
        this.f29484n.submit(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    boolean d4 = CrashlyticsCore.this.f29476f.d();
                    if (!d4) {
                        Logger.getLogger().w("Initialization marker file was not properly removed.");
                    }
                    return Boolean.valueOf(d4);
                } catch (Exception e4) {
                    Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", e4);
                    return Boolean.FALSE;
                }
            }
        });
    }

    void j() {
        this.f29484n.checkRunningOnThread();
        this.f29476f.a();
        Logger.getLogger().v("Initialization marker file was created.");
    }

    public void log(String str) {
        this.f29479i.f0(System.currentTimeMillis() - this.f29475e, str);
    }

    public void logException(@NonNull Throwable th) {
        this.f29479i.e0(Thread.currentThread(), th);
    }

    public void logFatalException(Throwable th) {
        Logger logger = Logger.getLogger();
        logger.d("Recorded on-demand fatal events: " + this.f29474d.getRecordedOnDemandExceptions());
        Logger logger2 = Logger.getLogger();
        logger2.d("Dropped on-demand fatal events: " + this.f29474d.getDroppedOnDemandExceptions());
        this.f29479i.Z("com.crashlytics.on-demand.recorded-exceptions", Integer.toString(this.f29474d.getRecordedOnDemandExceptions()));
        this.f29479i.Z("com.crashlytics.on-demand.dropped-exceptions", Integer.toString(this.f29474d.getDroppedOnDemandExceptions()));
        this.f29479i.Q(Thread.currentThread(), th);
    }

    public boolean onPreExecute(AppData appData, SettingsProvider settingsProvider) {
        if (h(appData.buildId, CommonUtils.getBooleanResourceValue(this.f29471a, "com.crashlytics.RequireBuildId", true))) {
            String clsuuid = new CLSUUID(this.f29480j).toString();
            try {
                this.f29477g = new CrashlyticsFileMarker("crash_marker", this.f29481k);
                this.f29476f = new CrashlyticsFileMarker("initialization_marker", this.f29481k);
                UserMetadata userMetadata = new UserMetadata(clsuuid, this.f29481k, this.f29484n);
                LogFileManager logFileManager = new LogFileManager(this.f29481k);
                this.f29479i = new CrashlyticsController(this.f29471a, this.f29484n, this.f29480j, this.f29473c, this.f29481k, this.f29477g, appData, userMetadata, logFileManager, SessionReportingCoordinator.create(this.f29471a, this.f29480j, this.f29481k, appData, logFileManager, userMetadata, new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10)), settingsProvider, this.f29474d, this.f29485o), this.f29486p, this.f29482l);
                boolean e4 = e();
                d();
                this.f29479i.z(clsuuid, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider);
                if (e4 && CommonUtils.canTryConnection(this.f29471a)) {
                    Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    g(settingsProvider);
                    return false;
                }
                Logger.getLogger().d("Successfully configured exception handler.");
                return true;
            } catch (Exception e5) {
                Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", e5);
                this.f29479i = null;
                return false;
            }
        }
        throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
    }

    public Task<Void> sendUnsentReports() {
        return this.f29479i.W();
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f29473c.setCrashlyticsDataCollectionEnabled(bool);
    }

    public void setCustomKey(String str, String str2) {
        this.f29479i.X(str, str2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.f29479i.Y(map);
    }

    public void setInternalKey(String str, String str2) {
        this.f29479i.Z(str, str2);
    }

    public void setUserId(String str) {
        this.f29479i.a0(str);
    }
}
