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
import com.arlosoft.macrodroid.triggers.info.GPSEnabledTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.GPSEnabledTriggerReceiver;

/* loaded from: classes3.dex */
public class GPSEnabledTrigger extends Trigger {
    public static final Parcelable.Creator<GPSEnabledTrigger> CREATOR = new a();
    private static GPSEnabledTriggerReceiver s_gpsTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_gpsModeEnabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<GPSEnabledTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GPSEnabledTrigger createFromParcel(Parcel parcel) {
            return new GPSEnabledTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GPSEnabledTrigger[] newArray(int i4) {
            return new GPSEnabledTrigger[i4];
        }
    }

    /* synthetic */ GPSEnabledTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_gps_enabled_enabled), MacroDroidApplication.getInstance().getString(R.string.trigger_gps_enabled_disabled)};
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
        this.m_gpsModeEnabled = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_gpsTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_gpsTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_gpsTriggerReceiver = new GPSEnabledTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_gpsTriggerReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_gpsModeEnabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_gpsModeEnabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    public boolean getGPSEnabled() {
        return this.m_gpsModeEnabled;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return GPSEnabledTriggerInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_gpsModeEnabled ? 1 : 0);
    }

    public GPSEnabledTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private GPSEnabledTrigger() {
        this.m_gpsModeEnabled = true;
    }

    private GPSEnabledTrigger(Parcel parcel) {
        super(parcel);
        this.m_gpsModeEnabled = parcel.readInt() != 0;
    }
}
