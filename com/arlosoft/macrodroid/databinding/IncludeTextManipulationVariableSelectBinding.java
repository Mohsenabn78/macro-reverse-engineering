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
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class IncludeTextManipulationVariableSelectBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11269a;
    @NonNull
    public final Button addVariableButton;
    @NonNull
    public final NDSpinner variableSpinner;

    private IncludeTextManipulationVariableSelectBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull NDSpinner nDSpinner) {
        this.f11269a = linearLayout;
        this.addVariableButton = button;
        this.variableSpinner = nDSpinner;
    }

    @NonNull
    public static IncludeTextManipulationVariableSelectBinding bind(@NonNull View view) {
        int i4 = R.id.add_variable_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_variable_button);
        if (button != null) {
            i4 = R.id.variable_spinner;
            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variable_spinner);
            if (nDSpinner != null) {
                return new IncludeTextManipulationVariableSelectBinding((LinearLayout) view, button, nDSpinner);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeTextManipulationVariableSelectBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeTextManipulationVariableSelectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_text_manipulation_variable_select, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11269a;
    }
}
