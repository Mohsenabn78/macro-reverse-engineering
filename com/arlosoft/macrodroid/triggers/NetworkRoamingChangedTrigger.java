package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.NetworkRoamingChangedTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.NetworkRoamingChangedTriggerReceiver;

/* loaded from: classes3.dex */
public class NetworkRoamingChangedTrigger extends Trigger {
    public static final Parcelable.Creator<NetworkRoamingChangedTrigger> CREATOR = new a();
    private static NetworkRoamingChangedTriggerReceiver s_networkRoamingReceiver;
    private static int s_triggerCounter;
    private boolean m_roamingEnabled;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<NetworkRoamingChangedTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NetworkRoamingChangedTrigger createFromParcel(Parcel parcel) {
            return new NetworkRoamingChangedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NetworkRoamingChangedTrigger[] newArray(int i4) {
            return new NetworkRoamingChangedTrigger[i4];
        }
    }

    /* synthetic */ NetworkRoamingChangedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_network_roaming_change_started), SelectableItem.r(R.string.trigger_network_roaming_change_stopped)};
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
        this.m_roamingEnabled = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_networkRoamingReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_networkRoamingReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_networkRoamingReceiver = new NetworkRoamingChangedTriggerReceiver();
            NetworkRoamingChangedTriggerReceiver.initialiseOldRoamingValue(getContext());
            MacroDroidApplication.getInstance().registerReceiver(s_networkRoamingReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_roamingEnabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_roamingEnabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return NetworkRoamingChangedTriggerInfo.getInstance();
    }

    public boolean isRoamingEnabled() {
        return this.m_roamingEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_roamingEnabled ? 1 : 0);
    }

    public NetworkRoamingChangedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private NetworkRoamingChangedTrigger() {
        this.m_roamingEnabled = true;
    }

    private NetworkRoamingChangedTrigger(Parcel parcel) {
        super(parcel);
        this.m_roamingEnabled = parcel.readInt() != 0;
    }
}
