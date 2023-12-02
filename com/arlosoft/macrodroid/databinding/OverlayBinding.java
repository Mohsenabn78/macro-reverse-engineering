package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.ExludeGestureFrameLayout;

/* loaded from: classes3.dex */
public final class OverlayBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ExludeGestureFrameLayout f11341a;
    @NonNull
    public final View touchArea;

    private OverlayBinding(@NonNull ExludeGestureFrameLayout exludeGestureFrameLayout, @NonNull View view) {
        this.f11341a = exludeGestureFrameLayout;
        this.touchArea = view;
    }

    @NonNull
    public static OverlayBinding bind(@NonNull View view) {
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.touch_area);
        if (findChildViewById != null) {
            return new OverlayBinding((ExludeGestureFrameLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.touch_area)));
    }

    @NonNull
    public static OverlayBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static OverlayBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.overlay, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ExludeGestureFrameLayout getRoot() {
        return this.f11341a;
    }
}
