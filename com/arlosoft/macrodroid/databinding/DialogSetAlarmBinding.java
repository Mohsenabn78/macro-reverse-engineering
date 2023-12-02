package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
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
public final class DialogSetAlarmBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11123a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox checkBoxFriday;
    @NonNull
    public final CheckBox checkBoxMonday;
    @NonNull
    public final CheckBox checkBoxSaturday;
    @NonNull
    public final CheckBox checkBoxSunday;
    @NonNull
    public final CheckBox checkBoxThursday;
    @NonNull
    public final CheckBox checkBoxTuesday;
    @NonNull
    public final CheckBox checkBoxWednesday;
    @NonNull
    public final RadioButton dialogSetAlarmFixed;
    @NonNull
    public final NumberPicker dialogSetAlarmHourPicker;
    @NonNull
    public final AppCompatEditText dialogSetAlarmLabel;
    @NonNull
    public final NumberPicker dialogSetAlarmMinutePicker;
    @NonNull
    public final RadioButton dialogSetAlarmOneOff;
    @NonNull
    public final TimePicker dialogSetAlarmOneOffTimePicker;
    @NonNull
    public final RadioButton dialogSetAlarmRelative;
    @NonNull
    public final TableLayout dialogSetAlarmRelativeValueLayout;
    @NonNull
    public final RadioButton dialogSetAlarmRepeated;
    @NonNull
    public final TimePicker dialogSetAlarmTimePicker;
    @NonNull
    public final NDSpinner dialogSetAlarmVariableSpinner;
    @NonNull
    public final Spinner dialogSetAlarmVariableSpinnerDay;
    @NonNull
    public final ViewFlipper dialogSetAlarmViewFlipper;
    @NonNull
    public final ViewFlipper dialogSetAlarmViewFlipperOneOff;
    @NonNull
    public final TextInputLayout inputLayoutPassword;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final ScrollView scrollView1;

    private DialogSetAlarmBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull CheckBox checkBox5, @NonNull CheckBox checkBox6, @NonNull CheckBox checkBox7, @NonNull RadioButton radioButton, @NonNull NumberPicker numberPicker, @NonNull AppCompatEditText appCompatEditText, @NonNull NumberPicker numberPicker2, @NonNull RadioButton radioButton2, @NonNull TimePicker timePicker, @NonNull RadioButton radioButton3, @NonNull TableLayout tableLayout, @NonNull RadioButton radioButton4, @NonNull TimePicker timePicker2, @NonNull NDSpinner nDSpinner, @NonNull Spinner spinner, @NonNull ViewFlipper viewFlipper, @NonNull ViewFlipper viewFlipper2, @NonNull TextInputLayout textInputLayout, @NonNull Button button2, @NonNull Button button3, @NonNull ScrollView scrollView) {
        this.f11123a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.checkBoxFriday = checkBox;
        this.checkBoxMonday = checkBox2;
        this.checkBoxSaturday = checkBox3;
        this.checkBoxSunday = checkBox4;
        this.checkBoxThursday = checkBox5;
        this.checkBoxTuesday = checkBox6;
        this.checkBoxWednesday = checkBox7;
        this.dialogSetAlarmFixed = radioButton;
        this.dialogSetAlarmHourPicker = numberPicker;
        this.dialogSetAlarmLabel = appCompatEditText;
        this.dialogSetAlarmMinutePicker = numberPicker2;
        this.dialogSetAlarmOneOff = radioButton2;
        this.dialogSetAlarmOneOffTimePicker = timePicker;
        this.dialogSetAlarmRelative = radioButton3;
        this.dialogSetAlarmRelativeValueLayout = tableLayout;
        this.dialogSetAlarmRepeated = radioButton4;
        this.dialogSetAlarmTimePicker = timePicker2;
        this.dialogSetAlarmVariableSpinner = nDSpinner;
        this.dialogSetAlarmVariableSpinnerDay = spinner;
        this.dialogSetAlarmViewFlipper = viewFlipper;
        this.dialogSetAlarmViewFlipperOneOff = viewFlipper2;
        this.inputLayoutPassword = textInputLayout;
        this.magicTextButton = button2;
        this.okButton = button3;
        this.scrollView1 = scrollView;
    }

    @NonNull
    public static DialogSetAlarmBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.checkBoxFriday;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxFriday);
                if (checkBox != null) {
                    i4 = R.id.checkBoxMonday;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxMonday);
                    if (checkBox2 != null) {
                        i4 = R.id.checkBoxSaturday;
                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxSaturday);
                        if (checkBox3 != null) {
                            i4 = R.id.checkBoxSunday;
                            CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxSunday);
                            if (checkBox4 != null) {
                                i4 = R.id.checkBoxThursday;
                                CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxThursday);
                                if (checkBox5 != null) {
                                    i4 = R.id.checkBoxTuesday;
                                    CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxTuesday);
                                    if (checkBox6 != null) {
                                        i4 = R.id.checkBoxWednesday;
                                        CheckBox checkBox7 = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkBoxWednesday);
                                        if (checkBox7 != null) {
                                            i4 = R.id.dialog_set_alarm_fixed;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_fixed);
                                            if (radioButton != null) {
                                                i4 = R.id.dialog_set_alarm_hour_picker;
                                                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_hour_picker);
                                                if (numberPicker != null) {
                                                    i4 = R.id.dialog_set_alarm_label;
                                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_label);
                                                    if (appCompatEditText != null) {
                                                        i4 = R.id.dialog_set_alarm_minute_picker;
                                                        NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_minute_picker);
                                                        if (numberPicker2 != null) {
                                                            i4 = R.id.dialog_set_alarm_one_off;
                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_one_off);
                                                            if (radioButton2 != null) {
                                                                i4 = R.id.dialog_set_alarm_one_off_timePicker;
                                                                TimePicker timePicker = (TimePicker) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_one_off_timePicker);
                                                                if (timePicker != null) {
                                                                    i4 = R.id.dialog_set_alarm_relative;
                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_relative);
                                                                    if (radioButton3 != null) {
                                                                        i4 = R.id.dialog_set_alarm_relative_value_layout;
                                                                        TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_relative_value_layout);
                                                                        if (tableLayout != null) {
                                                                            i4 = R.id.dialog_set_alarm_repeated;
                                                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_repeated);
                                                                            if (radioButton4 != null) {
                                                                                i4 = R.id.dialog_set_alarm_timePicker;
                                                                                TimePicker timePicker2 = (TimePicker) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_timePicker);
                                                                                if (timePicker2 != null) {
                                                                                    i4 = R.id.dialog_set_alarm_variable_spinner;
                                                                                    NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_variable_spinner);
                                                                                    if (nDSpinner != null) {
                                                                                        i4 = R.id.dialog_set_alarm_variable_spinner_day;
                                                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_variable_spinner_day);
                                                                                        if (spinner != null) {
                                                                                            i4 = R.id.dialog_set_alarm_view_flipper;
                                                                                            ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_view_flipper);
                                                                                            if (viewFlipper != null) {
                                                                                                i4 = R.id.dialog_set_alarm_view_flipper_one_off;
                                                                                                ViewFlipper viewFlipper2 = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.dialog_set_alarm_view_flipper_one_off);
                                                                                                if (viewFlipper2 != null) {
                                                                                                    i4 = R.id.input_layout_password;
                                                                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.input_layout_password);
                                                                                                    if (textInputLayout != null) {
                                                                                                        i4 = R.id.magic_text_button;
                                                                                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                                                                                                        if (button2 != null) {
                                                                                                            i4 = R.id.okButton;
                                                                                                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                                                            if (button3 != null) {
                                                                                                                i4 = R.id.scrollView1;
                                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scrollView1);
                                                                                                                if (scrollView != null) {
                                                                                                                    return new DialogSetAlarmBinding((LinearLayout) view, linearLayout, button, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, radioButton, numberPicker, appCompatEditText, numberPicker2, radioButton2, timePicker, radioButton3, tableLayout, radioButton4, timePicker2, nDSpinner, spinner, viewFlipper, viewFlipper2, textInputLayout, button2, button3, scrollView);
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
    public static DialogSetAlarmBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSetAlarmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_set_alarm, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11123a;
    }
}
