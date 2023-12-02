package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WeatherHumidityDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11422a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton weatherDialogAboveRadioButton;
    @NonNull
    public final RadioButton weatherDialogBelowRadioButton;
    @NonNull
    public final TextView weatherDialogPercentageValue;
    @NonNull
    public final RadioGroup weatherDialogRadioGroup;
    @NonNull
    public final SeekBar weatherDialogValue;

    private WeatherHumidityDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull TextView textView, @NonNull RadioGroup radioGroup, @NonNull SeekBar seekBar) {
        this.f11422a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.weatherDialogAboveRadioButton = radioButton;
        this.weatherDialogBelowRadioButton = radioButton2;
        this.weatherDialogPercentageValue = textView;
        this.weatherDialogRadioGroup = radioGroup;
        this.weatherDialogValue = seekBar;
    }

    @NonNull
    public static WeatherHumidityDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.okButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button2 != null) {
                    i4 = R.id.weather_dialog_above_radio_button;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_dialog_above_radio_button);
                    if (radioButton != null) {
                        i4 = R.id.weather_dialog_below_radio_button;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_dialog_below_radio_button);
                        if (radioButton2 != null) {
                            i4 = R.id.weather_dialog_percentage_value;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.weather_dialog_percentage_value);
                            if (textView != null) {
                                i4 = R.id.weather_dialog_radio_group;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.weather_dialog_radio_group);
                                if (radioGroup != null) {
                                    i4 = R.id.weather_dialog_value;
                                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.weather_dialog_value);
                                    if (seekBar != null) {
                                        return new WeatherHumidityDialogBinding((LinearLayout) view, linearLayout, button, button2, radioButton, radioButton2, textView, radioGroup, seekBar);
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
    public static WeatherHumidityDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WeatherHumidityDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.weather_humidity_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11422a;
    }
}
