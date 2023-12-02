package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.IfConditionActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class IfConditionAction extends ParentAction {
    public static final Parcelable.Creator<IfConditionAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<IfConditionAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IfConditionAction createFromParcel(Parcel parcel) {
            return new IfConditionAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IfConditionAction[] newArray(int i4) {
            return new IfConditionAction[i4];
        }
    }

    public IfConditionAction() {
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction
    protected String X() {
        return SelectableItem.r(R.string.enter_condition_if);
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction
    protected String Y() {
        StringBuilder sb = new StringBuilder(SelectableItem.r(R.string.if_condition_short));
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getCollapsedName() {
        return getConfiguredName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.if_condition_short);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
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
        return IfConditionActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 160) + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        V(true, true);
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (getConstraints().size() == 0) {
            return false;
        }
        for (Constraint constraint : getConstraints()) {
            if (constraint.isEnabled() && !constraint.isValid() && !constraint.canRunWhenInvalid()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.ParentAction, com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public IfConditionAction(Activity activity, Macro macro) {
        super(activity, macro);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IfConditionAction(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }
}
