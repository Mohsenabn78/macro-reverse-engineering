package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class AndroidWearNotificationActionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10983a;
    @NonNull
    public final Button androidWearNotificationActionChangeIconButton;
    @NonNull
    public final RadioButton androidWearNotificationActionDisabledRadioButton;
    @NonNull
    public final RadioButton androidWearNotificationActionEnabledRadioButton;
    @NonNull
    public final ImageView androidWearNotificationActionIcon;
    @NonNull
    public final Spinner androidWearNotificationActionMacroSpinner;
    @NonNull
    public final AppCompatEditText androidWearNotificationActionTitle;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;

    private AndroidWearNotificationActionBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull ImageView imageView, @NonNull Spinner spinner, @NonNull AppCompatEditText appCompatEditText, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull Button button3) {
        this.f10983a = linearLayout;
        this.androidWearNotificationActionChangeIconButton = button;
        this.androidWearNotificationActionDisabledRadioButton = radioButton;
        this.androidWearNotificationActionEnabledRadioButton = radioButton2;
        this.androidWearNotificationActionIcon = imageView;
        this.androidWearNotificationActionMacroSpinner = spinner;
        this.androidWearNotificationActionTitle = appCompatEditText;
        this.buttonBar = linearLayout2;
        this.cancelButton = button2;
        this.okButton = button3;
    }

    @NonNull
    public static AndroidWearNotificationActionBinding bind(@NonNull View view) {
        int i4 = R.id.android_wear_notification_action_change_icon_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_change_icon_button);
        if (button != null) {
            i4 = R.id.android_wear_notification_action_disabled_radio_button;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_disabled_radio_button);
            if (radioButton != null) {
                i4 = R.id.android_wear_notification_action_enabled_radio_button;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_enabled_radio_button);
                if (radioButton2 != null) {
                    i4 = R.id.android_wear_notification_action_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_icon);
                    if (imageView != null) {
                        i4 = R.id.android_wear_notification_action_macro_spinner;
                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_macro_spinner);
                        if (spinner != null) {
                            i4 = R.id.android_wear_notification_action_title;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.android_wear_notification_action_title);
                            if (appCompatEditText != null) {
                                i4 = R.id.button_bar;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                                if (linearLayout != null) {
                                    i4 = R.id.cancelButton;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                                    if (button2 != null) {
                                        i4 = R.id.okButton;
                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                        if (button3 != null) {
                                            return new AndroidWearNotificationActionBinding((LinearLayout) view, button, radioButton, radioButton2, imageView, spinner, appCompatEditText, linearLayout, button2, button3);
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
    public static AndroidWearNotificationActionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AndroidWearNotificationActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.android_wear_notification_action, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10983a;
    }
}
