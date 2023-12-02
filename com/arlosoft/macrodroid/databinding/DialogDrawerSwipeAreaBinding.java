package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogDrawerSwipeAreaBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11051a;
    @NonNull
    public final ImageView colorImage;
    @NonNull
    public final RadioButton left;
    @NonNull
    public final RadioButton right;
    @NonNull
    public final SeekBar seekBarHeight;
    @NonNull
    public final SeekBar seekBarOffset;
    @NonNull
    public final SeekBar seekBarOpacity;
    @NonNull
    public final SeekBar seekBarVisibleWidth;
    @NonNull
    public final SeekBar seekBarWidth;
    @NonNull
    public final RadioGroup swipeEnabledCheckbox;

    private DialogDrawerSwipeAreaBinding(@NonNull ScrollView scrollView, @NonNull ImageView imageView, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull SeekBar seekBar, @NonNull SeekBar seekBar2, @NonNull SeekBar seekBar3, @NonNull SeekBar seekBar4, @NonNull SeekBar seekBar5, @NonNull RadioGroup radioGroup) {
        this.f11051a = scrollView;
        this.colorImage = imageView;
        this.left = radioButton;
        this.right = radioButton2;
        this.seekBarHeight = seekBar;
        this.seekBarOffset = seekBar2;
        this.seekBarOpacity = seekBar3;
        this.seekBarVisibleWidth = seekBar4;
        this.seekBarWidth = seekBar5;
        this.swipeEnabledCheckbox = radioGroup;
    }

    @NonNull
    public static DialogDrawerSwipeAreaBinding bind(@NonNull View view) {
        int i4 = R.id.color_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.color_image);
        if (imageView != null) {
            i4 = R.id.left;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.left);
            if (radioButton != null) {
                i4 = R.id.right;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.right);
                if (radioButton2 != null) {
                    i4 = R.id.seek_bar_height;
                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar_height);
                    if (seekBar != null) {
                        i4 = R.id.seek_bar_offset;
                        SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar_offset);
                        if (seekBar2 != null) {
                            i4 = R.id.seek_bar_opacity;
                            SeekBar seekBar3 = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar_opacity);
                            if (seekBar3 != null) {
                                i4 = R.id.seek_bar_visible_width;
                                SeekBar seekBar4 = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar_visible_width);
                                if (seekBar4 != null) {
                                    i4 = R.id.seek_bar_width;
                                    SeekBar seekBar5 = (SeekBar) ViewBindings.findChildViewById(view, R.id.seek_bar_width);
                                    if (seekBar5 != null) {
                                        i4 = R.id.swipe_enabled_checkbox;
                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.swipe_enabled_checkbox);
                                        if (radioGroup != null) {
                                            return new DialogDrawerSwipeAreaBinding((ScrollView) view, imageView, radioButton, radioButton2, seekBar, seekBar2, seekBar3, seekBar4, seekBar5, radioGroup);
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
    public static DialogDrawerSwipeAreaBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDrawerSwipeAreaBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_drawer_swipe_area, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11051a;
    }
}
