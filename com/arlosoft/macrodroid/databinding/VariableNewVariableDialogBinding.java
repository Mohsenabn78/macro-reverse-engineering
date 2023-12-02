package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class VariableNewVariableDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11403a;
    @NonNull
    public final CheckBox createNowCheckBox;
    @NonNull
    public final Button createVarMagicText;
    @NonNull
    public final RadioGroup localGlobalLayout;
    @NonNull
    public final RadioButton radioButtonGlobal;
    @NonNull
    public final RadioButton radioButtonLocal;
    @NonNull
    public final LinearLayout typeContainer;
    @NonNull
    public final AppCompatEditText variableNewVariableDialogName;
    @NonNull
    public final Spinner variableNewVariableTypeSpinner;

    private VariableNewVariableDialogBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull Button button, @NonNull RadioGroup radioGroup, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull LinearLayout linearLayout2, @NonNull AppCompatEditText appCompatEditText, @NonNull Spinner spinner) {
        this.f11403a = linearLayout;
        this.createNowCheckBox = checkBox;
        this.createVarMagicText = button;
        this.localGlobalLayout = radioGroup;
        this.radioButtonGlobal = radioButton;
        this.radioButtonLocal = radioButton2;
        this.typeContainer = linearLayout2;
        this.variableNewVariableDialogName = appCompatEditText;
        this.variableNewVariableTypeSpinner = spinner;
    }

    @NonNull
    public static VariableNewVariableDialogBinding bind(@NonNull View view) {
        int i4 = R.id.create_now_check_box;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.create_now_check_box);
        if (checkBox != null) {
            i4 = R.id.create_var_magic_text;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.create_var_magic_text);
            if (button != null) {
                i4 = R.id.local_global_layout;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.local_global_layout);
                if (radioGroup != null) {
                    i4 = R.id.radio_button_global;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_global);
                    if (radioButton != null) {
                        i4 = R.id.radio_button_local;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_local);
                        if (radioButton2 != null) {
                            i4 = R.id.type_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.type_container);
                            if (linearLayout != null) {
                                i4 = R.id.variable_new_variable_dialog_name;
                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_new_variable_dialog_name);
                                if (appCompatEditText != null) {
                                    i4 = R.id.variable_new_variable_type_spinner;
                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.variable_new_variable_type_spinner);
                                    if (spinner != null) {
                                        return new VariableNewVariableDialogBinding((LinearLayout) view, checkBox, button, radioGroup, radioButton, radioButton2, linearLayout, appCompatEditText, spinner);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static VariableNewVariableDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableNewVariableDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_new_variable_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11403a;
    }
}
