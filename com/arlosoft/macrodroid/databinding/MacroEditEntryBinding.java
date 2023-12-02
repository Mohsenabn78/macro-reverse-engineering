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
public final class MacroEditEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11322a;
    @NonNull
    public final MaterialCardView cardView;

    private MacroEditEntryBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2) {
        this.f11322a = materialCardView;
        this.cardView = materialCardView2;
    }

    @NonNull
    public static MacroEditEntryBinding bind(@NonNull View view) {
        if (view != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            return new MacroEditEntryBinding(materialCardView, materialCardView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MacroEditEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MacroEditEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.macro_edit_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11322a;
    }
}
