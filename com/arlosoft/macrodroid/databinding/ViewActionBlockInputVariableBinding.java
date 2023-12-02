package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewActionBlockInputVariableBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11406a;
    @NonNull
    public final Button variableMagicTextButton;
    @NonNull
    public final TextView variableName;
    @NonNull
    public final AppCompatEditText variableValue;

    private ViewActionBlockInputVariableBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText) {
        this.f11406a = linearLayout;
        this.variableMagicTextButton = button;
        this.variableName = textView;
        this.variableValue = appCompatEditText;
    }

    @NonNull
    public static ViewActionBlockInputVariableBinding bind(@NonNull View view) {
        int i4 = R.id.variableMagicTextButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.variableMagicTextButton);
        if (button != null) {
            i4 = R.id.variableName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variableName);
            if (textView != null) {
                i4 = R.id.variableValue;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variableValue);
                if (appCompatEditText != null) {
                    return new ViewActionBlockInputVariableBinding((LinearLayout) view, button, textView, appCompatEditText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewActionBlockInputVariableBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewActionBlockInputVariableBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_action_block_input_variable, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11406a;
    }
}
