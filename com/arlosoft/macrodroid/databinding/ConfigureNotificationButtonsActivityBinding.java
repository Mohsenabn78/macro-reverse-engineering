package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ConfigureNotificationButtonsActivityBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11001a;
    @NonNull
    public final TextView android12Warning;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final SwitchCompat configureBlackBar;
    @NonNull
    public final FrameLayout configureNotificationButtonBar;
    @NonNull
    public final FrameLayout configureNotificationButtonControls;
    @NonNull
    public final CheckBox configureNotificationShowMacrodroidIcon;
    @NonNull
    public final CheckBox configureNotificationShowMode;
    @NonNull
    public final SwitchCompat configureNotificationSwitch;
    @NonNull
    public final ImageView iconTintButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final LinearLayout topContainer;
    @NonNull
    public final View viewBlocker;

    private ConfigureNotificationButtonsActivityBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull SwitchCompat switchCompat, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull SwitchCompat switchCompat2, @NonNull ImageView imageView, @NonNull Button button2, @NonNull LinearLayout linearLayout2, @NonNull View view) {
        this.f11001a = scrollView;
        this.android12Warning = textView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.configureBlackBar = switchCompat;
        this.configureNotificationButtonBar = frameLayout;
        this.configureNotificationButtonControls = frameLayout2;
        this.configureNotificationShowMacrodroidIcon = checkBox;
        this.configureNotificationShowMode = checkBox2;
        this.configureNotificationSwitch = switchCompat2;
        this.iconTintButton = imageView;
        this.okButton = button2;
        this.topContainer = linearLayout2;
        this.viewBlocker = view;
    }

    @NonNull
    public static ConfigureNotificationButtonsActivityBinding bind(@NonNull View view) {
        int i4 = R.id.android12Warning;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.android12Warning);
        if (textView != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.configure_black_bar;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.configure_black_bar);
                    if (switchCompat != null) {
                        i4 = R.id.configure_notification_button_bar;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.configure_notification_button_bar);
                        if (frameLayout != null) {
                            i4 = R.id.configure_notification_button_controls;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.configure_notification_button_controls);
                            if (frameLayout2 != null) {
                                i4 = R.id.configure_notification_show_macrodroid_icon;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.configure_notification_show_macrodroid_icon);
                                if (checkBox != null) {
                                    i4 = R.id.configure_notification_show_mode;
                                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.configure_notification_show_mode);
                                    if (checkBox2 != null) {
                                        i4 = R.id.configure_notification_Switch;
                                        SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.configure_notification_Switch);
                                        if (switchCompat2 != null) {
                                            i4 = R.id.icon_tint_button;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon_tint_button);
                                            if (imageView != null) {
                                                i4 = R.id.okButton;
                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                if (button2 != null) {
                                                    i4 = R.id.top_container;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.top_container);
                                                    if (linearLayout2 != null) {
                                                        i4 = R.id.view_blocker;
                                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.view_blocker);
                                                        if (findChildViewById != null) {
                                                            return new ConfigureNotificationButtonsActivityBinding((ScrollView) view, textView, linearLayout, button, switchCompat, frameLayout, frameLayout2, checkBox, checkBox2, switchCompat2, imageView, button2, linearLayout2, findChildViewById);
                                                        }
                                                    }
                                                }
                                            }
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
    public static ConfigureNotificationButtonsActivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureNotificationButtonsActivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_notification_buttons_activity, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11001a;
    }
}
