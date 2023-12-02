package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class PasswordEntryDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11344a;
    @NonNull
    public final LinearLayout biometricsLayout;
    @NonNull
    public final SwitchCompat enableBiometricsSwitch;
    @NonNull
    public final TextView passwordDelayLabel;
    @NonNull
    public final Spinner passwordDelaySpinner;
    @NonNull
    public final AppCompatEditText passwordEntryDialogConfirm;
    @NonNull
    public final AppCompatEditText passwordEntryDialogPassword;
    @NonNull
    public final SwitchCompat passwordEntryDialogSwitch;
    @NonNull
    public final LinearLayout passwordEntryPasswordsLayout;
    @NonNull
    public final LinearLayout passwordEntrySwitchLayout;
    @NonNull
    public final TextView passwordWarningText;

    private PasswordEntryDialogBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull SwitchCompat switchCompat, @NonNull TextView textView, @NonNull Spinner spinner, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull SwitchCompat switchCompat2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2) {
        this.f11344a = scrollView;
        this.biometricsLayout = linearLayout;
        this.enableBiometricsSwitch = switchCompat;
        this.passwordDelayLabel = textView;
        this.passwordDelaySpinner = spinner;
        this.passwordEntryDialogConfirm = appCompatEditText;
        this.passwordEntryDialogPassword = appCompatEditText2;
        this.passwordEntryDialogSwitch = switchCompat2;
        this.passwordEntryPasswordsLayout = linearLayout2;
        this.passwordEntrySwitchLayout = linearLayout3;
        this.passwordWarningText = textView2;
    }

    @NonNull
    public static PasswordEntryDialogBinding bind(@NonNull View view) {
        int i4 = R.id.biometrics_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.biometrics_layout);
        if (linearLayout != null) {
            i4 = R.id.enable_biometrics_switch;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.enable_biometrics_switch);
            if (switchCompat != null) {
                i4 = R.id.passwordDelayLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.passwordDelayLabel);
                if (textView != null) {
                    i4 = R.id.passwordDelaySpinner;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.passwordDelaySpinner);
                    if (spinner != null) {
                        i4 = R.id.password_entry_dialog_confirm;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.password_entry_dialog_confirm);
                        if (appCompatEditText != null) {
                            i4 = R.id.password_entry_dialog_password;
                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.password_entry_dialog_password);
                            if (appCompatEditText2 != null) {
                                i4 = R.id.password_entry_dialog_switch;
                                SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.password_entry_dialog_switch);
                                if (switchCompat2 != null) {
                                    i4 = R.id.password_entry_passwords_layout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.password_entry_passwords_layout);
                                    if (linearLayout2 != null) {
                                        i4 = R.id.password_entry_switch_layout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.password_entry_switch_layout);
                                        if (linearLayout3 != null) {
                                            i4 = R.id.password_warning_text;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.password_warning_text);
                                            if (textView2 != null) {
                                                return new PasswordEntryDialogBinding((ScrollView) view, linearLayout, switchCompat, textView, spinner, appCompatEditText, appCompatEditText2, switchCompat2, linearLayout2, linearLayout3, textView2);
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
    public static PasswordEntryDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PasswordEntryDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.password_entry_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11344a;
    }
}
