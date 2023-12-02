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
public final class DialogVolumeConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11161a;
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
    public final SeekBar levelSeekBar;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView percentLabel;

    private DialogVolumeConstraintBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull SeekBar seekBar, @NonNull Button button2, @NonNull TextView textView) {
        this.f11161a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.equalsRadioButton = radioButton;
        this.greaterThanRadioButton = radioButton2;
        this.lessThanRadioButton = radioButton3;
        this.levelSeekBar = seekBar;
        this.okButton = button2;
        this.percentLabel = textView;
    }

    @NonNull
    public static DialogVolumeConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
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
                            i4 = R.id.levelSeekBar;
                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.levelSeekBar);
                            if (seekBar != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    i4 = R.id.percentLabel;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.percentLabel);
                                    if (textView != null) {
                                        return new DialogVolumeConstraintBinding((LinearLayout) view, linearLayout, button, radioButton, radioButton2, radioButton3, seekBar, button2, textView);
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
    public static DialogVolumeConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogVolumeConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_volume_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11161a;
    }
}
