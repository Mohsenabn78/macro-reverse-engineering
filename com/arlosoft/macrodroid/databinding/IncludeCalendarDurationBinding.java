package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class IncludeCalendarDurationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11254a;
    @NonNull
    public final CheckBox allDayCheckbox;
    @NonNull
    public final LinearLayout calendarFixedTimeLayout;
    @NonNull
    public final LinearLayout calendarRelativeTimeLayout;
    @NonNull
    public final NumberPicker daysPicker;
    @NonNull
    public final LinearLayout durationBoxLayout;
    @NonNull
    public final LinearLayout durationLayout;
    @NonNull
    public final Button durationMagicButton;
    @NonNull
    public final AppCompatEditText durationText;
    @NonNull
    public final TextInputLayout durationTextinputlayout;
    @NonNull
    public final NumberPicker fixedDaysPicker;
    @NonNull
    public final NumberPicker fixedMonthsPicker;
    @NonNull
    public final RadioButton fixedRadioButton;
    @NonNull
    public final TimePicker fixedTimePicker;
    @NonNull
    public final NumberPicker hoursPicker;
    @NonNull
    public final RadioButton minusRadioButton;
    @NonNull
    public final NumberPicker minutesPicker;
    @NonNull
    public final RadioButton plusRadioButton;
    @NonNull
    public final RadioButton relativeRadioButton;
    @NonNull
    public final NDSpinner relativeTimeOption;
    @NonNull
    public final ViewFlipper relativeTimeViewFlipper;
    @NonNull
    public final TextView timeOfDayLabel;
    @NonNull
    public final Spinner timeUnitSpinner;

    private IncludeCalendarDurationBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull NumberPicker numberPicker, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull NumberPicker numberPicker2, @NonNull NumberPicker numberPicker3, @NonNull RadioButton radioButton, @NonNull TimePicker timePicker, @NonNull NumberPicker numberPicker4, @NonNull RadioButton radioButton2, @NonNull NumberPicker numberPicker5, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull NDSpinner nDSpinner, @NonNull ViewFlipper viewFlipper, @NonNull TextView textView, @NonNull Spinner spinner) {
        this.f11254a = linearLayout;
        this.allDayCheckbox = checkBox;
        this.calendarFixedTimeLayout = linearLayout2;
        this.calendarRelativeTimeLayout = linearLayout3;
        this.daysPicker = numberPicker;
        this.durationBoxLayout = linearLayout4;
        this.durationLayout = linearLayout5;
        this.durationMagicButton = button;
        this.durationText = appCompatEditText;
        this.durationTextinputlayout = textInputLayout;
        this.fixedDaysPicker = numberPicker2;
        this.fixedMonthsPicker = numberPicker3;
        this.fixedRadioButton = radioButton;
        this.fixedTimePicker = timePicker;
        this.hoursPicker = numberPicker4;
        this.minusRadioButton = radioButton2;
        this.minutesPicker = numberPicker5;
        this.plusRadioButton = radioButton3;
        this.relativeRadioButton = radioButton4;
        this.relativeTimeOption = nDSpinner;
        this.relativeTimeViewFlipper = viewFlipper;
        this.timeOfDayLabel = textView;
        this.timeUnitSpinner = spinner;
    }

    @NonNull
    public static IncludeCalendarDurationBinding bind(@NonNull View view) {
        int i4 = R.id.all_day_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.all_day_checkbox);
        if (checkBox != null) {
            i4 = R.id.calendar_fixed_time_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.calendar_fixed_time_layout);
            if (linearLayout != null) {
                i4 = R.id.calendar_relative_time_layout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.calendar_relative_time_layout);
                if (linearLayout2 != null) {
                    i4 = R.id.days_picker;
                    NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.days_picker);
                    if (numberPicker != null) {
                        i4 = R.id.duration_box_layout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.duration_box_layout);
                        if (linearLayout3 != null) {
                            LinearLayout linearLayout4 = (LinearLayout) view;
                            i4 = R.id.duration_magic_button;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.duration_magic_button);
                            if (button != null) {
                                i4 = R.id.duration_text;
                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.duration_text);
                                if (appCompatEditText != null) {
                                    i4 = R.id.duration_textinputlayout;
                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.duration_textinputlayout);
                                    if (textInputLayout != null) {
                                        i4 = R.id.fixed_days_picker;
                                        NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.fixed_days_picker);
                                        if (numberPicker2 != null) {
                                            i4 = R.id.fixed_months_picker;
                                            NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.fixed_months_picker);
                                            if (numberPicker3 != null) {
                                                i4 = R.id.fixed_radio_button;
                                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.fixed_radio_button);
                                                if (radioButton != null) {
                                                    i4 = R.id.fixed_time_picker;
                                                    TimePicker timePicker = (TimePicker) ViewBindings.findChildViewById(view, R.id.fixed_time_picker);
                                                    if (timePicker != null) {
                                                        i4 = R.id.hours_picker;
                                                        NumberPicker numberPicker4 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.hours_picker);
                                                        if (numberPicker4 != null) {
                                                            i4 = R.id.minusRadioButton;
                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.minusRadioButton);
                                                            if (radioButton2 != null) {
                                                                i4 = R.id.minutes_picker;
                                                                NumberPicker numberPicker5 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.minutes_picker);
                                                                if (numberPicker5 != null) {
                                                                    i4 = R.id.plusRadioButton;
                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.plusRadioButton);
                                                                    if (radioButton3 != null) {
                                                                        i4 = R.id.relative_radio_button;
                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.relative_radio_button);
                                                                        if (radioButton4 != null) {
                                                                            i4 = R.id.relativeTimeOption;
                                                                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.relativeTimeOption);
                                                                            if (nDSpinner != null) {
                                                                                i4 = R.id.relativeTimeViewFlipper;
                                                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.relativeTimeViewFlipper);
                                                                                if (viewFlipper != null) {
                                                                                    i4 = R.id.time_of_day_label;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.time_of_day_label);
                                                                                    if (textView != null) {
                                                                                        i4 = R.id.timeUnitSpinner;
                                                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.timeUnitSpinner);
                                                                                        if (spinner != null) {
                                                                                            return new IncludeCalendarDurationBinding(linearLayout4, checkBox, linearLayout, linearLayout2, numberPicker, linearLayout3, linearLayout4, button, appCompatEditText, textInputLayout, numberPicker2, numberPicker3, radioButton, timePicker, numberPicker4, radioButton2, numberPicker5, radioButton3, radioButton4, nDSpinner, viewFlipper, textView, spinner);
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
    public static IncludeCalendarDurationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeCalendarDurationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_calendar_duration, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11254a;
    }
}
