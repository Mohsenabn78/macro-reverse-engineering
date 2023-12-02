package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityConfigureZoneBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10936a;
    @NonNull
    public final View areaRadius;
    @NonNull
    public final SeekBar areaSeekBar;
    @NonNull
    public final LinearLayout configPanel;
    @NonNull
    public final View dividerLine;
    @NonNull
    public final TextView radiusValueText;
    @NonNull
    public final FloatingActionButton saveButton;
    @NonNull
    public final TextView searchBox;
    @NonNull
    public final AppCompatEditText zoneName;

    private ActivityConfigureZoneBinding(@NonNull FrameLayout frameLayout, @NonNull View view, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout, @NonNull View view2, @NonNull TextView textView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView2, @NonNull AppCompatEditText appCompatEditText) {
        this.f10936a = frameLayout;
        this.areaRadius = view;
        this.areaSeekBar = seekBar;
        this.configPanel = linearLayout;
        this.dividerLine = view2;
        this.radiusValueText = textView;
        this.saveButton = floatingActionButton;
        this.searchBox = textView2;
        this.zoneName = appCompatEditText;
    }

    @NonNull
    public static ActivityConfigureZoneBinding bind(@NonNull View view) {
        int i4 = R.id.area_radius;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.area_radius);
        if (findChildViewById != null) {
            i4 = R.id.area_seek_bar;
            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.area_seek_bar);
            if (seekBar != null) {
                i4 = R.id.config_panel;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.config_panel);
                if (linearLayout != null) {
                    i4 = R.id.divider_line;
                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.divider_line);
                    if (findChildViewById2 != null) {
                        i4 = R.id.radius_value_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.radius_value_text);
                        if (textView != null) {
                            i4 = R.id.save_button;
                            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.save_button);
                            if (floatingActionButton != null) {
                                i4 = R.id.search_box;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.search_box);
                                if (textView2 != null) {
                                    i4 = R.id.zone_name;
                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.zone_name);
                                    if (appCompatEditText != null) {
                                        return new ActivityConfigureZoneBinding((FrameLayout) view, findChildViewById, seekBar, linearLayout, findChildViewById2, textView, floatingActionButton, textView2, appCompatEditText);
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
    public static ActivityConfigureZoneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityConfigureZoneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_configure_zone, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10936a;
    }
}
