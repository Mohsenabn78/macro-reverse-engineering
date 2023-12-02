package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ReadScreenContentsAction;
import com.arlosoft.macrodroid.action.info.ReadScreenContentsActionInfo;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasDictionaryVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.screenread.ScreenContentsCache;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReadScreenContentsAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nReadScreenContentsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadScreenContentsAction.kt\ncom/arlosoft/macrodroid/action/ReadScreenContentsAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,493:1\n766#2:494\n857#2,2:495\n766#2:497\n857#2,2:498\n262#3,2:500\n262#3,2:502\n37#4,2:504\n*S KotlinDebug\n*F\n+ 1 ReadScreenContentsAction.kt\ncom/arlosoft/macrodroid/action/ReadScreenContentsAction\n*L\n195#1:494\n195#1:495,2\n222#1:497\n222#1:498,2\n338#1:500,2\n339#1:502,2\n441#1:504,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ReadScreenContentsAction extends Action implements BlockingAction, HasDictionaryVariableName, SupportsMagicText, HasDictionaryKeys {
    private static final int READ_SCREEN_TIMEOUT_SECONDS = 5;
    @Nullable
    private DictionaryKeys dictionaryKeys;
    private boolean includeOverlays;
    private boolean includeWithoutText;
    private boolean isLocalVar;
    @Inject
    public transient PremiumStatusHandler premiumStatusHandler;
    @Inject
    public transient ScreenContentsCache screenContentsCache;
    private transient int selectedIndex;
    @Nullable
    private String variableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ReadScreenContentsAction> CREATOR = new Parcelable.Creator<ReadScreenContentsAction>() { // from class: com.arlosoft.macrodroid.action.ReadScreenContentsAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ReadScreenContentsAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ReadScreenContentsAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ReadScreenContentsAction[] newArray(int i4) {
            return new ReadScreenContentsAction[i4];
        }
    };

    /* compiled from: ReadScreenContentsAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        final /* synthetic */ Ref.ObjectRef<MacroDroidVariable> $variable;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadScreenContentsAction.kt */
        /* renamed from: com.arlosoft.macrodroid.action.ReadScreenContentsAction$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0069a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TriggerContextInfo $contextInfo;
            final /* synthetic */ boolean $forceEvenIfNotEnabled;
            final /* synthetic */ boolean $isTest;
            final /* synthetic */ int $nextAction;
            final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
            final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
            final /* synthetic */ Ref.ObjectRef<MacroDroidVariable> $variable;
            int label;
            final /* synthetic */ ReadScreenContentsAction this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ReadScreenContentsAction.kt */
            /* renamed from: com.arlosoft.macrodroid.action.ReadScreenContentsAction$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0070a implements FlowCollector<Map<String, ? extends String>> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ReadScreenContentsAction f2423a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ TriggerContextInfo f2424b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Ref.ObjectRef<MacroDroidVariable> f2425c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ boolean f2426d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ int f2427e;

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ boolean f2428f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Stack<Integer> f2429g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ ResumeMacroInfo f2430h;

                C0070a(ReadScreenContentsAction readScreenContentsAction, TriggerContextInfo triggerContextInfo, Ref.ObjectRef<MacroDroidVariable> objectRef, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
                    this.f2423a = readScreenContentsAction;
                    this.f2424b = triggerContextInfo;
                    this.f2425c = objectRef;
                    this.f2426d = z3;
                    this.f2427e = i4;
                    this.f2428f = z4;
                    this.f2429g = stack;
                    this.f2430h = resumeMacroInfo;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void c(boolean z3, ReadScreenContentsAction this$0, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
                    if (!z3) {
                        this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z4, skipEndifIndexStack, resumeMacroInfo);
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /* renamed from: b */
                public final Object emit(@NotNull Map<String, String> map, @NotNull Continuation<? super Unit> continuation) {
                    List<String> emptyList;
                    Context context = this.f2423a.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    DictionaryKeys dictionaryKeys = this.f2423a.dictionaryKeys;
                    if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    VariableValue.Dictionary dictionary = new VariableValue.Dictionary(new ArrayList(), false, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, this.f2424b, this.f2423a.getMacro()));
                    for (String str : map.keySet()) {
                        List<VariableValue.DictionaryEntry> entries = dictionary.getEntries();
                        String str2 = map.get(str);
                        if (str2 == null) {
                            str2 = "";
                        }
                        entries.add(new VariableValue.DictionaryEntry(str, new VariableValue.StringValue(str2, null, 2, null), null, 4, null));
                    }
                    this.f2423a.getMacro().variableUpdate(this.f2425c.element, dictionary);
                    Handler handler = new Handler(Looper.getMainLooper());
                    final boolean z3 = this.f2426d;
                    final ReadScreenContentsAction readScreenContentsAction = this.f2423a;
                    final int i4 = this.f2427e;
                    final TriggerContextInfo triggerContextInfo = this.f2424b;
                    final boolean z4 = this.f2428f;
                    final Stack<Integer> stack = this.f2429g;
                    final ResumeMacroInfo resumeMacroInfo = this.f2430h;
                    handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.mg
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReadScreenContentsAction.a.C0069a.C0070a.c(z3, readScreenContentsAction, i4, triggerContextInfo, z4, stack, resumeMacroInfo);
                        }
                    });
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0069a(ReadScreenContentsAction readScreenContentsAction, TriggerContextInfo triggerContextInfo, Ref.ObjectRef<MacroDroidVariable> objectRef, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super C0069a> continuation) {
                super(2, continuation);
                this.this$0 = readScreenContentsAction;
                this.$contextInfo = triggerContextInfo;
                this.$variable = objectRef;
                this.$isTest = z3;
                this.$nextAction = i4;
                this.$forceEvenIfNotEnabled = z4;
                this.$skipEndifIndexStack = stack;
                this.$resumeMacroInfo = resumeMacroInfo;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0069a(this.this$0, this.$contextInfo, this.$variable, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
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
                    Flow take = FlowKt.take(this.this$0.getScreenContentsCache().getScreenDataFlow(), 1);
                    C0070a c0070a = new C0070a(this.this$0, this.$contextInfo, this.$variable, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
                    this.label = 1;
                    if (take.collect(c0070a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0069a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TriggerContextInfo triggerContextInfo, Ref.ObjectRef<MacroDroidVariable> objectRef, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$contextInfo = triggerContextInfo;
            this.$variable = objectRef;
            this.$isTest = z3;
            this.$nextAction = i4;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ReadScreenContentsAction readScreenContentsAction, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack stack, ResumeMacroInfo resumeMacroInfo) {
            Long macroGuid = readScreenContentsAction.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Read Screen contents timed out", macroGuid.longValue());
            if (!z3) {
                readScreenContentsAction.getMacro().invokeActions(readScreenContentsAction.getMacro().getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$contextInfo, this.$variable, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
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
                C0069a c0069a = new C0069a(ReadScreenContentsAction.this, this.$contextInfo, this.$variable, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, null);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(5000L, c0069a, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (((Unit) obj) == null) {
                Handler handler = new Handler(Looper.getMainLooper());
                final ReadScreenContentsAction readScreenContentsAction = ReadScreenContentsAction.this;
                final boolean z3 = this.$isTest;
                final int i5 = this.$nextAction;
                final TriggerContextInfo triggerContextInfo = this.$contextInfo;
                final boolean z4 = this.$forceEvenIfNotEnabled;
                final Stack<Integer> stack = this.$skipEndifIndexStack;
                final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
                handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.lg
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadScreenContentsAction.a.b(ReadScreenContentsAction.this, z3, i5, triggerContextInfo, z4, stack, resumeMacroInfo);
                    }
                });
            }
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
    /* compiled from: ReadScreenContentsAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f2431d = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull VariableValue variableValue) {
            boolean z3;
            Intrinsics.checkNotNullParameter(variableValue, "variableValue");
            if (variableValue instanceof VariableValue.Dictionary) {
                VariableValue.Dictionary dictionary = (VariableValue.Dictionary) variableValue;
                if (!dictionary.isArray() || dictionary.hasDictionaryChildren(dictionary)) {
                    z3 = true;
                    return Boolean.valueOf(z3);
                }
            }
            z3 = false;
            return Boolean.valueOf(z3);
        }
    }

    public /* synthetic */ ReadScreenContentsAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(final MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, final ArrayList<String> arrayList) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.variable_new_variable_dialog);
        appCompatDialog.setTitle(R.string.action_set_variable_create);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        View findViewById = appCompatDialog.findViewById(R.id.variable_new_variable_dialog_name);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.type_container);
        ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.local_global_layout);
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        if (dictionary.isArray()) {
            appCompatDialog.setTitle(R.string.variable_dictionary_add_array_index);
            editText.setHint(R.string.variable_array_index);
            editText.setInputType(2);
        } else {
            appCompatDialog.setTitle(R.string.variable_dictionary_add_key);
            editText.setHint(R.string.variable_dictionary_key);
            editText.setInputType(655361);
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.ReadScreenContentsAction$createNewKey$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z3;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button3 = button;
                Intrinsics.checkNotNull(button3);
                Editable text = editText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "keyName.text");
                if (text.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button3.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadScreenContentsAction.Y(ReadScreenContentsAction.this, macroDroidVariable, arrayList, editText, appCompatDialog, view);
            }
        });
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadScreenContentsAction.Z(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ReadScreenContentsAction this$0, MacroDroidVariable variable, ArrayList parentKeys, EditText keyName, AppCompatDialog dialog, View view) {
        List plus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variable, "$variable");
        Intrinsics.checkNotNullParameter(parentKeys, "$parentKeys");
        Intrinsics.checkNotNullParameter(keyName, "$keyName");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.variableName = variable.getName();
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) parentKeys), keyName.getText().toString());
        this$0.dictionaryKeys = new DictionaryKeys(plus);
        this$0.l0();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void a0() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.createNewVariable(activity, getPremiumStatusHandler().getPremiumStatus().isPro(), true, R.style.Theme_App_Dialog_Action, true, true, R.layout.simple_spinner_dropdown_item_2_lines, "#999999", true, getMacro(), 4, new VariableHelper.NewVariableCreationListener() { // from class: com.arlosoft.macrodroid.action.ReadScreenContentsAction$createNewVariable$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
            public void newVariableCreated(@NotNull MacroDroidVariable variable, boolean z3) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                variable.setIsInput(false);
                if ((variable.isLocalVar() && ReadScreenContentsAction.this.getMacro().findLocalVariableByName(variable.getName()) != null) || (!variable.isLocalVar() && MacroDroidVariableStore.getInstance().getVariableByName(variable.getName()) != null)) {
                    ReadScreenContentsAction.this.d0();
                } else if (z3) {
                    ReadScreenContentsAction.this.addVariable(variable);
                    ReadScreenContentsAction.this.k0(variable, variable.getDictionary(), new ArrayList(), 0);
                } else {
                    ReadScreenContentsAction.this.isLocalVar = variable.isLocalVar();
                    ReadScreenContentsAction.this.k0(variable, variable.getDictionary(), new ArrayList(), 0);
                }
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
            public boolean validateVariableName(@NotNull String variableName) {
                Intrinsics.checkNotNullParameter(variableName, "variableName");
                if (ReadScreenContentsAction.this.getMacro().findLocalVariableByName(variableName) == null) {
                    return true;
                }
                return false;
            }
        });
    }

    private final Spanned[] b0() {
        Spanned fromHtml = Html.fromHtml(MacroDroidApplication.Companion.getInstance().getString(R.string.screen_content_exclude_overlays));
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(instance.getStr…ontent_exclude_overlays))");
        String r4 = SelectableItem.r(R.string.screen_content_include_overlays);
        String r5 = SelectableItem.r(R.string.pro_version_required);
        Spanned fromHtml2 = Html.fromHtml(r4 + "<br/><small>(" + r5 + "</small>)");
        Intrinsics.checkNotNullExpressionValue(fromHtml2, "fromHtml(\"${getString(R.…ion_required)}</small>)\")");
        return new Spanned[]{fromHtml, fromHtml2};
    }

    private final String[] c0() {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        String string = companion.getInstance().getString(R.string.read_screen_contents_exclude_view_ids_without_text);
        Intrinsics.checkNotNullExpressionValue(string, "instance.getString(R.str…de_view_ids_without_text)");
        String string2 = companion.getInstance().getString(R.string.read_screen_contents_include_view_ids_without_text);
        Intrinsics.checkNotNullExpressionValue(string2, "instance.getString(R.str…de_view_ids_without_text)");
        return new String[]{string, string2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.variable_creation_failed);
        builder.setMessage(R.string.variable_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.e0(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    private final void f0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        boolean z3 = this.includeOverlays;
        builder.setSingleChoiceItems(b0(), z3 ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ig
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.h0(ReadScreenContentsAction.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.i0(ReadScreenContentsAction.this, dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.j0(ReadScreenContentsAction.this, dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        DialogExtensionsKt.setWidthToParent(create, getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium));
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.bg
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ReadScreenContentsAction.g0(ReadScreenContentsAction.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ReadScreenContentsAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ReadScreenContentsAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ReadScreenContentsAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(ReadScreenContentsAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        boolean z3 = true;
        if (!this$0.getPremiumStatusHandler().getPremiumStatus().isPro() && checkedItemPosition != 0) {
            UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            companion.animateInUpgradeSceen(activity);
            ToastCompat.makeText(this$0.getContext(), (int) R.string.pro_version_required, 1).show();
            this$0.itemComplete();
            return;
        }
        if (checkedItemPosition == 0) {
            z3 = false;
        }
        this$0.includeOverlays = z3;
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(final MacroDroidVariable macroDroidVariable, final VariableValue.Dictionary dictionary, final ArrayList<String> arrayList, final int i4) {
        String str;
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        List<String> list = null;
        if (dictionaryKeys != null && dictionaryKeys.getKeys().size() > i4) {
            str = dictionaryKeys.getKeys().get(i4);
        } else {
            str = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        b bVar = b.f2431d;
        String str2 = str;
        DictionaryKeys dictionaryKeys2 = this.dictionaryKeys;
        if (dictionaryKeys2 != null) {
            list = dictionaryKeys2.getKeys();
        }
        VariableHelper.showSelectKeyDialog(activity, R.style.Theme_App_Dialog_Action, dictionary, bVar, str2, true, new VariableHelper.ManualKeyOption(true, list), false, VariableHelper.ShowThisDictionaryOption.SHOW_DICTIONARIES_ONLY, true, new VariableHelper.KeyDialogOptionChosenCallback() { // from class: com.arlosoft.macrodroid.action.ReadScreenContentsAction$showSelectKeyDialog$3

            /* compiled from: ReadScreenContentsAction.kt */
            /* loaded from: classes2.dex */
            static final class a extends Lambda implements Function1<VariableHelper.ManualKeyData, Unit> {
                final /* synthetic */ MacroDroidVariable $variable;
                final /* synthetic */ ReadScreenContentsAction this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(ReadScreenContentsAction readScreenContentsAction, MacroDroidVariable macroDroidVariable) {
                    super(1);
                    this.this$0 = readScreenContentsAction;
                    this.$variable = macroDroidVariable;
                }

                public final void a(@NotNull VariableHelper.ManualKeyData manualKeyData) {
                    Intrinsics.checkNotNullParameter(manualKeyData, "<name for destructuring parameter 0>");
                    List<String> component1 = manualKeyData.component1();
                    manualKeyData.component2();
                    this.this$0.variableName = this.$variable.getName();
                    this.this$0.dictionaryKeys = new DictionaryKeys(component1);
                    this.this$0.l0();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                    a(manualKeyData);
                    return Unit.INSTANCE;
                }
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void addKeyChosen() {
                this.X(macroDroidVariable, dictionary, arrayList);
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void keyChosen(@NotNull VariableValue.DictionaryEntry dictionaryEntry) {
                Intrinsics.checkNotNullParameter(dictionaryEntry, "dictionaryEntry");
                arrayList.add(dictionaryEntry.getKey());
                if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                    ReadScreenContentsAction readScreenContentsAction = this;
                    MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    readScreenContentsAction.k0(macroDroidVariable2, (VariableValue.Dictionary) variable, arrayList, i4 + 1);
                    return;
                }
                this.variableName = macroDroidVariable.getName();
                this.dictionaryKeys = new DictionaryKeys(arrayList);
                this.l0();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void manualKeyEntryChosen(@Nullable List<String> list2) {
                Macro macro;
                Activity activity2 = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                VariableValue.Dictionary dictionary2 = dictionary;
                macro = ((SelectableItem) this).m_macro;
                ArrayList<String> arrayList2 = arrayList;
                ReadScreenContentsAction readScreenContentsAction = this;
                VariableHelper.defineKeysManually(activity2, R.style.Theme_App_Dialog_Action, macroDroidVariable2, dictionary2, macro, arrayList2, list2, false, readScreenContentsAction, false, new a(readScreenContentsAction, macroDroidVariable));
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void thisDictionaryChosen() {
                this.variableName = macroDroidVariable.getName();
                this.dictionaryKeys = new DictionaryKeys(arrayList);
                this.l0();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void copyAllChosen() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        boolean z3 = this.includeOverlays;
        builder.setSingleChoiceItems(c0(), z3 ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.eg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.m0(ReadScreenContentsAction.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.n0(ReadScreenContentsAction.this, dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ReadScreenContentsAction.o0(ReadScreenContentsAction.this, dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        DialogExtensionsKt.setWidthToParent(create, getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium));
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.hg
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ReadScreenContentsAction.p0(ReadScreenContentsAction.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(ReadScreenContentsAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(ReadScreenContentsAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(ReadScreenContentsAction this$0, DialogInterface dialogInterface, int i4) {
        boolean z3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this$0.includeWithoutText = z3;
        this$0.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(ReadScreenContentsAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.selectedIndex = i4;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.dictionaryKeys;
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
        String str = this.variableName;
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        return "➔ " + str + formattedDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ReadScreenContentsActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        List mutableListOf;
        List<String> keys;
        String[] strArr = new String[1];
        String str = this.variableName;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(strArr);
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys != null && (keys = dictionaryKeys.getKeys()) != null) {
            mutableListOf.addAll(keys);
        }
        return (String[]) mutableListOf.toArray(new String[0]);
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

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.animateInUpgradeSceen(activity);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        int i4;
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = allDictionaryAndArrayVariables.iterator();
        while (true) {
            i4 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) next;
            if (((!macroDroidVariable.isArray() || macroDroidVariable.getHasDictionaryChildren()) ? 1 : 1) != 0) {
                arrayList.add(next);
            }
        }
        String[] strArr = new String[arrayList.size() + 1];
        strArr[0] = SelectableItem.r(R.string.new_variable);
        int size = arrayList.size();
        while (i4 < size) {
            int i5 = i4 + 1;
            strArr[i5] = ((MacroDroidVariable) arrayList.get(i4)).getName();
            i4 = i5;
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String p() {
        String string = getContext().getString(R.string.action_set_variable_select);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…tion_set_variable_select)");
        return string;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresUIInteractionAccessibility() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.selectedIndex == 0) {
            if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
                a0();
                return;
            }
            UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            companion.animateInUpgradeSceen(activity);
            ToastCompat.makeText(getContext(), (int) R.string.pro_version_required, 1).show();
            return;
        }
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = allDictionaryAndArrayVariables.iterator();
        while (true) {
            boolean z3 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) next;
            if ((!macroDroidVariable.isArray() || macroDroidVariable.getHasDictionaryChildren()) ? true : true) {
                arrayList.add(next);
            }
        }
        if (this.selectedIndex > arrayList.size()) {
            ToastCompat.makeText(getContext(), (int) R.string.variable_does_not_exit, 0).show();
            return;
        }
        MacroDroidVariable macroDroidVariable2 = (MacroDroidVariable) arrayList.get(this.selectedIndex - 1);
        if (!macroDroidVariable2.isDictionary() && !macroDroidVariable2.isArray()) {
            this.dictionaryKeys = null;
            this.variableName = macroDroidVariable2.getName();
            l0();
            return;
        }
        k0((MacroDroidVariable) arrayList.get(this.selectedIndex - 1), macroDroidVariable2.getDictionary(), new ArrayList<>(), 0);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.dictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        boolean z3;
        List mutableList;
        List drop;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            String str = this.m_classType;
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
            return;
        }
        this.variableName = magicText[0];
        if (magicText.length > 1) {
            mutableList = ArraysKt___ArraysKt.toMutableList(magicText);
            drop = CollectionsKt___CollectionsKt.drop(mutableList, 1);
            this.dictionaryKeys = new DictionaryKeys(drop);
        }
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setScreenContentsCache(@NotNull ScreenContentsCache screenContentsCache) {
        Intrinsics.checkNotNullParameter(screenContentsCache, "<set-?>");
        this.screenContentsCache = screenContentsCache;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.variableName);
        out.writeInt(this.isLocalVar ? 1 : 0);
        out.writeParcelable(this.dictionaryKeys, i4);
        out.writeInt(this.includeOverlays ? 1 : 0);
        out.writeInt(this.includeWithoutText ? 1 : 0);
    }

    public ReadScreenContentsAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [T, com.arlosoft.macrodroid.common.MacroDroidVariable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.arlosoft.macrodroid.common.MacroDroidVariable] */
    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        if (!Util.isUIInteractionAccessibilityEnabled(getContext())) {
            PermissionsHelper.showNeedsSpecialPermission(getContext(), getName(), 10);
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Read Screen Contents failed, UI Interaction accessibility service is disabled", macroGuid.longValue());
            return;
        }
        String varName = MagicText.replaceMagicText(getContext(), this.variableName, triggerContextInfo, getMacro());
        boolean z5 = false;
        if (varName == null || varName.length() == 0) {
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            SystemLog.logError("Cannot read screen contents, dictionary variable name is blank", macroGuid2.longValue());
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? variableByName = getVariableByName(varName);
        objectRef.element = variableByName;
        if (variableByName == 0) {
            Intrinsics.checkNotNullExpressionValue(varName, "varName");
            addVariable(new MacroDroidVariable(4, varName, this.isLocalVar));
            objectRef.element = getVariableByName(varName);
        }
        if (objectRef.element == 0) {
            String str = "Cannot read screen contents, dictionary variable not available: " + this.variableName + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
            Long macroGuid3 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
            SystemLog.logError(str, macroGuid3.longValue());
            return;
        }
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            String str2 = SelectableItem.r(R.string.log_warning_not_include_overlays) + " (" + SelectableItem.r(R.string.using_screen_overlays_requires_pro_version) + ")";
            Long macroGuid4 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
            SystemLog.logWarning(str2, macroGuid4.longValue());
        } else {
            z5 = this.includeOverlays;
        }
        UIInteractionAccessibilityService.Companion companion = UIInteractionAccessibilityService.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.invokeCaptureScreen(context, z5, this.includeWithoutText, true);
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new a(triggerContextInfo, objectRef, z4, i4, z3, skipEndifIndexStack, resumeMacroInfo, null), 3, null);
    }

    public ReadScreenContentsAction() {
        init();
    }

    private ReadScreenContentsAction(Parcel parcel) {
        super(parcel);
        init();
        this.variableName = parcel.readString();
        this.isLocalVar = parcel.readInt() != 0;
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.includeOverlays = parcel.readInt() != 0;
        this.includeWithoutText = parcel.readInt() != 0;
    }

    /* compiled from: ReadScreenContentsAction.kt */
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
