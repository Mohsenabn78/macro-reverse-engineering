package com.arlosoft.macrodroid.action.services;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.clipboard.ClipboardDataStore;
import com.arlosoft.macrodroid.clipboard.ClipboardReadActivity;
import com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection;
import com.arlosoft.macrodroid.clipboard.helper.LanguageDetector;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptionData;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.screenread.ScreenContentsCache;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.toast.CustomToastHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.uiinteraction.UIInteractionResultCache;
import com.arlosoft.macrodroid.utils.Vibrate;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.google.firebase.firestore.util.ExponentialBackoff;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionAccessibilityService.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUIInteractionAccessibilityService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAccessibilityService.kt\ncom/arlosoft/macrodroid/action/services/UIInteractionAccessibilityService\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1271:1\n1549#2:1272\n1620#2,3:1273\n1549#2:1276\n1620#2,3:1277\n1855#2,2:1280\n1549#2:1283\n1620#2,3:1284\n1549#2:1287\n1620#2,3:1288\n1549#2:1291\n1620#2,3:1292\n1549#2:1295\n1620#2,3:1296\n1#3:1282\n*S KotlinDebug\n*F\n+ 1 UIInteractionAccessibilityService.kt\ncom/arlosoft/macrodroid/action/services/UIInteractionAccessibilityService\n*L\n310#1:1272\n310#1:1273,3\n344#1:1276\n344#1:1277,3\n752#1:1280,2\n1147#1:1283\n1147#1:1284,3\n1208#1:1287\n1208#1:1288,3\n1246#1:1291\n1246#1:1292,3\n1248#1:1295\n1248#1:1296,3\n*E\n"})
/* loaded from: classes2.dex */
public final class UIInteractionAccessibilityService extends AccessibilityService {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f4907h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f4908i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final PublishSubject<UiInteractionConfiguration.Click> f4909j;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f4910k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static String f4911l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private static LinkedList<String> f4912m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private static String f4913n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private static String f4914o;

    /* renamed from: a  reason: collision with root package name */
    private ClipboardDetection f4915a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4916b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, Long> f4917c = new LinkedHashMap();
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private List<String> f4918d;

    /* renamed from: e  reason: collision with root package name */
    private int f4919e;

    /* renamed from: f  reason: collision with root package name */
    private int f4920f;

    /* renamed from: g  reason: collision with root package name */
    private int f4921g;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public RemoteConfig remoteConfig;
    @Inject
    public ScreenContentsCache screenContentsCache;
    @Inject
    public UIInteractionResultCache uIInteractionResultCache;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: UIInteractionAccessibilityService.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class ViewIdAndText {
        public static final int $stable = 0;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final String f4922a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f4923b;

        public ViewIdAndText(@Nullable String str, @NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.f4922a = str;
            this.f4923b = text;
        }

        public static /* synthetic */ ViewIdAndText copy$default(ViewIdAndText viewIdAndText, String str, String str2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = viewIdAndText.f4922a;
            }
            if ((i4 & 2) != 0) {
                str2 = viewIdAndText.f4923b;
            }
            return viewIdAndText.copy(str, str2);
        }

        @Nullable
        public final String component1() {
            return this.f4922a;
        }

        @NotNull
        public final String component2() {
            return this.f4923b;
        }

        @NotNull
        public final ViewIdAndText copy(@Nullable String str, @NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new ViewIdAndText(str, text);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewIdAndText)) {
                return false;
            }
            ViewIdAndText viewIdAndText = (ViewIdAndText) obj;
            if (Intrinsics.areEqual(this.f4922a, viewIdAndText.f4922a) && Intrinsics.areEqual(this.f4923b, viewIdAndText.f4923b)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getText() {
            return this.f4923b;
        }

        @Nullable
        public final String getViewId() {
            return this.f4922a;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f4922a;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return (hashCode * 31) + this.f4923b.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f4922a;
            String str2 = this.f4923b;
            return "ViewIdAndText(viewId=" + str + ", text=" + str2 + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIInteractionAccessibilityService.kt */
    @SourceDebugExtension({"SMAP\nUIInteractionAccessibilityService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIInteractionAccessibilityService.kt\ncom/arlosoft/macrodroid/action/services/UIInteractionAccessibilityService$handleScreenContentTrigger$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1271:1\n1549#2:1272\n1620#2,3:1273\n288#2,2:1276\n*S KotlinDebug\n*F\n+ 1 UIInteractionAccessibilityService.kt\ncom/arlosoft/macrodroid/action/services/UIInteractionAccessibilityService$handleScreenContentTrigger$1\n*L\n1030#1:1272\n1030#1:1273,3\n1076#1:1276,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AccessibilityNodeInfo $rootView;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UIInteractionAccessibilityService.kt */
        /* renamed from: com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0084a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Macro> $macrosToInvoke;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0084a(List<Macro> list, Continuation<? super C0084a> continuation) {
                super(2, continuation);
                this.$macrosToInvoke = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0084a(this.$macrosToInvoke, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    for (Macro macro : this.$macrosToInvoke) {
                        macro.invokeActions(macro.getTriggerContextInfo());
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0084a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AccessibilityNodeInfo accessibilityNodeInfo, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$rootView = accessibilityNodeInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$rootView, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:122:0x01c7 A[EDGE_INSN: B:122:0x01c7->B:79:0x01c7 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01bc A[LOOP:4: B:62:0x017e->B:77:0x01bc, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 565
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        PublishSubject<UiInteractionConfiguration.Click> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        f4909j = create;
        f4912m = new LinkedList<>();
    }

    public UIInteractionAccessibilityService() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f4918d = emptyList;
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    private final void A(UiInteractionConfiguration.GestureSequence gestureSequence, long j4, long j5, long j6, long[] jArr, long[] jArr2, long j7) {
        GestureDescription build;
        if (Build.VERSION.SDK_INT < 24) {
            SystemLog.logError("Gestures are only supported on Android 7+");
            return;
        }
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Path path = new Path();
        if (gestureSequence.getXyPercentages()) {
            path.moveTo((float) convertFromPercent(j4, point.x), (float) convertFromPercent(j5, point.y));
        } else {
            path.moveTo((float) j4, (float) j5);
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        int length = jArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (gestureSequence.getXyPercentages()) {
                path.lineTo((float) convertFromPercent(jArr[i4], point.x), (float) convertFromPercent(jArr2[i4], point.y));
            } else {
                path.lineTo((float) jArr[i4], (float) jArr2[i4]);
            }
        }
        long j8 = 20000;
        if (j6 > 20000) {
            SystemLog.logError("Gesture sequence element duration exceeds maximum (20 seconds). Forcing to 20 seconds", j7);
        } else {
            j8 = 1;
            if (j6 >= 1) {
                j8 = j6;
            }
        }
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, j8));
        build = builder.build();
        try {
            if (!dispatchGesture(build, null, null)) {
                SystemLog.logError("Failed to dispatch gesture");
            }
        } catch (Exception e4) {
            SystemLog.logError("Gesture sequence failed: " + e4);
        }
    }

    private final void B(UiInteractionConfiguration.Paste paste, TriggerContextInfo triggerContextInfo, long j4) {
        ClipData.Item item;
        String clipboardText;
        if (paste.getUseClipboard()) {
            Object systemService = getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
            if (primaryClip != null) {
                item = primaryClip.getItemAt(0);
            } else {
                item = null;
            }
            if (item != null && item.getText() != null) {
                clipboardText = item.getText().toString();
            } else {
                clipboardText = ClipboardDataStore.getClipboardText();
                if (clipboardText == null) {
                    clipboardText = "";
                }
            }
            F(clipboardText, paste.getForceClear(), triggerContextInfo, j4);
            return;
        }
        F(paste.getText(), paste.getForceClear(), triggerContextInfo, j4);
    }

    private final void C() {
        String str;
        CharSequence packageName;
        if (!this.f4916b) {
            SystemLog.logDebug("Screen content trigger is functional");
            this.f4916b = true;
        }
        AccessibilityNodeInfo w3 = w();
        if (w3 != null && (packageName = w3.getPackageName()) != null) {
            str = packageName.toString();
        } else {
            str = null;
        }
        f4913n = str;
        if (w3 != null) {
            e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(w3, null), 2, null);
        }
    }

    private final void D(String str) {
        if (!Intrinsics.areEqual(str, f4911l)) {
            String str2 = f4911l;
            if (str2 != null) {
                f4912m.add(str2);
            }
            f4911l = str;
        }
    }

    private final AccessibilityNodeInfo E(List<? extends AccessibilityNodeInfo> list) {
        int i4 = Integer.MAX_VALUE;
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : list) {
            Rect rect = new Rect();
            accessibilityNodeInfo2.getBoundsInScreen(rect);
            int width = rect.width() * rect.height();
            if (width < i4) {
                accessibilityNodeInfo = accessibilityNodeInfo2;
                i4 = width;
            }
        }
        return accessibilityNodeInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (r11 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void F(java.lang.String r9, boolean r10, com.arlosoft.macrodroid.triggers.TriggerContextInfo r11, long r12) {
        /*
            r8 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r1 = 1
            android.view.accessibility.AccessibilityNodeInfo r1 = r8.findFocus(r1)
            com.arlosoft.macrodroid.macro.MacroStore r2 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
            com.arlosoft.macrodroid.macro.Macro r12 = r2.getMacroByGUID(r12)
            java.lang.String r2 = com.arlosoft.macrodroid.common.MagicText.replaceMagicText(r8, r9, r11, r12)
            java.lang.String r9 = "outputText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            java.lang.String r3 = "\\n"
            java.lang.String r4 = "\n"
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r9 = kotlin.text.StringsKt.replace$default(r2, r3, r4, r5, r6, r7)
            int r11 = android.os.Build.VERSION.SDK_INT
            r12 = 26
            java.lang.String r13 = ""
            if (r11 < r12) goto L38
            if (r1 == 0) goto L35
            java.lang.CharSequence r11 = androidx.core.view.accessibility.a.a(r1)
            goto L36
        L35:
            r11 = 0
        L36:
            if (r11 != 0) goto L39
        L38:
            r11 = r13
        L39:
            if (r1 == 0) goto L47
            java.lang.CharSequence r12 = r1.getText()
            if (r12 == 0) goto L47
            java.lang.String r12 = r12.toString()
            if (r12 != 0) goto L48
        L47:
            r12 = r13
        L48:
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r12)
            if (r11 != 0) goto L52
            if (r10 == 0) goto L51
            goto L52
        L51:
            r13 = r12
        L52:
            r10 = 0
            if (r1 == 0) goto L5a
            int r11 = r1.getTextSelectionStart()
            goto L5b
        L5a:
            r11 = 0
        L5b:
            int r12 = r13.length()
            int r11 = java.lang.Math.min(r11, r12)
            int r11 = java.lang.Math.max(r11, r10)
            if (r1 == 0) goto L6e
            int r12 = r1.getTextSelectionEnd()
            goto L6f
        L6e:
            r12 = 0
        L6f:
            int r2 = r13.length()
            int r12 = java.lang.Math.min(r12, r2)
            int r12 = java.lang.Math.max(r12, r10)
            java.lang.String r10 = r13.substring(r10, r11)
            java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            java.lang.String r12 = r13.substring(r12)
            java.lang.String r13 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            r13.append(r9)
            r13.append(r12)
            java.lang.String r10 = r13.toString()
            java.lang.String r12 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            r0.putCharSequence(r12, r10)
            if (r1 == 0) goto Le8
            r10 = 2097152(0x200000, float:2.938736E-39)
            boolean r10 = r1.performAction(r10, r0)
            if (r10 != 0) goto Lc9
            java.lang.CharSequence r9 = r1.getClassName()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Failed to paste text. Typically only EditText fields can pasted into. This field type = "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r9)
            goto Led
        Lc9:
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            int r12 = r9.length()
            int r12 = r12 + r11
            java.lang.String r13 = "ACTION_ARGUMENT_SELECTION_START_INT"
            r10.putInt(r13, r12)
            int r9 = r9.length()
            int r11 = r11 + r9
            java.lang.String r9 = "ACTION_ARGUMENT_SELECTION_END_INT"
            r10.putInt(r9, r11)
            r9 = 131072(0x20000, float:1.83671E-40)
            r1.performAction(r9, r10)
            goto Led
        Le8:
            java.lang.String r9 = "Paste failed (could not detect current UI focus)"
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r9)
        Led:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.F(java.lang.String, boolean, com.arlosoft.macrodroid.triggers.TriggerContextInfo, long):void");
    }

    @TargetApi(24)
    private final boolean G(Point point, boolean z3) {
        float f4;
        long j4;
        GestureDescription build;
        Path path = new Path();
        int i4 = point.x;
        float f5 = 0.0f;
        if (i4 >= 0) {
            f4 = i4;
        } else {
            f4 = 0.0f;
        }
        int i5 = point.y;
        if (i5 >= 0) {
            f5 = i5;
        }
        path.moveTo(f4, f5);
        path.lineTo(f4 + 1.0f, f5 + 1.0f);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        if (z3) {
            j4 = 1000;
        } else {
            j4 = 30;
        }
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, j4));
        build = builder.build();
        return dispatchGesture(build, null, null);
    }

    private final boolean H(Point point, boolean z3) {
        AccessibilityNodeInfo w3 = w();
        if (w3 == null) {
            SystemLog.logError("Cannot perform click as x,y location (could not detect current UI root node). Please try rebooting your device.");
            return false;
        }
        AccessibilityNodeInfo v3 = v(this, w3, point, 0, 4, null);
        if (v3 == null) {
            return false;
        }
        return q(this, v3, z3, 0, 4, null);
    }

    private final void I() {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        if (Build.VERSION.SDK_INT >= 30) {
            AccessibilityNodeInfo x3 = x();
            if (x3 != null) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
                x3.performAction(accessibilityAction.getId());
                return;
            }
            SystemLog.logError("Copy failed (could not detect current UI focus)");
            return;
        }
        SystemLog.logError("Press Enter requires Android 11 or above.");
    }

    private final void J(boolean z3, boolean z4, boolean z5) {
        List<AccessibilityNodeInfo> listOf;
        int collectionSizeOrDefault;
        HashMap hashMap = new HashMap();
        if (!z3) {
            listOf = kotlin.collections.e.listOf(w());
        } else {
            List<AccessibilityWindowInfo> windows = getWindows();
            Intrinsics.checkNotNullExpressionValue(windows, "windows");
            List<AccessibilityWindowInfo> list = windows;
            collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
            listOf = new ArrayList(collectionSizeOrDefault);
            for (AccessibilityWindowInfo accessibilityWindowInfo : list) {
                listOf.add(accessibilityWindowInfo.getRoot());
            }
        }
        boolean z6 = false;
        for (AccessibilityNodeInfo accessibilityNodeInfo : listOf) {
            if (accessibilityNodeInfo != null) {
                d(this, accessibilityNodeInfo, z4, hashMap, z5, 0, 16, null);
                z6 = true;
            }
        }
        if (!z6) {
            SystemLog.logError("readScreenContents failed (could not detect current UI root node). Please try rebooting your device.");
            return;
        }
        getScreenContentsCache().setScreenData(hashMap);
        this.f4920f = 0;
    }

    private final void a(AccessibilityNodeInfo accessibilityNodeInfo, List<TextWithActiveRootNodeState> list, boolean z3, int i4) {
        String str;
        if (i4 > 50) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (text == null || (str = text.toString()) == null) {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription != null) {
                str = contentDescription.toString();
            } else {
                str = null;
            }
        }
        if (str != null) {
            list.add(new TextWithActiveRootNodeState(str, z3));
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i5);
                if (child != null) {
                    a(child, list, z3, i4 + 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void b(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, List list, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        uIInteractionAccessibilityService.a(accessibilityNodeInfo, list, z3, i4);
    }

    private final void c(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3, HashMap<String, String> hashMap, boolean z4, int i4) {
        String str;
        CharSequence contentDescription;
        boolean contains$default;
        if (i4 > 50) {
            return;
        }
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        if (viewIdResourceName == null) {
            viewIdResourceName = "index:" + this.f4920f;
        }
        if (hashMap.containsKey(viewIdResourceName)) {
            int i5 = 2;
            while (true) {
                if (!hashMap.containsKey(viewIdResourceName + "$" + i5)) {
                    break;
                }
                i5++;
            }
            viewIdResourceName = viewIdResourceName + "$" + i5;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (text == null || (str = text.toString()) == null) {
            if (z4 && (contentDescription = accessibilityNodeInfo.getContentDescription()) != null) {
                str = contentDescription.toString();
            } else {
                str = null;
            }
        }
        if (str != null) {
            hashMap.put(viewIdResourceName, str);
        } else if (z3) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) viewIdResourceName, (CharSequence) "index:", false, 2, (Object) null);
            if (!contains$default) {
                hashMap.put(viewIdResourceName, "");
            }
        }
        this.f4920f++;
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i6);
            if (child != null) {
                c(child, z3, hashMap, z4, i4 + 1);
            }
        }
    }

    static /* synthetic */ void d(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, boolean z3, HashMap hashMap, boolean z4, int i4, int i5, Object obj) {
        int i6;
        if ((i5 & 16) != 0) {
            i6 = 0;
        } else {
            i6 = i4;
        }
        uIInteractionAccessibilityService.c(accessibilityNodeInfo, z3, hashMap, z4, i6);
    }

    private final void e(AccessibilityNodeInfo accessibilityNodeInfo, List<TextWithActiveRootNodeState> list, Set<TextWithActiveRootNodeState> set, boolean z3, int i4) {
        int collectionSizeOrDefault;
        String str;
        int collectionSizeOrDefault2;
        if (i4 > 50) {
            return;
        }
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        if (viewIdResourceName == null) {
            viewIdResourceName = "index:" + this.f4920f;
        }
        Set<TextWithActiveRootNodeState> set2 = set;
        collectionSizeOrDefault = f.collectionSizeOrDefault(set2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TextWithActiveRootNodeState textWithActiveRootNodeState : set2) {
            arrayList.add(textWithActiveRootNodeState.getText());
        }
        if (arrayList.contains(viewIdResourceName)) {
            int i5 = 2;
            while (true) {
                collectionSizeOrDefault2 = f.collectionSizeOrDefault(set2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (TextWithActiveRootNodeState textWithActiveRootNodeState2 : set2) {
                    arrayList2.add(textWithActiveRootNodeState2.getText());
                }
                if (!arrayList2.contains(viewIdResourceName + "$" + i5)) {
                    break;
                }
                i5++;
            }
            viewIdResourceName = viewIdResourceName + "$" + i5;
        }
        set.add(new TextWithActiveRootNodeState(viewIdResourceName, z3));
        CharSequence text = accessibilityNodeInfo.getText();
        if (text == null || (str = text.toString()) == null) {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription != null) {
                str = contentDescription.toString();
            } else {
                str = null;
            }
        }
        if (str != null) {
            list.add(new TextWithActiveRootNodeState(str, z3));
        }
        this.f4921g++;
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i6);
            if (child != null) {
                e(child, list, set, z3, i4 + 1);
            }
        }
    }

    static /* synthetic */ void f(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, List list, Set set, boolean z3, int i4, int i5, Object obj) {
        int i6;
        if ((i5 & 16) != 0) {
            i6 = 0;
        } else {
            i6 = i4;
        }
        uIInteractionAccessibilityService.e(accessibilityNodeInfo, list, set, z3, i6);
    }

    private final void g() {
        AccessibilityNodeInfo x3 = x();
        if (x3 != null) {
            x3.performAction(8);
        } else {
            SystemLog.logError("Clear selection failed (could not detect current UI focus)");
        }
    }

    private final boolean h(boolean z3) {
        if (x() != null) {
            return q(this, x(), z3, 0, 4, null);
        }
        SystemLog.logError("Click current focus item failed (could not detect current UI focus)");
        return false;
    }

    private final boolean i(Point point, boolean z3) {
        if (point == null) {
            SystemLog.logError("Tried to click item at location, but no location configured");
            return false;
        } else if (Build.VERSION.SDK_INT >= 24) {
            if (!G(point, z3)) {
                return H(point, z3);
            }
            return true;
        } else {
            return H(point, z3);
        }
    }

    public static final boolean isConnected() {
        return Companion.isConnected();
    }

    private final boolean j(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z3, long j4, int i4) {
        if (i4 > 50) {
            return false;
        }
        if (str == null) {
            SystemLog.logError("Click item with content description failed (No text content specified)");
            return false;
        } else if (accessibilityNodeInfo == null) {
            SystemLog.logError("Click item with content description failed (node was null).");
            return false;
        } else if (accessibilityNodeInfo.getContentDescription() != null && r(str, 1, accessibilityNodeInfo.getContentDescription().toString(), false, j4)) {
            return q(this, accessibilityNodeInfo, z3, 0, 4, null);
        } else {
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (j(accessibilityNodeInfo.getChild(i5), str, z3, j4, i4 + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    static /* synthetic */ boolean k(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z3, long j4, int i4, int i5, Object obj) {
        int i6;
        if ((i5 & 16) != 0) {
            i6 = 0;
        } else {
            i6 = i4;
        }
        return uIInteractionAccessibilityService.j(accessibilityNodeInfo, str, z3, j4, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:6:0x003f, B:12:0x004b, B:15:0x0060, B:17:0x0076, B:23:0x0082, B:26:0x009b, B:28:0x00b1, B:34:0x00bd, B:37:0x00d3), top: B:46:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:6:0x003f, B:12:0x004b, B:15:0x0060, B:17:0x0076, B:23:0x0082, B:26:0x009b, B:28:0x00b1, B:34:0x00bd, B:37:0x00d3), top: B:46:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:6:0x003f, B:12:0x004b, B:15:0x0060, B:17:0x0076, B:23:0x0082, B:26:0x009b, B:28:0x00b1, B:34:0x00bd, B:37:0x00d3), top: B:46:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:6:0x003f, B:12:0x004b, B:15:0x0060, B:17:0x0076, B:23:0x0082, B:26:0x009b, B:28:0x00b1, B:34:0x00bd, B:37:0x00d3), top: B:46:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean l(android.view.accessibility.AccessibilityNodeInfo r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, android.graphics.Point r23, boolean r24, long r25) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.l(android.view.accessibility.AccessibilityNodeInfo, java.lang.String, java.lang.String, java.lang.String, int, android.graphics.Point, boolean, long):boolean");
    }

    private final boolean m(AccessibilityNodeInfo accessibilityNodeInfo, String str, int i4, boolean z3, long j4, int i5) {
        if (i5 > 75) {
            return false;
        }
        if (str == null) {
            SystemLog.logError("Click item with text failed (No text content specified)");
            return false;
        } else if (accessibilityNodeInfo == null) {
            SystemLog.logError("Click item with text failed (node was null).");
            return false;
        } else {
            CharSequence text = accessibilityNodeInfo.getText();
            if (text == null) {
                text = accessibilityNodeInfo.getContentDescription();
            }
            if (text != null && r(str, i4, text.toString(), false, j4)) {
                return q(this, accessibilityNodeInfo, z3, 0, 4, null);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (m(accessibilityNodeInfo.getChild(i6), str, i4, z3, j4, i5 + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    static /* synthetic */ boolean n(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str, int i4, boolean z3, long j4, int i5, int i6, Object obj) {
        int i7;
        if ((i6 & 32) != 0) {
            i7 = 0;
        } else {
            i7 = i5;
        }
        return uIInteractionAccessibilityService.m(accessibilityNodeInfo, str, i4, z3, j4, i7);
    }

    private final boolean o(AccessibilityNodeInfo accessibilityNodeInfo, String str, int i4, boolean z3, int i5, List<String> list) {
        if (i5 > 75) {
            return false;
        }
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        if (viewIdResourceName == null) {
            viewIdResourceName = "index:" + this.f4919e;
        }
        if (list.contains(viewIdResourceName)) {
            int i6 = 2;
            while (true) {
                if (!list.contains(viewIdResourceName + "$" + i6)) {
                    break;
                }
                i6++;
            }
            viewIdResourceName = viewIdResourceName + "$" + i6;
        }
        String str2 = viewIdResourceName;
        if (r(str, i4, str2, false, 0L)) {
            return q(this, accessibilityNodeInfo, z3, 0, 4, null);
        }
        list.add(str2);
        this.f4919e++;
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i7);
            if (child != null && o(child, str, i4, z3, i5 + 1, list)) {
                return true;
            }
        }
        return false;
    }

    private final boolean p(AccessibilityNodeInfo accessibilityNodeInfo, boolean z3, int i4) {
        if (i4 > 75 || accessibilityNodeInfo == null) {
            return false;
        }
        if (z3) {
            if (accessibilityNodeInfo.isLongClickable()) {
                return accessibilityNodeInfo.performAction(32);
            }
        } else if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.getActionList().contains(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK)) {
            return accessibilityNodeInfo.performAction(16);
        }
        return p(accessibilityNodeInfo.getParent(), z3, i4 + 1);
    }

    static /* synthetic */ boolean q(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return uIInteractionAccessibilityService.p(accessibilityNodeInfo, z3, i4);
    }

    private final boolean r(String str, int i4, String str2, boolean z3, long j4) {
        String regex;
        String replaceMagicText = MagicText.replaceMagicText(this, str, null, null);
        if (i4 == 0) {
            regex = WildCardHelper.getRegexContainsPattern(replaceMagicText, z3, false);
        } else {
            regex = WildCardHelper.getRegexPattern(replaceMagicText, z3, false);
        }
        Intrinsics.checkNotNullExpressionValue(regex, "regex");
        return new Regex(regex).matches(str2);
    }

    private final void s() {
        AccessibilityNodeInfo x3 = x();
        if (x3 != null) {
            x3.performAction(16384);
        } else {
            SystemLog.logError("Copy failed (could not detect current UI focus)");
        }
    }

    public static final void setConnected(boolean z3) {
        Companion.setConnected(z3);
    }

    private final void t() {
        AccessibilityNodeInfo x3 = x();
        if (x3 != null) {
            x3.performAction(65536);
        } else {
            SystemLog.logError("Cut failed (could not detect current UI focus)");
        }
    }

    private final AccessibilityNodeInfo u(AccessibilityNodeInfo accessibilityNodeInfo, Point point, int i4) {
        ArrayList arrayListOf;
        AccessibilityNodeInfo u3;
        if (i4 > 75) {
            return null;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(accessibilityNodeInfo);
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i5);
            if (child != null) {
                Rect rect = new Rect();
                child.getBoundsInScreen(rect);
                if (rect.contains(point.x, point.y) && (u3 = u(child, point, i4 + 1)) != null) {
                    arrayListOf.add(u3);
                }
            }
        }
        return E(arrayListOf);
    }

    static /* synthetic */ AccessibilityNodeInfo v(UIInteractionAccessibilityService uIInteractionAccessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, Point point, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return uIInteractionAccessibilityService.u(accessibilityNodeInfo, point, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfo w() {
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = 0;
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        while (accessibilityNodeInfo == null && i4 < 20) {
            try {
                accessibilityNodeInfo = getRootInActiveWindow();
            } catch (Exception unused) {
                accessibilityNodeInfo = null;
            }
            i4++;
            FirebaseAnalyticsEventLogger.log("rootInActiveWindow attempt: " + i4 + ", time since start: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return accessibilityNodeInfo;
    }

    private final AccessibilityNodeInfo x() {
        return findFocus(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void y(com.arlosoft.macrodroid.action.UiInteractionConfiguration.Click r16, int r17, int r18, long r19, int r21) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.y(com.arlosoft.macrodroid.action.UiInteractionConfiguration$Click, int, int, long, int):void");
    }

    private final void z(UiInteractionConfiguration.Gesture gesture, long j4, long j5, long j6, long j7, long j8) {
        GestureDescription build;
        Path path = new Path();
        if (gesture.getXyPercentages()) {
            Object systemService = getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            path.moveTo((float) convertFromPercent(j4, point.x), (float) convertFromPercent(j5, point.y));
            path.lineTo((float) convertFromPercent(j6, point.x), (float) convertFromPercent(j7, point.y));
        } else {
            path.moveTo((float) j4, (float) j5);
            path.lineTo((float) j6, (float) j7);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            GestureDescription.Builder builder = new GestureDescription.Builder();
            if (j8 > ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
                SystemLog.logError("Gesture duration exceeds maximum (60 seconds). Forcing to 60 seconds");
                j8 = 60000;
            }
            builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, Math.max(1L, j8)));
            build = builder.build();
            if (!dispatchGesture(build, null, null)) {
                SystemLog.logError("Failed to dispatch gesture");
                return;
            }
            return;
        }
        SystemLog.logError("Gestures are only supported on Android 7+");
    }

    public final long convertFromPercent(long j4, int i4) {
        return (j4 * i4) / 100;
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
    public final RemoteConfig getRemoteConfig() {
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            return remoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
        return null;
    }

    @NotNull
    public final ScreenContentsCache getScreenContentsCache() {
        ScreenContentsCache screenContentsCache = this.screenContentsCache;
        if (screenContentsCache != null) {
            return screenContentsCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenContentsCache");
        return null;
    }

    @NotNull
    public final UIInteractionResultCache getUIInteractionResultCache() {
        UIInteractionResultCache uIInteractionResultCache = this.uIInteractionResultCache;
        if (uIInteractionResultCache != null) {
            return uIInteractionResultCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uIInteractionResultCache");
        return null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(@NotNull AccessibilityEvent event) {
        String str;
        String str2;
        CharSequence packageName;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Build.VERSION.SDK_INT >= 29) {
            ClipboardDetection clipboardDetection = this.f4915a;
            if (clipboardDetection == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipboardDetector");
                clipboardDetection = null;
            }
            clipboardDetection.addEvent(event.getEventType());
        }
        if (event.getEventType() == 32 && (packageName = event.getPackageName()) != null) {
            D(packageName.toString());
        }
        try {
            if (f4908i) {
                AccessibilityNodeInfo source = event.getSource();
                if (source != null) {
                    try {
                        source.refresh();
                    } catch (Exception unused) {
                    }
                }
                if (event.getEventType() == 1 || event.getEventType() == 2) {
                    Rect rect = new Rect();
                    if (source != null) {
                        source.getBoundsInScreen(rect);
                    }
                    Point point = new Point(rect.centerX(), rect.centerY());
                    AccessibilityNodeInfo source2 = event.getSource();
                    if (source2 != null) {
                        str = source2.getViewIdResourceName();
                    } else {
                        str = null;
                    }
                    CharSequence contentDescription = event.getContentDescription();
                    String str3 = (contentDescription == null || (r1 = contentDescription.toString()) == null) ? "" : "";
                    List<CharSequence> text = event.getText();
                    if (text.size() > 0) {
                        str2 = text.get(0).toString();
                    } else {
                        str2 = null;
                    }
                    UiInteractionConfiguration.Click click = new UiInteractionConfiguration.Click(3, false, point, false, null, null, str2, 1, str3, str, false, null, false, 4096, null);
                    Vibrate.vibrateDevice(this, 0);
                    String describe = click.describe();
                    CustomToastHelper.displayCustomToast((Context) this, "id: " + describe, -1, (int) R.drawable.launcher_no_border, ContextCompat.getColor(this, R.color.actions_primary_dark), 1, true, false);
                    f4909j.onNext(click);
                    f4908i = false;
                }
            }
        } catch (Exception unused2) {
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ClipboardDetection clipboardDetection2 = this.f4915a;
            if (clipboardDetection2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipboardDetector");
                clipboardDetection2 = null;
            }
            if (ClipboardDetection.getSupportedEventTypes$default(clipboardDetection2, event, null, 2, null)) {
                ClipboardReadActivity.Companion.startIfRequired(this);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Map<String, ExtraSubscriptionData> map;
        super.onCreate();
        LanguageDetector languageDetector = LanguageDetector.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        this.f4915a = new ClipboardDetection(languageDetector.getCopyForLocale(applicationContext));
        ExtraSubscriptions extraSubscriptions = Settings.getExtraSubscriptions(getApplicationContext());
        boolean z3 = false;
        if (extraSubscriptions != null && (map = extraSubscriptions.getMap()) != null && !map.isEmpty()) {
            z3 = true;
        }
        if (!z3) {
            this.f4918d = getRemoteConfig().getBlockScreenReadPackages();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SystemLog.logInfo("UI Interaction accessibility service disconnected");
        f4907h = false;
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        SystemLog.logInfo("UI Interaction accessibility service connected");
        f4907h = true;
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        Bundle extras;
        long[] jArr;
        if (intent != null && (extras = intent.getExtras()) != null) {
            int i6 = extras.getInt(Constants.EXTRA_GLOBAL_CONTROL_TYPE, -1);
            if (i6 != -1) {
                performGlobalAction(i6);
                return 2;
            }
            int i7 = extras.getInt(UIInteractionAccessibilityServiceKt.EXTRA_SERVICE_REQUEST_ID, -1);
            this.f4917c.put(Integer.valueOf(i7), Long.valueOf(System.currentTimeMillis()));
            boolean z3 = extras.getBoolean(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_COMMAND);
            boolean z4 = extras.getBoolean(UIInteractionAccessibilityServiceKt.EXTRA_CHECK_UI_QUERY_COMMAND);
            if (z3) {
                J(extras.getBoolean(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_OPTION_INCLUDE_OVERLAYS, false), extras.getBoolean(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_OPTION_INCLUDE_WITHOUT_TEXT, false), extras.getBoolean(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_OPTION_USE_ID_FALLBACKS, false));
                return 2;
            } else if (z4) {
                C();
                return 2;
            } else {
                UiInteractionConfiguration uiInteractionConfiguration = (UiInteractionConfiguration) extras.getParcelable(UIInteractionAccessibilityServiceKt.EXTRA_UI_INTERACTION_CONFIG);
                TriggerContextInfo triggerContextInfo = (TriggerContextInfo) extras.getParcelable(UIInteractionAccessibilityServiceKt.EXTRA_TRIGGER_CONTEXT_INFO);
                long j4 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_X_VARIABLE_VALUE, -1L);
                long j5 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_Y_VARIABLE_VALUE, -1L);
                long j6 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_MACRO_GUID, -1L);
                long j7 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_START_X_VARIABLE_VALUE, -1L);
                long j8 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_START_Y_VARIABLE_VALUE, -1L);
                long j9 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_END_X_VARIABLE_VALUE, -1L);
                long j10 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_END_Y_VARIABLE_VALUE, -1L);
                long[] longArray = extras.getLongArray(UIInteractionAccessibilityServiceKt.EXTRA_GESTURE_SEQUENCE_X_VALUES);
                if (longArray == null) {
                    longArray = new long[0];
                }
                Intrinsics.checkNotNullExpressionValue(longArray, "it.getLongArray(EXTRA_GE…_VALUES) ?: longArrayOf()");
                long[] longArray2 = extras.getLongArray(UIInteractionAccessibilityServiceKt.EXTRA_GESTURE_SEQUENCE_Y_VALUES);
                if (longArray2 == null) {
                    jArr = new long[0];
                } else {
                    jArr = longArray2;
                }
                Intrinsics.checkNotNullExpressionValue(jArr, "it.getLongArray(EXTRA_GE…_VALUES) ?: longArrayOf()");
                long[] jArr2 = jArr;
                long j11 = extras.getLong(UIInteractionAccessibilityServiceKt.EXTRA_DURATION_VARIABLE_VALUE, -1L);
                if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Click) {
                    y((UiInteractionConfiguration.Click) uiInteractionConfiguration, (int) j4, (int) j5, j6, i7);
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Copy) {
                    s();
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Cut) {
                    t();
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.ClearSelection) {
                    g();
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Paste) {
                    B((UiInteractionConfiguration.Paste) uiInteractionConfiguration, triggerContextInfo, j6);
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.Gesture) {
                    z((UiInteractionConfiguration.Gesture) uiInteractionConfiguration, j7, j8, j9, j10, j11);
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.GestureSequence) {
                    A((UiInteractionConfiguration.GestureSequence) uiInteractionConfiguration, j7, j8, j11, longArray, jArr2, j6);
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.PressBack) {
                    performGlobalAction(1);
                    return 2;
                } else if (uiInteractionConfiguration instanceof UiInteractionConfiguration.PressEnter) {
                    I();
                    return 2;
                } else {
                    return 2;
                }
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(@Nullable Intent intent) {
        f4907h = false;
        return super.onUnbind(intent);
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public final void setScreenContentsCache(@NotNull ScreenContentsCache screenContentsCache) {
        Intrinsics.checkNotNullParameter(screenContentsCache, "<set-?>");
        this.screenContentsCache = screenContentsCache;
    }

    public final void setUIInteractionResultCache(@NotNull UIInteractionResultCache uIInteractionResultCache) {
        Intrinsics.checkNotNullParameter(uIInteractionResultCache, "<set-?>");
        this.uIInteractionResultCache = uIInteractionResultCache;
    }

    /* compiled from: UIInteractionAccessibilityService.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* compiled from: UIInteractionAccessibilityService.kt */
        /* loaded from: classes2.dex */
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

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
                Object coroutine_suspended;
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(500L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                UIInteractionAccessibilityService.f4908i = true;
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UIInteractionAccessibilityService.kt */
        /* loaded from: classes2.dex */
        public static final class b extends ContinuationImpl {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;

            b(Continuation<? super b> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return Companion.this.checkUiQuery(null, this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UIInteractionAccessibilityService.kt */
        /* loaded from: classes2.dex */
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<MacroStore> $macroStore;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(Ref.ObjectRef<MacroStore> objectRef, Continuation<? super c> continuation) {
                super(2, continuation);
                this.$macroStore = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new c(this.$macroStore, continuation);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, com.arlosoft.macrodroid.macro.MacroStore] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef<MacroStore> objectRef = this.$macroStore;
                    ?? macroStore = MacroStore.getInstance();
                    Intrinsics.checkNotNullExpressionValue(macroStore, "getInstance()");
                    objectRef.element = macroStore;
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

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void captureNextClick() {
            e.e(GlobalScope.INSTANCE, null, null, new a(null), 3, null);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(11:5|6|(1:(1:9)(2:41|42))(2:43|(1:45)(1:46))|10|11|12|13|14|(2:34|35)|31|32))|47|6|(0)(0)|10|11|12|13|14|(1:16)|34|35|31|32) */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
            r7 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logDebug("Could not start service for check Ui query: " + r7);
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object checkUiQuery(@org.jetbrains.annotations.NotNull android.content.Context r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.Companion.b
                if (r0 == 0) goto L13
                r0 = r8
                com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion$b r0 = (com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.Companion.b) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion$b r0 = new com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion$b
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 != r4) goto L36
                java.lang.Object r7 = r0.L$2
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                java.lang.Object r1 = r0.L$1
                android.content.Context r1 = (android.content.Context) r1
                java.lang.Object r0 = r0.L$0
                com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion r0 = (com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.Companion) r0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L61
            L36:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3e:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
                r8.<init>()
                kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion$c r5 = new com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService$Companion$c
                r5.<init>(r8, r3)
                r0.L$0 = r6
                r0.L$1 = r7
                r0.L$2 = r8
                r0.label = r4
                java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r5, r0)
                if (r0 != r1) goto L5e
                return r1
            L5e:
                r0 = r6
                r1 = r7
                r7 = r8
            L61:
                T r7 = r7.element
                com.arlosoft.macrodroid.macro.MacroStore r7 = (com.arlosoft.macrodroid.macro.MacroStore) r7
                java.util.Set r7 = r7.getAllScreenContentPackages()
                java.util.LinkedList r8 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.access$getPreviousForegroundAppPackages$cp()     // Catch: java.util.NoSuchElementException -> L75
                java.lang.Object r8 = r8.pop()     // Catch: java.util.NoSuchElementException -> L75
                java.lang.String r8 = (java.lang.String) r8     // Catch: java.util.NoSuchElementException -> L75
                r3 = r8
                goto L76
            L75:
            L76:
                boolean r8 = r7.isEmpty()
                if (r8 != 0) goto Lb8
                java.lang.String r8 = r0.getForegroundAppPackage()
                if (r8 == 0) goto Lb8
                java.lang.String r8 = r0.getForegroundAppPackage()
                boolean r8 = r7.contains(r8)
                if (r8 != 0) goto Lb8
                if (r3 == 0) goto L94
                boolean r8 = r7.contains(r3)
                if (r8 != 0) goto Lb8
            L94:
                java.lang.String r8 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.access$getLastForegroundPackage$cp()
                if (r8 == 0) goto La8
                java.lang.String r8 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.access$getLastForegroundPackage$cp()
                java.lang.String r2 = r0.getForegroundAppPackage()
                boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)
                if (r8 == 0) goto Lb8
            La8:
                java.lang.String r8 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.access$getPreviousRootViewPackage$cp()
                if (r8 == 0) goto Lde
                java.lang.String r8 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.access$getPreviousRootViewPackage$cp()
                boolean r7 = r7.contains(r8)
                if (r7 == 0) goto Lde
            Lb8:
                android.content.Intent r7 = new android.content.Intent     // Catch: java.lang.Exception -> Lc9
                java.lang.Class<com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService> r8 = com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.class
                r7.<init>(r1, r8)     // Catch: java.lang.Exception -> Lc9
                java.lang.String r8 = "uiQuery"
                r7.putExtra(r8, r4)     // Catch: java.lang.Exception -> Lc9
                r1.startService(r7)     // Catch: java.lang.Exception -> Lc9
                goto Lde
            Lc9:
                r7 = move-exception
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r1 = "Could not start service for check Ui query: "
                r8.append(r1)
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logDebug(r7)
            Lde:
                java.lang.String r7 = r0.getForegroundAppPackage()
                com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.access$setLastForegroundPackage$cp(r7)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService.Companion.checkUiQuery(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Nullable
        public final String getForegroundAppPackage() {
            return UIInteractionAccessibilityService.f4911l;
        }

        @NotNull
        public final PublishSubject<UiInteractionConfiguration.Click> getItemSelectedSubject() {
            return UIInteractionAccessibilityService.f4909j;
        }

        public final boolean getPullViewIdsForScreenTrigger() {
            return UIInteractionAccessibilityService.f4910k;
        }

        public final void invokeCaptureScreen(@NotNull Context context, boolean z3, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Intent intent = new Intent(context, UIInteractionAccessibilityService.class);
                intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_COMMAND, true);
                intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_OPTION_INCLUDE_OVERLAYS, z3);
                intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_OPTION_INCLUDE_WITHOUT_TEXT, z4);
                intent.putExtra(UIInteractionAccessibilityServiceKt.EXTRA_CAPTURE_SCREEN_OPTION_USE_ID_FALLBACKS, z5);
                context.startService(intent);
            } catch (Exception e4) {
                SystemLog.logError("Could not capture screen at this time: " + e4);
            }
        }

        public final boolean isConnected() {
            return UIInteractionAccessibilityService.f4907h;
        }

        public final void setConnected(boolean z3) {
            UIInteractionAccessibilityService.f4907h = z3;
        }

        public final void setForegroundAppPackage(@Nullable String str) {
            UIInteractionAccessibilityService.f4911l = str;
        }

        public final void setPullViewIdsForScreenTrigger(boolean z3) {
            UIInteractionAccessibilityService.f4910k = z3;
        }

        @JvmStatic
        public static /* synthetic */ void isConnected$annotations() {
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }
}
