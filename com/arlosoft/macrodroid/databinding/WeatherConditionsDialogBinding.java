package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WeatherConditionsDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11421a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioGroup radioGroup1;
    @NonNull
    public final RadioButton weatherConditionsDialogClear;
    @NonNull
    public final RadioButton weatherConditionsDialogCloudy;
    @NonNull
    public final RadioButton weatherConditionsDialogRain;
    @NonNull
    public final RadioButton weatherConditionsDialogSnow;
    @NonNull
    public final RadioButton weatherConditionsDialogThunder;

    private WeatherConditionsDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull RadioGroup radioGroup, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5) {
        this.f11421a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.radioGroup1 = radioGroup;
        this.weatherConditionsDialogClear = radioButton;
        this.weatherConditionsDialogCloudy = radioButton2;
        this.weatherConditionsDialogRain = radioButton3;
        this.weatherConditionsDialogSnow = radioButton4;
        this.weatherConditionsDialogThunder = radioButton5;
    }

    @NonNull
    public static WeatherConditionsDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.okButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button2 != null) {
                    i4 = R.id.radioGroup1;
                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.radioGroup1);
                    if (radioGroup != null) {
                        i4 = R.id.weather_conditions_dialog_clear;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_conditions_dialog_clear);
                        if (radioButton != null) {
                            i4 = R.id.weather_conditions_dialog_cloudy;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_conditions_dialog_cloudy);
                            if (radioButton2 != null) {
                                i4 = R.id.weather_conditions_dialog_rain;
                                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_conditions_dialog_rain);
                                if (radioButton3 != null) {
                                    i4 = R.id.weather_conditions_dialog_snow;
                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_conditions_dialog_snow);
                                    if (radioButton4 != null) {
                                        i4 = R.id.weather_conditions_dialog_thunder;
                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.weather_conditions_dialog_thunder);
                                        if (radioButton5 != null) {
                                            return new WeatherConditionsDialogBinding((LinearLayout) view, linearLayout, button, button2, radioGroup, radioButton, radioButton2, radioButton3, radioButton4, radioButton5);
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
    public static WeatherConditionsDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WeatherConditionsDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.weather_conditions_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11421a;
    }
}
