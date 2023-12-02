package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class CalibrateTouchDeviceBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10993a;
    @NonNull
    public final View buttonBorder;
    @NonNull
    public final TextView calibrateTouchDeviceInstructionText;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final View view1;

    private CalibrateTouchDeviceBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull TextView textView, @NonNull Button button, @NonNull View view2) {
        this.f10993a = relativeLayout;
        this.buttonBorder = view;
        this.calibrateTouchDeviceInstructionText = textView;
        this.cancelButton = button;
        this.view1 = view2;
    }

    @NonNull
    public static CalibrateTouchDeviceBinding bind(@NonNull View view) {
        int i4 = R.id.button_border;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.button_border);
        if (findChildViewById != null) {
            i4 = R.id.calibrate_touch_device_instruction_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.calibrate_touch_device_instruction_text);
            if (textView != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.view1;
                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.view1);
                    if (findChildViewById2 != null) {
                        return new CalibrateTouchDeviceBinding((RelativeLayout) view, findChildViewById, textView, button, findChildViewById2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CalibrateTouchDeviceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CalibrateTouchDeviceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.calibrate_touch_device, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f10993a;
    }
}
