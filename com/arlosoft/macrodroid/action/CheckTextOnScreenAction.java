package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.CheckTextOnScreenAction;
import com.arlosoft.macrodroid.action.info.CheckTextOnScreenActionInfo;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.screenread.ScreenContentsCache;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckTextOnScreenAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class CheckTextOnScreenAction extends Action implements BlockingAction, HasVariableNames, HasDictionaryKeys {
    private static final int MATCH_OPTION_CONTAINS = 1;
    private static final int MATCH_OPTION_MATCH = 0;
    private static final int READ_SCREEN_TIMEOUT_SECONDS = 5;
    @Nullable
    private DictionaryKeys booleanDictionaryKeys;
    @Nullable
    private String booleanVariableName;
    private boolean enableRegex;
    private boolean ignoreCase;
    private boolean ignoreHiddenText;
    private boolean includeOverlays;
    private int matchOption;
    @Inject
    public transient PremiumStatusHandler premiumStatusHandler;
    @Inject
    public transient ScreenContentsCache screenContentsCache;
    @NotNull
    private String textToCheck;
    @Nullable
    private DictionaryKeys viewIdStringDictionaryKeys;
    @Nullable
    private String viewIdStringVariableName;
    @Nullable
    private transient DictionaryKeys workingBooleanDictionaryKeys;
    @Nullable
    private transient String workingBooleanVariableName;
    @Nullable
    private transient DictionaryKeys workingViewIdStringDictionaryKeys;
    @Nullable
    private transient String workingViewIdStringVariableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CheckTextOnScreenAction> CREATOR = new Parcelable.Creator<CheckTextOnScreenAction>() { // from class: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CheckTextOnScreenAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CheckTextOnScreenAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CheckTextOnScreenAction[] newArray(int i4) {
            return new CheckTextOnScreenAction[i4];
        }
    };

    /* compiled from: CheckTextOnScreenAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckBox $ignoreCaseCheckBox;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CheckBox checkBox, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$ignoreCaseCheckBox = checkBox;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$ignoreCaseCheckBox, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$ignoreCaseCheckBox.setEnabled(!this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: CheckTextOnScreenAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        final /* synthetic */ String $textToCompare;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CheckTextOnScreenAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            final /* synthetic */ TriggerContextInfo $contextInfo;
            final /* synthetic */ boolean $forceEvenIfNotEnabled;
            final /* synthetic */ boolean $isTest;
            final /* synthetic */ int $nextAction;
            final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
            final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
            final /* synthetic */ String $textToCompare;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ CheckTextOnScreenAction this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CheckTextOnScreenAction.kt */
            /* renamed from: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0067a implements FlowCollector<Map<String, ? extends String>> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CheckTextOnScreenAction f2109a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ String f2110b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Ref.BooleanRef f2111c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Ref.ObjectRef<String> f2112d;

                C0067a(CheckTextOnScreenAction checkTextOnScreenAction, String str, Ref.BooleanRef booleanRef, Ref.ObjectRef<String> objectRef) {
                    this.f2109a = checkTextOnScreenAction;
                    this.f2110b = str;
                    this.f2111c = booleanRef;
                    this.f2112d = objectRef;
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, java.lang.String] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /* renamed from: a */
                public final Object emit(@NotNull Map<String, String> map, @NotNull Continuation<? super Unit> continuation) {
                    String regexPattern;
                    Iterator<String> it = map.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (this.f2109a.matchOption == 1) {
                            regexPattern = WildCardHelper.getRegexContainsPattern(this.f2110b, this.f2109a.enableRegex, this.f2109a.ignoreCase);
                        } else {
                            regexPattern = WildCardHelper.getRegexPattern(this.f2110b, this.f2109a.enableRegex, this.f2109a.ignoreCase);
                        }
                        if (WildCardHelper.matches(map.get(next), regexPattern, this.f2109a.enableRegex, this.f2109a.ignoreCase)) {
                            this.f2111c.element = true;
                            this.f2112d.element = next;
                            break;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(CheckTextOnScreenAction checkTextOnScreenAction, TriggerContextInfo triggerContextInfo, String str, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = checkTextOnScreenAction;
                this.$contextInfo = triggerContextInfo;
                this.$textToCompare = str;
                this.$isTest = z3;
                this.$nextAction = i4;
                this.$forceEvenIfNotEnabled = z4;
                this.$skipEndifIndexStack = stack;
                this.$resumeMacroInfo = resumeMacroInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(boolean z3, CheckTextOnScreenAction checkTextOnScreenAction, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack stack, ResumeMacroInfo resumeMacroInfo) {
                if (!z3) {
                    checkTextOnScreenAction.getMacro().invokeActions(checkTextOnScreenAction.getMacro().getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$contextInfo, this.$textToCompare, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                Ref.BooleanRef booleanRef;
                Ref.ObjectRef objectRef;
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        objectRef = (Ref.ObjectRef) this.L$1;
                        booleanRef = (Ref.BooleanRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    booleanRef = new Ref.BooleanRef();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Flow take = FlowKt.take(this.this$0.getScreenContentsCache().getScreenDataFlow(), 1);
                    C0067a c0067a = new C0067a(this.this$0, this.$textToCompare, booleanRef, objectRef2);
                    this.L$0 = booleanRef;
                    this.L$1 = objectRef2;
                    this.label = 1;
                    if (take.collect(c0067a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                this.this$0.c0(booleanRef.element, this.$contextInfo);
                this.this$0.d0((String) objectRef.element, this.$contextInfo);
                Handler handler = new Handler(Looper.getMainLooper());
                final boolean z3 = this.$isTest;
                final CheckTextOnScreenAction checkTextOnScreenAction = this.this$0;
                final int i5 = this.$nextAction;
                final TriggerContextInfo triggerContextInfo = this.$contextInfo;
                final boolean z4 = this.$forceEvenIfNotEnabled;
                final Stack<Integer> stack = this.$skipEndifIndexStack;
                final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
                return Boxing.boxBoolean(handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.z1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CheckTextOnScreenAction.b.a.b(z3, checkTextOnScreenAction, i5, triggerContextInfo, z4, stack, resumeMacroInfo);
                    }
                }));
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(TriggerContextInfo triggerContextInfo, String str, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$contextInfo = triggerContextInfo;
            this.$textToCompare = str;
            this.$isTest = z3;
            this.$nextAction = i4;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(CheckTextOnScreenAction checkTextOnScreenAction, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack stack, ResumeMacroInfo resumeMacroInfo) {
            Long macroGuid = checkTextOnScreenAction.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Check text on screen timed out", macroGuid.longValue());
            if (!z3) {
                checkTextOnScreenAction.getMacro().invokeActions(checkTextOnScreenAction.getMacro().getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$contextInfo, this.$textToCompare, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
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
                a aVar = new a(CheckTextOnScreenAction.this, this.$contextInfo, this.$textToCompare, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, null);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(5000L, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (((Boolean) obj) == null) {
                Handler handler = new Handler(Looper.getMainLooper());
                final CheckTextOnScreenAction checkTextOnScreenAction = CheckTextOnScreenAction.this;
                final boolean z3 = this.$isTest;
                final int i5 = this.$nextAction;
                final TriggerContextInfo triggerContextInfo = this.$contextInfo;
                final boolean z4 = this.$forceEvenIfNotEnabled;
                final Stack<Integer> stack = this.$skipEndifIndexStack;
                final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
                handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.y1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CheckTextOnScreenAction.b.b(CheckTextOnScreenAction.this, z3, i5, triggerContextInfo, z4, stack, resumeMacroInfo);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ CheckTextOnScreenAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(final Activity activity, final Spinner booleanVariableSpinner, final CheckTextOnScreenAction this$0, View view) {
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VariablesHelper.createNewVariable(activity, booleanVariableSpinner, this$0, this$0.getDialogTheme(), 0, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.x1
            @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
            public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                CheckTextOnScreenAction.V(CheckTextOnScreenAction.this, activity, booleanVariableSpinner, macroDroidVariable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final CheckTextOnScreenAction this$0, Activity activity, Spinner booleanVariableSpinner, MacroDroidVariable macroDroidVariable) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        this$0.workingBooleanVariableName = macroDroidVariable.getName();
        this$0.workingBooleanDictionaryKeys = null;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.configureBooleanVarSpinner(activity, R.style.Theme_App_Dialog_Action, this$0, booleanVariableSpinner, this$0.getMacro(), true, listOf, macroDroidVariable.getName(), "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$handleItemSelected$3$1$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                CheckTextOnScreenAction.this.workingBooleanVariableName = null;
                CheckTextOnScreenAction.this.workingBooleanDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                CheckTextOnScreenAction.this.workingBooleanVariableName = variable.getName();
                CheckTextOnScreenAction checkTextOnScreenAction = CheckTextOnScreenAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                checkTextOnScreenAction.workingBooleanDictionaryKeys = dictionaryKeys;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final Activity activity, final Spinner viewIdStringVariableSpinner, final CheckTextOnScreenAction this$0, View view) {
        Intrinsics.checkNotNullParameter(viewIdStringVariableSpinner, "$viewIdStringVariableSpinner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VariablesHelper.createNewVariable(activity, viewIdStringVariableSpinner, this$0, this$0.getDialogTheme(), 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.w1
            @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
            public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                CheckTextOnScreenAction.X(CheckTextOnScreenAction.this, activity, viewIdStringVariableSpinner, macroDroidVariable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(final CheckTextOnScreenAction this$0, Activity activity, Spinner viewIdStringVariableSpinner, MacroDroidVariable macroDroidVariable) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewIdStringVariableSpinner, "$viewIdStringVariableSpinner");
        this$0.workingBooleanVariableName = macroDroidVariable.getName();
        this$0.workingViewIdStringDictionaryKeys = null;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.none));
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this$0, viewIdStringVariableSpinner, this$0.getMacro(), listOf, macroDroidVariable.getName(), true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$handleItemSelected$4$1$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                CheckTextOnScreenAction.this.workingViewIdStringVariableName = null;
                CheckTextOnScreenAction.this.workingViewIdStringDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                CheckTextOnScreenAction.this.workingViewIdStringVariableName = variable.getName();
                CheckTextOnScreenAction checkTextOnScreenAction = CheckTextOnScreenAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                checkTextOnScreenAction.workingViewIdStringDictionaryKeys = dictionaryKeys;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(CheckTextOnScreenAction this$0, CheckBox includeOverlaysCheckBox, EditText textbox, CheckBox enableRegexCheckBox, RadioButton matchesRadioButton, CheckBox ignoreCaseCheckBox, CheckBox ignoreHiddenTextCheckBox, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(includeOverlaysCheckBox, "$includeOverlaysCheckBox");
        Intrinsics.checkNotNullParameter(textbox, "$textbox");
        Intrinsics.checkNotNullParameter(enableRegexCheckBox, "$enableRegexCheckBox");
        Intrinsics.checkNotNullParameter(matchesRadioButton, "$matchesRadioButton");
        Intrinsics.checkNotNullParameter(ignoreCaseCheckBox, "$ignoreCaseCheckBox");
        Intrinsics.checkNotNullParameter(ignoreHiddenTextCheckBox, "$ignoreHiddenTextCheckBox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (this$0.workingBooleanVariableName == null) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.please_select_boolean_variable, 1).show();
        } else if (includeOverlaysCheckBox.isChecked() && !this$0.getPremiumStatusHandler().getPremiumStatus().isPro()) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.pro_version_required, 1).show();
        } else {
            this$0.booleanVariableName = this$0.workingBooleanVariableName;
            this$0.booleanDictionaryKeys = this$0.workingBooleanDictionaryKeys;
            this$0.viewIdStringVariableName = this$0.workingViewIdStringVariableName;
            this$0.viewIdStringDictionaryKeys = this$0.workingViewIdStringDictionaryKeys;
            this$0.textToCheck = textbox.getText().toString();
            this$0.enableRegex = enableRegexCheckBox.isChecked();
            this$0.matchOption = !matchesRadioButton.isChecked();
            this$0.includeOverlays = includeOverlaysCheckBox.isChecked();
            this$0.ignoreCase = ignoreCaseCheckBox.isChecked();
            this$0.ignoreHiddenText = ignoreHiddenTextCheckBox.isChecked();
            dialog.cancel();
            this$0.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(EditText textbox, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(textbox, "$textbox");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(textbox.getSelectionStart(), 0);
        int max2 = Math.max(textbox.getSelectionEnd(), 0);
        Editable text = textbox.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Activity activity, MagicText.MagicTextListener magicTextListener, CheckTextOnScreenAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), false, true, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(boolean z3, TriggerContextInfo triggerContextInfo) {
        List<String> emptyList;
        MacroDroidVariable variableByName = getVariableByName(this.booleanVariableName);
        if (variableByName == null) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Check Text On Screen action boolean variable not found: " + this.booleanVariableName, macroGuid.longValue());
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.booleanDictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        variableUpdate(variableByName, new VariableValue.BooleanValue(z3, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(String str, TriggerContextInfo triggerContextInfo) {
        boolean z3;
        List<String> emptyList;
        String str2 = this.viewIdStringVariableName;
        if (str2 != null && str2.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return;
        }
        MacroDroidVariable variableByName = getVariableByName(this.viewIdStringVariableName);
        if (variableByName == null) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Check Text On Screen action string variable not found: " + this.viewIdStringVariableName, macroGuid.longValue());
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.viewIdStringDictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<String> applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro());
        if (str == null) {
            str = "";
        }
        variableUpdate(variableByName, new VariableValue.StringValue(str, applyMagicTextToDictionaryKeys));
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.booleanDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro() && this.includeOverlays) {
            return String.valueOf(SelectableItem.r(R.string.using_screen_overlays_requires_pro_version));
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.textToCheck;
        String str2 = this.booleanVariableName;
        return "'" + str + "' -> " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return CheckTextOnScreenActionInfo.Companion.getInstance();
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
    public final ScreenContentsCache getScreenContentsCache() {
        ScreenContentsCache screenContentsCache = this.screenContentsCache;
        if (screenContentsCache != null) {
            return screenContentsCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenContentsCache");
        return null;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        return new String[]{this.booleanVariableName, this.viewIdStringVariableName};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        return new Integer[]{0, 2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        List listOf;
        String str;
        List listOf2;
        String str2;
        if (!checkActivityAlive()) {
            return;
        }
        this.workingBooleanVariableName = this.booleanVariableName;
        this.workingViewIdStringVariableName = this.viewIdStringVariableName;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_check_screen_contents);
        appCompatDialog.setTitle(R.string.action_check_text_on_screen);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        final Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.text_to_match);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.text_to_match_magic_text_button);
        Intrinsics.checkNotNull(findViewById4);
        Button button3 = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.enable_regex);
        Intrinsics.checkNotNull(findViewById5);
        final CheckBox checkBox = (CheckBox) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.ignore_case_checkbox);
        Intrinsics.checkNotNull(findViewById6);
        final CheckBox checkBox2 = (CheckBox) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.include_overlays_checkbox);
        Intrinsics.checkNotNull(findViewById7);
        final CheckBox checkBox3 = (CheckBox) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.ignore_hidden_text_checkbox);
        Intrinsics.checkNotNull(findViewById8);
        final CheckBox checkBox4 = (CheckBox) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.matches_radio_button);
        Intrinsics.checkNotNull(findViewById9);
        final RadioButton radioButton = (RadioButton) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.contains_radio_button);
        Intrinsics.checkNotNull(findViewById10);
        RadioButton radioButton2 = (RadioButton) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.addBooleanVariableButton);
        Intrinsics.checkNotNull(findViewById11);
        Button button4 = (Button) findViewById11;
        View findViewById12 = appCompatDialog.findViewById(R.id.booleanVariableSpinner);
        Intrinsics.checkNotNull(findViewById12);
        final Spinner spinner = (Spinner) findViewById12;
        View findViewById13 = appCompatDialog.findViewById(R.id.addStringVariableButton);
        Intrinsics.checkNotNull(findViewById13);
        Button button5 = (Button) findViewById13;
        View findViewById14 = appCompatDialog.findViewById(R.id.viewIdStringVariableSpinner);
        Intrinsics.checkNotNull(findViewById14);
        final Spinner spinner2 = (Spinner) findViewById14;
        editText.setText(this.textToCheck);
        editText.setSelection(editText.length());
        checkBox3.setChecked(this.includeOverlays);
        checkBox4.setChecked(this.ignoreHiddenText);
        checkBox3.setText(SelectableItem.r(R.string.screen_content_include_overlays) + " (" + SelectableItem.r(R.string.pro_version_only_short) + ")");
        checkBox2.setChecked(this.ignoreCase);
        boolean z4 = true;
        checkBox2.setEnabled(this.enableRegex ^ true);
        checkBox.setChecked(this.enableRegex);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new a(checkBox2, null), 1, (Object) null);
        button.setEnabled(!TextUtils.isEmpty(this.textToCheck));
        if (this.matchOption == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        if (this.matchOption != 1) {
            z4 = false;
        }
        radioButton2.setChecked(z4);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$handleItemSelected$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                boolean z5;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button6 = button;
                if (s3.length() > 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                button6.setEnabled(z5);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckTextOnScreenAction.U(activity, spinner, this, view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckTextOnScreenAction.W(activity, spinner2, this, view);
            }
        });
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        String str3 = this.booleanVariableName;
        if (str3 != null) {
            str = str3 + VariableHelper.getFormattedDictionaryKeys(this.booleanDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureBooleanVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, true, listOf, str, "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$handleItemSelected$5
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                CheckTextOnScreenAction.this.workingBooleanVariableName = null;
                CheckTextOnScreenAction.this.workingBooleanDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                CheckTextOnScreenAction.this.workingBooleanVariableName = variable.getName();
                CheckTextOnScreenAction checkTextOnScreenAction = CheckTextOnScreenAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                checkTextOnScreenAction.workingBooleanDictionaryKeys = dictionaryKeys;
            }
        });
        listOf2 = kotlin.collections.e.listOf(SelectableItem.r(R.string.none));
        Macro macro2 = getMacro();
        String str4 = this.viewIdStringVariableName;
        if (str4 != null) {
            str2 = str4 + VariableHelper.getFormattedDictionaryKeys(this.viewIdStringDictionaryKeys);
        } else {
            str2 = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner2, macro2, listOf2, str2, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.CheckTextOnScreenAction$handleItemSelected$6
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                CheckTextOnScreenAction.this.workingViewIdStringVariableName = null;
                CheckTextOnScreenAction.this.workingViewIdStringDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                CheckTextOnScreenAction.this.workingViewIdStringVariableName = variable.getName();
                CheckTextOnScreenAction checkTextOnScreenAction = CheckTextOnScreenAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                checkTextOnScreenAction.workingViewIdStringDictionaryKeys = dictionaryKeys;
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckTextOnScreenAction.Y(CheckTextOnScreenAction.this, checkBox3, editText, checkBox, radioButton, checkBox2, checkBox4, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckTextOnScreenAction.Z(AppCompatDialog.this, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.u1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CheckTextOnScreenAction.a0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckTextOnScreenAction.b0(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.animateInUpgradeSceen(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUIInteractionAccessibility() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.booleanDictionaryKeys = dictionaryKeys;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setScreenContentsCache(@NotNull ScreenContentsCache screenContentsCache) {
        Intrinsics.checkNotNullParameter(screenContentsCache, "<set-?>");
        this.screenContentsCache = screenContentsCache;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        if (varNames.length == 2) {
            this.booleanVariableName = varNames[0];
            this.viewIdStringVariableName = varNames[1];
            return;
        }
        SystemLog.logError("Invalid variables legnth in CheckTextOnScreenAction");
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.textToCheck);
        out.writeString(this.booleanVariableName);
        out.writeParcelable(this.booleanDictionaryKeys, i4);
        out.writeString(this.viewIdStringVariableName);
        out.writeParcelable(this.viewIdStringDictionaryKeys, i4);
        out.writeInt(this.enableRegex ? 1 : 0);
        out.writeInt(this.matchOption);
        out.writeInt(this.includeOverlays ? 1 : 0);
        out.writeInt(this.ignoreCase ? 1 : 0);
        out.writeInt(this.ignoreHiddenText ? 1 : 0);
    }

    public CheckTextOnScreenAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        boolean z5;
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        if (!Util.isUIInteractionAccessibilityEnabled(getContext())) {
            PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 10);
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Check Text On Screen action failed, UI Interaction accessibility service is disabled", macroGuid.longValue());
            return;
        }
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.textToCheck, triggerContextInfo, getMacro());
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            String str = SelectableItem.r(R.string.log_warning_not_include_overlays) + " (" + SelectableItem.r(R.string.using_screen_overlays_requires_pro_version) + ")";
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            SystemLog.logWarning(str, macroGuid2.longValue());
            z5 = false;
        } else {
            z5 = this.includeOverlays;
        }
        UIInteractionAccessibilityService.Companion companion = UIInteractionAccessibilityService.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.invokeCaptureScreen(context, false, z5, !this.ignoreHiddenText);
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new b(triggerContextInfo, replaceMagicText, z4, i4, z3, skipEndifIndexStack, resumeMacroInfo, null), 3, null);
    }

    public CheckTextOnScreenAction() {
        this.textToCheck = "";
        this.ignoreCase = true;
        init();
    }

    private CheckTextOnScreenAction(Parcel parcel) {
        super(parcel);
        this.textToCheck = "";
        this.ignoreCase = true;
        init();
        String readString = parcel.readString();
        this.textToCheck = readString != null ? readString : "";
        this.booleanVariableName = parcel.readString();
        this.booleanDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.viewIdStringVariableName = parcel.readString();
        this.viewIdStringDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.enableRegex = parcel.readInt() != 0;
        this.matchOption = parcel.readInt();
        this.includeOverlays = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
        this.ignoreHiddenText = parcel.readInt() != 0;
    }

    /* compiled from: CheckTextOnScreenAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
