package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.SelectModeActivity;
import com.arlosoft.macrodroid.action.info.SetModeActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class SetModeAction extends Action implements HasStringVariableName, BlockingAction {
    private boolean blockNextAction;
    private String m_mode;
    private transient List<String> m_modeList;
    private String m_variableName;
    private DictionaryKeys varDictionaryKeys;
    private transient boolean variableSelected;
    private static final String USER_PROMPT_TEXT = SelectableItem.r(R.string.user_prompt);
    public static final Parcelable.Creator<SetModeAction> CREATOR = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Function1<List<String>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f2492a;

        a(MacroDroidVariable macroDroidVariable) {
            this.f2492a = macroDroidVariable;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(List<String> list) {
            SetModeAction.this.m_variableName = this.f2492a.getName();
            SetModeAction.this.varDictionaryKeys = new DictionaryKeys(list);
            SetModeAction.this.itemComplete();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SetModeAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetModeAction createFromParcel(Parcel parcel) {
            return new SetModeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetModeAction[] newArray(int i4) {
            return new SetModeAction[i4];
        }
    }

    /* synthetic */ SetModeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void P() {
        final ArrayList<MacroDroidVariable> allOutputVariablesWithStrings = getAllOutputVariablesWithStrings();
        if (allOutputVariablesWithStrings.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_string_variables_defined, 0).show();
            return;
        }
        String[] strArr = new String[allOutputVariablesWithStrings.size()];
        int i4 = 0;
        for (int i5 = 0; i5 < allOutputVariablesWithStrings.size(); i5++) {
            String name = allOutputVariablesWithStrings.get(i5).getName();
            strArr[i5] = name;
            String str = this.m_variableName;
            if (str != null && str.equals(name)) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_variable_select);
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetModeAction.this.R(allOutputVariablesWithStrings, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private static final String Q() {
        return "[" + SelectableItem.r(R.string.string) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.variable_short_name) + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(List list, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition > list.size()) {
            ToastCompat.makeText(getContext(), (int) R.string.variable_does_not_exit, 0).show();
            return;
        }
        MacroDroidVariable macroDroidVariable = (MacroDroidVariable) list.get(checkedItemPosition);
        if (!macroDroidVariable.isDictionary() && !macroDroidVariable.isArray()) {
            this.varDictionaryKeys = null;
            this.m_variableName = macroDroidVariable.getName();
            itemComplete();
            return;
        }
        VariableHelper.showSelectKeyDialog(getActivity(), R.style.Theme_App_Dialog_Action, macroDroidVariable, getMacro(), false, macroDroidVariable.getDictionary(), null, new ArrayList(), 0, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, false, this, true, new a(macroDroidVariable));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        this.variableSelected = z3;
        this.m_mode = this.m_modeList.get(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        if (!this.m_mode.equals(getContext().getString(R.string.user_prompt)) && this.m_variableName == null && !modeListFromString.contains(this.m_mode)) {
            modeListFromString.add(this.m_mode);
        }
        Settings.setModeList(getContext(), Util.getModeListString(modeListFromString));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_variableName != null) {
            return 1;
        }
        return this.m_modeList.indexOf(this.m_mode);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(SelectableItem.r(R.string.action_set_mode_set_mode));
        sb.append(": ");
        if (this.m_variableName != null) {
            str = this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = this.m_mode;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetModeActionInfo.getInstance();
    }

    public String getMode() {
        return this.m_mode;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public String getVariableName() {
        return this.m_variableName;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        if (this.m_variableName == null && !this.m_mode.equals(USER_PROMPT_TEXT) && !modeListFromString.contains(this.m_mode)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        this.m_modeList = modeListFromString;
        modeListFromString.add(0, Q());
        this.m_modeList.add(0, USER_PROMPT_TEXT);
        String[] strArr = new String[this.m_modeList.size()];
        this.m_modeList.toArray(strArr);
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        boolean z3;
        if (this.m_variableName != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.variableSelected = z3;
        super.onItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_set_mode_select);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!this.variableSelected) {
            this.m_variableName = null;
            super.secondaryItemConfirmed();
            return;
        }
        P();
    }

    public void setMode(String str) {
        this.m_mode = str;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(String str) {
        this.m_variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_mode);
        parcel.writeString(this.m_variableName);
        parcel.writeInt(this.blockNextAction ? 1 : 0);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public SetModeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        String str = this.m_variableName;
        if (str != null) {
            MacroDroidVariable variableByName = getVariableByName(str);
            if (variableByName == null) {
                SystemLog.logError("Set mode failed, variable does not exist (" + this.m_variableName + ")", getMacroGuid().longValue());
                return;
            }
            String stringValue = variableByName.getStringValue(this.varDictionaryKeys);
            if (stringValue != null) {
                Util.setMode(getContext(), MagicText.replaceMagicText(getContext().getApplicationContext(), stringValue, triggerContextInfo, getMacro()));
                if (z4) {
                    return;
                }
                getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
                return;
            }
            SystemLog.logError("Set mode failed, variable does not exist (" + this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + ")", getMacroGuid().longValue());
        } else if (this.m_mode.equals(USER_PROMPT_TEXT)) {
            Intent intent = new Intent(getContext(), SelectModeActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(Util.EXTRA_GUID, this.m_macro.getGUID());
            intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, this.m_macro.getTriggerThatInvoked());
            intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
            intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
            intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, stack);
            intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
            intent.putExtra(Constants.EXTRA_IS_TEST, z4);
            intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
            intent.putExtra(Constants.EXTRA_BLOCK_NEXT_ACTION, this.blockNextAction);
            getContext().startActivity(intent);
        } else {
            Util.setMode(getContext(), this.m_mode);
            if (z4) {
                return;
            }
            getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
        }
    }

    public SetModeAction() {
        this.blockNextAction = true;
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        this.m_modeList = modeListFromString;
        modeListFromString.add(0, USER_PROMPT_TEXT);
        this.m_mode = this.m_modeList.get(0);
    }

    private SetModeAction(Parcel parcel) {
        super(parcel);
        this.blockNextAction = true;
        this.m_mode = parcel.readString();
        this.m_variableName = parcel.readString();
        this.blockNextAction = parcel.readInt() != 0;
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }
}
