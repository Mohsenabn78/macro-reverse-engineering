package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.DeleteSMSActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class DeleteSMSAction extends Action {
    public static final Parcelable.Creator<DeleteSMSAction> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DeleteSMSAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeleteSMSAction createFromParcel(Parcel parcel) {
            return new DeleteSMSAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DeleteSMSAction[] newArray(int i4) {
            return new DeleteSMSAction[i4];
        }
    }

    /* synthetic */ DeleteSMSAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        return SelectableItem.r(R.string.not_available_policy_restrictions);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DeleteSMSActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        SystemLog.logError(SelectableItem.r(R.string.not_available_policy_restrictions));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return false;
    }

    public DeleteSMSAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DeleteSMSAction() {
    }

    private DeleteSMSAction(Parcel parcel) {
        super(parcel);
    }
}
