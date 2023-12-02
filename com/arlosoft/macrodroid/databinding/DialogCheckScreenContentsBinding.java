package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogCheckScreenContentsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11031a;
    @NonNull
    public final Button addBooleanVariableButton;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final NDSpinner booleanVariableSpinner;
    @NonNull
    public final RadioButton containsRadioButton;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final CheckBox ignoreCaseCheckbox;
    @NonNull
    public final CheckBox ignoreHiddenTextCheckbox;
    @NonNull
    public final CheckBox includeOverlaysCheckbox;
    @NonNull
    public final RadioButton matchesRadioButton;
    @NonNull
    public final AppCompatEditText textToMatch;
    @NonNull
    public final Button textToMatchMagicTextButton;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;
    @NonNull
    public final NDSpinner viewIdStringVariableSpinner;

    private DialogCheckScreenContentsBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull NDSpinner nDSpinner, @NonNull RadioButton radioButton, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull RadioButton radioButton2, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button3, @NonNull TextView textView, @NonNull NDSpinner nDSpinner2) {
        this.f11031a = linearLayout;
        this.addBooleanVariableButton = button;
        this.addStringVariableButton = button2;
        this.booleanVariableSpinner = nDSpinner;
        this.containsRadioButton = radioButton;
        this.enableRegex = checkBox;
        this.ignoreCaseCheckbox = checkBox2;
        this.ignoreHiddenTextCheckbox = checkBox3;
        this.includeOverlaysCheckbox = checkBox4;
        this.matchesRadioButton = radioButton2;
        this.textToMatch = appCompatEditText;
        this.textToMatchMagicTextButton = button3;
        this.variableConstraintDialogWildcardsInfo = textView;
        this.viewIdStringVariableSpinner = nDSpinner2;
    }

    @NonNull
    public static DialogCheckScreenContentsBinding bind(@NonNull View view) {
        int i4 = R.id.addBooleanVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addBooleanVariableButton);
        if (button != null) {
            i4 = R.id.addStringVariableButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
            if (button2 != null) {
                i4 = R.id.booleanVariableSpinner;
                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.booleanVariableSpinner);
                if (nDSpinner != null) {
                    i4 = R.id.contains_radio_button;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.contains_radio_button);
                    if (radioButton != null) {
                        i4 = R.id.enable_regex;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
                        if (checkBox != null) {
                            i4 = R.id.ignore_case_checkbox;
                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case_checkbox);
                            if (checkBox2 != null) {
                                i4 = R.id.ignore_hidden_text_checkbox;
                                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_hidden_text_checkbox);
                                if (checkBox3 != null) {
                                    i4 = R.id.include_overlays_checkbox;
                                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.include_overlays_checkbox);
                                    if (checkBox4 != null) {
                                        i4 = R.id.matches_radio_button;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.matches_radio_button);
                                        if (radioButton2 != null) {
                                            i4 = R.id.text_to_match;
                                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.text_to_match);
                                            if (appCompatEditText != null) {
                                                i4 = R.id.text_to_match_magic_text_button;
                                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.text_to_match_magic_text_button);
                                                if (button3 != null) {
                                                    i4 = R.id.variable_constraint_dialog_wildcards_info;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                                    if (textView != null) {
                                                        i4 = R.id.viewIdStringVariableSpinner;
                                                        NDSpinner nDSpinner2 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.viewIdStringVariableSpinner);
                                                        if (nDSpinner2 != null) {
                                                            return new DialogCheckScreenContentsBinding((LinearLayout) view, button, button2, nDSpinner, radioButton, checkBox, checkBox2, checkBox3, checkBox4, radioButton2, appCompatEditText, button3, textView, nDSpinner2);
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
    public static DialogCheckScreenContentsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCheckScreenContentsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_check_screen_contents, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11031a;
    }
}
