package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetAlarmClockActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetAlarmClockAction extends Action implements HasVariable, HasDictionaryKeys {
    public static final Parcelable.Creator<SetAlarmClockAction> CREATOR = new c();
    private static final int OPTION_CLEAR_ALARM = 1;
    private static final int OPTION_DISMISS_ACTIVE_ALARM = 2;
    private static final int OPTION_SET_ALARM = 0;
    private static List<String> s_dayOptions;
    private int m_dayOption;
    private final boolean[] m_daysOfWeek;
    private int m_delayInHours;
    private int m_delayInMinutes;
    private int m_hour;
    private String m_label;
    private int m_minute;
    private boolean m_oneOff;
    private int m_option;
    private boolean m_relative;
    private MacroDroidVariable m_variable;
    private DictionaryKeys varDictionaryKeys;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient MacroDroidVariable workingVariable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2484a;

        b(ViewGroup viewGroup) {
            this.f2484a = viewGroup;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            this.f2484a.setVisibility(0);
            SetAlarmClockAction.this.workingVariable = null;
            SetAlarmClockAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2484a.setVisibility(8);
            SetAlarmClockAction.this.workingVariable = macroDroidVariable;
            SetAlarmClockAction setAlarmClockAction = SetAlarmClockAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            setAlarmClockAction.workingDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<SetAlarmClockAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetAlarmClockAction createFromParcel(Parcel parcel) {
            return new SetAlarmClockAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetAlarmClockAction[] newArray(int i4) {
            return new SetAlarmClockAction[i4];
        }
    }

    /* synthetic */ SetAlarmClockAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void a0() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_disable_alarm);
        appCompatDialog.setTitle(R.string.action_alarm_clock_disable_alarm);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_dismiss_alarm_label);
        editText.setText(this.m_label);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.mi
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetAlarmClockAction.d0(editText, magicTextPair);
            }
        };
        ((Button) appCompatDialog.findViewById(R.id.magic_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ni
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetAlarmClockAction.this.e0(activity, magicTextListener, view);
            }
        });
        editText.addTextChangedListener(new a(button, editText));
        if (this.m_label.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.oi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetAlarmClockAction.this.f0(editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private void b0() {
        String str;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_set_alarm);
        appCompatDialog.setTitle(R.string.action_alarm_clock_set_alarm);
        this.workingVariable = this.m_variable;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.dialog_set_alarm_one_off);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.dialog_set_alarm_repeated);
        final ViewFlipper viewFlipper = (ViewFlipper) appCompatDialog.findViewById(R.id.dialog_set_alarm_view_flipper);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_set_alarm_label);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.dialog_set_alarm_relative);
        RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.dialog_set_alarm_fixed);
        final ViewFlipper viewFlipper2 = (ViewFlipper) appCompatDialog.findViewById(R.id.dialog_set_alarm_view_flipper_one_off);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.dialog_set_alarm_minute_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.dialog_set_alarm_hour_picker);
        Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.dialog_set_alarm_variable_spinner);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.dialog_set_alarm_relative_value_layout);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.dialog_set_alarm_variable_spinner_day);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        editText.setText(this.m_label);
        radioButton.setChecked(this.m_oneOff);
        radioButton2.setChecked(!this.m_oneOff);
        viewFlipper.setDisplayedChild(!this.m_oneOff ? 1 : 0);
        numberPicker.setMinimum(0);
        numberPicker2.setMinimum(0);
        numberPicker.setValue(this.m_delayInMinutes);
        numberPicker2.setValue(this.m_delayInHours);
        int[] iArr = {R.id.checkBoxMonday, R.id.checkBoxTuesday, R.id.checkBoxWednesday, R.id.checkBoxThursday, R.id.checkBoxFriday, R.id.checkBoxSaturday, R.id.checkBoxSunday};
        final CheckBox[] checkBoxArr = new CheckBox[7];
        int i4 = 0;
        for (int i5 = 7; i4 < i5; i5 = 7) {
            CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(iArr[i4]);
            checkBoxArr[i4] = checkBox;
            checkBox.setChecked(this.m_daysOfWeek[i4]);
            checkBoxArr[i4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.qi
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    SetAlarmClockAction.this.i0(button, radioButton2, checkBoxArr, compoundButton, z3);
                }
            });
            i4++;
            iArr = iArr;
        }
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.ri
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SetAlarmClockAction.this.j0(viewFlipper, button, checkBoxArr, compoundButton, z3);
            }
        });
        radioButton3.setChecked(this.m_relative);
        radioButton4.setChecked(!this.m_relative);
        viewFlipper2.setDisplayedChild(!this.m_relative ? 1 : 0);
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.si
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                SetAlarmClockAction.k0(viewFlipper2, compoundButton, z3);
            }
        });
        final TimePicker timePicker = (TimePicker) appCompatDialog.findViewById(R.id.dialog_set_alarm_timePicker);
        Boolean bool = Boolean.TRUE;
        timePicker.setIs24HourView(bool);
        final TimePicker timePicker2 = (TimePicker) appCompatDialog.findViewById(R.id.dialog_set_alarm_one_off_timePicker);
        timePicker2.setIs24HourView(bool);
        timePicker.setCurrentHour(Integer.valueOf(this.m_hour));
        timePicker.setCurrentMinute(Integer.valueOf(this.m_minute));
        timePicker2.setCurrentHour(Integer.valueOf(this.m_hour));
        timePicker2.setCurrentMinute(Integer.valueOf(this.m_minute));
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.define_value));
        String str2 = " (" + SelectableItem.r(R.string.minutes) + ")";
        Activity activity2 = getActivity();
        Macro macro = getMacro();
        if (this.m_variable != null) {
            str = this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, str2, false, new b(viewGroup));
        if (this.workingVariable == null) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, c0());
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setSelection(this.m_dayOption);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ti
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SetAlarmClockAction.l0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ui
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetAlarmClockAction.this.m0(activity, magicTextListener, view);
            }
        });
        button.setEnabled(p0(radioButton2.isChecked(), checkBoxArr));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ki
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetAlarmClockAction.this.n0(radioButton, checkBoxArr, timePicker2, timePicker, editText, radioButton3, numberPicker, numberPicker2, spinner2, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.li
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private static List<String> c0() {
        if (s_dayOptions == null) {
            ArrayList arrayList = new ArrayList();
            s_dayOptions = arrayList;
            arrayList.add(SelectableItem.r(R.string.today) + RemoteSettings.FORWARD_SLASH_STRING + SelectableItem.r(R.string.tomorrow));
            s_dayOptions.addAll(Arrays.asList(DateFormatSymbols.getInstance().getWeekdays()));
            s_dayOptions.remove("");
        }
        return s_dayOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_label = editText.getText().toString();
        appCompatDialog.dismiss();
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_alarm_clock_set_alarm), SelectableItem.r(R.string.action_alarm_clock_disable_alarm), SelectableItem.r(R.string.action_alarm_clock_dismiss_active_alarm)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Button button, RadioButton radioButton, CheckBox[] checkBoxArr, CompoundButton compoundButton, boolean z3) {
        button.setEnabled(p0(radioButton.isChecked(), checkBoxArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(ViewFlipper viewFlipper, Button button, CheckBox[] checkBoxArr, CompoundButton compoundButton, boolean z3) {
        viewFlipper.setDisplayedChild(!z3 ? 1 : 0);
        button.setEnabled(p0(!z3 ? 1 : 0, checkBoxArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(ViewFlipper viewFlipper, CompoundButton compoundButton, boolean z3) {
        viewFlipper.setDisplayedChild(!z3 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(RadioButton radioButton, CheckBox[] checkBoxArr, TimePicker timePicker, TimePicker timePicker2, EditText editText, RadioButton radioButton2, NumberPicker numberPicker, NumberPicker numberPicker2, Spinner spinner, AppCompatDialog appCompatDialog, View view) {
        this.m_oneOff = radioButton.isChecked();
        for (int i4 = 0; i4 < checkBoxArr.length; i4++) {
            this.m_daysOfWeek[i4] = checkBoxArr[i4].isChecked();
        }
        if (this.m_oneOff) {
            this.m_hour = timePicker.getCurrentHour().intValue();
            this.m_minute = timePicker.getCurrentMinute().intValue();
        } else {
            this.m_hour = timePicker2.getCurrentHour().intValue();
            this.m_minute = timePicker2.getCurrentMinute().intValue();
        }
        this.m_label = editText.getText().toString();
        this.m_relative = radioButton2.isChecked();
        this.m_delayInMinutes = numberPicker.getValue();
        this.m_delayInHours = numberPicker2.getValue();
        this.m_variable = this.workingVariable;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        this.m_dayOption = spinner.getSelectedItemPosition();
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(Activity activity, DialogInterface dialogInterface, int i4) {
        Settings.setShownAlarmClockPopup(activity, true);
        super.itemComplete();
    }

    private boolean p0(boolean z3, CheckBox[] checkBoxArr) {
        if (!z3) {
            return true;
        }
        for (CheckBox checkBox : checkBoxArr) {
            if (checkBox.isChecked()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        boolean z3;
        int i4 = this.m_option;
        String str = "";
        if (i4 == 2) {
            return "";
        }
        if (i4 == 1) {
            return this.m_label;
        }
        if (this.m_oneOff) {
            if (this.m_relative) {
                if (this.m_variable == null) {
                    return "[" + this.m_label + "] " + SelectableItem.r(R.string.one_off) + " (" + SelectableItem.r(R.string.relative) + ") - " + this.m_delayInHours + ":" + String.format("%02d", Integer.valueOf(this.m_delayInMinutes));
                }
                return "[" + this.m_label + "] " + SelectableItem.r(R.string.one_off) + " (" + SelectableItem.r(R.string.relative) + ") - " + this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
            }
            return "[" + this.m_label + "] " + SelectableItem.r(R.string.one_off) + " (" + SelectableItem.r(R.string.fixed) + ") - " + String.format("%02d", Integer.valueOf(this.m_hour)) + ":" + String.format("%02d", Integer.valueOf(this.m_minute)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + c0().get(this.m_dayOption);
        }
        int i5 = 6;
        String[] strArr = {SelectableItem.r(R.string.monday3), SelectableItem.r(R.string.tuesday3), SelectableItem.r(R.string.wednesday3), SelectableItem.r(R.string.thursday3), SelectableItem.r(R.string.friday3), SelectableItem.r(R.string.saturday3), SelectableItem.r(R.string.sunday3)};
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.m_label)) {
            str = "[" + this.m_label + "] ";
        }
        sb.append(str);
        sb.append(SelectableItem.r(R.string.repeated));
        sb.append(" - ");
        sb.append(String.format("%02d", Integer.valueOf(this.m_hour)));
        sb.append(":");
        sb.append(String.format("%02d", Integer.valueOf(this.m_minute)));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            if (i6 < 7) {
                if (i7 == -1 && this.m_daysOfWeek[i6]) {
                    i7 = i6;
                }
                if (i7 != -1 && i8 == -1 && !this.m_daysOfWeek[i6]) {
                    i8 = i6 - 1;
                }
                if (i7 >= 0 && i8 >= 0 && this.m_daysOfWeek[i6]) {
                    z3 = false;
                    break;
                }
                i6++;
            } else {
                z3 = true;
                break;
            }
        }
        if (i8 != -1) {
            i5 = i8;
        }
        if (z3 && i5 - i7 > 1) {
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(strArr[i7]);
            sb2.append(" - ");
            sb2.append(strArr[i5]);
        } else {
            int i9 = 0;
            while (true) {
                boolean[] zArr = this.m_daysOfWeek;
                if (i9 >= zArr.length) {
                    break;
                }
                if (zArr[i9]) {
                    sb2.append(strArr[i9]);
                    sb2.append(", ");
                }
                i9++;
            }
            sb2 = new StringBuilder(sb2.substring(0, sb2.length() - 2));
        }
        return sb2.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetAlarmClockActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        if (TextUtils.isEmpty(this.m_label)) {
            str = "";
        } else {
            str = " (" + this.m_label + ")";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    public MacroDroidVariable getVariable() {
        return this.m_variable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String[] o4 = o();
        if (o4 != null && o4.length > 0) {
            k();
            return;
        }
        this.m_option = 0;
        secondaryItemConfirmed();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_label, triggerContextInfo, getMacro());
        int i4 = this.m_option;
        if (i4 == 0) {
            Intent intent = new Intent("android.intent.action.SET_ALARM");
            intent.putExtra("android.intent.extra.alarm.MESSAGE", replaceMagicText);
            intent.putExtra("android.intent.extra.alarm.SKIP_UI", true);
            int i5 = 0;
            if (this.m_oneOff) {
                if (this.m_relative) {
                    Calendar calendar = Calendar.getInstance();
                    MacroDroidVariable macroDroidVariable = this.m_variable;
                    if (macroDroidVariable != null) {
                        MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
                        if (variableByName != null) {
                            Long longValue = variableByName.getLongValue(this.varDictionaryKeys);
                            if (longValue != null) {
                                int intValue = longValue.intValue();
                                if (intValue > 0) {
                                    i5 = intValue / 1440;
                                    calendar.add(12, intValue);
                                }
                            } else {
                                SystemLog.logError("Not setting alarm clock, variable not found: " + this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys), getMacroGuid().longValue());
                                return;
                            }
                        } else {
                            SystemLog.logError("Not setting alarm clock, variable not found: " + this.m_variable.getName(), getMacroGuid().longValue());
                            return;
                        }
                    } else {
                        int i6 = this.m_delayInHours;
                        int i7 = this.m_delayInMinutes;
                        calendar.add(12, (i6 * 60) + i7);
                        i5 = ((i6 * 60) + i7) / 1440;
                    }
                    int i8 = calendar.get(11);
                    int i9 = calendar.get(12);
                    if (i5 > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(((calendar.get(7) - 1) % 7) + 1));
                        intent.putExtra("android.intent.extra.alarm.DAYS", arrayList);
                    }
                    intent.putExtra("android.intent.extra.alarm.HOUR", i8);
                    intent.putExtra("android.intent.extra.alarm.MINUTES", i9);
                } else {
                    intent.putExtra("android.intent.extra.alarm.HOUR", this.m_hour);
                    intent.putExtra("android.intent.extra.alarm.MINUTES", this.m_minute);
                    if (this.m_dayOption > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(Integer.valueOf(this.m_dayOption));
                        intent.putExtra("android.intent.extra.alarm.DAYS", arrayList2);
                    }
                }
                intent.addFlags(268435456);
                try {
                    getContext().startActivity(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                    SystemLog.logError("Sorry your device cannot handle the intent to set an alarm (No suitable clock app found)", getMacroGuid().longValue());
                    return;
                }
            }
            intent.putExtra("android.intent.extra.alarm.HOUR", this.m_hour);
            intent.putExtra("android.intent.extra.alarm.MINUTES", this.m_minute);
            ArrayList arrayList3 = new ArrayList();
            while (true) {
                boolean[] zArr = this.m_daysOfWeek;
                if (i5 < zArr.length) {
                    if (zArr[i5]) {
                        arrayList3.add(Integer.valueOf(((i5 + 1) % 7) + 1));
                    }
                    i5++;
                } else {
                    intent.putExtra("android.intent.extra.alarm.DAYS", arrayList3);
                    intent.addFlags(268435456);
                    try {
                        getContext().startActivity(intent);
                        return;
                    } catch (ActivityNotFoundException unused2) {
                        SystemLog.logError("Set alarm failed, your system has no app that can handle the AlarmClock.ACTION_SET_ALARM intent", getMacroGuid().longValue());
                        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.error, 1).show();
                        return;
                    }
                }
            }
        } else if (i4 == 1) {
            Intent intent2 = new Intent("android.intent.action.DISMISS_ALARM");
            intent2.putExtra("android.intent.extra.alarm.SEARCH_MODE", "android.label");
            intent2.putExtra("android.intent.extra.alarm.MESSAGE", replaceMagicText);
            intent2.addFlags(268435456);
            intent2.putExtra("android.intent.extra.alarm.SKIP_UI", true);
            try {
                getContext().startActivity(intent2);
            } catch (ActivityNotFoundException unused3) {
                SystemLog.logError("Clear alarm failed, your system has no app that can handle the AlarmClock.ACTION_DISMISS_ALARM intent", getMacroGuid().longValue());
                ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.clear_alarm_failed_error, 1).show();
            }
        } else if (i4 == 2) {
            try {
                Intent intent3 = new Intent("android.intent.action.DISMISS_ALARM");
                intent3.addFlags(268435456);
                getContext().startActivity(intent3);
            } catch (ActivityNotFoundException unused4) {
                SystemLog.logError("Dismiss alarm failed, your system has no app that can handle the AlarmClock.ACTION_DISMISS_ALARM intent", getMacroGuid().longValue());
                ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.clear_alarm_failed_error, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        final Activity activity = getActivity();
        if (checkActivityAlive() && !Settings.hasShownAlarmClockPopup(activity)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
            builder.setTitle(R.string.action_alarm_clock);
            builder.setMessage(R.string.action_alarm_clock_first_run);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ji
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    SetAlarmClockAction.this.o0(activity, dialogInterface, i4);
                }
            });
            try {
                builder.show();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        if (Build.VERSION.SDK_INT >= 23) {
            return getOptions();
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_option;
        if (i4 == 0) {
            b0();
        } else if (i4 == 1) {
            a0();
        } else if (i4 == 2) {
            itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_minute);
        parcel.writeInt(this.m_hour);
        parcel.writeString(this.m_label);
        parcel.writeInt(this.m_oneOff ? 1 : 0);
        parcel.writeBooleanArray(this.m_daysOfWeek);
        parcel.writeInt(this.m_relative ? 1 : 0);
        parcel.writeInt(this.m_delayInHours);
        parcel.writeInt(this.m_delayInMinutes);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeInt(this.m_dayOption);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public SetAlarmClockAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetAlarmClockAction() {
        this.m_daysOfWeek = new boolean[7];
        this.m_hour = 8;
        this.m_minute = 15;
        this.m_relative = true;
        this.m_oneOff = true;
        this.m_label = "";
    }

    private SetAlarmClockAction(Parcel parcel) {
        super(parcel);
        boolean[] zArr = new boolean[7];
        this.m_daysOfWeek = zArr;
        this.m_option = parcel.readInt();
        this.m_minute = parcel.readInt();
        this.m_hour = parcel.readInt();
        this.m_label = parcel.readString();
        this.m_oneOff = parcel.readInt() != 0;
        parcel.readBooleanArray(zArr);
        this.m_relative = parcel.readInt() != 0;
        this.m_delayInHours = parcel.readInt();
        this.m_delayInMinutes = parcel.readInt();
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_dayOption = parcel.readInt();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2481a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2482b;

        a(Button button, EditText editText) {
            this.f2481a = button;
            this.f2482b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2481a;
            if (this.f2482b.length() > 0) {
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
