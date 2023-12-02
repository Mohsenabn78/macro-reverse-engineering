package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.BatteryTemperatureTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.BatteryTemperatureTriggerReceiver;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class BatteryTemperatureTrigger extends Trigger {
    public static final Parcelable.Creator<BatteryTemperatureTrigger> CREATOR = new b();
    private static final int DEFAULT_TEMPERATURE = 30;
    public static final int OPTION_ANY_CHANGE = 1;
    public static final int OPTION_INCREASE_DECREASE = 0;
    private static BatteryTemperatureTriggerReceiver s_batteryTempTriggerReceiver;
    private static int s_triggerCounter;
    private boolean decreasesTo;
    private int option;
    private int temperature;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<BatteryTemperatureTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatteryTemperatureTrigger createFromParcel(Parcel parcel) {
            return new BatteryTemperatureTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatteryTemperatureTrigger[] newArray(int i4) {
            return new BatteryTemperatureTrigger[i4];
        }
    }

    /* synthetic */ BatteryTemperatureTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void R() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.battery_trigger_dialog);
        appCompatDialog.setTitle(SelectableItem.r(R.string.trigger_battery_temp));
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.battery_trigger_dialog_seek_bar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.battery_trigger_dialog_percent_label);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.battery_trigger_dialog_increases_rb);
        seekBar.setProgress(this.temperature);
        textView.setText(this.temperature + "°C");
        radioButton.setChecked(this.decreasesTo ^ true);
        seekBar.setOnSeekBarChangeListener(new a(textView));
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.g0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                BatteryTemperatureTrigger.this.S(compoundButton, z3);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatteryTemperatureTrigger.this.T(appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(CompoundButton compoundButton, boolean z3) {
        this.decreasesTo = !z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.cancel();
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_battery_level_increase_decrease), SelectableItem.r(R.string.trigger_battery_level_any_change)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_batteryTempTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_batteryTempTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_batteryTempTriggerReceiver = new BatteryTemperatureTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            intentFilter.setPriority(0);
            MacroDroidApplication.getInstance().registerReceiver(s_batteryTempTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        if (this.option == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.trigger_battery_temp));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (this.decreasesTo) {
                str = "<=";
            } else {
                str = ">=";
            }
            sb.append(str);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.temperature);
            sb.append("°C");
            return sb.toString();
        }
        return getName();
    }

    public boolean getDecreasesTo() {
        return this.decreasesTo;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.option == 1) {
            return SelectableItem.r(R.string.trigger_variable_any_change);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatteryTemperatureTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        if (this.option == 1) {
            return getConfiguredName() + " (" + getExtendedDetail() + ")";
        }
        return getConfiguredName();
    }

    public int getOption() {
        return this.option;
    }

    public int getTemperature() {
        return this.temperature;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.option == 0) {
            R();
        } else {
            itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.decreasesTo ? 1 : 0);
        parcel.writeInt(this.temperature);
        parcel.writeInt(this.option);
    }

    public BatteryTemperatureTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public BatteryTemperatureTrigger() {
        this.decreasesTo = true;
        this.temperature = 30;
        this.option = 0;
    }

    private BatteryTemperatureTrigger(Parcel parcel) {
        super(parcel);
        this.decreasesTo = parcel.readInt() != 0;
        this.temperature = parcel.readInt();
        this.option = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14330a;

        a(TextView textView) {
            this.f14330a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            BatteryTemperatureTrigger.this.temperature = i4;
            TextView textView = this.f14330a;
            textView.setText(BatteryTemperatureTrigger.this.temperature + "°C");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
