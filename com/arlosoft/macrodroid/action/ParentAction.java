package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ParentAction extends ConditionAction {
    private transient List<Action> childActions;
    private boolean childrenCollapsed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public List<Action> getChildActions() {
        return this.childActions;
    }

    public List<Integer> getChildIcons() {
        try {
            ArrayList arrayList = new ArrayList();
            for (Action action : this.childActions) {
                if (!(action instanceof EndParentAction)) {
                    arrayList.add(Integer.valueOf(action.getIcon()));
                }
                if (action instanceof ParentAction) {
                    break;
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public boolean getChildrenCollapsed() {
        return this.childrenCollapsed;
    }

    public void setChildActions(List<Action> list) {
        this.childActions = list;
    }

    public void setChildrenCollapsed(boolean z3) {
        this.childrenCollapsed = z3;
    }

    @Override // com.arlosoft.macrodroid.action.ConditionAction, com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.childrenCollapsed ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentAction() {
        this.childActions = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParentAction(Parcel parcel) {
        super(parcel);
        this.childActions = new ArrayList();
        this.childrenCollapsed = parcel.readInt() != 0;
    }
}
