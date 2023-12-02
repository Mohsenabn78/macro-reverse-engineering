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
import com.arlosoft.macrodroid.triggers.info.HotspotTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.HotspotTriggerReceiver;

/* loaded from: classes3.dex */
public class HotspotTrigger extends Trigger {
    public static final Parcelable.Creator<HotspotTrigger> CREATOR = new a();
    private static HotspotTriggerReceiver s_hotspotTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_hotspotEnabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<HotspotTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public HotspotTrigger createFromParcel(Parcel parcel) {
            return new HotspotTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public HotspotTrigger[] newArray(int i4) {
            return new HotspotTrigger[i4];
        }
    }

    /* synthetic */ HotspotTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_hotspot_enabled), MacroDroidApplication.getInstance().getString(R.string.trigger_hotspot_disabled)};
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
        this.m_hotspotEnabled = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_hotspotTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_hotspotTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_hotspotTriggerReceiver = new HotspotTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_hotspotTriggerReceiver, new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED"));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_hotspotEnabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_hotspotEnabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    public boolean getHotspotEnabled() {
        return this.m_hotspotEnabled;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return HotspotTriggerInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_hotspotEnabled ? 1 : 0);
    }

    public HotspotTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private HotspotTrigger() {
        this.m_hotspotEnabled = true;
    }

    private HotspotTrigger(Parcel parcel) {
        super(parcel);
        this.m_hotspotEnabled = parcel.readInt() != 0;
    }
}
