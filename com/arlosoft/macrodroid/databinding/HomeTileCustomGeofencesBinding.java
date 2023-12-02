package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class HomeTileCustomGeofencesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11248a;

    private HomeTileCustomGeofencesBinding(@NonNull LinearLayout linearLayout) {
        this.f11248a = linearLayout;
    }

    @NonNull
    public static HomeTileCustomGeofencesBinding bind(@NonNull View view) {
        if (view != null) {
            return new HomeTileCustomGeofencesBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static HomeTileCustomGeofencesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static HomeTileCustomGeofencesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.home_tile_custom_geofences, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11248a;
    }
}
