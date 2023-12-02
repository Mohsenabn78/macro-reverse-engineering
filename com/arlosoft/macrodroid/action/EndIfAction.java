package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.info.EndIfActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class EndIfAction extends EndParentAction {
    public static final Parcelable.Creator<EndIfAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<EndIfAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EndIfAction createFromParcel(Parcel parcel) {
            return new EndIfAction(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public EndIfAction[] newArray(int i4) {
            return new EndIfAction[i4];
        }
    }

    /* synthetic */ EndIfAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return EndIfActionInfo.getInstance();
    }

    public EndIfAction() {
    }

    private EndIfAction(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }
}
