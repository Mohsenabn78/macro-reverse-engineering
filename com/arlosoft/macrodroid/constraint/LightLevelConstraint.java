package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.LightLevelConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class LightLevelConstraint extends Constraint {
    private static final int LIGHT_LEVEL_NOT_SET = -1;
    private static final int OPTION_GREATER_THAN = 1;
    private static final int OPTION_LESS_THAN = 0;
    private static int s_constraintCounter;
    private static float s_lightLevel;
    private static boolean s_screenOn;
    private transient boolean m_enabled;
    private int m_lightLevel;
    private float m_lightLevelFloat;
    private int m_option;
    private static final Object s_lock = new Object();
    private static final SensorManager s_sensorManager = (SensorManager) MacroDroidApplication.getInstance().getSystemService("sensor");
    private static final d s_lightLevelListener = new d(null);
    public static final Parcelable.Creator<LightLevelConstraint> CREATOR = new c();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LightLevelConstraint.Z(intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<LightLevelConstraint> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LightLevelConstraint createFromParcel(Parcel parcel) {
            return new LightLevelConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LightLevelConstraint[] newArray(int i4) {
            return new LightLevelConstraint[i4];
        }
    }

    /* synthetic */ LightLevelConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private float U() {
        int i4 = this.m_lightLevel;
        if (i4 != -1) {
            return i4;
        }
        return this.m_lightLevelFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(CompoundButton compoundButton, boolean z3) {
        this.m_option = z3 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(EditText editText, AppCompatDialog appCompatDialog, SensorEventListener sensorEventListener, Activity activity, View view) {
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
    public static /* synthetic */ void X(AppCompatDialog appCompatDialog, SensorEventListener sensorEventListener, View view) {
        appCompatDialog.dismiss();
        s_sensorManager.unregisterListener(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(SensorEventListener sensorEventListener, DialogInterface dialogInterface) {
        s_sensorManager.unregisterListener(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(boolean z3) {
        synchronized (s_lock) {
            s_screenOn = z3;
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        float U = U();
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1 || s_lightLevel <= U) {
                return false;
            }
            return true;
        } else if (s_lightLevel >= U) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public void disableConstraintChecking() {
        synchronized (s_lock) {
            if (!this.m_enabled) {
                return;
            }
            this.m_enabled = false;
            int i4 = s_constraintCounter - 1;
            s_constraintCounter = i4;
            if (i4 == 0) {
                try {
                    s_sensorManager.unregisterListener(s_lightLevelListener);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                SensorManager sensorManager = s_sensorManager;
                sensorManager.registerListener(s_lightLevelListener, sensorManager.getDefaultSensor(5), 3);
            }
            s_constraintCounter++;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4;
        StringBuilder sb = new StringBuilder();
        if (this.m_option == 0) {
            i4 = R.string.less_than;
        } else {
            i4 = R.string.greater_than;
        }
        sb.append(SelectableItem.r(i4));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(U());
        sb.append("lx");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LightLevelConstraintInfo.getInstance();
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
        radioButton.setText(R.string.greater_than);
        ((RadioButton) appCompatDialog.findViewById(R.id.dialog_light_sensor_decreases_rb)).setText(R.string.less_than);
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
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.g2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                LightLevelConstraint.this.V(compoundButton, z5);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightLevelConstraint.this.W(editText, appCompatDialog, aVar, activity, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightLevelConstraint.X(AppCompatDialog.this, aVar, view);
            }
        });
        appCompatDialog.show();
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.j2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LightLevelConstraint.Y(aVar, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.select_option);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_lightLevel);
        parcel.writeFloat(this.m_lightLevelFloat);
    }

    public LightLevelConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_lightLevel = -1;
        this.m_lightLevelFloat = -1.0f;
    }

    private LightLevelConstraint() {
    }

    private LightLevelConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_lightLevel = parcel.readInt();
        this.m_lightLevelFloat = parcel.readFloat();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10191a;

        a(TextView textView) {
            this.f10191a = textView;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            TextView textView = this.f10191a;
            textView.setText(sensorEvent.values[0] + "lx");
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    private static class d implements SensorEventListener {
        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float unused = LightLevelConstraint.s_lightLevel = sensorEvent.values[0];
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f10193a;

        b(Button button) {
            this.f10193a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f10193a;
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
