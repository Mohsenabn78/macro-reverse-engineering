package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.info.ElseActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class ElseAction extends ElseParentAction {
    public static final Parcelable.Creator<ElseAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ElseAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ElseAction createFromParcel(Parcel parcel) {
            return new ElseAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ElseAction[] newArray(int i4) {
            return new ElseAction[i4];
        }
    }

    public ElseAction() {
    }

    @Override // com.arlosoft.macrodroid.action.ElseParentAction, com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ElseActionInfo.getInstance();
    }

    protected ElseAction(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.ElseParentAction, com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }
}
