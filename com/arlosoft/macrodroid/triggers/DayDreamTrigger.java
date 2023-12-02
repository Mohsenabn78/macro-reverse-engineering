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
import com.arlosoft.macrodroid.triggers.info.DayDreamTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.DayDreamTriggerReceiver;

/* loaded from: classes3.dex */
public class DayDreamTrigger extends Trigger {
    private static DayDreamTriggerReceiver s_dayDreamTriggerReceiver;
    private static int s_triggerCounter;
    private boolean m_dayDreamEnabled;
    private static final Object s_lock = new Object();
    public static final Parcelable.Creator<DayDreamTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DayDreamTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DayDreamTrigger createFromParcel(Parcel parcel) {
            return new DayDreamTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DayDreamTrigger[] newArray(int i4) {
            return new DayDreamTrigger[i4];
        }
    }

    /* synthetic */ DayDreamTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_daydream_on), MacroDroidApplication.getInstance().getString(R.string.trigger_daydream_off)};
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
        this.m_dayDreamEnabled = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_dayDreamTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_dayDreamTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_dayDreamTriggerReceiver = new DayDreamTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.DREAMING_STARTED");
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.DREAMING_STOPPED");
            MacroDroidApplication.getInstance().registerReceiver(s_dayDreamTriggerReceiver, intentFilter);
            MacroDroidApplication.getInstance().registerReceiver(s_dayDreamTriggerReceiver, intentFilter2);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_dayDreamEnabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_dayDreamEnabled) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    public boolean getDayDreamEnabled() {
        return this.m_dayDreamEnabled;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DayDreamTriggerInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_dayDreamEnabled ? 1 : 0);
    }

    public DayDreamTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DayDreamTrigger() {
        this.m_dayDreamEnabled = true;
    }

    private DayDreamTrigger(Parcel parcel) {
        super(parcel);
        this.m_dayDreamEnabled = parcel.readInt() != 0;
    }
}
