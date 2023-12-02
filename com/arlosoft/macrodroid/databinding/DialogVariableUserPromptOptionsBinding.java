package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogVariableUserPromptOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11160a;
    @NonNull
    public final CheckBox allowCancelCheckbox;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox cancelStopsRunningCheckbox;
    @NonNull
    public final CheckBox darkModeCheckbox;
    @NonNull
    public final Button descriptionMagicTextButton;
    @NonNull
    public final CheckBox existingValue;
    @NonNull
    public final AppCompatEditText falseLabel;
    @NonNull
    public final LinearLayout falseLabelLayout;
    @NonNull
    public final Button falseLabelMagicTextButton;
    @NonNull
    public final TextInputLayout inputLayoutPassword;
    @NonNull
    public final Button okButton;
    @NonNull
    public final CheckBox passwordField;
    @NonNull
    public final Button titleMagicTextButton;
    @NonNull
    public final AppCompatEditText trueLabel;
    @NonNull
    public final LinearLayout trueLabelLayout;
    @NonNull
    public final Button trueLabelMagicTextButton;
    @NonNull
    public final AppCompatEditText userPromptDescription;
    @NonNull
    public final AppCompatEditText userPromptTitle;

    private DialogVariableUserPromptOptionsBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull Button button2, @NonNull CheckBox checkBox4, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout2, @NonNull Button button3, @NonNull TextInputLayout textInputLayout, @NonNull Button button4, @NonNull CheckBox checkBox5, @NonNull Button button5, @NonNull AppCompatEditText appCompatEditText2, @NonNull LinearLayout linearLayout3, @NonNull Button button6, @NonNull AppCompatEditText appCompatEditText3, @NonNull AppCompatEditText appCompatEditText4) {
        this.f11160a = scrollView;
        this.allowCancelCheckbox = checkBox;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.cancelStopsRunningCheckbox = checkBox2;
        this.darkModeCheckbox = checkBox3;
        this.descriptionMagicTextButton = button2;
        this.existingValue = checkBox4;
        this.falseLabel = appCompatEditText;
        this.falseLabelLayout = linearLayout2;
        this.falseLabelMagicTextButton = button3;
        this.inputLayoutPassword = textInputLayout;
        this.okButton = button4;
        this.passwordField = checkBox5;
        this.titleMagicTextButton = button5;
        this.trueLabel = appCompatEditText2;
        this.trueLabelLayout = linearLayout3;
        this.trueLabelMagicTextButton = button6;
        this.userPromptDescription = appCompatEditText3;
        this.userPromptTitle = appCompatEditText4;
    }

    @NonNull
    public static DialogVariableUserPromptOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.allow_cancel_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.allow_cancel_checkbox);
        if (checkBox != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.cancel_stops_running_checkbox;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.cancel_stops_running_checkbox);
                    if (checkBox2 != null) {
                        i4 = R.id.dark_mode_checkbox;
                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.dark_mode_checkbox);
                        if (checkBox3 != null) {
                            i4 = R.id.description_magic_text_button;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.description_magic_text_button);
                            if (button2 != null) {
                                i4 = R.id.existing_value;
                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.existing_value);
                                if (checkBox4 != null) {
                                    i4 = R.id.false_label;
                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.false_label);
                                    if (appCompatEditText != null) {
                                        i4 = R.id.false_label_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.false_label_layout);
                                        if (linearLayout2 != null) {
                                            i4 = R.id.false_label_magic_text_button;
                                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.false_label_magic_text_button);
                                            if (button3 != null) {
                                                i4 = R.id.input_layout_password;
                                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.input_layout_password);
                                                if (textInputLayout != null) {
                                                    i4 = R.id.okButton;
                                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                    if (button4 != null) {
                                                        i4 = R.id.password_field;
                                                        CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.password_field);
                                                        if (checkBox5 != null) {
                                                            i4 = R.id.title_magic_text_button;
                                                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.title_magic_text_button);
                                                            if (button5 != null) {
                                                                i4 = R.id.true_label;
                                                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.true_label);
                                                                if (appCompatEditText2 != null) {
                                                                    i4 = R.id.true_label_layout;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.true_label_layout);
                                                                    if (linearLayout3 != null) {
                                                                        i4 = R.id.true_label_magic_text_button;
                                                                        Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.true_label_magic_text_button);
                                                                        if (button6 != null) {
                                                                            i4 = R.id.user_prompt_description;
                                                                            AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.user_prompt_description);
                                                                            if (appCompatEditText3 != null) {
                                                                                i4 = R.id.user_prompt_title;
                                                                                AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.user_prompt_title);
                                                                                if (appCompatEditText4 != null) {
                                                                                    return new DialogVariableUserPromptOptionsBinding((ScrollView) view, checkBox, linearLayout, button, checkBox2, checkBox3, button2, checkBox4, appCompatEditText, linearLayout2, button3, textInputLayout, button4, checkBox5, button5, appCompatEditText2, linearLayout3, button6, appCompatEditText3, appCompatEditText4);
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
    public static DialogVariableUserPromptOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogVariableUserPromptOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_variable_user_prompt_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11160a;
    }
}
