package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.SignalOnOffTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.PhoneStateMonitorService;

/* loaded from: classes3.dex */
public class SignalOnOffTrigger extends Trigger {
    public static final Parcelable.Creator<SignalOnOffTrigger> CREATOR = new a();
    private static int s_triggerCounter;
    private boolean m_signalOn;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<SignalOnOffTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SignalOnOffTrigger createFromParcel(Parcel parcel) {
            return new SignalOnOffTrigger(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SignalOnOffTrigger[] newArray(int i4) {
            return new SignalOnOffTrigger[i4];
        }
    }

    public SignalOnOffTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_signal_on_off_available), SelectableItem.r(R.string.trigger_signal_on_off_unavailable)};
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
        this.m_signalOn = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            MacroDroidApplication.getInstance().stopService(new Intent(getContext(), PhoneStateMonitorService.class));
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            MacroDroidApplication.getInstance().startService(new Intent(getContext(), PhoneStateMonitorService.class));
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_signalOn ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_signalOn) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SignalOnOffTriggerInfo.getInstance();
    }

    public boolean getSignalOn() {
        return this.m_signalOn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_signalOn ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignalOnOffTrigger() {
        this.m_signalOn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SignalOnOffTrigger(Parcel parcel) {
        super(parcel);
        this.m_signalOn = parcel.readInt() != 0;
    }
}
