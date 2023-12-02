package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.ProximitySensorConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.NearFarListener;

/* loaded from: classes3.dex */
public class ProximitySensorConstraint extends Constraint {
    private static b s_ProximityListener;
    private static int s_constraintCounter;
    private static c s_currentState;
    private static boolean s_screenOn;
    private transient boolean m_enabled;
    private boolean m_near;
    private static final Object s_lock = new Object();
    private static final ScreenOnOffReceiver s_screenOnOffReceiver = new ScreenOnOffReceiver();
    private static final SensorManager s_sensorManager = (SensorManager) MacroDroidApplication.getInstance().getSystemService("sensor");
    private static boolean s_sensorLive = false;
    public static final Parcelable.Creator<ProximitySensorConstraint> CREATOR = new a();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ProximitySensorConstraint.Q(intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ProximitySensorConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ProximitySensorConstraint createFromParcel(Parcel parcel) {
            return new ProximitySensorConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ProximitySensorConstraint[] newArray(int i4) {
            return new ProximitySensorConstraint[i4];
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
            c cVar;
            if (z3) {
                cVar = c.NEAR;
            } else {
                cVar = c.FAR;
            }
            c unused = ProximitySensorConstraint.s_currentState = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum c {
        NEAR,
        FAR
    }

    /* synthetic */ ProximitySensorConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(boolean z3) {
        synchronized (s_lock) {
            s_screenOn = z3;
            updateConstraintState();
        }
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_proximity_sensor_near), MacroDroidApplication.getInstance().getString(R.string.constraint_proximity_sensor_far)};
    }

    private static void updateConstraintState() {
        synchronized (s_lock) {
            if (!s_screenOn && !Settings.getProximitySensorScreenOffSetting(MacroDroidApplication.getInstance())) {
                if (s_sensorLive) {
                    s_currentState = c.FAR;
                    NearFarListener.removeListener(s_ProximityListener);
                    s_sensorLive = false;
                }
            }
            if (s_constraintCounter > 0) {
                if (!s_sensorLive) {
                    s_currentState = c.FAR;
                    NearFarListener.addListener(s_ProximityListener, NearFarListener.Priority.CONSTRAINT);
                    s_sensorLive = true;
                }
            } else if (s_sensorLive) {
                s_currentState = c.FAR;
                NearFarListener.removeListener(s_ProximityListener);
                s_sensorLive = false;
            }
        }
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
        this.m_near = z3;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (!s_sensorLive) {
            return false;
        }
        if (this.m_near) {
            if (s_currentState != c.NEAR) {
                return false;
            }
            return true;
        } else if (s_currentState != c.FAR) {
            return false;
        } else {
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        synchronized (s_lock) {
            if (!this.m_enabled) {
                return;
            }
            this.m_enabled = false;
            s_constraintCounter--;
            updateConstraintState();
            if (s_constraintCounter == 0) {
                try {
                    MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffReceiver);
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
                s_ProximityListener = null;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void enableConstraintChecking(boolean z3) {
        synchronized (s_lock) {
            if (!z3) {
                if (this.m_enabled) {
                    return;
                }
            }
            this.m_enabled = true;
            if (s_constraintCounter == 0) {
                s_ProximityListener = new b(null);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffReceiver, intentFilter);
                s_screenOn = ((PowerManager) getContext().getSystemService("power")).isScreenOn();
            }
            s_constraintCounter++;
            updateConstraintState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_near ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(SelectableItem.r(R.string.constraint_proximity_sensor));
        sb.append(": ");
        if (this.m_near) {
            str = getOptions()[0];
        } else {
            str = getOptions()[1];
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ProximitySensorConstraintInfo.getInstance();
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
        parcel.writeInt(this.m_near ? 1 : 0);
    }

    public ProximitySensorConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ProximitySensorConstraint() {
        this.m_near = true;
    }

    private ProximitySensorConstraint(Parcel parcel) {
        super(parcel);
        this.m_near = parcel.readInt() != 0;
    }
}
