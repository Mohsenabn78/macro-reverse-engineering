package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityLocationTriggerActionBarSetLocationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10950a;

    private ActivityLocationTriggerActionBarSetLocationBinding(@NonNull RelativeLayout relativeLayout) {
        this.f10950a = relativeLayout;
    }

    @NonNull
    public static ActivityLocationTriggerActionBarSetLocationBinding bind(@NonNull View view) {
        if (view != null) {
            return new ActivityLocationTriggerActionBarSetLocationBinding((RelativeLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityLocationTriggerActionBarSetLocationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLocationTriggerActionBarSetLocationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_location_trigger_action_bar_set_location, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f10950a;
    }
}
