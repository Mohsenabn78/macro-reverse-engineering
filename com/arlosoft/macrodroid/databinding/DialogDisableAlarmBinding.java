package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogDisableAlarmBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11049a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText dialogDismissAlarmLabel;
    @NonNull
    public final TextInputLayout inputLayoutPassword;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Button okButton;

    private DialogDisableAlarmBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull Button button2, @NonNull Button button3) {
        this.f11049a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.dialogDismissAlarmLabel = appCompatEditText;
        this.inputLayoutPassword = textInputLayout;
        this.magicTextButton = button2;
        this.okButton = button3;
    }

    @NonNull
    public static DialogDisableAlarmBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.dialog_dismiss_alarm_label;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_dismiss_alarm_label);
                if (appCompatEditText != null) {
                    i4 = R.id.input_layout_password;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.input_layout_password);
                    if (textInputLayout != null) {
                        i4 = R.id.magic_text_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                        if (button2 != null) {
                            i4 = R.id.okButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button3 != null) {
                                return new DialogDisableAlarmBinding((LinearLayout) view, linearLayout, button, appCompatEditText, textInputLayout, button2, button3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogDisableAlarmBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDisableAlarmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_disable_alarm, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11049a;
    }
}
