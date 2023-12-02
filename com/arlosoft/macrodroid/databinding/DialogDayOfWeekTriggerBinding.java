package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogDayOfWeekTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11044a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Spinner dialogDayOfWeekDialogSpinnerDay;
    @NonNull
    public final TimePicker dialogDayOfWeekDialogTimePicker;
    @NonNull
    public final CheckBox forceAlarmCheckbox;
    @NonNull
    public final TextView forceAlarmDescription;
    @NonNull
    public final Spinner monthOfYearSpinner;
    @NonNull
    public final Button okButton;

    private DialogDayOfWeekTriggerBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Spinner spinner, @NonNull TimePicker timePicker, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull Spinner spinner2, @NonNull Button button2) {
        this.f11044a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.dialogDayOfWeekDialogSpinnerDay = spinner;
        this.dialogDayOfWeekDialogTimePicker = timePicker;
        this.forceAlarmCheckbox = checkBox;
        this.forceAlarmDescription = textView;
        this.monthOfYearSpinner = spinner2;
        this.okButton = button2;
    }

    @NonNull
    public static DialogDayOfWeekTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.dialog_day_of_week_dialog_spinner_day;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.dialog_day_of_week_dialog_spinner_day);
                if (spinner != null) {
                    i4 = R.id.dialog_day_of_week_dialog_time_picker;
                    TimePicker timePicker = (TimePicker) ViewBindings.findChildViewById(view, R.id.dialog_day_of_week_dialog_time_picker);
                    if (timePicker != null) {
                        i4 = R.id.force_alarm_checkbox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_alarm_checkbox);
                        if (checkBox != null) {
                            i4 = R.id.force_alarm_description;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.force_alarm_description);
                            if (textView != null) {
                                i4 = R.id.month_of_year_spinner;
                                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.month_of_year_spinner);
                                if (spinner2 != null) {
                                    i4 = R.id.okButton;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                    if (button2 != null) {
                                        return new DialogDayOfWeekTriggerBinding((LinearLayout) view, linearLayout, button, spinner, timePicker, checkBox, textView, spinner2, button2);
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
    public static DialogDayOfWeekTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDayOfWeekTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_day_of_week_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11044a;
    }
}
