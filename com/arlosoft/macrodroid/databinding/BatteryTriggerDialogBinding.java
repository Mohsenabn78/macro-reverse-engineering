package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class BatteryTriggerDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10988a;
    @NonNull
    public final RadioButton batteryTriggerDialogDecreasesRb;
    @NonNull
    public final RadioButton batteryTriggerDialogIncreasesRb;
    @NonNull
    public final TextView batteryTriggerDialogPercentLabel;
    @NonNull
    public final SeekBar batteryTriggerDialogSeekBar;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;

    private BatteryTriggerDialogBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2) {
        this.f10988a = linearLayout;
        this.batteryTriggerDialogDecreasesRb = radioButton;
        this.batteryTriggerDialogIncreasesRb = radioButton2;
        this.batteryTriggerDialogPercentLabel = textView;
        this.batteryTriggerDialogSeekBar = seekBar;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
    }

    @NonNull
    public static BatteryTriggerDialogBinding bind(@NonNull View view) {
        int i4 = R.id.battery_trigger_dialog_decreases_rb;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.battery_trigger_dialog_decreases_rb);
        if (radioButton != null) {
            i4 = R.id.battery_trigger_dialog_increases_rb;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.battery_trigger_dialog_increases_rb);
            if (radioButton2 != null) {
                i4 = R.id.battery_trigger_dialog_percent_label;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.battery_trigger_dialog_percent_label);
                if (textView != null) {
                    i4 = R.id.battery_trigger_dialog_seek_bar;
                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.battery_trigger_dialog_seek_bar);
                    if (seekBar != null) {
                        i4 = R.id.button_bar;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                        if (linearLayout != null) {
                            i4 = R.id.cancelButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                            if (button != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    return new BatteryTriggerDialogBinding((LinearLayout) view, radioButton, radioButton2, textView, seekBar, linearLayout, button, button2);
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
    public static BatteryTriggerDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BatteryTriggerDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.battery_trigger_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10988a;
    }
}
