package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public final class DialogIpAddressBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11080a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton excludesRadioButton;
    @NonNull
    public final AppCompatEditText ipAddress;
    @NonNull
    public final Button ipAddressMagicTextButton;
    @NonNull
    public final RadioButton matchesRadioButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView variableConstraintDialogWildcardsInfo;

    private DialogIpAddressBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull RadioButton radioButton2, @NonNull Button button3, @NonNull TextView textView) {
        this.f11080a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.excludesRadioButton = radioButton;
        this.ipAddress = appCompatEditText;
        this.ipAddressMagicTextButton = button2;
        this.matchesRadioButton = radioButton2;
        this.okButton = button3;
        this.variableConstraintDialogWildcardsInfo = textView;
    }

    @NonNull
    public static DialogIpAddressBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.excludesRadioButton;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.excludesRadioButton);
                if (radioButton != null) {
                    i4 = R.id.ipAddress;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.ipAddress);
                    if (appCompatEditText != null) {
                        i4 = R.id.ipAddressMagicTextButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.ipAddressMagicTextButton);
                        if (button2 != null) {
                            i4 = R.id.matchesRadioButton;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.matchesRadioButton);
                            if (radioButton2 != null) {
                                i4 = R.id.okButton;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button3 != null) {
                                    i4 = R.id.variable_constraint_dialog_wildcards_info;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variable_constraint_dialog_wildcards_info);
                                    if (textView != null) {
                                        return new DialogIpAddressBinding((LinearLayout) view, linearLayout, button, radioButton, appCompatEditText, button2, radioButton2, button3, textView);
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
    public static DialogIpAddressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogIpAddressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ip_address, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11080a;
    }
}
