package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public final class ConfigurePebbleTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11007a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton configurePebbleTextClearRadioButton;
    @NonNull
    public final Button configurePebbleTextMagicTextButton;
    @NonNull
    public final RadioButton configurePebbleTextSetRadioButton;
    @NonNull
    public final Spinner configurePebbleTextSpinnerDuration;
    @NonNull
    public final Spinner configurePebbleTextSpinnerSize;
    @NonNull
    public final AppCompatEditText configurePebbleTextText;
    @NonNull
    public final Button okButton;

    private ConfigurePebbleTextBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull Button button2, @NonNull RadioButton radioButton2, @NonNull Spinner spinner, @NonNull Spinner spinner2, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button3) {
        this.f11007a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configurePebbleTextClearRadioButton = radioButton;
        this.configurePebbleTextMagicTextButton = button2;
        this.configurePebbleTextSetRadioButton = radioButton2;
        this.configurePebbleTextSpinnerDuration = spinner;
        this.configurePebbleTextSpinnerSize = spinner2;
        this.configurePebbleTextText = appCompatEditText;
        this.okButton = button3;
    }

    @NonNull
    public static ConfigurePebbleTextBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.configure_pebble_text_clear_radio_button;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.configure_pebble_text_clear_radio_button);
                if (radioButton != null) {
                    i4 = R.id.configure_pebble_text_magic_text_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configure_pebble_text_magic_text_button);
                    if (button2 != null) {
                        i4 = R.id.configure_pebble_text_set_radio_button;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.configure_pebble_text_set_radio_button);
                        if (radioButton2 != null) {
                            i4 = R.id.configure_pebble_text_spinner_duration;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_pebble_text_spinner_duration);
                            if (spinner != null) {
                                i4 = R.id.configure_pebble_text_spinner_size;
                                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_pebble_text_spinner_size);
                                if (spinner2 != null) {
                                    i4 = R.id.configure_pebble_text_text;
                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_pebble_text_text);
                                    if (appCompatEditText != null) {
                                        i4 = R.id.okButton;
                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                        if (button3 != null) {
                                            return new ConfigurePebbleTextBinding((LinearLayout) view, linearLayout, button, radioButton, button2, radioButton2, spinner, spinner2, appCompatEditText, button3);
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
    public static ConfigurePebbleTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigurePebbleTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_pebble_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11007a;
    }
}
