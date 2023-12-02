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
public final class ConfigurePebbleNotificationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11006a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button configurePebbleMagicSubjectButton;
    @NonNull
    public final Button configurePebbleMagicTextButton;
    @NonNull
    public final AppCompatEditText configurePebbleNotificationText;
    @NonNull
    public final AppCompatEditText configurePebbleSubjectText;
    @NonNull
    public final Button okButton;

    private ConfigurePebbleNotificationBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button4) {
        this.f11006a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configurePebbleMagicSubjectButton = button2;
        this.configurePebbleMagicTextButton = button3;
        this.configurePebbleNotificationText = appCompatEditText;
        this.configurePebbleSubjectText = appCompatEditText2;
        this.okButton = button4;
    }

    @NonNull
    public static ConfigurePebbleNotificationBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.configure_pebble_magic_subject_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configure_pebble_magic_subject_button);
                if (button2 != null) {
                    i4 = R.id.configure_pebble_magic_text_button;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.configure_pebble_magic_text_button);
                    if (button3 != null) {
                        i4 = R.id.configure_pebble_notification_text;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_pebble_notification_text);
                        if (appCompatEditText != null) {
                            i4 = R.id.configure_pebble_subject_text;
                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_pebble_subject_text);
                            if (appCompatEditText2 != null) {
                                i4 = R.id.okButton;
                                Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button4 != null) {
                                    return new ConfigurePebbleNotificationBinding((LinearLayout) view, linearLayout, button, button2, button3, appCompatEditText, appCompatEditText2, button4);
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
    public static ConfigurePebbleNotificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigurePebbleNotificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_pebble_notification, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11006a;
    }
}
