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

/* loaded from: classes3.dex */
public final class DialogSystemLogTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11137a;
    @NonNull
    public final RadioButton containsRadioButton;
    @NonNull
    public final Button dialogClipboardChangeTriggerMagicTextButton;
    @NonNull
    public final AppCompatEditText dialogClipboardChangeTriggerText;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final RadioButton matchesRadioButton;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;

    private DialogSystemLogTriggerBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull RadioButton radioButton2, @NonNull TextView textView) {
        this.f11137a = linearLayout;
        this.containsRadioButton = radioButton;
        this.dialogClipboardChangeTriggerMagicTextButton = button;
        this.dialogClipboardChangeTriggerText = appCompatEditText;
        this.enableRegex = checkBox;
        this.ignoreCase = checkBox2;
        this.matchesRadioButton = radioButton2;
        this.variableConstraintDialogWildcardsInfo = textView;
    }

    @NonNull
    public static DialogSystemLogTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.contains_radio_button;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.contains_radio_button);
        if (radioButton != null) {
            i4 = R.id.dialog_clipboard_change_trigger_magic_text_button;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.dialog_clipboard_change_trigger_magic_text_button);
            if (button != null) {
                i4 = R.id.dialog_clipboard_change_trigger_text;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_clipboard_change_trigger_text);
                if (appCompatEditText != null) {
                    i4 = R.id.enable_regex;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
                    if (checkBox != null) {
                        i4 = R.id.ignore_case;
                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
                        if (checkBox2 != null) {
                            i4 = R.id.matches_radio_button;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.matches_radio_button);
                            if (radioButton2 != null) {
                                i4 = R.id.variable_constraint_dialog_wildcards_info;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                if (textView != null) {
                                    return new DialogSystemLogTriggerBinding((LinearLayout) view, radioButton, button, appCompatEditText, checkBox, checkBox2, radioButton2, textView);
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
    public static DialogSystemLogTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSystemLogTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_system_log_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11137a;
    }
}
