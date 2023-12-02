package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.services.ScreenContentElement;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.database.FloatingTextData;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.anko.AsyncKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewIdOverlayService.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nViewIdOverlayService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewIdOverlayService.kt\ncom/arlosoft/macrodroid/triggers/services/ViewIdOverlayService\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,296:1\n177#2,2:297\n1855#3,2:299\n*S KotlinDebug\n*F\n+ 1 ViewIdOverlayService.kt\ncom/arlosoft/macrodroid/triggers/services/ViewIdOverlayService\n*L\n181#1:297,2\n260#1:299,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ViewIdOverlayService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f15551a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<FloatingView> f15552b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private float f15553c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Database f15554d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private View f15555e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15556f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private WindowManager.LayoutParams f15557g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final Timer f15558h;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ViewIdOverlayService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void showOveraly(@NotNull Context context, @NotNull List<ScreenContentElement> viewList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewList, "viewList");
            try {
                Intent intent = new Intent(context, ViewIdOverlayService.class);
                intent.putExtra("view_list", new ArrayList(viewList));
                context.startService(intent);
            } catch (IllegalStateException unused) {
                SystemLog.logError("Failed to refresh floating text view, the app does not have permission to display overlays");
            }
        }

        @JvmStatic
        public final void stopService(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Database.getInstance().hideAllFloatingTexts();
            MacroStore.getInstance().removeAllFloatingTextInstances();
            context.getApplicationContext().stopService(new Intent(context.getApplicationContext(), FloatingTextService.class));
        }
    }

    /* compiled from: ViewIdOverlayService.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewTextPair {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final FloatingView f15559a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final FloatingTextData f15560b;

        public ViewTextPair(@NotNull FloatingView view, @NotNull FloatingTextData text) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            this.f15559a = view;
            this.f15560b = text;
        }

        public static /* synthetic */ ViewTextPair copy$default(ViewTextPair viewTextPair, FloatingView floatingView, FloatingTextData floatingTextData, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                floatingView = viewTextPair.f15559a;
            }
            if ((i4 & 2) != 0) {
                floatingTextData = viewTextPair.f15560b;
            }
            return viewTextPair.copy(floatingView, floatingTextData);
        }

        @NotNull
        public final FloatingView component1() {
            return this.f15559a;
        }

        @NotNull
        public final FloatingTextData component2() {
            return this.f15560b;
        }

        @NotNull
        public final ViewTextPair copy(@NotNull FloatingView view, @NotNull FloatingTextData text) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            return new ViewTextPair(view, text);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewTextPair)) {
                return false;
            }
            ViewTextPair viewTextPair = (ViewTextPair) obj;
            if (Intrinsics.areEqual(this.f15559a, viewTextPair.f15559a) && Intrinsics.areEqual(this.f15560b, viewTextPair.f15560b)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final FloatingTextData getText() {
            return this.f15560b;
        }

        @NotNull
        public final FloatingView getView() {
            return this.f15559a;
        }

        public int hashCode() {
            return (this.f15559a.hashCode() * 31) + this.f15560b.hashCode();
        }

        @NotNull
        public String toString() {
            FloatingView floatingView = this.f15559a;
            FloatingTextData floatingTextData = this.f15560b;
            return "ViewTextPair(view=" + floatingView + ", text=" + floatingTextData + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewIdOverlayService.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Context, Unit> {
        final /* synthetic */ FloatingView $floatingView;
        final /* synthetic */ String $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FloatingView floatingView, String str) {
            super(1);
            this.$floatingView = floatingView;
            this.$text = str;
        }

        public final void a(@NotNull Context runOnUiThread) {
            Intrinsics.checkNotNullParameter(runOnUiThread, "$this$runOnUiThread");
            if (!Intrinsics.areEqual(this.$floatingView.getTextView().getText(), this.$text)) {
                this.$floatingView.getTextView().setText(this.$text);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Context context) {
            a(context);
            return Unit.INSTANCE;
        }
    }

    public ViewIdOverlayService() {
        Database database = Database.getInstance();
        Intrinsics.checkNotNullExpressionValue(database, "getInstance()");
        this.f15554d = database;
        this.f15558h = new Timer();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:25|(2:27|(2:29|30))|31|32|34|(1:36)|37|38|30|23) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a8, code lost:
        com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError("Failed to add floating text: " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(java.util.List<com.arlosoft.macrodroid.action.services.ScreenContentElement> r14) {
        /*
            r13 = this;
            java.util.List<com.arlosoft.macrodroid.triggers.services.FloatingView> r0 = r13.f15552b
            monitor-enter(r0)
            java.util.List<com.arlosoft.macrodroid.triggers.services.FloatingView> r1 = r13.f15552b     // Catch: java.lang.Throwable -> Lbf
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Lbf
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Lbf
            r3 = 0
            if (r2 == 0) goto L29
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Lbf
            com.arlosoft.macrodroid.triggers.services.FloatingView r2 = (com.arlosoft.macrodroid.triggers.services.FloatingView) r2     // Catch: java.lang.Throwable -> Lbf
            android.view.WindowManager r4 = r13.f15551a     // Catch: java.lang.Exception -> L9 java.lang.Throwable -> Lbf
            if (r4 != 0) goto L20
            java.lang.String r4 = "windowManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)     // Catch: java.lang.Exception -> L9 java.lang.Throwable -> Lbf
            goto L21
        L20:
            r3 = r4
        L21:
            android.view.View r2 = r2.getContainer()     // Catch: java.lang.Exception -> L9 java.lang.Throwable -> Lbf
            r3.removeView(r2)     // Catch: java.lang.Exception -> L9 java.lang.Throwable -> Lbf
            goto L9
        L29:
            java.util.List<com.arlosoft.macrodroid.triggers.services.FloatingView> r1 = r13.f15552b     // Catch: java.lang.Throwable -> Lbf
            r1.clear()     // Catch: java.lang.Throwable -> Lbf
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lbf
            monitor-exit(r0)
            java.util.Iterator r14 = r14.iterator()
        L35:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto Lbe
            java.lang.Object r0 = r14.next()
            com.arlosoft.macrodroid.action.services.ScreenContentElement r0 = (com.arlosoft.macrodroid.action.services.ScreenContentElement) r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L4d
            boolean r1 = com.arlosoft.macrodroid.action.wq.a(r13)
            if (r1 == 0) goto L35
        L4d:
            android.widget.TextView r1 = new android.widget.TextView     // Catch: java.lang.Exception -> La7
            r1.<init>(r13)     // Catch: java.lang.Exception -> La7
            java.lang.String r2 = r0.getViewId()     // Catch: java.lang.Exception -> La7
            r1.setText(r2)     // Catch: java.lang.Exception -> La7
            r2 = 150(0x96, float:2.1E-43)
            r4 = 0
            int r2 = android.graphics.Color.argb(r2, r4, r4, r4)     // Catch: java.lang.Exception -> La7
            r1.setBackgroundColor(r2)     // Catch: java.lang.Exception -> La7
            r2 = -1
            r1.setTextColor(r2)     // Catch: java.lang.Exception -> La7
            r2 = 2
            r4 = 1094713344(0x41400000, float:12.0)
            r1.setTextSize(r2, r4)     // Catch: java.lang.Exception -> La7
            android.view.WindowManager$LayoutParams r2 = new android.view.WindowManager$LayoutParams     // Catch: java.lang.Exception -> La7
            r6 = -2
            r7 = -2
            android.graphics.Rect r4 = r0.getBounds()     // Catch: java.lang.Exception -> La7
            int r8 = r4.centerX()     // Catch: java.lang.Exception -> La7
            android.graphics.Rect r0 = r0.getBounds()     // Catch: java.lang.Exception -> La7
            int r9 = r0.centerY()     // Catch: java.lang.Exception -> La7
            int r10 = com.arlosoft.macrodroid.utils.OverlayUtils.getOverlayType()     // Catch: java.lang.Exception -> La7
            r11 = 786472(0xc0028, float:1.102082E-39)
            r12 = -3
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> La7
            r13.f15557g = r2     // Catch: java.lang.Exception -> La7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch: java.lang.Exception -> La7
            r0 = 8388659(0x800033, float:1.1755015E-38)
            r2.gravity = r0     // Catch: java.lang.Exception -> La7
            android.view.WindowManager r0 = r13.f15551a     // Catch: java.lang.Exception -> La7
            if (r0 != 0) goto La1
            java.lang.String r0 = "windowManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> La7
            r0 = r3
        La1:
            android.view.WindowManager$LayoutParams r2 = r13.f15557g     // Catch: java.lang.Exception -> La7
            r0.addView(r1, r2)     // Catch: java.lang.Exception -> La7
            goto L35
        La7:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to add floating text: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r0)
            goto L35
        Lbe:
            return
        Lbf:
            r14 = move-exception
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.ViewIdOverlayService.a(java.util.List):void");
    }

    private final void b() {
        if (this.f15555e != null) {
            try {
                WindowManager windowManager = this.f15551a;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                windowManager.removeView(this.f15555e);
            } catch (Exception unused) {
            }
            this.f15555e = null;
        }
    }

    private final void c(FloatingView floatingView, FloatingTextData floatingTextData) {
        this.f15554d.hideFloatingText(floatingView.getId());
        WindowManager windowManager = this.f15551a;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            windowManager = null;
        }
        windowManager.removeView(floatingView.getContainer());
        synchronized (this.f15552b) {
            this.f15552b.remove(floatingView);
            if (this.f15552b.isEmpty()) {
                stopSelf();
            }
            Unit unit = Unit.INSTANCE;
        }
        MacroStore.getInstance().removeFloatingTextInstance(floatingTextData.getMacroId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        List<FloatingTextData> floatingTexts = this.f15554d.getFloatingTexts(true);
        ArrayList<ViewTextPair> arrayList = new ArrayList();
        for (FloatingTextData floatingText : floatingTexts) {
            if (floatingText.isVisible()) {
                synchronized (this.f15552b) {
                    for (FloatingView floatingView : this.f15552b) {
                        if (Intrinsics.areEqual(floatingView.getId(), floatingText.getId())) {
                            if (floatingText.getAutoHideDelay() > 0 && floatingText.getAutoHideDelay() + floatingText.getDisplayedTimestamp() < System.currentTimeMillis()) {
                                Intrinsics.checkNotNullExpressionValue(floatingText, "floatingText");
                                arrayList.add(new ViewTextPair(floatingView, floatingText));
                            } else {
                                Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(floatingText.getMacroId());
                                if (macroByGUID == null) {
                                    macroByGUID = MacroStore.getInstance().getMacroFloatingTextInstanceByGUID(floatingText.getMacroId());
                                }
                                AsyncKt.runOnUiThread(this, new a(floatingView, MagicText.replaceMagicText(this, floatingText.getText(), floatingText.getTriggerContextInfo(), macroByGUID)));
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        for (ViewTextPair viewTextPair : arrayList) {
            c(viewTextPair.getView(), viewTextPair.getText());
        }
    }

    @JvmStatic
    public static final void showOveraly(@NotNull Context context, @NotNull List<ScreenContentElement> list) {
        Companion.showOveraly(context, list);
    }

    @JvmStatic
    public static final void stopService(@NotNull Context context) {
        Companion.stopService(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public final WindowManager.LayoutParams getParams() {
        return this.f15557g;
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
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f15551a = (WindowManager) systemService;
        this.f15556f = true;
        this.f15558h.scheduleAtFixedRate(new TimerTask() { // from class: com.arlosoft.macrodroid.triggers.services.ViewIdOverlayService$onCreate$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ViewIdOverlayService.this.d();
            }
        }, 0L, 1000L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15556f = false;
        this.f15558h.cancel();
        b();
        synchronized (this.f15552b) {
            for (FloatingView floatingView : this.f15552b) {
                try {
                    WindowManager windowManager = this.f15551a;
                    if (windowManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                        windowManager = null;
                    }
                    windowManager.removeView(floatingView.getContainer());
                } catch (Exception unused) {
                }
            }
            this.f15552b.clear();
            Unit unit = Unit.INSTANCE;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        ArrayList arrayList;
        this.f15553c = IntExtensionsKt.getPx(5);
        if (intent != null) {
            arrayList = intent.getParcelableArrayListExtra("view_list");
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            a(arrayList);
            return 1;
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@NotNull Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        stopSelf();
    }

    public final void setParams(@Nullable WindowManager.LayoutParams layoutParams) {
        this.f15557g = layoutParams;
    }
}
