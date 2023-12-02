package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.BatterySaverTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.BatterySaverTriggerReceiver;

/* loaded from: classes3.dex */
public class BatterySaverTrigger extends Trigger {
    public static final Parcelable.Creator<BatterySaverTrigger> CREATOR = new a();
    public static final int STATE_DISABLED = 1;
    public static final int STATE_ENABLED = 0;
    private static BatterySaverTriggerReceiver s_batterySaverTrigger;
    private static int s_triggerCounter;
    private int m_option;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<BatterySaverTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatterySaverTrigger createFromParcel(Parcel parcel) {
            return new BatterySaverTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatterySaverTrigger[] newArray(int i4) {
            return new BatterySaverTrigger[i4];
        }
    }

    /* synthetic */ BatterySaverTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.enabled), MacroDroidApplication.getInstance().getString(R.string.disabled)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0 && s_batterySaverTrigger != null) {
            MacroDroidApplication.getInstance().unregisterReceiver(s_batterySaverTrigger);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_batterySaverTrigger = new BatterySaverTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_batterySaverTrigger, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatterySaverTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public int getOption() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getTemplateConfiguredName() {
        return getName() + "(" + getExtendedDetail() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public BatterySaverTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BatterySaverTrigger() {
    }

    private BatterySaverTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
