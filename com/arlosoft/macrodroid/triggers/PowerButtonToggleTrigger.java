package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.PowerButtonToggleTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.PowerButtonToggleTriggerReceiver;

/* loaded from: classes3.dex */
public class PowerButtonToggleTrigger extends Trigger {
    private static PowerButtonToggleTriggerReceiver s_screenOnOffTriggerReceiver;
    private int m_numToggles;
    private static final String[] s_options = {ExifInterface.GPS_MEASUREMENT_3D, "4", "5"};
    private static int s_triggerCounter = 0;
    public static final Parcelable.Creator<PowerButtonToggleTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<PowerButtonToggleTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PowerButtonToggleTrigger createFromParcel(Parcel parcel) {
            return new PowerButtonToggleTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PowerButtonToggleTrigger[] newArray(int i4) {
            return new PowerButtonToggleTrigger[i4];
        }
    }

    /* synthetic */ PowerButtonToggleTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_numToggles = i4 + 3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_screenOnOffTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_screenOnOffTriggerReceiver = new PowerButtonToggleTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_numToggles - 3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.trigger_power_button_toggle) + " (" + this.m_numToggles + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PowerButtonToggleTriggerInfo.getInstance();
    }

    public int getNumToggles() {
        return this.m_numToggles;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return s_options;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.trigger_power_button_toggle_num_presses);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_numToggles);
    }

    public PowerButtonToggleTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public PowerButtonToggleTrigger() {
        this.m_numToggles = 3;
    }

    private PowerButtonToggleTrigger(Parcel parcel) {
        super(parcel);
        this.m_numToggles = parcel.readInt();
    }
}
