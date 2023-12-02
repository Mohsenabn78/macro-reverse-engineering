package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class IncludeTextManipulationParamBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11268a;
    @NonNull
    public final Button paramButton;
    @NonNull
    public final AppCompatEditText paramEditText;
    @NonNull
    public final TextInputLayout textInputLayout;

    private IncludeTextManipulationParamBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout) {
        this.f11268a = linearLayout;
        this.paramButton = button;
        this.paramEditText = appCompatEditText;
        this.textInputLayout = textInputLayout;
    }

    @NonNull
    public static IncludeTextManipulationParamBinding bind(@NonNull View view) {
        int i4 = R.id.param_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.param_button);
        if (button != null) {
            i4 = R.id.param_edit_text;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.param_edit_text);
            if (appCompatEditText != null) {
                i4 = R.id.text_input_layout;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.text_input_layout);
                if (textInputLayout != null) {
                    return new IncludeTextManipulationParamBinding((LinearLayout) view, button, appCompatEditText, textInputLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeTextManipulationParamBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeTextManipulationParamBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_text_manipulation_param, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11268a;
    }
}
