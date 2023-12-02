package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogTorchBrightnessBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11146a;
    @NonNull
    public final NDSpinner optionSpinner;
    @NonNull
    public final TextView percentText;
    @NonNull
    public final SeekBar seekBar;
    @NonNull
    public final LinearLayout seekBarLayout;

    private DialogTorchBrightnessBinding(@NonNull LinearLayout linearLayout, @NonNull NDSpinner nDSpinner, @NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout2) {
        this.f11146a = linearLayout;
        this.optionSpinner = nDSpinner;
        this.percentText = textView;
        this.seekBar = seekBar;
        this.seekBarLayout = linearLayout2;
    }

    @NonNull
    public static DialogTorchBrightnessBinding bind(@NonNull View view) {
        int i4 = R.id.option_spinner;
        NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.option_spinner);
        if (nDSpinner != null) {
            i4 = R.id.percent_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.percent_text);
            if (textView != null) {
                i4 = R.id.seek_bar;
                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar);
                if (seekBar != null) {
                    i4 = R.id.seek_bar_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.seek_bar_layout);
                    if (linearLayout != null) {
                        return new DialogTorchBrightnessBinding((LinearLayout) view, nDSpinner, textView, seekBar, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogTorchBrightnessBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTorchBrightnessBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_torch_brightness, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11146a;
    }
}
