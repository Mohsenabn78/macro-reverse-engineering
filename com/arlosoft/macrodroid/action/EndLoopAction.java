package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.action.info.EndLoopActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class EndLoopAction extends EndParentAction {
    public static final Parcelable.Creator<EndLoopAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<EndLoopAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EndLoopAction createFromParcel(Parcel parcel) {
            return new EndLoopAction(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public EndLoopAction[] newArray(int i4) {
            return new EndLoopAction[i4];
        }
    }

    /* synthetic */ EndLoopAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return EndLoopActionInfo.getInstance();
    }

    public EndLoopAction() {
    }

    private EndLoopAction(Parcel parcel) {
        super(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }
}
