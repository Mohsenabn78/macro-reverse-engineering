package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.IBinder;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.database.FloatingTextData;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.utils.OverlayUtils;
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
import kotlin.text.m;
import org.jetbrains.anko.AsyncKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextService.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFloatingTextService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTextService.kt\ncom/arlosoft/macrodroid/triggers/services/FloatingTextService\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,435:1\n68#2,2:436\n262#2,2:438\n71#2:440\n40#2:441\n56#2:442\n75#2:443\n177#2,2:444\n1855#3,2:446\n*S KotlinDebug\n*F\n+ 1 FloatingTextService.kt\ncom/arlosoft/macrodroid/triggers/services/FloatingTextService\n*L\n144#1:436,2\n160#1:438,2\n144#1:440\n144#1:441\n144#1:442\n144#1:443\n315#1:444,2\n399#1:446,2\n*E\n"})
/* loaded from: classes3.dex */
public final class FloatingTextService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f15451a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<FloatingView> f15452b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private float f15453c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Database f15454d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private View f15455e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15456f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15457g;

    /* renamed from: h  reason: collision with root package name */
    private int f15458h;

    /* renamed from: i  reason: collision with root package name */
    private int f15459i;

    /* renamed from: j  reason: collision with root package name */
    private int f15460j;

    /* renamed from: k  reason: collision with root package name */
    private int f15461k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private WindowManager.LayoutParams f15462l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final Timer f15463m;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FloatingTextService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void refreshTextViews(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                context.startService(new Intent(context, FloatingTextService.class));
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

    /* compiled from: FloatingTextService.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewTextPair {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final FloatingView f15469a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final FloatingTextData f15470b;

        public ViewTextPair(@NotNull FloatingView view, @NotNull FloatingTextData text) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            this.f15469a = view;
            this.f15470b = text;
        }

        public static /* synthetic */ ViewTextPair copy$default(ViewTextPair viewTextPair, FloatingView floatingView, FloatingTextData floatingTextData, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                floatingView = viewTextPair.f15469a;
            }
            if ((i4 & 2) != 0) {
                floatingTextData = viewTextPair.f15470b;
            }
            return viewTextPair.copy(floatingView, floatingTextData);
        }

        @NotNull
        public final FloatingView component1() {
            return this.f15469a;
        }

        @NotNull
        public final FloatingTextData component2() {
            return this.f15470b;
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
            if (Intrinsics.areEqual(this.f15469a, viewTextPair.f15469a) && Intrinsics.areEqual(this.f15470b, viewTextPair.f15470b)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final FloatingTextData getText() {
            return this.f15470b;
        }

        @NotNull
        public final FloatingView getView() {
            return this.f15469a;
        }

        public int hashCode() {
            return (this.f15469a.hashCode() * 31) + this.f15470b.hashCode();
        }

        @NotNull
        public String toString() {
            FloatingView floatingView = this.f15469a;
            FloatingTextData floatingTextData = this.f15470b;
            return "ViewTextPair(view=" + floatingView + ", text=" + floatingTextData + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingTextService.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Context, Unit> {
        final /* synthetic */ FloatingTextData $floatingText;
        final /* synthetic */ FloatingView $floatingView;
        final /* synthetic */ String $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FloatingView floatingView, String str, FloatingTextData floatingTextData) {
            super(1);
            this.$floatingView = floatingView;
            this.$text = str;
            this.$floatingText = floatingTextData;
        }

        public final void a(@NotNull Context runOnUiThread) {
            CharSequence charSequence;
            Intrinsics.checkNotNullParameter(runOnUiThread, "$this$runOnUiThread");
            if (!Intrinsics.areEqual(this.$floatingView.getTextView().getText(), this.$text)) {
                TextView textView = this.$floatingView.getTextView();
                if (this.$floatingText.getHtmlFormatting()) {
                    charSequence = Html.fromHtml(this.$text);
                } else {
                    charSequence = this.$text;
                }
                textView.setText(charSequence);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Context context) {
            a(context);
            return Unit.INSTANCE;
        }
    }

    public FloatingTextService() {
        Database database = Database.getInstance();
        Intrinsics.checkNotNullExpressionValue(database, "getInstance()");
        this.f15454d = database;
        this.f15463m = new Timer();
    }

    private final void a(FloatingTextData floatingTextData, TextView textView) {
        String replace$default;
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(floatingTextData.getMacroId());
        if (macroByGUID == null) {
            macroByGUID = MacroStore.getInstance().getMacroFloatingTextInstanceByGUID(floatingTextData.getMacroId());
        }
        String replaceMagicText = MagicText.replaceMagicText(this, floatingTextData.getText(), floatingTextData.getTriggerContextInfo(), macroByGUID);
        Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(this, f…riggerContextInfo, macro)");
        replace$default = m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
        Spanned spanned = replace$default;
        if (floatingTextData.getHtmlFormatting()) {
            spanned = Html.fromHtml(replace$default);
        }
        textView.setText(spanned);
        int alignemnt = floatingTextData.getAlignemnt();
        int i4 = 1;
        if (alignemnt != 0) {
            if (alignemnt != 1) {
                if (alignemnt == 2) {
                    i4 = 5;
                }
            } else {
                i4 = 3;
            }
        }
        textView.setGravity(i4);
        textView.setTextColor(floatingTextData.getTextColor());
        textView.setTextSize(2, floatingTextData.getTextSize());
        int px = IntExtensionsKt.getPx(floatingTextData.getPadding());
        textView.setPadding(px, px, px, px);
        textView.setAlpha(floatingTextData.getAlpha() / 100.0f);
        e(textView, floatingTextData.getCorners(), floatingTextData.getBgColor());
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01dc, code lost:
        if (r0 != false) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.WindowManager] */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.WindowManager] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b() {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.FloatingTextService.b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (this.f15455e != null) {
            try {
                WindowManager windowManager = this.f15451a;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                windowManager.removeView(this.f15455e);
            } catch (Exception unused) {
            }
            this.f15455e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(FloatingView floatingView, FloatingTextData floatingTextData) {
        this.f15454d.hideFloatingText(floatingView.getId());
        try {
            WindowManager windowManager = this.f15451a;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            windowManager.removeView(floatingView.getContainer());
        } catch (Exception unused) {
        }
        synchronized (this.f15452b) {
            this.f15452b.remove(floatingView);
            if (this.f15452b.isEmpty()) {
                stopSelf();
            }
            Unit unit = Unit.INSTANCE;
        }
        MacroStore.getInstance().removeFloatingTextInstance(floatingTextData.getMacroId());
    }

    private final void e(TextView textView, int i4, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(IntExtensionsKt.getPx(i4));
        gradientDrawable.setColor(i5);
        textView.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(float f4, int i4, boolean z3) {
        int i5;
        if (this.f15455e == null) {
            WindowManager windowManager = null;
            this.f15455e = View.inflate(getBaseContext(), R.layout.floating_button_delete, null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, (((int) f4) / 2) - IntExtensionsKt.getPx(48), OverlayUtils.getOverlayType(), i4, -3);
            layoutParams.windowAnimations = R.style.FloatingButtonAnimation;
            WindowManager windowManager2 = this.f15451a;
            if (windowManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            } else {
                windowManager = windowManager2;
            }
            windowManager.addView(this.f15455e, layoutParams);
        }
        View view = this.f15455e;
        if (view != null) {
            if (z3) {
                i5 = R.drawable.floating_button_delete_active_background;
            } else {
                i5 = R.drawable.floating_button_delete_background;
            }
            view.setBackgroundResource(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(FloatingTextService floatingTextService, float f4, int i4, boolean z3, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        floatingTextService.f(f4, i4, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        String replace$default;
        List<FloatingTextData> floatingTexts = this.f15454d.getFloatingTexts(true);
        ArrayList<ViewTextPair> arrayList = new ArrayList();
        for (FloatingTextData floatingText : floatingTexts) {
            if (floatingText.isVisible()) {
                synchronized (this.f15452b) {
                    for (FloatingView floatingView : this.f15452b) {
                        if (Intrinsics.areEqual(floatingView.getId(), floatingText.getId())) {
                            if (floatingText.getAutoHideDelay() > 0 && floatingText.getAutoHideDelay() + floatingText.getDisplayedTimestamp() < System.currentTimeMillis()) {
                                Intrinsics.checkNotNullExpressionValue(floatingText, "floatingText");
                                arrayList.add(new ViewTextPair(floatingView, floatingText));
                            } else {
                                Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(floatingText.getMacroId());
                                if (macroByGUID == null) {
                                    macroByGUID = MacroStore.getInstance().getMacroFloatingTextInstanceByGUID(floatingText.getMacroId());
                                }
                                String replaceMagicText = MagicText.replaceMagicText(this, floatingText.getText(), floatingText.getTriggerContextInfo(), macroByGUID);
                                Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(this, f…riggerContextInfo, macro)");
                                replace$default = m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
                                AsyncKt.runOnUiThread(this, new a(floatingView, replace$default, floatingText));
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        for (ViewTextPair viewTextPair : arrayList) {
            d(viewTextPair.getView(), viewTextPair.getText());
        }
    }

    @JvmStatic
    public static final void refreshTextViews(@NotNull Context context) {
        Companion.refreshTextViews(context);
    }

    @JvmStatic
    public static final void stopService(@NotNull Context context) {
        Companion.stopService(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public final WindowManager.LayoutParams getParams() {
        return this.f15462l;
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
        b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f15451a = (WindowManager) systemService;
        this.f15457g = true;
        this.f15463m.scheduleAtFixedRate(new TimerTask() { // from class: com.arlosoft.macrodroid.triggers.services.FloatingTextService$onCreate$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                FloatingTextService.this.h();
            }
        }, 0L, 1000L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15457g = false;
        this.f15463m.cancel();
        c();
        synchronized (this.f15452b) {
            for (FloatingView floatingView : this.f15452b) {
                try {
                    WindowManager windowManager = this.f15451a;
                    if (windowManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                        windowManager = null;
                    }
                    windowManager.removeView(floatingView.getContainer());
                } catch (Exception unused) {
                }
            }
            this.f15452b.clear();
            Unit unit = Unit.INSTANCE;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        this.f15453c = IntExtensionsKt.getPx(5);
        b();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(@NotNull Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        stopSelf();
    }

    public final void setParams(@Nullable WindowManager.LayoutParams layoutParams) {
        this.f15462l = layoutParams;
    }
}
