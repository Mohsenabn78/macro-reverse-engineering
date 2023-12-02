package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class CalendarConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f10992a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final NumberPicker calendarAdvanceDayPicker;
    @NonNull
    public final NumberPicker calendarAdvanceHourPicker;
    @NonNull
    public final NumberPicker calendarAdvanceMinutePicker;
    @NonNull
    public final LinearLayout calendarAdvanceTimeLayout;
    @NonNull
    public final TextView calendarConfigureAvailabilityLabel;
    @NonNull
    public final Spinner calendarConfigureAvailabilitySpinner;
    @NonNull
    public final AppCompatEditText calendarConfigureDetail;
    @NonNull
    public final Button calendarConfigureDetailMagicText;
    @NonNull
    public final RadioButton calendarConfigureInEvent;
    @NonNull
    public final RadioButton calendarConfigureNotInEvent;
    @NonNull
    public final RadioGroup calendarConfigureRadioButtons;
    @NonNull
    public final Spinner calendarConfigureSpinner;
    @NonNull
    public final AppCompatEditText calendarConfigureTitle;
    @NonNull
    public final Button calendarConfigureTitleMagicText;
    @NonNull
    public final TextInputLayout calendarTitleTextinputlayout;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox checkInAdvance;
    @NonNull
    public final CheckBox checkNegative;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final CheckBox ignoreAllDay;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView selectCalendarSpinner;
    @NonNull
    public final CheckBox useAlarm;
    @NonNull
    public final TextView useAlarmDescription;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;

    private CalendarConfigureBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull NumberPicker numberPicker3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull Spinner spinner, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup, @NonNull Spinner spinner2, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button2, @NonNull TextInputLayout textInputLayout, @NonNull Button button3, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull CheckBox checkBox5, @NonNull Button button4, @NonNull TextView textView2, @NonNull CheckBox checkBox6, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f10992a = scrollView;
        this.buttonBar = linearLayout;
        this.calendarAdvanceDayPicker = numberPicker;
        this.calendarAdvanceHourPicker = numberPicker2;
        this.calendarAdvanceMinutePicker = numberPicker3;
        this.calendarAdvanceTimeLayout = linearLayout2;
        this.calendarConfigureAvailabilityLabel = textView;
        this.calendarConfigureAvailabilitySpinner = spinner;
        this.calendarConfigureDetail = appCompatEditText;
        this.calendarConfigureDetailMagicText = button;
        this.calendarConfigureInEvent = radioButton;
        this.calendarConfigureNotInEvent = radioButton2;
        this.calendarConfigureRadioButtons = radioGroup;
        this.calendarConfigureSpinner = spinner2;
        this.calendarConfigureTitle = appCompatEditText2;
        this.calendarConfigureTitleMagicText = button2;
        this.calendarTitleTextinputlayout = textInputLayout;
        this.cancelButton = button3;
        this.checkInAdvance = checkBox;
        this.checkNegative = checkBox2;
        this.enableRegex = checkBox3;
        this.ignoreAllDay = checkBox4;
        this.ignoreCase = checkBox5;
        this.okButton = button4;
        this.selectCalendarSpinner = textView2;
        this.useAlarm = checkBox6;
        this.useAlarmDescription = textView3;
        this.variableConstraintDialogWildcardsInfo = textView4;
    }

    @NonNull
    public static CalendarConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.calendar_advance_day_picker;
            NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.calendar_advance_day_picker);
            if (numberPicker != null) {
                i4 = R.id.calendar_advance_hour_picker;
                NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.calendar_advance_hour_picker);
                if (numberPicker2 != null) {
                    i4 = R.id.calendar_advance_minute_picker;
                    NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.calendar_advance_minute_picker);
                    if (numberPicker3 != null) {
                        i4 = R.id.calendar_advance_time_layout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.calendar_advance_time_layout);
                        if (linearLayout2 != null) {
                            i4 = R.id.calendar_configure_availability_label;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.calendar_configure_availability_label);
                            if (textView != null) {
                                i4 = R.id.calendar_configure_availability_spinner;
                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.calendar_configure_availability_spinner);
                                if (spinner != null) {
                                    i4 = R.id.calendar_configure_detail;
                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.calendar_configure_detail);
                                    if (appCompatEditText != null) {
                                        i4 = R.id.calendar_configure_detail_magic_text;
                                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.calendar_configure_detail_magic_text);
                                        if (button != null) {
                                            i4 = R.id.calendar_configure_in_event;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.calendar_configure_in_event);
                                            if (radioButton != null) {
                                                i4 = R.id.calendar_configure_not_in_event;
                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.calendar_configure_not_in_event);
                                                if (radioButton2 != null) {
                                                    i4 = R.id.calendar_configure_radio_buttons;
                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.calendar_configure_radio_buttons);
                                                    if (radioGroup != null) {
                                                        i4 = R.id.calendar_configure_spinner;
                                                        Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.calendar_configure_spinner);
                                                        if (spinner2 != null) {
                                                            i4 = R.id.calendar_configure_title;
                                                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.calendar_configure_title);
                                                            if (appCompatEditText2 != null) {
                                                                i4 = R.id.calendar_configure_title_magic_text;
                                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.calendar_configure_title_magic_text);
                                                                if (button2 != null) {
                                                                    i4 = R.id.calendar_title_textinputlayout;
                                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.calendar_title_textinputlayout);
                                                                    if (textInputLayout != null) {
                                                                        i4 = R.id.cancelButton;
                                                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                                                                        if (button3 != null) {
                                                                            i4 = R.id.check_in_advance;
                                                                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.check_in_advance);
                                                                            if (checkBox != null) {
                                                                                i4 = R.id.check_negative;
                                                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.check_negative);
                                                                                if (checkBox2 != null) {
                                                                                    i4 = R.id.enable_regex;
                                                                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
                                                                                    if (checkBox3 != null) {
                                                                                        i4 = R.id.ignore_all_day;
                                                                                        CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_all_day);
                                                                                        if (checkBox4 != null) {
                                                                                            i4 = R.id.ignore_case;
                                                                                            CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
                                                                                            if (checkBox5 != null) {
                                                                                                i4 = R.id.okButton;
                                                                                                Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                                                if (button4 != null) {
                                                                                                    i4 = R.id.select_calendar_spinner;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.select_calendar_spinner);
                                                                                                    if (textView2 != null) {
                                                                                                        i4 = R.id.use_alarm;
                                                                                                        CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, R.id.use_alarm);
                                                                                                        if (checkBox6 != null) {
                                                                                                            i4 = R.id.use_alarm_description;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.use_alarm_description);
                                                                                                            if (textView3 != null) {
                                                                                                                i4 = R.id.variable_constraint_dialog_wildcards_info;
                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                                                                                                if (textView4 != null) {
                                                                                                                    return new CalendarConfigureBinding((ScrollView) view, linearLayout, numberPicker, numberPicker2, numberPicker3, linearLayout2, textView, spinner, appCompatEditText, button, radioButton, radioButton2, radioGroup, spinner2, appCompatEditText2, button2, textInputLayout, button3, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, button4, textView2, checkBox6, textView3, textView4);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CalendarConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CalendarConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.calendar_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f10992a;
    }
}
