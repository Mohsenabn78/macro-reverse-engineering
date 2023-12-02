package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Vibrator;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.FlipDeviceTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.FlipEventListener;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class FlipDeviceTrigger extends Trigger {
    private static FlipEventListener s_flipListener;
    private static boolean s_screenOn;
    private static ScreenOnOffReceiver s_screenOnOffTriggerReceiver;
    private boolean m_anyStart;
    private boolean m_faceDown;
    private boolean m_workWithScreenOff;
    private static final SensorManager s_sensorManager = (SensorManager) MacroDroidApplication.getInstance().getSystemService("sensor");
    private static int s_triggerCounter = 0;
    private static boolean s_sensorLive = false;
    public static final Parcelable.Creator<FlipDeviceTrigger> CREATOR = new b();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FlipDeviceTrigger.T(context, intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements FlipEventListener.OnFlipListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.triggers.receivers.FlipEventListener.OnFlipListener
        public void onFaceDown() {
            FlipDeviceTrigger.R();
        }

        @Override // com.arlosoft.macrodroid.triggers.receivers.FlipEventListener.OnFlipListener
        public void onFlip(boolean z3) {
            FlipDeviceTrigger.S(z3);
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<FlipDeviceTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FlipDeviceTrigger createFromParcel(Parcel parcel) {
            return new FlipDeviceTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FlipDeviceTrigger[] newArray(int i4) {
            return new FlipDeviceTrigger[i4];
        }
    }

    /* synthetic */ FlipDeviceTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean P() {
        return this.m_anyStart;
    }

    private boolean Q() {
        return this.m_faceDown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R() {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof FlipDeviceTrigger) && ((FlipDeviceTrigger) next).P() && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0 && Settings.getFlipDeviceVibrateSetting(MacroDroidApplication.getInstance())) {
            ((Vibrator) MacroDroidApplication.getInstance().getSystemService("vibrator")).vibrate(new long[]{0, 100}, -1);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof FlipDeviceTrigger) {
                    FlipDeviceTrigger flipDeviceTrigger = (FlipDeviceTrigger) next;
                    if (flipDeviceTrigger.Q() == z3 && (!z3 || !flipDeviceTrigger.P())) {
                        if (next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0 && Settings.getFlipDeviceVibrateSetting(MacroDroidApplication.getInstance())) {
            ((Vibrator) MacroDroidApplication.getInstance().getSystemService("vibrator")).vibrate(new long[]{0, 100}, -1);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(Context context, boolean z3) {
        s_screenOn = z3;
        updateTriggerState(context);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_flip_device_up_to_down), MacroDroidApplication.getInstance().getString(R.string.trigger_flip_device_down_to_up), MacroDroidApplication.getInstance().getString(R.string.trigger_flip_device_any_to_down)};
    }

    public static void updateTriggerState(Context context) {
        if (!s_screenOn && !Settings.getFlipDeviceScreenOffSetting(context)) {
            if (s_sensorLive) {
                s_sensorManager.unregisterListener(s_flipListener);
                s_sensorLive = false;
            }
        } else if (s_triggerCounter > 0) {
            if (!s_sensorLive) {
                s_flipListener.setOnFlipListener(new a());
                SensorManager sensorManager = s_sensorManager;
                sensorManager.registerListener(s_flipListener, sensorManager.getDefaultSensor(1), 3);
                s_sensorLive = true;
            }
        } else if (s_sensorLive) {
            s_sensorManager.unregisterListener(s_flipListener);
            s_sensorLive = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        boolean z4 = false;
        if (i4 != 0 && i4 != 2) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.m_faceDown = z3;
        if (i4 == 2) {
            z4 = true;
        }
        this.m_anyStart = z4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        s_triggerCounter--;
        updateTriggerState(getContext());
        if (s_triggerCounter == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_flipListener = null;
            s_screenOnOffTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_flipListener = new FlipEventListener();
            s_screenOnOffTriggerReceiver = new ScreenOnOffReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffTriggerReceiver, intentFilter);
            s_screenOn = ((PowerManager) getContext().getSystemService("power")).isScreenOn();
        }
        s_triggerCounter++;
        updateTriggerState(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (this.m_anyStart) {
            return 2;
        }
        return !this.m_faceDown ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_anyStart) {
            return getOptions()[2];
        }
        return getOptions()[!this.m_faceDown ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FlipDeviceTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
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
        parcel.writeInt(!this.m_faceDown ? 1 : 0);
        parcel.writeInt(!this.m_workWithScreenOff ? 1 : 0);
        parcel.writeInt(!this.m_anyStart ? 1 : 0);
    }

    public FlipDeviceTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FlipDeviceTrigger() {
        this.m_faceDown = true;
        this.m_workWithScreenOff = false;
        this.m_anyStart = false;
    }

    private FlipDeviceTrigger(Parcel parcel) {
        super(parcel);
        this.m_faceDown = parcel.readInt() == 0;
        this.m_workWithScreenOff = parcel.readInt() == 0;
        this.m_anyStart = parcel.readInt() == 0;
    }
}
