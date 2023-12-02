package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public final class DialogStopwatchConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11133a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioGroup constraintOptions;
    @NonNull
    public final CheckBox forceAlarmCheckbox;
    @NonNull
    public final TextView forceAlarmDescription;
    @NonNull
    public final RadioButton greaterThan;
    @NonNull
    public final NumberPicker hourPicker;
    @NonNull
    public final RadioButton lessThan;
    @NonNull
    public final NumberPicker minutePicker;
    @NonNull
    public final Button okButton;
    @NonNull
    public final NumberPicker secondPicker;
    @NonNull
    public final NDSpinner spinner;
    @NonNull
    public final TableLayout timeLayout;

    private DialogStopwatchConstraintBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioGroup radioGroup, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull NumberPicker numberPicker, @NonNull RadioButton radioButton2, @NonNull NumberPicker numberPicker2, @NonNull Button button2, @NonNull NumberPicker numberPicker3, @NonNull NDSpinner nDSpinner, @NonNull TableLayout tableLayout) {
        this.f11133a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.constraintOptions = radioGroup;
        this.forceAlarmCheckbox = checkBox;
        this.forceAlarmDescription = textView;
        this.greaterThan = radioButton;
        this.hourPicker = numberPicker;
        this.lessThan = radioButton2;
        this.minutePicker = numberPicker2;
        this.okButton = button2;
        this.secondPicker = numberPicker3;
        this.spinner = nDSpinner;
        this.timeLayout = tableLayout;
    }

    @NonNull
    public static DialogStopwatchConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.constraint_options;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.constraint_options);
                if (radioGroup != null) {
                    i4 = R.id.force_alarm_checkbox;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_alarm_checkbox);
                    if (checkBox != null) {
                        i4 = R.id.force_alarm_description;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.force_alarm_description);
                        if (textView != null) {
                            i4 = R.id.greater_than;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.greater_than);
                            if (radioButton != null) {
                                i4 = R.id.hour_picker;
                                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.hour_picker);
                                if (numberPicker != null) {
                                    i4 = R.id.less_than;
                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.less_than);
                                    if (radioButton2 != null) {
                                        i4 = R.id.minute_picker;
                                        NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.minute_picker);
                                        if (numberPicker2 != null) {
                                            i4 = R.id.okButton;
                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                            if (button2 != null) {
                                                i4 = R.id.second_picker;
                                                NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.second_picker);
                                                if (numberPicker3 != null) {
                                                    i4 = R.id.spinner;
                                                    NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.spinner);
                                                    if (nDSpinner != null) {
                                                        i4 = R.id.time_layout;
                                                        TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.time_layout);
                                                        if (tableLayout != null) {
                                                            return new DialogStopwatchConstraintBinding((LinearLayout) view, linearLayout, button, radioGroup, checkBox, textView, radioButton, numberPicker, radioButton2, numberPicker2, button2, numberPicker3, nDSpinner, tableLayout);
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
    public static DialogStopwatchConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogStopwatchConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_stopwatch_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11133a;
    }
}
