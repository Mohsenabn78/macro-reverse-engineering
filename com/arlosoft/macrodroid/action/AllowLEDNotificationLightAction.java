package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.AllowLEDNotificationLightActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.LegacySystemCommands;

/* loaded from: classes2.dex */
public class AllowLEDNotificationLightAction extends Action {
    public static final Parcelable.Creator<AllowLEDNotificationLightAction> CREATOR = new a();
    private boolean m_enabled;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AllowLEDNotificationLightAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AllowLEDNotificationLightAction createFromParcel(Parcel parcel) {
            return new AllowLEDNotificationLightAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AllowLEDNotificationLightAction[] newArray(int i4) {
            return new AllowLEDNotificationLightAction[i4];
        }
    }

    /* synthetic */ AllowLEDNotificationLightAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_allow_LED_notification_on), MacroDroidApplication.getInstance().getString(R.string.action_allow_LED_notification_off)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_enabled = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[!this.m_enabled ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AllowLEDNotificationLightActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = getContext();
            boolean z3 = this.m_enabled;
            LegacySystemCommands.sendSystemCommandInt(context, "notification_light_pulse", z3 ? 1 : 0, getMacro().getName());
            return;
        }
        Settings.System.putInt(getContext().getContentResolver(), "notification_light_pulse", this.m_enabled ? 1 : 0);
        Settings.System.putInt(getContext().getContentResolver(), "led_indicator_charing", this.m_enabled ? 1 : 0);
        Settings.System.putInt(getContext().getContentResolver(), "led_indicator_charging", this.m_enabled ? 1 : 0);
        Settings.System.putInt(getContext().getContentResolver(), "led_indicator_low_battery", this.m_enabled ? 1 : 0);
        Settings.System.putInt(getContext().getContentResolver(), "led_indicator_missed_event", this.m_enabled ? 1 : 0);
        Settings.System.putInt(getContext().getContentResolver(), "led_indicator_voice_recording", this.m_enabled ? 1 : 0);
        Settings.System.putInt(getContext().getContentResolver(), "lge_notification_light_pulse", this.m_enabled ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLegacyHelperFile() {
        return true;
    }

    public void setEnabledState(boolean z3) {
        this.m_enabled = z3;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_enabled ? 1 : 0);
    }

    public AllowLEDNotificationLightAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AllowLEDNotificationLightAction() {
        this.m_enabled = true;
    }

    private AllowLEDNotificationLightAction(Parcel parcel) {
        super(parcel);
        this.m_enabled = parcel.readInt() == 0;
    }
}
