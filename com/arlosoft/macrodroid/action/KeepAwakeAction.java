package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.KeepAwakeActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class KeepAwakeAction extends Action {
    public static final Parcelable.Creator<KeepAwakeAction> CREATOR = new b();
    private static final int SCREEN_DIM = 1;
    private static final int SCREEN_OFF = 2;
    private static final int SCREEN_ON = 0;
    private static int s_idCounter;
    private static PowerManager.WakeLock s_wakelock;
    private boolean m_enabled;
    private boolean m_permanent;
    private int m_screenOption;
    private int m_secondsToStayAwakeFor;

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<KeepAwakeAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public KeepAwakeAction createFromParcel(Parcel parcel) {
            return new KeepAwakeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public KeepAwakeAction[] newArray(int i4) {
            return new KeepAwakeAction[i4];
        }
    }

    /* synthetic */ KeepAwakeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q() {
        Button button;
        Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.keep_awake_options);
        appCompatDialog.setTitle(getContext().getString(R.string.action_keep_awake_keep_awake));
        final Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.keep_awake_options_screen_setting);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.keep_awake_options_time_setting);
        int i4 = this.m_secondsToStayAwakeFor;
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.keep_awake_options_hour_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.keep_awake_options_minute_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.keep_awake_options_second_picker);
        numberPicker.setMinimum(0);
        numberPicker2.setMinimum(0);
        numberPicker3.setMinimum(0);
        NumberPicker.Listener listener = new NumberPicker.Listener() { // from class: com.arlosoft.macrodroid.action.m8
            @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
            public final void valueUpdated() {
                KeepAwakeAction.U(button2, spinner2, numberPicker2, numberPicker, numberPicker3);
            }
        };
        numberPicker.setValue(i4 / 3600);
        numberPicker.setListener(listener);
        numberPicker2.setValue((i4 / 60) % 60);
        numberPicker2.setListener(listener);
        numberPicker3.setValue(i4 % 60);
        numberPicker3.setListener(listener);
        numberPicker.setEnabled(false);
        numberPicker2.setEnabled(false);
        numberPicker3.setEnabled(false);
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, S());
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(this.m_screenOption);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(activity, 17367048, T());
        arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        boolean z3 = true;
        spinner2.setSelection(!this.m_permanent ? 1 : 0);
        if (!this.m_permanent && numberPicker3.getValue() == 0 && numberPicker2.getValue() == 0 && numberPicker.getValue() == 0) {
            button = button2;
            z3 = false;
        } else {
            button = button2;
        }
        button.setEnabled(z3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.n8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeepAwakeAction.this.V(numberPicker3, numberPicker2, numberPicker, spinner, spinner2, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        spinner2.setOnItemSelectedListener(new a(numberPicker, numberPicker2, numberPicker3, button, spinner2));
        appCompatDialog.show();
    }

    private String[] R() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_enable), MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_disable)};
    }

    private String[] S() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_screen_on), MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_screen_dim), MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_screen_off)};
    }

    private String[] T() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_until_disabled), MacroDroidApplication.getInstance().getString(R.string.action_keep_awake_fixed_time)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(Button button, Spinner spinner, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        boolean z3;
        if (button != null) {
            if (spinner.getSelectedItemPosition() != 0 && numberPicker.getValue() == 0 && numberPicker2.getValue() == 0 && numberPicker3.getValue() == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            button.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Spinner spinner, Spinner spinner2, AppCompatDialog appCompatDialog, View view) {
        boolean z3;
        this.m_secondsToStayAwakeFor = numberPicker.getValue() + (numberPicker2.getValue() * 60) + (numberPicker3.getValue() * 60 * 60);
        this.m_screenOption = spinner.getSelectedItemPosition();
        if (spinner2.getSelectedItemPosition() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_permanent = z3;
        itemComplete();
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i4) {
        Q();
    }

    private void Y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.action_keep_awake).setMessage(R.string.action_keep_awake_not_work_on_all_devices_warning).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.l8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                KeepAwakeAction.this.X(dialogInterface, i4);
            }
        });
        builder.show();
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
        this.m_enabled = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_enabled ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_enabled) {
            return getName();
        }
        return R()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_enabled) {
            String str = S()[this.m_screenOption] + " - ";
            if (this.m_permanent) {
                return str + SelectableItem.r(R.string.action_keep_awake_until_disabled);
            }
            int i4 = this.m_secondsToStayAwakeFor;
            int i5 = i4 / 3600;
            int i6 = (i4 / 60) % 60;
            int i7 = i4 % 60;
            if (i5 > 0) {
                return str + String.format("%01d", Integer.valueOf(i5)) + SelectableItem.r(R.string.hour_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.format("%02d", Integer.valueOf(i6)) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.format("%02d", Integer.valueOf(i7)) + SelectableItem.r(R.string.second_one_char);
            } else if (i6 > 0) {
                return str + String.format("%02d", Integer.valueOf(i6)) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.format("%02d", Integer.valueOf(i7)) + SelectableItem.r(R.string.second_one_char);
            } else {
                return str + String.format("%02d", Integer.valueOf(i7)) + SelectableItem.r(R.string.second_one_char);
            }
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return KeepAwakeActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    @SuppressLint({"Wakelock"})
    public synchronized void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4;
        PowerManager.WakeLock wakeLock = s_wakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            s_wakelock.release();
        }
        if (this.m_enabled) {
            PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
            int i5 = this.m_screenOption;
            if (i5 != 0) {
                i4 = 1;
                if (i5 != 1) {
                    if (i5 != 2) {
                        i4 = 0;
                    }
                } else {
                    i4 = 6;
                }
            } else {
                i4 = 10;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435456 | i4, "macrodroid:keepawakeaction");
            s_wakelock = newWakeLock;
            if (!this.m_permanent) {
                newWakeLock.acquire(this.m_secondsToStayAwakeFor * 1000);
            } else {
                newWakeLock.acquire();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!this.m_enabled) {
            itemComplete();
        } else {
            Y();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_secondsToStayAwakeFor);
        parcel.writeInt(this.m_screenOption);
        parcel.writeInt(!this.m_enabled ? 1 : 0);
        parcel.writeInt(!this.m_permanent ? 1 : 0);
    }

    public KeepAwakeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private KeepAwakeAction() {
        this.m_enabled = true;
        this.m_permanent = true;
    }

    private KeepAwakeAction(Parcel parcel) {
        super(parcel);
        this.m_secondsToStayAwakeFor = parcel.readInt();
        this.m_screenOption = parcel.readInt();
        this.m_enabled = parcel.readInt() == 0;
        this.m_permanent = parcel.readInt() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NumberPicker f2270a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberPicker f2271b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NumberPicker f2272c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Button f2273d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Spinner f2274e;

        a(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Button button, Spinner spinner) {
            this.f2270a = numberPicker;
            this.f2271b = numberPicker2;
            this.f2272c = numberPicker3;
            this.f2273d = button;
            this.f2274e = spinner;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            boolean z3;
            boolean z4;
            boolean z5;
            NumberPicker numberPicker = this.f2270a;
            boolean z6 = false;
            if (i4 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            numberPicker.setEnabled(z3);
            NumberPicker numberPicker2 = this.f2271b;
            if (i4 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            numberPicker2.setEnabled(z4);
            NumberPicker numberPicker3 = this.f2272c;
            if (i4 == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            numberPicker3.setEnabled(z5);
            Button button = this.f2273d;
            if (button != null) {
                button.setEnabled((this.f2274e.getSelectedItemPosition() != 0 && this.f2271b.getValue() == 0 && this.f2270a.getValue() == 0 && this.f2272c.getValue() == 0) ? true : true);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
