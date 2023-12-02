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

/* loaded from: classes3.dex */
public final class DialogSmsNumberBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11131a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final AppCompatEditText smsNumber;

    private DialogSmsNumberBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText) {
        this.f11131a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.magicTextButton = button2;
        this.okButton = button3;
        this.smsNumber = appCompatEditText;
    }

    @NonNull
    public static DialogSmsNumberBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.magic_text_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                if (button2 != null) {
                    i4 = R.id.okButton;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button3 != null) {
                        i4 = R.id.sms_number;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.sms_number);
                        if (appCompatEditText != null) {
                            return new DialogSmsNumberBinding((LinearLayout) view, linearLayout, button, button2, button3, appCompatEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSmsNumberBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSmsNumberBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sms_number, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11131a;
    }
}
