package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewActionBlockInputVariableBooleanBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11407a;
    @NonNull
    public final Spinner variableBooleanSpinner;
    @NonNull
    public final TextView variableName;

    private ViewActionBlockInputVariableBooleanBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull TextView textView) {
        this.f11407a = linearLayout;
        this.variableBooleanSpinner = spinner;
        this.variableName = textView;
    }

    @NonNull
    public static ViewActionBlockInputVariableBooleanBinding bind(@NonNull View view) {
        int i4 = R.id.variableBooleanSpinner;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.variableBooleanSpinner);
        if (spinner != null) {
            i4 = R.id.variableName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variableName);
            if (textView != null) {
                return new ViewActionBlockInputVariableBooleanBinding((LinearLayout) view, spinner, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewActionBlockInputVariableBooleanBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewActionBlockInputVariableBooleanBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_action_block_input_variable_boolean, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11407a;
    }
}
