package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.JsonOutputAction;
import com.arlosoft.macrodroid.action.info.JsonOutputActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsonOutputAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class JsonOutputAction extends Action implements HasVariableNames, HasMultipleDictionaryKeys {
    @Nullable
    private DictionaryKeys dictionaryKeys;
    @Nullable
    private String dictionaryVarName;
    @Nullable
    private DictionaryKeys stringDictionaryKeys;
    @Nullable
    private String stringVarName;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient String workingDictionaryVariableName;
    @Nullable
    private transient DictionaryKeys workingStringDictionaryKeys;
    @Nullable
    private transient String workingStringVariableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<JsonOutputAction> CREATOR = new Parcelable.Creator<JsonOutputAction>() { // from class: com.arlosoft.macrodroid.action.JsonOutputAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public JsonOutputAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new JsonOutputAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public JsonOutputAction[] newArray(int i4) {
            return new JsonOutputAction[i4];
        }
    };

    /* compiled from: JsonOutputAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Button $okButton;
        final /* synthetic */ Spinner $stringVarSpinner;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: JsonOutputAction.kt */
        /* renamed from: com.arlosoft.macrodroid.action.JsonOutputAction$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0068a extends Lambda implements Function0<Unit> {
            final /* synthetic */ Button $okButton;
            final /* synthetic */ JsonOutputAction this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0068a(JsonOutputAction jsonOutputAction, Button button) {
                super(0);
                this.this$0 = jsonOutputAction;
                this.$okButton = button;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.U(this.$okButton);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Spinner spinner, Button button, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$stringVarSpinner = spinner;
            this.$okButton = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(JsonOutputAction jsonOutputAction, Spinner spinner, Button button, MacroDroidVariable macroDroidVariable) {
            jsonOutputAction.workingStringVariableName = macroDroidVariable.getName();
            jsonOutputAction.workingDictionaryKeys = null;
            jsonOutputAction.T(spinner, new C0068a(jsonOutputAction, button));
            jsonOutputAction.U(button);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$stringVarSpinner, this.$okButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Activity activity = JsonOutputAction.this.getActivity();
                final Spinner spinner = this.$stringVarSpinner;
                final JsonOutputAction jsonOutputAction = JsonOutputAction.this;
                final Button button = this.$okButton;
                VariablesHelper.createNewVariable(activity, spinner, jsonOutputAction, (int) R.style.Theme_App_Dialog_Action, 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.h8
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        JsonOutputAction.a.c(JsonOutputAction.this, spinner, button, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ JsonOutputAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final JSONObject O(List<VariableValue.DictionaryEntry> list) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (VariableValue.DictionaryEntry dictionaryEntry : list) {
            VariableValue variable = dictionaryEntry.getVariable();
            String key = dictionaryEntry.getKey();
            if (variable instanceof VariableValue.StringValue) {
                obj = ((VariableValue.StringValue) variable).getTextValue();
            } else if (variable instanceof VariableValue.IntegerValue) {
                obj = Long.valueOf(((VariableValue.IntegerValue) variable).getIntValue());
            } else if (variable instanceof VariableValue.DecimalValue) {
                obj = Double.valueOf(((VariableValue.DecimalValue) variable).getDecimalValue());
            } else if (variable instanceof VariableValue.BooleanValue) {
                obj = Boolean.valueOf(((VariableValue.BooleanValue) variable).getBooleanValue());
            } else if (variable instanceof VariableValue.Dictionary) {
                VariableValue.Dictionary dictionary = (VariableValue.Dictionary) variable;
                if (dictionary.isArray()) {
                    obj = P(dictionary.getEntries());
                } else {
                    obj = O(dictionary.getEntries());
                }
            } else {
                obj = "";
            }
            hashMap.put(key, obj);
        }
        return new JSONObject(hashMap);
    }

    private final JSONArray P(List<VariableValue.DictionaryEntry> list) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (VariableValue.DictionaryEntry dictionaryEntry : list) {
            VariableValue variable = dictionaryEntry.getVariable();
            if (variable instanceof VariableValue.StringValue) {
                obj = ((VariableValue.StringValue) variable).getTextValue();
            } else if (variable instanceof VariableValue.IntegerValue) {
                obj = Long.valueOf(((VariableValue.IntegerValue) variable).getIntValue());
            } else if (variable instanceof VariableValue.DecimalValue) {
                obj = Double.valueOf(((VariableValue.DecimalValue) variable).getDecimalValue());
            } else if (variable instanceof VariableValue.BooleanValue) {
                obj = Boolean.valueOf(((VariableValue.BooleanValue) variable).getBooleanValue());
            } else if (variable instanceof VariableValue.Dictionary) {
                VariableValue.Dictionary dictionary = (VariableValue.Dictionary) variable;
                if (dictionary.isArray()) {
                    obj = P(dictionary.getEntries());
                } else {
                    obj = O(dictionary.getEntries());
                }
            } else {
                obj = "";
            }
            arrayList.add(obj);
        }
        return new JSONArray((Collection) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Spinner stringVarSpinner, Spinner dictionaryVarSpinner, JsonOutputAction this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(stringVarSpinner, "$stringVarSpinner");
        Intrinsics.checkNotNullParameter(dictionaryVarSpinner, "$dictionaryVarSpinner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (stringVarSpinner.getSelectedItem() != null && dictionaryVarSpinner.getSelectedItem() != null) {
            this$0.stringVarName = this$0.workingStringVariableName;
            this$0.stringDictionaryKeys = this$0.workingStringDictionaryKeys;
            this$0.dictionaryVarName = this$0.workingDictionaryVariableName;
            this$0.dictionaryKeys = this$0.workingDictionaryKeys;
            this$0.itemComplete();
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void S(Spinner spinner) {
        List emptyList;
        String str;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        String str2 = this.workingDictionaryVariableName;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureDictionaryAndArrayVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, emptyList, str, true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.JsonOutputAction$initialiseDictionaryVarSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                JsonOutputAction.this.workingDictionaryVariableName = variable.getName();
                JsonOutputAction jsonOutputAction = JsonOutputAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                jsonOutputAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(Spinner spinner, final Function0<Unit> function0) {
        String str;
        List listOf = getAllStringVariables().isEmpty() ? kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select)) : CollectionsKt__CollectionsKt.emptyList();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        String str2 = this.workingStringVariableName;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.JsonOutputAction$initialiseStringVarSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                JsonOutputAction.this.workingStringVariableName = variable.getName();
                JsonOutputAction jsonOutputAction = JsonOutputAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                jsonOutputAction.workingDictionaryKeys = dictionaryKeys;
                function0.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(Button button) {
        boolean z3;
        if (this.workingStringVariableName != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    @NotNull
    public DictionaryKeys[] getDictionaryKeys() {
        return new DictionaryKeys[]{this.stringDictionaryKeys, this.dictionaryKeys};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.dictionaryVarName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        String str3 = this.stringVarName;
        if (str3 != null) {
            str2 = str3;
        }
        String formattedDictionaryKeys2 = VariableHelper.getFormattedDictionaryKeys(this.stringDictionaryKeys);
        return str + formattedDictionaryKeys + " -> " + str2 + formattedDictionaryKeys2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return JsonOutputActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        return new String[]{this.stringVarName, this.dictionaryVarName};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        return new Integer[]{2, 4};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_json_output);
        appCompatDialog.setTitle(R.string.action_json_output);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        this.workingStringVariableName = this.stringVarName;
        this.workingStringDictionaryKeys = this.stringDictionaryKeys;
        this.workingDictionaryVariableName = this.dictionaryVarName;
        this.workingDictionaryKeys = this.dictionaryKeys;
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        final Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.dictionaryVariableSpinner);
        Intrinsics.checkNotNull(findViewById3);
        final Spinner spinner = (Spinner) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.stringVariableSpinner);
        Intrinsics.checkNotNull(findViewById4);
        final Spinner spinner2 = (Spinner) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.addStringVariableButton);
        Intrinsics.checkNotNull(findViewById5);
        String str = null;
        ViewExtensionsKt.onClick$default((Button) findViewById5, null, new a(spinner2, button, null), 1, null);
        List listOf = getAllStringVariables().isEmpty() ? kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select)) : CollectionsKt__CollectionsKt.emptyList();
        U(button);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        if (this.dictionaryVarName != null) {
            str = this.stringVarName + VariableHelper.getFormattedDictionaryKeys(this.stringDictionaryKeys);
        }
        VariableHelper.configureStringVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner2, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.JsonOutputAction$handleItemSelected$2
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                JsonOutputAction.this.workingStringVariableName = variable.getName();
                JsonOutputAction jsonOutputAction = JsonOutputAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                jsonOutputAction.workingStringDictionaryKeys = dictionaryKeys;
                JsonOutputAction.this.U(button);
            }
        });
        S(spinner);
        if (spinner.getCount() == 0) {
            ToastCompat.makeText(getActivity(), (int) R.string.no_dictionary_or_array_variables_defined, 1).show();
            return;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.f8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JsonOutputAction.Q(spinner2, spinner, this, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JsonOutputAction.R(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        List<String> emptyList;
        String jSONObject;
        List<String> list;
        MacroDroidVariable variableByName = getVariableByName(this.stringVarName);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        VariableValue.Dictionary dictionaryFromKeyList = getVariableByName(this.dictionaryVarName).getDictionaryFromKeyList(VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro()), false, false);
        if (variableByName == null) {
            SystemLog.logError("Could not get string variable: " + this.stringVarName);
            return;
        }
        try {
            if (dictionaryFromKeyList.isArray()) {
                jSONObject = P(dictionaryFromKeyList.getEntries()).toString();
            } else {
                jSONObject = O(dictionaryFromKeyList.getEntries()).toString();
            }
            Intrinsics.checkNotNullExpressionValue(jSONObject, "if (dictionaryToOutput.i…g()\n                    }");
            DictionaryKeys dictionaryKeys2 = this.stringDictionaryKeys;
            if (dictionaryKeys2 != null) {
                list = dictionaryKeys2.getKeys();
            } else {
                list = null;
            }
            variableUpdate(variableByName, new VariableValue.StringValue(jSONObject, list));
        } catch (Exception e4) {
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Could not parse JSON string: " + e4, macroGuid.longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    public void setDictionaryKeys(@NotNull DictionaryKeys[] dictionaryKeys) {
        Intrinsics.checkNotNullParameter(dictionaryKeys, "dictionaryKeys");
        if (dictionaryKeys.length >= 2) {
            this.stringDictionaryKeys = dictionaryKeys[0];
            this.dictionaryKeys = dictionaryKeys[1];
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        if (varNames.length == 2) {
            this.stringVarName = varNames[0];
            this.dictionaryVarName = varNames[1];
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.stringVarName);
        out.writeString(this.dictionaryVarName);
        out.writeParcelable(this.stringDictionaryKeys, i4);
        out.writeParcelable(this.dictionaryKeys, i4);
    }

    public JsonOutputAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public JsonOutputAction() {
    }

    private JsonOutputAction(Parcel parcel) {
        super(parcel);
        this.stringVarName = parcel.readString();
        this.dictionaryVarName = parcel.readString();
        this.stringDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: JsonOutputAction.kt */
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
