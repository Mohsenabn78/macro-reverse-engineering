package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class VariableNewValueDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11402a;
    @NonNull
    public final EditText arrayIndex;
    @NonNull
    public final TextInputLayout arrayIndexEntryLayout;
    @NonNull
    public final NDSpinner booleanVariableSpinner;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final LinearLayout expressionFunctionsLayout;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton radioButtonDummyPlaceholder;
    @NonNull
    public final AppCompatEditText variableNewValueDialogExpressionEdittext;
    @NonNull
    public final LinearLayout variableNewValueDialogExpressionLayout;
    @NonNull
    public final RelativeLayout variableNewValueDialogIntOptionRadioButtonContainer;
    @NonNull
    public final RadioGroup variableNewValueDialogIntOptionRadiogroup;
    @NonNull
    public final AppCompatEditText variableNewValueDialogIntegerEdittext;
    @NonNull
    public final AppCompatEditText variableNewValueDialogIntegerRandomMax;
    @NonNull
    public final AppCompatEditText variableNewValueDialogIntegerRandomMin;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonBooleanOtherBooleanVariable;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonBooleanPrompt;
    @NonNull
    public final RadioGroup variableNewValueDialogRadioButtonContainer;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonDecrement;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonExpression;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonFalse;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonIncrement;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonInvert;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonPrompt;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonRandom;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonSetValue;
    @NonNull
    public final RadioButton variableNewValueDialogRadioButtonTrue;
    @NonNull
    public final LinearLayout variableNewValueDialogRandomValueLayout;
    @NonNull
    public final AppCompatEditText variableNewValueDialogStringEdittext;
    @NonNull
    public final LinearLayout variableNewValueDialogStringOptionContainer;
    @NonNull
    public final RadioButton variableNewValueDialogStringRadioButtonUserPrompt;
    @NonNull
    public final RadioButton variableNewValueDialogStringRadioButtonValue;
    @NonNull
    public final Button variableNewValueExpressionMagicButton;
    @NonNull
    public final Button variableNewValueStringMagicButton;

    private VariableNewValueDialogBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout, @NonNull NDSpinner nDSpinner, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull LinearLayout linearLayout3, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout4, @NonNull RelativeLayout relativeLayout, @NonNull RadioGroup radioGroup, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatEditText appCompatEditText3, @NonNull AppCompatEditText appCompatEditText4, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioGroup radioGroup2, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5, @NonNull RadioButton radioButton6, @NonNull RadioButton radioButton7, @NonNull RadioButton radioButton8, @NonNull RadioButton radioButton9, @NonNull RadioButton radioButton10, @NonNull RadioButton radioButton11, @NonNull RadioButton radioButton12, @NonNull LinearLayout linearLayout5, @NonNull AppCompatEditText appCompatEditText5, @NonNull LinearLayout linearLayout6, @NonNull RadioButton radioButton13, @NonNull RadioButton radioButton14, @NonNull Button button3, @NonNull Button button4) {
        this.f11402a = linearLayout;
        this.arrayIndex = editText;
        this.arrayIndexEntryLayout = textInputLayout;
        this.booleanVariableSpinner = nDSpinner;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.expressionFunctionsLayout = linearLayout3;
        this.okButton = button2;
        this.radioButtonDummyPlaceholder = radioButton;
        this.variableNewValueDialogExpressionEdittext = appCompatEditText;
        this.variableNewValueDialogExpressionLayout = linearLayout4;
        this.variableNewValueDialogIntOptionRadioButtonContainer = relativeLayout;
        this.variableNewValueDialogIntOptionRadiogroup = radioGroup;
        this.variableNewValueDialogIntegerEdittext = appCompatEditText2;
        this.variableNewValueDialogIntegerRandomMax = appCompatEditText3;
        this.variableNewValueDialogIntegerRandomMin = appCompatEditText4;
        this.variableNewValueDialogRadioButtonBooleanOtherBooleanVariable = radioButton2;
        this.variableNewValueDialogRadioButtonBooleanPrompt = radioButton3;
        this.variableNewValueDialogRadioButtonContainer = radioGroup2;
        this.variableNewValueDialogRadioButtonDecrement = radioButton4;
        this.variableNewValueDialogRadioButtonExpression = radioButton5;
        this.variableNewValueDialogRadioButtonFalse = radioButton6;
        this.variableNewValueDialogRadioButtonIncrement = radioButton7;
        this.variableNewValueDialogRadioButtonInvert = radioButton8;
        this.variableNewValueDialogRadioButtonPrompt = radioButton9;
        this.variableNewValueDialogRadioButtonRandom = radioButton10;
        this.variableNewValueDialogRadioButtonSetValue = radioButton11;
        this.variableNewValueDialogRadioButtonTrue = radioButton12;
        this.variableNewValueDialogRandomValueLayout = linearLayout5;
        this.variableNewValueDialogStringEdittext = appCompatEditText5;
        this.variableNewValueDialogStringOptionContainer = linearLayout6;
        this.variableNewValueDialogStringRadioButtonUserPrompt = radioButton13;
        this.variableNewValueDialogStringRadioButtonValue = radioButton14;
        this.variableNewValueExpressionMagicButton = button3;
        this.variableNewValueStringMagicButton = button4;
    }

    @NonNull
    public static VariableNewValueDialogBinding bind(@NonNull View view) {
        int i4 = R.id.arrayIndex;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.arrayIndex);
        if (editText != null) {
            i4 = R.id.arrayIndexEntryLayout;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.arrayIndexEntryLayout);
            if (textInputLayout != null) {
                i4 = R.id.boolean_variable_spinner;
                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.boolean_variable_spinner);
                if (nDSpinner != null) {
                    i4 = R.id.button_bar;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                    if (linearLayout != null) {
                        i4 = R.id.cancelButton;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                        if (button != null) {
                            i4 = R.id.expression_functions_layout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.expression_functions_layout);
                            if (linearLayout2 != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    i4 = R.id.radio_button_dummy_placeholder;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_dummy_placeholder);
                                    if (radioButton != null) {
                                        i4 = R.id.variable_new_value_dialog_expression_edittext;
                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_expression_edittext);
                                        if (appCompatEditText != null) {
                                            i4 = R.id.variable_new_value_dialog_expression_layout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_expression_layout);
                                            if (linearLayout3 != null) {
                                                i4 = R.id.variable_new_value_dialog_int_option_radio_button_container;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_int_option_radio_button_container);
                                                if (relativeLayout != null) {
                                                    i4 = R.id.variable_new_value_dialog_int_option_radiogroup;
                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_int_option_radiogroup);
                                                    if (radioGroup != null) {
                                                        i4 = R.id.variable_new_value_dialog_integer_edittext;
                                                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_integer_edittext);
                                                        if (appCompatEditText2 != null) {
                                                            i4 = R.id.variable_new_value_dialog_integer_random_max;
                                                            AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_integer_random_max);
                                                            if (appCompatEditText3 != null) {
                                                                i4 = R.id.variable_new_value_dialog_integer_random_min;
                                                                AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_integer_random_min);
                                                                if (appCompatEditText4 != null) {
                                                                    i4 = R.id.variable_new_value_dialog_radio_button_boolean_other_boolean_variable;
                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_boolean_other_boolean_variable);
                                                                    if (radioButton2 != null) {
                                                                        i4 = R.id.variable_new_value_dialog_radio_button_boolean_prompt;
                                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_boolean_prompt);
                                                                        if (radioButton3 != null) {
                                                                            i4 = R.id.variable_new_value_dialog_radio_button_container;
                                                                            RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_container);
                                                                            if (radioGroup2 != null) {
                                                                                i4 = R.id.variable_new_value_dialog_radio_button_decrement;
                                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_decrement);
                                                                                if (radioButton4 != null) {
                                                                                    i4 = R.id.variable_new_value_dialog_radio_button_expression;
                                                                                    RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_expression);
                                                                                    if (radioButton5 != null) {
                                                                                        i4 = R.id.variable_new_value_dialog_radio_button_false;
                                                                                        RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_false);
                                                                                        if (radioButton6 != null) {
                                                                                            i4 = R.id.variable_new_value_dialog_radio_button_increment;
                                                                                            RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_increment);
                                                                                            if (radioButton7 != null) {
                                                                                                i4 = R.id.variable_new_value_dialog_radio_button_invert;
                                                                                                RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_invert);
                                                                                                if (radioButton8 != null) {
                                                                                                    i4 = R.id.variable_new_value_dialog_radio_button_prompt;
                                                                                                    RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_prompt);
                                                                                                    if (radioButton9 != null) {
                                                                                                        i4 = R.id.variable_new_value_dialog_radio_button_random;
                                                                                                        RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_random);
                                                                                                        if (radioButton10 != null) {
                                                                                                            i4 = R.id.variable_new_value_dialog_radio_button_setValue;
                                                                                                            RadioButton radioButton11 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_setValue);
                                                                                                            if (radioButton11 != null) {
                                                                                                                i4 = R.id.variable_new_value_dialog_radio_button_true;
                                                                                                                RadioButton radioButton12 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_radio_button_true);
                                                                                                                if (radioButton12 != null) {
                                                                                                                    i4 = R.id.variable_new_value_dialog_random_value_layout;
                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_random_value_layout);
                                                                                                                    if (linearLayout4 != null) {
                                                                                                                        i4 = R.id.variable_new_value_dialog_string_edittext;
                                                                                                                        AppCompatEditText appCompatEditText5 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_string_edittext);
                                                                                                                        if (appCompatEditText5 != null) {
                                                                                                                            i4 = R.id.variable_new_value_dialog_string_option_container;
                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_string_option_container);
                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                i4 = R.id.variable_new_value_dialog_string_radio_button_user_prompt;
                                                                                                                                RadioButton radioButton13 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_string_radio_button_user_prompt);
                                                                                                                                if (radioButton13 != null) {
                                                                                                                                    i4 = R.id.variable_new_value_dialog_string_radio_button_value;
                                                                                                                                    RadioButton radioButton14 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_new_value_dialog_string_radio_button_value);
                                                                                                                                    if (radioButton14 != null) {
                                                                                                                                        i4 = R.id.variable_new_value_expression_magic_button;
                                                                                                                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.variable_new_value_expression_magic_button);
                                                                                                                                        if (button3 != null) {
                                                                                                                                            i4 = R.id.variable_new_value_string_magic_button;
                                                                                                                                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.variable_new_value_string_magic_button);
                                                                                                                                            if (button4 != null) {
                                                                                                                                                return new VariableNewValueDialogBinding((LinearLayout) view, editText, textInputLayout, nDSpinner, linearLayout, button, linearLayout2, button2, radioButton, appCompatEditText, linearLayout3, relativeLayout, radioGroup, appCompatEditText2, appCompatEditText3, appCompatEditText4, radioButton2, radioButton3, radioGroup2, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, radioButton10, radioButton11, radioButton12, linearLayout4, appCompatEditText5, linearLayout5, radioButton13, radioButton14, button3, button4);
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    public static VariableNewValueDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableNewValueDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_new_value_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11402a;
    }
}
