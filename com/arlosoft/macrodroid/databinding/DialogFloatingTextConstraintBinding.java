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
public final class DialogFloatingTextConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11068a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText identifier;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final RadioButton notShowingRadioButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton showingRadioButton;

    private DialogFloatingTextConstraintBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull Button button3, @NonNull RadioButton radioButton2) {
        this.f11068a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.identifier = appCompatEditText;
        this.magicTextButton = button2;
        this.notShowingRadioButton = radioButton;
        this.okButton = button3;
        this.showingRadioButton = radioButton2;
    }

    @NonNull
    public static DialogFloatingTextConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.identifier;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.identifier);
                if (appCompatEditText != null) {
                    i4 = R.id.magicTextButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                    if (button2 != null) {
                        i4 = R.id.notShowingRadioButton;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.notShowingRadioButton);
                        if (radioButton != null) {
                            i4 = R.id.okButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button3 != null) {
                                i4 = R.id.showingRadioButton;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.showingRadioButton);
                                if (radioButton2 != null) {
                                    return new DialogFloatingTextConstraintBinding((LinearLayout) view, linearLayout, button, appCompatEditText, button2, radioButton, button3, radioButton2);
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
    public static DialogFloatingTextConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogFloatingTextConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_floating_text_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11068a;
    }
}
