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
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ShakeDeviceTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.ShakeEventListener;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ShakeDeviceTrigger extends Trigger {
    private static boolean s_screenOn;
    private static ShakeEventListener s_sensorListener;
    private static final SensorManager s_sensorManager = (SensorManager) MacroDroidApplication.getInstance().getSystemService("sensor");
    private static int s_triggerCounter = 0;
    private static boolean s_sensorLive = false;
    private static final ScreenOnOffReceiver s_screenOnOffTriggerReceiver = new ScreenOnOffReceiver();
    public static final Parcelable.Creator<ShakeDeviceTrigger> CREATOR = new a();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ShakeDeviceTrigger.Q(intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ShakeDeviceTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShakeDeviceTrigger createFromParcel(Parcel parcel) {
            return new ShakeDeviceTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShakeDeviceTrigger[] newArray(int i4) {
            return new ShakeDeviceTrigger[i4];
        }
    }

    /* synthetic */ ShakeDeviceTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O() {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof ShakeDeviceTrigger) && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0 && Settings.getShakeTriggerVibrate(MacroDroidApplication.getInstance())) {
            ((Vibrator) MacroDroidApplication.getInstance().getSystemService("vibrator")).vibrate(new long[]{0, 200}, -1);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(boolean z3) {
        s_screenOn = z3;
        R();
    }

    private static void R() {
        int i4;
        if (!s_screenOn && !Settings.getShakeScreenOffSetting(MacroDroidApplication.getInstance())) {
            if (s_sensorLive) {
                s_sensorManager.unregisterListener(s_sensorListener);
                s_sensorLive = false;
            }
        } else if (s_triggerCounter > 0) {
            if (!s_sensorLive) {
                s_sensorListener.setOnShakeListener(new ShakeEventListener.OnShakeListener() { // from class: com.arlosoft.macrodroid.triggers.m7
                    @Override // com.arlosoft.macrodroid.triggers.receivers.ShakeEventListener.OnShakeListener
                    public final void onShake() {
                        ShakeDeviceTrigger.O();
                    }
                });
                ShakeEventListener.setShakeSensitivity(Settings.getShakeSensitiviy(MacroDroidApplication.getInstance()));
                String shakeSampleFrequency = Settings.getShakeSampleFrequency(MacroDroidApplication.getInstance());
                if (shakeSampleFrequency.equals(SelectableItem.r(R.string.sample_rate_slow))) {
                    i4 = 3;
                } else if (shakeSampleFrequency.equals(SelectableItem.r(R.string.sample_rate_fast))) {
                    i4 = 1;
                } else {
                    i4 = 2;
                }
                SensorManager sensorManager = s_sensorManager;
                sensorManager.registerListener(s_sensorListener, sensorManager.getDefaultSensor(1), i4);
                s_sensorLive = true;
            }
        } else if (s_sensorLive) {
            s_sensorManager.unregisterListener(s_sensorListener);
            s_sensorLive = false;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        s_triggerCounter--;
        R();
        if (s_triggerCounter == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_sensorListener = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_sensorListener = new ShakeEventListener(MacroDroidApplication.getInstance());
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffTriggerReceiver, intentFilter);
            s_screenOn = ((PowerManager) getContext().getSystemService("power")).isScreenOn();
        }
        s_triggerCounter++;
        R();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ShakeDeviceTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    public ShakeDeviceTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ShakeDeviceTrigger() {
    }

    private ShakeDeviceTrigger(Parcel parcel) {
        super(parcel);
    }
}
