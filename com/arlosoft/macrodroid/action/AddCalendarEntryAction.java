package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.AddCalendarEntryActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.calendar.CalendarArrayAdapter;
import com.arlosoft.macrodroid.calendar.CalendarInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.ExpressionUtils;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class AddCalendarEntryAction extends Action implements SupportsMagicText, HasStringVariableName, HasDictionaryKeys {
    public static final Parcelable.Creator<AddCalendarEntryAction> CREATOR = new d();
    public static final int TIME_UNIT_HOURS = 2;
    public static final int TIME_UNIT_MINUTES = 1;
    public static final int TIME_UNIT_SECONDS = 0;
    private boolean m_allDayEvent;
    private int m_availability;
    private String m_calendarId;
    private String m_detail;
    private String m_durationValue;
    private int m_fixedDays;
    private int m_fixedHour;
    private int m_fixedMinute;
    private int m_fixedMonths;
    private boolean m_fixedTime;
    private int m_relativeDays;
    private int m_relativeHours;
    private int m_relativeMinutes;
    private String m_relativeTimeVariableName;
    private int m_timeUnitForVariable;
    private String m_title;
    private boolean m_useVariableTimeInFuture;
    private DictionaryKeys varDictionaryKeys;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient String workingVariableName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewFlipper f2071a;

        a(ViewFlipper viewFlipper) {
            this.f2071a = viewFlipper;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            this.f2071a.setDisplayedChild(0);
            AddCalendarEntryAction.this.workingVariableName = null;
            AddCalendarEntryAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2071a.setDisplayedChild(1);
            AddCalendarEntryAction.this.workingVariableName = macroDroidVariable.getName();
            AddCalendarEntryAction addCalendarEntryAction = AddCalendarEntryAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            addCalendarEntryAction.workingDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes2.dex */
    class d implements Parcelable.Creator<AddCalendarEntryAction> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AddCalendarEntryAction createFromParcel(Parcel parcel) {
            return new AddCalendarEntryAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AddCalendarEntryAction[] newArray(int i4) {
            return new AddCalendarEntryAction[i4];
        }
    }

    /* synthetic */ AddCalendarEntryAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Z() {
        int i4;
        String str;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Spinner spinner;
        Activity activity;
        boolean z3;
        Activity activity2 = getActivity();
        Pair<String, List<CalendarInfo>> allCalendars = CalendarInfo.getAllCalendars(getContext());
        this.workingVariableName = this.m_relativeTimeVariableName;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        String str2 = allCalendars.first;
        List<CalendarInfo> list = allCalendars.second;
        if (list.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.action_add_calendar_event_no_calendars), 1).show();
            return;
        }
        if (this.m_calendarId == null) {
            this.m_calendarId = str2;
        }
        int i11 = 0;
        while (true) {
            if (i11 < list.size()) {
                if (list.get(i11).id.equals(this.m_calendarId)) {
                    i4 = i11;
                    break;
                }
                i11++;
            } else {
                i4 = 0;
                break;
            }
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity2, getDialogTheme());
        appCompatDialog.setContentView(R.layout.calendar_configure);
        appCompatDialog.setTitle(getContext().getString(R.string.action_add_calendar_event_configure));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!activity2.getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        TextInputLayout textInputLayout = (TextInputLayout) appCompatDialog.findViewById(R.id.calendar_title_textinputlayout);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.calendar_configure_title);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.calendar_configure_detail);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.calendar_configure_title_magic_text);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.calendar_configure_detail_magic_text);
        Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.calendar_configure_spinner);
        Spinner spinner3 = (Spinner) appCompatDialog.findViewById(R.id.calendar_configure_availability_spinner);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.select_calendar_spinner);
        final EditText editText3 = (EditText) appCompatDialog.findViewById(R.id.duration_text);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.duration_magic_button);
        final Spinner spinner4 = (Spinner) appCompatDialog.findViewById(R.id.relativeTimeOption);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.plusRadioButton);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.minusRadioButton);
        final Spinner spinner5 = (Spinner) appCompatDialog.findViewById(R.id.timeUnitSpinner);
        ViewFlipper viewFlipper = (ViewFlipper) appCompatDialog.findViewById(R.id.relativeTimeViewFlipper);
        final ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.calendar_relative_time_layout);
        final ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.calendar_fixed_time_layout);
        RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.relative_radio_button);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.fixed_radio_button);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.days_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.hours_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.minutes_picker);
        final NumberPicker numberPicker4 = (NumberPicker) appCompatDialog.findViewById(R.id.fixed_days_picker);
        final NumberPicker numberPicker5 = (NumberPicker) appCompatDialog.findViewById(R.id.fixed_months_picker);
        final TimePicker timePicker = (TimePicker) appCompatDialog.findViewById(R.id.fixed_time_picker);
        final TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.time_of_day_label);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.all_day_checkbox);
        final LinearLayout linearLayout = (LinearLayout) appCompatDialog.findViewById(R.id.duration_box_layout);
        int i12 = i4;
        ((TextView) appCompatDialog.findViewById(R.id.use_alarm_description)).setVisibility(8);
        ((CheckBox) appCompatDialog.findViewById(R.id.use_alarm)).setVisibility(8);
        ((CheckBox) appCompatDialog.findViewById(R.id.enable_regex)).setVisibility(8);
        ((TextView) appCompatDialog.findViewById(R.id.variable_constraint_dialog_wildcards_info)).setVisibility(8);
        ((CheckBox) appCompatDialog.findViewById(R.id.ignore_all_day)).setVisibility(8);
        ((CheckBox) appCompatDialog.findViewById(R.id.check_in_advance)).setVisibility(8);
        ((ViewGroup) appCompatDialog.findViewById(R.id.calendar_configure_radio_buttons)).setVisibility(8);
        ((LinearLayout) appCompatDialog.findViewById(R.id.duration_layout)).setVisibility(0);
        ((TextInputLayout) appCompatDialog.findViewById(R.id.duration_textinputlayout)).setHint(SelectableItem.r(R.string.duration) + " (" + SelectableItem.r(R.string.minutes) + ")");
        String str3 = this.m_durationValue;
        if (str3 != null) {
            if (str3 == null) {
                str3 = "0";
            }
            editText3.setText(str3);
        } else {
            editText3.setText("0");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.relative_time));
        Activity activity3 = getActivity();
        Macro macro = getMacro();
        if (this.workingVariableName != null) {
            str = this.workingVariableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity3, R.style.Theme_App_Dialog_Action, this, spinner4, macro, arrayList, str, "", false, new a(viewFlipper));
        if (this.workingVariableName == null) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        viewFlipper.setDisplayedChild(i5);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), (int) R.layout.simple_spinner_item, getContext().getResources().getStringArray(R.array.availability_options_set));
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner3.setSelection(this.m_availability);
        radioButton.setChecked(this.m_useVariableTimeInFuture);
        radioButton2.setChecked(!this.m_useVariableTimeInFuture);
        numberPicker3.setValue(this.m_relativeMinutes);
        numberPicker2.setValue(this.m_relativeHours);
        numberPicker.setValue(this.m_relativeDays);
        numberPicker4.setValue(this.m_fixedDays);
        numberPicker5.setValue(this.m_fixedMonths);
        timePicker.setIs24HourView(Boolean.TRUE);
        timePicker.setCurrentHour(Integer.valueOf(this.m_fixedHour));
        timePicker.setCurrentMinute(Integer.valueOf(this.m_fixedMinute));
        checkBox.setChecked(this.m_allDayEvent);
        if (this.m_allDayEvent) {
            i6 = 8;
        } else {
            i6 = 0;
        }
        linearLayout.setVisibility(i6);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                AddCalendarEntryAction.a0(linearLayout, timePicker, textView2, compoundButton, z4);
            }
        });
        if (this.m_allDayEvent) {
            i7 = 8;
        } else {
            i7 = 0;
        }
        timePicker.setVisibility(i7);
        if (this.m_allDayEvent) {
            i8 = 8;
        } else {
            i8 = 0;
        }
        textView2.setVisibility(i8);
        radioButton3.setChecked(!this.m_fixedTime);
        radioButton4.setChecked(this.m_fixedTime);
        if (this.m_fixedTime) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        viewGroup2.setVisibility(i9);
        if (this.m_fixedTime) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        viewGroup.setVisibility(i10);
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                AddCalendarEntryAction.b0(viewGroup2, viewGroup, compoundButton, z4);
            }
        });
        spinner5.setSelection(this.m_timeUnitForVariable);
        if (list.size() > 1) {
            spinner2.setVisibility(0);
            spinner = spinner3;
            activity = activity2;
            CalendarArrayAdapter calendarArrayAdapter = new CalendarArrayAdapter(activity, list);
            calendarArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter((SpinnerAdapter) calendarArrayAdapter);
            spinner2.setSelection(i12);
        } else {
            spinner = spinner3;
            activity = activity2;
            spinner2.setVisibility(8);
            textView.setVisibility(8);
        }
        spinner2.setOnItemSelectedListener(new b(list));
        textInputLayout.setHint(R.string.title);
        String str4 = this.m_title;
        if (str4 != null) {
            editText.setText(str4);
            editText.setSelection(editText.length());
        }
        String str5 = this.m_detail;
        if (str5 != null) {
            editText2.setText(str5);
            editText2.setSelection(editText2.length());
        }
        c cVar = new c(button, editText, editText3);
        editText.addTextChangedListener(cVar);
        editText3.addTextChangedListener(cVar);
        final Activity activity4 = activity;
        final Spinner spinner6 = spinner;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCalendarEntryAction.this.c0(editText, editText2, editText3, numberPicker3, numberPicker2, numberPicker, numberPicker5, numberPicker4, timePicker, radioButton4, checkBox, spinner6, radioButton, spinner5, spinner4, appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.j
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AddCalendarEntryAction.e0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCalendarEntryAction.this.f0(activity4, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.l
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AddCalendarEntryAction.g0(editText2, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCalendarEntryAction.this.h0(activity4, magicTextListener2, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener3 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.n
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                AddCalendarEntryAction.i0(editText3, magicTextPair);
            }
        };
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCalendarEntryAction.this.j0(activity4, magicTextListener3, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(LinearLayout linearLayout, TimePicker timePicker, TextView textView, CompoundButton compoundButton, boolean z3) {
        int i4;
        int i5;
        int i6 = 8;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        linearLayout.setVisibility(i4);
        if (z3) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        timePicker.setVisibility(i5);
        if (!z3) {
            i6 = 0;
        }
        textView.setVisibility(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(ViewGroup viewGroup, ViewGroup viewGroup2, CompoundButton compoundButton, boolean z3) {
        int i4;
        int i5 = 8;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        viewGroup.setVisibility(i4);
        if (z3) {
            i5 = 0;
        }
        viewGroup2.setVisibility(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(EditText editText, EditText editText2, EditText editText3, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, NumberPicker numberPicker5, TimePicker timePicker, RadioButton radioButton, CheckBox checkBox, Spinner spinner, RadioButton radioButton2, Spinner spinner2, Spinner spinner3, AppCompatDialog appCompatDialog, View view) {
        this.m_title = editText.getText().toString();
        this.m_detail = editText2.getText().toString();
        this.m_durationValue = editText3.getText().toString();
        this.m_relativeMinutes = numberPicker.getValue();
        this.m_relativeHours = numberPicker2.getValue();
        this.m_relativeDays = numberPicker3.getValue();
        this.m_fixedMonths = numberPicker4.getValue();
        this.m_fixedDays = numberPicker5.getValue();
        this.m_fixedHour = timePicker.getCurrentHour().intValue();
        this.m_fixedMinute = timePicker.getCurrentMinute().intValue();
        this.m_fixedTime = radioButton.isChecked();
        this.m_allDayEvent = checkBox.isChecked();
        this.m_availability = spinner.getSelectedItemPosition();
        this.m_useVariableTimeInFuture = radioButton2.isChecked();
        this.m_timeUnitForVariable = spinner2.getSelectedItemPosition();
        spinner3.getSelectedItemPosition();
        this.m_relativeTimeVariableName = this.workingVariableName;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        itemComplete();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @NonNull
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_title;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AddCalendarEntryActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_title, this.m_detail};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + ": " + g(this.m_title, triggerContextInfo) + " / " + g(this.m_detail, triggerContextInfo);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public String getVariableName() {
        return this.m_relativeTimeVariableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Z();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    @Override // com.arlosoft.macrodroid.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo r14) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.AddCalendarEntryAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@NonNull DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_title = strArr[0];
            this.m_detail = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(String str) {
        this.m_relativeTimeVariableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_title);
        parcel.writeString(this.m_detail);
        parcel.writeString(this.m_calendarId);
        parcel.writeString(this.m_durationValue);
        parcel.writeInt(this.m_fixedTime ? 1 : 0);
        parcel.writeInt(this.m_relativeMinutes);
        parcel.writeInt(this.m_relativeHours);
        parcel.writeInt(this.m_relativeDays);
        parcel.writeInt(this.m_fixedMonths);
        parcel.writeInt(this.m_fixedDays);
        parcel.writeInt(this.m_fixedHour);
        parcel.writeInt(this.m_fixedMinute);
        parcel.writeInt(this.m_allDayEvent ? 1 : 0);
        parcel.writeInt(this.m_availability);
        parcel.writeString(this.m_relativeTimeVariableName);
        parcel.writeInt(this.m_timeUnitForVariable);
        parcel.writeInt(this.m_useVariableTimeInFuture ? 1 : 0);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public AddCalendarEntryAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private AddCalendarEntryAction() {
        this.m_relativeTimeVariableName = null;
        this.m_timeUnitForVariable = 0;
        this.m_useVariableTimeInFuture = true;
    }

    private AddCalendarEntryAction(Parcel parcel) {
        super(parcel);
        this.m_relativeTimeVariableName = null;
        this.m_timeUnitForVariable = 0;
        this.m_useVariableTimeInFuture = true;
        this.m_title = parcel.readString();
        this.m_detail = parcel.readString();
        this.m_calendarId = parcel.readString();
        this.m_durationValue = parcel.readString();
        this.m_fixedTime = parcel.readInt() != 0;
        this.m_relativeMinutes = parcel.readInt();
        this.m_relativeHours = parcel.readInt();
        this.m_relativeDays = parcel.readInt();
        this.m_fixedMonths = parcel.readInt();
        this.m_fixedDays = parcel.readInt();
        this.m_fixedHour = parcel.readInt();
        this.m_fixedMinute = parcel.readInt();
        this.m_allDayEvent = parcel.readInt() != 0;
        this.m_availability = parcel.readInt();
        this.m_relativeTimeVariableName = parcel.readString();
        this.m_timeUnitForVariable = parcel.readInt();
        this.m_useVariableTimeInFuture = parcel.readInt() != 0;
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2073a;

        b(List list) {
            this.f2073a = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            AddCalendarEntryAction.this.m_calendarId = ((CalendarInfo) this.f2073a.get(i4)).id;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2075a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2076b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2077c;

        c(Button button, EditText editText, EditText editText2) {
            this.f2075a = button;
            this.f2076b = editText;
            this.f2077c = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2075a;
            if (this.f2076b.getText().length() > 0 && ExpressionUtils.isValidExpression(AddCalendarEntryAction.this.getContext(), AddCalendarEntryAction.this.getMacro(), this.f2077c.getText().toString(), null)) {
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
