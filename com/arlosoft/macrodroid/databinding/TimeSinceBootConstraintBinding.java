package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class TimeSinceBootConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11390a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton timeSinceBootConstraintGreaterThan;
    @NonNull
    public final NumberPicker timeSinceBootConstraintHourPicker;
    @NonNull
    public final RadioButton timeSinceBootConstraintLessThan;
    @NonNull
    public final NumberPicker timeSinceBootConstraintMinutePicker;
    @NonNull
    public final NumberPicker timeSinceBootConstraintSecondPicker;

    private TimeSinceBootConstraintBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull NumberPicker numberPicker, @NonNull RadioButton radioButton2, @NonNull NumberPicker numberPicker2, @NonNull NumberPicker numberPicker3) {
        this.f11390a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.timeSinceBootConstraintGreaterThan = radioButton;
        this.timeSinceBootConstraintHourPicker = numberPicker;
        this.timeSinceBootConstraintLessThan = radioButton2;
        this.timeSinceBootConstraintMinutePicker = numberPicker2;
        this.timeSinceBootConstraintSecondPicker = numberPicker3;
    }

    @NonNull
    public static TimeSinceBootConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.okButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button2 != null) {
                    i4 = R.id.time_since_boot_constraint_greater_than;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.time_since_boot_constraint_greater_than);
                    if (radioButton != null) {
                        i4 = R.id.time_since_boot_constraint_hour_picker;
                        NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.time_since_boot_constraint_hour_picker);
                        if (numberPicker != null) {
                            i4 = R.id.time_since_boot_constraint_less_than;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.time_since_boot_constraint_less_than);
                            if (radioButton2 != null) {
                                i4 = R.id.time_since_boot_constraint_minute_picker;
                                NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.time_since_boot_constraint_minute_picker);
                                if (numberPicker2 != null) {
                                    i4 = R.id.time_since_boot_constraint_second_picker;
                                    NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.time_since_boot_constraint_second_picker);
                                    if (numberPicker3 != null) {
                                        return new TimeSinceBootConstraintBinding((LinearLayout) view, linearLayout, button, button2, radioButton, numberPicker, radioButton2, numberPicker2, numberPicker3);
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
    public static TimeSinceBootConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TimeSinceBootConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.time_since_boot_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11390a;
    }
}
