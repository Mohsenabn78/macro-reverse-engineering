package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.PebbleHelper;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.PebbleTriggerInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes3.dex */
public class PebbleTrigger extends Trigger {
    public static final int BUTTON_ID_DOWN = 3;
    public static final int BUTTON_ID_MIDDLE = 2;
    public static final int BUTTON_ID_UP = 1;
    public static final int BUTTON_PRESS_LONG = 2;
    public static final int BUTTON_PRESS_MULTI = 3;
    public static final int BUTTON_PRESS_SINGLE = 1;
    public static final int OPTION_BATTERY_LEVEL = 3;
    private static final int OPTION_BUTTON_PRESS = 0;
    private static final int OPTION_CONNECTED = 1;
    private static final int OPTION_DISCONNECTED = 2;
    private static final int PEBBLE_COMMAND_DISPLAY_INFO = 20;
    private static final int PEBBLE_TRIGGER_INFO_MESSAGE_KEY = 2001;
    private static int s_triggerCounter;
    private int m_batteryLevel;
    private int m_buttonId;
    private boolean m_decreasesTo;
    private int m_option;
    private int m_pressType;
    private static final String[] s_options = {SelectableItem.r(R.string.trigger_pebble_button_pressed), SelectableItem.r(R.string.trigger_pebble_connected), SelectableItem.r(R.string.trigger_pebble_disconnected), SelectableItem.r(R.string.trigger_pebble_battery)};
    private static final String[] s_buttonIdOptions = {MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_button_press_top), MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_button_press_middle), MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_button_press_bottom)};
    private static final String[] s_pressTypeOptions = {MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_button_press_single), MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_button_press_long), MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_button_press_double)};
    private static final BroadcastReceiver s_connectReceiver = new a();
    private static final BroadcastReceiver s_disconnectReceiver = new b();
    private static final PebbleKit.PebbleDataReceiver s_buttonPressReceiver = new c(Constants.PEBBLE_APP_UUID);
    public static final Parcelable.Creator<PebbleTrigger> CREATOR = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PebbleTrigger.c0(true);
        }
    }

    /* loaded from: classes3.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PebbleTrigger.c0(false);
        }
    }

    /* loaded from: classes3.dex */
    class c extends PebbleKit.PebbleDataReceiver {
        c(UUID uuid) {
            super(uuid);
        }

        @Override // com.getpebble.android.kit.PebbleKit.PebbleDataReceiver
        public void receiveData(Context context, int i4, PebbleDictionary pebbleDictionary) {
            PebbleKit.sendAckToPebble(MacroDroidApplication.getInstance(), i4);
            if (pebbleDictionary.contains(1)) {
                int intValue = pebbleDictionary.getInteger(1).intValue();
                int i5 = intValue % 100;
                int i6 = intValue / 100;
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Trigger next = it.next();
                            if ((next instanceof PebbleTrigger) && next.constraintsMet()) {
                                PebbleTrigger pebbleTrigger = (PebbleTrigger) next;
                                if (i5 != -1 && pebbleTrigger.getOption() == 0 && pebbleTrigger.a0() == i5 && pebbleTrigger.b0() == i6) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            }
                        }
                    }
                }
                Iterator it2 = arrayList.iterator();
                boolean z3 = false;
                while (it2.hasNext()) {
                    Macro macro2 = (Macro) it2.next();
                    macro2.invokeActions(macro2.getTriggerContextInfo());
                    PebbleDictionary pebbleDictionary2 = new PebbleDictionary();
                    pebbleDictionary2.addUint8(999, Ascii.DC4);
                    pebbleDictionary2.addString(2001, "[" + macro2.getName() + "]");
                    PebbleKit.sendDataToPebble(MacroDroidApplication.getInstance(), Constants.PEBBLE_APP_UUID, pebbleDictionary2);
                    z3 = true;
                }
                if (!z3) {
                    try {
                        PebbleDictionary pebbleDictionary3 = new PebbleDictionary();
                        pebbleDictionary3.addUint8(999, Ascii.DC4);
                        pebbleDictionary3.addString(2001, "[" + MacroDroidApplication.getInstance().getString(R.string.trigger_pebble_no_macro_run) + "]");
                        PebbleKit.sendDataToPebble(MacroDroidApplication.getInstance(), Constants.PEBBLE_APP_UUID, pebbleDictionary3);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class e implements Parcelable.Creator<PebbleTrigger> {
        e() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PebbleTrigger createFromParcel(Parcel parcel) {
            return new PebbleTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PebbleTrigger[] newArray(int i4) {
            return new PebbleTrigger[i4];
        }
    }

    /* synthetic */ PebbleTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a0() {
        return this.m_buttonId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b0() {
        return this.m_pressType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c0(boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof PebbleTrigger) && next.constraintsMet()) {
                    PebbleTrigger pebbleTrigger = (PebbleTrigger) next;
                    if ((pebbleTrigger.getOption() == 1 && z3) || (pebbleTrigger.getOption() == 2 && !z3)) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
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
    public /* synthetic */ void d0() {
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(CompoundButton compoundButton, boolean z3) {
        this.m_decreasesTo = !z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        this.m_pressType = i4 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i4) {
        this.m_buttonId = i4 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(DialogInterface dialogInterface, int i4) {
        m0();
    }

    private void l0() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.battery_trigger_dialog);
        appCompatDialog.setTitle(SelectableItem.r(R.string.trigger_battery_level_title));
        SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.battery_trigger_dialog_seek_bar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.battery_trigger_dialog_percent_label);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.battery_trigger_dialog_increases_rb);
        seekBar.setProgress(this.m_batteryLevel);
        seekBar.incrementProgressBy(10);
        textView.setText(this.m_batteryLevel + "%");
        radioButton.setChecked(this.m_decreasesTo ^ true);
        seekBar.setOnSeekBarChangeListener(new d(textView));
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.m6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                PebbleTrigger.this.e0(compoundButton, z3);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PebbleTrigger.this.f0(appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.o6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void m0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_pebble_button_press_select_press);
        builder.setSingleChoiceItems(s_pressTypeOptions, this.m_pressType - 1, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.p6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleTrigger.this.h0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleTrigger.this.i0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void n0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_pebble_button_press_select_id);
        builder.setSingleChoiceItems(s_buttonIdOptions, this.m_buttonId - 1, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleTrigger.this.j0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PebbleTrigger.this.k0(dialogInterface, i4);
            }
        });
        builder.create().show();
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
            MacroDroidApplication.getInstance().unregisterReceiver(s_buttonPressReceiver);
            MacroDroidApplication.getInstance().unregisterReceiver(s_connectReceiver);
            MacroDroidApplication.getInstance().unregisterReceiver(s_disconnectReceiver);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            PebbleKit.registerReceivedDataHandler(getContext(), s_buttonPressReceiver);
            PebbleKit.registerPebbleConnectedReceiver(getContext(), s_connectReceiver);
            PebbleKit.registerPebbleDisconnectedReceiver(getContext(), s_disconnectReceiver);
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
        return s_options[this.m_option];
    }

    public boolean getDecreasesTo() {
        return this.m_decreasesTo;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        int i4 = this.m_option;
        if (i4 == 0) {
            return s_buttonIdOptions[this.m_buttonId - 1] + " : " + s_pressTypeOptions[this.m_pressType - 1];
        } else if (i4 == 3) {
            StringBuilder sb = new StringBuilder();
            if (this.m_decreasesTo) {
                str = "<";
            } else {
                str = ">=";
            }
            sb.append(str);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.m_batteryLevel);
            sb.append("%");
            return sb.toString();
        } else {
            return "";
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PebbleTriggerInfo.getInstance();
    }

    public int getOption() {
        return this.m_option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Settings.getShownPebbleInfo(getContext())) {
            super.handleItemSelected();
        } else {
            PebbleHelper.displayPebbleInfo(getActivity(), new PebbleHelper.PebbleDialogHandler() { // from class: com.arlosoft.macrodroid.triggers.j6
                @Override // com.arlosoft.macrodroid.common.PebbleHelper.PebbleDialogHandler
                public final void continueSelected() {
                    PebbleTrigger.this.d0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return s_options;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_option;
        if (i4 == 0) {
            n0();
        } else if (i4 == 3) {
            l0();
        } else {
            itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_buttonId);
        parcel.writeInt(this.m_pressType);
        parcel.writeInt(this.m_buttonId);
        parcel.writeInt(!this.m_decreasesTo ? 1 : 0);
    }

    public PebbleTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private PebbleTrigger() {
        this.m_buttonId = 1;
        this.m_pressType = 1;
        this.m_batteryLevel = 50;
        this.m_decreasesTo = true;
    }

    private PebbleTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_buttonId = parcel.readInt();
        this.m_pressType = parcel.readInt();
        this.m_buttonId = parcel.readInt();
        this.m_decreasesTo = parcel.readInt() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14401a;

        d(TextView textView) {
            this.f14401a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            PebbleTrigger.this.m_batteryLevel = i4;
            TextView textView = this.f14401a;
            textView.setText(PebbleTrigger.this.m_batteryLevel + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
