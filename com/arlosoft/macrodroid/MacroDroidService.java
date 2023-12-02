package com.arlosoft.macrodroid;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NotificationUtil;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.Debouncer;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class MacroDroidService extends Service {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2007a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2008b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static Thread f2009c;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Debouncer f2010d = new Debouncer();

    /* compiled from: MacroDroidService.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MacroDroidService.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$context = context;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$context, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Notification b4;
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Settings.getShowLastRunMacrosInNotification(this.$context) && !Settings.getShowNotificationButtonBar(this.$context) && (b4 = MacroDroidService.Companion.b(this.$context)) != null) {
                        try {
                            Object systemService = this.$context.getSystemService("notification");
                            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                            ((NotificationManager) systemService).notify(Util.PERSISTENT_NOTIFICATION_ID, b4);
                        } catch (Exception e4) {
                            SystemLog.logError("Failed to update notification: " + e4);
                            FirebaseAnalyticsEventLogger.logHandledException(e4);
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MacroDroidService.kt */
        /* loaded from: classes2.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $canLog;
            final /* synthetic */ Context $context;
            final /* synthetic */ boolean $updateAll;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(boolean z3, Context context, boolean z4, Continuation<? super b> continuation) {
                super(2, continuation);
                this.$updateAll = z3;
                this.$context = context;
                this.$canLog = z4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.$updateAll, this.$context, this.$canLog, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Notification b4;
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if ((this.$updateAll || (!Settings.getShowNotificationButtonBar(this.$context) && Settings.getShowLastRunMacrosInNotification(this.$context))) && (b4 = MacroDroidService.Companion.b(this.$context)) != null) {
                        try {
                            if (this.$canLog) {
                                SystemLog.logVerbose("Updating MacroDroid notification bar");
                            }
                            Object systemService = this.$context.getSystemService("notification");
                            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                            ((NotificationManager) systemService).notify(Util.PERSISTENT_NOTIFICATION_ID, b4);
                        } catch (Exception e4) {
                            SystemLog.logError("Failed to update notification: " + e4);
                            FirebaseAnalyticsEventLogger.logHandledException(e4);
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Notification b(Context context) {
            String macroDroidIconResourceName = Settings.getMacroDroidIconResourceName(context);
            String macroDroidIconTextString = Settings.getMacroDroidIconTextString(context);
            int resId = Util.getResId(context, macroDroidIconResourceName);
            if (resId == -1) {
                resId = Settings.getMacroDroidIcon(context);
            }
            try {
                context.getResources().getResourceName(resId);
            } catch (Resources.NotFoundException unused) {
                resId = R.drawable.active_icon_new;
            }
            if (Build.VERSION.SDK_INT < 26 && Settings.getForceHideIcon(context)) {
                long forceHideLastDisplayed = Settings.getForceHideLastDisplayed(context);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > forceHideLastDisplayed + 86400000) {
                    SystemLog.logWarning("<WARNING> - Force Hide Icon is enabled, please disable this if you see any issues");
                    Settings.setForceHideLastDisplayed(context, currentTimeMillis);
                }
                return null;
            }
            int notificationPriority = Settings.getNotificationPriority(context);
            if (Settings.getShowNotificationButtonBar(context)) {
                return NotificationUtil.constructNotification(context, resId, macroDroidIconTextString, notificationPriority, Constants.NOTIFICATION_CHANNEL_PERSISTENT);
            }
            return NotificationUtil.createClassicNotificationBar(context, resId, macroDroidIconTextString, notificationPriority, Constants.NOTIFICATION_CHANNEL_PERSISTENT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(boolean z3, Context context, boolean z4) {
            Intrinsics.checkNotNullParameter(context, "$context");
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new b(z3, context, z4, null), 2, null);
        }

        public static /* synthetic */ void updateNotification$default(Companion companion, Context context, boolean z3, boolean z4, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                z4 = true;
            }
            companion.updateNotification(context, z3, z4);
        }

        @NotNull
        public final Debouncer getUpdateNotificationDebouncer() {
            return MacroDroidService.f2010d;
        }

        @JvmStatic
        public final void startService(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Thread thread = MacroDroidService.f2009c;
            if (thread != null) {
                thread.interrupt();
            }
            Intent intent = new Intent(context.getApplicationContext(), MacroDroidService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                context.getApplicationContext().startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }

        @JvmStatic
        public final void stopService(@NotNull final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            final Intent intent = new Intent(context.getApplicationContext(), MacroDroidService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                MacroDroidService.f2009c = new Thread() { // from class: com.arlosoft.macrodroid.MacroDroidService$Companion$stopService$1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        boolean z3;
                        for (int i4 = 0; i4 < 20 && isAlive(); i4++) {
                            try {
                                z3 = MacroDroidService.f2007a;
                                if (z3) {
                                    context.getApplicationContext().stopService(intent);
                                    return;
                                }
                                Thread.sleep(100L);
                            } catch (InterruptedException | Exception unused) {
                                return;
                            }
                        }
                    }
                };
                Thread thread = MacroDroidService.f2009c;
                if (thread != null) {
                    thread.start();
                    return;
                }
                return;
            }
            context.getApplicationContext().stopService(intent);
        }

        @JvmStatic
        @Nullable
        public final Object updateLastRunTimeNotification(@NotNull Context context, @NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new a(context, null), continuation);
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }

        @JvmStatic
        public final void updateNotification(@NotNull final Context context, final boolean z3, final boolean z4) {
            Intrinsics.checkNotNullParameter(context, "context");
            getUpdateNotificationDebouncer().debounce(Void.class, new Runnable() { // from class: com.arlosoft.macrodroid.d0
                @Override // java.lang.Runnable
                public final void run() {
                    MacroDroidService.Companion.c(z3, context, z4);
                }
            }, 250L, TimeUnit.MILLISECONDS);
        }
    }

    @JvmStatic
    public static final void startService(@NotNull Context context) {
        Companion.startService(context);
    }

    @JvmStatic
    public static final void stopService(@NotNull Context context) {
        Companion.stopService(context);
    }

    @JvmStatic
    @Nullable
    public static final Object updateLastRunTimeNotification(@NotNull Context context, @NotNull Continuation<? super Unit> continuation) {
        return Companion.updateLastRunTimeNotification(context, continuation);
    }

    @JvmStatic
    public static final void updateNotification(@NotNull Context context, boolean z3, boolean z4) {
        Companion.updateNotification(context, z3, z4);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f2008b = true;
        SystemLog.logDebug("MacroDroidService - onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SystemLog.logDebug("MacroDroidService is being destroyed");
        f2007a = false;
        f2008b = false;
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        SystemLog.logDebug("MacroDroidService - onStartCommand");
        Notification b4 = Companion.b(this);
        if (b4 != null) {
            startForeground(Util.PERSISTENT_NOTIFICATION_ID, b4);
            SystemLog.logDebug("After call to startForeground");
            f2007a = true;
        } else if (Build.VERSION.SDK_INT >= 26) {
            FirebaseAnalyticsEventLogger.logHandledException(new Exception("Create Notification returned null"));
        }
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.arlosoft.macrodroid.app.MacroDroidApplication");
        ((MacroDroidApplication) application).getServiceInitialisation().notifyServiceInitialised();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        String action;
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (Exception unused) {
                return;
            }
        } else {
            action = null;
        }
        if (!Intrinsics.areEqual(action, "android.intent.action.MAIN")) {
            SystemLog.logVerbose("MacroDroid service task removed - attempting restart mechanism");
            Intent intent2 = new Intent(this, DummyActivity.class);
            intent2.addFlags(268435456);
            startActivity(intent2);
        }
    }
}
