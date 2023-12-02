package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class RegularIntervalSettingBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11346a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox forceAlarmCheckbox;
    @NonNull
    public final TextView forceAlarmDescription;
    @NonNull
    public final Button okButton;
    @NonNull
    public final NumberPicker regularIntervalSettingHourPicker;
    @NonNull
    public final NumberPicker regularIntervalSettingMinutePicker;
    @NonNull
    public final View regularIntervalSettingPadding;
    @NonNull
    public final CheckBox regularIntervalSettingReferenceStartTimeCheckbox;
    @NonNull
    public final NumberPicker regularIntervalSettingSecondPicker;
    @NonNull
    public final TimePicker regularIntervalSettingTimePicker;
    @NonNull
    public final TableLayout tableLayout1;
    @NonNull
    public final TableRow tableRow1;

    private RegularIntervalSettingBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull Button button2, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull View view, @NonNull CheckBox checkBox2, @NonNull NumberPicker numberPicker3, @NonNull TimePicker timePicker, @NonNull TableLayout tableLayout, @NonNull TableRow tableRow) {
        this.f11346a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.forceAlarmCheckbox = checkBox;
        this.forceAlarmDescription = textView;
        this.okButton = button2;
        this.regularIntervalSettingHourPicker = numberPicker;
        this.regularIntervalSettingMinutePicker = numberPicker2;
        this.regularIntervalSettingPadding = view;
        this.regularIntervalSettingReferenceStartTimeCheckbox = checkBox2;
        this.regularIntervalSettingSecondPicker = numberPicker3;
        this.regularIntervalSettingTimePicker = timePicker;
        this.tableLayout1 = tableLayout;
        this.tableRow1 = tableRow;
    }

    @NonNull
    public static RegularIntervalSettingBinding bind(@NonNull View view) {
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
                        i4 = R.id.okButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button2 != null) {
                            i4 = R.id.regular_interval_setting_hour_picker;
                            NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.regular_interval_setting_hour_picker);
                            if (numberPicker != null) {
                                i4 = R.id.regular_interval_setting_minute_picker;
                                NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.regular_interval_setting_minute_picker);
                                if (numberPicker2 != null) {
                                    i4 = R.id.regular_interval_setting_padding;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.regular_interval_setting_padding);
                                    if (findChildViewById != null) {
                                        i4 = R.id.regular_interval_setting_reference_start_time_checkbox;
                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.regular_interval_setting_reference_start_time_checkbox);
                                        if (checkBox2 != null) {
                                            i4 = R.id.regular_interval_setting_second_picker;
                                            NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.regular_interval_setting_second_picker);
                                            if (numberPicker3 != null) {
                                                i4 = R.id.regular_interval_setting_time_picker;
                                                TimePicker timePicker = (TimePicker) ViewBindings.findChildViewById(view, R.id.regular_interval_setting_time_picker);
                                                if (timePicker != null) {
                                                    i4 = R.id.tableLayout1;
                                                    TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.tableLayout1);
                                                    if (tableLayout != null) {
                                                        i4 = R.id.tableRow1;
                                                        TableRow tableRow = (TableRow) ViewBindings.findChildViewById(view, R.id.tableRow1);
                                                        if (tableRow != null) {
                                                            return new RegularIntervalSettingBinding((LinearLayout) view, linearLayout, button, checkBox, textView, button2, numberPicker, numberPicker2, findChildViewById, checkBox2, numberPicker3, timePicker, tableLayout, tableRow);
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
    public static RegularIntervalSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static RegularIntervalSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.regular_interval_setting, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11346a;
    }
}
