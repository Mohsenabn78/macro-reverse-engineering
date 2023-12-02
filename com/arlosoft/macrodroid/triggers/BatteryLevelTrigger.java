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
import com.arlosoft.macrodroid.triggers.info.BatteryLevelTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.BatteryLevelTriggerReceiver;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class BatteryLevelTrigger extends Trigger {
    public static final Parcelable.Creator<BatteryLevelTrigger> CREATOR = new b();
    private static final int DEFAULT_BATTERY_LEVEL = 50;
    public static final int OPTION_ANY_CHANGE = 1;
    public static final int OPTION_INCREASE_DECREASE = 0;
    private static BatteryLevelTriggerReceiver s_batteryLevelTriggerReceiver;
    private static int s_triggerCounter;
    private int m_batteryLevel;
    private boolean m_decreasesTo;
    private int m_option;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<BatteryLevelTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BatteryLevelTrigger createFromParcel(Parcel parcel) {
            return new BatteryLevelTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BatteryLevelTrigger[] newArray(int i4) {
            return new BatteryLevelTrigger[i4];
        }
    }

    /* synthetic */ BatteryLevelTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void R() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.battery_trigger_dialog);
        appCompatDialog.setTitle(SelectableItem.r(R.string.trigger_battery_level_title));
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.battery_trigger_dialog_seek_bar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.battery_trigger_dialog_percent_label);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.battery_trigger_dialog_increases_rb);
        seekBar.setProgress(this.m_batteryLevel);
        textView.setText(this.m_batteryLevel + "%");
        radioButton.setChecked(this.m_decreasesTo ^ true);
        seekBar.setOnSeekBarChangeListener(new a(textView));
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.d0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                BatteryLevelTrigger.this.S(compoundButton, z3);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatteryLevelTrigger.this.T(appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(CompoundButton compoundButton, boolean z3) {
        this.m_decreasesTo = !z3;
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
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_batteryLevelTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_batteryLevelTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_batteryLevelTriggerReceiver = new BatteryLevelTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            intentFilter.setPriority(0);
            MacroDroidApplication.getInstance().registerReceiver(s_batteryLevelTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    public int getBatteryLevel() {
        return this.m_batteryLevel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        if (this.m_option == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.trigger_battery_level_battery));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (this.m_decreasesTo) {
                str = "<=";
            } else {
                str = ">=";
            }
            sb.append(str);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.m_batteryLevel);
            sb.append("%");
            return sb.toString();
        }
        return getName();
    }

    public boolean getDecreasesTo() {
        return this.m_decreasesTo;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_option == 1) {
            return SelectableItem.r(R.string.trigger_variable_any_change);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return BatteryLevelTriggerInfo.getInstance();
    }

    public int getOption() {
        return this.m_option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_option == 0) {
            R();
        } else {
            itemComplete();
        }
    }

    public void setBatteryLevel(int i4) {
        this.m_batteryLevel = i4;
    }

    public void setDecreasesTo(boolean z3) {
        this.m_decreasesTo = z3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_decreasesTo ? 1 : 0);
        parcel.writeInt(this.m_batteryLevel);
        parcel.writeInt(this.m_option);
    }

    public BatteryLevelTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public BatteryLevelTrigger() {
        this.m_decreasesTo = true;
        this.m_batteryLevel = 50;
        this.m_option = 0;
    }

    private BatteryLevelTrigger(Parcel parcel) {
        super(parcel);
        this.m_decreasesTo = parcel.readInt() != 0;
        this.m_batteryLevel = parcel.readInt();
        this.m_option = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14328a;

        a(TextView textView) {
            this.f14328a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            BatteryLevelTrigger.this.m_batteryLevel = i4;
            TextView textView = this.f14328a;
            textView.setText(BatteryLevelTrigger.this.m_batteryLevel + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
