package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.VoiceInputActivity;
import com.arlosoft.macrodroid.action.info.VoiceInputActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceInputAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nVoiceInputAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceInputAction.kt\ncom/arlosoft/macrodroid/action/VoiceInputAction\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,283:1\n262#2,2:284\n262#2,2:286\n37#3,2:288\n26#4:290\n*S KotlinDebug\n*F\n+ 1 VoiceInputAction.kt\ncom/arlosoft/macrodroid/action/VoiceInputAction\n*L\n206#1:284,2\n208#1:286,2\n251#1:288,2\n251#1:290\n*E\n"})
/* loaded from: classes2.dex */
public final class VoiceInputAction extends Action implements BlockingAction, HasStringVariableName, SupportsMagicText, HasDictionaryKeys {
    @Nullable
    private DictionaryKeys dictionaryKeys;
    private transient int selectedIndex;
    @Nullable
    private String variableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<VoiceInputAction> CREATOR = new Parcelable.Creator<VoiceInputAction>() { // from class: com.arlosoft.macrodroid.action.VoiceInputAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VoiceInputAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VoiceInputAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VoiceInputAction[] newArray(int i4) {
            return new VoiceInputAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VoiceInputAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ ArrayList<String> $parentKeys;
        final /* synthetic */ MacroDroidVariable $variable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MacroDroidVariable macroDroidVariable, ArrayList<String> arrayList) {
            super(1);
            this.$variable = macroDroidVariable;
            this.$parentKeys = arrayList;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String keyName) {
            List plus;
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            VoiceInputAction.this.variableName = this.$variable.getName();
            VoiceInputAction voiceInputAction = VoiceInputAction.this;
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) this.$parentKeys), keyName);
            voiceInputAction.dictionaryKeys = new DictionaryKeys(plus);
            VoiceInputAction.this.itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VoiceInputAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f2743d = new b();

        b() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
            if (r2.hasStringChildren(r2) != false) goto L11;
         */
        @Override // kotlin.jvm.functions.Function1
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue r2) {
            /*
                r1 = this;
                java.lang.String r0 = "variableValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.StringValue
                if (r0 != 0) goto L19
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.Dictionary
                if (r0 == 0) goto L17
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r2 = (com.arlosoft.macrodroid.variables.VariableValue.Dictionary) r2
                boolean r2 = r2.hasStringChildren(r2)
                if (r2 == 0) goto L17
                goto L19
            L17:
                r2 = 0
                goto L1a
            L19:
                r2 = 1
            L1a:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.VoiceInputAction.b.invoke(com.arlosoft.macrodroid.variables.VariableValue):java.lang.Boolean");
        }
    }

    public /* synthetic */ VoiceInputAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList<String> arrayList) {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.createNewKey(activity, getDialogTheme(), dictionary, getMacro(), new a(macroDroidVariable, arrayList));
    }

    private final void Q() {
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
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.variable_new_variable_dialog_name);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.type_container);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.radio_button_local);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.radio_button_global);
        CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.create_now_check_box);
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        Intrinsics.checkNotNull(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.VoiceInputAction$createNewVariable$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z3;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button3 = button;
                Intrinsics.checkNotNull(button3);
                Editable text = editText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "varNameEntry.text");
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceInputAction.R(VoiceInputAction.this, editText, radioButton, appCompatDialog, view);
            }
        });
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceInputAction.S(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(VoiceInputAction this$0, EditText editText, RadioButton radioButton, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (this$0.getMacro().findLocalVariableByName(editText.getText().toString()) != null) {
            this$0.T();
            return;
        }
        String obj = editText.getText().toString();
        Intrinsics.checkNotNull(radioButton);
        MacroDroidVariable macroDroidVariable = new MacroDroidVariable(2, obj, radioButton.isChecked());
        this$0.addVariable(macroDroidVariable);
        this$0.variableName = macroDroidVariable.getName();
        this$0.itemComplete();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void T() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.variable_creation_failed);
        builder.setMessage(R.string.variable_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zt
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VoiceInputAction.U(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(final MacroDroidVariable macroDroidVariable, final VariableValue.Dictionary dictionary, final ArrayList<String> arrayList, final int i4) {
        String str;
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys != null && dictionaryKeys.getKeys().size() > i4) {
            str = dictionaryKeys.getKeys().get(i4);
        } else {
            str = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.showSelectKeyDialog(activity, R.style.Theme_App_Dialog_Action, dictionary, b.f2743d, str, true, new VariableHelper.ManualKeyOption(true, null), false, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, true, new VariableHelper.KeyDialogOptionChosenCallback() { // from class: com.arlosoft.macrodroid.action.VoiceInputAction$showSelectKeyDialog$3

            /* compiled from: VoiceInputAction.kt */
            /* loaded from: classes2.dex */
            static final class a extends Lambda implements Function1<VariableHelper.ManualKeyData, Unit> {
                final /* synthetic */ MacroDroidVariable $variable;
                final /* synthetic */ VoiceInputAction this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(VoiceInputAction voiceInputAction, MacroDroidVariable macroDroidVariable) {
                    super(1);
                    this.this$0 = voiceInputAction;
                    this.$variable = macroDroidVariable;
                }

                public final void a(@NotNull VariableHelper.ManualKeyData manualKeyData) {
                    Intrinsics.checkNotNullParameter(manualKeyData, "<name for destructuring parameter 0>");
                    List<String> component1 = manualKeyData.component1();
                    manualKeyData.component2();
                    this.this$0.variableName = this.$variable.getName();
                    this.this$0.dictionaryKeys = new DictionaryKeys(component1);
                    this.this$0.itemComplete();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                    a(manualKeyData);
                    return Unit.INSTANCE;
                }
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void addKeyChosen() {
                this.P(macroDroidVariable, dictionary, arrayList);
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void keyChosen(@NotNull VariableValue.DictionaryEntry dictionaryEntry) {
                Intrinsics.checkNotNullParameter(dictionaryEntry, "dictionaryEntry");
                arrayList.add(dictionaryEntry.getKey());
                if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                    VoiceInputAction voiceInputAction = this;
                    MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    voiceInputAction.V(macroDroidVariable2, (VariableValue.Dictionary) variable, arrayList, i4 + 1);
                    return;
                }
                this.variableName = macroDroidVariable.getName();
                this.dictionaryKeys = new DictionaryKeys(arrayList);
                this.itemComplete();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void manualKeyEntryChosen(@Nullable List<String> list) {
                Macro macro;
                DictionaryKeys dictionaryKeys2;
                List<String> list2;
                Activity activity2 = this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                VariableValue.Dictionary dictionary2 = dictionary;
                macro = ((SelectableItem) this).m_macro;
                dictionaryKeys2 = this.dictionaryKeys;
                if (dictionaryKeys2 != null) {
                    list2 = dictionaryKeys2.getKeys();
                } else {
                    list2 = null;
                }
                VoiceInputAction voiceInputAction = this;
                VariableHelper.defineKeysManually(activity2, R.style.Theme_App_Dialog_Action, macroDroidVariable2, dictionary2, macro, list2, list, false, voiceInputAction, false, new a(voiceInputAction, macroDroidVariable));
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void copyAllChosen() {
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
            public void thisDictionaryChosen() {
            }
        });
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
    @NotNull
    public String getExtendedDetail() {
        String str = this.variableName;
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        return "➔ " + str + formattedDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return VoiceInputActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        List<String> keys;
        String[] strArr;
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys == null || (keys = dictionaryKeys.getKeys()) == null || (strArr = (String[]) keys.toArray(new String[0])) == null) {
            return new String[0];
        }
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
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
        ArrayList<MacroDroidVariable> allOutputVariablesWithStrings = getAllOutputVariablesWithStrings();
        String[] strArr = new String[allOutputVariablesWithStrings.size() + 1];
        int i4 = 0;
        strArr[0] = SelectableItem.r(R.string.new_variable);
        int size = allOutputVariablesWithStrings.size();
        while (i4 < size) {
            int i5 = i4 + 1;
            strArr[i5] = allOutputVariablesWithStrings.get(i4).getName();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.selectedIndex == 0) {
            Q();
            return;
        }
        ArrayList<MacroDroidVariable> allOutputVariablesWithStrings = getAllOutputVariablesWithStrings();
        Intrinsics.checkNotNullExpressionValue(allOutputVariablesWithStrings, "allOutputVariablesWithStrings");
        if (this.selectedIndex > allOutputVariablesWithStrings.size()) {
            ToastCompat.makeText(getContext(), (int) R.string.variable_does_not_exit, 0).show();
            return;
        }
        MacroDroidVariable macroDroidVariable = allOutputVariablesWithStrings.get(this.selectedIndex - 1);
        if (!macroDroidVariable.isDictionary() && !macroDroidVariable.isArray()) {
            this.dictionaryKeys = null;
            this.variableName = macroDroidVariable.getName();
            itemComplete();
            return;
        }
        V(allOutputVariablesWithStrings.get(this.selectedIndex - 1), macroDroidVariable.getDictionary(), new ArrayList<>(), 0);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.dictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        boolean z3;
        List list;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            list = ArraysKt___ArraysKt.toList(magicText);
            this.dictionaryKeys = new DictionaryKeys(list);
        }
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
        out.writeParcelable(this.dictionaryKeys, i4);
    }

    public VoiceInputAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        Intent intent = new Intent(getContext(), VoiceInputActivity.class);
        intent.addFlags(268435456);
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        intent.putExtra(Constants.EXTRA_MACRO_GUID, macroGuid.longValue());
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, skipEndifIndexStack);
        intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, getMacro().getTriggerThatInvoked());
        intent.putExtra(Constants.EXTRA_IS_TEST, z4);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.putExtra(VoiceInputActivity.EXTRA_VARIABLE_NAME, this.variableName);
        intent.putExtra("dictionary_keys", this.dictionaryKeys);
        getContext().startActivity(intent);
    }

    public VoiceInputAction() {
    }

    private VoiceInputAction(Parcel parcel) {
        super(parcel);
        this.variableName = parcel.readString();
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: VoiceInputAction.kt */
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
