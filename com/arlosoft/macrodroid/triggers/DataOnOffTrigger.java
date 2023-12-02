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
import com.arlosoft.macrodroid.triggers.info.DataOnOffTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.ConnectivityChangeReceiver;

/* loaded from: classes3.dex */
public class DataOnOffTrigger extends Trigger {
    public static final Parcelable.Creator<DataOnOffTrigger> CREATOR = new a();
    private static ConnectivityChangeReceiver s_connectivityChangeTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_dataAvailable;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DataOnOffTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DataOnOffTrigger createFromParcel(Parcel parcel) {
            return new DataOnOffTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DataOnOffTrigger[] newArray(int i4) {
            return new DataOnOffTrigger[i4];
        }
    }

    /* synthetic */ DataOnOffTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_data_on_off_available), MacroDroidApplication.getInstance().getString(R.string.trigger_data_on_off_no_connection)};
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
        this.m_dataAvailable = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_connectivityChangeTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_connectivityChangeTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_connectivityChangeTriggerReceiver = new ConnectivityChangeReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_connectivityChangeTriggerReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_dataAvailable ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_dataAvailable) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    public boolean getDataAvailable() {
        return this.m_dataAvailable;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DataOnOffTriggerInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_dataAvailable ? 1 : 0);
    }

    public DataOnOffTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DataOnOffTrigger() {
        this.m_dataAvailable = true;
    }

    private DataOnOffTrigger(Parcel parcel) {
        super(parcel);
        this.m_dataAvailable = parcel.readInt() != 0;
    }
}
