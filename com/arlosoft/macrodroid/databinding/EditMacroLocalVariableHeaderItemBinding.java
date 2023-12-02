package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class EditMacroLocalVariableHeaderItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11192a;
    @NonNull
    public final ImageButton addVariableButton;
    @NonNull
    public final LinearLayout localVarsLayout;

    private EditMacroLocalVariableHeaderItemBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout) {
        this.f11192a = materialCardView;
        this.addVariableButton = imageButton;
        this.localVarsLayout = linearLayout;
    }

    @NonNull
    public static EditMacroLocalVariableHeaderItemBinding bind(@NonNull View view) {
        int i4 = R.id.addVariableButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.addVariableButton);
        if (imageButton != null) {
            i4 = R.id.localVarsLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.localVarsLayout);
            if (linearLayout != null) {
                return new EditMacroLocalVariableHeaderItemBinding((MaterialCardView) view, imageButton, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditMacroLocalVariableHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditMacroLocalVariableHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_macro_local_variable_header_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11192a;
    }
}
