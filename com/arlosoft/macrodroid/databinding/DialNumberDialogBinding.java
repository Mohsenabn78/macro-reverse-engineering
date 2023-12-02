package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialNumberDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11014a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton dialNumberDialogMakeCall;
    @NonNull
    public final AppCompatEditText dialNumberDialogPhoneNumber;
    @NonNull
    public final RadioButton dialNumberDialogStopCall;
    @NonNull
    public final Button okButton;

    private DialNumberDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull RadioButton radioButton2, @NonNull Button button2) {
        this.f11014a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.dialNumberDialogMakeCall = radioButton;
        this.dialNumberDialogPhoneNumber = appCompatEditText;
        this.dialNumberDialogStopCall = radioButton2;
        this.okButton = button2;
    }

    @NonNull
    public static DialNumberDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.dial_number_dialog_make_call;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dial_number_dialog_make_call);
                if (radioButton != null) {
                    i4 = R.id.dial_number_dialog_phone_number;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dial_number_dialog_phone_number);
                    if (appCompatEditText != null) {
                        i4 = R.id.dial_number_dialog_stop_call;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dial_number_dialog_stop_call);
                        if (radioButton2 != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                return new DialNumberDialogBinding((LinearLayout) view, linearLayout, button, radioButton, appCompatEditText, radioButton2, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialNumberDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialNumberDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dial_number_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11014a;
    }
}
