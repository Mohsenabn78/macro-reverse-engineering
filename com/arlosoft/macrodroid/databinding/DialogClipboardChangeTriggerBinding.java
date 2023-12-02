package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogClipboardChangeTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11033a;
    @NonNull
    public final Button dialogClipboardChangeTriggerMagicTextButton;
    @NonNull
    public final AppCompatEditText dialogClipboardChangeTriggerText;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final CheckBox useAccessibilityCheckbox;
    @NonNull
    public final TextView useAccessibilityInfo;
    @NonNull
    public final CheckBox useLogcatCheckbox;
    @NonNull
    public final TextView useLogcatInfo;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;

    private DialogClipboardChangeTriggerBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull TextView textView, @NonNull CheckBox checkBox4, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11033a = linearLayout;
        this.dialogClipboardChangeTriggerMagicTextButton = button;
        this.dialogClipboardChangeTriggerText = appCompatEditText;
        this.enableRegex = checkBox;
        this.ignoreCase = checkBox2;
        this.useAccessibilityCheckbox = checkBox3;
        this.useAccessibilityInfo = textView;
        this.useLogcatCheckbox = checkBox4;
        this.useLogcatInfo = textView2;
        this.variableConstraintDialogWildcardsInfo = textView3;
    }

    @NonNull
    public static DialogClipboardChangeTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.dialog_clipboard_change_trigger_magic_text_button;
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
                        i4 = R.id.useAccessibilityCheckbox;
                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.useAccessibilityCheckbox);
                        if (checkBox3 != null) {
                            i4 = R.id.useAccessibilityInfo;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.useAccessibilityInfo);
                            if (textView != null) {
                                i4 = R.id.useLogcatCheckbox;
                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.useLogcatCheckbox);
                                if (checkBox4 != null) {
                                    i4 = R.id.useLogcatInfo;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.useLogcatInfo);
                                    if (textView2 != null) {
                                        i4 = R.id.variable_constraint_dialog_wildcards_info;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                        if (textView3 != null) {
                                            return new DialogClipboardChangeTriggerBinding((LinearLayout) view, button, appCompatEditText, checkBox, checkBox2, checkBox3, textView, checkBox4, textView2, textView3);
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
    public static DialogClipboardChangeTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogClipboardChangeTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_clipboard_change_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11033a;
    }
}
