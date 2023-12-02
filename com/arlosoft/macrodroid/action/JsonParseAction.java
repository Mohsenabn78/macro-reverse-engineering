package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.JsonParseAction;
import com.arlosoft.macrodroid.action.info.JsonParseActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsonParseAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class JsonParseAction extends Action implements HasVariableNames, HasMultipleDictionaryKeys {
    @Nullable
    private DictionaryKeys dictionaryKeys;
    @Nullable
    private String dictionaryVarName;
    @Inject
    public transient PremiumStatusHandler premiumStatusHandler;
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
    public static final Parcelable.Creator<JsonParseAction> CREATOR = new Parcelable.Creator<JsonParseAction>() { // from class: com.arlosoft.macrodroid.action.JsonParseAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public JsonParseAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new JsonParseAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public JsonParseAction[] newArray(int i4) {
            return new JsonParseAction[i4];
        }
    };

    /* compiled from: JsonParseAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Spinner $dictionaryVarSpinner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Spinner spinner, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$dictionaryVarSpinner = spinner;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(JsonParseAction jsonParseAction, Spinner spinner, MacroDroidVariable macroDroidVariable) {
            jsonParseAction.workingDictionaryVariableName = macroDroidVariable.getName();
            jsonParseAction.workingDictionaryKeys = null;
            jsonParseAction.R(spinner);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$dictionaryVarSpinner, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (JsonParseAction.this.getPremiumStatusHandler().getPremiumStatus().isPro()) {
                    Activity activity = JsonParseAction.this.getActivity();
                    final Spinner spinner = this.$dictionaryVarSpinner;
                    final JsonParseAction jsonParseAction = JsonParseAction.this;
                    VariablesHelper.createNewVariable(activity, spinner, jsonParseAction, (int) R.style.Theme_App_Dialog_Action, 4, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.k8
                        @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                        public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                            JsonParseAction.a.c(JsonParseAction.this, spinner, macroDroidVariable);
                        }
                    });
                } else {
                    ToastCompat.makeText(JsonParseAction.this.getContext(), (int) R.string.pro_version_required, 1).show();
                    JsonParseAction.this.getActivity().startActivity(new Intent(JsonParseAction.this.getActivity(), UpgradeActivity2.class));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ JsonParseAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final VariableValue O(Object obj) {
        if (obj instanceof JSONArray) {
            VariableValue.Dictionary dictionary = new VariableValue.Dictionary(new ArrayList(), true, null, 4, null);
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                List<VariableValue.DictionaryEntry> entries = dictionary.getEntries();
                String valueOf = String.valueOf(i4);
                Object obj2 = jSONArray.get(i4);
                Intrinsics.checkNotNullExpressionValue(obj2, "jsonObject[i]");
                entries.add(new VariableValue.DictionaryEntry(valueOf, O(obj2), null, 4, null));
            }
            return dictionary;
        } else if (obj instanceof JSONObject) {
            VariableValue.Dictionary dictionary2 = new VariableValue.Dictionary(new ArrayList(), false, null, 6, null);
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jSONObject.get(key);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                dictionary2.getEntries().add(new VariableValue.DictionaryEntry(key, O(value), null, 4, null));
            }
            return dictionary2;
        } else if (obj instanceof Boolean) {
            return new VariableValue.BooleanValue(((Boolean) obj).booleanValue(), null, 2, null);
        } else {
            if (obj instanceof Float) {
                return new VariableValue.DecimalValue(((Number) obj).floatValue(), null, 2, null);
            }
            if (obj instanceof Double) {
                return new VariableValue.DecimalValue(((Number) obj).doubleValue(), null, 2, null);
            }
            if (obj instanceof Integer) {
                return new VariableValue.IntegerValue(((Integer) obj).longValue(), null, 2, null);
            }
            if (obj instanceof Long) {
                return new VariableValue.IntegerValue(((Number) obj).longValue(), null, 2, null);
            }
            return new VariableValue.StringValue(obj.toString(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Spinner stringVarSpinner, Spinner dictionaryVarSpinner, JsonParseAction this$0, AppCompatDialog dialog, View view) {
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
    public static final void Q(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(Spinner spinner) {
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
        VariableHelper.configureDictionaryVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, emptyList, str, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.JsonParseAction$initialiseDictionaryVarSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                JsonParseAction.this.workingDictionaryVariableName = variable.getName();
                JsonParseAction jsonParseAction = JsonParseAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                jsonParseAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    @NotNull
    public DictionaryKeys[] getDictionaryKeys() {
        return new DictionaryKeys[]{this.stringDictionaryKeys, this.dictionaryKeys};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.stringVarName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.stringDictionaryKeys);
        String str3 = this.dictionaryVarName;
        if (str3 != null) {
            str2 = str3;
        }
        String formattedDictionaryKeys2 = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        return str + formattedDictionaryKeys + " -> " + str2 + formattedDictionaryKeys2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return JsonParseActionInfo.Companion.getInstance();
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
        List emptyList;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_json_parse);
        appCompatDialog.setTitle(R.string.action_json_parse);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        this.workingStringVariableName = this.stringVarName;
        this.workingStringDictionaryKeys = this.stringDictionaryKeys;
        this.workingDictionaryVariableName = this.dictionaryVarName;
        this.workingDictionaryKeys = this.dictionaryKeys;
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.stringVariableSpinner);
        Intrinsics.checkNotNull(findViewById3);
        final Spinner spinner = (Spinner) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.dictionaryVariableSpinner);
        Intrinsics.checkNotNull(findViewById4);
        final Spinner spinner2 = (Spinner) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.addDictionaryVariableButton);
        Intrinsics.checkNotNull(findViewById5);
        String str = null;
        ViewExtensionsKt.onClick$default((Button) findViewById5, null, new a(spinner2, null), 1, null);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (this.dictionaryVarName != null) {
            str = this.stringVarName + VariableHelper.getFormattedDictionaryKeys(this.stringDictionaryKeys);
        }
        VariableHelper.configureStringVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner, macro, emptyList, str, false, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.JsonParseAction$handleItemSelected$2
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                JsonParseAction.this.workingStringVariableName = variable.getName();
                JsonParseAction jsonParseAction = JsonParseAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                jsonParseAction.workingStringDictionaryKeys = dictionaryKeys;
            }
        });
        R(spinner2);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JsonParseAction.P(spinner, spinner2, this, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JsonParseAction.Q(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        List<String> emptyList;
        List<String> emptyList2;
        boolean startsWith$default;
        boolean startsWith$default2;
        MacroDroidVariable variableByName = getVariableByName(this.stringVarName);
        MacroDroidVariable variableByName2 = getVariableByName(this.dictionaryVarName);
        if (variableByName == null) {
            SystemLog.logError("Could not get string variable: " + this.stringVarName);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.stringDictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String stringValue = variableByName.getStringValue(VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro()));
        if (stringValue == null) {
            stringValue = "";
        }
        if (variableByName2 == null) {
            SystemLog.logError("Could not output to dictionary variable: " + this.dictionaryVarName);
            return;
        }
        try {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            DictionaryKeys dictionaryKeys2 = this.dictionaryKeys;
            if (dictionaryKeys2 == null || (emptyList2 = dictionaryKeys2.getKeys()) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            VariableValue.Dictionary dictionary = new VariableValue.Dictionary(new ArrayList(), false, VariableHelper.applyMagicTextToDictionaryKeys(context2, emptyList2, triggerContextInfo, getMacro()));
            startsWith$default = kotlin.text.m.startsWith$default(stringValue, "{", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = kotlin.text.m.startsWith$default(stringValue, "[", false, 2, null);
                if (startsWith$default2) {
                    JSONArray jSONArray = new JSONArray(stringValue);
                    VariableValue.Dictionary dictionary2 = new VariableValue.Dictionary(new ArrayList(), true, null, 4, null);
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        List<VariableValue.DictionaryEntry> entries = dictionary2.getEntries();
                        String valueOf = String.valueOf(i4);
                        Object obj = jSONArray.get(i4);
                        Intrinsics.checkNotNullExpressionValue(obj, "jsonArray[i]");
                        entries.add(new VariableValue.DictionaryEntry(valueOf, O(obj), null, 4, null));
                    }
                    dictionary.getEntries().add(new VariableValue.DictionaryEntry(RemoteConfigConstants.ResponseFieldKey.ENTRIES, dictionary2, null, 4, null));
                }
            } else {
                JSONObject jSONObject = new JSONObject(stringValue);
                Iterator<String> keys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object value = jSONObject.get(key);
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    dictionary.getEntries().add(new VariableValue.DictionaryEntry(key, O(value), null, 4, null));
                }
            }
            variableUpdate(variableByName2, dictionary);
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

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
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

    public JsonParseAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public JsonParseAction() {
        init();
    }

    private JsonParseAction(Parcel parcel) {
        super(parcel);
        init();
        this.stringVarName = parcel.readString();
        this.dictionaryVarName = parcel.readString();
        this.stringDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: JsonParseAction.kt */
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
