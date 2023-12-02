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
public final class HotspotDevicesConstraintDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11252a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton hotspotDevicesConstraintDialogEquals;
    @NonNull
    public final RadioButton hotspotDevicesConstraintDialogGreaterThan;
    @NonNull
    public final RadioButton hotspotDevicesConstraintDialogLessThan;
    @NonNull
    public final SeekBar hotspotDevicesConstraintDialogSeekBar;
    @NonNull
    public final TextView hotspotDevicesConstraintDialogValue;
    @NonNull
    public final LinearLayout linearLayout1;
    @NonNull
    public final Button okButton;

    private HotspotDevicesConstraintDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull SeekBar seekBar, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull Button button2) {
        this.f11252a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.hotspotDevicesConstraintDialogEquals = radioButton;
        this.hotspotDevicesConstraintDialogGreaterThan = radioButton2;
        this.hotspotDevicesConstraintDialogLessThan = radioButton3;
        this.hotspotDevicesConstraintDialogSeekBar = seekBar;
        this.hotspotDevicesConstraintDialogValue = textView;
        this.linearLayout1 = linearLayout3;
        this.okButton = button2;
    }

    @NonNull
    public static HotspotDevicesConstraintDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.hotspot_devices_constraint_dialog_equals;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.hotspot_devices_constraint_dialog_equals);
                if (radioButton != null) {
                    i4 = R.id.hotspot_devices_constraint_dialog_greater_than;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.hotspot_devices_constraint_dialog_greater_than);
                    if (radioButton2 != null) {
                        i4 = R.id.hotspot_devices_constraint_dialog_less_than;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.hotspot_devices_constraint_dialog_less_than);
                        if (radioButton3 != null) {
                            i4 = R.id.hotspot_devices_constraint_dialog_seek_bar;
                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.hotspot_devices_constraint_dialog_seek_bar);
                            if (seekBar != null) {
                                i4 = R.id.hotspot_devices_constraint_dialog_value;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.hotspot_devices_constraint_dialog_value);
                                if (textView != null) {
                                    i4 = R.id.linearLayout1;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout1);
                                    if (linearLayout2 != null) {
                                        i4 = R.id.okButton;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                        if (button2 != null) {
                                            return new HotspotDevicesConstraintDialogBinding((LinearLayout) view, linearLayout, button, radioButton, radioButton2, radioButton3, seekBar, textView, linearLayout2, button2);
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
    public static HotspotDevicesConstraintDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static HotspotDevicesConstraintDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.hotspot_devices_constraint_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11252a;
    }
}
