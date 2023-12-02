package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class VariableUserPromptBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11404a;
    @NonNull
    public final TextView variableUserPromptMessage;
    @NonNull
    public final RadioButton variableUserPromptRadioFalse;
    @NonNull
    public final RadioGroup variableUserPromptRadioGroup;
    @NonNull
    public final RadioButton variableUserPromptRadioTrue;
    @NonNull
    public final EditText variableUserPromptVariableValue;

    private VariableUserPromptBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull RadioGroup radioGroup, @NonNull RadioButton radioButton2, @NonNull EditText editText) {
        this.f11404a = linearLayout;
        this.variableUserPromptMessage = textView;
        this.variableUserPromptRadioFalse = radioButton;
        this.variableUserPromptRadioGroup = radioGroup;
        this.variableUserPromptRadioTrue = radioButton2;
        this.variableUserPromptVariableValue = editText;
    }

    @NonNull
    public static VariableUserPromptBinding bind(@NonNull View view) {
        int i4 = R.id.variable_user_prompt_message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variable_user_prompt_message);
        if (textView != null) {
            i4 = R.id.variable_user_prompt_radio_false;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_user_prompt_radio_false);
            if (radioButton != null) {
                i4 = R.id.variable_user_prompt_radio_group;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.variable_user_prompt_radio_group);
                if (radioGroup != null) {
                    i4 = R.id.variable_user_prompt_radio_true;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_user_prompt_radio_true);
                    if (radioButton2 != null) {
                        i4 = R.id.variable_user_prompt_variable_value;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.variable_user_prompt_variable_value);
                        if (editText != null) {
                            return new VariableUserPromptBinding((LinearLayout) view, textView, radioButton, radioGroup, radioButton2, editText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static VariableUserPromptBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableUserPromptBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_user_prompt, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11404a;
    }
}
