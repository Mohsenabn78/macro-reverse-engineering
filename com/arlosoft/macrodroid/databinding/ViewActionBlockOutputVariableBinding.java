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
public final class ViewActionBlockOutputVariableBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11410a;
    @NonNull
    public final TextView variableName;
    @NonNull
    public final NDSpinner variableSpinner;

    private ViewActionBlockOutputVariableBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull NDSpinner nDSpinner) {
        this.f11410a = linearLayout;
        this.variableName = textView;
        this.variableSpinner = nDSpinner;
    }

    @NonNull
    public static ViewActionBlockOutputVariableBinding bind(@NonNull View view) {
        int i4 = R.id.variableName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variableName);
        if (textView != null) {
            i4 = R.id.variableSpinner;
            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variableSpinner);
            if (nDSpinner != null) {
                return new ViewActionBlockOutputVariableBinding((LinearLayout) view, textView, nDSpinner);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewActionBlockOutputVariableBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewActionBlockOutputVariableBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_action_block_output_variable, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11410a;
    }
}
