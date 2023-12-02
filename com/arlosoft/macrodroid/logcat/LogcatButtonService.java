package com.arlosoft.macrodroid.logcat;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.FloatingButtonsUpdateEvent;
import com.arlosoft.macrodroid.logcat.LogcatMessageSelectActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.LogcatTrigger;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.melnykov.fab.FloatingActionButton;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.e;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatButtonService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LogcatButtonService extends Service {
    @NotNull
    public static final String EXTRA_ENABLED_BUFFERS = "enabled_buffers";
    @NotNull
    public static final String EXTRA_TRIGGER = "trigger";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f12613a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private View f12614b;

    /* renamed from: c  reason: collision with root package name */
    private float f12615c;

    /* renamed from: d  reason: collision with root package name */
    private int f12616d;

    /* renamed from: e  reason: collision with root package name */
    private int f12617e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12618f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12619g;

    /* renamed from: h  reason: collision with root package name */
    private int f12620h;

    /* renamed from: i  reason: collision with root package name */
    private int f12621i;

    /* renamed from: j  reason: collision with root package name */
    private int f12622j;

    /* renamed from: k  reason: collision with root package name */
    private int f12623k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private WindowManager.LayoutParams f12624l;
    @Inject
    public LogcatMessageRepository logcatMessageRepository;

    /* renamed from: m  reason: collision with root package name */
    private LogcatTrigger f12625m;

    /* renamed from: n  reason: collision with root package name */
    private Macro f12626n;

    /* renamed from: o  reason: collision with root package name */
    private int f12627o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12628p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private Job f12629q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private InputStream f12630r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<LogcatMessage> f12631s;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LogcatButtonService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void createService(@NotNull Context context, @NotNull Macro macro, @NotNull LogcatTrigger trigger, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(macro, "macro");
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            Intent intent = new Intent(context, LogcatButtonService.class);
            intent.putExtra("trigger", trigger);
            intent.putExtra("Macro", macro);
            intent.putExtra("enabled_buffers", i4);
            context.startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogcatButtonService.kt */
    @SourceDebugExtension({"SMAP\nLogcatButtonService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogcatButtonService.kt\ncom/arlosoft/macrodroid/logcat/LogcatButtonService$startlogcatCapture$1\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,316:1\n52#2:317\n1#3:318\n1313#4,2:319\n*S KotlinDebug\n*F\n+ 1 LogcatButtonService.kt\ncom/arlosoft/macrodroid/logcat/LogcatButtonService$startlogcatCapture$1\n*L\n274#1:317\n274#1:318\n275#1:319,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LogcatButtonService.kt */
        /* renamed from: com.arlosoft.macrodroid.logcat.LogcatButtonService$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0109a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ LogcatButtonService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0109a(LogcatButtonService logcatButtonService, Continuation<? super C0109a> continuation) {
                super(2, continuation);
                this.this$0 = logcatButtonService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0109a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.stopSelf();
                    this.this$0.d();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0109a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            BufferedReader bufferedReader;
            Sequence<String> take;
            int indexOf$default;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    SystemLog.logInfo("Logcat message capture started");
                    long currentTimeMillis = System.currentTimeMillis();
                    String bufferStringFromEnabledBuffers = LogcatTrigger.Companion.getBufferStringFromEnabledBuffers(LogcatButtonService.this.f12627o);
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("logcat -c -b " + bufferStringFromEnabledBuffers).waitFor();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    SystemLog.logDebugBuildOnly$default("WAITED FOR " + currentTimeMillis2 + TranslateLanguage.MALAY, 0L, null, 6, null);
                    LogcatButtonService logcatButtonService = LogcatButtonService.this;
                    Runtime runtime2 = Runtime.getRuntime();
                    logcatButtonService.f12630r = runtime2.exec("logcat -v tag -b " + bufferStringFromEnabledBuffers).getInputStream();
                    InputStream inputStream = LogcatButtonService.this.f12630r;
                    if (inputStream != null) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                        if (inputStreamReader instanceof BufferedReader) {
                            bufferedReader = (BufferedReader) inputStreamReader;
                        } else {
                            bufferedReader = new BufferedReader(inputStreamReader, 8192);
                        }
                        LogcatButtonService logcatButtonService2 = LogcatButtonService.this;
                        take = SequencesKt___SequencesKt.take(TextStreamsKt.lineSequence(bufferedReader), 2500);
                        for (String str : take) {
                            try {
                                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ":", 0, false, 6, (Object) null);
                                String substring = str.substring(2, indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                String substring2 = str.substring(substring.length() + 4);
                                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                logcatButtonService2.f12631s.add(new LogcatMessage(substring, substring2));
                            } catch (Exception unused) {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader, null);
                    }
                    e.e(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new C0109a(LogcatButtonService.this, null), 2, null);
                } catch (Exception e4) {
                    if (!(e4 instanceof InterruptedIOException)) {
                        SystemLog.logError("Logcat message capture failed: {" + e4 + "}");
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

    public LogcatButtonService() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
        this.f12631s = new ArrayList<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00c6, code lost:
        if (r0 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void a() {
        /*
            r12 = this;
            monitor-enter(r12)
            android.view.View r0 = r12.f12614b     // Catch: java.lang.Throwable -> Ld6
            r1 = 0
            if (r0 == 0) goto L12
            android.view.WindowManager r0 = r12.f12613a     // Catch: java.lang.Exception -> L10 java.lang.Throwable -> Ld6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L10 java.lang.Throwable -> Ld6
            android.view.View r2 = r12.f12614b     // Catch: java.lang.Exception -> L10 java.lang.Throwable -> Ld6
            r0.removeView(r2)     // Catch: java.lang.Exception -> L10 java.lang.Throwable -> Ld6
        L10:
            r12.f12614b = r1     // Catch: java.lang.Throwable -> Ld6
        L12:
            java.lang.String r0 = "window"
            java.lang.Object r0 = r12.getSystemService(r0)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r2 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)     // Catch: java.lang.Throwable -> Ld6
            android.view.WindowManager r0 = (android.view.WindowManager) r0     // Catch: java.lang.Throwable -> Ld6
            r12.f12613a = r0     // Catch: java.lang.Throwable -> Ld6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Throwable -> Ld6
            android.view.Display r0 = r0.getDefaultDisplay()     // Catch: java.lang.Throwable -> Ld6
            int r0 = r0.getWidth()     // Catch: java.lang.Throwable -> Ld6
            r12.f12616d = r0     // Catch: java.lang.Throwable -> Ld6
            android.view.WindowManager r0 = r12.f12613a     // Catch: java.lang.Throwable -> Ld6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Throwable -> Ld6
            android.view.Display r0 = r0.getDefaultDisplay()     // Catch: java.lang.Throwable -> Ld6
            int r0 = r0.getHeight()     // Catch: java.lang.Throwable -> Ld6
            com.arlosoft.macrodroid.settings.Settings.getDisabledCategories(r12)     // Catch: java.lang.Throwable -> Ld6
            int r2 = r12.f12616d     // Catch: java.lang.Throwable -> Ld6
            android.content.res.Resources r2 = r12.getResources()     // Catch: java.lang.Throwable -> Ld6
            r3 = 2131165383(0x7f0700c7, float:1.7944982E38)
            int r2 = r2.getDimensionPixelSize(r3)     // Catch: java.lang.Throwable -> Ld6
            r12.f12617e = r2     // Catch: java.lang.Throwable -> Ld6
            android.graphics.Point r2 = new android.graphics.Point     // Catch: java.lang.Throwable -> Ld6
            int r0 = -r0
            int r0 = r0 / 6
            r3 = 0
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> Ld6
            android.view.WindowManager$LayoutParams r0 = new android.view.WindowManager$LayoutParams     // Catch: java.lang.Throwable -> Ld6
            int r6 = r12.f12617e     // Catch: java.lang.Throwable -> Ld6
            int r7 = r2.x     // Catch: java.lang.Throwable -> Ld6
            int r8 = r2.y     // Catch: java.lang.Throwable -> Ld6
            int r9 = com.arlosoft.macrodroid.utils.OverlayUtils.getOverlayType()     // Catch: java.lang.Throwable -> Ld6
            r10 = 786472(0xc0028, float:1.102082E-39)
            r11 = -3
            r4 = r0
            r5 = r6
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Ld6
            r12.f12624l = r0     // Catch: java.lang.Throwable -> Ld6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Throwable -> Ld6
            r2 = 2132017516(0x7f14016c, float:1.9673313E38)
            r0.windowAnimations = r2     // Catch: java.lang.Throwable -> Ld6
            android.content.Context r0 = r12.getBaseContext()     // Catch: java.lang.Throwable -> Ld6
            r2 = 2131558761(0x7f0d0169, float:1.8742847E38)
            android.view.View r0 = android.view.View.inflate(r0, r2, r1)     // Catch: java.lang.Throwable -> Ld6
            r12.f12614b = r0     // Catch: java.lang.Throwable -> Ld6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Throwable -> Ld6
            r1 = 2131362884(0x7f0a0444, float:1.8345561E38)
            android.view.View r0 = r0.findViewById(r1)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r1 = "floatingView!!.findViewById(R.id.fab)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Throwable -> Ld6
            com.melnykov.fab.FloatingActionButton r0 = (com.melnykov.fab.FloatingActionButton) r0     // Catch: java.lang.Throwable -> Ld6
            r1 = 2131100119(0x7f0601d7, float:1.781261E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r12, r1)     // Catch: java.lang.Throwable -> Ld6
            r0.setColorNormal(r2)     // Catch: java.lang.Throwable -> Ld6
            r2 = 2131100120(0x7f0601d8, float:1.7812612E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r12, r2)     // Catch: java.lang.Throwable -> Ld6
            r0.setColorRipple(r2)     // Catch: java.lang.Throwable -> Ld6
            int r1 = androidx.core.content.ContextCompat.getColor(r12, r1)     // Catch: java.lang.Throwable -> Ld6
            r0.setColorPressed(r1)     // Catch: java.lang.Throwable -> Ld6
            r1 = 2131231225(0x7f0801f9, float:1.8078525E38)
            r0.setImageResource(r1)     // Catch: java.lang.Throwable -> Ld6
            com.arlosoft.macrodroid.logcat.LogcatButtonService$configureFloatingButtons$1 r1 = new com.arlosoft.macrodroid.logcat.LogcatButtonService$configureFloatingButtons$1     // Catch: java.lang.Throwable -> Ld6
            r1.<init>()     // Catch: java.lang.Throwable -> Ld6
            r0.setOnTouchListener(r1)     // Catch: java.lang.Throwable -> Ld6
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ld6
            r1 = 23
            if (r0 < r1) goto Lc8
            boolean r0 = com.arlosoft.macrodroid.action.wq.a(r12)     // Catch: java.lang.Throwable -> Ld6
            if (r0 == 0) goto Ld4
        Lc8:
            android.view.WindowManager r0 = r12.f12613a     // Catch: java.lang.Exception -> Ld4 java.lang.Throwable -> Ld6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> Ld4 java.lang.Throwable -> Ld6
            android.view.View r1 = r12.f12614b     // Catch: java.lang.Exception -> Ld4 java.lang.Throwable -> Ld6
            android.view.WindowManager$LayoutParams r2 = r12.f12624l     // Catch: java.lang.Exception -> Ld4 java.lang.Throwable -> Ld6
            r0.addView(r1, r2)     // Catch: java.lang.Exception -> Ld4 java.lang.Throwable -> Ld6
        Ld4:
            monitor-exit(r12)
            return
        Ld6:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logcat.LogcatButtonService.a():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (!this.f12619g) {
            this.f12619g = true;
            View view = this.f12614b;
            Intrinsics.checkNotNull(view);
            View findViewById = view.findViewById(R.id.fab);
            Intrinsics.checkNotNullExpressionValue(findViewById, "floatingView!!.findViewById(R.id.fab)");
            ((FloatingActionButton) findViewById).setImageResource(R.drawable.material_ic_stop_24px_svg);
            ToastCompat.makeText(this, (int) R.string.capturing_logcat_message_hit_stop_when_done, 1).show();
            c();
            return;
        }
        stopSelf();
        d();
    }

    private final void c() {
        Job e4;
        this.f12631s.clear();
        Job job = this.f12629q;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        e4 = e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
        this.f12629q = e4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void d() {
        if (!this.f12628p) {
            LogcatTrigger logcatTrigger = null;
            try {
                InputStream inputStream = this.f12630r;
                if (inputStream != null) {
                    inputStream.close();
                }
                Job job = this.f12629q;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.f12629q = null;
                this.f12630r = null;
                SystemLog.logInfo("Logcat message capture ended");
            } catch (Exception e4) {
                FirebaseCrashlytics.getInstance().recordException(e4);
                SystemLog.logError("Closing logcat message capture failed: " + e4);
            }
            getLogcatMessageRepository().setLogcatMessageList(this.f12631s);
            LogcatMessageSelectActivity.Companion companion = LogcatMessageSelectActivity.Companion;
            Macro macro = this.f12626n;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            LogcatTrigger logcatTrigger2 = this.f12625m;
            if (logcatTrigger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("trigger");
            } else {
                logcatTrigger = logcatTrigger2;
            }
            companion.createInstance(this, macro, logcatTrigger, this.f12627o);
            this.f12628p = true;
        }
    }

    @NotNull
    public final LogcatMessageRepository getLogcatMessageRepository() {
        LogcatMessageRepository logcatMessageRepository = this.logcatMessageRepository;
        if (logcatMessageRepository != null) {
            return logcatMessageRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logcatMessageRepository");
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public final WindowManager.LayoutParams getParams() {
        return this.f12624l;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        EventBusUtils.getEventBus().register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        if (this.f12614b != null) {
            try {
                WindowManager windowManager = this.f12613a;
                Intrinsics.checkNotNull(windowManager);
                windowManager.removeView(this.f12614b);
            } catch (Exception unused) {
            }
        }
        super.onDestroy();
    }

    public final void onEventMainThread(@Nullable FloatingButtonsUpdateEvent floatingButtonsUpdateEvent) {
        a();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("Macro");
            Intrinsics.checkNotNull(parcelableExtra);
            this.f12626n = (Macro) parcelableExtra;
            Parcelable parcelableExtra2 = intent.getParcelableExtra("trigger");
            Intrinsics.checkNotNull(parcelableExtra2);
            this.f12625m = (LogcatTrigger) parcelableExtra2;
            this.f12627o = intent.getIntExtra("enabled_buffers", 0);
            this.f12615c = TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
            a();
            return 3;
        }
        return 3;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@NotNull Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        stopSelf();
    }

    public final void setLogcatMessageRepository(@NotNull LogcatMessageRepository logcatMessageRepository) {
        Intrinsics.checkNotNullParameter(logcatMessageRepository, "<set-?>");
        this.logcatMessageRepository = logcatMessageRepository;
    }

    public final void setParams(@Nullable WindowManager.LayoutParams layoutParams) {
        this.f12624l = layoutParams;
    }
}
