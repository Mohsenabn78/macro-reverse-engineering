package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ModeEnterExitTriggerInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class ModeEnterExitTrigger extends Trigger implements HasStringVariableName {
    private boolean m_anyChange;
    private String m_mode;
    private boolean m_modeEntered;
    private transient List<String> m_modeList;
    private String m_variableName;
    private DictionaryKeys varDictionaryKeys;
    private static final String FROM_VARIABLE_TEXT = "[" + SelectableItem.r(R.string.string) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.variable_short_name) + "]";
    public static final Parcelable.Creator<ModeEnterExitTrigger> CREATOR = new b();

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<ModeEnterExitTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ModeEnterExitTrigger createFromParcel(Parcel parcel) {
            return new ModeEnterExitTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ModeEnterExitTrigger[] newArray(int i4) {
            return new ModeEnterExitTrigger[i4];
        }
    }

    /* synthetic */ ModeEnterExitTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T() {
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
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ModeEnterExitTrigger.this.U(dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.o5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ModeEnterExitTrigger.this.V(allOutputVariablesWithStrings, strArr, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4) {
        C(i4);
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
            T();
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
        VariableHelper.showSelectKeyDialog(getActivity(), R.style.Theme_App_Dialog_Action, dictionary, null, str, false, new VariableHelper.ManualKeyOption(true, null), false, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, true, new a(arrayList, macroDroidVariable, i4));
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_mode_enter_exit_enter), SelectableItem.r(R.string.trigger_mode_enter_exit_exit), SelectableItem.r(R.string.trigger_mode_enter_exit_any_change)};
    }

    private void init() {
        this.m_modeList = Util.getModeListFromString(Settings.getModeList(getContext()));
        this.m_modeEntered = true;
        this.m_mode = SelectableItem.r(R.string.mode_standard);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        boolean z4 = true;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_modeEntered = z3;
        if (i4 != 2) {
            z4 = false;
        }
        this.m_anyChange = z4;
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
        if (this.m_anyChange) {
            return 2;
        }
        if (this.m_modeEntered) {
            return 0;
        }
        return 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_anyChange) {
            return getOptions()[2];
        }
        if (this.m_modeEntered) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_variableName != null) {
            return this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        }
        String str = this.m_mode;
        if (str != null) {
            return str;
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ModeEnterExitTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public boolean getMacroDroidModeEnabled() {
        return this.m_modeEntered;
    }

    public String getMode() {
        return this.m_mode;
    }

    public boolean getTriggerOnAnyChange() {
        return this.m_anyChange;
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

    public boolean matchesMode(String str) {
        String str2 = this.m_variableName;
        if (str2 != null) {
            MacroDroidVariable variableByName = getVariableByName(str2);
            if (variableByName == null) {
                SystemLog.logError("Mode trigger check failed, variable does not exist (" + this.m_variableName + ")", getMacroGuid().longValue());
                return false;
            }
            String stringValue = variableByName.getStringValue(this.varDictionaryKeys);
            if (stringValue != null) {
                return str.equals(stringValue);
            }
            SystemLog.logError("Mode trigger check failed, variable does not exist (" + this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + ")", getMacroGuid().longValue());
            return false;
        }
        return this.m_mode.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!checkActivityAlive()) {
            return;
        }
        if (this.m_anyChange) {
            itemComplete();
            return;
        }
        List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(getContext()));
        this.m_modeList = modeListFromString;
        int i4 = 0;
        modeListFromString.add(0, FROM_VARIABLE_TEXT);
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
        builder.setTitle(R.string.select_mode);
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                ModeEnterExitTrigger.this.W(dialogInterface, i7);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.m5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                ModeEnterExitTrigger.this.X(dialogInterface, i7);
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
        parcel.writeInt(this.m_modeEntered ? 1 : 0);
        parcel.writeInt(this.m_anyChange ? 1 : 0);
        parcel.writeString(this.m_mode);
        parcel.writeString(this.m_variableName);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public ModeEnterExitTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ModeEnterExitTrigger() {
        init();
    }

    private ModeEnterExitTrigger(Parcel parcel) {
        super(parcel);
        init();
        this.m_modeEntered = parcel.readInt() != 0;
        this.m_anyChange = parcel.readInt() != 0;
        this.m_mode = parcel.readString();
        this.m_variableName = parcel.readString();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements VariableHelper.KeyDialogOptionChosenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f14386a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f14387b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f14388c;

        a(ArrayList arrayList, MacroDroidVariable macroDroidVariable, int i4) {
            this.f14386a = arrayList;
            this.f14387b = macroDroidVariable;
            this.f14388c = i4;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void keyChosen(@NonNull VariableValue.DictionaryEntry dictionaryEntry) {
            this.f14386a.add(dictionaryEntry.getKey());
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                ModeEnterExitTrigger.this.Y(this.f14387b, (VariableValue.Dictionary) dictionaryEntry.getVariable(), this.f14386a, this.f14388c + 1);
                return;
            }
            ModeEnterExitTrigger.this.varDictionaryKeys = new DictionaryKeys(this.f14386a);
            ModeEnterExitTrigger.this.m_variableName = this.f14387b.getName();
            ModeEnterExitTrigger.this.itemComplete();
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

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
