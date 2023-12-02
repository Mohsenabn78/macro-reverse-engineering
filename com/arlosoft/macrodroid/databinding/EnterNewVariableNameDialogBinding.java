package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EnterNewVariableNameDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11201a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText enterNewVariableNameDialogVariableName;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton radioButtonGlobal;
    @NonNull
    public final RadioButton radioButtonLocal;

    private EnterNewVariableNameDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2) {
        this.f11201a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.enterNewVariableNameDialogVariableName = appCompatEditText;
        this.okButton = button2;
        this.radioButtonGlobal = radioButton;
        this.radioButtonLocal = radioButton2;
    }

    @NonNull
    public static EnterNewVariableNameDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.enter_new_variable_name_dialog_variable_name;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.enter_new_variable_name_dialog_variable_name);
                if (appCompatEditText != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        i4 = R.id.radio_button_global;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_global);
                        if (radioButton != null) {
                            i4 = R.id.radio_button_local;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_local);
                            if (radioButton2 != null) {
                                return new EnterNewVariableNameDialogBinding((LinearLayout) view, linearLayout, button, appCompatEditText, button2, radioButton, radioButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EnterNewVariableNameDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EnterNewVariableNameDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.enter_new_variable_name_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11201a;
    }
}
