package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class VariableConstraintDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11399a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final AppCompatEditText expressionEdittext;
    @NonNull
    public final LinearLayout expressionFunctionsLayout;
    @NonNull
    public final Button expressionMagicButton;
    @NonNull
    public final RadioButton expressionRadioButton;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final Button variableConstraintDialogButtonCancel;
    @NonNull
    public final Button variableConstraintDialogButtonOk;
    @NonNull
    public final LinearLayout variableConstraintDialogIntOptionRadioButtonContainer;
    @NonNull
    public final AppCompatEditText variableConstraintDialogIntegerEdittext;
    @NonNull
    public final RadioButton variableConstraintDialogIntegerValueRadioButton;
    @NonNull
    public final RadioButton variableConstraintDialogIntegerVariableRadioButton;
    @NonNull
    public final NDSpinner variableConstraintDialogIntegerVariableSpinner;
    @NonNull
    public final RadioGroup variableConstraintDialogRadioButtonContainer;
    @NonNull
    public final RadioButton variableConstraintDialogRadioButtonEqual;
    @NonNull
    public final RadioButton variableConstraintDialogRadioButtonFalse;
    @NonNull
    public final RadioButton variableConstraintDialogRadioButtonGreaterThan;
    @NonNull
    public final RadioButton variableConstraintDialogRadioButtonLessThan;
    @NonNull
    public final RadioButton variableConstraintDialogRadioButtonNotEqual;
    @NonNull
    public final RadioButton variableConstraintDialogRadioButtonTrue;
    @NonNull
    public final LinearLayout variableConstraintDialogStringContainer;
    @NonNull
    public final AppCompatEditText variableConstraintDialogStringEdittext;
    @NonNull
    public final Button variableConstraintDialogStringMagicButton;
    @NonNull
    public final RadioGroup variableConstraintDialogStringOptionRadioButtonContainer;
    @NonNull
    public final RadioButton variableConstraintDialogStringRadioButtonContains;
    @NonNull
    public final RadioButton variableConstraintDialogStringRadioButtonEqual;
    @NonNull
    public final RadioButton variableConstraintDialogStringRadioButtonExcludes;
    @NonNull
    public final RadioButton variableConstraintDialogStringRadioButtonNotEqual;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;

    private VariableConstraintDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CheckBox checkBox, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout3, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull CheckBox checkBox2, @NonNull Button button2, @NonNull Button button3, @NonNull LinearLayout linearLayout4, @NonNull AppCompatEditText appCompatEditText2, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull NDSpinner nDSpinner, @NonNull RadioGroup radioGroup, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5, @NonNull RadioButton radioButton6, @NonNull RadioButton radioButton7, @NonNull RadioButton radioButton8, @NonNull RadioButton radioButton9, @NonNull LinearLayout linearLayout5, @NonNull AppCompatEditText appCompatEditText3, @NonNull Button button4, @NonNull RadioGroup radioGroup2, @NonNull RadioButton radioButton10, @NonNull RadioButton radioButton11, @NonNull RadioButton radioButton12, @NonNull RadioButton radioButton13, @NonNull TextView textView) {
        this.f11399a = linearLayout;
        this.buttonBar = linearLayout2;
        this.enableRegex = checkBox;
        this.expressionEdittext = appCompatEditText;
        this.expressionFunctionsLayout = linearLayout3;
        this.expressionMagicButton = button;
        this.expressionRadioButton = radioButton;
        this.ignoreCase = checkBox2;
        this.variableConstraintDialogButtonCancel = button2;
        this.variableConstraintDialogButtonOk = button3;
        this.variableConstraintDialogIntOptionRadioButtonContainer = linearLayout4;
        this.variableConstraintDialogIntegerEdittext = appCompatEditText2;
        this.variableConstraintDialogIntegerValueRadioButton = radioButton2;
        this.variableConstraintDialogIntegerVariableRadioButton = radioButton3;
        this.variableConstraintDialogIntegerVariableSpinner = nDSpinner;
        this.variableConstraintDialogRadioButtonContainer = radioGroup;
        this.variableConstraintDialogRadioButtonEqual = radioButton4;
        this.variableConstraintDialogRadioButtonFalse = radioButton5;
        this.variableConstraintDialogRadioButtonGreaterThan = radioButton6;
        this.variableConstraintDialogRadioButtonLessThan = radioButton7;
        this.variableConstraintDialogRadioButtonNotEqual = radioButton8;
        this.variableConstraintDialogRadioButtonTrue = radioButton9;
        this.variableConstraintDialogStringContainer = linearLayout5;
        this.variableConstraintDialogStringEdittext = appCompatEditText3;
        this.variableConstraintDialogStringMagicButton = button4;
        this.variableConstraintDialogStringOptionRadioButtonContainer = radioGroup2;
        this.variableConstraintDialogStringRadioButtonContains = radioButton10;
        this.variableConstraintDialogStringRadioButtonEqual = radioButton11;
        this.variableConstraintDialogStringRadioButtonExcludes = radioButton12;
        this.variableConstraintDialogStringRadioButtonNotEqual = radioButton13;
        this.variableConstraintDialogWildcardsInfo = textView;
    }

    @NonNull
    public static VariableConstraintDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.enable_regex;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
            if (checkBox != null) {
                i4 = R.id.expression_edittext;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.expression_edittext);
                if (appCompatEditText != null) {
                    i4 = R.id.expression_functions_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.expression_functions_layout);
                    if (linearLayout2 != null) {
                        i4 = R.id.expression_magic_button;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.expression_magic_button);
                        if (button != null) {
                            i4 = R.id.expression_radio_button;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.expression_radio_button);
                            if (radioButton != null) {
                                i4 = R.id.ignore_case;
                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
                                if (checkBox2 != null) {
                                    i4 = R.id.variable_constraint_dialog_button_cancel;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_button_cancel);
                                    if (button2 != null) {
                                        i4 = R.id.variable_constraint_dialog_button_ok;
                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_button_ok);
                                        if (button3 != null) {
                                            i4 = R.id.variable_constraint_dialog_int_option_radio_button_container;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_int_option_radio_button_container);
                                            if (linearLayout3 != null) {
                                                i4 = R.id.variable_constraint_dialog_integer_edittext;
                                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_integer_edittext);
                                                if (appCompatEditText2 != null) {
                                                    i4 = R.id.variable_constraint_dialog_integer_value_radio_button;
                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_integer_value_radio_button);
                                                    if (radioButton2 != null) {
                                                        i4 = R.id.variable_constraint_dialog_integer_variable_radio_button;
                                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_integer_variable_radio_button);
                                                        if (radioButton3 != null) {
                                                            i4 = R.id.variable_constraint_dialog_integer_variable_spinner;
                                                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_integer_variable_spinner);
                                                            if (nDSpinner != null) {
                                                                i4 = R.id.variable_constraint_dialog_radio_button_container;
                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_container);
                                                                if (radioGroup != null) {
                                                                    i4 = R.id.variable_constraint_dialog_radio_button_equal;
                                                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_equal);
                                                                    if (radioButton4 != null) {
                                                                        i4 = R.id.variable_constraint_dialog_radio_button_false;
                                                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_false);
                                                                        if (radioButton5 != null) {
                                                                            i4 = R.id.variable_constraint_dialog_radio_button_greater_than;
                                                                            RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_greater_than);
                                                                            if (radioButton6 != null) {
                                                                                i4 = R.id.variable_constraint_dialog_radio_button_less_than;
                                                                                RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_less_than);
                                                                                if (radioButton7 != null) {
                                                                                    i4 = R.id.variable_constraint_dialog_radio_button_not_equal;
                                                                                    RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_not_equal);
                                                                                    if (radioButton8 != null) {
                                                                                        i4 = R.id.variable_constraint_dialog_radio_button_true;
                                                                                        RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_radio_button_true);
                                                                                        if (radioButton9 != null) {
                                                                                            i4 = R.id.variable_constraint_dialog_string_container;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_container);
                                                                                            if (linearLayout4 != null) {
                                                                                                i4 = R.id.variable_constraint_dialog_string_edittext;
                                                                                                AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_edittext);
                                                                                                if (appCompatEditText3 != null) {
                                                                                                    i4 = R.id.variable_constraint_dialog_string_magic_button;
                                                                                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_magic_button);
                                                                                                    if (button4 != null) {
                                                                                                        i4 = R.id.variable_constraint_dialog_string_option_radio_button_container;
                                                                                                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_option_radio_button_container);
                                                                                                        if (radioGroup2 != null) {
                                                                                                            i4 = R.id.variable_constraint_dialog_string_radio_button_contains;
                                                                                                            RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_radio_button_contains);
                                                                                                            if (radioButton10 != null) {
                                                                                                                i4 = R.id.variable_constraint_dialog_string_radio_button_equal;
                                                                                                                RadioButton radioButton11 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_radio_button_equal);
                                                                                                                if (radioButton11 != null) {
                                                                                                                    i4 = R.id.variable_constraint_dialog_string_radio_button_excludes;
                                                                                                                    RadioButton radioButton12 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_radio_button_excludes);
                                                                                                                    if (radioButton12 != null) {
                                                                                                                        i4 = R.id.variable_constraint_dialog_string_radio_button_not_equal;
                                                                                                                        RadioButton radioButton13 = (RadioButton) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_string_radio_button_not_equal);
                                                                                                                        if (radioButton13 != null) {
                                                                                                                            i4 = R.id.variable_constraint_dialog_wildcards_info;
                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                                                                                                            if (textView != null) {
                                                                                                                                return new VariableConstraintDialogBinding((LinearLayout) view, linearLayout, checkBox, appCompatEditText, linearLayout2, button, radioButton, checkBox2, button2, button3, linearLayout3, appCompatEditText2, radioButton2, radioButton3, nDSpinner, radioGroup, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, linearLayout4, appCompatEditText3, button4, radioGroup2, radioButton10, radioButton11, radioButton12, radioButton13, textView);
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
    public static VariableConstraintDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableConstraintDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_constraint_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11399a;
    }
}
