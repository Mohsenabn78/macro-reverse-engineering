package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.LightSensorTriggerInfo;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Iterator;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class LightSensorTrigger extends Trigger {
    private static final String BG_UPDATE_INTENT = "LightSensorBGUpdate";
    private static final int LIGHT_LEVEL_NOT_SET = -1;
    private static final long MIN_MS_BETWEEN_SCANS = 500;
    private static final int OPTION_DECREASES_TO = 0;
    private static final int OPTION_INCREASES_TO = 1;
    private static d s_bgCheckReceiver;
    private static long s_lastCheckTimestamp;
    private static float s_oldLightLevel;
    private static PendingIntent s_pendingIntentBgScan;
    private static boolean s_screenOn;
    private static d s_updateRateReceiver;
    private int m_lightLevel;
    private float m_lightLevelFloat;
    private int m_option;
    private static final SensorManager s_sensorManager = (SensorManager) MacroDroidApplication.getInstance().getSystemService("sensor");
    private static final LightLevelListener s_lightLevelListener = new LightLevelListener(false);
    private static final LightLevelListener s_lightLevelListenerBg = new LightLevelListener(true);
    private static int s_triggerCounter = 0;
    private static boolean s_sensorLive = false;
    private static final ScreenOnOffReceiver s_screenOnOffTriggerReceiver = new ScreenOnOffReceiver();
    public static final Parcelable.Creator<LightSensorTrigger> CREATOR = new c();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LightSensorTrigger.g0(intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<LightSensorTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LightSensorTrigger createFromParcel(Parcel parcel) {
            return new LightSensorTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LightSensorTrigger[] newArray(int i4) {
            return new LightSensorTrigger[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LightSensorTrigger.s_sensorManager.registerListener(LightSensorTrigger.s_lightLevelListenerBg, LightSensorTrigger.s_sensorManager.getDefaultSensor(5), 500000);
            LightSensorTrigger.f0(context);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* synthetic */ LightSensorTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private float Z() {
        int i4 = this.m_lightLevel;
        if (i4 != -1) {
            return i4;
        }
        return this.m_lightLevelFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a0(float f4) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof LightSensorTrigger) {
                        LightSensorTrigger lightSensorTrigger = (LightSensorTrigger) next;
                        if (lightSensorTrigger.getOption() == 0 && f4 <= lightSensorTrigger.Z() && s_oldLightLevel > lightSensorTrigger.Z()) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        } else if (lightSensorTrigger.getOption() == 1 && f4 >= lightSensorTrigger.Z() && s_oldLightLevel < lightSensorTrigger.Z()) {
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
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(CompoundButton compoundButton, boolean z3) {
        this.m_option = z3 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(EditText editText, AppCompatDialog appCompatDialog, SensorEventListener sensorEventListener, Activity activity, View view) {
        try {
            this.m_lightLevelFloat = Float.valueOf(editText.getText().toString()).floatValue();
            appCompatDialog.dismiss();
            itemComplete();
            s_sensorManager.unregisterListener(sensorEventListener);
        } catch (NumberFormatException unused) {
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.invalid_value, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(AppCompatDialog appCompatDialog, SensorEventListener sensorEventListener, View view) {
        appCompatDialog.dismiss();
        s_sensorManager.unregisterListener(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(SensorEventListener sensorEventListener, DialogInterface dialogInterface) {
        s_sensorManager.unregisterListener(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f0(Context context) {
        int lightSensorBGScanRate = Settings.getLightSensorBGScanRate(context) * 60;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (lightSensorBGScanRate > 0) {
            int i4 = lightSensorBGScanRate * 1000;
            IntentFilter intentFilter = new IntentFilter(BG_UPDATE_INTENT);
            if (s_bgCheckReceiver == null) {
                s_bgCheckReceiver = new d(null);
                MacroDroidApplication.getInstance().registerReceiver(s_bgCheckReceiver, intentFilter);
            }
            s_pendingIntentBgScan = PendingIntent.getBroadcast(context, 0, new Intent(BG_UPDATE_INTENT), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
            AlarmHelper.scheduleExactAlarmWithInexactFallback(0, System.currentTimeMillis() + i4, s_pendingIntentBgScan, true);
            return;
        }
        PendingIntent pendingIntent = s_pendingIntentBgScan;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
            s_pendingIntentBgScan = null;
        }
        if (s_bgCheckReceiver != null) {
            MacroDroidApplication.getInstance().unregisterReceiver(s_bgCheckReceiver);
            s_bgCheckReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g0(boolean z3) {
        s_screenOn = z3;
        h0();
    }

    private int getOption() {
        return this.m_option;
    }

    private static void h0() {
        if (s_screenOn) {
            if (s_triggerCounter > 0) {
                if (!s_sensorLive) {
                    SensorManager sensorManager = s_sensorManager;
                    sensorManager.registerListener(s_lightLevelListener, sensorManager.getDefaultSensor(5), 3);
                    s_sensorLive = true;
                }
            } else if (s_sensorLive) {
                s_sensorManager.unregisterListener(s_lightLevelListener);
                s_sensorLive = false;
            }
        } else if (s_sensorLive) {
            s_sensorManager.unregisterListener(s_lightLevelListener);
            s_sensorLive = false;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            h0();
            if (s_pendingIntentBgScan != null) {
                ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(s_pendingIntentBgScan);
                s_pendingIntentBgScan = null;
            }
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_screenOnOffTriggerReceiver);
                if (s_updateRateReceiver != null) {
                    getContext().unregisterReceiver(s_updateRateReceiver);
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffTriggerReceiver, intentFilter);
            s_screenOn = ((PowerManager) getContext().getSystemService("power")).isScreenOn();
            IntentFilter intentFilter2 = new IntentFilter(Util.LIGHT_SENSOR_BACKGROUND_SCAN_RATE_INTENT);
            s_updateRateReceiver = new d(null);
            getContext().registerReceiver(s_updateRateReceiver, intentFilter2);
            f0(getContext());
        }
        s_triggerCounter++;
        h0();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        StringBuilder sb = new StringBuilder();
        if (this.m_option == 0) {
            i4 = R.string.decreases_to;
        } else {
            i4 = R.string.increases_to;
        }
        sb.append(SelectableItem.r(i4));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(Z());
        sb.append("lx");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LightSensorTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        int i4 = this.m_lightLevel;
        if (i4 != -1) {
            this.m_lightLevelFloat = i4;
            this.m_lightLevel = -1;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_light_sensor);
        appCompatDialog.setTitle(SelectableItem.r(R.string.trigger_light_sensor));
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.lux_value);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.dialog_light_sensor_increases_rb);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final a aVar = new a((TextView) appCompatDialog.findViewById(R.id.light_level));
        boolean z4 = false;
        if (this.m_option == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        radioButton.setChecked(z3);
        SensorManager sensorManager = s_sensorManager;
        sensorManager.registerListener(aVar, sensorManager.getDefaultSensor(5), 3);
        float f4 = this.m_lightLevelFloat;
        if (f4 != -1.0f) {
            editText.setText(String.valueOf(f4));
            editText.setSelection(editText.length());
        }
        if (editText.length() > 0) {
            z4 = true;
        }
        button.setEnabled(z4);
        editText.addTextChangedListener(new b(button));
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.p4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                LightSensorTrigger.this.b0(compoundButton, z5);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightSensorTrigger.this.c0(editText, appCompatDialog, aVar, activity, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightSensorTrigger.d0(AppCompatDialog.this, aVar, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.s4
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LightSensorTrigger.e0(aVar, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.select_option);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_lightLevel);
        parcel.writeFloat(this.m_lightLevelFloat);
    }

    public LightSensorTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_lightLevel = -1;
        this.m_lightLevelFloat = -1.0f;
    }

    private LightSensorTrigger() {
    }

    private LightSensorTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_lightLevel = parcel.readInt();
        this.m_lightLevelFloat = parcel.readFloat();
    }

    /* loaded from: classes3.dex */
    public static class LightLevelListener implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14377a;

        public LightLevelListener(boolean z3) {
            this.f14377a = z3;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float f4 = sensorEvent.values[0];
            if (LightSensorTrigger.s_oldLightLevel == f4) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - LightSensorTrigger.s_lastCheckTimestamp >= 500) {
                long unused = LightSensorTrigger.s_lastCheckTimestamp = currentTimeMillis;
                LightSensorTrigger.a0(f4);
                float unused2 = LightSensorTrigger.s_oldLightLevel = f4;
                if (this.f14377a) {
                    LightSensorTrigger.s_sensorManager.unregisterListener(LightSensorTrigger.s_lightLevelListenerBg);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14378a;

        a(TextView textView) {
            this.f14378a = textView;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            TextView textView = this.f14378a;
            textView.setText(sensorEvent.values[0] + "lx");
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14380a;

        b(Button button) {
            this.f14380a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14380a;
            if (editable.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
