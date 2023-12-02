package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WeatherTemperatureDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11423a;
    @NonNull
    public final RadioButton weatherDialogAboveRadioButton;
    @NonNull
    public final RadioButton weatherDialogBelowRadioButton;
    @NonNull
    public final RadioGroup weatherDialogRadioGroup;
    @NonNull
    public final Spinner weatherDialogTemperatureUnit;
    @NonNull
    public final AppCompatEditText weatherDialogTextValue;

    private WeatherTemperatureDialogBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup, @NonNull Spinner spinner, @NonNull AppCompatEditText appCompatEditText) {
        this.f11423a = linearLayout;
        this.weatherDialogAboveRadioButton = radioButton;
        this.weatherDialogBelowRadioButton = radioButton2;
        this.weatherDialogRadioGroup = radioGroup;
        this.weatherDialogTemperatureUnit = spinner;
        this.weatherDialogTextValue = appCompatEditText;
    }

    @NonNull
    public static WeatherTemperatureDialogBinding bind(@NonNull View view) {
        int i4 = R.id.weather_dialog_above_radio_button;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_dialog_above_radio_button);
        if (radioButton != null) {
            i4 = R.id.weather_dialog_below_radio_button;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_dialog_below_radio_button);
            if (radioButton2 != null) {
                i4 = R.id.weather_dialog_radio_group;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.weather_dialog_radio_group);
                if (radioGroup != null) {
                    i4 = R.id.weather_dialog_temperature_unit;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.weather_dialog_temperature_unit);
                    if (spinner != null) {
                        i4 = R.id.weather_dialog_text_value;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.weather_dialog_text_value);
                        if (appCompatEditText != null) {
                            return new WeatherTemperatureDialogBinding((LinearLayout) view, radioButton, radioButton2, radioGroup, spinner, appCompatEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static WeatherTemperatureDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WeatherTemperatureDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.weather_temperature_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11423a;
    }
}
