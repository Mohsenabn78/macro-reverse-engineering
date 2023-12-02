package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogAppLaunchedOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11025a;
    @NonNull
    public final RadioButton appClosedRadio;
    @NonNull
    public final RadioButton appLaunchedRadio;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox forceLegacySetting;
    @NonNull
    public final LinearLayout legacySettingsView;
    @NonNull
    public final Button okButton;
    @NonNull
    public final CheckBox preventNotificationInterrupt;
    @NonNull
    public final TextView preventNotificationInterruptDescription;

    private DialogAppLaunchedOptionsBinding(@NonNull ScrollView scrollView, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull CheckBox checkBox2, @NonNull TextView textView) {
        this.f11025a = scrollView;
        this.appClosedRadio = radioButton;
        this.appLaunchedRadio = radioButton2;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.forceLegacySetting = checkBox;
        this.legacySettingsView = linearLayout2;
        this.okButton = button2;
        this.preventNotificationInterrupt = checkBox2;
        this.preventNotificationInterruptDescription = textView;
    }

    @NonNull
    public static DialogAppLaunchedOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.app_closed_radio;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.app_closed_radio);
        if (radioButton != null) {
            i4 = R.id.app_launched_radio;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.app_launched_radio);
            if (radioButton2 != null) {
                i4 = R.id.button_bar;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                if (linearLayout != null) {
                    i4 = R.id.cancelButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                    if (button != null) {
                        i4 = R.id.force_legacy_setting;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.force_legacy_setting);
                        if (checkBox != null) {
                            i4 = R.id.legacy_settings_view;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.legacy_settings_view);
                            if (linearLayout2 != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    i4 = R.id.prevent_notification_interrupt;
                                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.prevent_notification_interrupt);
                                    if (checkBox2 != null) {
                                        i4 = R.id.prevent_notification_interrupt_description;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.prevent_notification_interrupt_description);
                                        if (textView != null) {
                                            return new DialogAppLaunchedOptionsBinding((ScrollView) view, radioButton, radioButton2, linearLayout, button, checkBox, linearLayout2, button2, checkBox2, textView);
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
    public static DialogAppLaunchedOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAppLaunchedOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_app_launched_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11025a;
    }
}
