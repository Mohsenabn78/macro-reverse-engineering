package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogFontScaleBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11070a;
    @NonNull
    public final LinearLayout barLayout;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView percentText;
    @NonNull
    public final SeekBar seekBar;
    @NonNull
    public final NDSpinner variablesSpinner;

    private DialogFontScaleBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull NDSpinner nDSpinner) {
        this.f11070a = scrollView;
        this.barLayout = linearLayout;
        this.cancelButton = button;
        this.okButton = button2;
        this.percentText = textView;
        this.seekBar = seekBar;
        this.variablesSpinner = nDSpinner;
    }

    @NonNull
    public static DialogFontScaleBinding bind(@NonNull View view) {
        int i4 = R.id.barLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.barLayout);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.okButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button2 != null) {
                    i4 = R.id.percentText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.percentText);
                    if (textView != null) {
                        i4 = R.id.seekBar;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.seekBar);
                        if (seekBar != null) {
                            i4 = R.id.variablesSpinner;
                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variablesSpinner);
                            if (nDSpinner != null) {
                                return new DialogFontScaleBinding((ScrollView) view, linearLayout, button, button2, textView, seekBar, nDSpinner);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogFontScaleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogFontScaleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_font_scale, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11070a;
    }
}
