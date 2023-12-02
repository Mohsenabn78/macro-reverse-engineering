package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EnterBooleanValueDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11197a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton falseRadio;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton trueRadio;

    private EnterBooleanValueDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull Button button2, @NonNull RadioButton radioButton2) {
        this.f11197a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.falseRadio = radioButton;
        this.okButton = button2;
        this.trueRadio = radioButton2;
    }

    @NonNull
    public static EnterBooleanValueDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.falseRadio;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.falseRadio);
                if (radioButton != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        i4 = R.id.trueRadio;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.trueRadio);
                        if (radioButton2 != null) {
                            return new EnterBooleanValueDialogBinding((LinearLayout) view, linearLayout, button, radioButton, button2, radioButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EnterBooleanValueDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EnterBooleanValueDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.enter_boolean_value_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11197a;
    }
}
