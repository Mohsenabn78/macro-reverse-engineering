package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class SendEmailActionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11362a;
    @NonNull
    public final Button addVariableButton;
    @NonNull
    public final TextInputEditText body;
    @NonNull
    public final NDSpinner booleanVariableSpinner;
    @NonNull
    public final Button configureSmtpServer;
    @NonNull
    public final TextInputEditText fromAddress;
    @NonNull
    public final TextInputLayout fromEmailAddressLayout;
    @NonNull
    public final CheckBox htmlCheckBox;
    @NonNull
    public final TextInputEditText subject;
    @NonNull
    public final TextInputEditText toAddress;
    @NonNull
    public final CheckBox waitToCompleteCheckbox;
    @NonNull
    public final LinearLayout waitToCompleteOptions;

    private SendEmailActionBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull TextInputEditText textInputEditText, @NonNull NDSpinner nDSpinner, @NonNull Button button2, @NonNull TextInputEditText textInputEditText2, @NonNull TextInputLayout textInputLayout, @NonNull CheckBox checkBox, @NonNull TextInputEditText textInputEditText3, @NonNull TextInputEditText textInputEditText4, @NonNull CheckBox checkBox2, @NonNull LinearLayout linearLayout2) {
        this.f11362a = linearLayout;
        this.addVariableButton = button;
        this.body = textInputEditText;
        this.booleanVariableSpinner = nDSpinner;
        this.configureSmtpServer = button2;
        this.fromAddress = textInputEditText2;
        this.fromEmailAddressLayout = textInputLayout;
        this.htmlCheckBox = checkBox;
        this.subject = textInputEditText3;
        this.toAddress = textInputEditText4;
        this.waitToCompleteCheckbox = checkBox2;
        this.waitToCompleteOptions = linearLayout2;
    }

    @NonNull
    public static SendEmailActionBinding bind(@NonNull View view) {
        int i4 = R.id.addVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addVariableButton);
        if (button != null) {
            i4 = R.id.body;
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.body);
            if (textInputEditText != null) {
                i4 = R.id.booleanVariableSpinner;
                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.booleanVariableSpinner);
                if (nDSpinner != null) {
                    i4 = R.id.configure_smtp_server;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configure_smtp_server);
                    if (button2 != null) {
                        i4 = R.id.fromAddress;
                        TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.fromAddress);
                        if (textInputEditText2 != null) {
                            i4 = R.id.fromEmailAddressLayout;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.fromEmailAddressLayout);
                            if (textInputLayout != null) {
                                i4 = R.id.html_check_box;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.html_check_box);
                                if (checkBox != null) {
                                    i4 = R.id.subject;
                                    TextInputEditText textInputEditText3 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.subject);
                                    if (textInputEditText3 != null) {
                                        i4 = R.id.toAddress;
                                        TextInputEditText textInputEditText4 = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.toAddress);
                                        if (textInputEditText4 != null) {
                                            i4 = R.id.wait_to_complete_checkbox;
                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.wait_to_complete_checkbox);
                                            if (checkBox2 != null) {
                                                i4 = R.id.wait_to_complete_options;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wait_to_complete_options);
                                                if (linearLayout != null) {
                                                    return new SendEmailActionBinding((LinearLayout) view, button, textInputEditText, nDSpinner, button2, textInputEditText2, textInputLayout, checkBox, textInputEditText3, textInputEditText4, checkBox2, linearLayout);
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
    public static SendEmailActionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SendEmailActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.send_email_action, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11362a;
    }
}
