package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.LogicConstraintInfo;
import com.arlosoft.macrodroid.editscreen.SelectableItemsViewHolder;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class LogicConstraint extends Constraint {
    public static final Parcelable.Creator<LogicConstraint> CREATOR = new a();
    private static final int OPTION_LOGIC_AND = 0;
    private static final int OPTION_LOGIC_NOT = 3;
    private static final int OPTION_LOGIC_OR = 1;
    private static final int OPTION_LOGIC_XOR = 2;
    private List<Constraint> m_childConstraints;
    private int m_option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<LogicConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LogicConstraint createFromParcel(Parcel parcel) {
            return new LogicConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LogicConstraint[] newArray(int i4) {
            return new LogicConstraint[i4];
        }
    }

    /* synthetic */ LogicConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q(Constraint constraint) {
        if (constraint.getConstraints() != null) {
            for (Constraint constraint2 : constraint.getConstraints()) {
                Q(constraint2);
            }
        }
        constraint.disableConstraintChecking();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(AppCompatDialog appCompatDialog, CheckBox checkBox, View view) {
        appCompatDialog.dismiss();
        if (checkBox.isChecked()) {
            Settings.setShowLogicConstraintInfo(getContext(), false);
        }
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.dismiss();
        handleItemCancel();
    }

    private void T() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_logic_constraint_explanation);
        appCompatDialog.setTitle(R.string.constraint_logic);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!getActivity().getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.dontShowAgainCheckbox);
        Macro macro = new Macro();
        LogicConstraint logicConstraint = new LogicConstraint(getActivity(), macro);
        logicConstraint.setOption(1);
        TimeOfDayConstraint timeOfDayConstraint = new TimeOfDayConstraint(getActivity(), macro);
        timeOfDayConstraint.setStartTime(18, 0);
        timeOfDayConstraint.setEndTime(0, 0);
        logicConstraint.addConstraint(timeOfDayConstraint);
        DayOfWeekConstraint dayOfWeekConstraint = new DayOfWeekConstraint(getActivity(), macro);
        dayOfWeekConstraint.setDaysOfWeek(new boolean[]{false, true, true, true, true, true, false});
        logicConstraint.addConstraint(dayOfWeekConstraint);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.include_macro_item, (ViewGroup) ((FrameLayout) appCompatDialog.findViewById(R.id.exampleContainer)), true);
        inflate.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.constraints_primary));
        new SelectableItemsViewHolder(getActivity(), macro, inflate, null, null, null, Observable.just(Boolean.FALSE), null).bind(logicConstraint, new ArrayList(), 0, false, false, false, false, false, false, false, true, false);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogicConstraint.this.R(appCompatDialog, checkBox, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogicConstraint.this.S(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_logic_and), MacroDroidApplication.getInstance().getString(R.string.constraint_logic_or), MacroDroidApplication.getInstance().getString(R.string.constraint_logic_xor), MacroDroidApplication.getInstance().getString(R.string.constraint_logic_not)};
    }

    private void init() {
        this.m_childConstraints = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void addConstraint(Constraint constraint) {
        this.m_childConstraints.add(constraint);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @CallSuper
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        for (Constraint constraint : this.m_childConstraints) {
            constraint.anonymizeForTemplate();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void applyImport() {
        for (Constraint constraint : this.m_childConstraints) {
            constraint.applyImport();
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (this.m_childConstraints.size() == 0) {
            return true;
        }
        int i4 = this.m_option;
        if (i4 == 0) {
            for (Constraint constraint : this.m_childConstraints) {
                if (constraint.isEnabled() && !constraint.constraintMet(triggerContextInfo)) {
                    return false;
                }
            }
            return true;
        } else if (i4 == 1) {
            int i5 = 0;
            for (Constraint constraint2 : this.m_childConstraints) {
                if (constraint2.isEnabled()) {
                    i5++;
                    if (constraint2.constraintMet(triggerContextInfo)) {
                        return true;
                    }
                }
            }
            if (i5 <= 0) {
                return true;
            }
            return false;
        } else if (i4 == 2) {
            int i6 = 0;
            for (Constraint constraint3 : this.m_childConstraints) {
                if (constraint3.isEnabled() && constraint3.constraintMet(triggerContextInfo)) {
                    i6++;
                }
            }
            if (i6 == 1) {
                return true;
            }
            return false;
        } else {
            if (i4 == 3) {
                for (Constraint constraint4 : this.m_childConstraints) {
                    if (constraint4.isEnabled() && constraint4.constraintMet(triggerContextInfo)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        for (Constraint constraint : this.m_childConstraints) {
            constraint.disableConstraintChecking();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        for (Constraint constraint : this.m_childConstraints) {
            if (constraint.isEnabled()) {
                constraint.enableConstraintChecking(z3);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void forceRemoveConstraint(Constraint constraint) {
        this.m_childConstraints.remove(constraint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        StringBuilder sb = new StringBuilder();
        sb.append(getOptions()[this.m_option]);
        sb.append(" (");
        for (int i4 = 0; i4 < this.m_childConstraints.size(); i4++) {
            sb.append(this.m_childConstraints.get(i4).getConfiguredName());
            if (i4 < this.m_childConstraints.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public List<Constraint> getConstraints() {
        return this.m_childConstraints;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditMacroConfiguredName() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LogicConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getRequiredPermissions() {
        ArrayList arrayList = new ArrayList();
        for (Constraint constraint : this.m_childConstraints) {
            String[] requiredPermissions = constraint.getRequiredPermissions();
            if (requiredPermissions.length > 0) {
                Collections.addAll(arrayList, requiredPermissions);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Settings.getShowLogicConstraintInfo(getContext())) {
            T();
        } else {
            super.handleItemSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_logic);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void removeConstraint(Constraint constraint) {
        Q(constraint);
        this.m_childConstraints.remove(constraint);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void setMacro(Macro macro) {
        super.setMacro(macro);
        List<Constraint> list = this.m_childConstraints;
        if (list != null) {
            for (Constraint constraint : list) {
                constraint.setMacro(this.m_macro);
            }
        }
    }

    public void setOption(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeList(this.m_childConstraints);
    }

    public LogicConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private LogicConstraint() {
        init();
    }

    private LogicConstraint(Parcel parcel) {
        super(parcel);
        init();
        this.m_option = parcel.readInt();
        this.m_childConstraints = parcel.readArrayList(Constraint.class.getClassLoader());
    }
}
