package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class BatteryConstraintDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f10987a;
    @NonNull
    public final CheckBox autoBrightnessCheckbox;
    @NonNull
    public final SeekBar batteryLevelSeekBar;
    @NonNull
    public final TextView batteryPercentLabel;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton equalsRadioButton;
    @NonNull
    public final RadioButton greaterThanRadioButton;
    @NonNull
    public final RadioButton lessThanRadioButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final CheckBox useAndroidPieCheckbox;
    @NonNull
    public final TextView useAndroidPieText;
    @NonNull
    public final LinearLayout valueContainer;

    private BatteryConstraintDialogBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull SeekBar seekBar, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull Button button2, @NonNull CheckBox checkBox2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f10987a = scrollView;
        this.autoBrightnessCheckbox = checkBox;
        this.batteryLevelSeekBar = seekBar;
        this.batteryPercentLabel = textView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.equalsRadioButton = radioButton;
        this.greaterThanRadioButton = radioButton2;
        this.lessThanRadioButton = radioButton3;
        this.okButton = button2;
        this.useAndroidPieCheckbox = checkBox2;
        this.useAndroidPieText = textView2;
        this.valueContainer = linearLayout2;
    }

    @NonNull
    public static BatteryConstraintDialogBinding bind(@NonNull View view) {
        int i4 = R.id.auto_brightness_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.auto_brightness_checkbox);
        if (checkBox != null) {
            i4 = R.id.batteryLevelSeekBar;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.batteryLevelSeekBar);
            if (seekBar != null) {
                i4 = R.id.batteryPercentLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.batteryPercentLabel);
                if (textView != null) {
                    i4 = R.id.button_bar;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                    if (linearLayout != null) {
                        i4 = R.id.cancelButton;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                        if (button != null) {
                            i4 = R.id.equalsRadioButton;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.equalsRadioButton);
                            if (radioButton != null) {
                                i4 = R.id.greaterThanRadioButton;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.greaterThanRadioButton);
                                if (radioButton2 != null) {
                                    i4 = R.id.lessThanRadioButton;
                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.lessThanRadioButton);
                                    if (radioButton3 != null) {
                                        i4 = R.id.okButton;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                        if (button2 != null) {
                                            i4 = R.id.use_android_pie_checkbox;
                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.use_android_pie_checkbox);
                                            if (checkBox2 != null) {
                                                i4 = R.id.use_android_pie_text;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.use_android_pie_text);
                                                if (textView2 != null) {
                                                    i4 = R.id.value_container;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.value_container);
                                                    if (linearLayout2 != null) {
                                                        return new BatteryConstraintDialogBinding((ScrollView) view, checkBox, seekBar, textView, linearLayout, button, radioButton, radioButton2, radioButton3, button2, checkBox2, textView2, linearLayout2);
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
    public static BatteryConstraintDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BatteryConstraintDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.battery_constraint_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f10987a;
    }
}
