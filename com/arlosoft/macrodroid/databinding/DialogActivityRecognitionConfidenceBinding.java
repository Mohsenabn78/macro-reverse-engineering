package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class DialogActivityRecognitionConfidenceBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11019a;
    @NonNull
    public final TextView dialogActivityRecognitionConfidencePercentLabel;
    @NonNull
    public final SeekBar dialogActivityRecognitionConfidenceSeekBar;
    @NonNull
    public final RadioButton greaterThanRadioButton;
    @NonNull
    public final RadioButton lessThanRadioButton;

    private DialogActivityRecognitionConfidenceBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2) {
        this.f11019a = linearLayout;
        this.dialogActivityRecognitionConfidencePercentLabel = textView;
        this.dialogActivityRecognitionConfidenceSeekBar = seekBar;
        this.greaterThanRadioButton = radioButton;
        this.lessThanRadioButton = radioButton2;
    }

    @NonNull
    public static DialogActivityRecognitionConfidenceBinding bind(@NonNull View view) {
        int i4 = R.id.dialog_activity_recognition_confidence_percent_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_activity_recognition_confidence_percent_label);
        if (textView != null) {
            i4 = R.id.dialog_activity_recognition_confidence_seek_bar;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.dialog_activity_recognition_confidence_seek_bar);
            if (seekBar != null) {
                i4 = R.id.greater_than_radio_button;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.greater_than_radio_button);
                if (radioButton != null) {
                    i4 = R.id.less_than_radio_button;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.less_than_radio_button);
                    if (radioButton2 != null) {
                        return new DialogActivityRecognitionConfidenceBinding((LinearLayout) view, textView, seekBar, radioButton, radioButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogActivityRecognitionConfidenceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogActivityRecognitionConfidenceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_activity_recognition_confidence, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11019a;
    }
}
