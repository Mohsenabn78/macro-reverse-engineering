package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.categories.HasMacroNames;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.MacroEnabledConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class MacroEnabledConstraint extends Constraint implements HasMacroNames {
    public static final Parcelable.Creator<MacroEnabledConstraint> CREATOR = new a();
    private boolean m_enabled;
    private List<Long> m_macroIds;
    private transient List<Macro> m_macroList;
    private List<String> m_macroNames;
    private transient int m_selectedCount;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<MacroEnabledConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MacroEnabledConstraint createFromParcel(Parcel parcel) {
            return new MacroEnabledConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MacroEnabledConstraint[] newArray(int i4) {
            return new MacroEnabledConstraint[i4];
        }
    }

    /* synthetic */ MacroEnabledConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q() {
        boolean z3 = true;
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        this.m_macroList = allCompletedMacrosSorted;
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (it.hasNext()) {
            if (getMacro().getGUID() == it.next().getGUID()) {
                it.remove();
            }
        }
        int size = this.m_macroList.size() + 1;
        String[] strArr = new String[size];
        this.m_selectedCount = 0;
        boolean[] zArr = new boolean[size];
        int i4 = 0;
        while (i4 < this.m_macroList.size()) {
            int i5 = i4 + 1;
            strArr[i5] = this.m_macroList.get(i4).getName();
            if (this.m_macroList.get(i4).getIsFavourite()) {
                strArr[i5] = "⭐ " + strArr[i5];
            }
            int i6 = 0;
            while (true) {
                if (i6 >= this.m_macroIds.size()) {
                    break;
                } else if (this.m_macroIds.get(i6).equals(Long.valueOf(this.m_macroList.get(i4).getGUID()))) {
                    zArr[i5] = true;
                    this.m_selectedCount++;
                    break;
                } else {
                    i6++;
                }
            }
            i4 = i5;
        }
        strArr[0] = R();
        int i7 = 0;
        while (true) {
            if (i7 >= this.m_macroIds.size()) {
                break;
            } else if (this.m_macroIds.get(i7).equals(Long.valueOf(getMacro().getGUID()))) {
                zArr[0] = true;
                this.m_selectedCount++;
                break;
            } else {
                i7++;
            }
        }
        String string = getContext().getString(R.string.constraint_last_run_time_select_macros);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(string);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.y2
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i8, boolean z4) {
                MacroEnabledConstraint.this.U(dialogInterface, i8, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.z2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                MacroEnabledConstraint.this.V(dialogInterface, i8);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        Button button = create.getButton(-1);
        if (this.m_selectedCount <= 0) {
            z3 = false;
        }
        button.setEnabled(z3);
    }

    private static final String R() {
        return MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_this_macro);
    }

    private boolean S(Macro macro) {
        Set<String> disabledCategories = Settings.getDisabledCategories(MacroDroidApplication.getInstance());
        if (macro != null && !macro.isExtra() && disabledCategories.contains(macro.getCategory())) {
            return true;
        }
        return false;
    }

    private boolean T(Macro macro) {
        if (macro != null && macro.isEnabled() && !S(macro)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4 = true;
        if (z3) {
            this.m_selectedCount++;
        } else {
            this.m_selectedCount--;
        }
        Button button = ((AlertDialog) dialogInterface).getButton(-1);
        if (this.m_selectedCount <= 0) {
            z4 = false;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i4) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getListView().getCheckedItemPositions();
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        this.m_macroNames.clear();
        this.m_macroIds.clear();
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                if (checkedItemPositions.keyAt(i5) == 0) {
                    this.m_macroNames.add(R());
                    this.m_macroIds.add(Long.valueOf(getMacro().getGUID()));
                } else {
                    this.m_macroNames.add(this.m_macroList.get(checkedItemPositions.keyAt(i5) - 1).getName());
                    this.m_macroIds.add(Long.valueOf(this.m_macroList.get(checkedItemPositions.keyAt(i5) - 1).getGUID()));
                }
            }
        }
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_macro_enabled_macros_enabled), MacroDroidApplication.getInstance().getString(R.string.constraint_macro_enabled_macros_disabled)};
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
        this.m_enabled = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        MacroStore macroStore = MacroStore.getInstance();
        for (Long l4 : this.m_macroIds) {
            if (T(macroStore.getMacroByGUID(l4.longValue())) != this.m_enabled) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[!this.m_enabled ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_macroNames.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MacroEnabledConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + ": " + this.m_macroNames.toString();
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public List<String> getMacroNames() {
        return this.m_macroNames;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Q();
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public void setMacroNames(List<String> list) {
        this.m_macroNames = list;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_enabled ? 1 : 0);
        parcel.writeList(this.m_macroIds);
        parcel.writeStringList(this.m_macroNames);
    }

    public MacroEnabledConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MacroEnabledConstraint() {
        this.m_enabled = true;
        this.m_macroIds = new ArrayList();
        this.m_macroNames = new ArrayList();
    }

    private MacroEnabledConstraint(Parcel parcel) {
        super(parcel);
        this.m_enabled = true;
        this.m_enabled = parcel.readInt() != 0;
        ArrayList arrayList = new ArrayList();
        this.m_macroIds = arrayList;
        parcel.readList(arrayList, null);
        ArrayList arrayList2 = new ArrayList();
        this.m_macroNames = arrayList2;
        parcel.readStringList(arrayList2);
    }
}
