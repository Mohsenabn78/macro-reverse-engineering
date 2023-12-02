package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ElseActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class ElseParentAction extends ConditionAction {
    public static final Parcelable.Creator<ElseParentAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ElseParentAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ElseParentAction createFromParcel(Parcel parcel) {
            return new ElseParentAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ElseParentAction[] newArray(int i4) {
            return new ElseParentAction[i4];
        }
    }

    public ElseParentAction() {
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
    public SelectableItemInfo getInfo() {
        return ElseActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ElseParentAction(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }
}
