package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.calendar.CalendarArrayAdapter;
import com.arlosoft.macrodroid.calendar.CalendarInfo;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.CalendarTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.CheckCalendarReceiver;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class CalendarTrigger extends Trigger {
    public static final int AVAILABILITY_ANY = 0;
    public static final int AVAILABILITY_BUSY = 1;
    public static final Parcelable.Creator<CalendarTrigger> CREATOR = new b();
    private static PendingIntent s_pendingIntent;
    private static int s_triggerCounter;
    private String calendarAccount;
    private boolean enableRegex;
    private boolean ignoreCase;
    private int m_advanceTimeSeconds;
    private int m_availability;
    private String m_calendarId;
    private String m_calendarName;
    private boolean m_checkInAdvance;
    private String m_detailText;
    private boolean m_eventStart;
    private boolean m_ignoreAllDay;
    private boolean m_negativeAdvanceCheck;
    private String m_titleText;
    private String simpleCalendarName;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<CalendarTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CalendarTrigger createFromParcel(Parcel parcel) {
            return new CalendarTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CalendarTrigger[] newArray(int i4) {
            return new CalendarTrigger[i4];
        }
    }

    /* synthetic */ CalendarTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Z() {
        Pair<String, List<CalendarInfo>> allCalendars = CalendarInfo.getAllCalendars(getContext());
        String str = allCalendars.first;
        List<CalendarInfo> list = allCalendars.second;
        if (list.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.action_add_calendar_event_no_calendars), 1).show();
            return;
        }
        if (this.m_calendarId == null) {
            this.m_calendarId = str;
        }
        int i4 = 0;
        while (true) {
            if (i4 < list.size()) {
                if (list.get(i4).id.equals(this.m_calendarId)) {
                    break;
                }
                i4++;
            } else {
                i4 = 0;
                break;
            }
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.calendar_configure);
        appCompatDialog.setTitle(getContext().getString(R.string.constraint_calendar_select_option));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.calendar_configure_title);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.calendar_configure_detail);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.calendar_configure_title_magic_text);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.calendar_configure_detail_magic_text);
        Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.calendar_configure_spinner);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.calendar_configure_in_event);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.calendar_configure_not_in_event);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.ignore_case);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.enable_regex);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.ignore_all_day);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.check_in_advance);
        final CheckBox checkBox5 = (CheckBox) appCompatDialog.findViewById(R.id.use_alarm);
        final View findViewById = appCompatDialog.findViewById(R.id.calendar_advance_time_layout);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.calendar_advance_minute_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.calendar_advance_hour_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.calendar_advance_day_picker);
        final CheckBox checkBox6 = (CheckBox) appCompatDialog.findViewById(R.id.check_negative);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.calendar_configure_availability_spinner);
        spinner2.setSelection(this.m_availability);
        radioButton.setText(R.string.trigger_calendar_event_start);
        radioButton2.setText(R.string.trigger_calendar_event_end);
        checkBox3.setChecked(this.m_ignoreAllDay);
        checkBox5.setChecked(Settings.getUseCalendarAlarm(getContext()));
        checkBox.setEnabled(!this.enableRegex);
        checkBox.setChecked(this.ignoreCase);
        checkBox2.setChecked(this.enableRegex);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.z0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CalendarTrigger.a0(checkBox, compoundButton, z3);
            }
        });
        if (list.size() > 1) {
            spinner.setVisibility(0);
            spinner.setAdapter((SpinnerAdapter) new CalendarArrayAdapter(activity, list));
            spinner.setSelection(i4);
        } else {
            spinner.setVisibility(8);
        }
        radioButton.setChecked(this.m_eventStart);
        radioButton2.setChecked(!this.m_eventStart);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.a1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CalendarTrigger.this.b0(compoundButton, z3);
            }
        });
        spinner.setOnItemSelectedListener(new a(list));
        String str2 = this.m_titleText;
        if (str2 != null) {
            editText.setText(str2);
            editText.setSelection(editText.length());
        }
        String str3 = this.m_detailText;
        if (str3 != null) {
            editText2.setText(str3);
            editText2.setSelection(editText2.length());
        }
        numberPicker.setMinimum(0);
        numberPicker.setValue((this.m_advanceTimeSeconds / 60) % 60);
        numberPicker2.setMinimum(0);
        numberPicker2.setValue((this.m_advanceTimeSeconds / 3600) % 24);
        numberPicker3.setMinimum(0);
        numberPicker3.setValue(this.m_advanceTimeSeconds / Strategy.TTL_SECONDS_MAX);
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.b1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CalendarTrigger.c0(findViewById, compoundButton, z3);
            }
        });
        checkBox4.setChecked(this.m_checkInAdvance);
        checkBox6.setChecked(this.m_negativeAdvanceCheck);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarTrigger.this.d0(appCompatDialog, checkBox3, editText, editText2, spinner2, checkBox4, numberPicker, numberPicker2, numberPicker3, checkBox6, checkBox2, checkBox, checkBox5, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.e1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CalendarTrigger.f0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarTrigger.this.g0(activity, magicTextListener, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.g1
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CalendarTrigger.h0(editText2, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalendarTrigger.this.i0(activity, magicTextListener2, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(CompoundButton compoundButton, boolean z3) {
        this.m_eventStart = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(View view, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(AppCompatDialog appCompatDialog, CheckBox checkBox, EditText editText, EditText editText2, Spinner spinner, CheckBox checkBox2, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, View view) {
        appCompatDialog.cancel();
        this.m_ignoreAllDay = checkBox.isChecked();
        this.m_titleText = editText.getText().toString();
        this.m_detailText = editText2.getText().toString();
        this.m_availability = spinner.getSelectedItemPosition();
        this.m_checkInAdvance = checkBox2.isChecked();
        this.m_advanceTimeSeconds = (numberPicker.getValue() * 60) + (numberPicker2.getValue() * 3600) + (numberPicker3.getValue() * Strategy.TTL_SECONDS_MAX);
        this.m_negativeAdvanceCheck = checkBox3.isChecked();
        this.enableRegex = checkBox4.isChecked();
        this.ignoreCase = checkBox5.isChecked();
        Settings.setUseCalendarAlarm(getContext(), checkBox6.isChecked());
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, false, true, R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    public static void scheduleAlarm(Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, 5 - (calendar.get(12) % 5));
        calendar.set(13, 1);
        SystemLog.logDebug("Scheduling calendar check at " + String.format("%02d", Integer.valueOf(calendar.get(11))) + ":" + String.format("%02d", Integer.valueOf(calendar.get(12))) + ":" + String.format("%02d", Integer.valueOf(calendar.get(13))));
        if (s_pendingIntent != null) {
            AlarmHelper.scheduleExactRTCWithAlarmOption(Settings.getUseCalendarAlarm(context), calendar.getTimeInMillis(), s_pendingIntent);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void configureOnImport() {
        Pair<String, List<CalendarInfo>> allCalendars = CalendarInfo.getAllCalendars(getContext());
        String str = allCalendars.first;
        for (CalendarInfo calendarInfo : allCalendars.second) {
            if ((calendarInfo.ownerAccount + " (" + calendarInfo.name + ")").equals(this.m_calendarName)) {
                this.m_calendarId = calendarInfo.id;
                return;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(s_pendingIntent);
                s_pendingIntent = null;
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_pendingIntent = PendingIntent.getBroadcast(getContext(), 0, new Intent(getContext(), CheckCalendarReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
            scheduleAlarm(getContext());
        }
        s_triggerCounter++;
    }

    public String getAccount() {
        return this.calendarAccount;
    }

    public int getAvailability() {
        return this.m_availability;
    }

    public String getCalendarId() {
        return this.m_calendarId;
    }

    public String getCalendarName() {
        return this.m_calendarName;
    }

    public boolean getCheckInAdvance() {
        return this.m_checkInAdvance;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4;
        if (this.m_eventStart) {
            i4 = R.string.trigger_calendar_event_start;
        } else {
            i4 = R.string.trigger_calendar_event_end;
        }
        return SelectableItem.r(i4);
    }

    public String getDetailText() {
        return this.m_detailText;
    }

    public boolean getEventStart() {
        return this.m_eventStart;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        String str2;
        if (TextUtils.isEmpty(this.m_calendarId)) {
            return "[" + SelectableItem.r(R.string.select_calendar) + "]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(getContext().getResources().getStringArray(R.array.availability_options)[this.m_availability]);
        sb.append(")");
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.m_titleText);
        if (this.m_checkInAdvance) {
            int i4 = this.m_advanceTimeSeconds;
            int i5 = (i4 / 60) % 60;
            int i6 = (i4 / 3600) % 24;
            int i7 = i4 / Strategy.TTL_SECONDS_MAX;
            if (i5 != 0 || i6 != 0 || i7 != 0) {
                if (this.m_negativeAdvanceCheck) {
                    sb.append(" [-");
                } else {
                    sb.append(" [+");
                }
                String str3 = "";
                if (i7 <= 0) {
                    str = "";
                } else {
                    str = i7 + SelectableItem.r(R.string.days_captial).toLowerCase().substring(0, 1).toLowerCase(Locale.getDefault());
                }
                sb.append(str);
                if (i6 <= 0) {
                    str2 = "";
                } else {
                    str2 = i6 + SelectableItem.r(R.string.hours_capital).toLowerCase().substring(0, 1).toLowerCase(Locale.getDefault());
                }
                sb.append(str2);
                if (i5 > 0) {
                    str3 = i5 + SelectableItem.r(R.string.minutes).substring(0, 1).toLowerCase(Locale.getDefault());
                }
                sb.append(str3);
                sb.append("]");
            }
        }
        return sb.toString();
    }

    public boolean getIgnoreAllDay() {
        return this.m_ignoreAllDay;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CalendarTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        if (!TextUtils.isEmpty(this.m_titleText)) {
            str = this.m_titleText;
        } else {
            str = this.m_detailText;
        }
        if (TextUtils.isEmpty(str)) {
            return getConfiguredName();
        }
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(str, 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CALENDAR"};
    }

    public String getSimpleCalendarName() {
        return this.simpleCalendarName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        String str;
        if (!TextUtils.isEmpty(this.m_titleText)) {
            str = this.m_titleText;
        } else {
            str = this.m_detailText;
        }
        if (TextUtils.isEmpty(str)) {
            return getConfiguredName();
        }
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(str, 150) + ")";
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public TriggerContextInfo getTestTriggerContentInfo() {
        return new TriggerContextInfo(this, "test title", "test detail", "test location", "25/12/2000", "12/25/2000", "04:44", "26/12/2000", "12/26/2000", "05:55");
    }

    public int getTimeInAdvanceSeconds() {
        if (this.m_negativeAdvanceCheck) {
            return -this.m_advanceTimeSeconds;
        }
        return this.m_advanceTimeSeconds;
    }

    public String getTitleText() {
        return this.m_titleText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Z();
    }

    public boolean isEnableRegex() {
        return this.enableRegex;
    }

    public boolean isIgnoreCase() {
        return this.ignoreCase;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_calendarId);
        parcel.writeString(this.m_calendarName);
        parcel.writeInt(this.m_eventStart ? 1 : 0);
        parcel.writeString(this.m_titleText);
        parcel.writeString(this.m_detailText);
        parcel.writeInt(this.m_availability);
        parcel.writeInt(this.m_checkInAdvance ? 1 : 0);
        parcel.writeInt(this.m_advanceTimeSeconds);
        parcel.writeInt(this.m_negativeAdvanceCheck ? 1 : 0);
        parcel.writeInt(this.m_ignoreAllDay ? 1 : 0);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeString(this.calendarAccount);
        parcel.writeString(this.simpleCalendarName);
        parcel.writeInt(this.ignoreCase ? 1 : 0);
    }

    public CalendarTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CalendarTrigger() {
        this.m_eventStart = true;
    }

    private CalendarTrigger(Parcel parcel) {
        super(parcel);
        this.m_calendarId = parcel.readString();
        this.m_calendarName = parcel.readString();
        this.m_eventStart = parcel.readInt() != 0;
        this.m_titleText = parcel.readString();
        this.m_detailText = parcel.readString();
        this.m_availability = parcel.readInt();
        this.m_checkInAdvance = parcel.readInt() != 0;
        this.m_advanceTimeSeconds = parcel.readInt();
        this.m_negativeAdvanceCheck = parcel.readInt() != 0;
        this.m_ignoreAllDay = parcel.readInt() != 0;
        this.enableRegex = parcel.readInt() != 0;
        this.calendarAccount = parcel.readString();
        this.simpleCalendarName = parcel.readString();
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f14334a;

        a(List list) {
            this.f14334a = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            CalendarTrigger.this.m_calendarId = ((CalendarInfo) this.f14334a.get(i4)).id;
            CalendarTrigger calendarTrigger = CalendarTrigger.this;
            calendarTrigger.m_calendarName = ((CalendarInfo) this.f14334a.get(i4)).ownerAccount + " (" + ((CalendarInfo) this.f14334a.get(i4)).name + ")";
            CalendarTrigger.this.calendarAccount = ((CalendarInfo) this.f14334a.get(i4)).ownerAccount;
            CalendarTrigger.this.simpleCalendarName = ((CalendarInfo) this.f14334a.get(i4)).name;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
