package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.BatteryLevelConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class BatteryLevelConstraint extends Constraint {
    public static final Parcelable.Creator<BatteryLevelConstraint> CREATOR = new b();
    private static final int DEFAULT_BATTERY_LEVEL = 50;
    private static int s_batteryLevel;
    private int m_batteryLevel;
    private transient c m_batteryLevelReceiver;
    private transient boolean m_constraintCheckingEnabled;
    private boolean m_equals;
    private boolean m_greaterThan;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<BatteryLevelConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatteryLevelConstraint createFromParcel(Parcel parcel) {
            return new BatteryLevelConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatteryLevelConstraint[] newArray(int i4) {
            return new BatteryLevelConstraint[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int unused = BatteryLevelConstraint.s_batteryLevel = (intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0) * 100) / intent.getIntExtra("scale", 100);
        }

        /* synthetic */ c(BatteryLevelConstraint batteryLevelConstraint, a aVar) {
            this();
        }
    }

    /* synthetic */ BatteryLevelConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(RadioButton radioButton, RadioButton radioButton2, AppCompatDialog appCompatDialog, View view) {
        this.m_greaterThan = radioButton.isChecked();
        this.m_equals = radioButton2.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        SystemLog.logVerbose("Battery level constraint, current level = " + s_batteryLevel);
        int i4 = s_batteryLevel;
        if (i4 == 0) {
            Intent registerReceiver = getContext().getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            double intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra >= 0 && intExtra2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i4 = (int) ((intExtra / intExtra2) * 100.0d);
            }
        }
        if (this.m_equals) {
            if (i4 == this.m_batteryLevel) {
                return true;
            }
            return false;
        } else if (this.m_greaterThan) {
            if (i4 > this.m_batteryLevel) {
                return true;
            }
            return false;
        } else if (i4 < this.m_batteryLevel) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public synchronized void disableConstraintChecking() {
        if (!this.m_constraintCheckingEnabled) {
            return;
        }
        this.m_constraintCheckingEnabled = false;
        if (this.m_batteryLevelReceiver != null) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(this.m_batteryLevelReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            this.m_batteryLevelReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public synchronized void enableConstraintChecking(boolean z3) {
        if (!z3) {
            if (this.m_constraintCheckingEnabled) {
                return;
            }
        }
        this.m_constraintCheckingEnabled = true;
        if (this.m_batteryLevelReceiver == null) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            this.m_batteryLevelReceiver = new c(this, null);
            intentFilter.setPriority(1000);
            MacroDroidApplication.getInstance().registerReceiver(this.m_batteryLevelReceiver, intentFilter);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(R.string.constraint_battery_level_battery_label));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (this.m_equals) {
            str = "=";
        } else if (this.m_greaterThan) {
            str = ">";
        } else {
            str = "<";
        }
        sb.append(str);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.m_batteryLevel);
        sb.append("%");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatteryLevelConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.battery_constraint_dialog);
        appCompatDialog.setTitle(R.string.constraint_battery_level);
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.batteryLevelSeekBar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.batteryPercentLabel);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.greaterThanRadioButton);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.lessThanRadioButton);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.equalsRadioButton);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        seekBar.setProgress(this.m_batteryLevel);
        textView.setText(this.m_batteryLevel + "%");
        if (this.m_equals) {
            radioButton3.setChecked(true);
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
        } else {
            radioButton.setChecked(this.m_greaterThan);
            radioButton2.setChecked(!this.m_greaterThan);
            radioButton3.setChecked(false);
        }
        seekBar.setOnSeekBarChangeListener(new a(textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatteryLevelConstraint.this.T(radioButton, radioButton3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_greaterThan ? 1 : 0);
        parcel.writeInt(this.m_equals ? 1 : 0);
        parcel.writeInt(this.m_batteryLevel);
    }

    public BatteryLevelConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BatteryLevelConstraint() {
        this.m_greaterThan = false;
        this.m_batteryLevel = 50;
    }

    private BatteryLevelConstraint(Parcel parcel) {
        super(parcel);
        this.m_greaterThan = parcel.readInt() != 0;
        this.m_equals = parcel.readInt() != 0;
        this.m_batteryLevel = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10152a;

        a(TextView textView) {
            this.f10152a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            BatteryLevelConstraint.this.m_batteryLevel = i4;
            TextView textView = this.f10152a;
            textView.setText(BatteryLevelConstraint.this.m_batteryLevel + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
