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
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogClickResultBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11032a;
    @NonNull
    public final Button addBooleanVariableButton;
    @NonNull
    public final RadioButton blockUntilCompleteRadioButton;
    @NonNull
    public final NDSpinner booleanVariableSpinner;
    @NonNull
    public final RadioButton dontWaitRadioButton;
    @NonNull
    public final LinearLayout saveToVariableContainer;

    private DialogClickResultBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull NDSpinner nDSpinner, @NonNull RadioButton radioButton2, @NonNull LinearLayout linearLayout2) {
        this.f11032a = linearLayout;
        this.addBooleanVariableButton = button;
        this.blockUntilCompleteRadioButton = radioButton;
        this.booleanVariableSpinner = nDSpinner;
        this.dontWaitRadioButton = radioButton2;
        this.saveToVariableContainer = linearLayout2;
    }

    @NonNull
    public static DialogClickResultBinding bind(@NonNull View view) {
        int i4 = R.id.add_boolean_variable_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_boolean_variable_button);
        if (button != null) {
            i4 = R.id.block_until_complete_radio_button;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.block_until_complete_radio_button);
            if (radioButton != null) {
                i4 = R.id.boolean_variable_spinner;
                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.boolean_variable_spinner);
                if (nDSpinner != null) {
                    i4 = R.id.dont_wait_radio_button;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dont_wait_radio_button);
                    if (radioButton2 != null) {
                        i4 = R.id.save_to_variable_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.save_to_variable_container);
                        if (linearLayout != null) {
                            return new DialogClickResultBinding((LinearLayout) view, button, radioButton, nDSpinner, radioButton2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogClickResultBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogClickResultBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_click_result, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11032a;
    }
}
