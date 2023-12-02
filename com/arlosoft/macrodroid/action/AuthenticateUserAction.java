package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import androidx.biometric.BiometricManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.AuthenticateUserActivity;
import com.arlosoft.macrodroid.action.info.AuthenticateUserActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.List;
import java.util.Stack;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AuthenticateUserAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AuthenticateUserAction extends Action implements SupportsMagicText, HasStringVariableName, BlockingAction {
    @Nullable
    private DictionaryKeys dictionaryKeys;
    private int option;
    private boolean preventPasswordPin;
    @NotNull
    private String subtitle;
    @NotNull
    private String title;
    @Nullable
    private String variableName;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient String workingVariableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AuthenticateUserAction> CREATOR = new Parcelable.Creator<AuthenticateUserAction>() { // from class: com.arlosoft.macrodroid.action.AuthenticateUserAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AuthenticateUserAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthenticateUserAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AuthenticateUserAction[] newArray(int i4) {
            return new AuthenticateUserAction[i4];
        }
    };

    public /* synthetic */ AuthenticateUserAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(final AuthenticateUserAction this$0, final Spinner booleanVariableSpinner, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        VariablesHelper.createNewVariable(this$0.getActivity(), booleanVariableSpinner, this$0, this$0.getDialogTheme(), 0, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.c1
            @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
            public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                AuthenticateUserAction.V(AuthenticateUserAction.this, booleanVariableSpinner, macroDroidVariable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final AuthenticateUserAction this$0, Spinner booleanVariableSpinner, MacroDroidVariable macroDroidVariable) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        this$0.workingVariableName = macroDroidVariable.getName();
        this$0.workingDictionaryKeys = null;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.configureBooleanVarSpinner(activity, R.style.Theme_App_Dialog_Action, this$0, booleanVariableSpinner, this$0.getMacro(), true, listOf, macroDroidVariable.getName(), "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.AuthenticateUserAction$handleItemSelected$1$1$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                AuthenticateUserAction.this.workingVariableName = null;
                AuthenticateUserAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                AuthenticateUserAction.this.workingVariableName = variable.getName();
                AuthenticateUserAction authenticateUserAction = AuthenticateUserAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                authenticateUserAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(EditText titleText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(titleText, "$titleText");
        int max = Math.max(titleText.getSelectionStart(), 0);
        int max2 = Math.max(titleText.getSelectionEnd(), 0);
        Editable text = titleText.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(AuthenticateUserAction this$0, MagicText.MagicTextListener titleMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(titleMagicTextListener, "$titleMagicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), titleMagicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText titleText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(titleText, "$titleText");
        int max = Math.max(titleText.getSelectionStart(), 0);
        int max2 = Math.max(titleText.getSelectionEnd(), 0);
        Editable text = titleText.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AuthenticateUserAction this$0, MagicText.MagicTextListener subtitleMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(subtitleMagicTextListener, "$subtitleMagicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), subtitleMagicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(EditText titleText, AuthenticateUserAction this$0, Spinner booleanVariableSpinner, String noBooleanVarsConfigured, EditText subtitleText, CheckBox allowPinCheckbox, AppCompatDialog dialog, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(titleText, "$titleText");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        Intrinsics.checkNotNullParameter(noBooleanVarsConfigured, "$noBooleanVarsConfigured");
        Intrinsics.checkNotNullParameter(subtitleText, "$subtitleText");
        Intrinsics.checkNotNullParameter(allowPinCheckbox, "$allowPinCheckbox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Editable text = titleText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "titleText.text");
        if (text.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.action_confirm_enter_title_label, 0).show();
        } else if (booleanVariableSpinner.getAdapter().getCount() != 0 && !Intrinsics.areEqual(booleanVariableSpinner.getSelectedItem(), noBooleanVarsConfigured)) {
            if (this$0.workingVariableName == null) {
                ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.action_set_variable_select, 0).show();
                return;
            }
            this$0.title = titleText.getText().toString();
            this$0.subtitle = subtitleText.getText().toString();
            this$0.variableName = this$0.workingVariableName;
            this$0.dictionaryKeys = this$0.workingDictionaryKeys;
            this$0.preventPasswordPin = !allowPinCheckbox.isChecked();
            dialog.dismiss();
            this$0.itemComplete();
        } else {
            ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.invalid_value, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.title;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return AuthenticateUserActionInfo.Companion.getInstance();
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
        return new String[]{this.title, this.subtitle};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        List listOf;
        String str;
        List listOf2;
        BiometricManager from = BiometricManager.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        if (from.canAuthenticate(255) != 0 && from.canAuthenticate(32768) != 0) {
            ToastCompat.makeText(getContext(), (int) R.string.device_does_not_support_authentication, 1).show();
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_authenticate_user_config);
        appCompatDialog.setTitle(R.string.action_authenticate_user);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        View findViewById = appCompatDialog.findViewById(R.id.titleText);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.subtitleText);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText2 = (EditText) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.addVariableButton);
        Intrinsics.checkNotNull(findViewById3);
        View findViewById4 = appCompatDialog.findViewById(R.id.booleanVariableSpinner);
        Intrinsics.checkNotNull(findViewById4);
        final Spinner spinner = (Spinner) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.titleMagicTextButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.subtitleMagicTextButton);
        Intrinsics.checkNotNull(findViewById6);
        Button button2 = (Button) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.allowPinOrSwipePatternCheckBox);
        Intrinsics.checkNotNull(findViewById7);
        final CheckBox checkBox = (CheckBox) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById8);
        Button button3 = (Button) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById9);
        Button button4 = (Button) findViewById9;
        editText.setText(this.title);
        editText2.setText(this.subtitle);
        checkBox.setChecked(!this.preventPasswordPin);
        ((Button) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthenticateUserAction.U(AuthenticateUserAction.this, spinner, view);
            }
        });
        this.workingVariableName = this.variableName;
        this.workingDictionaryKeys = this.dictionaryKeys;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        String str2 = this.variableName;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureBooleanVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner, macro, true, listOf, str, "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.AuthenticateUserAction$handleItemSelected$2
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                AuthenticateUserAction.this.workingVariableName = null;
                AuthenticateUserAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                AuthenticateUserAction.this.workingVariableName = variable.getName();
                AuthenticateUserAction authenticateUserAction = AuthenticateUserAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                authenticateUserAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
        final String string = getContext().getString(R.string.no_boolean_variables_configured);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ean_variables_configured)");
        if (spinner.getCount() == 0) {
            Activity activity3 = getActivity();
            listOf2 = kotlin.collections.e.listOf(string);
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity3, (int) R.layout.simple_spinner_item, listOf2);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.w0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AuthenticateUserAction.W(editText, magicTextPair);
            }
        };
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthenticateUserAction.X(AuthenticateUserAction.this, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.y0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AuthenticateUserAction.Y(editText, magicTextPair);
            }
        };
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthenticateUserAction.Z(AuthenticateUserAction.this, magicTextListener2, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthenticateUserAction.a0(editText, this, spinner, string, editText2, checkBox, appCompatDialog, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthenticateUserAction.b0(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.title = magicText[0];
            this.subtitle = magicText[1];
            return;
        }
        int length = magicText.length;
        SystemLog.logError("Invalid magic text array size: " + length);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.title);
        out.writeString(this.subtitle);
        out.writeString(this.variableName);
        out.writeParcelable(this.dictionaryKeys, i4);
        out.writeInt(this.preventPasswordPin ? 1 : 0);
    }

    public AuthenticateUserAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        String titleWithMagicText = g(this.title, triggerContextInfo);
        String subtitleWithMagicText = g(this.subtitle, triggerContextInfo);
        AuthenticateUserActivity.Companion companion = AuthenticateUserActivity.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(titleWithMagicText, "titleWithMagicText");
        Intrinsics.checkNotNullExpressionValue(subtitleWithMagicText, "subtitleWithMagicText");
        String str = this.variableName;
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        companion.show(context, titleWithMagicText, subtitleWithMagicText, str, dictionaryKeys, macroGuid.longValue(), getSIGUID(), triggerContextInfo, i4, skipEndifIndexStack, z4, z3, !this.preventPasswordPin, resumeMacroInfo);
    }

    public AuthenticateUserAction() {
        this.title = "";
        this.subtitle = "";
    }

    private AuthenticateUserAction(Parcel parcel) {
        super(parcel);
        List emptyList;
        this.title = "";
        this.subtitle = "";
        String readString = parcel.readString();
        this.title = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.subtitle = readString2 != null ? readString2 : "";
        this.variableName = parcel.readString();
        DictionaryKeys dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        if (dictionaryKeys == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            dictionaryKeys = new DictionaryKeys(emptyList);
        }
        this.dictionaryKeys = dictionaryKeys;
        this.preventPasswordPin = parcel.readInt() != 0;
    }

    /* compiled from: AuthenticateUserAction.kt */
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
