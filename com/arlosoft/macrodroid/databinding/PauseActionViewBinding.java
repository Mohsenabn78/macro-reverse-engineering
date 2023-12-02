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
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class PauseActionViewBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11345a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox forceAlarmCheckbox;
    @NonNull
    public final TextView forceAlarmDescription;
    @NonNull
    public final RadioButton minutesRadioButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final NumberPicker pauseActionMinutePicker;
    @NonNull
    public final NumberPicker pauseActionMsPicker;
    @NonNull
    public final NumberPicker pauseActionSecondPicker;
    @NonNull
    public final NDSpinner pauseActionSpinner;
    @NonNull
    public final TableLayout pauseActionValueLayout;
    @NonNull
    public final RadioButton secondsRadioButton;
    @NonNull
    public final RadioGroup variableUnitsContainer;

    private PauseActionViewBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull Button button2, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull NumberPicker numberPicker3, @NonNull NDSpinner nDSpinner, @NonNull TableLayout tableLayout, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup) {
        this.f11345a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.forceAlarmCheckbox = checkBox;
        this.forceAlarmDescription = textView;
        this.minutesRadioButton = radioButton;
        this.okButton = button2;
        this.pauseActionMinutePicker = numberPicker;
        this.pauseActionMsPicker = numberPicker2;
        this.pauseActionSecondPicker = numberPicker3;
        this.pauseActionSpinner = nDSpinner;
        this.pauseActionValueLayout = tableLayout;
        this.secondsRadioButton = radioButton2;
        this.variableUnitsContainer = radioGroup;
    }

    @NonNull
    public static PauseActionViewBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.force_alarm_checkbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_alarm_checkbox);
                if (checkBox != null) {
                    i4 = R.id.force_alarm_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.force_alarm_description);
                    if (textView != null) {
                        i4 = R.id.minutesRadioButton;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.minutesRadioButton);
                        if (radioButton != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                i4 = R.id.pause_action_minute_picker;
                                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.pause_action_minute_picker);
                                if (numberPicker != null) {
                                    i4 = R.id.pause_action_ms_picker;
                                    NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.pause_action_ms_picker);
                                    if (numberPicker2 != null) {
                                        i4 = R.id.pause_action_second_picker;
                                        NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.pause_action_second_picker);
                                        if (numberPicker3 != null) {
                                            i4 = R.id.pause_action_spinner;
                                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.pause_action_spinner);
                                            if (nDSpinner != null) {
                                                i4 = R.id.pause_action_value_layout;
                                                TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.pause_action_value_layout);
                                                if (tableLayout != null) {
                                                    i4 = R.id.secondsRadioButton;
                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.secondsRadioButton);
                                                    if (radioButton2 != null) {
                                                        i4 = R.id.variableUnitsContainer;
                                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.variableUnitsContainer);
                                                        if (radioGroup != null) {
                                                            return new PauseActionViewBinding((ScrollView) view, linearLayout, button, checkBox, textView, radioButton, button2, numberPicker, numberPicker2, numberPicker3, nDSpinner, tableLayout, radioButton2, radioGroup);
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
    public static PauseActionViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PauseActionViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.pause_action_view, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11345a;
    }
}
