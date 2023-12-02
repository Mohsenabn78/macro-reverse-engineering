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
public final class DialogMacrodroidNotificationTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11094a;
    @NonNull
    public final Button bodyMagicTextButton;
    @NonNull
    public final AppCompatEditText bodyText;
    @NonNull
    public final LinearLayout customLayout;
    @NonNull
    public final RadioButton customRadioButton;
    @NonNull
    public final RadioButton defaultRadioButton;
    @NonNull
    public final Button titleMagicTextButton;
    @NonNull
    public final AppCompatEditText titleText;

    private DialogMacrodroidNotificationTextBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText2) {
        this.f11094a = linearLayout;
        this.bodyMagicTextButton = button;
        this.bodyText = appCompatEditText;
        this.customLayout = linearLayout2;
        this.customRadioButton = radioButton;
        this.defaultRadioButton = radioButton2;
        this.titleMagicTextButton = button2;
        this.titleText = appCompatEditText2;
    }

    @NonNull
    public static DialogMacrodroidNotificationTextBinding bind(@NonNull View view) {
        int i4 = R.id.bodyMagicTextButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.bodyMagicTextButton);
        if (button != null) {
            i4 = R.id.bodyText;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.bodyText);
            if (appCompatEditText != null) {
                i4 = R.id.customLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.customLayout);
                if (linearLayout != null) {
                    i4 = R.id.customRadioButton;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.customRadioButton);
                    if (radioButton != null) {
                        i4 = R.id.defaultRadioButton;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.defaultRadioButton);
                        if (radioButton2 != null) {
                            i4 = R.id.titleMagicTextButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.titleMagicTextButton);
                            if (button2 != null) {
                                i4 = R.id.titleText;
                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.titleText);
                                if (appCompatEditText2 != null) {
                                    return new DialogMacrodroidNotificationTextBinding((LinearLayout) view, button, appCompatEditText, linearLayout, radioButton, radioButton2, button2, appCompatEditText2);
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
    public static DialogMacrodroidNotificationTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogMacrodroidNotificationTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_macrodroid_notification_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11094a;
    }
}
