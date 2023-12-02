package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogConfigureLogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11038a;
    @NonNull
    public final TextView numLines;
    @NonNull
    public final SeekBar seekBar;
    @NonNull
    public final Button setColorButton;

    private DialogConfigureLogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SeekBar seekBar, @NonNull Button button) {
        this.f11038a = linearLayout;
        this.numLines = textView;
        this.seekBar = seekBar;
        this.setColorButton = button;
    }

    @NonNull
    public static DialogConfigureLogBinding bind(@NonNull View view) {
        int i4 = R.id.num_lines;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.num_lines);
        if (textView != null) {
            i4 = R.id.seek_bar;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar);
            if (seekBar != null) {
                i4 = R.id.set_color_button;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.set_color_button);
                if (button != null) {
                    return new DialogConfigureLogBinding((LinearLayout) view, textView, seekBar, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogConfigureLogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConfigureLogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_configure_log, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11038a;
    }
}
