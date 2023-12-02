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
public final class SelectIconTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11354a;
    @NonNull
    public final Button addUserIconButton;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final AppCompatEditText notificationIconText;
    @NonNull
    public final TextInputLayout notificationIconTextInputLayout;

    private SelectIconTextBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout) {
        this.f11354a = linearLayout;
        this.addUserIconButton = button;
        this.magicTextButton = button2;
        this.notificationIconText = appCompatEditText;
        this.notificationIconTextInputLayout = textInputLayout;
    }

    @NonNull
    public static SelectIconTextBinding bind(@NonNull View view) {
        int i4 = R.id.add_user_icon_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_user_icon_button);
        if (button != null) {
            i4 = R.id.magic_text_button;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
            if (button2 != null) {
                i4 = R.id.notification_icon_text;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.notification_icon_text);
                if (appCompatEditText != null) {
                    i4 = R.id.notification_icon_text_input_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.notification_icon_text_input_layout);
                    if (textInputLayout != null) {
                        return new SelectIconTextBinding((LinearLayout) view, button, button2, appCompatEditText, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectIconTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectIconTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_icon_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11354a;
    }
}
