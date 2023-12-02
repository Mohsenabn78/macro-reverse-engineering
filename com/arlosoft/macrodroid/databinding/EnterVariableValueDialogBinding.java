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

/* loaded from: classes3.dex */
public final class EnterVariableValueDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11206a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText enterVariableDialogValue;
    @NonNull
    public final Button okButton;

    private EnterVariableValueDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2) {
        this.f11206a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.enterVariableDialogValue = appCompatEditText;
        this.okButton = button2;
    }

    @NonNull
    public static EnterVariableValueDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.enter_variable_dialog_value;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.enter_variable_dialog_value);
                if (appCompatEditText != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        return new EnterVariableValueDialogBinding((LinearLayout) view, linearLayout, button, appCompatEditText, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EnterVariableValueDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EnterVariableValueDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.enter_variable_value_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11206a;
    }
}
