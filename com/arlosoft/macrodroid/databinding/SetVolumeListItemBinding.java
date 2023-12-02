package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
public final class SetVolumeListItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11364a;
    @NonNull
    public final CheckBox setVolumeListItemCheckbox;
    @NonNull
    public final NDSpinner setVolumeListItemSpinner;
    @NonNull
    public final SeekBar setVolumeSeekbar;
    @NonNull
    public final TextView setVolumeValue;

    private SetVolumeListItemBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull NDSpinner nDSpinner, @NonNull SeekBar seekBar, @NonNull TextView textView) {
        this.f11364a = linearLayout;
        this.setVolumeListItemCheckbox = checkBox;
        this.setVolumeListItemSpinner = nDSpinner;
        this.setVolumeSeekbar = seekBar;
        this.setVolumeValue = textView;
    }

    @NonNull
    public static SetVolumeListItemBinding bind(@NonNull View view) {
        int i4 = R.id.set_volume_list_item_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.set_volume_list_item_checkbox);
        if (checkBox != null) {
            i4 = R.id.set_volume_list_item_spinner;
            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.set_volume_list_item_spinner);
            if (nDSpinner != null) {
                i4 = R.id.set_volume_seekbar;
                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.set_volume_seekbar);
                if (seekBar != null) {
                    i4 = R.id.set_volume_value;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.set_volume_value);
                    if (textView != null) {
                        return new SetVolumeListItemBinding((LinearLayout) view, checkBox, nDSpinner, seekBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SetVolumeListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SetVolumeListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.set_volume_list_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11364a;
    }
}
