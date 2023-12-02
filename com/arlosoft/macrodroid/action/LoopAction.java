package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.LoopActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class LoopAction extends ParentAction implements HasVariable, HasDictionaryKeys {
    public static final Parcelable.Creator<LoopAction> CREATOR = new c();
    public static final int OPTION_LOOP_DO_WHILE = 2;
    public static final int OPTION_LOOP_FIXED_NUMBER = 0;
    public static final int OPTION_LOOP_WHILE_DO = 1;
    private DictionaryKeys fixedOptionDictionaryKeys;
    private int m_fixedOptionCount;
    private MacroDroidVariable m_fixedOptionVariable;
    private transient int m_loopCount;
    protected int m_option;
    private transient int m_selectionOption;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient MacroDroidVariable workingVariable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f2300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f2301b;

        a(EditText editText, Button button) {
            this.f2300a = editText;
            this.f2301b = button;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            this.f2300a.setVisibility(0);
            LoopAction.this.workingVariable = null;
            LoopAction.this.workingDictionaryKeys = null;
            if (!TextUtils.isEmpty(this.f2300a.getText().toString()) && Integer.valueOf(this.f2300a.getText().toString()).intValue() != 0) {
                this.f2301b.setEnabled(true);
            } else {
                this.f2301b.setEnabled(false);
            }
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2300a.setVisibility(8);
            LoopAction.this.workingVariable = macroDroidVariable;
            LoopAction loopAction = LoopAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            loopAction.workingDictionaryKeys = dictionaryKeys;
            this.f2301b.setEnabled(true);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<LoopAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LoopAction createFromParcel(Parcel parcel) {
            return new LoopAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LoopAction[] newArray(int i4) {
            return new LoopAction[i4];
        }
    }

    public LoopAction() {
        this.m_fixedOptionCount = 0;
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_loop_fixed_number), SelectableItem.r(R.string.action_loop_while_do_option), SelectableItem.r(R.string.action_loop_do_while_option)};
    }

    private void n0() {
        String str;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_loop_for_configure);
        appCompatDialog.setTitle(R.string.action_loop);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        this.workingVariable = this.m_fixedOptionVariable;
        this.workingDictionaryKeys = this.fixedOptionDictionaryKeys;
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.dialog_loop_for_variable);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_loop_for_use_number_edittext);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        editText.setText(String.valueOf(this.m_fixedOptionCount));
        editText.setSelection(editText.length());
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.fixed_count));
        Activity activity = getActivity();
        Macro macro = getMacro();
        if (this.m_fixedOptionVariable != null) {
            str = this.m_fixedOptionVariable.getName() + VariableHelper.getFormattedDictionaryKeys(this.fixedOptionDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, "", false, new a(editText, button));
        if (this.workingVariable == null) {
            editText.setVisibility(0);
        } else {
            editText.setVisibility(8);
        }
        spinner.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.action.w9
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean o02;
                o02 = LoopAction.this.o0(spinner, view, motionEvent);
                return o02;
            }
        });
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoopAction.this.p0(editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.y9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean o0(Spinner spinner, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || spinner.getAdapter().getCount() > 1) {
            return false;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_integer_variables_defined, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_fixedOptionCount = Integer.valueOf(editText.getText().toString()).intValue();
        this.m_fixedOptionVariable = this.workingVariable;
        this.fixedOptionDictionaryKeys = this.workingDictionaryKeys;
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectionOption = i4;
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction
    protected String X() {
        return SelectableItem.r(R.string.enter_condition_loop);
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction
    protected String Y() {
        StringBuilder sb = new StringBuilder(getConfiguredName());
        if (this.m_option == 0) {
            return sb.toString();
        }
        sb.append(" (");
        int size = getConstraints().size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append(getConstraints().get(i4).getConfiguredName());
            if (i4 < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(") ");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = this.m_option;
        this.m_selectionOption = i4;
        return i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getCollapsedName() {
        return getConfiguredName() + ": " + getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Object obj;
        int i4 = this.m_option;
        if (i4 != 1) {
            if (i4 != 2) {
                String r4 = SelectableItem.r(R.string.action_loop_number_times);
                Object[] objArr = new Object[1];
                if (this.m_fixedOptionVariable == null) {
                    obj = Integer.valueOf(this.m_fixedOptionCount);
                } else {
                    obj = "<" + this.m_fixedOptionVariable.getName() + VariableHelper.getFormattedDictionaryKeys(this.fixedOptionDictionaryKeys) + ">";
                }
                objArr[0] = obj;
                return String.format(r4, objArr);
            }
            return SelectableItem.r(R.string.action_loop_do_while);
        }
        return getContext().getString(R.string.action_loop_while_do);
    }

    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.fixedOptionDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        if (this.m_option == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < 5; i5++) {
            if (getConstraints().size() > i5) {
                sb.append(getConstraints().get(i5).getConfiguredNameFlowControl());
                if (i5 < getConstraints().size() - 1 && i5 < 4) {
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (n()) {
                        i4 = R.string.or;
                    } else {
                        i4 = R.string.and;
                    }
                    sb.append(SelectableItem.r(i4));
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LoopActionInfo.getInstance();
    }

    public int getOption() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    public MacroDroidVariable getVariable() {
        return this.m_fixedOptionVariable;
    }

    public boolean incrementLoopCount() {
        int i4;
        int i5 = this.m_loopCount + 1;
        this.m_loopCount = i5;
        MacroDroidVariable macroDroidVariable = this.m_fixedOptionVariable;
        if (macroDroidVariable == null) {
            if (i5 <= this.m_fixedOptionCount) {
                return true;
            }
            return false;
        }
        MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
        if (variableByName != null) {
            Long longValue = variableByName.getLongValue(this.fixedOptionDictionaryKeys);
            if (longValue != null) {
                i4 = longValue.intValue();
                if (variableByName == null && this.m_loopCount <= i4) {
                    return true;
                }
                return false;
            }
            SystemLog.logError("Variable not found: " + variableByName.getName() + VariableHelper.getFormattedDictionaryKeys(this.fixedOptionDictionaryKeys));
        } else {
            SystemLog.logError("Variable not found: " + this.m_fixedOptionVariable.getName());
        }
        i4 = 0;
        if (variableByName == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        this.m_option = this.m_selectionOption;
        super.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void resetLoopCount() {
        this.m_loopCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_selectionOption;
        if (i4 != 0) {
            if (i4 == 1 || i4 == 2) {
                V(true, true);
                return;
            }
            return;
        }
        n0();
    }

    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.fixedOptionDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.ParentAction, com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_fixedOptionCount);
        parcel.writeParcelable(this.m_fixedOptionVariable, i4);
        parcel.writeParcelable(this.fixedOptionDictionaryKeys, i4);
    }

    public LoopAction(Activity activity, Macro macro) {
        super(activity, macro);
        this.m_fixedOptionCount = 0;
        setActivity(activity);
        this.m_macro = macro;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoopAction(Parcel parcel) {
        super(parcel);
        this.m_fixedOptionCount = 0;
        this.m_option = parcel.readInt();
        this.m_fixedOptionCount = parcel.readInt();
        this.m_fixedOptionVariable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.fixedOptionDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2303a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2304b;

        b(Button button, EditText editText) {
            this.f2303a = button;
            this.f2304b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            try {
                Button button = this.f2303a;
                if (!TextUtils.isEmpty(this.f2304b.getText().toString()) && Integer.valueOf(this.f2304b.getText().toString()).intValue() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button.setEnabled(z3);
            } catch (NumberFormatException unused) {
                this.f2303a.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
