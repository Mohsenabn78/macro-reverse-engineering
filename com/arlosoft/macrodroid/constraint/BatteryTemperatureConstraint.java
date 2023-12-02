package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
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
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class BatteryTemperatureConstraint extends Constraint {
    public static final Parcelable.Creator<BatteryTemperatureConstraint> CREATOR = new b();
    private static final int DEFAULT_TEMPERATURE = 30;
    private boolean equals;
    private boolean greaterThan;
    private int temperature;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<BatteryTemperatureConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatteryTemperatureConstraint createFromParcel(Parcel parcel) {
            return new BatteryTemperatureConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatteryTemperatureConstraint[] newArray(int i4) {
            return new BatteryTemperatureConstraint[i4];
        }
    }

    /* synthetic */ BatteryTemperatureConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(RadioButton radioButton, RadioButton radioButton2, AppCompatDialog appCompatDialog, View view) {
        this.greaterThan = radioButton.isChecked();
        this.equals = radioButton2.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        int intExtra = getContext().getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("temperature", 0) / 10;
        if (this.equals) {
            if (intExtra != this.temperature) {
                return false;
            }
            return true;
        } else if (this.greaterThan) {
            if (intExtra <= this.temperature) {
                return false;
            }
            return true;
        } else if (intExtra >= this.temperature) {
            return false;
        } else {
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(R.string.constraint_battery_temp));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (this.equals) {
            str = "=";
        } else if (this.greaterThan) {
            str = ">";
        } else {
            str = "<";
        }
        sb.append(str);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.temperature);
        sb.append("°C");
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatteryTemperatureConstraintInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.battery_constraint_dialog);
        appCompatDialog.setTitle(R.string.constraint_battery_temp);
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.batteryLevelSeekBar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.batteryPercentLabel);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.greaterThanRadioButton);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.lessThanRadioButton);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.equalsRadioButton);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        seekBar.setProgress(this.temperature);
        textView.setText(this.temperature + "°C");
        if (this.equals) {
            radioButton3.setChecked(true);
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
        } else {
            radioButton.setChecked(this.greaterThan);
            radioButton2.setChecked(!this.greaterThan);
            radioButton3.setChecked(false);
        }
        seekBar.setOnSeekBarChangeListener(new a(textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatteryTemperatureConstraint.this.S(radioButton, radioButton3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.t
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
        parcel.writeInt(this.greaterThan ? 1 : 0);
        parcel.writeInt(this.equals ? 1 : 0);
        parcel.writeInt(this.temperature);
    }

    public BatteryTemperatureConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BatteryTemperatureConstraint() {
        this.greaterThan = false;
        this.temperature = 30;
    }

    private BatteryTemperatureConstraint(Parcel parcel) {
        super(parcel);
        this.greaterThan = parcel.readInt() != 0;
        this.equals = parcel.readInt() != 0;
        this.temperature = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10155a;

        a(TextView textView) {
            this.f10155a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            BatteryTemperatureConstraint.this.temperature = i4;
            TextView textView = this.f10155a;
            textView.setText(BatteryTemperatureConstraint.this.temperature + "°C");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
