package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
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
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.FaceUpDownConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes3.dex */
public class FaceUpDownConstraint extends Constraint {
    private static final int OPTION_FACE_DOWN = 1;
    private static final int OPTION_FACE_UP = 0;
    private static final int OPTION_SIDEWAYS_LEFT = 4;
    private static final int OPTION_SIDEWAYS_RIGHT = 5;
    private static final int OPTION_VERTICAL_UPRIGHT = 2;
    private static final int OPTION_VERTICAL_UPSIDE_DOWN = 3;
    public static String SETTING_KEY_SCREEN_OFF = "device_facing_constraint_screen_off";
    private static boolean s_screenOn;
    private transient boolean m_enabled;
    private int m_option;
    private boolean[] m_selectedOptions;
    private static ScreenOnOffReceiver s_screenOnOffReceiver = new ScreenOnOffReceiver();
    private static final Object s_lock = new Object();
    private static int s_constraintCounter = 0;
    private static boolean s_sensorLive = false;
    private static final SensorManager s_sensorManager = (SensorManager) MacroDroidApplication.getInstance().getSystemService("sensor");
    private static float[] s_accelerometer = new float[3];
    private static float[] s_magnetic = new float[3];
    private static final SensorEventListener s_sensorListener = new a();
    private static final String[] s_options = {MacroDroidApplication.getInstance().getString(R.string.constraint_face_up_down_option_face_up), MacroDroidApplication.getInstance().getString(R.string.constraint_face_up_down_option_face_down), MacroDroidApplication.getInstance().getString(R.string.constraint_facing_vertical_upright), MacroDroidApplication.getInstance().getString(R.string.constraint_facing_vertical_upside_down), MacroDroidApplication.getInstance().getString(R.string.constraint_facing_vertical_sideways_left), MacroDroidApplication.getInstance().getString(R.string.constraint_facing_vertical_sideways_right)};
    public static final Parcelable.Creator<FaceUpDownConstraint> CREATOR = new c();

    /* loaded from: classes3.dex */
    public static class ScreenOnOffReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FaceUpDownConstraint.i0(intent.getAction().equals("android.intent.action.SCREEN_ON"));
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<FaceUpDownConstraint> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FaceUpDownConstraint createFromParcel(Parcel parcel) {
            return new FaceUpDownConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FaceUpDownConstraint[] newArray(int i4) {
            return new FaceUpDownConstraint[i4];
        }
    }

    /* synthetic */ FaceUpDownConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean[] W() {
        int i4 = this.m_option;
        if (i4 != -1) {
            boolean[] zArr = new boolean[s_options.length];
            zArr[i4] = true;
            return zArr;
        }
        return this.m_selectedOptions;
    }

    private boolean X(int i4) {
        if (i4 > 150) {
            return true;
        }
        return false;
    }

    private boolean Y(int i4) {
        if (i4 < 30) {
            return true;
        }
        return false;
    }

    private boolean Z(float[] fArr) {
        float f4 = fArr[2];
        if (f4 < -0.8d && f4 > -2.2d) {
            float f5 = fArr[1];
            if (f5 > -0.5d && f5 < 0.5d) {
                return true;
            }
        }
        return false;
    }

    private boolean a0(float[] fArr) {
        float f4 = fArr[2];
        if (f4 > 0.8d && f4 < 2.2d) {
            float f5 = fArr[1];
            if (f5 > -0.5d && f5 < 0.5d) {
                return true;
            }
        }
        return false;
    }

    private boolean b0(float[] fArr) {
        if (fArr[1] < -1.0d) {
            return true;
        }
        return false;
    }

    private boolean c0(float[] fArr) {
        if (fArr[1] > 1.0d) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(CheckBox[] checkBoxArr, Button button, CompoundButton compoundButton, boolean z3) {
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= checkBoxArr.length) {
                break;
            } else if (checkBoxArr[i4].isChecked()) {
                z4 = true;
                break;
            } else {
                i4++;
            }
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(CheckBox[] checkBoxArr, AppCompatDialog appCompatDialog, SensorEventListener sensorEventListener, CheckBox checkBox, View view) {
        this.m_option = -1;
        for (int i4 = 0; i4 < checkBoxArr.length; i4++) {
            this.m_selectedOptions[i4] = checkBoxArr[i4].isChecked();
        }
        appCompatDialog.dismiss();
        itemComplete();
        s_sensorManager.unregisterListener(sensorEventListener);
        SelectableItem.setSettingBoolean(getContext(), SETTING_KEY_SCREEN_OFF, checkBox.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(AppCompatDialog appCompatDialog, SensorEventListener sensorEventListener, View view) {
        appCompatDialog.dismiss();
        s_sensorManager.unregisterListener(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(SensorEventListener sensorEventListener, DialogInterface dialogInterface) {
        s_sensorManager.unregisterListener(sensorEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(@NonNull SensorEvent sensorEvent, @NonNull ImageView[] imageViewArr, @DrawableRes int i4, @DrawableRes int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int type = sensorEvent.sensor.getType();
        if (type != 1) {
            if (type == 2) {
                System.arraycopy(sensorEvent.values, 0, s_magnetic, 0, 3);
            }
        } else {
            System.arraycopy(sensorEvent.values, 0, s_accelerometer, 0, 3);
        }
        float[] fArr = new float[9];
        SensorManager.getRotationMatrix(fArr, new float[9], s_accelerometer, s_magnetic);
        float[] fArr2 = new float[3];
        SensorManager.getOrientation(fArr, fArr2);
        int round = (int) Math.round(Math.toDegrees(Math.acos(fArr[8])));
        ImageView imageView = imageViewArr[0];
        if (Y(round)) {
            i6 = i4;
        } else {
            i6 = i5;
        }
        imageView.setImageResource(i6);
        ImageView imageView2 = imageViewArr[1];
        if (X(round)) {
            i7 = i4;
        } else {
            i7 = i5;
        }
        imageView2.setImageResource(i7);
        ImageView imageView3 = imageViewArr[2];
        if (b0(fArr2)) {
            i8 = i4;
        } else {
            i8 = i5;
        }
        imageView3.setImageResource(i8);
        ImageView imageView4 = imageViewArr[3];
        if (c0(fArr2)) {
            i9 = i4;
        } else {
            i9 = i5;
        }
        imageView4.setImageResource(i9);
        ImageView imageView5 = imageViewArr[4];
        if (Z(fArr2)) {
            i10 = i4;
        } else {
            i10 = i5;
        }
        imageView5.setImageResource(i10);
        ImageView imageView6 = imageViewArr[5];
        if (!a0(fArr2)) {
            i4 = i5;
        }
        imageView6.setImageResource(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i0(boolean z3) {
        synchronized (s_lock) {
            s_screenOn = z3;
            updateConstraintState();
        }
    }

    public static void updateConstraintState() {
        synchronized (s_lock) {
            if (!s_screenOn && !SelectableItem.q(MacroDroidApplication.getInstance(), SETTING_KEY_SCREEN_OFF)) {
                if (s_sensorLive) {
                    s_sensorManager.unregisterListener(s_sensorListener);
                    s_sensorLive = false;
                }
            }
            if (s_constraintCounter > 0) {
                if (!s_sensorLive) {
                    SensorManager sensorManager = s_sensorManager;
                    SensorEventListener sensorEventListener = s_sensorListener;
                    sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(1), 3);
                    sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(4), 3);
                    sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(2), 3);
                    s_sensorLive = true;
                }
            } else if (s_sensorLive) {
                s_sensorManager.unregisterListener(s_sensorListener);
                s_sensorLive = false;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        this.m_selectedOptions = W();
        float[] fArr = new float[9];
        if (!SensorManager.getRotationMatrix(fArr, new float[9], s_accelerometer, s_magnetic)) {
            return true;
        }
        float[] fArr2 = new float[3];
        SensorManager.getOrientation(fArr, fArr2);
        int round = (int) Math.round(Math.toDegrees(Math.acos(fArr[8])));
        if (this.m_selectedOptions[0] && Y(round)) {
            return true;
        }
        if (this.m_selectedOptions[1] && X(round)) {
            return true;
        }
        if (this.m_selectedOptions[2] && b0(fArr2)) {
            return true;
        }
        if (this.m_selectedOptions[3] && c0(fArr2)) {
            return true;
        }
        if (this.m_selectedOptions[4] && Z(fArr2)) {
            return true;
        }
        if (this.m_selectedOptions[5] && a0(fArr2)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                MacroDroidApplication.getInstance().registerReceiver(s_screenOnOffReceiver, intentFilter);
                s_screenOn = ((PowerManager) getContext().getSystemService("power")).isScreenOn();
            }
            s_constraintCounter++;
            updateConstraintState();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        this.m_selectedOptions = W();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.m_selectedOptions;
            if (i4 >= zArr.length) {
                break;
            }
            if (zArr[i4]) {
                sb.append(s_options[i4]);
                sb.append(", ");
            }
            i4++;
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 2);
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FaceUpDownConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        this.m_selectedOptions = W();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_device_facing);
        appCompatDialog.setTitle(SelectableItem.r(R.string.constraint_face_up_down));
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.screen_off_checkbox);
        checkBox.setChecked(SelectableItem.q(getContext(), SETTING_KEY_SCREEN_OFF));
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final CheckBox[] checkBoxArr = {(CheckBox) appCompatDialog.findViewById(R.id.face_up_checkbox), (CheckBox) appCompatDialog.findViewById(R.id.face_down_checkbox), (CheckBox) appCompatDialog.findViewById(R.id.vertical_upright_checkbox), (CheckBox) appCompatDialog.findViewById(R.id.vertical_upside_down_checkbox), (CheckBox) appCompatDialog.findViewById(R.id.sideways_left_checkbox), (CheckBox) appCompatDialog.findViewById(R.id.sideways_right_checkbox)};
        ImageView[] imageViewArr = {(ImageView) appCompatDialog.findViewById(R.id.indicator_face_up), (ImageView) appCompatDialog.findViewById(R.id.indicator_face_down), (ImageView) appCompatDialog.findViewById(R.id.indicator_upright), (ImageView) appCompatDialog.findViewById(R.id.indicator_upside_down), (ImageView) appCompatDialog.findViewById(R.id.indicator_sideways_left), (ImageView) appCompatDialog.findViewById(R.id.indicator_sideways_right)};
        for (int i4 = 0; i4 < 6; i4++) {
            checkBoxArr[i4].setChecked(this.m_selectedOptions[i4]);
            checkBoxArr[i4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.constraint.b1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                    FaceUpDownConstraint.d0(checkBoxArr, button, compoundButton, z4);
                }
            });
        }
        final b bVar = new b(imageViewArr);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceUpDownConstraint.this.e0(checkBoxArr, appCompatDialog, bVar, checkBox, view);
            }
        });
        SensorManager sensorManager = s_sensorManager;
        sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(1), 3);
        sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(4), 3);
        sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(2), 3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceUpDownConstraint.f0(AppCompatDialog.this, bVar, view);
            }
        });
        int i5 = 0;
        while (true) {
            if (i5 < 6) {
                if (checkBoxArr[i5].isChecked()) {
                    z3 = true;
                    break;
                }
                i5++;
            } else {
                z3 = false;
                break;
            }
        }
        button.setEnabled(z3);
        appCompatDialog.show();
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.e1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FaceUpDownConstraint.g0(bVar, dialogInterface);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeBooleanArray(this.m_selectedOptions);
    }

    public FaceUpDownConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private FaceUpDownConstraint() {
        this.m_option = -1;
        this.m_selectedOptions = new boolean[s_options.length];
    }

    private FaceUpDownConstraint(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        boolean[] zArr = new boolean[s_options.length];
        this.m_selectedOptions = zArr;
        parcel.readBooleanArray(zArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type == 2) {
                    System.arraycopy(sensorEvent.values, 0, FaceUpDownConstraint.s_magnetic, 0, 3);
                    return;
                }
                return;
            }
            System.arraycopy(sensorEvent.values, 0, FaceUpDownConstraint.s_accelerometer, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    class b implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView[] f10188a;

        b(ImageView[] imageViewArr) {
            this.f10188a = imageViewArr;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            FaceUpDownConstraint.this.h0(sensorEvent, this.f10188a, R.drawable.green_tick, R.drawable.red_cross);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }
    }
}
