package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetAutoRotateActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SetAutoRotateAction extends Action {
    public static final Parcelable.Creator<SetAutoRotateAction> CREATOR = new a();
    private int m_state;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetAutoRotateAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetAutoRotateAction createFromParcel(Parcel parcel) {
            return new SetAutoRotateAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetAutoRotateAction[] newArray(int i4) {
            return new SetAutoRotateAction[i4];
        }
    }

    /* synthetic */ SetAutoRotateAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static void M(ContentResolver contentResolver, boolean z3) {
        Settings.System.putInt(contentResolver, "accelerometer_rotation", z3 ? 1 : 0);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_autorotate_on), SelectableItem.r(R.string.action_set_autorotate_off), SelectableItem.r(R.string.action_set_autorotate_toggle)};
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
        return SetAutoRotateActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        try {
            int i4 = this.m_state;
            boolean z3 = true;
            if (i4 != 0 && (i4 == 1 || (i4 == 2 && Settings.System.getInt(getContext().getContentResolver(), "accelerometer_rotation") != 0))) {
                z3 = false;
            }
            M(getContext().getContentResolver(), z3);
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to update auto rotate setting: " + e4.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return true;
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
    }

    public SetAutoRotateAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetAutoRotateAction() {
        this.m_state = 0;
    }

    private SetAutoRotateAction(Parcel parcel) {
        super(parcel);
        this.m_state = parcel.readInt();
    }
}
