package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DimmerOverlayBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f11172a;
    @NonNull
    public final View dimmerView;

    private DimmerOverlayBinding(@NonNull View view, @NonNull View view2) {
        this.f11172a = view;
        this.dimmerView = view2;
    }

    @NonNull
    public static DimmerOverlayBinding bind(@NonNull View view) {
        if (view != null) {
            return new DimmerOverlayBinding(view, view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DimmerOverlayBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f11172a;
    }

    @NonNull
    public static DimmerOverlayBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dimmer_overlay, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
