package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ProximityTriggerInfo;
import com.arlosoft.macrodroid.utils.NearFarListener;

/* loaded from: classes3.dex */
public class ProximityTrigger extends Trigger {
    public static final Parcelable.Creator<ProximityTrigger> CREATOR = new a();
    private static final int OPTION_PROXIMITY_FAR = 1;
    private static final int OPTION_PROXIMITY_FAST_WAVE = 3;
    private static final int OPTION_PROXIMITY_NEAR = 0;
    private static final int OPTION_PROXIMITY_SLOW_WAVE = 2;
    private static final int SLOW_WAVE_TIME_MS = 500;
    private static c sPreviousState = null;
    private static b s_ProximityListener = null;
    private static boolean s_screenOn = false;
    private static ScreenOnOffReceiver s_screenOnOffTriggerReceiver = null;
    private static boolean s_sensorLive = false;
    private static long s_transitionToNearTimestamp;
    private static int s_triggerCounter;
    private boolean m_near;
    private int m_selectedOption;

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ProximityTrigger.Q(intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ProximityTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ProximityTrigger createFromParcel(Parcel parcel) {
            return new ProximityTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ProximityTrigger[] newArray(int i4) {
            return new ProximityTrigger[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements NearFarListener.NearFarChangedListener {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.arlosoft.macrodroid.utils.NearFarListener.NearFarChangedListener
        public void onChange(boolean z3) {
            ProximityTrigger.P(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum c {
        NONE,
        NEAR,
        FAR
    }

    /* synthetic */ ProximityTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private int O() {
        return getCheckedItemIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010f A[LOOP:2: B:70:0x0109->B:72:0x010f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void P(boolean r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.ProximityTrigger.P(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(boolean z3) {
        s_screenOn = z3;
        R();
    }

    private static void R() {
        if (!s_screenOn && !Settings.getProximitySensorScreenOffSetting(MacroDroidApplication.getInstance())) {
            if (s_sensorLive) {
                sPreviousState = c.NONE;
                NearFarListener.removeListener(s_ProximityListener);
                s_sensorLive = false;
            }
        } else if (s_triggerCounter > 0) {
            if (!s_sensorLive) {
                sPreviousState = c.NONE;
                NearFarListener.addListener(s_ProximityListener, NearFarListener.Priority.TRIGGER);
                s_sensorLive = true;
            }
        } else if (s_sensorLive) {
            sPreviousState = c.NONE;
            NearFarListener.removeListener(s_ProximityListener);
            s_sensorLive = false;
        }
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_proximity_near), SelectableItem.r(R.string.trigger_proximity_far), SelectableItem.r(R.string.trigger_proximity_slow_wave), SelectableItem.r(R.string.trigger_proximity_fast_wave)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedOption = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        s_triggerCounter--;
        R();
        if (s_triggerCounter == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffTriggerReceiver);
            } catch (Exception e4) {
                SystemLog.logDebug("Failed to unregister screen on off trigger receiver for ProximityTrigger");
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_screenOnOffTriggerReceiver = null;
            s_ProximityListener = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (this.m_selectedOption == -1) {
            this.m_selectedOption = !this.m_near ? 1 : 0;
        }
        if (s_triggerCounter == 0) {
            s_ProximityListener = new b(null);
            s_screenOnOffTriggerReceiver = new ScreenOnOffReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffTriggerReceiver, intentFilter);
            s_screenOn = ((PowerManager) getContext().getSystemService("power")).isScreenOn();
        }
        s_triggerCounter++;
        R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = this.m_selectedOption;
        if (i4 >= 0) {
            return i4;
        }
        return !this.m_near ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[getCheckedItemIndex()];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ProximityTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public boolean getNear() {
        return this.m_near;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.select_option);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(!this.m_near ? 1 : 0);
        parcel.writeInt(this.m_selectedOption);
    }

    public ProximityTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ProximityTrigger() {
        this.m_near = true;
        this.m_selectedOption = -1;
    }

    private ProximityTrigger(Parcel parcel) {
        super(parcel);
        this.m_near = parcel.readInt() == 0;
        this.m_selectedOption = parcel.readInt();
    }
}
