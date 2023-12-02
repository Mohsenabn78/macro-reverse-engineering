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
public final class EditMacroConstraintEmptyBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11189a;

    private EditMacroConstraintEmptyBinding(@NonNull MaterialCardView materialCardView) {
        this.f11189a = materialCardView;
    }

    @NonNull
    public static EditMacroConstraintEmptyBinding bind(@NonNull View view) {
        if (view != null) {
            return new EditMacroConstraintEmptyBinding((MaterialCardView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static EditMacroConstraintEmptyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditMacroConstraintEmptyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_macro_constraint_empty, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11189a;
    }
}
