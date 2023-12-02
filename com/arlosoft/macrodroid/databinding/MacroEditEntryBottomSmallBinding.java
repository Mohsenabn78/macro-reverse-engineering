package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class MacroEditEntryBottomSmallBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11324a;
    @NonNull
    public final MaterialCardView cardView;

    private MacroEditEntryBottomSmallBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2) {
        this.f11324a = materialCardView;
        this.cardView = materialCardView2;
    }

    @NonNull
    public static MacroEditEntryBottomSmallBinding bind(@NonNull View view) {
        if (view != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            return new MacroEditEntryBottomSmallBinding(materialCardView, materialCardView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MacroEditEntryBottomSmallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MacroEditEntryBottomSmallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.macro_edit_entry_bottom_small, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11324a;
    }
}
