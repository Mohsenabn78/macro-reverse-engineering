package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class ViewActionBlockInputVariableDictionaryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11408a;
    @NonNull
    public final NDSpinner variableDictionarySpinner;
    @NonNull
    public final TextView variableName;

    private ViewActionBlockInputVariableDictionaryBinding(@NonNull LinearLayout linearLayout, @NonNull NDSpinner nDSpinner, @NonNull TextView textView) {
        this.f11408a = linearLayout;
        this.variableDictionarySpinner = nDSpinner;
        this.variableName = textView;
    }

    @NonNull
    public static ViewActionBlockInputVariableDictionaryBinding bind(@NonNull View view) {
        int i4 = R.id.variableDictionarySpinner;
        NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variableDictionarySpinner);
        if (nDSpinner != null) {
            i4 = R.id.variableName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variableName);
            if (textView != null) {
                return new ViewActionBlockInputVariableDictionaryBinding((LinearLayout) view, nDSpinner, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewActionBlockInputVariableDictionaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewActionBlockInputVariableDictionaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_action_block_input_variable_dictionary, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11408a;
    }
}
