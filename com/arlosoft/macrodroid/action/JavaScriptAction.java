package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.JavaScriptAction;
import com.arlosoft.macrodroid.action.activities.JavaScriptEditActivity;
import com.arlosoft.macrodroid.action.activities.JavaScriptEditingStore;
import com.arlosoft.macrodroid.action.info.JavaScriptActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.javascript.JavaScripResult;
import com.arlosoft.macrodroid.javascript.JavaScriptExecutor;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.List;
import java.util.Stack;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaScriptAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class JavaScriptAction extends Action implements SupportsMagicText, BlockingAction, HasVariableNames {
    @NotNull
    public static final String DEFAULT_JS_ENGINE = "JetPack JavascriptEngine";
    public static final int REQUEST_CODE_JAVASCRIPT_EDITOR = 1;
    private boolean blockNextAction;
    @Nullable
    private DictionaryKeys consoleVarDictionaryKeys;
    @Nullable
    private String consoleVariableName;
    @NotNull
    private String javascriptEngine;
    @NotNull
    private String scriptText;
    @Nullable
    private DictionaryKeys stringVarDictionaryKeys;
    @Nullable
    private String stringVariableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<JavaScriptAction> CREATOR = new Parcelable.Creator<JavaScriptAction>() { // from class: com.arlosoft.macrodroid.action.JavaScriptAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public JavaScriptAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new JavaScriptAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public JavaScriptAction[] newArray(int i4) {
            return new JavaScriptAction[i4];
        }
    };

    /* compiled from: JavaScriptAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $consoleText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$consoleText = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String newConsoleText) {
            Intrinsics.checkNotNullParameter(newConsoleText, "newConsoleText");
            Ref.ObjectRef<String> objectRef = this.$consoleText;
            String str = objectRef.element;
            objectRef.element = ((Object) str) + newConsoleText;
        }
    }

    /* compiled from: JavaScriptAction.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<JavaScripResult, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $consoleText;
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(TriggerContextInfo triggerContextInfo, Ref.ObjectRef<String> objectRef, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo) {
            super(1);
            this.$contextInfo = triggerContextInfo;
            this.$consoleText = objectRef;
            this.$isTest = z3;
            this.$nextAction = i4;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(JavaScriptAction this$0, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
            if (this$0.blockNextAction && !z3) {
                this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z4, skipEndifIndexStack, resumeMacroInfo);
            }
        }

        public final void b(@NotNull JavaScripResult it) {
            List<String> emptyList;
            List<String> emptyList2;
            List<String> emptyList3;
            List<String> emptyList4;
            Intrinsics.checkNotNullParameter(it, "it");
            if (it instanceof JavaScripResult.Success) {
                JavaScriptAction javaScriptAction = JavaScriptAction.this;
                MacroDroidVariable variableByName = javaScriptAction.getVariableByName(javaScriptAction.stringVariableName);
                if (variableByName == null) {
                    Long macroGuid = JavaScriptAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                    SystemLog.logError("Could not save response into variable: " + JavaScriptAction.this.stringVariableName + ". The variable was not found.", macroGuid.longValue());
                } else {
                    Context context = JavaScriptAction.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    DictionaryKeys dictionaryKeys = JavaScriptAction.this.stringVarDictionaryKeys;
                    if (dictionaryKeys == null || (emptyList4 = dictionaryKeys.getKeys()) == null) {
                        emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    JavaScriptAction.this.variableUpdate(variableByName, new VariableValue.StringValue(((JavaScripResult.Success) it).getResult(), VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList4, this.$contextInfo, JavaScriptAction.this.getMacro())));
                }
                JavaScriptAction javaScriptAction2 = JavaScriptAction.this;
                MacroDroidVariable variableByName2 = javaScriptAction2.getVariableByName(javaScriptAction2.consoleVariableName);
                if (variableByName2 == null) {
                    Long macroGuid2 = JavaScriptAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                    SystemLog.logError("Could not save console output into variable: " + JavaScriptAction.this.consoleVariableName + ". The variable was not found.", macroGuid2.longValue());
                } else {
                    Context context2 = JavaScriptAction.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    DictionaryKeys dictionaryKeys2 = JavaScriptAction.this.consoleVarDictionaryKeys;
                    if (dictionaryKeys2 == null || (emptyList3 = dictionaryKeys2.getKeys()) == null) {
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    JavaScriptAction.this.variableUpdate(variableByName2, new VariableValue.StringValue(this.$consoleText.element, VariableHelper.applyMagicTextToDictionaryKeys(context2, emptyList3, this.$contextInfo, JavaScriptAction.this.getMacro())));
                }
                Handler handler = new Handler(Looper.getMainLooper());
                final JavaScriptAction javaScriptAction3 = JavaScriptAction.this;
                final boolean z3 = this.$isTest;
                final int i4 = this.$nextAction;
                final TriggerContextInfo triggerContextInfo = this.$contextInfo;
                final boolean z4 = this.$forceEvenIfNotEnabled;
                final Stack<Integer> stack = this.$skipEndifIndexStack;
                final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
                handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.e8
                    @Override // java.lang.Runnable
                    public final void run() {
                        JavaScriptAction.b.c(JavaScriptAction.this, z3, i4, triggerContextInfo, z4, stack, resumeMacroInfo);
                    }
                });
            } else if (it instanceof JavaScripResult.Failure) {
                JavaScriptAction javaScriptAction4 = JavaScriptAction.this;
                MacroDroidVariable variableByName3 = javaScriptAction4.getVariableByName(javaScriptAction4.stringVariableName);
                if (variableByName3 == null) {
                    Long macroGuid3 = JavaScriptAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                    SystemLog.logError("Could not save response into variable: " + JavaScriptAction.this.stringVariableName + ". The variable was not found.", macroGuid3.longValue());
                } else {
                    Context context3 = JavaScriptAction.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    DictionaryKeys dictionaryKeys3 = JavaScriptAction.this.stringVarDictionaryKeys;
                    if (dictionaryKeys3 == null || (emptyList2 = dictionaryKeys3.getKeys()) == null) {
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    JavaScriptAction.this.variableUpdate(variableByName3, new VariableValue.StringValue(String.valueOf(((JavaScripResult.Failure) it).getError().getMessage()), VariableHelper.applyMagicTextToDictionaryKeys(context3, emptyList2, this.$contextInfo, JavaScriptAction.this.getMacro())));
                }
                JavaScriptAction javaScriptAction5 = JavaScriptAction.this;
                MacroDroidVariable variableByName4 = javaScriptAction5.getVariableByName(javaScriptAction5.consoleVariableName);
                if (variableByName4 == null) {
                    Long macroGuid4 = JavaScriptAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
                    SystemLog.logError("Could not save console output into variable: " + JavaScriptAction.this.consoleVariableName + ". The variable was not found.", macroGuid4.longValue());
                } else {
                    Context context4 = JavaScriptAction.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "context");
                    DictionaryKeys dictionaryKeys4 = JavaScriptAction.this.consoleVarDictionaryKeys;
                    if (dictionaryKeys4 == null || (emptyList = dictionaryKeys4.getKeys()) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    JavaScriptAction.this.variableUpdate(variableByName4, new VariableValue.StringValue(this.$consoleText.element, VariableHelper.applyMagicTextToDictionaryKeys(context4, emptyList, this.$contextInfo, JavaScriptAction.this.getMacro())));
                }
                if (JavaScriptAction.this.blockNextAction && !this.$isTest) {
                    JavaScriptAction.this.getMacro().invokeActions(JavaScriptAction.this.getMacro().getActions(), this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JavaScripResult javaScripResult) {
            b(javaScripResult);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ JavaScriptAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        List lines;
        Object first;
        List lines2;
        String str;
        lines = StringsKt__StringsKt.lines(this.scriptText);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) lines);
        lines2 = StringsKt__StringsKt.lines(this.scriptText);
        if (lines2.size() > 1) {
            str = "...";
        } else {
            str = "";
        }
        return first + str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return JavaScriptActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.scriptText};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        String[] strArr = new String[2];
        String str = this.stringVariableName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        String str3 = this.consoleVariableName;
        if (str3 != null) {
            str2 = str3;
        }
        strArr[1] = str2;
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        return new Integer[]{2, 2};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@Nullable Activity activity, int i4, int i5, @Nullable Intent intent) {
        String str;
        String str2;
        DictionaryKeys dictionaryKeys;
        String str3;
        DictionaryKeys dictionaryKeys2;
        String str4;
        if (i5 == -1 && i4 == 1) {
            if (intent != null) {
                str = intent.getStringExtra(JavaScriptEditActivity.EXTRA_SCRIPT);
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this.scriptText = str;
            if (intent != null) {
                str2 = intent.getStringExtra("var_name");
            } else {
                str2 = null;
            }
            this.stringVariableName = str2;
            if (intent != null) {
                dictionaryKeys = (DictionaryKeys) intent.getParcelableExtra("dictionary_keys");
            } else {
                dictionaryKeys = null;
            }
            this.stringVarDictionaryKeys = dictionaryKeys;
            if (intent != null) {
                str3 = intent.getStringExtra(JavaScriptEditActivity.EXTRA_CONSOLE_VARIABLE_NAME);
            } else {
                str3 = null;
            }
            this.consoleVariableName = str3;
            if (intent != null) {
                dictionaryKeys2 = (DictionaryKeys) intent.getParcelableExtra(JavaScriptEditActivity.EXTRA_CONSOLE_DICTIONARY_KEYS);
            } else {
                dictionaryKeys2 = null;
            }
            this.consoleVarDictionaryKeys = dictionaryKeys2;
            if (intent != null) {
                str4 = intent.getStringExtra(JavaScriptEditActivity.EXTRA_JAVASCRIPT_ENGINE);
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = "JetPack JavascriptEngine";
            }
            this.javascriptEngine = str4;
            itemComplete();
            JavaScriptEditingStore.INSTANCE.setAction(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        JavaScriptEditingStore.INSTANCE.setAction(this);
        JavaScriptEditActivity.Companion companion = JavaScriptEditActivity.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        companion.show(activity, macroGuid.longValue(), this.scriptText, this.stringVariableName, this.stringVarDictionaryKeys, this.consoleVariableName, this.consoleVarDictionaryKeys, this.javascriptEngine, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.scriptText = magicText[0];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        if (varNames.length == 2) {
            this.stringVariableName = varNames[0];
            this.consoleVariableName = varNames[1];
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.scriptText);
        out.writeInt(this.blockNextAction ? 1 : 0);
        out.writeString(this.stringVariableName);
        out.writeParcelable(this.stringVarDictionaryKeys, i4);
        out.writeString(this.consoleVariableName);
        out.writeParcelable(this.consoleVarDictionaryKeys, i4);
        out.writeString(this.javascriptEngine);
    }

    public JavaScriptAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        String script = h(this.scriptText, triggerContextInfo);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        JavaScriptExecutor javaScriptExecutor = JavaScriptExecutor.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = this.javascriptEngine;
        Macro macro = getMacro();
        Intrinsics.checkNotNullExpressionValue(script, "script");
        javaScriptExecutor.executeJavaScript(context, str, macro, script, new a(objectRef), new b(triggerContextInfo, objectRef, z4, i4, z3, skipEndifIndexStack, resumeMacroInfo));
        if (z4 || this.blockNextAction) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
    }

    public JavaScriptAction() {
        this.scriptText = "";
        this.blockNextAction = true;
        this.javascriptEngine = "JetPack JavascriptEngine";
    }

    private JavaScriptAction(Parcel parcel) {
        super(parcel);
        this.scriptText = "";
        this.blockNextAction = true;
        this.javascriptEngine = "JetPack JavascriptEngine";
        String readString = parcel.readString();
        this.scriptText = readString != null ? readString : "";
        this.blockNextAction = parcel.readInt() != 0;
        this.stringVariableName = parcel.readString();
        this.stringVarDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.consoleVariableName = parcel.readString();
        this.consoleVarDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        String readString2 = parcel.readString();
        this.javascriptEngine = readString2 != null ? readString2 : "JetPack JavascriptEngine";
    }

    /* compiled from: JavaScriptAction.kt */
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
