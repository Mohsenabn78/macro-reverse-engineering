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

/* loaded from: classes3.dex */
public final class DialogSeekBarBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11119a;
    @NonNull
    public final SeekBar seekBar;
    @NonNull
    public final TextView valueLabel;

    private DialogSeekBarBinding(@NonNull LinearLayout linearLayout, @NonNull SeekBar seekBar, @NonNull TextView textView) {
        this.f11119a = linearLayout;
        this.seekBar = seekBar;
        this.valueLabel = textView;
    }

    @NonNull
    public static DialogSeekBarBinding bind(@NonNull View view) {
        int i4 = R.id.seekBar;
        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.seekBar);
        if (seekBar != null) {
            i4 = R.id.valueLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.valueLabel);
            if (textView != null) {
                return new DialogSeekBarBinding((LinearLayout) view, seekBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSeekBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSeekBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_seek_bar, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11119a;
    }
}
