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
public final class DialogMacrodroidNotificationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11093a;
    @NonNull
    public final AppCompatEditText notificationIconText;
    @NonNull
    public final TextInputLayout notificationIconTextInputLayout;
    @NonNull
    public final LinearLayout notificationIconTextLayout;
    @NonNull
    public final Button notificationIconTextMagicTextButton;

    private DialogMacrodroidNotificationBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button) {
        this.f11093a = linearLayout;
        this.notificationIconText = appCompatEditText;
        this.notificationIconTextInputLayout = textInputLayout;
        this.notificationIconTextLayout = linearLayout2;
        this.notificationIconTextMagicTextButton = button;
    }

    @NonNull
    public static DialogMacrodroidNotificationBinding bind(@NonNull View view) {
        int i4 = R.id.notification_icon_text;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.notification_icon_text);
        if (appCompatEditText != null) {
            i4 = R.id.notification_icon_text_input_layout;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.notification_icon_text_input_layout);
            if (textInputLayout != null) {
                i4 = R.id.notification_icon_text_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.notification_icon_text_layout);
                if (linearLayout != null) {
                    i4 = R.id.notification_icon_text_magic_text_button;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.notification_icon_text_magic_text_button);
                    if (button != null) {
                        return new DialogMacrodroidNotificationBinding((LinearLayout) view, appCompatEditText, textInputLayout, linearLayout, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogMacrodroidNotificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogMacrodroidNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_macrodroid_notification, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11093a;
    }
}
