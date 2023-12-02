package com.arlosoft.macrodroid.action.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.arlosoft.macrodroid.action.CustomEntry;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.NonAppActivityWithPreventClash;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joni.constants.internal.StackType;

/* compiled from: SelectionDialogActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SelectionDialogActivity extends NonAppActivityWithPreventClash {
    @NotNull
    public static final String EXTRA_BACKGROUND_COLOR = "background_color";
    @NotNull
    public static final String EXTRA_MACRO_GUID = "macro_guid";
    @NotNull
    public static final String EXTRA_MESSAGE = "message";
    @NotNull
    public static final String EXTRA_OPTIONS = "options";
    @NotNull
    public static final String EXTRA_PREVENT_BACK_BUTTON_CLOSE = "prevent_back_button_close";
    @NotNull
    public static final String EXTRA_TEXT_COLOR = "text_color";
    @NotNull
    public static final String EXTRA_VARIABLE_SELECTED_INDEX = "variable_selected_index";
    @NotNull
    public static final String EXTRA_VARIABLE_SELECTED_VALUE = "variable_selected_value";

    /* renamed from: e  reason: collision with root package name */
    private boolean f2919e;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SelectionDialogActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showSelectionDialog(@NotNull Context context, long j4, @NotNull String message, int i4, int i5, @Nullable VariableWithDictionaryKeys variableWithDictionaryKeys, @Nullable VariableWithDictionaryKeys variableWithDictionaryKeys2, boolean z3, @NotNull ArrayList<CustomEntry> options, @Nullable TriggerContextInfo triggerContextInfo, @Nullable Trigger trigger, int i6, @NotNull Stack<Integer> skipEndifIndexStack, boolean z4, boolean z5, @Nullable ResumeMacroInfo resumeMacroInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
            Intent intent = new Intent(context, SelectionDialogActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("macro_guid", j4);
            intent.putExtra("message", message);
            intent.putExtra("text_color", i4);
            intent.putExtra("background_color", i5);
            intent.putExtra(SelectionDialogActivity.EXTRA_VARIABLE_SELECTED_INDEX, variableWithDictionaryKeys);
            intent.putExtra(SelectionDialogActivity.EXTRA_VARIABLE_SELECTED_VALUE, variableWithDictionaryKeys2);
            intent.putExtra(SelectionDialogActivity.EXTRA_PREVENT_BACK_BUTTON_CLOSE, z3);
            intent.putExtra(SelectionDialogActivity.EXTRA_OPTIONS, options);
            intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
            intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, trigger);
            intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i6);
            intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, skipEndifIndexStack);
            intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z4);
            intent.putExtra(Constants.EXTRA_IS_TEST, z5);
            intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
            context.startActivity(intent);
        }
    }

    /* compiled from: SelectionDialogActivity.kt */
    @SourceDebugExtension({"SMAP\nSelectionDialogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionDialogActivity.kt\ncom/arlosoft/macrodroid/action/activities/SelectionDialogActivity$onCreate$2\n+ 2 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,176:1\n74#2,6:177\n80#2:209\n84#2:216\n75#3:183\n76#3,11:185\n89#3:215\n76#4:184\n460#5,13:196\n473#5,3:212\n154#6:210\n154#6:211\n*S KotlinDebug\n*F\n+ 1 SelectionDialogActivity.kt\ncom/arlosoft/macrodroid/action/activities/SelectionDialogActivity$onCreate$2\n*L\n131#1:177,6\n131#1:209\n131#1:216\n131#1:183\n131#1:185,11\n131#1:215\n131#1:184\n131#1:196,13\n131#1:212,3\n135#1:210\n139#1:211\n*E\n"})
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $backgroundColor;
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ String $message;
        final /* synthetic */ int $nextActionIndex;
        final /* synthetic */ List<CustomEntry> $options;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        final /* synthetic */ int $textColor;
        final /* synthetic */ Trigger $triggerThatInvoked;
        final /* synthetic */ VariableWithDictionaryKeys $variableSelectedIndex;
        final /* synthetic */ VariableWithDictionaryKeys $variableSelectedValue;
        final /* synthetic */ SelectionDialogActivity this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SelectionDialogActivity.kt */
        /* renamed from: com.arlosoft.macrodroid.action.activities.SelectionDialogActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0080a extends Lambda implements Function1<LazyListScope, Unit> {
            final /* synthetic */ TriggerContextInfo $contextInfo;
            final /* synthetic */ boolean $forceIfNotEnabled;
            final /* synthetic */ boolean $isTest;
            final /* synthetic */ Macro $macro;
            final /* synthetic */ int $nextActionIndex;
            final /* synthetic */ List<CustomEntry> $options;
            final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
            final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
            final /* synthetic */ Trigger $triggerThatInvoked;
            final /* synthetic */ VariableWithDictionaryKeys $variableSelectedIndex;
            final /* synthetic */ VariableWithDictionaryKeys $variableSelectedValue;
            final /* synthetic */ SelectionDialogActivity this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: SelectionDialogActivity.kt */
            @SourceDebugExtension({"SMAP\nSelectionDialogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionDialogActivity.kt\ncom/arlosoft/macrodroid/action/activities/SelectionDialogActivity$onCreate$2$1$1$1\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,176:1\n154#2:177\n*S KotlinDebug\n*F\n+ 1 SelectionDialogActivity.kt\ncom/arlosoft/macrodroid/action/activities/SelectionDialogActivity$onCreate$2$1$1$1\n*L\n166#1:177\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.action.activities.SelectionDialogActivity$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0081a extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
                final /* synthetic */ TriggerContextInfo $contextInfo;
                final /* synthetic */ boolean $forceIfNotEnabled;
                final /* synthetic */ boolean $isTest;
                final /* synthetic */ Macro $macro;
                final /* synthetic */ int $nextActionIndex;
                final /* synthetic */ List<CustomEntry> $options;
                final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
                final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
                final /* synthetic */ Trigger $triggerThatInvoked;
                final /* synthetic */ VariableWithDictionaryKeys $variableSelectedIndex;
                final /* synthetic */ VariableWithDictionaryKeys $variableSelectedValue;
                final /* synthetic */ SelectionDialogActivity this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SelectionDialogActivity.kt */
                /* renamed from: com.arlosoft.macrodroid.action.activities.SelectionDialogActivity$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public static final class C0082a extends Lambda implements Function0<Unit> {
                    final /* synthetic */ TriggerContextInfo $contextInfo;
                    final /* synthetic */ CustomEntry $entry;
                    final /* synthetic */ boolean $forceIfNotEnabled;
                    final /* synthetic */ boolean $isTest;
                    final /* synthetic */ int $it;
                    final /* synthetic */ Macro $macro;
                    final /* synthetic */ int $nextActionIndex;
                    final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
                    final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
                    final /* synthetic */ Trigger $triggerThatInvoked;
                    final /* synthetic */ VariableWithDictionaryKeys $variableSelectedIndex;
                    final /* synthetic */ VariableWithDictionaryKeys $variableSelectedValue;
                    final /* synthetic */ SelectionDialogActivity this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0082a(VariableWithDictionaryKeys variableWithDictionaryKeys, VariableWithDictionaryKeys variableWithDictionaryKeys2, SelectionDialogActivity selectionDialogActivity, boolean z3, Macro macro, Trigger trigger, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, int i5, CustomEntry customEntry) {
                        super(0);
                        this.$variableSelectedIndex = variableWithDictionaryKeys;
                        this.$variableSelectedValue = variableWithDictionaryKeys2;
                        this.this$0 = selectionDialogActivity;
                        this.$isTest = z3;
                        this.$macro = macro;
                        this.$triggerThatInvoked = trigger;
                        this.$nextActionIndex = i4;
                        this.$contextInfo = triggerContextInfo;
                        this.$forceIfNotEnabled = z4;
                        this.$skipEndifIndexStack = stack;
                        this.$resumeMacroInfo = resumeMacroInfo;
                        this.$it = i5;
                        this.$entry = customEntry;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VariableWithDictionaryKeys variableWithDictionaryKeys = this.$variableSelectedIndex;
                        if (variableWithDictionaryKeys != null) {
                            Macro macro = this.$macro;
                            int i4 = this.$it;
                            MacroDroidVariable variableByName = macro.getVariableByName(variableWithDictionaryKeys.getVariableName());
                            if (variableByName != null) {
                                macro.variableUpdate(variableByName, new VariableValue.IntegerValue(i4, variableWithDictionaryKeys.getKeys().getKeys()));
                            }
                        }
                        VariableWithDictionaryKeys variableWithDictionaryKeys2 = this.$variableSelectedValue;
                        if (variableWithDictionaryKeys2 != null) {
                            Macro macro2 = this.$macro;
                            CustomEntry customEntry = this.$entry;
                            MacroDroidVariable variableByName2 = macro2.getVariableByName(variableWithDictionaryKeys2.getVariableName());
                            if (variableByName2 != null) {
                                macro2.variableUpdate(variableByName2, new VariableValue.StringValue(customEntry.getText(), variableWithDictionaryKeys2.getKeys().getKeys()));
                            }
                        }
                        this.this$0.finish();
                        if (this.$isTest) {
                            return;
                        }
                        this.$macro.setTriggerThatInvoked(this.$triggerThatInvoked);
                        Macro macro3 = this.$macro;
                        macro3.invokeActions(macro3.getActions(), this.$nextActionIndex, this.$contextInfo, this.$forceIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0081a(List<CustomEntry> list, VariableWithDictionaryKeys variableWithDictionaryKeys, VariableWithDictionaryKeys variableWithDictionaryKeys2, SelectionDialogActivity selectionDialogActivity, boolean z3, Macro macro, Trigger trigger, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
                    super(4);
                    this.$options = list;
                    this.$variableSelectedIndex = variableWithDictionaryKeys;
                    this.$variableSelectedValue = variableWithDictionaryKeys2;
                    this.this$0 = selectionDialogActivity;
                    this.$isTest = z3;
                    this.$macro = macro;
                    this.$triggerThatInvoked = trigger;
                    this.$nextActionIndex = i4;
                    this.$contextInfo = triggerContextInfo;
                    this.$forceIfNotEnabled = z4;
                    this.$skipEndifIndexStack = stack;
                    this.$resumeMacroInfo = resumeMacroInfo;
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@NotNull LazyItemScope items, int i4, @Nullable Composer composer, int i5) {
                    int i6;
                    Intrinsics.checkNotNullParameter(items, "$this$items");
                    if ((i5 & 112) == 0) {
                        i6 = (composer.changed(i4) ? 32 : 16) | i5;
                    } else {
                        i6 = i5;
                    }
                    if ((i6 & 721) == 144 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(426406915, i5, -1, "com.arlosoft.macrodroid.action.activities.SelectionDialogActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SelectionDialogActivity.kt:140)");
                    }
                    CustomEntry customEntry = this.$options.get(i4);
                    int m3570getItalic_LCdwA = customEntry.isItalic() ? FontStyle.Companion.m3570getItalic_LCdwA() : FontStyle.Companion.m3571getNormal_LCdwA();
                    FontWeight bold = customEntry.isBold() ? FontWeight.Companion.getBold() : FontWeight.Companion.getNormal();
                    TextKt.m1242TextfLXpl1I(customEntry.getText(), SizeKt.fillMaxWidth$default(PaddingKt.m419paddingVpY3zN4(ClickableKt.m188clickableXHw0xAI$default(Modifier.Companion, false, null, null, new C0082a(this.$variableSelectedIndex, this.$variableSelectedValue, this.this$0, this.$isTest, this.$macro, this.$triggerThatInvoked, this.$nextActionIndex, this.$contextInfo, this.$forceIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, i4, customEntry), 7, null), Dp.m3873constructorimpl(24), Dp.m3873constructorimpl(16)), 0.0f, 1, null), ColorKt.Color(customEntry.getColor()), TextUnitKt.getSp(18), FontStyle.m3563boximpl(m3570getItalic_LCdwA), bold, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, StackType.ABSENT, 0, 65472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0080a(List<CustomEntry> list, VariableWithDictionaryKeys variableWithDictionaryKeys, VariableWithDictionaryKeys variableWithDictionaryKeys2, SelectionDialogActivity selectionDialogActivity, boolean z3, Macro macro, Trigger trigger, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
                super(1);
                this.$options = list;
                this.$variableSelectedIndex = variableWithDictionaryKeys;
                this.$variableSelectedValue = variableWithDictionaryKeys2;
                this.this$0 = selectionDialogActivity;
                this.$isTest = z3;
                this.$macro = macro;
                this.$triggerThatInvoked = trigger;
                this.$nextActionIndex = i4;
                this.$contextInfo = triggerContextInfo;
                this.$forceIfNotEnabled = z4;
                this.$skipEndifIndexStack = stack;
                this.$resumeMacroInfo = resumeMacroInfo;
            }

            public final void a(@NotNull LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                LazyListScope.CC.k(LazyColumn, this.$options.size(), null, null, ComposableLambdaKt.composableLambdaInstance(426406915, true, new C0081a(this.$options, this.$variableSelectedIndex, this.$variableSelectedValue, this.this$0, this.$isTest, this.$macro, this.$triggerThatInvoked, this.$nextActionIndex, this.$contextInfo, this.$forceIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo)), 6, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                a(lazyListScope);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, String str, int i5, List<CustomEntry> list, VariableWithDictionaryKeys variableWithDictionaryKeys, VariableWithDictionaryKeys variableWithDictionaryKeys2, SelectionDialogActivity selectionDialogActivity, boolean z3, Macro macro, Trigger trigger, int i6, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
            super(2);
            this.$backgroundColor = i4;
            this.$message = str;
            this.$textColor = i5;
            this.$options = list;
            this.$variableSelectedIndex = variableWithDictionaryKeys;
            this.$variableSelectedValue = variableWithDictionaryKeys2;
            this.this$0 = selectionDialogActivity;
            this.$isTest = z3;
            this.$macro = macro;
            this.$triggerThatInvoked = trigger;
            this.$nextActionIndex = i6;
            this.$contextInfo = triggerContextInfo;
            this.$forceIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Unit mo1invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i4) {
            boolean z3;
            VariableWithDictionaryKeys variableWithDictionaryKeys;
            SelectionDialogActivity selectionDialogActivity;
            VariableWithDictionaryKeys variableWithDictionaryKeys2;
            ResumeMacroInfo resumeMacroInfo;
            Modifier.Companion companion;
            List<CustomEntry> list;
            Stack<Integer> stack;
            TriggerContextInfo triggerContextInfo;
            int i5;
            boolean z4;
            Trigger trigger;
            Macro macro;
            if ((i4 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(756690102, i4, -1, "com.arlosoft.macrodroid.action.activities.SelectionDialogActivity.onCreate.<anonymous> (SelectionDialogActivity.kt:127)");
            }
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier m169backgroundbw27NRU$default = BackgroundKt.m169backgroundbw27NRU$default(companion2, ColorKt.Color(this.$backgroundColor), null, 2, null);
            String str = this.$message;
            int i6 = this.$textColor;
            List<CustomEntry> list2 = this.$options;
            VariableWithDictionaryKeys variableWithDictionaryKeys3 = this.$variableSelectedIndex;
            VariableWithDictionaryKeys variableWithDictionaryKeys4 = this.$variableSelectedValue;
            SelectionDialogActivity selectionDialogActivity2 = this.this$0;
            boolean z5 = this.$isTest;
            Macro macro2 = this.$macro;
            Trigger trigger2 = this.$triggerThatInvoked;
            int i7 = this.$nextActionIndex;
            TriggerContextInfo triggerContextInfo2 = this.$contextInfo;
            boolean z6 = this.$forceIfNotEnabled;
            Stack<Integer> stack2 = this.$skipEndifIndexStack;
            ResumeMacroInfo resumeMacroInfo2 = this.$resumeMacroInfo;
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m169backgroundbw27NRU$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer m1296constructorimpl = Updater.m1296constructorimpl(composer);
            Updater.m1303setimpl(m1296constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1303setimpl(m1296constructorimpl, density, companion3.getSetDensity());
            Updater.m1303setimpl(m1296constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m1303setimpl(m1296constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1286boximpl(SkippableUpdater.m1287constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-1397757379);
            if (str.length() > 0) {
                triggerContextInfo = triggerContextInfo2;
                z4 = z6;
                i5 = i7;
                trigger = trigger2;
                macro = macro2;
                z3 = z5;
                variableWithDictionaryKeys = variableWithDictionaryKeys4;
                selectionDialogActivity = selectionDialogActivity2;
                variableWithDictionaryKeys2 = variableWithDictionaryKeys3;
                resumeMacroInfo = resumeMacroInfo2;
                list = list2;
                stack = stack2;
                companion = companion2;
                TextKt.m1242TextfLXpl1I(str, SizeKt.fillMaxWidth$default(PaddingKt.m419paddingVpY3zN4(companion2, Dp.m3873constructorimpl(24), Dp.m3873constructorimpl(16)), 0.0f, 1, null), ColorKt.Color(i6), TextUnitKt.getSp(22), null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 3120, 0, 65520);
            } else {
                z3 = z5;
                variableWithDictionaryKeys = variableWithDictionaryKeys4;
                selectionDialogActivity = selectionDialogActivity2;
                variableWithDictionaryKeys2 = variableWithDictionaryKeys3;
                resumeMacroInfo = resumeMacroInfo2;
                companion = companion2;
                list = list2;
                stack = stack2;
                triggerContextInfo = triggerContextInfo2;
                i5 = i7;
                z4 = z6;
                trigger = trigger2;
                macro = macro2;
            }
            composer.endReplaceableGroup();
            LazyDslKt.LazyColumn(PaddingKt.m422paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m3873constructorimpl(8), 7, null), null, null, false, null, null, null, false, new C0080a(list, variableWithDictionaryKeys2, variableWithDictionaryKeys, selectionDialogActivity, z3, macro, trigger, i5, triggerContextInfo, z4, stack, resumeMacroInfo), composer, 6, 254);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Stack<Integer> stack;
        super.onCreate(bundle);
        getWindow().addFlags(524288);
        getWindow().addFlags(4194304);
        setFinishOnTouchOutside(false);
        String stringExtra = getIntent().getStringExtra("message");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str = stringExtra;
        long longExtra = getIntent().getLongExtra("macro_guid", -1L);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(EXTRA_OPTIONS);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = CollectionsKt__CollectionsKt.emptyList();
        }
        List list = parcelableArrayListExtra;
        int intExtra = getIntent().getIntExtra("text_color", -1);
        int intExtra2 = getIntent().getIntExtra("background_color", -16777216);
        VariableWithDictionaryKeys variableWithDictionaryKeys = (VariableWithDictionaryKeys) getIntent().getParcelableExtra(EXTRA_VARIABLE_SELECTED_INDEX);
        VariableWithDictionaryKeys variableWithDictionaryKeys2 = (VariableWithDictionaryKeys) getIntent().getParcelableExtra(EXTRA_VARIABLE_SELECTED_VALUE);
        this.f2919e = getIntent().getBooleanExtra(EXTRA_PREVENT_BACK_BUTTON_CLOSE, false);
        boolean booleanExtra = getIntent().getBooleanExtra(Constants.EXTRA_IS_TEST, false);
        int intExtra3 = getIntent().getIntExtra(Constants.EXTRA_NEXT_ACTION_INDEX, 0);
        boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
        Trigger trigger = (Trigger) getIntent().getParcelableExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED);
        TriggerContextInfo triggerContextInfo = (TriggerContextInfo) getIntent().getParcelableExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        ResumeMacroInfo resumeMacroInfo = (ResumeMacroInfo) getIntent().getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO);
        if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            Serializable serializableExtra = getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX);
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
            stack = Util.deserializeStack((ArrayList) serializableExtra);
        } else {
            stack = new Stack<>();
        }
        Stack<Integer> stack2 = stack;
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        final boolean z3 = this.f2919e;
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(z3) { // from class: com.arlosoft.macrodroid.action.activities.SelectionDialogActivity$onCreate$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        });
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(longExtra);
        if (macroByGUID == null) {
            SystemLog.logError("Could not find macro in Confirm Next Actions");
            finish();
            return;
        }
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(756690102, true, new a(intExtra2, str, intExtra, list, variableWithDictionaryKeys, variableWithDictionaryKeys2, this, booleanExtra, macroByGUID, trigger, intExtra3, triggerContextInfo, booleanExtra2, stack2, resumeMacroInfo)), 1, null);
        getWindow().setLayout(-1, -2);
    }
}
