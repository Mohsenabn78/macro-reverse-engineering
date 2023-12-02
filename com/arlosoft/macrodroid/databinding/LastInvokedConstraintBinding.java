package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;

/* loaded from: classes3.dex */
public final class LastInvokedConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11285a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final NumberPicker lastInvokedConstraintHourPicker;
    @NonNull
    public final NumberPicker lastInvokedConstraintMinutePicker;
    @NonNull
    public final NumberPicker lastInvokedConstraintSecondPicker;
    @NonNull
    public final Button okButton;

    private LastInvokedConstraintBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull NumberPicker numberPicker, @NonNull NumberPicker numberPicker2, @NonNull NumberPicker numberPicker3, @NonNull Button button2) {
        this.f11285a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.lastInvokedConstraintHourPicker = numberPicker;
        this.lastInvokedConstraintMinutePicker = numberPicker2;
        this.lastInvokedConstraintSecondPicker = numberPicker3;
        this.okButton = button2;
    }

    @NonNull
    public static LastInvokedConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.last_invoked_constraint_hour_picker;
                NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, R.id.last_invoked_constraint_hour_picker);
                if (numberPicker != null) {
                    i4 = R.id.last_invoked_constraint_minute_picker;
                    NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.last_invoked_constraint_minute_picker);
                    if (numberPicker2 != null) {
                        i4 = R.id.last_invoked_constraint_second_picker;
                        NumberPicker numberPicker3 = (NumberPicker) ViewBindings.findChildViewById(view, R.id.last_invoked_constraint_second_picker);
                        if (numberPicker3 != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                return new LastInvokedConstraintBinding((LinearLayout) view, linearLayout, button, numberPicker, numberPicker2, numberPicker3, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static LastInvokedConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LastInvokedConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.last_invoked_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11285a;
    }
}
