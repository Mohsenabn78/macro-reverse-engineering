package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeSelectableItemHeaderBottomDividerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11265a;

    private IncludeSelectableItemHeaderBottomDividerBinding(@NonNull FrameLayout frameLayout) {
        this.f11265a = frameLayout;
    }

    @NonNull
    public static IncludeSelectableItemHeaderBottomDividerBinding bind(@NonNull View view) {
        if (view != null) {
            return new IncludeSelectableItemHeaderBottomDividerBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static IncludeSelectableItemHeaderBottomDividerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeSelectableItemHeaderBottomDividerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_selectable_item_header_bottom_divider, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11265a;
    }
}
