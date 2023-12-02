package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogShellScriptBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11127a;
    @NonNull
    public final CheckBox blockActionsCheckbox;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button dialogShellScriptMagicTextButton;
    @NonNull
    public final TextView dialogShellScriptSaveOutput;
    @NonNull
    public final AppCompatEditText dialogShellScriptText;
    @NonNull
    public final TextView dialogShellScriptVariableInfo;
    @NonNull
    public final NDSpinner dialogShellScriptVariableSpinner;
    @NonNull
    public final CheckBox helperFileCheckBox;
    @NonNull
    public final RadioButton nonRooted;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton rootOnly;
    @NonNull
    public final Spinner timeoutSpinner;

    private DialogShellScriptBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView2, @NonNull NDSpinner nDSpinner, @NonNull CheckBox checkBox2, @NonNull RadioButton radioButton, @NonNull Button button3, @NonNull RadioButton radioButton2, @NonNull Spinner spinner) {
        this.f11127a = scrollView;
        this.blockActionsCheckbox = checkBox;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.dialogShellScriptMagicTextButton = button2;
        this.dialogShellScriptSaveOutput = textView;
        this.dialogShellScriptText = appCompatEditText;
        this.dialogShellScriptVariableInfo = textView2;
        this.dialogShellScriptVariableSpinner = nDSpinner;
        this.helperFileCheckBox = checkBox2;
        this.nonRooted = radioButton;
        this.okButton = button3;
        this.rootOnly = radioButton2;
        this.timeoutSpinner = spinner;
    }

    @NonNull
    public static DialogShellScriptBinding bind(@NonNull View view) {
        int i4 = R.id.blockActionsCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.blockActionsCheckbox);
        if (checkBox != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.dialog_shell_script_magic_text_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.dialog_shell_script_magic_text_button);
                    if (button2 != null) {
                        i4 = R.id.dialog_shell_script_save_output;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_shell_script_save_output);
                        if (textView != null) {
                            i4 = R.id.dialog_shell_script_text;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_shell_script_text);
                            if (appCompatEditText != null) {
                                i4 = R.id.dialog_shell_script_variable_info;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_shell_script_variable_info);
                                if (textView2 != null) {
                                    i4 = R.id.dialog_shell_script_variable_spinner;
                                    NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dialog_shell_script_variable_spinner);
                                    if (nDSpinner != null) {
                                        i4 = R.id.helperFileCheckBox;
                                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.helperFileCheckBox);
                                        if (checkBox2 != null) {
                                            i4 = R.id.non_rooted;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.non_rooted);
                                            if (radioButton != null) {
                                                i4 = R.id.okButton;
                                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                if (button3 != null) {
                                                    i4 = R.id.root_only;
                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.root_only);
                                                    if (radioButton2 != null) {
                                                        i4 = R.id.timeoutSpinner;
                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.timeoutSpinner);
                                                        if (spinner != null) {
                                                            return new DialogShellScriptBinding((ScrollView) view, checkBox, linearLayout, button, button2, textView, appCompatEditText, textView2, nDSpinner, checkBox2, radioButton, button3, radioButton2, spinner);
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
    public static DialogShellScriptBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogShellScriptBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_shell_script, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11127a;
    }
}
