package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogLightSensorBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11087a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton dialogLightSensorDecreasesRb;
    @NonNull
    public final RadioButton dialogLightSensorIncreasesRb;
    @NonNull
    public final TextView lightLevel;
    @NonNull
    public final AppCompatEditText luxValue;
    @NonNull
    public final Button okButton;

    private DialogLightSensorBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2) {
        this.f11087a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.dialogLightSensorDecreasesRb = radioButton;
        this.dialogLightSensorIncreasesRb = radioButton2;
        this.lightLevel = textView;
        this.luxValue = appCompatEditText;
        this.okButton = button2;
    }

    @NonNull
    public static DialogLightSensorBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.dialog_light_sensor_decreases_rb;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dialog_light_sensor_decreases_rb);
                if (radioButton != null) {
                    i4 = R.id.dialog_light_sensor_increases_rb;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dialog_light_sensor_increases_rb);
                    if (radioButton2 != null) {
                        i4 = R.id.light_level;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.light_level);
                        if (textView != null) {
                            i4 = R.id.lux_value;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.lux_value);
                            if (appCompatEditText != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    return new DialogLightSensorBinding((ScrollView) view, linearLayout, button, radioButton, radioButton2, textView, appCompatEditText, button2);
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
    public static DialogLightSensorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogLightSensorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_light_sensor, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11087a;
    }
}
