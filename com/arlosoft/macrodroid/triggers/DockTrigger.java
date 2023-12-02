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
import com.arlosoft.macrodroid.triggers.info.DockTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.DockTriggerReceiver;

/* loaded from: classes3.dex */
public class DockTrigger extends Trigger {
    public static final int ANY_DOCK = 0;
    public static final int CAR_DOCK = 2;
    public static final Parcelable.Creator<DockTrigger> CREATOR = new a();
    public static final int DESK_DOCK = 1;
    public static final int UNDOCKED = 3;
    private static DockTriggerReceiver s_dockTriggerReceiver;
    private static int s_triggerCounter;
    private int m_dockType;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DockTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DockTrigger createFromParcel(Parcel parcel) {
            return new DockTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DockTrigger[] newArray(int i4) {
            return new DockTrigger[i4];
        }
    }

    /* synthetic */ DockTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_dock_any), MacroDroidApplication.getInstance().getString(R.string.trigger_dock_desk), MacroDroidApplication.getInstance().getString(R.string.trigger_dock_car), MacroDroidApplication.getInstance().getString(R.string.trigger_dock_undock)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_dockType = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_dockTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_dockTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_dockTriggerReceiver = new DockTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.DOCK_EVENT");
            intentFilter.setPriority(Integer.MAX_VALUE);
            MacroDroidApplication.getInstance().registerReceiver(s_dockTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_dockType;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_dockType];
    }

    public int getDockType() {
        return this.m_dockType;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DockTriggerInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.trigger_dock_select);
    }

    public void setDockType(int i4) {
        this.m_dockType = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_dockType);
    }

    public DockTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DockTrigger() {
        this.m_dockType = 0;
    }

    private DockTrigger(Parcel parcel) {
        super(parcel);
        this.m_dockType = parcel.readInt();
    }
}
