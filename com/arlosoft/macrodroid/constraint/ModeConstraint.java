package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.info.ModeConstraintInfo;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class ModeConstraint extends Constraint implements HasStringVariableName {
    private String m_mode;
    private transient List<String> m_modeList;
    private boolean m_modeSelected;
    private String m_variableName;
    private DictionaryKeys varDictionaryKeys;
    private static final String FROM_VARIABLE_TEXT = "[" + SelectableItem.r(R.string.string) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.variable_short_name) + "]";
    public static final Parcelable.Creator<ModeConstraint> CREATOR = new b();

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<ModeConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ModeConstraint createFromParcel(Parcel parcel) {
            return new ModeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ModeConstraint[] newArray(int i4) {
            return new ModeConstraint[i4];
        }
    }

    /* synthetic */ ModeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void U() {
        final ArrayList<MacroDroidVariable> allOutputVariablesWithStrings = getAllOutputVariablesWithStrings();
        if (allOutputVariablesWithStrings.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_string_variables_defined, 0).show();
            return;
        }
        final String[] strArr = new String[allOutputVariablesWithStrings.size()];
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
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.f3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ModeConstraint.this.V(allOutputVariablesWithStrings, strArr, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(List list, String[] strArr, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        MacroDroidVariable macroDroidVariable = (MacroDroidVariable) list.get(checkedItemPosition);
        if (!macroDroidVariable.isDictionary() && !macroDroidVariable.isArray()) {
            this.varDictionaryKeys = null;
            this.m_variableName = strArr[checkedItemPosition];
            itemComplete();
            return;
        }
        Y(macroDroidVariable, macroDroidVariable.getDictionary(), new ArrayList<>(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        this.m_mode = this.m_modeList.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            U();
            return;
        }
        this.m_variableName = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList<String> arrayList, int i4) {
        String str;
        if (dictionary.getEntries().isEmpty()) {
            ToastCompat.makeText(getContext(), (int) R.string.variable_multi_entry_no_entries, 1).show();
            return;
        }
        if (arrayList.size() > i4) {
            str = arrayList.get(i4);
        } else {
            str = null;
        }
        VariableHelper.showSelectKeyDialog(getActivity(), R.style.Theme_App_Dialog_Action, dictionary, null, str, false, new VariableHelper.ManualKeyOption(false, null), false, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, true, new a(arrayList, macroDroidVariable, i4));
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_mode_current_mode), MacroDroidApplication.getInstance().getString(R.string.constraint_mode_not_in_mode)};
    }

    private void init() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        this.m_modeList = modeListFromString;
        this.m_modeSelected = true;
        if (modeListFromString.size() > 0) {
            this.m_mode = this.m_modeList.get(0);
        } else {
            this.m_mode = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_modeSelected = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        String mode = Settings.getMode(getContext());
        String str = this.m_variableName;
        if (str != null) {
            MacroDroidVariable variableByName = getVariableByName(str);
            if (variableByName == null) {
                SystemLog.logError("Mode constraint check failed, variable does not exist (" + this.m_variableName + ")", getMacroGuid().longValue());
                return false;
            }
            String stringValue = variableByName.getStringValue(this.varDictionaryKeys);
            if (stringValue == null) {
                SystemLog.logError("Mode constraint check failed, variable does not exist (" + this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + ")", getMacroGuid().longValue());
                return false;
            }
            String replaceMagicText = MagicText.replaceMagicText(getContext().getApplicationContext(), stringValue, triggerContextInfo, getMacro());
            if (this.m_modeSelected) {
                return replaceMagicText.equals(mode);
            }
            return !replaceMagicText.equals(mode);
        } else if (this.m_modeSelected) {
            return this.m_mode.equals(mode);
        } else {
            return !this.m_mode.equals(mode);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        if (!modeListFromString.contains(this.m_mode)) {
            modeListFromString.add(this.m_mode);
        }
        Settings.setModeList(getContext(), Util.getModeListString(modeListFromString));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_modeSelected ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        String str2;
        if (this.m_modeSelected) {
            StringBuilder sb = new StringBuilder();
            sb.append(getContext().getString(R.string.constraint_mode_mode));
            sb.append(" = ");
            if (this.m_variableName != null) {
                str2 = this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
            } else {
                str2 = this.m_mode;
            }
            sb.append(str2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getContext().getString(R.string.constraint_mode_mode));
        sb2.append(" != ");
        if (this.m_variableName != null) {
            str = this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = this.m_mode;
        }
        sb2.append(str);
        return sb2.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ModeConstraintInfo.getInstance();
    }

    public String getMode() {
        return this.m_mode;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public String getVariableName() {
        return this.m_variableName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        if (this.m_variableName == null && !modeListFromString.contains(this.m_mode)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!checkActivityAlive()) {
            return;
        }
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        this.m_modeList = modeListFromString;
        int i4 = 0;
        modeListFromString.add(0, FROM_VARIABLE_TEXT);
        if (this.m_modeList.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_modes_configured, 0).show();
            return;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.m_modeList.size(); i6++) {
            if (this.m_mode.equals(this.m_modeList.get(i6))) {
                i5 = i6;
            }
        }
        if (this.m_variableName == null) {
            i4 = i5;
        }
        String[] strArr = new String[this.m_modeList.size()];
        this.m_modeList.toArray(strArr);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.constraint_mode_select);
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.d3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                ModeConstraint.this.W(dialogInterface, i7);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.e3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                ModeConstraint.this.X(dialogInterface, i7);
            }
        });
        builder.create().show();
    }

    public void setMode(String str) {
        this.m_mode = str;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(String str) {
        this.m_variableName = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_mode);
        parcel.writeInt(this.m_modeSelected ? 1 : 0);
        parcel.writeString(this.m_variableName);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public ModeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ModeConstraint() {
        init();
    }

    private ModeConstraint(Parcel parcel) {
        super(parcel);
        this.m_mode = parcel.readString();
        this.m_modeSelected = parcel.readInt() != 0;
        this.m_variableName = parcel.readString();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements VariableHelper.KeyDialogOptionChosenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f10209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f10210b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10211c;

        a(ArrayList arrayList, MacroDroidVariable macroDroidVariable, int i4) {
            this.f10209a = arrayList;
            this.f10210b = macroDroidVariable;
            this.f10211c = i4;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void keyChosen(@NonNull VariableValue.DictionaryEntry dictionaryEntry) {
            this.f10209a.add(dictionaryEntry.getKey());
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                ModeConstraint.this.Y(this.f10210b, (VariableValue.Dictionary) dictionaryEntry.getVariable(), this.f10209a, this.f10211c + 1);
                return;
            }
            ModeConstraint.this.varDictionaryKeys = new DictionaryKeys(this.f10209a);
            ModeConstraint.this.m_variableName = this.f10210b.getName();
            ModeConstraint.this.itemComplete();
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void manualKeyEntryChosen(@Nullable List<String> list) {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void addKeyChosen() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void copyAllChosen() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void thisDictionaryChosen() {
        }
    }
}
