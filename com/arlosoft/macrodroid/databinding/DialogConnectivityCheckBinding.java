package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogConnectivityCheckBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11041a;
    @NonNull
    public final Button addVariableButton;
    @NonNull
    public final CheckBox blockActionsCheckbox;
    @NonNull
    public final Spinner booleanVariableSpinner;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final AppCompatEditText timeoutMs;
    @NonNull
    public final TextInputLayout timeoutMsTextInput;
    @NonNull
    public final Button urlMagicTextButton;
    @NonNull
    public final AppCompatEditText urlText;

    private DialogConnectivityCheckBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull Spinner spinner, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull Button button4, @NonNull AppCompatEditText appCompatEditText2) {
        this.f11041a = linearLayout;
        this.addVariableButton = button;
        this.blockActionsCheckbox = checkBox;
        this.booleanVariableSpinner = spinner;
        this.buttonBar = linearLayout2;
        this.cancelButton = button2;
        this.okButton = button3;
        this.timeoutMs = appCompatEditText;
        this.timeoutMsTextInput = textInputLayout;
        this.urlMagicTextButton = button4;
        this.urlText = appCompatEditText2;
    }

    @NonNull
    public static DialogConnectivityCheckBinding bind(@NonNull View view) {
        int i4 = R.id.addVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addVariableButton);
        if (button != null) {
            i4 = R.id.blockActionsCheckbox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.blockActionsCheckbox);
            if (checkBox != null) {
                i4 = R.id.booleanVariableSpinner;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.booleanVariableSpinner);
                if (spinner != null) {
                    i4 = R.id.button_bar;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                    if (linearLayout != null) {
                        i4 = R.id.cancelButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                        if (button2 != null) {
                            i4 = R.id.okButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button3 != null) {
                                i4 = R.id.timeoutMs;
                                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.timeoutMs);
                                if (appCompatEditText != null) {
                                    i4 = R.id.timeoutMsTextInput;
                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.timeoutMsTextInput);
                                    if (textInputLayout != null) {
                                        i4 = R.id.urlMagicTextButton;
                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.urlMagicTextButton);
                                        if (button4 != null) {
                                            i4 = R.id.urlText;
                                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.urlText);
                                            if (appCompatEditText2 != null) {
                                                return new DialogConnectivityCheckBinding((LinearLayout) view, button, checkBox, spinner, linearLayout, button2, button3, appCompatEditText, textInputLayout, button4, appCompatEditText2);
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
    public static DialogConnectivityCheckBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConnectivityCheckBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_connectivity_check, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11041a;
    }
}
