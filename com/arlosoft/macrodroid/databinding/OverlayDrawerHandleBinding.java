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
public final class OverlayDrawerHandleBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ExludeGestureFrameLayout f11343a;
    @NonNull
    public final ExludeGestureFrameLayout drawerContainer;
    @NonNull
    public final View visibleHandle;

    private OverlayDrawerHandleBinding(@NonNull ExludeGestureFrameLayout exludeGestureFrameLayout, @NonNull ExludeGestureFrameLayout exludeGestureFrameLayout2, @NonNull View view) {
        this.f11343a = exludeGestureFrameLayout;
        this.drawerContainer = exludeGestureFrameLayout2;
        this.visibleHandle = view;
    }

    @NonNull
    public static OverlayDrawerHandleBinding bind(@NonNull View view) {
        ExludeGestureFrameLayout exludeGestureFrameLayout = (ExludeGestureFrameLayout) view;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.visible_handle);
        if (findChildViewById != null) {
            return new OverlayDrawerHandleBinding(exludeGestureFrameLayout, exludeGestureFrameLayout, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.visible_handle)));
    }

    @NonNull
    public static OverlayDrawerHandleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static OverlayDrawerHandleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.overlay_drawer_handle, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ExludeGestureFrameLayout getRoot() {
        return this.f11343a;
    }
}
