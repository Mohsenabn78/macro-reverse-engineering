package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class BlockTouchOverlayBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f10989a;
    @NonNull
    public final View dimmerView;

    private BlockTouchOverlayBinding(@NonNull View view, @NonNull View view2) {
        this.f10989a = view;
        this.dimmerView = view2;
    }

    @NonNull
    public static BlockTouchOverlayBinding bind(@NonNull View view) {
        if (view != null) {
            return new BlockTouchOverlayBinding(view, view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static BlockTouchOverlayBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f10989a;
    }

    @NonNull
    public static BlockTouchOverlayBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.block_touch_overlay, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
