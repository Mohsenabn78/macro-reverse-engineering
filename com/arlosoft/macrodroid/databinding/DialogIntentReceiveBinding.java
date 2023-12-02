package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogIntentReceiveBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11078a;
    @NonNull
    public final AppCompatEditText action;
    @NonNull
    public final Button addExtraButton;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox enableRegex;
    @NonNull
    public final LinearLayout extrasContainer;
    @NonNull
    public final Button okButton;

    private DialogIntentReceiveBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout3, @NonNull Button button3) {
        this.f11078a = linearLayout;
        this.action = appCompatEditText;
        this.addExtraButton = button;
        this.buttonBar = linearLayout2;
        this.cancelButton = button2;
        this.enableRegex = checkBox;
        this.extrasContainer = linearLayout3;
        this.okButton = button3;
    }

    @NonNull
    public static DialogIntentReceiveBinding bind(@NonNull View view) {
        int i4 = R.id.action;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.action);
        if (appCompatEditText != null) {
            i4 = R.id.add_extra_button;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_extra_button);
            if (button != null) {
                i4 = R.id.button_bar;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                if (linearLayout != null) {
                    i4 = R.id.cancelButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                    if (button2 != null) {
                        i4 = R.id.enable_regex;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enable_regex);
                        if (checkBox != null) {
                            i4 = R.id.extras_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.extras_container);
                            if (linearLayout2 != null) {
                                i4 = R.id.okButton;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button3 != null) {
                                    return new DialogIntentReceiveBinding((LinearLayout) view, appCompatEditText, button, linearLayout, button2, checkBox, linearLayout2, button3);
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
    public static DialogIntentReceiveBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogIntentReceiveBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_intent_receive, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11078a;
    }
}
