package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.ikovac.timepickerwithseconds.TimePicker;

/* loaded from: classes3.dex */
public final class TimerTriggerConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11391a;
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
    public final CheckBox forceAlarmCheckbox;
    @NonNull
    public final TextView forceAlarmDescription;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TimePicker timePicker;

    private TimerTriggerConfigureBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull CheckBox checkBox5, @NonNull CheckBox checkBox6, @NonNull CheckBox checkBox7, @NonNull CheckBox checkBox8, @NonNull TextView textView, @NonNull Button button2, @NonNull TimePicker timePicker) {
        this.f11391a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.checkBoxFriday = checkBox;
        this.checkBoxMonday = checkBox2;
        this.checkBoxSaturday = checkBox3;
        this.checkBoxSunday = checkBox4;
        this.checkBoxThursday = checkBox5;
        this.checkBoxTuesday = checkBox6;
        this.checkBoxWednesday = checkBox7;
        this.forceAlarmCheckbox = checkBox8;
        this.forceAlarmDescription = textView;
        this.okButton = button2;
        this.timePicker = timePicker;
    }

    @NonNull
    public static TimerTriggerConfigureBinding bind(@NonNull View view) {
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
                                            i4 = R.id.force_alarm_checkbox;
                                            CheckBox checkBox8 = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_alarm_checkbox);
                                            if (checkBox8 != null) {
                                                i4 = R.id.force_alarm_description;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.force_alarm_description);
                                                if (textView != null) {
                                                    i4 = R.id.okButton;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                    if (button2 != null) {
                                                        i4 = R.id.timePicker;
                                                        TimePicker timePicker = (TimePicker) ViewBindings.findChildViewById(view, R.id.timePicker);
                                                        if (timePicker != null) {
                                                            return new TimerTriggerConfigureBinding((LinearLayout) view, linearLayout, button, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, textView, button2, timePicker);
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
    public static TimerTriggerConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TimerTriggerConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.timer_trigger_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11391a;
    }
}
