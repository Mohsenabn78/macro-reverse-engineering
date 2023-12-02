package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.categories.HasMacroNames;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.LastRunTimeConstraintInfo;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class LastRunTimeConstraint extends Constraint implements HasMacroNames {
    public static final Parcelable.Creator<LastRunTimeConstraint> CREATOR = new a();
    private boolean checkThisMacro;
    private boolean m_invoked;
    private List<Long> m_macroIds;
    private transient List<Macro> m_macroList;
    private List<String> m_macroNames;
    private transient int m_parentType;
    private transient int m_selectedCount;
    private int m_timePeriodSeconds;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<LastRunTimeConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LastRunTimeConstraint createFromParcel(Parcel parcel) {
            return new LastRunTimeConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LastRunTimeConstraint[] newArray(int i4) {
            return new LastRunTimeConstraint[i4];
        }
    }

    /* synthetic */ LastRunTimeConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T() {
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
        strArr[0] = getContext().getString(R.string.constraint_last_run_time_this_macro);
        this.m_selectedCount = 0;
        boolean[] zArr = new boolean[size];
        if (this.checkThisMacro) {
            zArr[0] = true;
            this.m_selectedCount = 0 + 1;
        }
        for (int i4 = 1; i4 < size; i4++) {
            int i5 = i4 - 1;
            strArr[i4] = this.m_macroList.get(i5).getName();
            if (this.m_macroList.get(i5).getIsFavourite()) {
                strArr[i4] = "⭐ " + strArr[i4];
            }
            int i6 = 0;
            while (true) {
                if (i6 >= this.m_macroIds.size()) {
                    break;
                } else if (this.m_macroIds.get(i6).equals(Long.valueOf(this.m_macroList.get(i5).getGUID()))) {
                    zArr[i4] = true;
                    this.m_selectedCount++;
                    break;
                } else {
                    i6++;
                }
            }
        }
        String string = getContext().getString(R.string.constraint_last_run_time_select_macros);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(string);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.b2
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i7, boolean z4) {
                LastRunTimeConstraint.this.V(dialogInterface, i7, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.c2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                LastRunTimeConstraint.this.W(dialogInterface, i7);
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

    private void U() {
        int i4;
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.last_invoked_constraint);
        if (this.m_invoked) {
            i4 = R.string.constraint_last_run_time_invoked_within;
        } else {
            i4 = R.string.constraint_last_run_time_not_invoked_for;
        }
        appCompatDialog.setTitle(i4);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.last_invoked_constraint_second_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.last_invoked_constraint_minute_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.last_invoked_constraint_hour_picker);
        numberPicker.setMaximum(59);
        boolean z3 = false;
        numberPicker.setMinimum(0);
        numberPicker2.setMaximum(59);
        numberPicker2.setMinimum(0);
        numberPicker3.setMinimum(0);
        numberPicker.setValue(this.m_timePeriodSeconds % 60);
        int i5 = this.m_timePeriodSeconds;
        if (i5 > 59) {
            numberPicker2.setValue((i5 / 60) % 60);
        }
        int i6 = this.m_timePeriodSeconds;
        if (i6 > 3599) {
            numberPicker3.setValue(i6 / 3600);
        }
        NumberPicker.Listener listener = new NumberPicker.Listener() { // from class: com.arlosoft.macrodroid.constraint.d2
            @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
            public final void valueUpdated() {
                LastRunTimeConstraint.X(button, numberPicker2, numberPicker3, numberPicker);
            }
        };
        numberPicker.setListener(listener);
        numberPicker2.setListener(listener);
        numberPicker3.setListener(listener);
        if (this.m_timePeriodSeconds != 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LastRunTimeConstraint.this.Y(numberPicker, numberPicker2, numberPicker3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i4, boolean z3) {
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
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getListView().getCheckedItemPositions();
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        this.m_macroNames.clear();
        this.m_macroIds.clear();
        this.checkThisMacro = false;
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                if (checkedItemPositions.keyAt(i5) == 0) {
                    this.checkThisMacro = true;
                } else {
                    this.m_macroNames.add(this.m_macroList.get(checkedItemPositions.keyAt(i5) - 1).getName());
                    this.m_macroIds.add(Long.valueOf(this.m_macroList.get(checkedItemPositions.keyAt(i5) - 1).getGUID()));
                }
            }
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(Button button, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        boolean z3;
        if (button != null) {
            if (numberPicker.getValue() == 0 && numberPicker2.getValue() == 0 && numberPicker3.getValue() == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            button.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, AppCompatDialog appCompatDialog, View view) {
        this.m_timePeriodSeconds = numberPicker.getValue() + (numberPicker2.getValue() * 60) + (numberPicker3.getValue() * 3600);
        appCompatDialog.dismiss();
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_option_invoked), MacroDroidApplication.getInstance().getString(R.string.constraint_last_run_time_option_not_invoked)};
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
        this.m_invoked = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        long lastRunTime;
        long j4;
        long time = new Date().getTime();
        long j5 = 1000;
        if (this.m_macroIds.size() == 0) {
            if (getMacro() != null) {
                if (this.m_parentType == 1) {
                    j4 = Database.getInstance().getPreviousRunTime(getMacro().getGUID());
                } else {
                    j4 = Database.getInstance().getLastRunTime(getMacro().getGUID());
                }
            } else {
                j4 = 0;
            }
            if (j4 > 0) {
                long j6 = (time - j4) / 1000;
                boolean z3 = this.m_invoked;
                if (!z3 && j6 < this.m_timePeriodSeconds) {
                    return false;
                }
                if (z3 && j6 >= this.m_timePeriodSeconds) {
                    return false;
                }
            } else {
                return !this.m_invoked;
            }
        } else {
            for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosIncludingExtras()) {
                if (this.checkThisMacro && !this.m_macroIds.contains(Long.valueOf(getMacro().getGUID()))) {
                    this.m_macroIds.add(Long.valueOf(getMacro().getGUID()));
                }
                for (Long l4 : this.m_macroIds) {
                    long longValue = l4.longValue();
                    if (longValue == macro.getGUID()) {
                        if (getMacro() != null && longValue == getMacro().getGUID()) {
                            if (this.m_parentType == 1) {
                                lastRunTime = Database.getInstance().getPreviousRunTime(longValue);
                            } else {
                                lastRunTime = Database.getInstance().getLastRunTime(longValue);
                            }
                        } else {
                            lastRunTime = Database.getInstance().getLastRunTime(longValue);
                        }
                        if (lastRunTime > 0) {
                            long j7 = (time - lastRunTime) / j5;
                            boolean z4 = this.m_invoked;
                            if (!z4 && j7 < this.m_timePeriodSeconds) {
                                return false;
                            }
                            if (z4 && j7 >= this.m_timePeriodSeconds) {
                                return false;
                            }
                        } else {
                            return !this.m_invoked;
                        }
                    }
                    j5 = 1000;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        this.m_parentType = L();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_invoked ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4;
        Context context = getContext();
        if (this.m_invoked) {
            i4 = R.string.constraint_last_run_time_macros_invoked;
        } else {
            i4 = R.string.constraint_last_run_time_macros_not_invoked;
        }
        return context.getString(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        String str;
        if (this.m_invoked) {
            i4 = R.string.constraint_last_run_time_invoked_within;
        } else {
            i4 = R.string.constraint_last_run_time_not_invoked_for;
        }
        String r4 = SelectableItem.r(i4);
        if (this.checkThisMacro) {
            if (this.m_macroIds.size() == 0) {
                str = SelectableItem.r(R.string.constraint_last_run_time_this_macro) + ": ";
            } else if (this.m_macroIds.size() == 1) {
                str = SelectableItem.r(R.string.constraint_last_run_time_this_macro) + " + \"" + this.m_macroNames.get(0) + "\": ";
            } else {
                str = SelectableItem.r(R.string.constraint_last_run_time_this_macro) + " + " + this.m_macroNames.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.macros) + ": ";
            }
        } else if (this.m_macroIds.size() == 1) {
            str = "\"" + this.m_macroNames.get(0) + "\": ";
        } else if (this.m_macroIds.size() > 1) {
            str = this.m_macroNames.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.macros) + ": ";
        } else {
            str = "";
        }
        int i5 = this.m_timePeriodSeconds;
        if (i5 >= 3600) {
            return str + r4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds / 3600) + SelectableItem.r(R.string.hour_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((this.m_timePeriodSeconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
        } else if (i5 >= 60) {
            return str + r4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((this.m_timePeriodSeconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
        } else {
            return str + r4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LastRunTimeConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public List<String> getMacroNames() {
        return this.m_macroNames;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        boolean z3;
        if (this.checkThisMacro) {
            return true;
        }
        List<Macro> allCompletedMacrosIncludingExtras = MacroStore.getInstance().getAllCompletedMacrosIncludingExtras();
        for (Long l4 : this.m_macroIds) {
            long longValue = l4.longValue();
            Iterator<Macro> it = allCompletedMacrosIncludingExtras.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getGUID() == longValue) {
                        z3 = true;
                        continue;
                        break;
                    }
                } else {
                    z3 = false;
                    continue;
                    break;
                }
            }
            if (!z3) {
                return false;
            }
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
        T();
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public void setMacroNames(List<String> list) {
        this.m_macroNames = list;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_invoked ? 1 : 0);
        parcel.writeInt(this.m_timePeriodSeconds);
        parcel.writeList(this.m_macroIds);
        parcel.writeStringList(this.m_macroNames);
        parcel.writeInt(this.checkThisMacro ? 1 : 0);
    }

    public LastRunTimeConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private LastRunTimeConstraint() {
        this.m_timePeriodSeconds = 0;
        this.m_invoked = true;
        this.m_macroIds = new ArrayList();
        this.m_macroNames = new ArrayList();
    }

    private LastRunTimeConstraint(Parcel parcel) {
        super(parcel);
        this.m_invoked = parcel.readInt() != 0;
        this.m_timePeriodSeconds = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.m_macroIds = arrayList;
        parcel.readList(arrayList, null);
        ArrayList arrayList2 = new ArrayList();
        this.m_macroNames = arrayList2;
        parcel.readStringList(arrayList2);
        this.checkThisMacro = parcel.readInt() != 0;
    }
}
