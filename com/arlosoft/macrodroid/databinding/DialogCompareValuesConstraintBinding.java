package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogCompareValuesConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11036a;
    @NonNull
    public final RadioGroup booleanComparisonOptions;
    @NonNull
    public final RadioButton booleanEqualsRadioButton;
    @NonNull
    public final RadioButton booleanNotEqualsRadioButton;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final CheckBox enableRegexCheckbox;
    @NonNull
    public final LinearLayout expressionFunctionsLayout;
    @NonNull
    public final CheckBox ignoreCaseCheckbox;
    @NonNull
    public final RadioGroup numberComparisonOptions;
    @NonNull
    public final RadioButton numberEqualsRadioButton;
    @NonNull
    public final RadioButton numberGreaterThanRadioButton;
    @NonNull
    public final RadioButton numberLessThanRadioButton;
    @NonNull
    public final RadioButton numberNotEqualsRadioButton;
    @NonNull
    public final RadioGroup stringComparisonOptions;
    @NonNull
    public final RadioButton stringContainsRadioButton;
    @NonNull
    public final RadioButton stringEqualsRadioButton;
    @NonNull
    public final RadioButton stringExcludesRadioButton;
    @NonNull
    public final RadioButton stringNotEqualsRadioButton;
    @NonNull
    public final LinearLayout stringSecondaryOptions;
    @NonNull
    public final Spinner typeSpinner;
    @NonNull
    public final EditText value1;
    @NonNull
    public final Button value1MagicButton;
    @NonNull
    public final EditText value2;
    @NonNull
    public final Button value2MagicButton;
    @NonNull
    public final Button variableConstraintDialogButtonCancel;
    @NonNull
    public final Button variableConstraintDialogButtonOk;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;

    private DialogCompareValuesConstraintBinding(@NonNull LinearLayout linearLayout, @NonNull RadioGroup radioGroup, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull LinearLayout linearLayout2, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout3, @NonNull CheckBox checkBox2, @NonNull RadioGroup radioGroup2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5, @NonNull RadioButton radioButton6, @NonNull RadioGroup radioGroup3, @NonNull RadioButton radioButton7, @NonNull RadioButton radioButton8, @NonNull RadioButton radioButton9, @NonNull RadioButton radioButton10, @NonNull LinearLayout linearLayout4, @NonNull Spinner spinner, @NonNull EditText editText, @NonNull Button button, @NonNull EditText editText2, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull TextView textView) {
        this.f11036a = linearLayout;
        this.booleanComparisonOptions = radioGroup;
        this.booleanEqualsRadioButton = radioButton;
        this.booleanNotEqualsRadioButton = radioButton2;
        this.buttonBar = linearLayout2;
        this.enableRegexCheckbox = checkBox;
        this.expressionFunctionsLayout = linearLayout3;
        this.ignoreCaseCheckbox = checkBox2;
        this.numberComparisonOptions = radioGroup2;
        this.numberEqualsRadioButton = radioButton3;
        this.numberGreaterThanRadioButton = radioButton4;
        this.numberLessThanRadioButton = radioButton5;
        this.numberNotEqualsRadioButton = radioButton6;
        this.stringComparisonOptions = radioGroup3;
        this.stringContainsRadioButton = radioButton7;
        this.stringEqualsRadioButton = radioButton8;
        this.stringExcludesRadioButton = radioButton9;
        this.stringNotEqualsRadioButton = radioButton10;
        this.stringSecondaryOptions = linearLayout4;
        this.typeSpinner = spinner;
        this.value1 = editText;
        this.value1MagicButton = button;
        this.value2 = editText2;
        this.value2MagicButton = button2;
        this.variableConstraintDialogButtonCancel = button3;
        this.variableConstraintDialogButtonOk = button4;
        this.variableConstraintDialogWildcardsInfo = textView;
    }

    @NonNull
    public static DialogCompareValuesConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.booleanComparisonOptions;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.booleanComparisonOptions);
        if (radioGroup != null) {
            i4 = R.id.booleanEqualsRadioButton;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.booleanEqualsRadioButton);
            if (radioButton != null) {
                i4 = R.id.booleanNotEqualsRadioButton;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.booleanNotEqualsRadioButton);
                if (radioButton2 != null) {
                    i4 = R.id.button_bar;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                    if (linearLayout != null) {
                        i4 = R.id.enableRegexCheckbox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enableRegexCheckbox);
                        if (checkBox != null) {
                            i4 = R.id.expression_functions_layout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.expression_functions_layout);
                            if (linearLayout2 != null) {
                                i4 = R.id.ignoreCaseCheckbox;
                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignoreCaseCheckbox);
                                if (checkBox2 != null) {
                                    i4 = R.id.numberComparisonOptions;
                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.numberComparisonOptions);
                                    if (radioGroup2 != null) {
                                        i4 = R.id.numberEqualsRadioButton;
                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.numberEqualsRadioButton);
                                        if (radioButton3 != null) {
                                            i4 = R.id.numberGreaterThanRadioButton;
                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.numberGreaterThanRadioButton);
                                            if (radioButton4 != null) {
                                                i4 = R.id.numberLessThanRadioButton;
                                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.numberLessThanRadioButton);
                                                if (radioButton5 != null) {
                                                    i4 = R.id.numberNotEqualsRadioButton;
                                                    RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(view, R.id.numberNotEqualsRadioButton);
                                                    if (radioButton6 != null) {
                                                        i4 = R.id.stringComparisonOptions;
                                                        RadioGroup radioGroup3 = (RadioGroup) ViewBindings.findChildViewById(view, R.id.stringComparisonOptions);
                                                        if (radioGroup3 != null) {
                                                            i4 = R.id.stringContainsRadioButton;
                                                            RadioButton radioButton7 = (RadioButton) ViewBindings.findChildViewById(view, R.id.stringContainsRadioButton);
                                                            if (radioButton7 != null) {
                                                                i4 = R.id.stringEqualsRadioButton;
                                                                RadioButton radioButton8 = (RadioButton) ViewBindings.findChildViewById(view, R.id.stringEqualsRadioButton);
                                                                if (radioButton8 != null) {
                                                                    i4 = R.id.stringExcludesRadioButton;
                                                                    RadioButton radioButton9 = (RadioButton) ViewBindings.findChildViewById(view, R.id.stringExcludesRadioButton);
                                                                    if (radioButton9 != null) {
                                                                        i4 = R.id.stringNotEqualsRadioButton;
                                                                        RadioButton radioButton10 = (RadioButton) ViewBindings.findChildViewById(view, R.id.stringNotEqualsRadioButton);
                                                                        if (radioButton10 != null) {
                                                                            i4 = R.id.stringSecondaryOptions;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.stringSecondaryOptions);
                                                                            if (linearLayout3 != null) {
                                                                                i4 = R.id.typeSpinner;
                                                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.typeSpinner);
                                                                                if (spinner != null) {
                                                                                    i4 = R.id.value_1;
                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.value_1);
                                                                                    if (editText != null) {
                                                                                        i4 = R.id.value_1_magic_button;
                                                                                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.value_1_magic_button);
                                                                                        if (button != null) {
                                                                                            i4 = R.id.value_2;
                                                                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.value_2);
                                                                                            if (editText2 != null) {
                                                                                                i4 = R.id.value_2_magic_button;
                                                                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.value_2_magic_button);
                                                                                                if (button2 != null) {
                                                                                                    i4 = R.id.variable_constraint_dialog_button_cancel;
                                                                                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_button_cancel);
                                                                                                    if (button3 != null) {
                                                                                                        i4 = R.id.variable_constraint_dialog_button_ok;
                                                                                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_button_ok);
                                                                                                        if (button4 != null) {
                                                                                                            i4 = R.id.variable_constraint_dialog_wildcards_info;
                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                                                                                            if (textView != null) {
                                                                                                                return new DialogCompareValuesConstraintBinding((LinearLayout) view, radioGroup, radioButton, radioButton2, linearLayout, checkBox, linearLayout2, checkBox2, radioGroup2, radioButton3, radioButton4, radioButton5, radioButton6, radioGroup3, radioButton7, radioButton8, radioButton9, radioButton10, linearLayout3, spinner, editText, button, editText2, button2, button3, button4, textView);
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
    public static DialogCompareValuesConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCompareValuesConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_compare_values_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11036a;
    }
}
