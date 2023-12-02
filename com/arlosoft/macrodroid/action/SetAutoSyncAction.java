package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetAutoSyncActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SetAutoSyncAction extends Action {
    public static final Parcelable.Creator<SetAutoSyncAction> CREATOR = new a();
    private boolean m_selectAccounts;
    private int m_state;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetAutoSyncAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetAutoSyncAction createFromParcel(Parcel parcel) {
            return new SetAutoSyncAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetAutoSyncAction[] newArray(int i4) {
            return new SetAutoSyncAction[i4];
        }
    }

    /* synthetic */ SetAutoSyncAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_autosync_on), SelectableItem.r(R.string.action_set_autosync_off), SelectableItem.r(R.string.action_set_autosync_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetAutoSyncActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            int i4 = this.m_state;
            boolean z3 = true;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        z3 = true ^ ContentResolver.getMasterSyncAutomatically();
                    }
                } else {
                    z3 = false;
                }
            }
            ContentResolver.setMasterSyncAutomatically(z3);
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to update background sync: " + e4.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
        parcel.writeInt(this.m_selectAccounts ? 1 : 0);
    }

    public SetAutoSyncAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetAutoSyncAction() {
        this.m_state = 0;
    }

    private SetAutoSyncAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
        this.m_selectAccounts = parcel.readInt() != 0;
    }
}
