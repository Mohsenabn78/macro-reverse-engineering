package com.arlosoft.macrodroid.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.collection.ArraySet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.preference.PreferenceManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.PasswordProtection;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accessibility.AccessibilityServiceMonitor;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.di.AppComponent;
import com.arlosoft.macrodroid.app.di.DaggerAppComponent;
import com.arlosoft.macrodroid.app.di.modules.ActivityModule;
import com.arlosoft.macrodroid.app.di.modules.ApplicationModule;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.autobackup.worker.AutoBackupWorker;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.cache.CacheProvider;
import com.arlosoft.macrodroid.cache.preference.PreferenceCache;
import com.arlosoft.macrodroid.commercial.CommercialTools;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.CheckExtraSubscriptionWorker;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptionData;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.drawer.DrawerOverlayHandleService;
import com.arlosoft.macrodroid.extras.stopclub.updatechecker.StopClubUpdateChecker;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.freeversion.DataSharingService;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.helper.receiver.HelperResultsReceiver;
import com.arlosoft.macrodroid.logging.helper.HelperLogMessageBroadcaseReceiver;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.telephony.TelephonyMonitor;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger;
import com.arlosoft.macrodroid.triggers.MacroDroidInitialisedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.receivers.GPSEnabledTriggerReceiver;
import com.arlosoft.macrodroid.triggers.receivers.PebbleBatteryUpdateReceiver;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.triggers.services.NotificationServiceOreo;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import com.arlosoft.macrodroid.utils.LocaleUtils;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import com.arlosoft.macrodroid.utils.SigningHelper;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseAccess;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.PersistentCacheSettings;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import crashguard.android.library.CrashGuard;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dev.skomlach.biometric.compat.BiometricPromptCompat;
import dev.skomlach.common.network.PingConfig;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.apache.commons.io.FileUtils;
import org.jetbrains.anko.Sdk27ServicesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: MacroDroidApplication.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroDroidApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidApplication.kt\ncom/arlosoft/macrodroid/app/MacroDroidApplication\n+ 2 ArraySet.kt\nandroidx/collection/ArraySetKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,873:1\n22#2:874\n22#2:877\n1855#3,2:875\n*S KotlinDebug\n*F\n+ 1 MacroDroidApplication.kt\ncom/arlosoft/macrodroid/app/MacroDroidApplication\n*L\n233#1:874\n464#1:877\n427#1:875,2\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroDroidApplication extends Application implements CacheProvider, HasActivityInjector, LifecycleObserver {
    public static AppComponent appComponentInstance;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static MacroDroidApplication f5666j;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f5667k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f5668l;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private PebbleBatteryUpdateReceiver f5669a;
    @Inject
    public AccessibilityServiceMonitor accessibilityServiceMonitor;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private MacroDroidRoomDatabase f5670b;
    @Inject
    public BillingDataSource billingDataSource;

    /* renamed from: c  reason: collision with root package name */
    private long f5671c;
    @Inject
    public CommercialTools commercialTools;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5672d;
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    public ExtrasManager extrasManager;
    @Inject
    public FlashSaleManager flashSaleManager;
    @Inject
    public FreeVersionHelper freeVersionHelper;

    /* renamed from: g  reason: collision with root package name */
    private AppComponent f5675g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f5676h;

    /* renamed from: i  reason: collision with root package name */
    private long f5677i;
    @Inject
    public NotificationChannelUtil notificationChannelUtil;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public PurchaseValidator purchaseValidator;
    @Inject
    public RemoteConfig remoteConfig;
    @Inject
    public UserProvider userProvider;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, Cache> f5673e = new HashMap<>();
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final ServiceInitialisation f5674f = new ServiceInitialisation();

    /* compiled from: MacroDroidApplication.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class MacroDroidUnhandledExceptionHandler implements Thread.UncaughtExceptionHandler {
        public static final int $stable = 8;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f5678a;

        public MacroDroidUnhandledExceptionHandler(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f5678a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NotNull Thread t3, @NotNull Throwable e4) {
            Intrinsics.checkNotNullParameter(t3, "t");
            Intrinsics.checkNotNullParameter(e4, "e");
            FirebaseAccess.INSTANCE.logFatalException(e4);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5678a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(t3, e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ DataSharingService $dataSharingService;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(DataSharingService dataSharingService) {
            super(1);
            this.$dataSharingService = dataSharingService;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                this.$dataSharingService.getDataPartner().enableDataSharing();
            }
        }
    }

    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<PersistentCacheSettings.Builder, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f5680d = new b();

        b() {
            super(1);
        }

        public final void a(@NotNull PersistentCacheSettings.Builder persistentCacheSettings) {
            Intrinsics.checkNotNullParameter(persistentCacheSettings, "$this$persistentCacheSettings");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PersistentCacheSettings.Builder builder) {
            a(builder);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CrashGuard.initialize(MacroDroidApplication.this.getApplicationContext(), new CrashGuard.Project("aa45bc25-0261-4de3-a2b7-981406097d47", "70d1d4c1-5ea3-4bd5-a7eb-3eb685e7bb2d"));
                CrashGuard.getInstance(MacroDroidApplication.this.getApplicationContext()).setConfiguration(new CrashGuard.Configuration(R.drawable.onboarding_intro, "Crash Detected!", "We're sorry, but it looks like something went wrong. The crash has been logged to the developer for investigation.", false, false));
                CrashGuard.getInstance(MacroDroidApplication.this.getApplicationContext()).start();
                CrashGuard.getInstance(MacroDroidApplication.this.getApplicationContext()).setSupplementalInformation(Settings.getAnonymousUserId(MacroDroidApplication.this));
                Thread.setDefaultUncaughtExceptionHandler(new MacroDroidUnhandledExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Boolean, Unit> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = Settings.getForceHideIcon(MacroDroidApplication.this) ? " (Force hide icon enabled)" : "";
            SystemLog.logVerbose("MacroDroid service created: 5.38.16 (53800019)" + str);
            Timber.d("Service init took " + (currentTimeMillis - MacroDroidApplication.this.f5677i) + TranslateLanguage.MALAY, new Object[0]);
            SystemLog.logDebug("Service init took " + (currentTimeMillis - MacroDroidApplication.this.f5677i) + TranslateLanguage.MALAY);
            int memoryClass = Sdk27ServicesKt.getActivityManager(MacroDroidApplication.this).getMemoryClass();
            SystemLog.logDebug("Memory limit: " + memoryClass + "MB");
            MacroDroidApplication.this.c(true);
        }
    }

    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<Throwable, Unit> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            long currentTimeMillis = System.currentTimeMillis();
            Timber.d("Service init error -> took " + (currentTimeMillis - MacroDroidApplication.this.f5677i) + TranslateLanguage.MALAY, new Object[0]);
            SystemLog.logDebug("Service init timeout ->  took " + (currentTimeMillis - MacroDroidApplication.this.f5677i) + TranslateLanguage.MALAY);
            MacroDroidApplication.this.c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CommercialTools commercialTools = MacroDroidApplication.this.getCommercialTools();
                this.label = 1;
                if (commercialTools.registerCommercial(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (Settings.getAutoBackupsEnabled(MacroDroidApplication.this)) {
                    AutoBackupWorker.Companion.enablePeriodicBackups();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public MacroDroidApplication() {
        BehaviorSubject<Boolean> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Boolean>()");
        this.f5676h = create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z3) {
        boolean z4;
        String password = Settings.getPassword(this);
        if (password != null && password.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4 && Settings.getBiometricsEnabled(this)) {
            PingConfig.INSTANCE.setHostsList(new ArraySet());
            BiometricPromptCompat.Companion.init(null);
        }
        if (Settings.getInstallDate(this) == 0) {
            Settings.setInstallDate(this, this.f5677i);
        }
        Settings.setAppLaunchCount(this, Settings.getAppLaunchCount(this) + 1);
        i();
        forceLanguage();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        RxPaparazzo.register(this).withFileProviderPath(Constants.RX_PAPARAZZO_DIRECTORY);
        Database.getInstance(this);
        MacroDroidVariableStore.getInstance();
        FirebaseAnalyticsEventLogger.log("Initialising MacroStore in MacroDroidApplication creation");
        MacroStore.getInstance(getApplicationContext());
        new Thread() { // from class: com.arlosoft.macrodroid.app.MacroDroidApplication$afterServiceInitialised$1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                PebbleBatteryUpdateReceiver pebbleBatteryUpdateReceiver;
                try {
                    if (Settings.getRootEnabled(MacroDroidApplication.this) && RootToolsHelper.isAccessGiven()) {
                        Util.runAsRoot(new String[]{"Dummy_command_to_avoid_delaying_root_access_request"});
                    }
                } catch (Exception unused) {
                }
                FirebaseCrashlytics.getInstance().setUserId(Settings.getAnonymousUserId(MacroDroidApplication.this));
                if (ApplicationChecker.isPebbleInstalled()) {
                    MacroDroidApplication macroDroidApplication = MacroDroidApplication.this;
                    UUID uuid = Constants.PEBBLE_APP_UUID;
                    macroDroidApplication.f5669a = new PebbleBatteryUpdateReceiver(uuid);
                    MacroDroidApplication macroDroidApplication2 = MacroDroidApplication.this;
                    pebbleBatteryUpdateReceiver = macroDroidApplication2.f5669a;
                    PebbleKit.registerReceivedDataHandler(macroDroidApplication2, pebbleBatteryUpdateReceiver);
                    PebbleDictionary pebbleDictionary = new PebbleDictionary();
                    pebbleDictionary.addUint8(999, (byte) 6);
                    PebbleKit.sendDataToPebble(MacroDroidApplication.this, uuid, pebbleDictionary);
                }
                Settings.setKeyGuardState(MacroDroidApplication.this, 0);
                try {
                    String file = Environment.getExternalStorageDirectory().toString();
                    File file2 = new File(file + "/MacroDroid");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                } catch (Exception unused2) {
                }
            }
        }.start();
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        n();
        GPSEnabledTriggerReceiver.initEnabledState(this);
        t();
        s();
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(this);
        String signingKeySha1 = SigningHelper.INSTANCE.getSigningKeySha1(Companion.getInstance());
        SystemLog.logDebug("Sha1 = " + signingKeySha1);
        r();
        l();
        if (Settings.isDrawerEnabled(this) && (Build.VERSION.SDK_INT < 26 || z3)) {
            stopService(new Intent(this, DrawerOverlayHandleService.class));
            startService(new Intent(this, DrawerOverlayHandleService.class));
        }
        u();
        long currentTimeMillis = System.currentTimeMillis();
        Timber.d("Startup time took " + (currentTimeMillis - this.f5677i) + TranslateLanguage.MALAY, new Object[0]);
        SystemLog.logInfo("MacroDroid process has started");
        SystemLog.logDebug("Startup time took " + (currentTimeMillis - this.f5677i) + TranslateLanguage.MALAY);
        d();
        this.f5676h.onNext(Boolean.TRUE);
        getAccessibilityServiceMonitor().monitorServices();
    }

    private final void d() {
        boolean contains$default;
        boolean contains$default2;
        try {
            String enabledAppList = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
            Intrinsics.checkNotNullExpressionValue(enabledAppList, "enabledAppList");
            Companion companion = Companion;
            String packageName = companion.getInstance().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "instance.packageName");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) enabledAppList, (CharSequence) packageName, false, 2, (Object) null);
            Class cls = NotificationServiceOreo.class;
            if (!contains$default) {
                String name = cls.getName();
                Intrinsics.checkNotNullExpressionValue(name, "NotificationServiceOreo::class.java.name");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) enabledAppList, (CharSequence) name, false, 2, (Object) null);
                if (!contains$default2) {
                    return;
                }
            }
            SystemLog.logDebug("Attempting to force start Notification Service");
            MacroDroidApplication companion2 = companion.getInstance();
            if (Build.VERSION.SDK_INT < 26) {
                cls = NotificationService.class;
            }
            companion.getInstance().startService(new Intent(companion2, cls));
        } catch (Exception e4) {
            SystemLog.logDebug("Failed to force start notification service: " + e4);
        }
    }

    private final void e() {
        Map<String, ExtraSubscriptionData> map;
        Set<String> keySet;
        Map<String, ExtraSubscriptionData> map2;
        List list;
        Object firstOrNull;
        ExtraSubscriptions extraSubscriptions = com.arlosoft.macrodroid.settings.Settings.getExtraSubscriptions(this);
        if (extraSubscriptions != null && (map2 = extraSubscriptions.getMap()) != null && (list = MapsKt.toList(map2)) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            if (((Pair) firstOrNull) != null) {
                getExtrasManager().registerDeviceId(ExtrasManager.Companion.getExtrasCollection(), BillingModuleKt.SKU_STOPCLUB_SUB);
                new StopClubUpdateChecker(this, getExtrasManager()).checkForUpdate();
            }
        }
        if (extraSubscriptions != null && (map = extraSubscriptions.getMap()) != null && (keySet = map.keySet()) != null) {
            for (String str : keySet) {
                CheckExtraSubscriptionWorker.Companion.scheduleSubscriptionCheck(Gradients.INSTANCE.getContext(), str);
            }
        }
    }

    private final void f() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            try {
                if (getFlashSaleManager().canStartNewFlash()) {
                    if (com.arlosoft.macrodroid.settings.Settings.getCanShowFlashNotification(this)) {
                        getFlashSaleManager().createFlashSaleNotification(this);
                    }
                } else {
                    com.arlosoft.macrodroid.settings.Settings.setCanShowFlashNotification(Gradients.INSTANCE.getContext(), true);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final void g(boolean z3) {
        if (NonAppActivity.Companion.isActive() && z3) {
            f5667k = true;
        } else if (f5667k && !z3) {
            f5667k = false;
        } else {
            Object systemService = getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            boolean isInteractive = ((PowerManager) systemService).isInteractive();
            if (!z3 && !isInteractive) {
                f5668l = true;
            } else if (z3 && f5668l) {
                f5668l = false;
            } else {
                f5668l = false;
                f5667k = false;
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof ApplicationLaunchedTrigger) {
                            ApplicationLaunchedTrigger applicationLaunchedTrigger = (ApplicationLaunchedTrigger) next;
                            if (applicationLaunchedTrigger.getIsAllApps()) {
                                if (applicationLaunchedTrigger.getLaunched() == z3) {
                                    macro.setTriggerThatInvoked(next);
                                    macro.setTriggerContextInfo(new TriggerContextInfo(macro.getTriggerThatInvoked(), "MacroDroid", getPackageName()));
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            } else {
                                Iterator<String> it2 = applicationLaunchedTrigger.getPackageNameList().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        String next2 = it2.next();
                                        if (applicationLaunchedTrigger.getLaunched() == z3 && Intrinsics.areEqual(next2, BuildConfig.APPLICATION_ID) && next.constraintsMet()) {
                                            macro.setTriggerThatInvoked(next);
                                            macro.setTriggerContextInfo(new TriggerContextInfo(macro.getTriggerThatInvoked(), "MacroDroid", next2));
                                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                arrayList.add(macro);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Macro macro2 = (Macro) it3.next();
                        macro2.invokeActions(macro2.getTriggerContextInfo());
                    }
                }
            }
        }
    }

    @NotNull
    public static final MacroDroidApplication getInstance() {
        return Companion.getInstance();
    }

    private final void h() {
        AppComponent build = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder()\n              …\n                .build()");
        this.f5675g = build;
        AppComponent appComponent = null;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appComponent");
            build = null;
        }
        build.inject(this);
        Companion companion = Companion;
        AppComponent appComponent2 = this.f5675g;
        if (appComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appComponent");
        } else {
            appComponent = appComponent2;
        }
        companion.setAppComponentInstance(appComponent);
    }

    private final void i() {
        PackageManager packageManager = getPackageManager();
        ComponentName componentName = new ComponentName(BuildConfig.APPLICATION_ID, "com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidOnOffTileService");
        if (com.arlosoft.macrodroid.settings.Settings.getPassword(this) == null) {
            try {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            } catch (Exception unused) {
            }
        }
    }

    private final void j() {
        if (this.f5670b == null) {
            this.f5670b = (MacroDroidRoomDatabase) Room.databaseBuilder(this, MacroDroidRoomDatabase.class, "macroDroidDatabase").setJournalMode(RoomDatabase.JournalMode.AUTOMATIC).enableMultiInstanceInvalidation().build();
        }
    }

    private final void k() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            DataSharingService enabledDataSharingService = getFreeVersionHelper().getEnabledDataSharingService();
            enabledDataSharingService.getDataPartner().initialise(new a(enabledDataSharingService));
            return;
        }
        getFreeVersionHelper().getEnabledDataSharingService().getDataPartner().disableDataSharing(true);
        getFreeVersionHelper().setEnabledDataSharingService(DataSharingService.NONE);
    }

    private final void l() {
        try {
            if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
                FirebaseMessaging.getInstance().subscribeToTopic("FreeVersion");
            } else {
                FirebaseMessaging.getInstance().subscribeToTopic("ProVersion");
            }
        } catch (Exception unused) {
        }
        long j4 = 60;
        if (((((System.currentTimeMillis() - com.arlosoft.macrodroid.settings.Settings.getInstallDate(this)) / 1000) / j4) / j4) / 24 > 30) {
            try {
                FirebaseMessaging.getInstance().subscribeToTopic("OldUser");
            } catch (Exception unused2) {
            }
        }
    }

    private final void m(Context context) {
        EmojiCompat.init(context);
    }

    private final void n() {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof MacroDroidInitialisedTrigger) && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean o(File file) {
        boolean z3 = false;
        ObjectInputStream objectInputStream = null;
        try {
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                try {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
                    edit.clear();
                    Object readObject = objectInputStream2.readObject();
                    Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                    Iterator it = ((Map) readObject).entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        String str = (String) entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            edit.putBoolean(str, ((Boolean) value).booleanValue());
                        } else if (value instanceof Float) {
                            edit.putFloat(str, ((Number) value).floatValue());
                        } else if (value instanceof Integer) {
                            edit.putInt(str, ((Number) value).intValue());
                        } else if (value instanceof Long) {
                            edit.putLong(str, ((Number) value).longValue());
                        } else if (value instanceof String) {
                            edit.putString(str, (String) value);
                        }
                    }
                    edit.apply();
                    z3 = true;
                    forceLanguage();
                    objectInputStream2.close();
                    objectInputStream = it;
                } catch (IOException e5) {
                    e = e5;
                    objectInputStream = objectInputStream2;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                        objectInputStream = objectInputStream;
                    }
                    return z3;
                } catch (ClassNotFoundException e6) {
                    e = e6;
                    objectInputStream = objectInputStream2;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                        objectInputStream = objectInputStream;
                    }
                    return z3;
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            } catch (ClassNotFoundException e9) {
                e = e9;
            }
            return z3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void r() {
        File file = new File("/sdcard/Download/MDefault.mdr");
        if (file.exists()) {
            MacroStore macroStore = MacroStore.getInstance();
            macroStore.storeMacroList(MacroStore.getInstance().importJson(file.getAbsolutePath(), false));
            macroStore.writeToJSON();
            file.delete();
            FileUtils.deleteQuietly(file);
        }
        File file2 = new File("/sdcard/Download/MDefault.set");
        if (file2.exists()) {
            o(file2);
            file2.delete();
            FileUtils.deleteQuietly(file2);
        }
    }

    private final void t() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new f(null), 3, null);
    }

    private final void u() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new g(null), 2, null);
    }

    @Override // dagger.android.HasActivityInjector
    @NotNull
    public AndroidInjector<Activity> activityInjector() {
        return getDispatchingAndroidInjector();
    }

    @NotNull
    public final ActivityModule createActivityModule(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new ActivityModule(activity);
    }

    public final void forceLanguage() {
        Locale locale;
        int i4 = 0;
        Timber.d("++++ FORCE LANGUAGE: " + com.arlosoft.macrodroid.settings.Settings.getForcedLanguageCode(this), new Object[0]);
        String forcedLanguageCode = com.arlosoft.macrodroid.settings.Settings.getForcedLanguageCode(this);
        if (forcedLanguageCode != null) {
            Configuration configuration = getResources().getConfiguration();
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 121) {
                locale = Locale.forLanguageTag(forcedLanguageCode);
                Intrinsics.checkNotNullExpressionValue(locale, "{\n                Locale…nguageCode)\n            }");
            } else {
                locale = LocaleUtils.toLocale(forcedLanguageCode);
                Intrinsics.checkNotNullExpressionValue(locale, "{\n                Locale…nguageCode)\n            }");
            }
            configuration.locale = locale;
            if (i5 >= 24) {
                configuration.setLocale(locale);
            }
            Companion.setLocale(locale);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
            return;
        }
        String forcedLanguage = com.arlosoft.macrodroid.settings.Settings.getForcedLanguage(this);
        if (forcedLanguage != null) {
            Configuration configuration2 = getResources().getConfiguration();
            String[] stringArray = getResources().getStringArray(R.array.languages);
            Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.languages)");
            int length = stringArray.length;
            while (true) {
                if (i4 < length) {
                    if (Intrinsics.areEqual(stringArray[i4], forcedLanguage)) {
                        break;
                    }
                    i4++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (i4 >= 0) {
                Locale locale2 = com.arlosoft.macrodroid.settings.Settings.PREFERENCE_LANGUAGE_LOCALES[i4];
                configuration2.locale = locale2;
                if (Build.VERSION.SDK_INT >= 24) {
                    configuration2.setLocale(locale2);
                }
                Companion.setLocale(configuration2.locale);
                getResources().updateConfiguration(configuration2, getResources().getDisplayMetrics());
            }
        }
    }

    @NotNull
    public final AccessibilityServiceMonitor getAccessibilityServiceMonitor() {
        AccessibilityServiceMonitor accessibilityServiceMonitor = this.accessibilityServiceMonitor;
        if (accessibilityServiceMonitor != null) {
            return accessibilityServiceMonitor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("accessibilityServiceMonitor");
        return null;
    }

    @NotNull
    public final BehaviorSubject<Boolean> getApplicationStartedSubject() {
        return this.f5676h;
    }

    @NotNull
    public final BillingDataSource getBillingDataSource() {
        BillingDataSource billingDataSource = this.billingDataSource;
        if (billingDataSource != null) {
            return billingDataSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("billingDataSource");
        return null;
    }

    @Override // com.arlosoft.macrodroid.cache.CacheProvider
    @NotNull
    public Cache getCache(@NotNull String cacheName) {
        Intrinsics.checkNotNullParameter(cacheName, "cacheName");
        Cache cache = this.f5673e.get(cacheName);
        if (cache == null) {
            return new PreferenceCache(this, cacheName);
        }
        return cache;
    }

    @NotNull
    public final CommercialTools getCommercialTools() {
        CommercialTools commercialTools = this.commercialTools;
        if (commercialTools != null) {
            return commercialTools;
        }
        Intrinsics.throwUninitializedPropertyAccessException("commercialTools");
        return null;
    }

    @NotNull
    public final DispatchingAndroidInjector<Activity> getDispatchingAndroidInjector() {
        DispatchingAndroidInjector<Activity> dispatchingAndroidInjector = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector != null) {
            return dispatchingAndroidInjector;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        return null;
    }

    @NotNull
    public final ExtrasManager getExtrasManager() {
        ExtrasManager extrasManager = this.extrasManager;
        if (extrasManager != null) {
            return extrasManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extrasManager");
        return null;
    }

    @NotNull
    public final FlashSaleManager getFlashSaleManager() {
        FlashSaleManager flashSaleManager = this.flashSaleManager;
        if (flashSaleManager != null) {
            return flashSaleManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flashSaleManager");
        return null;
    }

    @NotNull
    public final FreeVersionHelper getFreeVersionHelper() {
        FreeVersionHelper freeVersionHelper = this.freeVersionHelper;
        if (freeVersionHelper != null) {
            return freeVersionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("freeVersionHelper");
        return null;
    }

    @NotNull
    public final NotificationChannelUtil getNotificationChannelUtil() {
        NotificationChannelUtil notificationChannelUtil = this.notificationChannelUtil;
        if (notificationChannelUtil != null) {
            return notificationChannelUtil;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationChannelUtil");
        return null;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final PurchaseValidator getPurchaseValidator() {
        PurchaseValidator purchaseValidator = this.purchaseValidator;
        if (purchaseValidator != null) {
            return purchaseValidator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("purchaseValidator");
        return null;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            return remoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
        return null;
    }

    @NotNull
    public final MacroDroidRoomDatabase getRoomDatabase() {
        j();
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.f5670b;
        Intrinsics.checkNotNull(macroDroidRoomDatabase);
        return macroDroidRoomDatabase;
    }

    @NotNull
    public final ServiceInitialisation getServiceInitialisation() {
        return this.f5674f;
    }

    @NotNull
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    public final boolean isForeground() {
        return this.f5672d;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppBackgrounded() {
        Timber.d("++++ MacroDroid - BG", new Object[0]);
        this.f5672d = false;
        g(false);
        this.f5671c = System.currentTimeMillis();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForegrounded() {
        Timber.d("++++ MacroDroid - FG", new Object[0]);
        this.f5672d = true;
        if (f5666j == null) {
            f5666j = this;
        }
        g(true);
        if (!TextUtils.isEmpty(com.arlosoft.macrodroid.settings.Settings.getPassword(this))) {
            int passwordCheckDelaySeconds = com.arlosoft.macrodroid.settings.Settings.getPasswordCheckDelaySeconds(this);
            if (this.f5671c + (passwordCheckDelaySeconds * 1000) < System.currentTimeMillis()) {
                PasswordProtection.INSTANCE.setPasswordRequired();
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        PingConfig.INSTANCE.setHostsList(new ArraySet());
        if (f5666j == null) {
            f5666j = this;
        }
        AndroidThreeTen.init((Application) this);
        FirestoreKt.getFirestore(Firebase.INSTANCE).setFirestoreSettings(new FirebaseFirestoreSettings.Builder().setLocalCacheSettings(FirestoreKt.persistentCacheSettings(b.f5680d)).build());
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new c(null), 2, null);
        Macro.setMacroDroidEnabledState(com.arlosoft.macrodroid.settings.Settings.getMacroDroidEnabled(this));
        FirebaseApp.initializeApp(this);
        h();
        k();
        j();
        m(this);
        FirebaseAnalyticsEventLogger.log("MacroDroid application created");
        if (com.arlosoft.macrodroid.settings.Settings.getLastVersionRun(this) == 0) {
            com.arlosoft.macrodroid.settings.Settings.setFirstVersionRun(this, BuildConfig.VERSION_CODE);
        }
        if (getFreeVersionHelper().haveFreeDaysExpired()) {
            getFreeVersionHelper().displayFreeDaysExpiredNotification();
            com.arlosoft.macrodroid.settings.Settings.setMacroDroidEnabled(this, false);
        } else {
            getFreeVersionHelper().scheduleFreeDaysExpiryAlarm();
            if (com.arlosoft.macrodroid.settings.Settings.getMacroDroidEnabled(this)) {
                SystemLog.logDebug("Starting MacroDroid service");
                try {
                    MacroDroidService.Companion.startService(this);
                    SystemLog.logDebug("After starting MacroDroid service");
                } catch (Exception e4) {
                    FirebaseCrashlytics.getInstance().recordException(e4);
                    SystemLog.logDebug("Service start not allowed: " + e4);
                }
            } else {
                SystemLog.logWarning("MacroDroid is currently disabled by the switch on the home page.");
            }
        }
        Timber.d("++++ APPLICATION - onCreate", new Object[0]);
        this.f5677i = System.currentTimeMillis();
        new Thread() { // from class: com.arlosoft.macrodroid.app.MacroDroidApplication$onCreate$3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                AppCompatDelegate.setDefaultNightMode(Integer.parseInt(com.arlosoft.macrodroid.settings.Settings.getDarkMode(MacroDroidApplication.this)));
            }
        }.start();
        getNotificationChannelUtil().setupNotificationChannels();
        if (com.arlosoft.macrodroid.settings.Settings.getMacroDroidEnabled(this)) {
            Flowable<Boolean> observeOn = this.f5674f.awaitInitFlowable().take(1L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final d dVar = new d();
            Consumer<? super Boolean> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.app.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MacroDroidApplication.p(Function1.this, obj);
                }
            };
            final e eVar = new e();
            observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.app.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MacroDroidApplication.q(Function1.this, obj);
                }
            });
        } else {
            c(false);
        }
        e();
        f();
        TelephonyMonitor.INSTANCE.monitorTelephonyState(this);
        IntentFilter intentFilter = new IntentFilter(HelperCommandsKt.HELPER_SYSTEM_LOG_MESSAGE);
        intentFilter.addAction(HelperCommandsKt.V21_SYSTEM_HELPER_LOG_MESSAGE);
        intentFilter.addAction(HelperCommandsKt.XIAOMI_HELPER_LOG_MESSAGE);
        registerReceiver(new HelperLogMessageBroadcaseReceiver(), intentFilter);
        registerReceiver(new HelperResultsReceiver(), new IntentFilter(HelperCommandsKt.HELPER_COMMAND_RESULT_INTENT_ACTION));
    }

    public final void setAccessibilityServiceMonitor(@NotNull AccessibilityServiceMonitor accessibilityServiceMonitor) {
        Intrinsics.checkNotNullParameter(accessibilityServiceMonitor, "<set-?>");
        this.accessibilityServiceMonitor = accessibilityServiceMonitor;
    }

    public final void setBillingDataSource(@NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(billingDataSource, "<set-?>");
        this.billingDataSource = billingDataSource;
    }

    public final void setCommercialTools(@NotNull CommercialTools commercialTools) {
        Intrinsics.checkNotNullParameter(commercialTools, "<set-?>");
        this.commercialTools = commercialTools;
    }

    public final void setDispatchingAndroidInjector(@NotNull DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
        Intrinsics.checkNotNullParameter(dispatchingAndroidInjector, "<set-?>");
        this.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }

    public final void setExtrasManager(@NotNull ExtrasManager extrasManager) {
        Intrinsics.checkNotNullParameter(extrasManager, "<set-?>");
        this.extrasManager = extrasManager;
    }

    public final void setFlashSaleManager(@NotNull FlashSaleManager flashSaleManager) {
        Intrinsics.checkNotNullParameter(flashSaleManager, "<set-?>");
        this.flashSaleManager = flashSaleManager;
    }

    public final void setForeground(boolean z3) {
        this.f5672d = z3;
    }

    public final void setFreeVersionHelper(@NotNull FreeVersionHelper freeVersionHelper) {
        Intrinsics.checkNotNullParameter(freeVersionHelper, "<set-?>");
        this.freeVersionHelper = freeVersionHelper;
    }

    public final void setNotificationChannelUtil(@NotNull NotificationChannelUtil notificationChannelUtil) {
        Intrinsics.checkNotNullParameter(notificationChannelUtil, "<set-?>");
        this.notificationChannelUtil = notificationChannelUtil;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setPurchaseValidator(@NotNull PurchaseValidator purchaseValidator) {
        Intrinsics.checkNotNullParameter(purchaseValidator, "<set-?>");
        this.purchaseValidator = purchaseValidator;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    /* compiled from: MacroDroidApplication.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AppComponent getAppComponentInstance() {
            AppComponent appComponent = MacroDroidApplication.appComponentInstance;
            if (appComponent != null) {
                return appComponent;
            }
            Intrinsics.throwUninitializedPropertyAccessException("appComponentInstance");
            return null;
        }

        @NotNull
        public final MacroDroidApplication getInstance() {
            MacroDroidApplication macroDroidApplication = get_instance();
            Intrinsics.checkNotNull(macroDroidApplication);
            return macroDroidApplication;
        }

        @Nullable
        public final Locale getLocale() {
            String currentLanguageTag = com.arlosoft.macrodroid.settings.Settings.getCurrentLanguageTag(getInstance());
            if (currentLanguageTag != null) {
                return Locale.forLanguageTag(currentLanguageTag);
            }
            return Locale.getDefault();
        }

        @Nullable
        public final MacroDroidApplication get_instance() {
            return MacroDroidApplication.f5666j;
        }

        public final void setAppComponentInstance(@NotNull AppComponent appComponent) {
            Intrinsics.checkNotNullParameter(appComponent, "<set-?>");
            MacroDroidApplication.appComponentInstance = appComponent;
        }

        public final void setLocale(@Nullable Locale locale) {
            String str;
            MacroDroidApplication companion = getInstance();
            if (locale != null) {
                str = locale.toLanguageTag();
            } else {
                str = null;
            }
            com.arlosoft.macrodroid.settings.Settings.setCurrentLanguageTag(companion, str);
        }

        public final void set_instance(@Nullable MacroDroidApplication macroDroidApplication) {
            MacroDroidApplication.f5666j = macroDroidApplication;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    private final void s() {
    }
}
