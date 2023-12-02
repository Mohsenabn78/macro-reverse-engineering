package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityLocationTriggerV2Binding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10951a;
    @NonNull
    public final SeekBar activityLocationTriggerV2RadiusBar;
    @NonNull
    public final LinearLayout activityLocationTriggerV2RadiusContainer;
    @NonNull
    public final FloatingActionButton activityLocationTriggerV2SetLocationButton;

    private ActivityLocationTriggerV2Binding(@NonNull LinearLayout linearLayout, @NonNull SeekBar seekBar, @NonNull LinearLayout linearLayout2, @NonNull FloatingActionButton floatingActionButton) {
        this.f10951a = linearLayout;
        this.activityLocationTriggerV2RadiusBar = seekBar;
        this.activityLocationTriggerV2RadiusContainer = linearLayout2;
        this.activityLocationTriggerV2SetLocationButton = floatingActionButton;
    }

    @NonNull
    public static ActivityLocationTriggerV2Binding bind(@NonNull View view) {
        int i4 = R.id.activity_location_trigger_v2_radius_bar;
        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, R.id.activity_location_trigger_v2_radius_bar);
        if (seekBar != null) {
            i4 = R.id.activity_location_trigger_v2_radius_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.activity_location_trigger_v2_radius_container);
            if (linearLayout != null) {
                i4 = R.id.activity_location_trigger_v2_set_location_button;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.activity_location_trigger_v2_set_location_button);
                if (floatingActionButton != null) {
                    return new ActivityLocationTriggerV2Binding((LinearLayout) view, seekBar, linearLayout, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityLocationTriggerV2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLocationTriggerV2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_location_trigger_v2, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10951a;
    }
}
