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
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DimDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11171a;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final LinearLayout dimBarLayout;
    @NonNull
    public final RadioButton dimDialogOffRadioButton;
    @NonNull
    public final RadioButton dimDialogOnRadioButton;
    @NonNull
    public final SeekBar dimDialogSeekBar;
    @NonNull
    public final NDSpinner dimDialogSpinner;
    @NonNull
    public final LinearLayout dimDialogValuesLayout;
    @NonNull
    public final TextView dimPercentText;
    @NonNull
    public final Button okButton;

    private DimDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull LinearLayout linearLayout2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull SeekBar seekBar, @NonNull NDSpinner nDSpinner, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull Button button2) {
        this.f11171a = linearLayout;
        this.cancelButton = button;
        this.dimBarLayout = linearLayout2;
        this.dimDialogOffRadioButton = radioButton;
        this.dimDialogOnRadioButton = radioButton2;
        this.dimDialogSeekBar = seekBar;
        this.dimDialogSpinner = nDSpinner;
        this.dimDialogValuesLayout = linearLayout3;
        this.dimPercentText = textView;
        this.okButton = button2;
    }

    @NonNull
    public static DimDialogBinding bind(@NonNull View view) {
        int i4 = R.id.cancelButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
        if (button != null) {
            i4 = R.id.dim_bar_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dim_bar_layout);
            if (linearLayout != null) {
                i4 = R.id.dim_dialog_off_radio_button;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dim_dialog_off_radio_button);
                if (radioButton != null) {
                    i4 = R.id.dim_dialog_on_radio_button;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.dim_dialog_on_radio_button);
                    if (radioButton2 != null) {
                        i4 = R.id.dim_dialog_seek_bar;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.dim_dialog_seek_bar);
                        if (seekBar != null) {
                            i4 = R.id.dim_dialog_spinner;
                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dim_dialog_spinner);
                            if (nDSpinner != null) {
                                i4 = R.id.dim_dialog_values_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.dim_dialog_values_layout);
                                if (linearLayout2 != null) {
                                    i4 = R.id.dim_percent_text;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dim_percent_text);
                                    if (textView != null) {
                                        i4 = R.id.okButton;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                        if (button2 != null) {
                                            return new DimDialogBinding((LinearLayout) view, button, linearLayout, radioButton, radioButton2, seekBar, nDSpinner, linearLayout2, textView, button2);
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
    public static DimDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DimDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dim_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11171a;
    }
}
