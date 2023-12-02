package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.DeviceUnlockedTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.DeviceUnlockedTriggerReceiver;

/* loaded from: classes3.dex */
public class DeviceUnlockedTrigger extends Trigger {
    public static final Parcelable.Creator<DeviceUnlockedTrigger> CREATOR = new a();
    private static DeviceUnlockedTriggerReceiver s_deviceUnlockedTriggerReceiver;
    private static int s_triggerCounter;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DeviceUnlockedTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeviceUnlockedTrigger createFromParcel(Parcel parcel) {
            return new DeviceUnlockedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DeviceUnlockedTrigger[] newArray(int i4) {
            return new DeviceUnlockedTrigger[i4];
        }
    }

    /* synthetic */ DeviceUnlockedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_deviceUnlockedTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_deviceUnlockedTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_deviceUnlockedTriggerReceiver = new DeviceUnlockedTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_deviceUnlockedTriggerReceiver, new IntentFilter("android.intent.action.USER_PRESENT"));
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DeviceUnlockedTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    public DeviceUnlockedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DeviceUnlockedTrigger() {
    }

    private DeviceUnlockedTrigger(Parcel parcel) {
        super(parcel);
    }
}
