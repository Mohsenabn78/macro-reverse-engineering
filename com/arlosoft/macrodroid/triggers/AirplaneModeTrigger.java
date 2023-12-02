package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.AirplaneModeTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.AirplaneModeTriggerReceiver;

/* loaded from: classes3.dex */
public class AirplaneModeTrigger extends Trigger {
    public static final Parcelable.Creator<AirplaneModeTrigger> CREATOR = new a();
    private static AirplaneModeTriggerReceiver s_airplaneModeTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_airplaneModeEnabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AirplaneModeTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AirplaneModeTrigger createFromParcel(Parcel parcel) {
            return new AirplaneModeTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AirplaneModeTrigger[] newArray(int i4) {
            return new AirplaneModeTrigger[i4];
        }
    }

    /* synthetic */ AirplaneModeTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_airplane_mode_enabled), MacroDroidApplication.getInstance().getString(R.string.trigger_airplane_mode_disabled)};
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
        this.m_airplaneModeEnabled = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_airplaneModeTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_airplaneModeTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_airplaneModeTriggerReceiver = new AirplaneModeTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_airplaneModeTriggerReceiver, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
        }
        s_triggerCounter++;
    }

    public boolean getAirplaneModeEnabled() {
        return this.m_airplaneModeEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_airplaneModeEnabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_airplaneModeEnabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AirplaneModeTriggerInfo.Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_airplaneModeEnabled ? 1 : 0);
    }

    public AirplaneModeTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AirplaneModeTrigger() {
        this.m_airplaneModeEnabled = true;
    }

    private AirplaneModeTrigger(Parcel parcel) {
        super(parcel);
        this.m_airplaneModeEnabled = parcel.readInt() != 0;
    }
}
