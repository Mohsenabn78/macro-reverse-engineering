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
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class EditMacroConstraintHeaderItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11190a;
    @NonNull
    public final NDSpinner constraintAndOrSpinner;
    @NonNull
    public final LinearLayout constraintsLayout;
    @NonNull
    public final ImageButton editMacroAddConstraintButton;
    @NonNull
    public final ImageButton pasteConstraintButton;
    @NonNull
    public final ImageButton reorderConstraintsButton;

    private EditMacroConstraintHeaderItemBinding(@NonNull MaterialCardView materialCardView, @NonNull NDSpinner nDSpinner, @NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3) {
        this.f11190a = materialCardView;
        this.constraintAndOrSpinner = nDSpinner;
        this.constraintsLayout = linearLayout;
        this.editMacroAddConstraintButton = imageButton;
        this.pasteConstraintButton = imageButton2;
        this.reorderConstraintsButton = imageButton3;
    }

    @NonNull
    public static EditMacroConstraintHeaderItemBinding bind(@NonNull View view) {
        int i4 = R.id.constraintAndOrSpinner;
        NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.constraintAndOrSpinner);
        if (nDSpinner != null) {
            i4 = R.id.constraintsLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.constraintsLayout);
            if (linearLayout != null) {
                i4 = R.id.edit_macro_addConstraintButton;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.edit_macro_addConstraintButton);
                if (imageButton != null) {
                    i4 = R.id.pasteConstraintButton;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.pasteConstraintButton);
                    if (imageButton2 != null) {
                        i4 = R.id.reorderConstraintsButton;
                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.reorderConstraintsButton);
                        if (imageButton3 != null) {
                            return new EditMacroConstraintHeaderItemBinding((MaterialCardView) view, nDSpinner, linearLayout, imageButton, imageButton2, imageButton3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditMacroConstraintHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditMacroConstraintHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_macro_constraint_header_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11190a;
    }
}
